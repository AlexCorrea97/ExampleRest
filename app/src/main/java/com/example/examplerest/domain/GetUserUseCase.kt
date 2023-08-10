package com.example.examplerest.domain

import com.example.examplerest.data.dto.UserResponse
import com.example.examplerest.data.mapper.toUser
import com.example.examplerest.data.remote.Api
import com.example.examplerest.domain.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userApi: Api){
    val gson = Gson()
    suspend operator fun invoke(): Resource<User>{
        return try {
            val dataMap = userApi.sendGET<UserResponse>("/api")
            val data = mapToObject(dataMap, UserResponse::class.java)
            Resource.Success(
                data = data!!.toUser()
            )
        }
        catch (ex: Exception){
            Resource.Error(
                message = ex.message.toString()
            )
        }
    }
    inline fun <reified T> fromJson(json: String): T? {
        return gson.fromJson(json, object : TypeToken<T>() {}.type)
    }

    public fun <T> mapToObject(map: Map<String, Any?>?, type: Class<T>): T? {
        if (map == null) return null

        val json = gson.toJson(map)
        return gson.fromJson(json, type)
    }
}