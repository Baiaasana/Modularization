package com.example.modularization.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.backend.data.UserModel
import com.example.modularization.common.Glide
import com.example.modularization.databinding.UserItemBinding

class UserAdapter : ListAdapter<UserModel, UserAdapter.UserViewHolder>(
        ItemCallback
    ) {

    var onItemClickListener: ((UserModel, UserItemBinding) -> Unit)? = null

    inner class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvUsername.text = item.username
                Glide().setImage(item.image, ivUser)
                ivUser.transitionName = ivUser.transitionName.plus(adapterPosition.toString())
                itemView.setOnClickListener {
                    onItemClickListener?.invoke(item, binding)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bind()

    object ItemCallback : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(
            oldItem: UserModel,
            newItem: UserModel,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UserModel,
            newItem: UserModel,
        ): Boolean {
            return oldItem == newItem
        }
    }
}