package snow.app.triviaapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
 import com.example.room.mvvm.repository.GameRepository
 import snow.app.triviaapp.model.GameTableModel

class HistoryViewModel : ViewModel() {

    var liveDataGame:LiveData<List<GameTableModel>>? = null


    fun getHistories(context: Context) :LiveData<List<GameTableModel>>? {
        liveDataGame = GameRepository.getGameHistory(context)
        return liveDataGame
    }


}