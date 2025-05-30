package com.vladislaviliev.birthday.kid

import com.vladislaviliev.birthday.networking.NetworkState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class KidRepository(
    private val scope: CoroutineScope,
    private val dispatcher: CoroutineDispatcher,
    private val api: KidApi,
) {
    val networkState: Flow<NetworkState> = api.networkState

    suspend fun connect(ip: String, port: Int) = scope.launch(dispatcher) {
        api.connect(ip, port)
    }.join()
}