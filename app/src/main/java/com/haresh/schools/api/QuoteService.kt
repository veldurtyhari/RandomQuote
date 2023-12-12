package com.haresh.schools.api

import com.haresh.schools.models.School
import retrofit2.http.GET

interface QuoteService {

    @GET("f9bf-2cp4.json")
    suspend fun getSchools() : List<School>

}