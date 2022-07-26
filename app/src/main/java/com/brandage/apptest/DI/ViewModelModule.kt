package com.brandage.apptest.DI

import com.brandage.apptest.viewmodel.MyViewModel

val viewModelModule = module {
    viewModel {
        MyViewModel(get())
    }
    single { MyViewModel(get()) }
}