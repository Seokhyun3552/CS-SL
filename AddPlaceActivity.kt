package edu.illinois.cs.cs124.ay2022.mp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import edu.illinois.cs.cs124.ay2022.mp.R
import android.widget.EditText
import edu.illinois.cs.cs124.ay2022.mp.application.FavoritePlacesApplication
import edu.illinois.cs.cs124.ay2022.mp.models.Place
import edu.illinois.cs.cs124.ay2022.mp.models.ResultMightThrow
import edu.illinois.cs.cs124.ay2022.mp.network.Client
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

private val TAG = AddPlaceActivity::class.simpleName
@Suppress("EmptyClassBlock")
class AddPlaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_addplace)

        val returnToMain = Intent(this, MainActivity::class.java)
        returnToMain.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK + Intent.FLAG_ACTIVITY_NEW_TASK

        val cancelButton = findViewById<Button>(R.id.cancel_button)
        cancelButton.setOnClickListener {
            startActivity(returnToMain)
        }
        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener {
            val lat = intent.getStringExtra("latitude")
            val lon = intent.getStringExtra("longitude")
            println(lat)
            val id = FavoritePlacesApplication.CLIENT_ID
            val editText = this.findViewById<EditText>(R.id.description)
            val latd = lat?.toDouble()
            val longd = lon?.toDouble()
            if (longd != null) {
                if (latd != null) {
                    val plobj = Place(id, "test", latd, longd, editText.text.toString())
                    val completableFuture = CompletableFuture<ResultMightThrow<Boolean>>()

                    // When getPlaces returns, it causes the CompletableFuture to complete
                    Client.postFavoritePlace(plobj) { completableFuture.complete(it) }

                    // Wait for the CompletableFuture to complete
                    val result = try {
                        completableFuture.get(1, TimeUnit.SECONDS)
                    } catch (e: TimeoutException) {
                        println(e)
                    }

                }
            } // Reference taken from the MP2 test case
            startActivity(returnToMain)
        }
    }
}
