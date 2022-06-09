package com.masterdev.navigationdrawer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.masterdev.navigationdrawer.ui.theme.NavigationDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationDrawerTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem("home", "Home", "Go to home screen", Icons.Default.Home),
                                MenuItem(
                                    "setting",
                                    "Setting",
                                    "Go to setting screen",
                                    Icons.Default.Settings
                                ),
                                MenuItem(
                                    "about-us",
                                    "About Us",
                                    "Go to about screen",
                                    Icons.Default.Call
                                )
                            ), onItemClick = {
                                Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_SHORT)
                                    .show()
                            }
                        )
                    }) {

                }
            }
        }
    }
}
