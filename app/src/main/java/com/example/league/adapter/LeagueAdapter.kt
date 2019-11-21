package com.example.league.adapter

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.league.model.LeagueModel
import com.example.league.ui.ItemRowUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LeagueAdapter(
    private val items: List<LeagueModel>,
    private val listener: (LeagueModel) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemRowUI().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }


    inner class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        lateinit var image: ImageView
        lateinit var tvName: TextView
        lateinit var tvDes: TextView

        fun bindItem(items: LeagueModel, listener: (LeagueModel) -> Unit) {

            image = itemView.findViewById(ItemRowUI.imgLeague)
            tvName = itemView.findViewById(ItemRowUI.tvLeagueName)
            tvDes = itemView.findViewById(ItemRowUI.tvLeagueDes)

            tvName.text = items.name
            tvDes.text = items.describtion

            Glide.with(containerView).load(items.image).into(image)

            containerView.setOnClickListener { listener(items) }
        }

    }
}