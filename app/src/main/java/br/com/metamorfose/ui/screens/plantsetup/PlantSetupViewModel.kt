/**
 * File: PlantSetupViewModel.kt
 * Description: ViewModel responsável pela gestão das informações da planta do usuário.
 *
 * Responsabilidades:
 * - Gerencia as informações da planta do usuário.
 *
 * Author: Gabriel Souza Teixeira
 * Created on: 08-05-2025
 * Last modified: 08-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 * Example of Usage:
 * - Este ViewModel é usado na tela de configuração da Planta.
 * - Permite cadastrar e alterar as informações da planta digital do usuário.
 */

package br.com.metamorfose.ui.screens.plantsetup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.metamorfose.ui.state.auth.AuthScreenMode
import br.com.metamorfose.ui.state.auth.AuthState
import br.com.metamorfose.ui.state.auth.LoginState
import br.com.metamorfose.ui.state.auth.RegisterState
import br.com.metamorfose.ui.state.auth.ValidationState
import br.com.metamorfose.utils.validators.InputValidators.validateEmail
import br.com.metamorfose.utils.validators.InputValidators.validatePassword
import br.com.metamorfose.utils.validators.InputValidators.validatePhone
import br.com.metamorfose.utils.validators.InputValidators.validateUsername
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel responsável pelas configurações da planta do usuário
 * Este ViewModel possui as configurações da planta do usuário e fará seu gerenciamento
 */
class PlantSetupViewModel : ViewModel() {
    private var _plantName = "";

    private var _plantType = "";

    private var _plantColor = "";

    public fun getPlantName(): String {
        return this._plantName;
    }

    public fun getPlantType(): String {
        return this._plantType;
    }

    public fun getPlantColor(): String {
        return this._plantColor;
    }

    public fun setPlantName(plantName:String) {
        this._plantName = plantName
    }

    public fun setPlantType(plantType:String) {
        this._plantType = plantType
    }

    public fun setPlantColor(plantColor:String) {
        this._plantColor = plantColor
    }
}
