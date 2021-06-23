package kg.nurik.thecocktailapp.ui.bottomNav.story

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.nurik.thecocktailapp.data.local.CasheAppDatabase
import kg.nurik.thecocktailapp.data.model.Drink
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel(
    private val db: CasheAppDatabase
) : ViewModel() {

    fun update(item: Drink) {
        viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                db.getCasheDao().deleteItemStory(item)
            }.onFailure {
                Log.d("commands", it.localizedMessage ?: "no error message")
            }
        }
    }

    fun getStoryCocktail(): LiveData<List<Drink>> {
        return db.getCasheDao().getStoryCocktail()
    }
}