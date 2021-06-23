package kg.nurik.thecocktailapp.ui.bottomNav.random

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import kg.nurik.thecocktailapp.R
import kg.nurik.thecocktailapp.databinding.FragmentRandomCocktailBinding
import kg.nurik.thecocktailapp.utils.ConnectionUtils
import kg.nurik.thecocktailapp.utils.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomCocktailFragment : Fragment(R.layout.fragment_random_cocktail) {

    private val binding by viewBinding(FragmentRandomCocktailBinding::bind)
    private val vm by viewModel<RandomCocktailViewModel>()
    private val adapter by lazy { RandomCocktailAdapter(vm) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RecyclerviewRandomCocktail.adapter = adapter
        checkIsInternet()
        setupViews()
        swipeRefresh()
    }

    private fun setupViews() {
        vm.allAds.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.drinks)
        })
        vm.progress.observe(viewLifecycleOwner, Observer {
            binding.progressBarRandomCocktail.isVisible = it
        })
    }

    private fun swipeRefresh() {
        binding.mySwipeRefreshLayout.setOnRefreshListener {
            vm.loadAds()
            checkIsInternet()
            vm.swipeRefresh.observe(viewLifecycleOwner, Observer {
                binding.mySwipeRefreshLayout.isRefreshing = it
            })
        }
    }

    private fun checkIsInternet() {
        val isHasNetwork = ConnectionUtils.isNetworkAvailable(requireContext())
        if (!isHasNetwork) {
            Snackbar.make(
                binding.parentLayout, "Проверьте наличие интернета",
                Snackbar.LENGTH_INDEFINITE
            )
                .setAction("Обновить") {
                    if (!ConnectionUtils.isNetworkAvailable(requireContext()))
                        setupViews()
                        checkIsInternet()
                }
                .show()
        }
    }
}