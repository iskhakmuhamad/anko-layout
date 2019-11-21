package com.example.league.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.league.model.LeagueModel
import com.example.league.ui.DetailUI
import com.example.league.ui.MainUI
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.setContentView

class DetailActivity: AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Detail of League"
        info ("Masuk DETAIL UI")
        val itemExtra = intent.extras?.getParcelable<LeagueModel>(MainUI.LEAGUE_ITEM)

        val detailUI = DetailUI()

        detailUI.setContentView(this)
        Glide.with(applicationContext).load(itemExtra?.image).into(detailUI.imgLeague)
        detailUI.tvLeagueName.text = itemExtra?.name
        detailUI.tvLeagueDes.text = itemExtra?.describtion

    }

}