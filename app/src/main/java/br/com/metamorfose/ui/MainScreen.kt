package br.com.metamorfose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.metamorfose.ui.components.BottomNavigationBar
import br.com.metamorfose.ui.components.CharacterSection
import br.com.metamorfose.ui.components.ConversationText

@Composable
fun MainScreen(peronaName: String, userName: String) {
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            CharacterSection(peronaName)
            ConversationText(userName)
            BottomNavigationBar()
        }
    }
}
