package com.example.optionmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.optionmenu.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    val tabName = arrayOf("Home", "Quiz")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            //implementasi settingan per viewpager
            viewPager.adapter = SectionPagerAdapter(this@MainActivity)
            //hubungin antara tab menjadi viewpager. jadi apa yang dipilih tab nya sesuai dengan yang ditampilkan di view pager
            TabLayoutMediator(tabLayout,viewPager){ tab, position ->
                //berikut merupakan nama tabnya
                tab.text = tabName[position]
            }.attach()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_home ->{
                Toast.makeText(this,"Home",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_quiz->{
                Toast.makeText(this,"Quiz",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_materi->{
                Toast.makeText(this,"Materi",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }
}