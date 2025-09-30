package com.example.sentraedgevaultdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    companion object {
        init {
            System.loadLibrary("vault")
        }
    }

    external fun stringFromVault(): String
    external fun getDeviceMessage(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var message by remember { mutableStateOf(stringFromVault()) }

            Button(onClick = { message = getDeviceMessage() }) {
                Text(text = message)
            }
        } // closes setContent
    }
}
