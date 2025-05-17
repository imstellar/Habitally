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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.assignment.habitally.ui.theme.HabitAllyTheme
import kotlinx.coroutines.delay

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
                var workoutMinutes by remember {mutableIntStateOf(0)}
                var workoutActivities by remember {mutableIntStateOf(0)}
                var workoutTargetMinutes by remember {mutableIntStateOf(0)}
                var workoutTargetActivity by remember {mutableIntStateOf(0)}

                WaterTracker()
                WorkoutTracker(
                    workoutMinutes,
                    onWorkoutMinutesChanged = {value -> workoutMinutes = value},
                    workoutActivities,
                    onWorkoutActivitiesChanged = {value -> workoutActivities = value},
                    workoutTargetMinutes,
                    workoutTargetActivity
                )
                WorkoutTimer(
                    onTimerSubmission = {value -> workoutMinutes = value}
                )
            }
        }
    }
}

@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }

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
                    "Equal to " + waterCount / 200 + " glasses",
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
                    "$waterCount ml",
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
                OutlinedButton (onClick = {
                    waterCount = if (waterCount >= 500) waterCount - 500 else 0
                },
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(start = 8.dp)
                ) {
                    Text("- 500ml")
                }
                Button (onClick = {
                    waterCount = if (waterCount >= 200) waterCount - 200 else 0
                },
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
                    onClick = {
                        waterCount = waterCount + 500
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(start = 8.dp)
                ) {
                    Text("+ 500ml")
                }
                Button (
                    onClick = {
                        waterCount = waterCount + 200
                    },
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
fun WorkoutTracker(
    workoutMinutes: Int,
    onWorkoutMinutesChanged: (Int) -> Unit,
    workoutActivities: Int,
    onWorkoutActivitiesChanged: (Int) -> Unit,
    workoutTargetMinutes: Int,
    workoutTargetActivity: Int
) {
    Column {
        var workoutActivitiesOutput = if (workoutActivities == 0) "No" else workoutActivities.toString()
        var workoutTargetActivityOutput = if (workoutTargetActivity == 0) "No" else workoutTargetActivity.toString()
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
                    modifier = Modifier.padding(bottom = 4.dp),
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
                    "$workoutMinutes minutes",
                    modifier = Modifier.padding(bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    "$workoutActivitiesOutput activities",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            var enteredText by remember {mutableStateOf("")}
            OutlinedTextField(
                value = enteredText,
                onValueChange = {newText ->
                    if (newText.isDigitsOnly()) {
                        enteredText = newText
                    } else if (newText.isEmpty()) {
                        enteredText = ""
                    }
                },
                label = { Text("Minutes") },
                modifier = Modifier.fillMaxWidth(0.5f).padding(start = 12.dp, top = 4.dp, end = 12.dp, bottom = 12.dp)
            )
            Button(
                enabled = enteredText.isNotEmpty(),
                onClick = {
                    if (enteredText.isNotEmpty()) {
                        onWorkoutActivitiesChanged(workoutActivities + 1)
                        onWorkoutMinutesChanged(workoutMinutes + enteredText.toInt())
                        enteredText = ""
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp)
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
                Text("Your daily target:")
                Text("$workoutTargetMinutes minutes", style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp, bottom = 4.dp))
                Text("$workoutTargetActivityOutput activities", style = MaterialTheme.typography.bodyMedium)
            }
            OutlinedButton(modifier = Modifier.align(Alignment.CenterEnd).padding(12.dp), onClick = {}) {
                Text("Change")
            }
        }
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 32.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onSurface)
}

@Composable
fun WorkoutTimer(
    onTimerSubmission: (Int) -> Unit,
) {
    var timerSeconds by remember {mutableIntStateOf(0)}
    var timerMinutes by remember {mutableIntStateOf(0)}
    var timerHours by remember {mutableIntStateOf(0)}

    var timerState by remember {mutableIntStateOf(-1)}
    Column (modifier = Modifier.padding(bottom = 16.dp)) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Text(
                "Timer",
                modifier = Modifier.padding(start = 12.dp, top = 12.dp, bottom = 4.dp),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "Start a new workout instantly",
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
            Column (
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text ("This workout")
                Text (
                    "$timerSeconds seconds",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text (
                    "$timerMinutes minutes",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text (
                    "$timerHours hours",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column (modifier = Modifier.padding(12.dp).align(alignment = Alignment.BottomEnd)) {
                OutlinedButton (
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(0.5f),
                    enabled = timerState == 0,
                    onClick = {
                        timerState = -1
                        timerSeconds = 0
                    }
                ) {
                    Text ("Reset")
                }
                Button (
                    modifier = Modifier.fillMaxWidth(0.5f),
                    onClick = {timerState = if (timerState != 1) 1 else 0}
                ) {
                    Text(text = if (timerState != 1) "Start" else "Pause")
                }
            }

            LaunchedEffect(timerState) {
                while (timerState == 1) {
                    delay(1000L)
                    timerSeconds++
                    if (timerSeconds >= 60) {
                        timerSeconds = 0
                        timerMinutes = timerMinutes + 20
                        if (timerMinutes >= 60) {
                            timerMinutes = 0
                            timerHours++
                        }
                    }
                }
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