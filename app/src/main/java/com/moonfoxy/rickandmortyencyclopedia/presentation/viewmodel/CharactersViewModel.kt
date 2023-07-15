package com.moonfoxy.rickandmortyencyclopedia.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moonfoxy.rickandmortyencyclopedia.domain.model.CharacterListUIState
import com.moonfoxy.rickandmortyencyclopedia.domain.usecase.GetCharacterListUseCase
import com.moonfoxy.rickandmortyencyclopedia.remote.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CharacterListUIState())
    val state: State<CharacterListUIState> = _state

    init {
        getCharacterList()
    }

    fun getCharacterList() {
        viewModelScope.launch {

            getCharacterListUseCase().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            characterList = result.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            characterList = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            characterList = result.data ?: emptyList(),
                            isLoading = false
                        )

                    }
                }
            }.launchIn(this)
        }
    }
}