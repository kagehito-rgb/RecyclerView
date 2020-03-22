package com.example.multityperecyclerview.multiRecyclerView

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.multityperecyclerview.R
import com.example.multityperecyclerview.databinding.ItemBorderBinding
import com.example.multityperecyclerview.databinding.ItemDetailBinding
import com.example.multityperecyclerview.databinding.ItemHeaderBinding
import com.example.multityperecyclerview.databinding.ItemSummaryBinding
import java.lang.IllegalArgumentException

class MultiRecyclerViewAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: MutableList<ListItem> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return when(viewType) {
            HEADER -> HeaderViewHolder(ItemHeaderBinding.inflate(inflater, p0, false))
            DETAIL -> DetailVieHolder(ItemDetailBinding.inflate(inflater, p0, false))
            SUMMARY -> SummaryViewHolder(ItemSummaryBinding.inflate(inflater, p0, false))
            BORDER -> BorderViewHolder(ItemBorderBinding.inflate(inflater, p0, false))
            else -> throw IllegalArgumentException("Unknown ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when(item) {
            is ListItem.HeaderItem-> (holder as HeaderViewHolder).bind(item)
            is ListItem.DetailItem -> (holder as DetailVieHolder).bind(item)
            is ListItem.SummaryItem -> (holder as SummaryViewHolder).bind(item)
            is ListItem.BorderItem -> (holder as BorderViewHolder)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is ListItem.HeaderItem -> HEADER
            is ListItem.DetailItem -> DETAIL
            is ListItem.SummaryItem -> SUMMARY
            is ListItem.BorderItem -> BORDER
        }
    }

    fun addItem(item: ListItem) {
        val addIndex = items.size
        items.add(item)
        notifyItemInserted(addIndex)
    }

    companion object {
        private const val HEADER = R.id.header_item
        private const val DETAIL = R.id.detail_item
        private const val SUMMARY = R.id.summary_item
        private const val BORDER = R.id.border_item
    }

    sealed class ListItem {
        class HeaderItem(val label: String) : ListItem()
        class DetailItem(val value: String): ListItem()
        class SummaryItem(val value: String, val count: Int): ListItem()
        object BorderItem: ListItem()
    }

    data class HeaderViewHolder(val binding: ItemHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem.HeaderItem) {
            binding.apply {
                this.item = item
            }
        }
    }
    data class DetailVieHolder(val binding: ItemDetailBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem.DetailItem) {
            binding.apply {
                this.item = item
            }
        }
    }
    data class SummaryViewHolder(val binding: ItemSummaryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItem.SummaryItem) {
            binding.apply {
                this.item = item
            }
        }
    }
    data class BorderViewHolder(val binding: ItemBorderBinding): RecyclerView.ViewHolder(binding.root)
}