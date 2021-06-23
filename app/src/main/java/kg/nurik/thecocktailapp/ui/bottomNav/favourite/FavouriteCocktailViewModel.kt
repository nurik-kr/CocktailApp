package kg.nurik.thecocktailapp.ui.bottomNav.favourite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.thecocktailapp.data.local.CasheAppDatabase
import kg.nurik.thecocktailapp.data.model.FavouriteDrink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteCocktailViewModel(
    private val db: CasheAppDatabase
) : ViewModel() {

    fun update(item: FavouriteDrink) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao().updateFavourite(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage?: "no error message")
            }
        }
    }

    fun getAllFavouriteDrink(): LiveData<List<FavouriteDrink>> {
        return db.getCasheDao().getNewTableFavorite()
    }
}