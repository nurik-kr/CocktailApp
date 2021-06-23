package kg.nurik.thecocktailapp.data.interactor

import kg.nurik.thecocktailapp.data.model.Cocktail
import kg.nurik.thecocktailapp.data.remote.CocktailService
import retrofit2.Response

interface Interactor {
    suspend fun loadRandomCocktail(): Response<Cocktail>
}

class InteractorImpl(private val api: CocktailService) : Interactor {

    override suspend fun loadRandomCocktail(): Response<Cocktail> {
        return api.loadRandomCocktail()
    }

}