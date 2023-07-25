package com.atakan.userinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.atakan.userinformation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val infoUs = RetrofitMain.getInstance().create(IpApi::class.java)

        lifecycleScope.launch{
            val result = infoUs.getInfo()
            if(result != null){
                println(result.body()?.city)
            }
        }

        setContentView(binding.root)
    }
}