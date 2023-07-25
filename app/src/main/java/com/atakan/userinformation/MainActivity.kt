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
                binding.apply {
                    city.text = result.body()?.city.toString()
                    country.text = result.body()?.country_name.toString()
                    lat.text = result.body()?.latitude.toString()
                    longt.text = result.body()?.longitude.toString()
                    timezone.text = result.body()?.timezone.toString()
                    currency.text = result.body()?.currency.toString()
                    org.text = result.body()?.org.toString()
                }
            }
        }

        setContentView(binding.root)
    }
}