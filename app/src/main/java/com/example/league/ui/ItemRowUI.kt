package com.example.league.ui

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.Typeface
import android.text.Layout
import android.text.Layout.Alignment
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import com.example.league.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemRowUI : AnkoComponent<ViewGroup> {

    companion object {
        val imgLeague = 1
        val tvLeagueName = 2
        val tvLeagueDes = 3
    }


    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        cardView {

            lparams {
                cardElevation = dip(10).toFloat()
                width = matchParent
                height = wrapContent
                background.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
                margin = dip(10)
                radius = dip(12).toFloat()
            }
            linearLayout {
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = imgLeague
                }.lparams{
                    width = dip(50)
                    height = dip(100)
                    marginStart = 20
                }

                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    textView {
                        id = tvLeagueName
                        textSize = sp(8).toFloat()
                        setTypeface(null, Typeface.BOLD_ITALIC)
                        gravity = Gravity.CENTER_HORIZONTAL
                    }.lparams {
                        padding = dip(5)
                    }
                    textView {
                        id = tvLeagueDes
                        maxLines = 3
                        textSize = 15f
                    }.lparams(width = matchParent) {
                        padding = dip(10)
                    }
                }.lparams(width = matchParent, height = wrapContent)
            }
        }
    }

}