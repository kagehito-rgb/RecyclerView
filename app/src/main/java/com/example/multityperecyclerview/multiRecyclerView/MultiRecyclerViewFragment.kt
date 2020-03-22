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
        val menuData = WeekHeader(
            "月曜日",
            DetailMenu(
                "カレー",
                SummaryMenu(
                    "うどん",
                    570
                )
            )
        )
        recyclerViewAdapter.items.apply {
            add(MultiRecyclerViewAdapter.ListItem.HeaderItem(menuData))
            add(MultiRecyclerViewAdapter.ListItem.DetailItem(menuData.detailMenu))
            add(MultiRecyclerViewAdapter.ListItem.SummaryItem(menuData.detailMenu.summaryMenu))
        }
        binding.multiRecycler.run {
            adapter = recyclerViewAdapter
            hasFixedSize()
            layoutManager = LinearLayoutManager(requireContext())
        }
        return binding.root
    }
}