package com.example.gbcarbonintensity.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.gbcarbonintensity.databinding.DateBinding
import java.util.*

/**
 * Adapter for the dates list. Has a reference to the [DatePickerViewModel] to send actions back to it.
 */
class DatesAdapter(
    private val viewModel: DatePickerViewModel
) : ListAdapter<Date, DatesAdapter.ViewHolder>(TaskDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.bind(viewModel, item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.from(parent)

    class ViewHolder private constructor(
        private val binding: DateBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun from(parent: ViewGroup): ViewHolder {

                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DateBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)

            }

        }

        fun bind(viewModel: DatePickerViewModel, item: Date) {

            binding.viewmodel = viewModel
            binding.date = item
            binding.executePendingBindings()

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