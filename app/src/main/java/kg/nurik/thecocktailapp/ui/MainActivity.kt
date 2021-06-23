package kg.nurik.thecocktailapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.nurik.thecocktailapp.R
import kg.nurik.thecocktailapp.databinding.ActivityMainBinding
import kg.nurik.thecocktailapp.utils.setupWithNavController
import kg.nurik.thecocktailapp.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupBottomMenu()
    }

    private fun setupBottomMenu() {
        val navId = listOf(
            R.navigation.random,
            R.navigation.favourite,
            R.navigation.story
        )

        binding.bottomNav.setupWithNavController(
            navGraphIds = navId,
            fragmentManager = supportFragmentManager,
            containerId = R.id.navView,
            intent = intent
        )
    }
}