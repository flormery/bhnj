package pe.edu.upeu.nagevacionjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upeu.nagevacion.ui.presentation.components.MyAppDrawer
import pe.edu.upeu.nagevacionjpc.ui.theme.NagevacionJPCTheme

import pe.edu.upeu.nagevacionjpc.ui.theme.ThemeType
import pe.edu.upeu.nagevacionjpc.ui.theme.darkGreenScheme
import pe.edu.upeu.nagevacionjpc.ui.theme.darkRedScheme
import pe.edu.upeu.nagevacionjpc.ui.theme.lightGreenScheme
import pe.edu.upeu.nagevacionjpc.ui.theme.lightRedScheme
import pe.edu.upeu.nagevacionjpc.ui.utils.conttexto
import pe.edu.upeu.nagevacionjpc.ui.utils.isNight



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeType= remember{ mutableStateOf(ThemeType.RED) }
            val darkThemex= isNight()
            val darkTheme = remember { mutableStateOf(darkThemex) }

            val colorScheme=when(themeType.value){
                ThemeType.RED->{if (darkTheme.value) darkRedScheme else
                    lightRedScheme}
                ThemeType.GREEN->{if (darkTheme.value) darkGreenScheme else
                    lightGreenScheme}
                else->{lightGreenScheme}
            }
            conttexto.CONTEXTO_APPX=this
            NagevacionJPCTheme(colorScheme = colorScheme) {
                MyAppDrawer(darkMode = darkTheme, themeType = themeType)
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
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
    NagevacionJPCTheme(colorScheme = lightGreenScheme) {
        Greeting("Android")
    }
}