package snow.app.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_name.*
import snow.app.triviaapp.R
import snow.app.triviaapp.utils.AppConstants

class NameActivity : AppCompatActivity() {
    var alertDialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        // click listners
        listners()
    }

    fun listners() {

        //next button click listner
        tvNext.setOnClickListener {

            if (edName.text.toString().isEmpty()) {
                AppConstants.showToast(
                    this@NameActivity,
                    resources.getString(R.string.please_enter_name)
                )
            }else{
                startActivity(
                    Intent(this, SelectCricketerActivity::class.java).putExtra(
                        "name",
                        edName.text.toString()
                    )
                )
            }

        }


    }

    override fun onBackPressed() {
        showExitAlert()

    }

    private fun showExitAlert() {
        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Exit")
        //set message for alert dialog
        builder.setMessage("Are you sure you want to quit the test and exit the app?")

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