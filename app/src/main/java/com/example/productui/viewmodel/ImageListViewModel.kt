package com.example.productui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.productui.R
import com.example.productui.model.ImageList

class ImageListViewModel : ViewModel() {
    var imageList : MutableLiveData<MutableList<ImageList>> =MutableLiveData()

    init {
        imageList.value = createImageList()
    }

    fun getImageList() :LiveData<MutableList<ImageList>>{
        return imageList
    }

    private fun createImageList() : MutableList<ImageList>{
        val imageList = mutableListOf<ImageList>()

        imageList.add(ImageList(R.drawable.wheels1))
        imageList.add(ImageList(R.drawable.wheels2))
        imageList.add(ImageList(R.drawable.wheels3))
        imageList.add(ImageList(R.drawable.wheels4))
        imageList.add(ImageList(R.drawable.wheels5))

        return imageList
    }
}