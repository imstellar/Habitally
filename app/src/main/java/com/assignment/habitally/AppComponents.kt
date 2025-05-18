package com.assignment.habitally

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun SectionHeader (
    headerText: String,
    subHeaderText: String
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(6.dp))
    ) {
        Text(
            headerText,
            modifier = Modifier.padding(top = 12.dp, start = 12.dp),
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            subHeaderText,
            modifier = Modifier.padding(top = 4.dp, start = 12.dp, bottom = 12.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun SectionDetails(
    leftHighlightText: String,
    leftTexts: List<String>,
    rightHighlightText: String,
    rightTexts: List<String>
) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(leftHighlightText, modifier = Modifier.padding(bottom = 4.dp))
            leftTexts.forEach { text ->
                Text(text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 4.dp))
            }
        }
        Column(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.TopEnd),
            horizontalAlignment = Alignment.End
        ) {
            Text(rightHighlightText, modifier = Modifier.padding(bottom = 4.dp))
            rightTexts.forEach { text ->
                Text(text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(bottom = 4.dp))
            }
        }
    }
}

@Composable
fun SectionTarget(
    onNavigate: () -> Unit,
    targetTexts: List<String>
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(6.dp))
    ) {
        Column (
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterStart)
        ) {
            Text("Your daily target:")
            targetTexts.forEach { text ->
                Text(text, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp))
            }
        }
        OutlinedButton (
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.CenterEnd)
                .padding(start = 6.dp ,end = 12.dp),
            onClick = onNavigate
        ) {
            Text("Change")
        }
    }
}

@Composable
fun SectionDivider() {
    HorizontalDivider(
        modifier = Modifier
            .padding(horizontal = 32.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onSurface
    )
}