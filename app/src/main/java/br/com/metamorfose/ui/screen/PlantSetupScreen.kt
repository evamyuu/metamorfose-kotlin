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

package br.com.metamorfose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.*
import br.com.metamorfose.R
import androidx.compose.ui.platform.LocalConfiguration

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantSetupScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var plantName by remember { mutableStateOf("") }
    var plantType by remember { mutableStateOf("") }
    var potColor by remember { mutableStateOf("") }

    // Usando as cores definidas no seu tema
    val backgroundPurple = LightPurpleGradient //LightPurple33Gradient
    val backgroundPurpleFlat = PurpleLight
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundPurple)
            //.background(backgroundPurpleFlat)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Cabeçalho com botão de voltar
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = PurpleDarken
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Mascote/Avatar da planta
            /*Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Corpo roxo do mascote
                Box(
                    modifier = Modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .background(PurpleNormal)
                ) {
                    // Rosto do mascote
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFFC0CB))
                            .align(Alignment.Center)
                    ) {
                        // Olhos do mascote
                        Row(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(top = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(BlackDark)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(BlackDark)
                            )
                        }

                        // Boca do mascote
                        Box(
                            modifier = Modifier
                                .padding(top = 48.dp)
                                .size(width = 40.dp, height = 12.dp)
                                .clip(CircleShape)
                                .background(PurpleDarken)
                                .align(Alignment.Center)
                        )
                    }
                }

                // Broto no topo
                Box(
                    modifier = Modifier
                        .offset(y = (-70).dp)
                        .align(Alignment.TopCenter)
                ) {
                    // Tronco
                    Box(
                        modifier = Modifier
                            .width(8.dp)
                            .height(20.dp)
                            .background(GreenDarken)
                            .align(Alignment.TopCenter)
                    )

                    // Folhas
                    Row(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = (-10).dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(topStart = 12.dp, bottomEnd = 12.dp))
                                .background(GreenLight)
                                .rotate(-15f)
                        )
                        Spacer(modifier = Modifier.width((-12).dp))
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .clip(RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp))
                                .background(GreenLight)
                                .rotate(15f)
                        )
                    }
                }
            }*/
            // Imagem SVG convertida (VectorDrawable)
            Image(
                painter = painterResource(id = R.drawable.ic_planta_digital),
                contentDescription = "Mascote da planta",
                modifier = Modifier
                    .size(320.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Formulário em um Card branco usando seu Shape personalizado
            Card(
                modifier = Modifier.fillMaxWidth()
                    .height(screenHeight * 0.5f)
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = WhiteLight),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Campo de nome da planta
                    OutlinedTextField(
                        value = plantName,
                        onValueChange = { plantName = it },
                        placeholder = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(android.R.drawable.ic_menu_add),
                                    contentDescription = null,
                                    tint = PurpleNormal,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Nome da planta",
                                    style = Typography.bodyMedium,
                                    color = GreyMedium
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Dropdown para selecionar planta
                    OutlinedTextField(
                        value = plantType,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(android.R.drawable.ic_menu_add),
                                    contentDescription = null,
                                    tint = PurpleNormal,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Selecione a sua planta",
                                    style = Typography.bodyMedium,
                                    color = GreyMedium
                                )
                            }
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Selecionar planta",
                                tint = PurpleNormal
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Dropdown para selecionar cor do vaso
                    OutlinedTextField(
                        value = potColor,
                        onValueChange = { },
                        readOnly = true,
                        placeholder = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .clip(CircleShape)
                                        .background(PurpleNormal)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    "Cor do vaso",
                                    style = Typography.bodyMedium,
                                    color = GreyMedium
                                )
                            }
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Selecionar cor",
                                tint = PurpleNormal
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Botão para tirar foto usando seu PrimaryButton personalizado
                    PrimaryButton(
                        text = "TIRAR A PRIMEIRA FOTO DE SUA PLANTA",
                        onClick = { /* Implementar lógica para tirar foto */ },
                        backgroundColor = PurpleNormal,
                        textColor = WhiteLight,
                        strokeColor = PurpleNormal,
                        shadowColor = PurpleDarken
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Link para ignorar etapa
                    TextButton(
                        onClick = { /* Implementar lógica para ignorar */ },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "IGNORAR ESSA ETAPA POR ENQUANTO",
                            style = Typography.labelLarge,
                            color = PurpleNormal,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
*/
@Preview(showBackground = true)
@Composable
fun PlantSetupScreenPreview() {
    MetamorfoseTheme {
        PlantSetupScreen(navController = rememberNavController())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantSetupScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var plantName by remember { mutableStateOf("") }
    var plantType by remember { mutableStateOf("") }
    var potColor by remember { mutableStateOf("") }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LightPurple33Gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            // Botão voltar
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(48.dp)
                    .padding(top = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = PurpleDarken
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Mascote
            Image(
                painter = painterResource(id = R.drawable.ic_planta_digital),
                contentDescription = "Mascote da planta",
                modifier = Modifier
                    .size(280.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Formulário
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = screenHeight * 0.45f, max = screenHeight * 0.6f)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = WhiteLight),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Nome da planta
                    OutlinedTextField(
                        value = plantName,
                        onValueChange = { plantName = it },
                        placeholder = {
                            Text("Nome da planta", color = GreyMedium)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Tipo da planta
                    OutlinedTextField(
                        value = plantType,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = {
                            Text("Selecione a sua planta", color = GreyMedium)
                        },
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Cor do vaso
                    OutlinedTextField(
                        value = potColor,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = {
                            Text("Cor do vaso", color = GreyMedium)
                        },
                        trailingIcon = {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PurpleNormal,
                            unfocusedBorderColor = GreyLight
                        ),
                        shape = Shape.small,
                        singleLine = true,
                        textStyle = Typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    // Botão de tirar foto
                    PrimaryButton(
                        text = "TIRAR A PRIMEIRA FOTO DE SUA PLANTA",
                        onClick = {
                            // TODO: Adicionar lógica de abrir câmera ou galeria
                        },
                        backgroundColor = PurpleNormal,
                        textColor = WhiteLight,
                        strokeColor = PurpleNormal,
                        shadowColor = PurpleDarken
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    TextButton(
                        onClick = {
                            // TODO: Navegar ou pular etapa
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "IGNORAR ESSA ETAPA POR ENQUANTO",
                            color = PurpleNormal,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
