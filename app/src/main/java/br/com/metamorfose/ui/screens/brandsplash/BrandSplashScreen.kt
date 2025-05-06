package br.com.metamorfose.ui.screens.brandsplash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.R
import br.com.metamorfose.ui.screens.brandsplash.BrandSplashViewModel
import kotlinx.coroutines.delay
import androidx.compose.ui.res.colorResource


@Composable
fun BrandSplashScreen(
    viewModel: BrandSplashViewModel = viewModel(),
    onNavigateToAuth: () -> Unit = {}
) {
    val isLoading by viewModel.isLoading.collectAsState()

    // Estado para controlar a animação
    var startAnimation by remember { mutableStateOf(false) }

    // Valor de escala animado
    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.5f,
        animationSpec = tween(durationMillis = 1000)
    )

    // Inicia a animação após a composição inicial
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    // Navega após o carregamento
    LaunchedEffect(isLoading) {
        if (!isLoading) {
            delay(500) // Pequeno atraso para garantir que a animação seja vista
            onNavigateToAuth()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_300)),
        contentAlignment = Alignment.Center
    ) {
        // Logo responsivo com animação de escala
        Image(
            painter = painterResource(id = R.drawable.ic_logo_butterfly),
            contentDescription = "Metamorfose Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.7f)  // Ocupa 70% da largura da tela
                .scale(scale)  // Aplica a animação de escala
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BrandSplashScreenPreview() {
    BrandSplashScreen()
}