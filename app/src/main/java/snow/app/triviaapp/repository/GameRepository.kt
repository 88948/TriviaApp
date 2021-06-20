package com.example.room.mvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.room.mvvm.room.GameDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import snow.app.triviaapp.model.GameTableModel

class GameRepository {

    companion object {

        var gameDatabase: GameDatabase? = null
        var gameTableModel: LiveData<List<GameTableModel>>? = null

        fun initializeDB(context: Context): GameDatabase {
            return GameDatabase.getDatabaseClient(context)
        }


        //insert data into table
        fun insertData(
            context: Context,
            name: String,
            cricketer: String,
            color: String,
            date: String
        ) {

            gameDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val gameDetails = GameTableModel(name, cricketer, color, date)
                gameDatabase!!.gameDao().InsertData(gameDetails)
            }

        }


        //get game history
        fun getGameHistory(context: Context): LiveData<List<GameTableModel>>? {

            gameDatabase = initializeDB(context)

            gameTableModel = gameDatabase!!.gameDao().getGameHistory()

            return gameTableModel
        }

    }
}