package kg.nurik.thecocktailapp.ui.bottomNav.random

import android.icu.number.NumberFormatter.with
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
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.databinding.ItemRandomCocktailBinding
import kg.nurik.thecocktailapp.utils.DiffUtils
import java.lang.Exception

class RandomCocktailAdapter(private val viewModel: RandomCocktailViewModel) :
    ListAdapter<Drink, RandomCocktailViewHolder>(DiffUtils.diffUtilRandomCockTail) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomCocktailViewHolder {
        val binding =
            ItemRandomCocktailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RandomCocktailViewHolder(binding, viewModel)
    }

    override fun onBindViewHolder(holder: RandomCocktailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class RandomCocktailViewHolder(
    private val binding: ItemRandomCocktailBinding,
    private val viewModel: RandomCocktailViewModel
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(point: Drink?) {
        binding.tvNameCock.text = point?.strDrink
        binding.tvIdCock.text = point?.idDrink
        binding.tvCategoryCock.text = point?.strCategory
        binding.tvTypeCock.text = point?.strAlcoholic
        binding.tvIngrCock1.text = point?.strIngredient1
        binding.tvIngrCock2.text = point?.strIngredient2
        binding.tvIngrCock3.text = point?.strIngredient3
        binding.tvIngrCock4.text = point?.strIngredient4
        binding.tvIngrCock5.text = point?.strIngredient5

        Picasso.get().load(point?.strDrinkThumb).into(binding.imCocktail, object : Callback {
            override fun onSuccess() {
                binding.progressImage.visibility = View.GONE
            }

            override fun onError(e: Exception?) {
            }
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