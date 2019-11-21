package com.example.league.ui

import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.activity.DetailActivity
import com.example.league.activity.MainActivity
import com.example.league.adapter.LeagueAdapter
import com.example.league.model.LeagueModel
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI(val myItems: List<LeagueModel>) : AnkoComponent<MainActivity> {

    companion object {
        val LEAGUE_ITEM = "league_item"
    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        verticalLayout {
            backgroundColor = Color.GRAY
            lparams(matchParent, wrapContent)
            recyclerView {
                layoutManager = LinearLayoutManager(context)
                adapter = LeagueAdapter(myItems) {

                    context.startActivity(intentFor<DetailActivity>
                        (LEAGUE_ITEM to it))

                }
            }
        }
    }
}
