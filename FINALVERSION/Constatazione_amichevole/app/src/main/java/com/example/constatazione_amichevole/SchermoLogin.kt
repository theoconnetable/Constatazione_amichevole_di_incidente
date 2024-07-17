@file:Suppress("UNUSED_EXPRESSION")

package com.example.constatazione_amichevole

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.constatazione_amichevole.data.FirebaseAuthViewModel


@Composable
fun SchermoLogin(navController : NavController){

    val authViewModel: FirebaseAuthViewModel = viewModel()


  var email by remember {
      mutableStateOf("")
  }

  var password by remember {
      mutableStateOf("")
  }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){


        Image(painter = painterResource(id = R.drawable.icona_pr),
            contentDescription = "Icona Login",
            modifier = Modifier.size(200.dp) )


        Text(text = "Benvenuti",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(value = email, onValueChange = {email = it}, label = {Text("Email")} )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(value = password, onValueChange = {password = it}, label = {Text("Password")}, visualTransformation = PasswordVisualTransformation() )

        Spacer(modifier = Modifier.height(6.dp))
        
        Button(onClick = { authViewModel.signIn(email, password) {
            navController.navigate(route = Screen.HomePage.route)
        } }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(6.dp))


        TextButton(onClick = { navController.navigate(route = Screen.CreaAccount.route)
            Log.i("CreateAccount","Inserted user") }) {
            Text(text = "Crea Account")
        }


    }
}