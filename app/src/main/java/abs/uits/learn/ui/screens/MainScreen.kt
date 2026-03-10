package abs.uits.learn.ui.screens

import abs.uits.learn.ui.navigation.BottomNavGraph
import abs.uits.learn.ui.navigation.NavGraph
import abs.uits.learn.ui.screens.home.HomeViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    rootNavController: NavHostController
) {

    var activeScreen by remember { mutableIntStateOf(1) }
    val bottomNavController = rememberNavController()

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar() {
                    NavigationBarItem(
                        selected =
                            activeScreen == 1,
                        onClick = {
                            bottomNavController.navigate("home")
                            activeScreen = 1
                        },
                        icon = {
                            Icon(
                                Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        },
                        label = {
                            Text("Home")
                        }
                    )
                    NavigationBarItem(
                        selected = activeScreen == 2,
                        onClick = {
                            bottomNavController.navigate("explore")

                            activeScreen = 2
                        },
                        icon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Explore"
                            )
                        },
                        label = {
                            Text("Explore")
                        }
                    )
                }
            }
        ) {
            Box(modifier.padding(it)) {
                BottomNavGraph(navController = bottomNavController)
            }
        }
    }

}