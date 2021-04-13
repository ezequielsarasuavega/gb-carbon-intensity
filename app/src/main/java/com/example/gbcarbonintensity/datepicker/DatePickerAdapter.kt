package com.example.gbcarbonintensity.datepicker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gbcarbonintensity.databinding.ItemDatePickerBinding
import com.example.gbcarbonintensity.utils.DateUtils
import java.util.*

/**
 * Adapter for the dates list
 */
class DatesAdapter(
    private val clickListener: OnDateClickListener
) : ListAdapter<Date, DatesAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(clickListener, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(
        private val binding: ItemDatePickerBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {
                return ViewHolder(ItemDatePickerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }

        }

        fun bind(clickListener: OnDateClickListener, item: Date) {

            with (binding) {

                date.text = DateUtils.formatDisplayDate(item)

                root.setOnClickListener {
                    clickListener.onClick(item)
                }

            }

        }

    }

}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class TaskDiffCallback : DiffUtil.ItemCallback<Date>() {

    override fun areItemsTheSame(oldItem: Date, newItem: Date): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: Date, newItem: Date): Boolean {
        return oldItem == newItem
    }

}

interface OnDateClickListener {

    fun onClick(date: Date)

}