package com.kenant42.jpcroomstudy

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.kenant42.jpcroomstudy.ui.theme.JpcroomstudyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpcroomstudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}


@Composable
fun Sayfa() {
    val context: Context = LocalContext.current
    val vt = Veritabani.accessDB(context)

    LaunchedEffect(key1 = true) {
        //fetchAllUsers(vt)
        //  saveUser(vt)
        // updateUser(vt)
        recordCheck(vt,"hme")
    }
}


fun fetchAllUsers(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val users = vt!!.usersDAO().getAllUsers()

        for (user in users) {
            Log.e("user", "${user.user_id}")
            Log.e("user", "${user.user_name}")
            Log.e("user", "${user.user_age}")
            Log.e("user", "${user.user_age}")
            Log.e("user", "${user.user_phone}")
        }
    }
}

fun saveUser(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val newUser = Users(1, "Kenan", 24, "123", "MEÜ")
        vt!!.usersDAO().saveUser(newUser)
        Log.e("USER ID", "${newUser.user_id}")
        Log.e("USER NAME", "${newUser.user_name}")
        Log.e("USER AGE", "${newUser.user_age}")
        Log.e("USER PHONE", "${newUser.user_phone}")
        Log.e("USER SCHOOL", "${newUser.user_school}")
    }
}

fun updateUser(vt: Veritabani?) {

    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val updatedUser = Users(4, "Ahmet", 26, "232", "AGÜ")
        vt!!.usersDAO().updateUser(updatedUser)
        Log.e("USER ID", "${updatedUser.user_id}")
        Log.e("USER NAME", "${updatedUser.user_name}")
        Log.e("USER AGE", "${updatedUser.user_age}")
        Log.e("USER PHONE", "${updatedUser.user_phone}")
        Log.e("USER SCHOOL", "${updatedUser.user_school}")
    }

}

fun deleteUser(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        vt!!.usersDAO().deleteUser(3)
    }
}

fun fetchRandomUser(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val user = vt!!.usersDAO().getRandomUser()

        Log.e("USER ID", "${user.user_id}")
        Log.e("USER NAME", "${user.user_name}")
        Log.e("USER AGE", "${user.user_age}")
        Log.e("USER PHONE", "${user.user_phone}")
        Log.e("USER SCHOOL", "${user.user_school}")

    }
}


fun recordCheck(vt: Veritabani?, wordToBeSearched:String) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val users = vt!!.usersDAO().recordCheck(wordToBeSearched)
        for (user in users) {
            Log.e("USER ID", "${user.user_id}")
            Log.e("USER NAME", "${user.user_name}")
            Log.e("USER AGE", "${user.user_age}")
            Log.e("USER PHONE", "${user.user_phone}")
            Log.e("USER SCHOOL", "${user.user_school}")
        }
    }
}

fun fetchUserById(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val user = vt!!.usersDAO().getUserById(5)
        Log.e("USER ID", "${user.user_id}")
        Log.e("USER NAME", "${user.user_name}")
        Log.e("USER AGE", "${user.user_age}")
        Log.e("USER PHONE", "${user.user_phone}")
        Log.e("USER SCHOOL", "${user.user_school}")

    }
}


fun fetchMatchingRecordCount(vt: Veritabani?) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val count = vt!!.usersDAO().getMatchingRecordCount("Ahmet")
        Log.e("MATCHING RECORD COUNT: ", "$count")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JpcroomstudyTheme {
    }
}