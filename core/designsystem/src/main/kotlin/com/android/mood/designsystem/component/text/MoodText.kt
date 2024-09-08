package com.android.mood.designsystem.component.text

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.android.mood.designsystem.foundation.MoodTheme

@Composable
fun MoodText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    color: Color = MoodTheme.color.black,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    var mergedStyle = style.merge(
        TextStyle(
            color = color
        )
    )
    if (textAlign != null) {
        mergedStyle = mergedStyle.merge(
            TextStyle(
                textAlign = textAlign,
            )
        )
    }


    BasicText(
        text = text,
        modifier = modifier,
        overflow = overflow,
        maxLines = maxLines,
        style = mergedStyle,
    )
}

@Composable
fun MoodText(
    text: String,
    style: TextStyle,
    brush: Brush,
    modifier: Modifier = Modifier,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    var mergedStyle = style.merge(
        TextStyle(
            brush = brush
        )
    )
    if (textAlign != null) {
        mergedStyle = mergedStyle.merge(
            TextStyle(
                textAlign = textAlign,
            )
        )
    }

    BasicText(
        text = text,
        modifier = modifier,
        overflow = overflow,
        maxLines = maxLines,
        style = mergedStyle,
    )
}

@Composable
fun MoodText(
    text: AnnotatedString,
    style: TextStyle,
    color: Color,
    modifier: Modifier = Modifier,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
) {
    var mergedStyle = style.merge(
        TextStyle(
            color = color
        )
    )
    if (textAlign != null) {
        mergedStyle = mergedStyle.merge(
            TextStyle(
                textAlign = textAlign,
            )
        )
    }

    BasicText(
        text = text,
        modifier = modifier,
        overflow = overflow,
        maxLines = maxLines,
        style = mergedStyle,
    )
}
