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
    private val itemList: List<CartItem>, // ده الموديل اللي بتستخدميه
    private val view: View // ممكن تستخدمه في SnackBar أو غيره
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = itemList[position]

        // تحميل الصورة من URL (لو موجودة)
        val imageUrl = item.imageUrl
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.adidas) // صورة مؤقتة
                .error(R.drawable.logout)       // لو حصل خطأ
                .into(holder.binding.imageView)
        } else {
            Log.i("CartAdapter", "No image found, using placeholder.")
            holder.binding.imageView.setImageResource(R.drawable.adidas)
        }

        // بيانات المنتج
        holder.binding.itemName.text = item.title
        holder.binding.itemDetails.text = item.details ?: "No details"
        holder.binding.quantityText.text = item.quantity.toString()
        holder.binding.currency.text = item.price + " USD"

        // حذف المنتج
        holder.binding.deleteIcon.setOnClickListener {
            // هنا ممكن تنادي على فنكشن أو تبعتي callback
            Snackbar.make(view, "${item.title} removed", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = itemList.size
}
