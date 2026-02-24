package abs.uits.learn.ui.screens.login

import abs.uits.learn.domain.model.UserInfo
import abs.uits.learn.domain.model.UserLogin
import abs.uits.learn.domain.network.RetrofitClient
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    suspend fun login(user: UserLogin): UserInfo {
        var user = RetrofitClient.Api.login(user)

        return user
    }

}