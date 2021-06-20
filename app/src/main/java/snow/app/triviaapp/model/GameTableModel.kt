package snow.app.triviaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GameData")
data class GameTableModel (

    @ColumnInfo(name = "name")
    var Name: String,

    @ColumnInfo(name = "cricketer")
    var Cricketer: String,


    @ColumnInfo(name = "colors")
    var Colors: String,


    @ColumnInfo(name = "date")
    var Date: String

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null

}