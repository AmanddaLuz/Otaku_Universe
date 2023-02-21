package com.amandaluz.otakuuniverse.view.categories.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.amandaluz.otakuuniverse.adapter.OptionsAbasAdapter
import com.amandaluz.otakuuniverse.databinding.FragmentHomeBinding
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
    }

    private fun loadingRecyclerView() {
        with(binding.rvAbas) {
            this.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL, false
            )
            setHasFixedSize(true)
            adapter = OptionsAbasAdapter(listOptionsAbas(requireContext())) {
                toast("Clique das Abas ok")
            }
        }
    }
}