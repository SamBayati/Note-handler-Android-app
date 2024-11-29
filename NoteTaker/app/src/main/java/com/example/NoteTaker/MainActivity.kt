package com.example.fragmentgg1
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.NoteTaker.PageAdapter
import com.example.fragmentgg1.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        tabLayout.addTab(tabLayout.newTab().setText("Date"))
        tabLayout.addTab(tabLayout.newTab().setText("Note"))
        tabLayout.addTab(tabLayout.newTab().setText("History"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val adapter = PageAdapter(this, 3)  // 3 tabs now
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Date"
                1 -> "Note"
                2 -> "History"
                else -> ""
            }
        }.attach()
    }
}