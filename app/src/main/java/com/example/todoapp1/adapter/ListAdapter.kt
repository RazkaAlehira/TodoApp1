package com.example.todoapp1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp1.R
import com.example.todoapp1.databinding.RowLayoutBinding
import com.example.todoapp1.model.Priority
import com.example.todoapp1.model.ToDoData

class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var dataList = emptyList<ToDoData>()
    private lateinit var binding: RowLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.txtTitle.text = dataList[position].title
        binding.txtDescription.text = dataList[position].description
        binding.rowBackground.setOnClickListener {
            val action = ListFragmentDirections
            holder.itemView.findNavController().navigate(R.id.action_listFragment_to_updateFragment)
        }

        val priority = dataList[position].priority
        when (priority) {
            Priority.HIGH -> binding.cardviewPriority.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.red
            ))
            Priority.MEDIUM -> binding.cardviewPriority.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.yellow
            ))
            Priority.LOW -> binding.cardviewPriority.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context,
                R.color.green
            ))
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    fun setData(toDoData: List<ToDoData>) {
        this.dataList = toDoData
        notifyDataSetChanged()
    }
}