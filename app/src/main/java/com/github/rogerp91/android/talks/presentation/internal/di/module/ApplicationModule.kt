package com.github.rogerp91.android.talks.presentation.internal.di.module

import android.app.Application
import androidx.room.Room
import com.github.rogerp91.android.talks.data.entity.remote.mapper.AddressRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.AttributesRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.CategoryRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.CityRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.CountryRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.DifferentialPricingRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.InstallmentsRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.PagingRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.ProductRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.ResultsRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.SellerAddressRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.SellerRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.ShippingRemoteDtoMapper
import com.github.rogerp91.android.talks.data.entity.remote.mapper.StateRemoteDtoMapper
import com.github.rogerp91.android.talks.presentation.viewmodel.presentation.ErrorPresentationModel
import com.github.rogerp91.android.talks.data.network.CategoryRestAPI
import com.github.rogerp91.android.talks.data.network.CategoryRestApiImpl
import com.github.rogerp91.android.talks.data.network.ProductsByKeyWordRestAPI
import com.github.rogerp91.android.talks.data.network.ProductsByKeyWordRestAPIImpl
import com.github.rogerp91.android.talks.data.network.api.CategoryAPI
import com.github.rogerp91.android.talks.data.network.api.ProductsByKwyWordAPI
import com.github.rogerp91.android.talks.data.repository.datasource.local.AppDatabase
import com.github.rogerp91.android.talks.data.repository.datasource.local.CategoryDao
import com.github.rogerp91.android.talks.data.repository.datasource.remote.CategoryDataStore
import com.github.rogerp91.android.talks.data.repository.datasource.remote.CategoryRemoteDataStore
import com.github.rogerp91.android.talks.data.repository.datasource.remote.GetProductsByKeyWordDataStore
import com.github.rogerp91.android.talks.data.repository.datasource.remote.GetProductsByKeyWordRemoteDataStore
import com.github.rogerp91.android.talks.data.repository.impl.CategoryRepositoryImpl
import com.github.rogerp91.android.talks.data.repository.impl.GetProductsByKeywordImpl
import com.github.rogerp91.android.talks.domain.repository.CategoryRepository
import com.github.rogerp91.android.talks.domain.repository.GetProductsByKeyword
import com.github.rogerp91.android.talks.presentation.model.mapper.ProductsModelMapper
import com.github.rogerp91.android.talks.presentation.model.mapper.SellerUiMapper
import com.github.rogerp91.android.talks.presentation.viewmodel.presentation.ListCategoryPresentation
import com.github.rogerp91.android.talks.data.entity.local.mapper.CategoryDatabaseDataMapper
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by rpatino on oct/2019
 */
@Module(includes = [AndroidInjectionModule::class])
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, AppDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        client.addNetworkInterceptor(interceptor)
        return client.build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    //region rest api
    @Provides
    @Singleton
    fun providesCategoryAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): CategoryAPI {
        val retrofit = Retrofit.Builder().baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
        return retrofit.create(CategoryAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesProductsByKeyWordAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): ProductsByKwyWordAPI {
        val retrofit = Retrofit.Builder().baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
        return retrofit.create(ProductsByKwyWordAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryRestApi(categoryRestApiImpl: CategoryRestApiImpl): CategoryRestAPI {
        return categoryRestApiImpl
    }

    @Provides
    @Singleton
    fun provideProductsByKeyWordRestApi(productsByKeyWordRestAPIImpl: ProductsByKeyWordRestAPIImpl)
        : ProductsByKeyWordRestAPI {
        return productsByKeyWordRestAPIImpl
    }

    @Provides
    fun providesCategoryDAO(appDataBase: AppDatabase): CategoryDao {
        return appDataBase.categoryDAO()
    }

    @Provides
    @Singleton
    fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository {
        return categoryRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideProductsByKeyWordRepository(getProductsByKeywordImpl: GetProductsByKeywordImpl): GetProductsByKeyword {
        return getProductsByKeywordImpl
    }

    @Provides
    @Singleton
    fun providesCategoryDataStore(categoryRestAPI: CategoryRestAPI): CategoryDataStore {
        return CategoryRemoteDataStore(categoryRestAPI)
    }

    @Provides
    @Singleton
    fun providesProductsByKeyWordDataStore(productsByKeyWordRestAPI: ProductsByKeyWordRestAPI): GetProductsByKeyWordDataStore {
        return GetProductsByKeyWordRemoteDataStore(productsByKeyWordRestAPI)
    }

    //region mapper
    @Provides
    @Singleton
    fun providesCategoryRemoteDtoMapper(): CategoryRemoteDtoMapper {
        return CategoryRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesCategoryDatabaseMapper(): CategoryDatabaseDataMapper {
        return CategoryDatabaseDataMapper()
    }

    @Provides
    @Singleton
    fun providesAddressRemoteDtoMapper(): AddressRemoteDtoMapper {
        return AddressRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesAttributesRemoteDtoMapper(): AttributesRemoteDtoMapper {
        return AttributesRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesCityRemoteDtoMapper(): CityRemoteDtoMapper {
        return CityRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesCountryRemoteDtoMapper(): CountryRemoteDtoMapper {
        return CountryRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesDifferentialPricingRemoteDtoMapper(): DifferentialPricingRemoteDtoMapper {
        return DifferentialPricingRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesInstallmentsRemoteDtoMapper(): InstallmentsRemoteDtoMapper {
        return InstallmentsRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesSellerRemoteDtoMapper(): SellerRemoteDtoMapper {
        return SellerRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesShippingRemoteDtoMapper(): ShippingRemoteDtoMapper {
        return ShippingRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesStateRemoteDtoMapper(): StateRemoteDtoMapper {
        return StateRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesProductRemoteDtoMapper(
        pagingMapper: PagingRemoteDtoMapper,
        resultsMapper: ResultsRemoteDtoMapper
    ): ProductRemoteDtoMapper {
        return ProductRemoteDtoMapper(
            pagingMapper, resultsMapper
        )
    }

    @Provides
    @Singleton
    fun providesSellerAddressRemoteDtoMapper(
        countryRemoteDtoMapper: CountryRemoteDtoMapper,
        stateRemoteDtoMapper: StateRemoteDtoMapper,
        cityRemoteDtoMapper: CityRemoteDtoMapper
    ): SellerAddressRemoteDtoMapper {
        return SellerAddressRemoteDtoMapper(
            countryRemoteDtoMapper, stateRemoteDtoMapper,
            cityRemoteDtoMapper
        )
    }

    @Provides
    @Singleton
    fun providesSellerUiMapper(): SellerUiMapper {
        return SellerUiMapper()
    }

    @Provides
    @Singleton
    fun providesProductsUiMapper(sellerUiMapper: SellerUiMapper): ProductsModelMapper {
        return ProductsModelMapper(sellerUiMapper)
    }

    @Provides
    @Singleton
    fun providesPagingDataMapper(): PagingRemoteDtoMapper {
        return PagingRemoteDtoMapper()
    }

    @Provides
    @Singleton
    fun providesResultsMapper(
        sellerRemoteDtoMapper: SellerRemoteDtoMapper,
        installmentsRemoteDtoMapper: InstallmentsRemoteDtoMapper,
        addressRemoteDtoMapper: AddressRemoteDtoMapper,
        shippingRemoteDtoMapper: ShippingRemoteDtoMapper,
        sellerAddressRemoteDtoMapper: SellerAddressRemoteDtoMapper,
        attributesRemoteDtoMapper: AttributesRemoteDtoMapper,
        differentialPricingRemoteDtoMapper: DifferentialPricingRemoteDtoMapper
    ): ResultsRemoteDtoMapper {
        return ResultsRemoteDtoMapper(
            sellerRemoteDtoMapper,
            installmentsRemoteDtoMapper,
            addressRemoteDtoMapper,
            shippingRemoteDtoMapper,
            sellerAddressRemoteDtoMapper,
            attributesRemoteDtoMapper,
            differentialPricingRemoteDtoMapper
        )
    }

    @Provides
    @Singleton
    fun provideErrorPresentation(): ErrorPresentationModel {
        return ErrorPresentationModel()
    }

    @Provides
    @Singleton
    fun provideCategoryPresentation(): ListCategoryPresentation {
        return ListCategoryPresentation()
    }
}
