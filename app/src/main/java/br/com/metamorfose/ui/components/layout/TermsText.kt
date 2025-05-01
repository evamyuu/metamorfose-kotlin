/**
 * File: TermsText.kt
 * Description: Componente que exibe um texto com destaque (negrito) nas palavras "Termos" e "Política de Privacidade".
 * Ideal para telas de login ou cadastro, indicando que o usuário concorda com os termos da plataforma.
 * O texto é exibido centralizado com a possibilidade de personalização de cor e conteúdo.
 *
 * Responsabilidades:
 * - Exibir o texto com partes em negrito para destacar os "Termos" e a "Política de Privacidade".
 * - Permitir personalização de cor e conteúdo do texto.
 * - Oferecer uma interface clara e simples para os usuários aceitarem os termos e a política de privacidade.
 *
 * Author: Evelin Cordeiro
 * Created on: 30-04-2025
 * Last modified: 30-04-2025
 * Version: 1.0.0
 * Squad: Metamorfose
 *
 */

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.metamorfose.ui.theme.GreyLight
import br.com.metamorfose.ui.theme.Typography

/**
 * @param modifier Modificador opcional para personalização (ex: padding, alinhamento).
 * @param termsText Texto a ser exibido. Por padrão, exibe a frase padrão do Metamorfose.
 * @param textColor Cor do texto. O padrão é um cinza claro definido no tema.
 */
@Composable
fun TermsText(
    modifier: Modifier = Modifier,
    termsText: String = "Ao entrar no Metamorfose, você concorda com os nossos Termos e Política de Privacidade.",
    textColor: Color = GreyLight
) {
    val annotatedString = buildAnnotatedString {
        val text = termsText
        append(text)

        val termsStart = text.indexOf("Termos")
        val termsEnd = termsStart + "Termos".length
        if (termsStart >= 0) {
            addStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold),
                start = termsStart,
                end = termsEnd
            )
        }

        val privacyStart = text.indexOf("Política de Privacidade")
        val privacyEnd = privacyStart + "Política de Privacidade".length
        if (privacyStart >= 0) {
            addStyle(
                style = SpanStyle(fontWeight = FontWeight.Bold),
                start = privacyStart,
                end = privacyEnd
            )
        }
    }

    Text(
        text = annotatedString,
        style = Typography.bodyLarge,
        color = textColor,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
    )
}

/**
 * Preview para o TermosText.
 */
@Preview(showBackground = true)
@Composable
fun TermsTextPreview() {
    TermsText(
        modifier = Modifier.fillMaxWidth(),
        termsText = "Ao entrar no Metamorfose, você concorda com os nossos Termos e Política de Privacidade."
    )
}
