// ktlint-disable filename
package com.example.hazardhunt.core.localstorage.di

import android.content.Context
import androidx.room.Room
import com.example.hazardhunt.core.localstorage.Safetaskdao
import com.example.hazardhunt.core.localstorage.Safetaskdatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Datamodule {

    @Provides
    fun providePersistentSafetyTask(
        @ApplicationContext
        context: Context,
    ): Safetaskdatabase {
        return Room.databaseBuilder(
            context,
            Safetaskdatabase::class.java,
            "safety-task-database",

        ).build()
    }

    @Provides
    fun taskdao(
        database: Safetaskdatabase,
    ): Safetaskdao {
        return database.taskDao()
    }
}
