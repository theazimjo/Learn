package abs.uits.learn.domain.model

data class UserLogin(
    var username: String,
    var password: String,
    var expiresInMins: Int
)

data class UserInfo(
    val accessToken: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val refreshToken: String,
    val username: String
)