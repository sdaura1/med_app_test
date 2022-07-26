package com.brandage.apptest.DI

import com.brandage.apptest.repository.MyRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

val repositoryModule = module {
    single { MyRepository(get()) }
}