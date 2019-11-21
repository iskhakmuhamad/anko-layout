package com.example.league.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.league.R
import com.example.league.model.LeagueModel
import com.example.league.ui.MainUI
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    var myItems: MutableList<LeagueModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "List of Leagues"
        loadData()
        val mainUI = MainUI(myItems)
        mainUI.setContentView(this)
    }

    @SuppressLint("Recycle")
    private fun loadData(){
        val imgLeague = resources.obtainTypedArray(R.array.league_img)
        val nameLeague = resources.getStringArray(R.array.league_name)
        val desLeague = resources.getStringArray(R.array.league_desc)

        myItems.clear()

        for (i in nameLeague.indices)
        {
            myItems.add(LeagueModel(nameLeague[i], imgLeague.getResourceId(i,0), desLeague[i]))
        }

        imgLeague.recycle()
    }
}
