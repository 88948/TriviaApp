package snow.app.triviaapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_name.*
import kotlinx.android.synthetic.main.activity_name.tvNext
import kotlinx.android.synthetic.main.activity_select_cricketer.*
import snow.app.triviaapp.R
import snow.app.triviaapp.utils.AppConstants

class SelectCricketerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_cricketer)
        listners()
    }

    fun listners() {

        //next button click
        tvNext.setOnClickListener {
            getSelectedCricketer()
        }







    }




    fun getSelectedCricketer(){
        var id: Int = radiogroup.checkedRadioButtonId
        if (id!=-1){
            // If any radio button checked from radio group
            // Get the instance of radio button using id
            val radio: RadioButton = findViewById(id)
            startActivity(Intent(this, SelectColorsActivity::class.java)
                .putExtra("cricketer",radio.text).putExtra("name",intent.getStringExtra("name")))
        }else{
            AppConstants.showToast(this@SelectCricketerActivity,"Please choose best cricketer in the world")
        }



    }
}