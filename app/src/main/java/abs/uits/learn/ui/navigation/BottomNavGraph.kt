package abs.uits.learn.ui.navigation

import abs.uits.learn.ui.screens.explore.Explore
import abs.uits.learn.ui.screens.home.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") {
            Home(modifier = Modifier, viewModel())
        }
        composable("explore") {
            Explore(modifier = Modifier)
        }
    }
}