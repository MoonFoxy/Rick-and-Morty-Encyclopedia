package com.moonfoxy.rickandmortyencyclopedia.remote.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterOrigin
import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterOriginDto
import javax.inject.Inject

class CharacterOriginDtoMapper @Inject constructor() :
    DtoMapper<CharacterOriginDto, CharacterOrigin> {
    override fun mapFromModel(model: CharacterOriginDto): CharacterOrigin {
        return with(model) {
            CharacterOrigin(
                name = name,
                url = url
            )
        }
    }
}