package com.android.fridaytaskapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.fridaytaskapplication.callback.RecyclerViewCallback
import com.android.fridaytaskapplication.databinding.ItemPictureLayoutBinding
import com.android.fridaytaskapplication.model.Picture

class RecyclerViewAdapter(val listener: RecyclerViewCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val pictureList: MutableList<Picture> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            ItemPictureLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserViewHolder) {
            holder.bind()
        }
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }

    inner class UserViewHolder(private val binding: ItemPictureLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var picture: Picture

        fun bind() {
            picture = pictureList[absoluteAdapterPosition]
            binding.tvTitle.text = picture.title
            binding.tvDescription.text = picture.description
            binding.update.setOnClickListener{
                listener.onUpdateClick(picture)
            }
            binding.delete.setOnClickListener{
                listener.onDeleteClick(picture)
            }
        }

    }

    fun setData(list: List<Picture>){
        this.pictureList.clear()
        this.pictureList.addAll(list)
        notifyDataSetChanged()
    }
}