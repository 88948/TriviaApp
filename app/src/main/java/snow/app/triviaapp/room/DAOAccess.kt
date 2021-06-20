package snow.app.triviaapp.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
 import snow.app.triviaapp.model.GameTableModel

@Dao
interface DAOAccess {


    //insert data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(gameTableModel: GameTableModel)

    //get games list from db

    @Query("SELECT * FROM GameData")
    fun getGameHistory() :  LiveData<List<GameTableModel>>

}