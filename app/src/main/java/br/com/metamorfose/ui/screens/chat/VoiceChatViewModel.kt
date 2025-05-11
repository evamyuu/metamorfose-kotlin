/*
* File: VoiceChatViewMode.kt
* Description: Responsável pela gestão do voice chat.
*
* Responsabilidades:
* * Gerencia o estado da tela de chat
* * Processa eventos de UI e atualiza o estado
* * Mantém informações do personagem e do usuário
*
* Author: Ester Silva
* Created on: 10-05-2025
* Last modified: 10-05-2025
* Version: 2.0.0
* Squad: Metamorfose
*
*/

package br.com.metamorfose.ui.screens.chat

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Estado da UI para a tela de chat
 */
data class ChatUiState(
    // Nome do usuário
    val userName: String = "",
    // Nome do personagem de planta
    val characterName: String = "",
    // Cor principal do personagem
    val characterColor: Color = Color.Unspecified,
    // Indica se está gravando áudio
    val isRecording: Boolean = false
)

/**
 * ViewModel para a tela de chat
 */
class ChatViewModel : ViewModel() {

    // Estado da UI
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState.asStateFlow()

    /**
     * Inicializa o ViewModel com dados do usuário e do personagem
     */
    fun initialize(userName: String, characterName: String, characterColor: Color) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                userName = userName,
                characterName = characterName,
                characterColor = characterColor
            )
        }
    }

    /**
     * Alterna o estado de gravação de áudio
     */
    fun toggleRecording() {
        _uiState.value = _uiState.value.copy(
            isRecording = !_uiState.value.isRecording
        )
    }

    /**
     * Inicia uma nova conversa
     */
    fun startNewConversation() {
        // Lógica para iniciar uma nova conversa seria implementada aqui
    }

    /**
     * Finaliza a sessão atual e retorna à tela anterior
     */
    fun exitChat() {
        // Lógica para sair do chat seria implementada aqui
    }
}
