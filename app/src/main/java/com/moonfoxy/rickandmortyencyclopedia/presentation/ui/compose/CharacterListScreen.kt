package com.moonfoxy.rickandmortyencyclopedia.presentation.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moonfoxy.rickandmortyencyclopedia.presentation.viewmodel.CharactersViewModel

@Preview
@Composable
fun CharacterListScreen(charactersViewModel: CharactersViewModel = hiltViewModel()) {

    val state = charactersViewModel.state.value

    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(state.characterList.size) { i ->
            CharacterItem(character = state.characterList[i], onItemClick = {})
        }
    }
}