package com.assignment.habitally

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
                                modifier = Modifier.padding(top = 4.dp),
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
            }
//            ,
//            floatingActionButton = {
//                FloatingActionButton(onClick = { }) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
//            }

        ) { innerPadding ->
            Column (
                modifier = Modifier.padding(innerPadding)
            ) {
                WaterTracker()
                WorkoutTracker()
            }
        }
    }
}

@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var waterCountWeekly by remember { mutableIntStateOf(waterCount) }

    Column {
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
                    top = 4.dp,
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
                Text(
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    text = "$waterCount ML",
                    style = MaterialTheme.typography.bodyMedium)
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
                Text(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp), text = "Based on the last 7 days", style = MaterialTheme.typography.bodyMedium)
                Text(text = "$waterCountWeekly ML", style = MaterialTheme.typography.bodyMedium)
            }
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)

        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                OutlinedButton (onClick = {},
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                )) {
                    Text (
                        text = "-200ml"
                    )
                }
                OutlinedButton (onClick = {},
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp)
                ) {
                    Text (
                        text = "-1000ml"
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                OutlinedButton (
                    onClick = {},
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp)
                ) {
                    Text (
                        text = "+200ml"
                    )
                }
                OutlinedButton (
                    onClick = {},
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp)
                ) {
                    Text (
                        text = "+1000ml"
                    )
                }
            }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Your daily target:"
            )
            Text (
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                style = MaterialTheme.typography.bodyMedium,
                text = "None set"
            )
            Button (
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(12.dp),
                onClick = {}
            ) {
                Text (
                    text = "Change"
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier.padding(
                start = 32.dp,
                end = 32.dp,
                bottom = 16.dp
            ),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun WorkoutTracker() {
    Column {
        var workoutMinutes by remember {mutableIntStateOf(0)}
        var workoutMinutesWeekly by remember {mutableIntStateOf(0)}
        var workoutActivities by remember {mutableIntStateOf(0)}
        var workoutActivitiesWeekly by remember {mutableIntStateOf(0)}

        var workoutActivitiesOutput = if (workoutActivities == 0) "No" else workoutActivities.toString()
        var workoutActivitiesWeeklyOutput = if (workoutActivitiesWeekly == 0) "No" else workoutActivitiesWeekly.toString()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                text = "Workouts",
                modifier = Modifier.padding(
                    top = 12.dp,
                    start = 12.dp,
                    bottom = 4.dp
                ),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Put your excess energy to use",
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
                Text(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp), text = "$workoutMinutes minutes", style = MaterialTheme.typography.bodyMedium)
                Text(text = "$workoutActivitiesOutput activities", style = MaterialTheme.typography.bodyMedium)
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
                Text(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp), text = "Based on the last 7 days", style = MaterialTheme.typography.bodyMedium)
                Text(text = "$workoutMinutesWeekly minutes", style = MaterialTheme.typography.bodyMedium)
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