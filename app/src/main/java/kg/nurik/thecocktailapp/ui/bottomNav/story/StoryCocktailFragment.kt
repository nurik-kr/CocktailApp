package kg.nurik.thecocktailapp.ui.bottomNav.story

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kg.nurik.thecocktailapp.R
import kg.nurik.thecocktailapp.databinding.FragmentRandomCocktailBinding
import kg.nurik.thecocktailapp.databinding.FragmentStoryCocktailBinding
import kg.nurik.thecocktailapp.ui.bottomNav.random.RandomCocktailAdapter
import kg.nurik.thecocktailapp.ui.bottomNav.random.RandomCocktailViewModel
import kg.nurik.thecocktailapp.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoryCocktailFragment : Fragment(R.layout.fragment_story_cocktail) {

    private val binding by viewBinding(FragmentStoryCocktailBinding::bind)
    private val vm by viewModel<StoryViewModel>()
    private val adapter by lazy { StoryAdapter(vm) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewStoryCocktail.adapter = adapter
        setupViews()
    }

    private fun setupViews() {
        vm.getStoryCocktail().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}
