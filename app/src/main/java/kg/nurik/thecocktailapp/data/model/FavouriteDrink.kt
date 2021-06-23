package kg.nurik.thecocktailapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class FavouriteDrink(
    @PrimaryKey
    val idDrink: String,
    val strDrink: String?,
    val strCategory: String?,
    val strGlass: String?,
    val strIBA: String?,
    val strAlcoholic: String?,
    val strInstructions: String?,
    val strInstructionsDE: String?,
    val strInstructionsIT: String?,
    val strDrinkThumb: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    var isChecked: Boolean
) : Parcelable