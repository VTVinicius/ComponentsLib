import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.vtvinicius.input_text.R


private val arialRegular = FontFamily(
    Font(R.font.arial_regular, FontWeight.Normal)
)
private val arialBold = FontFamily(
    Font(R.font.arial_bold, FontWeight.Bold)
)

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )  ,
    val title: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    val title22: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    val title40: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp
    ),
    val title20: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val normal: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    val buttonBig: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    val title18: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    val title18Bold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    val buttonSmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    val title22Bold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    val title20Bold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    val subtitleBold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    val normalBold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val buttonBold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    val buttonSmallBold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    val normalSmall: TextStyle = TextStyle(
        fontFamily = arialRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    val normalSmallBold: TextStyle = TextStyle(
        fontFamily = arialBold,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf { AppTypography() }