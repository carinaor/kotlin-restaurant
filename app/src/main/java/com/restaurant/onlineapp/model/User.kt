package com.restaurant.onlineapp.model
import com.google.gson.annotations.SerializedName

data class User(
        @SerializedName("name")
        val fullname: String,

        @SerializedName("username")
        val username: String,

        @SerializedName("active")
        val active: Boolean,

        @SerializedName("password")
        val password:String,

        @SerializedName("authentification")
        val isAuthentified: Boolean,

        @SerializedName("coupon_list")
        val ccoupons: List<Coupon>

)