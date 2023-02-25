package com.amandaluz.otakuuniverse.view.carroussel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.ViewFlipper
import com.amandaluz.otakuuniverse.R
import com.amandaluz.otakuuniverse.model.Slide
import com.amandaluz.otakuuniverse.model.TopItems
import com.bumptech.glide.Glide

class CustomCarrousel(context: Context?, attrs: AttributeSet?) : ViewFlipper(context, attrs) {

    private var list = mutableListOf<TopItems>()

    fun setList(list: MutableList<TopItems>) {
        this.list = list
    }

    private var itemClickedListener: ((article: TopItems) -> Unit)? = null

    fun setClick(itemClickedListener: (article: TopItems) -> Unit) {
        this.itemClickedListener = itemClickedListener
    }

    fun setupCarrousel() {
        val flipperList = mutableListOf<Slide>()
        list.forEach { item ->
            flipperList.add(
                Slide(
                    item.title ?: "",
                    item.imageUrl ?: ""
                )
            )
        }

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        this.setInAnimation(context, android.R.anim.slide_in_left)
        this.setOutAnimation(context, android.R.anim.slide_out_right)

        for (i in flipperList.indices) {
            val view: View = inflater.inflate(R.layout.item_slide, this, false)

            val title = view.findViewById<TextView>(R.id.title)
            title.text = flipperList[i].title

            val image = view.findViewById<ImageView>(R.id.background)
            Glide.with(context).load(flipperList[i].imageUrl).into(image)

            this.addView(view, i)

            title.setOnClickListener {
                itemClickedListener?.invoke(list[i])
            }
            image.setOnClickListener {
                itemClickedListener?.invoke(list[i])
            }
        }
    }
}