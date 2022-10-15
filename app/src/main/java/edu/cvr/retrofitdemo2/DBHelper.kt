package edu.cvr.retrofitdemo2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import java.sql.SQLException

@RequiresApi(Build.VERSION_CODES.P)
class DBHelper(
    context: Context?,
    factory: SQLiteDatabase.CursorFactory,
) : SQLiteOpenHelper(context, "Mydb", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        try{
            db!!.execSQL("CREATE TABLE Demo (Name TEXT, RollNo TEXT)")
        }catch (e: SQLException){
            e.printStackTrace()
        }

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS Demo")
        onCreate(db)
    }

    fun list():ArrayList<String>{
        val db = this.readableDatabase
        val data = ArrayList<String>()
        val curs = db.rawQuery("SELECT * FROM Demo",null)
        if(curs!!.moveToFirst()){
            do {
                val name = curs!!.getString(0)

                data.add(name)
            } while(curs!!.moveToNext())
        }
        curs!!.close()
        return data
    }
}