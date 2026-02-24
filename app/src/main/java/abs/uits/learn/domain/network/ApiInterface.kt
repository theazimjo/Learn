package abs.uits.learn.domain.network

import abs.uits.learn.domain.model.UserInfo
import abs.uits.learn.domain.model.UserLogin
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("auth/login")
    suspend fun login(@Body user: UserLogin): UserInfo
}