package com.vladislaviliev.birthday.test

import com.vladislaviliev.birthday.kid.text.Repository
import com.vladislaviliev.birthday.kid.text.Text
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DummyTextRepository : Repository {

    private val _text: MutableStateFlow<Text?> = MutableStateFlow(null)
    override val text = _text.asStateFlow()

    suspend fun emit(t: Text?) {
        _text.emit(t)
    }
}