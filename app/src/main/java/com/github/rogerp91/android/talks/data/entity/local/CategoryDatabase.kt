package com.github.rogerp91.android.talks.data.entity.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by rpatino on oct/2019
 */
@Entity
@Parcelize
data class CategoryDatabase(
    @PrimaryKey
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String
) : Parcelable