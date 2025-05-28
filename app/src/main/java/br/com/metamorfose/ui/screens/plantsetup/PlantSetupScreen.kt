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
 * Author: Gabriel Souza Teixeira
 * Created on: 05-05-2025
 * Last modified: 23-05-2025
 * Version: 1.2.0
 * Squad: Metamorfose
 *
 *  Changelog:
 *
 *  - [23-05-2025] Ajustado fontSize de acordo com o Figma (por Eve)
 *  - [27-05-2025] Ajustado espaçamento de acordo com o Figma (por Vinicyus)
 *
 */

package br.com.metamorfose.ui.screens.plantsetup

import CustomTextField
import SelectField
import Separator
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.*
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.SecondButton
import br.com.metamorfose.ui.components.ivy.PlantSetupIvyCharacter
import br.com.metamorfose.ui.components.layout.CardContainer
import br.com.metamorfose.ui.components.layout.GradientBackground

/**
 * Tela de configuração da Planta do usuário.
 *
 * @param viewModel ViewModel contendo a configuração da planta.
 * @param onNavigateToMain Callback acionado para navegar para a tela principal.
 * @param onNavigateBack Callback acionado para voltar à tela anterior.
 */
@Composable
fun PlantSetupScreen(
    viewModel: PlantSetupViewModel = viewModel(),
    onNavigateToMain: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
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
                    onClick = onNavigateBack,
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
                    modifier = Modifier
                        .absoluteOffset(y = 100.dp)
                        .padding(top = 240.dp, bottom = 0.dp)
                        .height(600.dp)
                ) {
                    // Conteúdo do card
                    PlantSetupContent(
                        viewModel = viewModel,
                        onSkipSetup = onNavigateToMain
                    )
                }
            }
        }
    }
}

/**
 * Conteúdo da aba de configuração da planta.
 *
 * Exibe os campos de nome, tipo e cor da planta.
 *
 * @param viewModel ViewModel que mantém o estado da tela de configuração da planta.
 * @param onSkipSetup Callback acionado quando o usuário clica no botão para ignorar a configuração.
 */
@Composable
private fun PlantSetupContent(
    viewModel: PlantSetupViewModel,
    onSkipSetup: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campo do nome da planta
        var plantName by remember { mutableStateOf(viewModel.getPlantName()) }

        CustomTextField(
            value = plantName,
            onValueChange = {
                plantName = it
                viewModel.setPlantName(it)
            },
            placeholder = "Nome da planta",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_plant),
                    contentDescription = "Planta",
                    modifier = Modifier.size(24.dp)
                )
            },
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Campo do tipo da planta
        val plantTypes = listOf("Tipo 1", "Tipo 2", "Tipo 3")
        var selectedPlantType by remember { mutableStateOf(viewModel.getPlantType()) }

        SelectField(
            selectedOption = selectedPlantType,
            options = plantTypes,
            onOptionSelected = {
                selectedPlantType = it
                viewModel.setPlantType(it)
            },
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
        var selectedPlantColor by remember { mutableStateOf(viewModel.getPlantColor()) }

        SelectField(
            selectedOption = selectedPlantColor,
            options = plantColors,
            onOptionSelected = {
                selectedPlantColor = it
                viewModel.setPlantColor(it)
            },
            placeholder = "Selecione uma cor",
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_plant_color),
                    contentDescription = "Ícone de seleção",
                    modifier = Modifier.size(24.dp)
                )
            },
            isError = false,
            modifier = Modifier.padding(
                top = 16.dp,
                bottom = 25.dp
            )
        )

// Botão principal para tirar foto
        PrimaryButton(
            text = "TIRAR A PRIMEIRA FOTO DE SUA PLANTA",
            onClick = { /* REGISTRAR INFORMAÇÕES DA PLANTA E GERAR FOTO VIRTUAL */ },
            modifier = Modifier.padding(
                top = 15.dp,
                bottom = 25.dp
            ),
            fontSize = 14.sp
        )

// Botão "Ignorar por enquanto"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 25.dp,
                    bottom = 8.dp
                ),
        ) {
            SecondButton(
                text = "IGNORAR ESSA ETAPA POR ENQUANTO",
                onClick = onSkipSetup,
                modifier = Modifier.weight(1f),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantSetupScreenPreview() {
    MetamorfoseTheme {
        PlantSetupScreen()
    }
}