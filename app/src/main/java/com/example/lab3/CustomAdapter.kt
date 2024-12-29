package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: List<DataInterface>): RecyclerView.Adapter<CustomAdapter.BlockViewHolder>() {

    abstract class BlockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: DataInterface)
    }

    class UserHolder(itemView: View) : BlockViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.nameTitle)
        val group : TextView = itemView.findViewById(R.id.groupTitle)

        override fun bind(item: DataInterface) {
            if (item is User) {
                name.text = item.name
                group.text = item.group
            }
        }
    }

    class GroupHolder(itemView: View) : BlockViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.groupNameTitle)

        override fun bind(item: DataInterface) {
            if (item is Group) {
                name.text = item.name
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlockViewHolder {
        return when(viewType) {
            DataInterface.USER_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_view_row, parent, false)
                UserHolder(view)
            }
            DataInterface.GROUP_TYPE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.group_activity_row, parent, false)
                GroupHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type: $viewType")
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].GetType()
    }

    override fun onBindViewHolder(holder: BlockViewHolder, position: Int) {
        holder.bind(itemList[position])
    }


}