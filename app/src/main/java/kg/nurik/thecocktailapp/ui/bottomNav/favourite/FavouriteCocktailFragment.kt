package kg.nurik.thecocktailapp.ui.bottomNav.favourite

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.thecocktailapp.R
import kg.nurik.thecocktailapp.databinding.FragmentFavouriteCocktailBinding
import kg.nurik.thecocktailapp.databinding.FragmentRandomCocktailBinding
import kg.nurik.thecocktailapp.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteCocktailFragment : Fragment(R.layout.fragment_favourite_cocktail) {

    private val binding by viewBinding(FragmentFavouriteCocktailBinding::bind)
    private val vm by viewModel<FavouriteCocktailViewModel>()
    private val adapter by lazy { FavouriteCocktailAdapter(vm) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewFavouriteCocktail.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        vm.getAllFavouriteDrink().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}