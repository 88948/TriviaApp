package snow.app.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_select_colors.*
import kotlinx.android.synthetic.main.activity_select_cricketer.*
import kotlinx.android.synthetic.main.activity_select_cricketer.rbOptionOne
import snow.app.triviaapp.R
import snow.app.triviaapp.utils.AppConstants

class SelectColorsActivity : AppCompatActivity() {
    var selectColorsList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_colors)

        listerners()
    }


    fun listerners() {

        //option one click listner
        rbOptionOne.setOnClickListener {

            if (selectColorsList.contains(rbOptionOne.text.toString())) {
                rbOptionOne.isChecked = false
                selectColorsList.remove(rbOptionOne.text.toString())
            } else {
                rbOptionOne.isChecked = true
                selectColorsList.add(rbOptionOne.text.toString())
            }


        }


        //option two click listner
        rbOptionTwoColor.setOnClickListener {


            if (selectColorsList.contains(rbOptionTwoColor.text.toString())) {
                rbOptionTwoColor.isChecked = false
                selectColorsList.remove(rbOptionTwoColor.text.toString())
            } else {
                rbOptionTwoColor.isChecked = true
                selectColorsList.add(rbOptionTwoColor.text.toString())
            }


        }


        //option three click listner
        rbOptionthreeColor.setOnClickListener {


            if (selectColorsList.contains(rbOptionthreeColor.text.toString())) {
                rbOptionthreeColor.isChecked = false
                selectColorsList.remove(rbOptionthreeColor.text.toString())
            } else {
                rbOptionthreeColor.isChecked = true
                selectColorsList.add(rbOptionthreeColor.text.toString())
            }


        }


        //option four click listner
        rbOptiontFourColor.setOnClickListener {


            if (selectColorsList.contains(rbOptiontFourColor.text.toString())) {
                rbOptiontFourColor.isChecked = false
                selectColorsList.remove(rbOptiontFourColor.text.toString())
            } else {
                rbOptiontFourColor.isChecked = true
                selectColorsList.add(rbOptiontFourColor.text.toString())
            }


        }




        tvNextColors.setOnClickListener {

            if (selectColorsList.size == 0) {
                AppConstants.showToast(
                    this@SelectColorsActivity,
                    "Please select at least one color"
                )
            } else {
                if (intent.hasExtra("name")) {
                    var selectedColors = TextUtils.join(",", selectColorsList)
                    startActivity(
                        Intent(this@SelectColorsActivity, SummaryActivity::class.java)
                            .putExtra("name", intent.getStringExtra("name"))
                            .putExtra("cricketer", intent.getStringExtra("cricketer"))
                            .putExtra("selectedColors", selectedColors)
                    )
                }
            }


        }
    }


}