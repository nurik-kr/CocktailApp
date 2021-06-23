package kg.nurik.thecocktailapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.model.FavouriteDrink

@Dao
interface CasheDao {

    @Transaction
    fun deleteAndInsertCocktail(data: List<Drink>) {
        deleteAllCocktail()
        insertCocktail(data)
    }

    @Update
    fun update(item: Drink)

    @Update
    fun deleteStoryItem(item: Drink)

    @Update
    fun updateFavourite(item: FavouriteDrink)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCocktail(data: List<Drink>)

    @Query("DELETE FROM drink")
    fun deleteAllCocktail()

    @Delete()
    fun deleteItemStory(item: Drink)

    @Query("SELECT * FROM drink")
    fun getAllCocktail(): LiveData<List<Drink>>

    @Query("SELECT ALL * FROM FavouriteDrink WHERE isChecked")
    fun getNewTableFavorite(): LiveData<List<FavouriteDrink>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavouriteCocktail(data: FavouriteDrink)

    @Query("SELECT * FROM drink ORDER BY idDrink DESC limit 10")
    fun getStoryCocktail(): LiveData<List<Drink>>
}