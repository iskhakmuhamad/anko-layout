package com.example.league.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueModel(val name: String?,val image: Int?, val describtion: String?) : Parcelable