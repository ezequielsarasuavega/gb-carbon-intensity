package com.example.gbcarbonintensity.datepicker

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gbcarbonintensity.utils.DateUtils
import java.util.*

/**
 * [BindingAdapter]s for the [Date]s list.
 */

@BindingAdapter("items")
fun setItems(listView: RecyclerView, items: List<Date>) {
    (listView.adapter as DatesAdapter).submitList(items)
}

@BindingAdapter("date")
fun formatDate(textView: TextView, date: Date) {
    textView.text = DateUtils.formatDisplayDate(date)
}
