package com.pro.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.pro.Model.User
import com.pro.dao.DBHelper.cuentasDB.usuarios.COLUMN_CONTRA
import com.pro.dao.DBHelper.cuentasDB.usuarios.COLUMN_NOMBRE
import com.pro.dao.DBHelper.cuentasDB.usuarios.DATABASE_NAME
import com.pro.dao.DBHelper.cuentasDB.usuarios.DATABASE_VERSION
import com.pro.dao.DBHelper.cuentasDB.usuarios.TABLE_NAME
import java.lang.Exception

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    object cuentasDB {
        object usuarios : BaseColumns {
            const val DATABASE_NAME = "personas.db"
            const val TABLE_NAME = "usuarios"
            const val DATABASE_VERSION = 1
            const val COLUMN_NOMBRE = "nombre"
            const val COLUMN_CONTRA = "contra"
        }

        // query final. QUERY ES UNA ORDEN PARA LA BASE DE DATOS
        // "CREATE TABLE personas.db (id INTEGER PRIMARY KEY, nombre TEXT, contra TEXT)"


        // val query = "CREATE TABLE " + DATABASE_NAME + "(${BaseColumns._ID} INTEGER PRIMARY KEY, nombre TEXT, contra TEXT)"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable =
            "CREATE TABLE ${TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${COLUMN_NOMBRE} TEXT," +
                    "${COLUMN_CONTRA} TEXT)"

        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun saveUsuario(usuario: User) : Boolean {

        val values = ContentValues()

        values.put(COLUMN_NOMBRE, usuario.name)
        values.put(COLUMN_CONTRA, usuario.pass)

        return try {
            this.writableDatabase.insert(TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getUsuario(usuario: User) : Boolean {
        return try {

            //SELECT * FROM table_name WHERE nombre = 'licha' AND contra = '123'

            val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_NOMBRE = '${usuario.name}' AND $COLUMN_CONTRA = '${usuario.pass}'"

           this.readableDatabase.rawQuery(query, null, null).moveToFirst()
        } catch (e: Exception) {
            false
        }
    }

}