package com.vladislaviliev.birthday.screens.connect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vladislaviliev.birthday.kid.KidRepository
import com.vladislaviliev.birthday.networking.NetworkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repository: KidRepository) : ViewModel() {

    val networkState = repository.networkState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NetworkState.Disconnected())

    fun connect(ip: String, port: Int) {
        viewModelScope.launch { repository.connect(ip, port) }
    }
}