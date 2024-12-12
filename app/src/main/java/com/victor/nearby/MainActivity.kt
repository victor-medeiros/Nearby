package com.victor.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.victor.nearby.data.model.Market
import com.victor.nearby.ui.component.screen.HomeScreen
import com.victor.nearby.ui.component.screen.MarketDetailsScreen
import com.victor.nearby.ui.component.screen.SplashScreen
import com.victor.nearby.ui.component.screen.WelcomeScreen
import com.victor.nearby.ui.component.screen.route.Home
import com.victor.nearby.ui.component.screen.route.Splash
import com.victor.nearby.ui.component.screen.route.Welcome
import com.victor.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            modifier = Modifier.fillMaxSize(),
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            }
                        )
                    }

                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = { navController.navigate(Home) })
                    }

                    composable<Home> {
                        HomeScreen(onNavigateToMarketDetails = { navController.navigate(it) })
                    }

                    composable<Market> {
                        val market = it.toRoute<Market>()
                        MarketDetailsScreen(
                            market = market,
                            onNavigateBack = navController::navigateUp
                        )
                    }
                }
            }
        }
    }
}