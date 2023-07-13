package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.utils.navigation_utils.MainNavigationManager
import com.example.myapplication.utils.navigation_utils.NavigationViewModel
import com.example.myapplication.utils.navigation_utils.observeNavigation


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigationViewModel: NavigationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        navigationViewModel.navigationManager.observe(this) {
            it.observeNavigation(
                findNavController(R.id.nav_host_fragment_content_main)
            )
        }

        setContentView(binding.root)

        setNavBar()
    }

    private fun setNavBar() {
        binding.content.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> {
                    navigationViewModel.navigateTo(MainNavigationManager.HomeFragment)
                    binding.content.bottomNavigation.removeBadge(R.id.item_2)
                    true
                }

                R.id.item_2 -> {
                    navigationViewModel.navigateTo(MainNavigationManager.PageFragment)
                    binding.content.bottomNavigation.removeBadge(R.id.item_1)
                    true

                }

                else -> false
            }
        }

        val badgeHome = binding.content.bottomNavigation.getOrCreateBadge(R.id.item_1)
        badgeHome.isVisible = true
        badgeHome.number = 99

        val PageHome = binding.content.bottomNavigation.getOrCreateBadge(R.id.item_2)
        PageHome.isVisible = true
        PageHome.number = 77
    }
}
