package com.uoa.deviceprofile.presentation.ui
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.uoa.deviceprofile.domain.model.DriverProfile
import com.uoa.deviceprofile.presentation.viewModel.DriverProfileViewModel
import com.uoa.core.util.DateUtils
import dagger.hilt.android.AndroidEntryPoint
import java.time.Instant
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DriverProfileView(viewModel: DriverProfileViewModel = hiltViewModel(),
                      driverProfile: DriverProfile) {
    var email= rememberSaveable { mutableStateOf("") }
    var password= rememberSaveable { mutableStateOf("") }
    var phone=rememberSaveable { mutableStateOf("")    }
    var driver_type=rememberSaveable { mutableStateOf("")    }
    var vehicle_type=rememberSaveable { mutableStateOf("")    }
    var education_level=rememberSaveable { mutableStateOf("")    }
    var driving_school=rememberSaveable { mutableStateOf(false)    }
    var driving_license= rememberSaveable{(mutableStateOf(false))}


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Driver Profile",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(value = email.value, onValueChange = { email.value = it }, label = { Text("Email") })
                TextField(value = password.value, onValueChange = { password.value= it }, label = { Text("Password") })
                TextField(value = phone.value, onValueChange = { phone.value= it }, label = { Text("Phone") })

            }

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(value = driver_type.value, onValueChange = { driver_type.value= it }, label = { Text("Driver Type") })
                TextField(value = vehicle_type.value, onValueChange = { vehicle_type.value= it }, label = { Text("Vehicle Type") })
                TextField(value = education_level.value, onValueChange = { education_level.value= it }, label = { Text("Education Level") })

            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Column(
            ) {
                Text(text = "Trained in a driving School?")
                Checkbox(checked = false, onCheckedChange = {driving_school.value=it})
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = "Trained in a driving School?")
                Checkbox(checked = false, onCheckedChange={driving_license.value=it})
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Button(onClick = {
                val driverP=DriverProfile(
                    driverType=driver_type.value,
                    vehicleType=vehicle_type.value,
                    educationalLevel=education_level.value,
                    drivingSchool=driving_school.value,
                    drivingLicense = driving_license.value,
                    email=email.value,
                    phone=phone.value,
                    phoneType = phone.value,
                    password = password.value,
                    registrationDateTime = Instant.now().toString()

                )
                val res=viewModel.signupDriverProfile(driverP)
                Log.i("SignUP",res.toString())
            }

            ) {
                Text(text = "Sign Up")
            }


        }
    }
}

