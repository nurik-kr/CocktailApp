package kg.nurik.thecocktailapp.utils

import androidx.recyclerview.widget.DiffUtil
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.model.FavouriteDrink

object DiffUtils {

    val diffUtilRandomCockTail = object : DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(
            oldItem: Drink,
            newItem: Drink
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: Drink,
            newItem: Drink
        ): Boolean {
            return oldItem.idDrink == newItem.idDrink &&
            return oldItem.strDrink == newItem.strDrink &&
            return oldItem.strCategory == newItem.strCategory &&
            return oldItem.strAlcoholic == newItem.strAlcoholic
        }
    }

    val diffUtilFavouriteCockTail = object : DiffUtil.ItemCallback<FavouriteDrink>() {
        override fun areItemsTheSame(
            oldItem: FavouriteDrink,
            newItem: FavouriteDrink
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: FavouriteDrink,
            newItem: FavouriteDrink
        ): Boolean {
            return oldItem.idDrink == newItem.idDrink &&
                    return oldItem.strDrink == newItem.strDrink &&
                            return oldItem.strCategory == newItem.strCategory &&
                                    return oldItem.strAlcoholic == newItem.strAlcoholic
        }
    }
}