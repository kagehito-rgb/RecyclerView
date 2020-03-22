package com.example.multityperecyclerview.multiRecyclerView

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multityperecyclerview.databinding.FragmentMultiRecyclerBinding

class MultiRecyclerViewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMultiRecyclerBinding.inflate(inflater)
        val recyclerViewAdapter = MultiRecyclerViewAdapter(requireContext())
        recyclerViewAdapter.run {
            addItem(MultiRecyclerViewAdapter.ListItem.HeaderItem(
                "月曜日"
            ))
            addItem(MultiRecyclerViewAdapter.ListItem.DetailItem(
                "カレー"
            ))
            addItem(MultiRecyclerViewAdapter.ListItem.SummaryItem(
                "ちゃんぽん",
                30
            ))
            addItem(MultiRecyclerViewAdapter.ListItem.HeaderItem(
                "火曜日"
            ))
            addItem(MultiRecyclerViewAdapter.ListItem.DetailItem(
                "とんかつ"
            ))
            addItem(MultiRecyclerViewAdapter.ListItem.SummaryItem(
                "ラーメン",
                70
            ))
        }
        binding.multiRecycler.run {
            adapter = recyclerViewAdapter
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}