package com.assignment.habitally

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.habitally.ui.theme.HabitAllyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    HabitAllyTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Column {
                            Text(
                                text = "Welcome to Habitally"
                            )
                            Text(
                                text = "Get started by tracking your habits below",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    },
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.primary,
                ) {
                    Row (
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {  }
                        ) {
                            Text(
                                text = "Overview"
                            )
                        }
                        Button(
                            onClick = { }
                        ) {
                            Text (
                                text = "Targets"
                            )
                        }
                    }
                }
            },

            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }

        ) { innerPadding ->
            WaterTracker(innerPadding)

        }
    }
}

@Composable
fun WaterTracker(
    innerPadding: PaddingValues = PaddingValues()
) {
    var waterCount by remember { mutableIntStateOf(0) }
    var waterCountWeekly by remember { mutableIntStateOf(waterCount) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                text = "Water",
                modifier = Modifier.padding(
                    top = 12.dp,
                    start = 12.dp
                ),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "You're made of it - make sure you drink enough",
                modifier = Modifier.padding(
                    start = 12.dp,
                    bottom = 12.dp
                ),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(12.dp)
            ) {
                Text(text = "Today")
                Text(text = "$waterCount ML", style = MaterialTheme.typography.bodyMedium)
                Text(
                    text = "Equal to " + waterCount / 60 + " glasses",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .padding(12.dp)
                    .align(alignment = Alignment.TopEnd),
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Your daily average")
                Text(text = "Based on the last 7 days", style = MaterialTheme.typography.bodyMedium)
                Text(text = "$waterCountWeekly ML", style = MaterialTheme.typography.bodyMedium)
            }
        }
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)

        ) {
            Row (
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }
            Row (
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(onClick = {}) {}
                Button(onClick = {}) {}
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    HabitAllyTheme {
        App()
    }
}