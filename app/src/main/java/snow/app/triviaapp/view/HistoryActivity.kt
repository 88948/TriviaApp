package snow.app.triviaapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import snow.app.triviaapp.R
import snow.app.triviaapp.model.GameTableModel
import snow.app.triviaapp.model.HistoryModel
import snow.app.triviaapp.utils.AppConstants
import snow.app.triviaapp.view.adapters.HistoryAdapter
import snow.app.triviaapp.viewmodel.HistoryViewModel
import snow.app.triviaapp.viewmodel.SummrayViewModel

class HistoryActivity : AppCompatActivity() {
    lateinit var historyViewModel: HistoryViewModel
    var arrayList: ArrayList<GameTableModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        //initialisations
        init()

        //set history adapter
        setAdapter()
    }

    fun init() {
        historyViewModel = ViewModelProvider(this).get(HistoryViewModel::class.java)
    }

    fun setAdapter() {


        historyViewModel.getHistories(this)!!.observe(this, Observer {
            if (it != null) {
                arrayList.clear()
                arrayList.addAll(it)
                rvHistory.setLayoutManager(LinearLayoutManager(this));
                rvHistory.adapter =
                    this.let { HistoryAdapter(it, arrayList) }
            } else {
                Log.e("it else", "--" + it)
            }

        })

    }
}