package com.rs.sharedelementtransition

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rs.sharedelementtransition.core.presentation.navigation.NavHelper
import com.rs.sharedelementtransition.core.presentation.navigation.NavHelper.SetupNavGraph
import com.rs.sharedelementtransition.ui.theme.SharedelementtransitionTheme

/**
 * Created by shankar
 * MainActivity used to initiate navigate between screen
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SharedelementtransitionTheme {
                val navController = rememberNavController()

                Surface {
                    SetupNavGraph(navController=navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SharedelementtransitionTheme {
        Greeting("Android")
    }
}