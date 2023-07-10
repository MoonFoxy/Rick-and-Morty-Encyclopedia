package com.moonfoxy.rickandmortyencyclopedia.remote.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterLocation
import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterLocationDto
import javax.inject.Inject

class CharacterLocationDtoMapper @Inject constructor() :
    DtoMapper<CharacterLocationDto, CharacterLocation> {
    override fun mapFromModel(model: CharacterLocationDto): CharacterLocation {
        return with(model) {
            CharacterLocation(
                name = name,
                url = url
            )
        }
    }
}