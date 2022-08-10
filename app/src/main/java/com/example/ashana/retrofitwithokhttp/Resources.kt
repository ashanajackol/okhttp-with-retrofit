package com.example.ashana.retrofitwithokhttp
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("last_name")
    val lastName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("email")
    val email: String = ""
)

data class Support(
    @SerializedName("url")
    val url: String = "",
    @SerializedName("text")
    val text: String = ""
)

data class Resources(
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("data")
    val data: List<DataItem>?,
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("support")
    val support: Support
)


