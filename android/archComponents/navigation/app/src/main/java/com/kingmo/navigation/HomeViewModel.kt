package com.kingmo.navigation

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

class HomeViewModel : ViewModel() {
    val userNameLiveData: MutableLiveData<String> = MutableLiveData()
    lateinit var resources: Resources
    lateinit var listener: NextListener

    fun updateUserName(userName: String) = userNameLiveData.postValue(resources.getString(R.string.name_format, userName))

    fun navigateToDetails() = listener.onNextClick()
}

interface NextListener {
    fun onNextClick()
}
