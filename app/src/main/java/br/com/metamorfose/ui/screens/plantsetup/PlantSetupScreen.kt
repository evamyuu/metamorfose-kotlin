/**
 * File: PlantSetupScreen.kt
 * Description: Tela de configuração inicial de uma planta no app Metamorfose.
 *
 * Responsabilidades:
 * - Permite ao usuário dar um nome para sua planta
 * - Possibilita a seleção do tipo de planta
 * - Permite a escolha da cor do vaso
 * - Oferece opção para tirar uma foto da planta ou ignorar essa etapa
 * - Exibe um mascote personalizado representando a planta
 *
 * Author: [Seu Nome]
 * Created on: 05-05-2025
 * Last modified: 05-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

package br.com.metamorfose.ui.screens.plantsetup

import CustomTextField
import SelectField
import Separator
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.*
import br.com.metamorfose.R
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.ui.components.buttons.SecondButton
import br.com.metamorfose.ui.components.buttons.SocialLoginButton
import br.com.metamorfose.ui.components.buttons.ToggleButtonGroup
import br.com.metamorfose.ui.components.inputs.CheckboxWithText
import br.com.metamorfose.ui.components.inputs.PasswordTextField
import br.com.metamorfose.ui.components.ivy.IvyCharacter
import br.com.metamorfose.ui.components.ivy.PlantSetupIvyCharacter
import br.com.metamorfose.ui.components.layout.CardContainer
import br.com.metamorfose.ui.components.layout.GradientBackground
import br.com.metamorfose.ui.screens.auth.AuthViewModel
import br.com.metamorfose.ui.state.auth.AuthScreenMode

/**
 * Tela de configuração da Planta do usuário.
 *
 * @param viewModel ViewModel contendo a configuração da planta.
 * @param onNavigate Callback acionado após configurar a planta, ou ignorar a etapa.
 */
@Composable
fun PlantSetupScreen(
    viewModel: PlantSetupViewModel = viewModel(),
    onNavigate: () -> Unit = {}
//    navController: NavController,
//    modifier: Modifier = Modifier
) {
    GradientBackground {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Botão de voltar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WindowInsets.systemBars.asPaddingValues())
            ) {
                IconButton(
                    onClick = { /* Navegar para trás */ },
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Voltar",
                        tint = BlackLight
                    )
                }
            }

            // Conteúdo principal com Ivy e Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                PlantSetupIvyCharacter(
                    size = 300f
                )

                CardContainer(
                    modifier = Modifier.absoluteOffset(y = 100.dp)
                        .padding(top = 240.dp, bottom = 0.dp)
                        .height(600.dp)
                ) {
                    // Conteúdo do card
                    PlantSetupContent(viewModel)
                }
            }
        }
    }
}

/**
 * Conteúdo da aba de Login.
 *
 * Exibe os campos de e-mail, senha, lembrete e botões sociais.
 *
 * @param viewModel ViewModel que mantém o estado da tela de login.
 */
@Composable
private fun PlantSetupContent(viewModel: PlantSetupViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo do nome da planta
        CustomTextField(
            value = "",
            onValueChange = {},
            placeholder = "Nome da planta",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_plant),
                    contentDescription = "E-mail",
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Campo do tipo da planta
        val plantTypes = listOf("Tipo 1", "Tipo 2", "Tipo 3")
        var selectedPlantType by remember { mutableStateOf("") }

        SelectField(
            selectedOption = selectedPlantType,
            options = plantTypes,
            onOptionSelected = { selectedPlantType = it },
            placeholder = "Selecione a sua planta",
            leadingIcon = {
                 Image(
                     painter = painterResource(id = R.drawable.ic_potted_plant),
                     contentDescription = "Ícone de seleção",
                     modifier = Modifier.size(24.dp)
                 )
             },
            isError = false,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Campo da cor da planta
        val plantColors = listOf("Cor 1", "Cor 2", "Cor 3")
        var selectedPlantColor by remember { mutableStateOf("") }

        SelectField(
            selectedOption = selectedPlantColor,
            options = plantColors,
            onOptionSelected = { selectedPlantColor = it },
            placeholder = "Selecione uma cor",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_plant_color),
                    contentDescription = "Ícone de seleção",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = false,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Botão principal de login
        PrimaryButton(
            text = "TIRAR A PRIMEIRA FOTO DE SUA PLANTA",
            onClick = { /* REGISTRAR INFORMAÇÕES DA PLANTA E GERAR FOTO VIRTUAL */ },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Divisor "OU"
        Separator(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "OU",
            dividerColor = WhiteDark,
            textColor = GreyLight
        )

        // Botão "Ignorar por enquanto"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            SecondButton(
                text = "IGNORAR ESSA ETAPA POR ENQUANTO",
                onClick = { /* Passar para próxima tela */ },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantSetupScreenPreview() {
    PlantSetupScreen()
}