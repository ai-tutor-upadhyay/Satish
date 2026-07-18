package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
      primary = GamakGold,
      secondary = GamakBeige,
      tertiary = GamakDarkGreen,
      background = GamakBlack,
      surface = GamakBlack,
      onPrimary = GamakBlack,
      onSecondary = GamakBlack,
      onTertiary = GamakWhite,
      onBackground = GamakCream,
      onSurface = GamakCream
  )

private val LightColorScheme =
  lightColorScheme(
      primary = GamakDarkGreen,
      secondary = GamakGold,
      tertiary = GamakBeige,
      background = GamakCream,
      surface = GamakWhite,
      onPrimary = GamakWhite,
      onSecondary = GamakBlack,
      onTertiary = GamakBlack,
      onBackground = GamakBlack,
      onSurface = GamakBlack
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Disable dynamic color to enforce brand colors
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
