package snow.app.triviaapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
 import com.example.room.mvvm.repository.GameRepository
 import snow.app.triviaapp.model.GameTableModel

class SummrayViewModel : ViewModel() {

    var liveDataGame: LiveData<GameTableModel>? = null

    fun insertData(context: Context, name: String, cricketer: String, colors: String, date: String) {
       GameRepository.insertData(context, name,cricketer,colors,date)
    }


}