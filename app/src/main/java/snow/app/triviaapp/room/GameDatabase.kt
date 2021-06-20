package com.example.room.mvvm.room

import android.content.Context
import androidx.room.*
 import snow.app.triviaapp.model.GameTableModel
import snow.app.triviaapp.room.DAOAccess

@Database(entities = arrayOf(GameTableModel::class), version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {

    abstract fun gameDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: GameDatabase? = null

        fun getDatabaseClient(context: Context) : GameDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, GameDatabase::class.java, "GAME_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}