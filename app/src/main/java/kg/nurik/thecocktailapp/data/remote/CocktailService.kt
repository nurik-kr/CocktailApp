package kg.nurik.thecocktailapp.data.remote

import kg.nurik.thecocktailapp.data.model.Cocktail
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface CocktailService {

    @GET("random.php")
    suspend fun loadRandomCocktail(): Response<Cocktail>

}

