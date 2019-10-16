package com.example.classparserecycler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.classparserecycler.R
import com.parse.ParseFile
import com.parse.ParseObject

class AdapterPhoto (private val photos: List<ParseObject>): RecyclerView.Adapter<NameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int = photos.size //Change the number of items showed in

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(photos[position])
    }
}

class NameViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val nameTitle: TextView = view.findViewById(R.id.item_photo_tv_image_title)
    private val image: ImageView = view.findViewById(R.id.item_photo_iv_photo)
    private val likesCount: TextView = view.findViewById(R.id.item_photo_tv_likes_count)

    fun bind(po: ParseObject) {
        val parseFile: ParseFile = po.get("photo") as ParseFile
        Glide.with(view).load(parseFile.url).into(image)
        nameTitle.text = po["username"] as String
        likesCount.text = "${po["commentsNumber"]}"
    }
}