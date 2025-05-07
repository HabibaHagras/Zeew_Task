package com.example.zeew_task.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zeew_task.adapters.AddressAdapter
import com.example.zeew_task.databinding.ActivitySecondBinding
import com.example.zeew_task.models.Addresse

class SecondActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivitySecondBinding
    private lateinit var addressAdapter: AddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val addressList = listOf(
            Addresse(1, "Egypt", "Street 1", "Building 5", "01000000000", default = true),
            Addresse(2, "Germany", "Street 2", null, "01500000000", default = false),
            Addresse(3, "USA", "Street 3", "Floor 2", "01200000000", default = false)
        )
        addressAdapter = AddressAdapter(this, addressList, binding.root)

        binding.recyclerViewAddresses.apply {
            layoutManager = LinearLayoutManager(this@SecondActivity)
            adapter = addressAdapter
        }
    }


}