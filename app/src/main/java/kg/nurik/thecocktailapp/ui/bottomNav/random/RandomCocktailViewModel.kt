package kg.nurik.thecocktailapp.ui.bottomNav.random

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.thecocktailapp.data.local.CasheAppDatabase
import kg.nurik.thecocktailapp.data.local.ModelWrapper
import kg.nurik.thecocktailapp.data.model.Cocktail
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RandomCocktailViewModel(
    private val repository: Repository,
    private val db: CasheAppDatabase
) : ViewModel() {

    val progress = MutableLiveData<Boolean>(false)
    val allAds = MutableLiveData<Cocktail>()
    val swipeRefresh = MutableLiveData<Boolean>(false)

    init {
        loadAds()
    }

    fun loadAds() {
        viewModelScope.launch(Dispatchers.IO) {
            progress.postValue(true)
            swipeRefresh.postValue(true)
            runCatching {
                val result = repository.loadRandomCocktail()
                if (result.isSuccessful) allAds.postValue(result.body())
                result.body()?.drinks?.let { db.getCasheDao().insertCocktail(it) }
                progress.postValue(false)
                swipeRefresh.postValue(false)
            }.onFailure {
                progress.postValue(false)
                swipeRefresh.postValue(false)
                Log.d("loadAds", it.localizedMessage ?: "error request")
            }
        }
    }


    fun update(item: Drink) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao().update(item)
                insertFavourite(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }

    private fun insertFavourite(item: Drink) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao()
                    .insertFavouriteCocktail(ModelWrapper.drinkToFavouriteDrink(item))
            }.onFailure {
                Log.d("FavouriteCommands", it.localizedMessage ?: "no error message")
            }
        }
    }
}