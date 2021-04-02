package com.example.gbcarbonintensity.list

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

/**
 * [BindingAdapter]s for the [Date]s list.
 */

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Date>) {
    (listView.adapter as DatesAdapter).submitList(items)
}

@BindingAdapter("app:date")
fun formatDate(textView: TextView, date: Date) {
    textView.setText(SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault()).format(date))
}