package snow.app.triviaapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_summary.*
import snow.app.triviaapp.R
import snow.app.triviaapp.utils.AppConstants
import snow.app.triviaapp.viewmodel.SummrayViewModel

class SummaryActivity : AppCompatActivity() {
    lateinit var summrayViewModel: SummrayViewModel
    var alertDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        //initialisationsLoginViewModel
        init()
        //bind data from intent
        bindData()

        //click listners
        listners()
    }

    fun init() {
         summrayViewModel = ViewModelProvider(this).get(SummrayViewModel::class.java)


    }


    fun listners() {
        //finish button click listner
        tvFinish.setOnClickListener {
            startActivity(Intent(this@SummaryActivity, NameActivity::class.java))
            finishAffinity()
        }

        tvHistory.setOnClickListener {
            startActivity(Intent(this@SummaryActivity, HistoryActivity::class.java))
        }
    }

    fun bindData() {

        //get data from intent
        if (intent.hasExtra("name")) {


              tvName.setText(getString(R.string.hello) + " " + intent.getStringExtra("name") + ",")
            tvFirstAns.setText(getString(R.string.answer) + " " + intent.getStringExtra("cricketer"))
            tvSecondAns.setText(getString(R.string.answer) + " " + intent.getStringExtra("selectedColors"))
        }


        //save data in database
        summrayViewModel.insertData(
            this@SummaryActivity,
            intent.getStringExtra("name").toString(),
            intent.getStringExtra("cricketer").toString(),
            intent.getStringExtra("selectedColors").toString(),
            AppConstants.getCurrentDate().toString()
        )


    }

    override fun onBackPressed() {
//show exit alert
        showExitAlert()
    }


    private fun showExitAlert() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Exit")
        //set message for alert dialog
        builder.setMessage("Are you sure you want to exit the app ? Or if you want to give the test again you can click on finish.")

        //performing positive action
        builder.setPositiveButton("Exit app") { dialogInterface, which ->
            alertDialog?.dismiss()
            finishAffinity()
        }

        builder.setNegativeButton("Continue") { dialogInterface, which ->
            alertDialog?.dismiss()
        }
        // Create the AlertDialog
        alertDialog = builder.create()
        // Set other dialog properties
        alertDialog?.setCancelable(false)
        alertDialog?.show()
    }

}