package snow.app.triviaapp.view.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_row.view.*
import snow.app.triviaapp.R
import snow.app.triviaapp.model.GameTableModel


class HistoryAdapter(
    var context: Context,
    val gamesList: MutableList<GameTableModel>
) :

    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.history_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //set text
        holder.tvGameDate.text = "GAME "+gamesList.get(position).Id +" : " +gamesList.get(position).Date
        holder.tvName.text =  "Name: "+gamesList.get(position).Name
        holder.tvFirstAns.text =  "Answer: "+gamesList.get(position).Cricketer
        holder.tvSecondAns.text =  "Answer: "+gamesList.get(position).Colors



    }

    override fun getItemCount(): Int {
        return gamesList.size
    }


    inner class MyViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
         var tvGameDate = view!!.tvGameDate
         var tvName = view!!.tvName
         var tvFirstAns = view!!.tvFirstAns
         var tvSecondAns = view!!.tvSecondAns

    }


}