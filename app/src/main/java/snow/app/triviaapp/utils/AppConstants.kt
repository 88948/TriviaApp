package snow.app.triviaapp.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class AppConstants {
    companion object {
        //show toast

        fun showToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }



        //get curent date
        fun getCurrentDate( ): String? {


            var day = 0
             try {
                 val cal = Calendar.getInstance()


                day = cal[Calendar.DATE]
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return when (day % 10) {
                1 -> SimpleDateFormat("d'st' MMMM hh:ss a").format(Date())
                2 -> SimpleDateFormat("d'nd' MMMM hh:ss a").format(Date())
                3 -> SimpleDateFormat("d'rd' MMMM hh:ss a").format(Date())
                else -> SimpleDateFormat("d'th' MMMM hh:ss a").format(Date())
            }
        }




    }
}