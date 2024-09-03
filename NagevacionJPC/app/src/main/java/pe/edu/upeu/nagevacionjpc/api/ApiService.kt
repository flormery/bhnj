package pe.edu.upeu.nagevacionjpc.api

import pe.edu.upeu.nagevacionjpc.modelo.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
        @GET("users")
        fun getUsers(): Call<List<User>>

}