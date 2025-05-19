package com.assignment.habitally

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.viewmodel.compose.viewModel
import com.assignment.habitally.data.AppState
import kotlinx.coroutines.delay


@Composable
fun AppHome(onNavigate: () -> Unit) {
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        WaterTracker(onNavigate)
        SectionDivider()
        WorkoutTracker(onNavigate)
        SectionDivider()
        WorkoutTimer()
    }
}

@Composable
fun WaterTracker(
    onNavigate: () -> Unit
) {
    val viewModel: AppState = viewModel()
    Column (
        modifier = Modifier.padding(16.dp)
    ) {
        SectionHeader(
            "Water",
            "You're made of it - make sure you drink enough"
        )
        SectionDetails(
            "Today",
            listOf("${viewModel.waterCount} ml", "Equal to " + viewModel.waterCount / 200 + " glasses"),
            "Your daily average",
            listOf("Based on the last 7 days", "${viewModel.waterCount} ml")
        )
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(bottom = 8.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton (
                    onClick = {
                        if (viewModel.waterCount <= 500) viewModel.updateWaterCount(0, 3) else viewModel.updateWaterCount(500, 2)
                    },
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) { Text("- 500ml") }
                Button (
                    onClick = {
                        if (viewModel.waterCount <= 200) viewModel.updateWaterCount(0, 3) else viewModel.updateWaterCount(200, 2)
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                ) { Text("- 200ml") }
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedButton (
                    onClick = {
                        viewModel.updateWaterCount(500, 1)
                    },
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) { Text("+ 500ml") }
                Button (
                    onClick = {
                        viewModel.updateWaterCount(200, 1)
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .fillMaxWidth()
                ) { Text("+ 200ml") }
            }
        }
        SectionTarget(
            onNavigate,
            listOf(if (viewModel.waterTargetCount == 0) "None set" else "${viewModel.waterTargetCount} + ML per day")
        )
    }
}

@Composable
fun WorkoutTracker(onNavigate: () -> Unit) {
    val viewModel: AppState = viewModel()
    Column (modifier = Modifier.padding(16.dp)) {
        SectionHeader(
            "Workouts",
            "Put your excess energy to use"
        )
        SectionDetails (
            "Today",
            listOf(
                if (viewModel.workoutMinutes < 60) "${viewModel.workoutMinutes} minutes" else "${viewModel.workoutMinutes / 60} hours and ${viewModel.workoutMinutes % 60} minutes",
                if (viewModel.workoutActivities == 0) "No activities" else "${viewModel.workoutActivities} activities"),
            "Your daily average",
            listOf(
                "Based on the last 7 days",
                if (viewModel.workoutWeeklyMinutes < 60) "${viewModel.workoutWeeklyMinutes} minutes" else "${viewModel.workoutWeeklyMinutes / 60} hours and ${viewModel.workoutWeeklyMinutes % 60} minutes",
                if (viewModel.workoutWeeklyActivities == 0) "No activities" else "${viewModel.workoutWeeklyActivities} activities")
        )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            var enteredText by remember {mutableStateOf("")}
            fun submitMinutes() {
                if (enteredText == "") return
                viewModel.updateWorkoutData(enteredText.toInt())
                enteredText = ""
            }
            OutlinedTextField(
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done // Or ImeAction.Go, ImeAction.Search, etc.
                ),
                keyboardActions = KeyboardActions(onDone = {submitMinutes()}),
                value = enteredText,
                onValueChange = {newText ->
                    if (newText.isDigitsOnly()) {
                        enteredText = newText
                    } else if (newText.isEmpty()) {
                        enteredText = ""
                    }
                },
                label = {Text("How many minutes was your workout?", style = MaterialTheme.typography.labelMedium)},
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                enabled = enteredText.isNotEmpty(),
                onClick = {submitMinutes()},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            ) { Text("Submit to records") }
        }
        var targetPresent = viewModel.workoutTargetMinutes != 0
        SectionTarget(
            onNavigate,
            if (targetPresent == true) {
                listOf(
                    "${viewModel.workoutTargetMinutes} minutes",
                    "${viewModel.workoutTargetActivities} activities"
                )
            } else { listOf("None set") }
        )
    }
}

@Composable
fun WorkoutTimer() {
    val viewModel: AppState = viewModel()
    var timerSeconds by remember {mutableIntStateOf(0)}
    var timerMinutes by remember {mutableIntStateOf(0)}
    var timerHours by remember {mutableIntStateOf(0)}

    var timerState by remember {mutableIntStateOf(-1)}
    Column (modifier = Modifier.padding(16.dp)) {
        SectionHeader(
            "Timer",
            "Start a new workout instantly"
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            Column (
                modifier = Modifier
                    .padding(12.dp)
            ) {
                Text ("This workout")
                Text (
                    "$timerSeconds seconds",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text (
                    "$timerMinutes minutes",
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text (
                    "$timerHours hours",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Column (modifier = Modifier
                .padding(12.dp)
                .align(alignment = Alignment.BottomEnd)) {
                OutlinedButton (
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(0.5f),
                    enabled = timerState == 0,
                    onClick = {
                        timerState = -1
                        timerSeconds = 0
                        timerMinutes = 0
                        timerHours = 0
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
                        timerMinutes++
                        if (timerMinutes >= 60) {
                            timerMinutes = 0
                            timerHours++
                        }
                    }
                }
            }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(6.dp))
                .padding(12.dp)
        ) {
            Column {
                Text("Add to records")
                if (timerMinutes == 0 || timerHours == 0) {Text("Your workout isn't long \nenough to be saved.", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 4.dp))}
            }
            OutlinedButton(
                enabled = ((timerMinutes != 0 || timerHours != 0) && timerState == 0),
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .align(Alignment.CenterEnd),
                onClick = {
                    viewModel.updateWorkoutData(timerHours * 60 + timerMinutes)
                    timerState = -1
                    timerSeconds = 0
                    timerMinutes = 0
                    timerHours = 0
                }
            ) {
                Text("Submit")
            }
        }
    }
}