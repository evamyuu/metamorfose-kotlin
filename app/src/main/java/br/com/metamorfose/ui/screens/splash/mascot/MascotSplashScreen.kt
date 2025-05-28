/**
 * File: MascotSplashScreen.kt
 * Description: Segunda tela de splash que exibe a mascote Ivy do aplicativo Metamorfose.
 * Exibida após a BrandSplashScreen e antes da tela de autenticação.
 *
 * Responsabilidades:
 * - Exibir o personagem Ivy com uma animação simples.
 * - Criar uma experiência de transição visual agradável.
 * - Apresentar a mascote do aplicativo aos usuários.
 *
 * Author: Evelin Cordeiro
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
import br.com.metamorfose.ui.screens.splash.mascot.MascotSplashViewModel


/**
 * Tela de splash que exibe a mascote Ivy do Metamorfose.
 * Esta é a segunda tela de splash, exibida após o logo da marca.
 *
 * @param viewModel ViewModel que gerencia o timer da tela.
 * @param onNavigateToAuth Callback para navegar para a tela de autenticação.
 */
@Composable
fun MascotSplashScreen(
    viewModel: MascotSplashViewModel = viewModel(),
    onNavigateToAuth: () -> Unit = {}
) {
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(isLoading) {
        if (!isLoading) {
            onNavigateToAuth()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_300)),
        contentAlignment = Alignment.Center
    ) {
        // Logo da borboleta
        Image(
            painter = painterResource(id = R.drawable.launcher_foreground),
            contentDescription = "Metamorfose Butterfly Logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(horizontal = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MascotSplashScreenPreview() {
    MascotSplashScreen()
}