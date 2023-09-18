package com.sathruwan.notes.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sathruwan.notes.dao.NotesDao
import com.sathruwan.notes.database.Migration.DataBaseVersion
import com.sathruwan.notes.model.Notes
import com.sathruwan.notes.utils.OwnConvertor

@Database(entities = [Notes::class] , version = DataBaseVersion, exportSchema = true)
@TypeConverters(OwnConvertor::class)
abstract class NotesDatabase : RoomDatabase()
{
    abstract fun getDaoInstance() : NotesDao

}