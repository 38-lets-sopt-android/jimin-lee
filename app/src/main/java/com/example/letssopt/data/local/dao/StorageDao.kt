package com.example.letssopt.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.letssopt.data.local.entity.StorageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StorageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStorageItems(storageEntity: StorageEntity)

    @Query("SELECT * FROM storage")
    fun getStorageItems(): Flow<List<StorageEntity>>

    @Delete
    suspend fun deleteStorageItems(item: StorageEntity)

    @Query("SELECT EXISTS(SELECT 1 FROM storage WHERE id = :id)")
    suspend fun isItemStored(id: Long): Boolean
}
