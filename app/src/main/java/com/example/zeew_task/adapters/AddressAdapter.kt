package com.example.zeew_task.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.zeew_task.R
import com.example.zeew_task.models.Addresse
import com.google.android.material.snackbar.Snackbar

class AddressAdapter(
    private val context: Context,
    private val itemList: List<Addresse>,
    private val view: View
) : RecyclerView.Adapter<AddressAdapter.AddressViewHolder>() {

    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.address_card, parent, false)
        return AddressViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val currentAddress = itemList[position]

        holder.countryTextView.text = currentAddress.country
        holder.addressTextView.text = currentAddress.address1
        holder.addressTextView2.text = currentAddress.address2 ?: currentAddress.address1
        holder.phoneTextView.text = currentAddress.phone

        holder.itemView.isSelected = selectedItemPosition == position

        if (currentAddress.default) {
            holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(R.color.default_address_color))
            holder.deleteIcon.visibility = View.GONE
        } else {
            holder.cardView.setCardBackgroundColor(holder.itemView.context.getColor(R.color.non_default_address_color))
            holder.deleteIcon.visibility = View.VISIBLE
        }

        // Delete click listener example
        holder.deleteIcon.setOnClickListener {
            Snackbar.make(view, "Deleted: ${currentAddress.address1}", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount() = itemList.size

    inner class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryTextView: TextView = itemView.findViewById(R.id.TextCountry)
        val addressTextView: TextView = itemView.findViewById(R.id.TextAddress)
        val addressTextView2: TextView = itemView.findViewById(R.id.TextAddress2)
        val phoneTextView: TextView = itemView.findViewById(R.id.TextPhone)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val deleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
    }
}
