package com.kenant42.jpcroomstudy

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.nio.file.attribute.UserPrincipal

@Database(entities = [Users::class],version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun usersDAO():UsersDaoInterface

    companion object{
        var INSTANCE:Veritabani? = null

        fun accessDB(context: Context):Veritabani?{
            if (INSTANCE == null){

                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabani::class.java,
                        "users.sqlite").createFromAsset("users.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}