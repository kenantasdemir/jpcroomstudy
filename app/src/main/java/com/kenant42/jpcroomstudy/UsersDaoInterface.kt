package com.kenant42.jpcroomstudy

import androidx.room.*

@Dao
interface UsersDaoInterface {

    @Query("SELECT * FROM userstable")
    suspend fun getAllUsers():List<Users>

    @Insert
    suspend fun saveUser(user:Users)

    @Update
    suspend fun updateUser(user: Users)

    @Query("DELETE FROM userstable WHERE user_id = :id")
    suspend fun deleteUser(id: Int)

    @Query("SELECT * FROM userstable ORDER BY RANDOM() LIMIT 5")
    suspend fun getRandomUser():Users

    @Query("SELECT * FROM userstable WHERE user_name LIKE '%' || :wordToBeSearched || '%'")
    suspend fun recordCheck(wordToBeSearched: String):List<Users>

    @Query("SELECT * FROM userstable WHERE user_id = :id")
    suspend fun getUserById(id:Int):Users

    @Query("SELECT COUNT(*) FROM userstable WHERE user_name = :username")
    suspend fun getMatchingRecordCount(username:String):Int

   // @Query("DROP TABLE userstable")
  //  suspend fun deleteDB()

}