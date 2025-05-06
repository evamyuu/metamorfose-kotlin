package br.com.metamorfose.ui.screens.brandsplash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BrandSplashViewModel : ViewModel() {

    // Indica se a animação da splash screen terminou
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        // Inicia um coroutine que atrasa por 2 segundos e depois atualiza o estado
        viewModelScope.launch {
            delay(3000) // 2 segundos de exibição
            _isLoading.value = false // Alterando o valor para falso após o delay
        }
    }
}