package br.com.metamorfose.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.R
import br.com.metamorfose.ui.theme.LightPurple33Gradient

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
    onNavigateToAuth: () -> Unit = {}
) {
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(isLoading) {
        if (!isLoading) {
            onNavigateToAuth()
        }
    }

    // Obtém a largura da tela atual
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_300)),
        contentAlignment = Alignment.Center
    ) {
        // Logo responsivo - ocupa 60% da largura da tela
        Image(
            painter = painterResource(id = R.drawable.ic_logo_butterfly),
            contentDescription = "Metamorfose Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.9f)  // Ocupa 60% da largura da tela
                .padding(horizontal = 16.dp)  // Margem lateral de segurança
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}