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

class ViewAdapter(private val itemDtoList: List<ViewItem>?) : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

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

        val itemDto = itemDtoList!![position]

        holder.textView.text = itemDto.name
    }

    override fun getItemCount(): Int {
        return itemDtoList?.size ?: 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.flex_box_recycler_view_text_item)
    }

    data class ViewItem(var imageId: Int, var name: String)
}