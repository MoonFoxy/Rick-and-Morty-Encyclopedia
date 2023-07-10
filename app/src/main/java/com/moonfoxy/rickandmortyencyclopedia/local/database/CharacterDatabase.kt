package com.moonfoxy.rickandmortyencyclopedia.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moonfoxy.rickandmortyencyclopedia.local.dao.CharacterDao
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterEntity
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterLocationEntity
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterOriginEntity
import com.moonfoxy.rickandmortyencyclopedia.local.util.LocalConstants.DB_NAME
import javax.inject.Inject

@Database(
    entities = [CharacterEntity::class, CharacterLocationEntity::class, CharacterOriginEntity::class],
    version = CharactersDatabase.VERSION,
    exportSchema = false
)
abstract class CharactersDatabase @Inject constructor() : RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDao

    companion object {
        const val VERSION = 1

        @Volatile
        private var INSTANCE: CharactersDatabase? = null

        fun getInstance(context: Context): CharactersDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CharactersDatabase::class.java,
            DB_NAME
        ).build()
    }
}
