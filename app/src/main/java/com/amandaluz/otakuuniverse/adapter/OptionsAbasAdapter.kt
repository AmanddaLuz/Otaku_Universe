package com.amandaluz.otakuuniverse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amandaluz.otakuuniverse.databinding.ItemRvAbasBinding

class OptionsAbasAdapter(
    private val listAbasItem: List<String>,
    private val itemListener: ((string: String) -> Unit),
) : RecyclerView.Adapter<OptionsAbasAdapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AdapterViewHolder {
        val itemBinding =
            ItemRvAbasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding, itemListener)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(listAbasItem[position])
    }

    override fun getItemCount(): Int = listAbasItem.size

    class AdapterViewHolder(
        private val itemAbasBinding: ItemRvAbasBinding,
        private val itemClickedListener: (string: String) -> Unit,
    ) : RecyclerView.ViewHolder(itemAbasBinding.root) {
        fun bind(string: String) {
            itemAbasBinding.btnAbasItem.text = string
            itemAbasBinding.btnAbasItem.setOnClickListener {
                itemClickedListener.invoke(string)
            }
        }
    }
}