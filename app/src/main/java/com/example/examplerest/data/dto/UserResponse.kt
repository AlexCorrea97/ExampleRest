package com.example.examplerest.data.dto

import com.google.gson.annotations.SerializedName

data class UserResponse(

    @SerializedName("results") var results: List<Results>,
    @SerializedName("info") var info: Info,

    )

data class Info(

    @SerializedName("seed") var seed: String? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("version") var version: String? = null,

    )

data class Results(

    @SerializedName("gender") var gender: String,
    @SerializedName("name") var name: Name,
    @SerializedName("location") var location: Location,
    @SerializedName("email") var email: String,
    @SerializedName("login") var login: Login,
    @SerializedName("dob") var dob: Dob,
    @SerializedName("registered") var registered: Registered? = Registered(),
    @SerializedName("phone") var phone: String,
    @SerializedName("cell") var cell: String,
    @SerializedName("id") var id: Id,
    @SerializedName("picture") var picture: Picture,
    @SerializedName("nat") var nat: String,

    )

data class Name(

    @SerializedName("title") var title: String,
    @SerializedName("first") var first: String,
    @SerializedName("last") var last: String,

    )

data class Street(

    @SerializedName("number") var number: Int,
    @SerializedName("name") var name: String,

    )

data class Coordinates(

    @SerializedName("latitude") var latitude: String? = null,
    @SerializedName("longitude") var longitude: String? = null,

    )

data class Timezone(

    @SerializedName("offset") var offset: String? = null,
    @SerializedName("description") var description: String? = null,

    )

data class Location(

    @SerializedName("street") var street: Street,
    @SerializedName("city") var city: String,
    @SerializedName("state") var state: String,
    @SerializedName("country") var country: String,
    @SerializedName("postcode") var postcode: Int,
    @SerializedName("coordinates") var coordinates: Coordinates? = Coordinates(),
    @SerializedName("timezone") var timezone: Timezone? = Timezone(),

    )

data class Login(

    @SerializedName("uuid") var uuid: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String,
    @SerializedName("salt") var salt: String? = null,
    @SerializedName("md5") var md5: String? = null,
    @SerializedName("sha1") var sha1: String? = null,
    @SerializedName("sha256") var sha256: String? = null,

    )

data class Dob(

    @SerializedName("date") var date: String,
    @SerializedName("age") var age: Int? = null,

    )

data class Registered(

    @SerializedName("date") var date: String? = null,
    @SerializedName("age") var age: Int? = null,

    )

data class Id(

    @SerializedName("name") var name: String? = null,
    @SerializedName("value") var value: String? = null,

    )

data class Picture(

    @SerializedName("large") var large: String,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,

    )