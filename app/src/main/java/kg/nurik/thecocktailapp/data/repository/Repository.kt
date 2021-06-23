package kg.nurik.thecocktailapp.data.repository

import android.util.Log
import kg.nurik.thecocktailapp.data.interactor.Interactor
import kg.nurik.thecocktailapp.data.local.CasheAppDatabase
import kg.nurik.thecocktailapp.data.model.Cocktail
import org.koin.android.ext.koin.ERROR_MSG
import retrofit2.Response

interface Repository {
    suspend fun loadRandomCocktail():Response<Cocktail>
}

class RepositoryImpl(
    private val network: Interactor,
    private val db: CasheAppDatabase
) : Repository {

    override suspend fun loadRandomCocktail(): Response<Cocktail> {
        return network.loadRandomCocktail()
//        try {
//            result.body()?.let { db.getCasheDao().deleteAndInsertCocktail(it.drinks) }
//        } catch (e: Exception) {
//            Log.d("DrinkError", e.localizedMessage ?: ERROR_MSG)
//        }
    }
}