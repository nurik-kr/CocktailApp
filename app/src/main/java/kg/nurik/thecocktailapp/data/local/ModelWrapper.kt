package kg.nurik.thecocktailapp.data.local

import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.model.FavouriteDrink


object ModelWrapper {
    fun drinkToFavouriteDrink(item: Drink) =
        FavouriteDrink(
            idDrink = item.idDrink,
            strDrink = item.strDrink,
            strCategory = item.strCategory,
            strGlass = item.strGlass,
            strIBA = item.strIBA,
            strAlcoholic = item.strAlcoholic,
            strInstructions = item.strInstructions,
            strInstructionsDE = item.strInstructionsDE,
            strInstructionsIT = item.strInstructionsIT,
            strDrinkThumb = item.strDrinkThumb,
            strIngredient1 = item.strIngredient1,
            strIngredient2 = item.strIngredient2,
            strIngredient3 = item.strIngredient3,
            strIngredient4 = item.strIngredient4,
            strIngredient5 = item.strIngredient5,
            isChecked = item.isChecked
        )



    fun favouriteDrinkToDrink(item: FavouriteDrink) =
        Drink(
            idDrink = item.idDrink,
            strDrink = item.strDrink,
            strCategory = item.strCategory,
            strGlass = item.strGlass,
            strIBA = item.strIBA,
            strAlcoholic = item.strAlcoholic,
            strInstructions = item.strInstructions,
            strInstructionsDE = item.strInstructionsDE,
            strInstructionsIT = item.strInstructionsIT,
            strDrinkThumb = item.strDrinkThumb,
            strIngredient1 = item.strIngredient1,
            strIngredient2 = item.strIngredient2,
            strIngredient3 = item.strIngredient3,
            strIngredient4 = item.strIngredient4,
            strIngredient5 = item.strIngredient5,
            isChecked = item.isChecked
        )
}
