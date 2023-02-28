package com.amandaluz.otakuuniverse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amandaluz.otakuuniverse.databinding.ItemRvCategoriesBinding
import com.amandaluz.otakuuniverse.model.TopItems

class AbasAdapter(
    private val listAbasItem: List<TopItems>,
    private val itemListener: ((item: TopItems) -> Unit),
) : RecyclerView.Adapter<AbasAdapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdapterViewHolder {
        val itemBinding =
            ItemRvCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding, itemListener)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(listAbasItem[position])
    }

    override fun getItemCount(): Int = listAbasItem.size

    class AdapterViewHolder(
        private val itemAbasBinding: ItemRvCategoriesBinding,
        private val itemClickedListener: (item: TopItems) -> Unit,
    ) : RecyclerView.ViewHolder(itemAbasBinding.root) {
        fun bind(item: TopItems) = with(itemAbasBinding){
            textTitle.text = item.name
            textDescription.text = item.nameKanji
            item.imageUrl?.let { imgCategories.setImageResource(it) }
            card.setOnClickListener {
                itemClickedListener.invoke(item)
            }
        }
    }
}