package com.example.productui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.productui.viewmodel.ImageListViewModel

class ImageListViewModelProviderFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageListViewModel::class.java)){
            return ImageListViewModel() as T
        }
        throw IllegalArgumentException ("UnknownViewModel")
    }
}