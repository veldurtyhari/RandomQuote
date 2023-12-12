package com.haresh.schools


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.haresh.schools.models.School


class PostsAdapter(private val context: Context) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

      val allSchools = mutableListOf<School>()
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_post_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = allSchools[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.school_name

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return allSchools.size
    }

    fun updateList(mylist: List<School>) {
     allSchools.clear()
     allSchools.addAll(mylist)
        //Toast.makeText(context, mylist.get(0).school_name, Toast.LENGTH_SHORT).show()
     notifyDataSetChanged()
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textView: TextView = itemView.findViewById(R.id.tvTitle)
    }
}