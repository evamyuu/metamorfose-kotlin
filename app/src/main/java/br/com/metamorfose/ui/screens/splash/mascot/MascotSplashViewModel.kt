/**
 * File: MascotSplashViewModel.kt
 * Description: ViewModel responsável por controlar o tempo de exibição da tela de splash da mascote.
 *
 * Responsabilidades:
 * - Gerenciar o estado de carregamento da tela de splash da mascote.
 * - Controlar o tempo de exibição (2 segundos) antes de navegar para a tela de autenticação.
 * - Emitir um StateFlow para informar quando a tela deve avançar para a próxima etapa.
 *
 * Author: Vitoria Lana
 * Created on: 05-05-2025
 * Last modified: 05-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.screens.splash.mascot
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MascotSplashViewModel : ViewModel() {

    // Indica se a animação da splash screen terminou
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        // Inicia um coroutine que atrasa por 2 segundos e depois atualiza o estado
        viewModelScope.launch {
            delay(2000) // 2 segundos de exibição
            _isLoading.value = false // Alterando o valor para falso após o delay
        }
    }
}
