package kg.nurik.thecocktailapp.ui.bottomNav.story

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.model.FavouriteDrink
import kg.nurik.thecocktailapp.databinding.ItemRandomCocktailBinding
import kg.nurik.thecocktailapp.databinding.ItemStoryCocktailBinding
import kg.nurik.thecocktailapp.utils.DiffUtils

class StoryAdapter(private val viewModel: StoryViewModel) :
    ListAdapter<Drink, StoryViewHolder>(DiffUtils.diffUtilRandomCockTail) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding =
            ItemStoryCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class StoryViewHolder(
    private val binding: ItemStoryCocktailBinding,
    private val viewModel: StoryViewModel
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(point: Drink?) {
        binding.tvNameCock.text = point?.strDrink
        binding.tvIdCock.text = point?.idDrink
        binding.tvCategoryCock.text = point?.strCategory
        binding.tvTypeCock.text = point?.strAlcoholic

        Picasso.get().load(point?.strDrinkThumb).into(binding.imCocktail)

        binding.imClose.setOnClickListener {
            viewModel.update(point!!)
        }
    }
}