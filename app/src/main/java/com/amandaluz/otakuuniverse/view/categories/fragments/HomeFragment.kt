package com.amandaluz.otakuuniverse.view.categories.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.amandaluz.otakuuniverse.R
import com.amandaluz.otakuuniverse.adapter.AbasAdapter
import com.amandaluz.otakuuniverse.adapter.OptionsAbasAdapter
import com.amandaluz.otakuuniverse.databinding.FragmentHomeBinding
import com.amandaluz.otakuuniverse.model.TopItems
import com.amandaluz.otakuuniverse.utils.listOptionsAbas
import com.amandaluz.otakuuniverse.utils.toast

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingRecyclerView()
        setCarrousel()
        loadingRecyclerViewAbas()
    }

    private fun loadingRecyclerView() {
        with(binding.rvAbas) {
            this.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
            adapter = OptionsAbasAdapter(listOptionsAbas(requireContext())) {
                toast(it)
            }
        }
    }

    private val test = listOf(
        TopItems("Title 1", null, null, R.drawable.ic_launcher_background),
        TopItems("Title 2", "teste 2", "1200", R.drawable.ic_launcher_foreground),
        TopItems(name = "Title 3", imageUrl = R.drawable.ic_launcher_background, nameKanji = "kanji 3"),
        TopItems("Title 4", nameKanji = "kanji 4", null, R.drawable.ic_launcher_background),
        TopItems("Title 5", "teste 5", "1500", R.drawable.ic_launcher_foreground),
        TopItems(name = "Title 6", imageUrl = R.drawable.ic_launcher_background),
        TopItems("Title 7", null, null, R.drawable.ic_launcher_background),
        TopItems("Title 8", "teste 8", "1800", R.drawable.ic_launcher_foreground),
        TopItems(name = "Title 9", imageUrl = R.drawable.ic_launcher_background),
        )

    private fun setCarrousel() = with(binding.includedCategoriesLayout.carrousel){
        setList(test as MutableList<TopItems>)
        setClick {
            it.name?.let { it1 -> toast(it1) }
        }
        setupCarrousel()
    }
    private fun loadingRecyclerViewAbas() {
        with(binding.includedCategoriesLayout.rvAbas) {
            this.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL, false
            )
            setHasFixedSize(true)
            adapter = AbasAdapter(test) {
                it.name?.let { it1 -> toast(it1) }
            }
        }
    }

}