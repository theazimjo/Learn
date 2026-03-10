package abs.uits.learn.ui.navigation

import abs.uits.learn.ui.screens.MainScreen
import abs.uits.learn.ui.screens.explore.Explore
import abs.uits.learn.ui.screens.home.Home
import abs.uits.learn.ui.screens.login.Login
import abs.uits.learn.ui.screens.splash.Splash
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController, startDestination = "splash") {

        composable("splash") {
            Splash(modifier = Modifier, navController)
        }

        composable("login") {
            Login(modifier = Modifier, viewModel(), navController)
        }

        composable("main") {
            MainScreen(modifier = Modifier, viewModel(), navController)
        }
    }

}