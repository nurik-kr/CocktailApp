package kg.nurik.thecocktailapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kg.nurik.thecocktailapp.data.model.Drink
import kg.nurik.thecocktailapp.data.model.FavouriteDrink

@Database(entities = [Drink::class, FavouriteDrink::class], version = 3)
abstract class CasheAppDatabase : RoomDatabase() {
    abstract fun getCasheDao(): CasheDao

    companion object {
        fun getInstanceDB(context: Context): CasheAppDatabase {
            return Room.databaseBuilder(context, CasheAppDatabase::class.java, "myDb")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}