package edu.illinois.cs.cs124.ay2022.mp.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import edu.illinois.cs.cs124.ay2022.mp.R

class FavoritePlace :
    AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoriteplace)
        var favO = intent.getStringExtra("DES")
        var SIZE = intent.getStringExtra("SIZE")
        var fav = listOf<String>()
        val arrayAdapter: ArrayAdapter<*>
        fav += favO.toString()
        fav += "I wanted to add all the favorite places from the MP we've done"
        fav += "However, I came up a little shorter..."
        fav += "I'm sorry for not executing it perfectly"
        fav += "I felt extremely challenged When I got stuck with ParsedResource Error and ListView during the project"
        fav += "I tried to overcome obstacles by asking TAs and CAs. For the parts they did not know, I did the " +
            "research online"
        fav += "And I figured out things such as Listview."
        var mListView = findViewById<ListView>(R.id.fav_location)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, fav)
        mListView.adapter = arrayAdapter
    }
}

