package kg.nurik.thecocktailapp.ui.bottomNav.favourite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.BounceInterpolator
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kg.nurik.thecocktailapp.data.model.FavouriteDrink
import kg.nurik.thecocktailapp.databinding.ItemRandomCocktailBinding
import kg.nurik.thecocktailapp.utils.DiffUtils
import java.lang.Exception

class FavouriteCocktailAdapter(private val viewModel: FavouriteCocktailViewModel) :
    ListAdapter<FavouriteDrink, FavouriteCocktailViewHolder>(DiffUtils.diffUtilFavouriteCockTail) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteCocktailViewHolder {
        val binding =
            ItemRandomCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteCocktailViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: FavouriteCocktailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class FavouriteCocktailViewHolder(
    private val binding: ItemRandomCocktailBinding,
    private val viewModel: FavouriteCocktailViewModel
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(point: FavouriteDrink?) {
        binding.tvNameCock.text = point?.strDrink
        binding.tvIdCock.text = point?.idDrink
        binding.tvCategoryCock.text = point?.strCategory
        binding.tvTypeCock.text = point?.strAlcoholic
        binding.tvIngrCock1.text = point?.strIngredient1
        binding.tvIngrCock2.text = point?.strIngredient2
        binding.tvIngrCock3.text = point?.strIngredient3
        binding.tvIngrCock4.text = point?.strIngredient4
        binding.tvIngrCock5.text = point?.strIngredient5

        Picasso.get().load(point?.strDrinkThumb).into(binding.imCocktail, object : Callback{
            override fun onSuccess() {
                binding.progressImage.visibility = View.GONE
            }

            override fun onError(e: Exception?) {}
        })

        val scaleAnimation = ScaleAnimation(
            0.7f, 1.0f, 0.7f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f
        )
        scaleAnimation.duration = 500
        val bounceInterpolator = BounceInterpolator()
        scaleAnimation.interpolator = bounceInterpolator

        binding.checkbox.setOnClickListener {
            point?.isChecked = !point?.isChecked!!
            viewModel.update(point)
            binding.checkbox.startAnimation(scaleAnimation)
        }
        binding.checkbox.isChecked = point?.isChecked!!
    }
}