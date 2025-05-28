/**
 * File: OnboardingEggScreen.kt
 * Description: Tela do onboarding do app Metamorfose que apresenta o casulo
 * como transformação do usuário.
 *
 * Responsabilidades:
 * - Exibe a ilustração da casulo sobre um fundo de onda
 * - Apresenta a mensagem motivacional para o usuário
 * - Mostra os indicadores de progresso (última etapa do onboarding)
 * - Permite que o usuário continue para a próxima tela com o botão continuar
 *
 * Author: Vinicyus Oliveira
 * Created on: 10-05-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 */

package br.com.metamorfose.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import br.com.metamorfose.R
import br.com.metamorfose.ui.components.buttons.PrimaryButton
import br.com.metamorfose.ui.theme.BlackLight
import br.com.metamorfose.ui.theme.GreyMedium
import br.com.metamorfose.ui.theme.MetamorfoseTheme
import br.com.metamorfose.ui.theme.Typography

/**
 * Tela da Casulo
 *
 * @param onContinueClick Ação a ser executada quando o usuário clicar em continuar
 * @param modifier Modificador opcional para customização da UI
 */
@Composable
fun OnboardingEggScreen(
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .zIndex(1f)
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.Outlined.ArrowBack,
                contentDescription = "Voltar",
                tint = BlackLight
            )
        }
    }

    // Exibição do fundo com a onda
    Image(
        painter = painterResource(id = R.drawable.bg_wave_1),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Ilustração do Casulo
        Image(
            painter = painterResource(id = R.drawable.egg_transformation),
            contentDescription = "Casulo",
            modifier = Modifier.size(330.dp, 240.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        // Texto motivacional
        Text(
            text = "Esse é você agora, aqui começa sua jornada de transformação.",
            style = Typography.headlineSmall,
            color = GreyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(72.dp))

        // Indicador de progresso e botão de ação
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Indicador de progresso
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ui_component_onboarding_progress_temp),
                    contentDescription = "Progresso Intermediário",
                    modifier = Modifier.height(43.dp)
                )
            }

            // Botão de continuar
            Box(
                modifier = Modifier.weight(1f)
                    .padding(WindowInsets.navigationBars.asPaddingValues()),
                contentAlignment = Alignment.CenterEnd,
            ) {
                PrimaryButton(
                    text = "CONTINUAR",
                    onClick = onContinueClick,
                    modifier = Modifier.size(width = 154.dp, height = 43.dp)
                )
            }
        }
    }
}

/**
 * Preview da tela OnboardingEggScreen.
 */
@Preview(showBackground = true)
@Composable
fun OnboardingEggScreenPreview() {
    MetamorfoseTheme {
        OnboardingEggScreen(
            onContinueClick = {},
            onBackClick = {}
        )
    }
}
