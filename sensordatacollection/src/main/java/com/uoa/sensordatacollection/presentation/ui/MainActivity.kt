package com.uoa.sensordatacollection.presentation.ui

import com.uoa.sensordatacollection.presentation.ui.theme.SensorTrackingTheme
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.Close
//import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.filled.PlayArrow
//import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
//import androidx.lifecycle.viewmodel.compose.viewModel
import com.uoa.sensordatacollection.presentation.viewmodel.SensorsViewModel
import com.uoa.sensordatacollection.presentation.viewmodel.TripState
import dagger.hilt.android.AndroidEntryPoint
//import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorTrackingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up the content of your activity here
                    SensorTrackingApp(this@MainActivity, this)
                }
            }
        }
    }
}

@Composable
fun SensorTrackingApp(liveOwner: LifecycleOwner, context: Context) {
    val viewModel= hiltViewModel<SensorsViewModel>()
    val tripState by viewModel.tripState.collectAsState()
    val driverProfileId = 12324L

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        TripStateIcon(tripState)
        Spacer(modifier = Modifier.height(16.dp))
        TripButton(
            tripState = tripState,
            onStartClick = { viewModel.startTrip(liveOwner, driverProfileId, true) },
            onStopClick = { viewModel.stopTrip(context, driverProfileId) }
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun TripStateIcon(tripState: TripState) {
    val icon = when (tripState) {
        TripState.STARTED -> Icons.Default.PlayArrow
        TripState.STOPPED -> Icons.Default.Close
    }

    Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun TripButton(
    tripState: TripState,
    onStartClick: () -> Unit,
    onStopClick: () -> Unit
) {
    Button(
        onClick = {
            when (tripState) {
                TripState.STARTED -> onStartClick()
                TripState.STOPPED -> onStopClick()
            }
        }
    ) {
        Text(text = when (tripState) {
            TripState.STARTED -> "Stop Trip"
            TripState.STOPPED -> "Start Trip"
        })
    }
}


//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SensorTrackingTheme {
//        SensorTrackingApp( liveOwner = MainActivity, context = LocalContext.current,)
//    }
//}
