package com.assignment.habitally

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.assignment.habitally.data.AppState

@Composable
fun AppTargets (
    appState: AppState,
) {
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
            SectionHeader(
                "Target: Water",
                "Adults need an average of 2,000ml per day"
            )
            SectionDetails(
                "Your daily average",
                listOf(
                    "Based on the last 7 days",
                    "${appState.waterCount} ml",
                ),
                "Current daily target",
                if (appState.waterTargetCount == 0) {
                    listOf("None")
                } else {
                    listOf(
                        "${appState.waterDaysCompleted} of 7 days completed",
                        "${appState.waterTargetCount} ml per day"
                    )
                }
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                var enteredText by remember { mutableStateOf("") }
                fun submitWater() {
                    if (enteredText == "") return
                    appState.updateWaterTarget(enteredText.toInt())
                    enteredText = ""
                }
                OutlinedTextField(
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = { submitWater() }),
                    value = enteredText,
                    onValueChange = { newText ->
                        if (newText.isDigitsOnly()) {
                            enteredText = newText
                        } else if (newText.isEmpty()) {
                            enteredText = ""
                        }
                    },
                    label = {
                        Text(
                            "What's your new water ml target per day?",
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    enabled = enteredText.isNotEmpty(),
                    onClick = { submitWater() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) { Text("Submit as new water target") }
            }
        }
        SectionDivider()
        Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
            SectionHeader(
                "Target: Workouts",
                "Create a path for your future self"
            )
            SectionDetails(
                "Your daily average",
                listOf(
                    "Based on the last 7 days",
                    if (appState.workoutMinutes < 60) "${appState.workoutMinutes} minutes" else "${appState.workoutMinutes / 60} hours and ${appState.workoutMinutes % 60} minutes",
                    if (appState.workoutActivities == 0) "No activities" else "${appState.workoutActivities} activities"
                ),
                "Current daily target",
                if (appState.workoutTargetMinutes == 0) {
                    listOf("None")
                } else {
                    listOf(
                        "${appState.workoutDaysCompleted} of 7 days completed",
                        "${appState.workoutTargetMinutes} minutes",
                        "${appState.workoutTargetActivities} activities"
                    )
                }
            )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                var enteredTargetMinutes by remember { mutableStateOf("") }
                var enteredTargetActivities by remember { mutableStateOf("") }
                fun submitWorkoutTarget() {
                    if (enteredTargetMinutes == "" || enteredTargetActivities == "") return
                    appState.updateWorkoutTarget(enteredTargetMinutes.toInt(), enteredTargetActivities.toInt())
                    enteredTargetMinutes = ""
                    enteredTargetActivities = ""
                }
                OutlinedTextField(
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = { submitWorkoutTarget() }),
                    value = enteredTargetMinutes,
                    onValueChange = { newText ->
                        if (newText.isDigitsOnly()) {
                            enteredTargetMinutes = newText
                        } else if (newText.isEmpty()) {
                            enteredTargetMinutes = ""
                        }
                    },
                    label = {
                        Text(
                            "What's your new target workout length per day?",
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                )
                OutlinedTextField(
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = { submitWorkoutTarget() }),
                    value = enteredTargetActivities,
                    onValueChange = { newText ->
                        if (newText.isDigitsOnly()) {
                            enteredTargetActivities = newText
                        } else if (newText.isEmpty()) {
                            enteredTargetActivities = ""
                        }
                    },
                    label = {
                        Text(
                            "How many activities do you want to do in that time?",
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    enabled = (enteredTargetMinutes.isNotEmpty() && enteredTargetActivities.isNotEmpty()),
                    onClick = {submitWorkoutTarget()},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) { Text("Submit as new workout target") }
            }
        }
    }
}