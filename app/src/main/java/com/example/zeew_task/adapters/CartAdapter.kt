package com.example.zeew_task.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zeew_task.R
import com.example.zeew_task.databinding.CartItemBinding
import com.example.zeew_task.models.CartItem
import com.google.android.material.snackbar.Snackbar

class CartAdapter(
    private val context: Context,
    private val itemList: List<CartItem>,
    private val view: View
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = itemList[position]

        val imageUrl = item.imageUrl
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.adidas)
                .error(R.drawable.logout)
                .into(holder.binding.imageView)
        } else {
            Log.i("CartAdapter", "No image found, using placeholder.")
            holder.binding.imageView.setImageResource(R.drawable.adidas)
        }

        holder.binding.itemName.text = item.title
        holder.binding.itemDetails.text = item.details ?: "No details"
        holder.binding.quantityText.text = item.quantity.toString()
        holder.binding.currency.text = item.price + " USD"

        holder.binding.deleteIcon.setOnClickListener {
            Snackbar.make(view, "${item.title} removed", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = itemList.size
}
