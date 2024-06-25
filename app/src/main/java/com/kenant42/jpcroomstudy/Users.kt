package com.kenant42.jpcroomstudy

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "userstable")
data class Users(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name =  "user_id") @NotNull  var user_id: Int,
    @ColumnInfo(name = "user_name") @NotNull var user_name: String,
    @ColumnInfo(name = "user_age") @NotNull var user_age:Int,
    @ColumnInfo(name = "user_phone") @NotNull var user_phone:String,
    @ColumnInfo(name = "user_school") @NotNull var user_school:String
    ) {
}