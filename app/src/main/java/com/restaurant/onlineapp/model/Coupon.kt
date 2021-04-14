package com.restaurant.onlineapp.model
import com.google.gson.annotations.SerializedName
import java.text.DateFormat

data class Coupon(
        @SerializedName("name")
        val title: String,
        @SerializedName("moneyValue")
        val moneyValue: Double,
        @SerializedName("isValid")
        val isValid: Boolean,
        @SerializedName("datetime")
        val dateCreation: String
)