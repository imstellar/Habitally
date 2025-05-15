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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
                            Text("Welcome to Habitally")
                            Text(modifier = Modifier.padding(top = 4.dp), text = "Get started by tracking your habits below", style = MaterialTheme.typography.titleMedium)
                        }
                    }
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
                        Button(onClick = {}) {Text("Overview")}
                        Button(onClick = {}) {Text ("Targets") }
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
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
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
                "Water",
                modifier = Modifier.padding(top = 12.dp, start = 12.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "You're made of it - make sure you drink enough",
                modifier = Modifier.padding(top = 4.dp, start = 12.dp, bottom = 12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text("Today")
                Text(
                    "$waterCount ml",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "Equal to " + waterCount / 60 + " glasses",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .align(alignment = Alignment.TopEnd),
                horizontalAlignment = Alignment.End
            ) {
                Text("Your daily average")
                Text(
                    "Based on the last 7 days",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "$waterCountWeekly ml",
                    style = MaterialTheme.typography.bodyMedium
                )
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
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp, end = 4.dp)
            ) {
                OutlinedButton (onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(start = 8.dp)
                ) {
                    Text("- 1000ml")
                }
                Button (onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Text("- 200ml")
                }
            }
            Row (
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, end = 4.dp)
            ) {
                OutlinedButton (
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(start = 8.dp)
                ) {
                    Text("+ 1000ml")
                }
                Button (
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                ) {
                    Text("+ 200ml")
                }
            }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                "Your daily target:",
                modifier = Modifier.padding(12.dp)
            )
            Text(
                "None set",
                modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedButton (
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(12.dp),
                onClick = {}
            ) {
                Text("Change")
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(
                    start = 32.dp,
                    end = 32.dp,
                    bottom = 16.dp
                ),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.onSurface)
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
                "Workouts",
                modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 4.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "Put your excess energy to use",
                modifier = Modifier.padding(start = 12.dp, bottom = 12.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Today")
                Text(
                    "$workoutMinutes minutes",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "$workoutActivitiesOutput activities",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .align(alignment = Alignment.TopEnd),
                horizontalAlignment = Alignment.End
            ) {
                Text("Your daily average")
                Text(
                    "Based on the last 7 days",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "$workoutMinutesWeekly minutes",
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "$workoutActivitiesWeeklyOutput activities",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            OutlinedButton (
                onClick = {},
                modifier = Modifier.padding(8.dp)
            ) { Text("+ 10m") }
            OutlinedButton (
                onClick = {},
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            ) { Text("- 10m") }
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) { Text("Confirm") }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column (
                modifier = Modifier.padding(12.dp)
            )  {
                Text("Your daily target:", )
                Text("0 minutes", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp, bottom = 4.dp))
                Text("No activities", style = MaterialTheme.typography.bodyMedium)
            }
            OutlinedButton(modifier = Modifier.align(Alignment.CenterEnd).padding(12.dp), onClick = {}) {
                Text("Change")
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