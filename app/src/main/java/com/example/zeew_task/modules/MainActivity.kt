package com.example.zeew_task.modules

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zeew_task.adapters.CartAdapter
import com.example.zeew_task.databinding.ActivityMainBinding
import com.example.zeew_task.models.CartItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cartItems = listOf(
            CartItem("Adidas Shoes", 2, "59.99", null, "Red - Size 42"),
            CartItem("Nike Jacket", 1, "89.99", null, "Black - L"),
            CartItem("Puma T-Shirt", 3, "19.99", null, "White - M")
        )
        cartAdapter = CartAdapter(this, cartItems, binding.root)

        binding.recyclerViewCartItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cartAdapter
        }
        binding.buttonCheckout.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }



}