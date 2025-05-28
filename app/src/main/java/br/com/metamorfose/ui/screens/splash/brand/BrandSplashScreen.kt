/**
 * File: BrandSplashScreen.kt
 * Description: Tela de splash inicial que exibe o logo da marca Metamorfose. Primeira tela exibida ao iniciar o aplicativo.
 *
 * Responsabilidades:
 * - Exibir a identidade visual da marca Metamorfose por um tempo determinado.
 * - Fornecer uma transição suave para a próxima tela de splash.
 * - Criar uma experiência de carregamento inicial agradável ao usuário.
 *
 * Author: Vitoria Lana
 * Created on: 05-05-2025
 * Last modified: 05-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.R
import br.com.metamorfose.ui.screens.splash.brand.BrandSplashViewModel


/**
 * Tela de splash inicial que exibe o logo da marca Metamorfose.
 * Esta é a primeira tela que o usuário vê ao iniciar o aplicativo.
 *
 * @param viewModel ViewModel que gerencia o timer da tela.
 * @param onNavigateToMascotSplash Callback para navegar para a próxima tela de splash.
 */
@Composable
fun BrandSplashScreen(
    viewModel: BrandSplashViewModel = viewModel(),
    onNavigateToMascotSplash: () -> Unit = {}
) {
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(isLoading) {
        if (!isLoading) {
            onNavigateToMascotSplash()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_300)),
        contentAlignment = Alignment.Center
    ) {
        // Logo da marca
        Image(
            painter = painterResource(id = R.drawable.logo_butterfly),
            contentDescription = "Metamorfose Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BrandSplashScreenPreview() {
    BrandSplashScreen()
}