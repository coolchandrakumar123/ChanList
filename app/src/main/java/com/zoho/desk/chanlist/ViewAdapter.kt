package com.zoho.desk.chanlist


/**
 * Created by chandra-1765$ on 22/02/19$.
 */
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class ViewAdapter(private val itemsList: ArrayList<ViewItem>?) : RecyclerView.Adapter<ViewAdapter.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)

        val textItem = itemView.findViewById(R.id.flex_box_recycler_view_text_item) as TextView
        textItem.setOnClickListener { view ->
            Toast.makeText(
                view.context,
                "You click text : " + textItem.text,
                Toast.LENGTH_SHORT
            ).show()
        }

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDto = itemsList!![position]
        holder.textView.text = itemDto.name
    }

    override fun getItemCount(): Int {
        return itemsList?.size ?: 0
    }

    override fun onItemDismiss(position: Int) {
        itemsList?.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(itemsList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(itemsList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.flex_box_recycler_view_text_item)
    }

    data class ViewItem(var imageId: Int, var name: String)

}