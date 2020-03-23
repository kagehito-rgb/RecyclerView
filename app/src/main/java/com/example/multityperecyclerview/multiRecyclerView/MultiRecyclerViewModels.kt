package com.example.multityperecyclerview.multiRecyclerView

data class WeekHeader(val week: String, val detailMenu: List<DetailMenu>)
data class DetailMenu(val menu: String)
data class SummaryMenu(val menu: String, val count: Int)