package com.example.multityperecyclerview.multiRecyclerView

data class WeekHeader(
    val week: String,
    val detailMenu: DetailMenu
)

data class DetailMenu(
    val menu: String,
    val summaryMenu: SummaryMenu
)

data class SummaryMenu(
    val menu: String,
    val count: Int
)