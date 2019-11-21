package com.example.league.ui
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.league.R
import com.example.league.activity.DetailActivity
import org.jetbrains.anko.*

class DetailUI : AnkoComponent<DetailActivity> {

    lateinit var imgLeague: ImageView
    lateinit var tvLeagueName: TextView
    lateinit var tvLeagueDes: TextView

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
        scrollView {

            backgroundColor = resources.getColor(R.color.colorPrimaryDark)
            lparams {
                width = matchParent
                height = matchParent
                padding = 16
            }

            linearLayout {
                orientation = LinearLayout.VERTICAL
                imgLeague = imageView {

                }.lparams {
                    margin = 20
                    width = 500
                    height = 400
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                tvLeagueName = textView {
                    textSize = sp(10).toFloat()
                    textColor = Color.WHITE
                    setTypeface(null, Typeface.BOLD_ITALIC)
                }.lparams {
                    padding = 10
                    margin = 10
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                tvLeagueDes = textView {
                    textSize = sp(7).toFloat()
                    textColor = Color.WHITE
                }.lparams {
                    padding = 20
                    margin = 10
                }
            }
        }
    }

}