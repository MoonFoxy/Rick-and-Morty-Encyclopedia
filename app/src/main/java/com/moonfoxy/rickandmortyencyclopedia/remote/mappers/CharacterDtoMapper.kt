package com.moonfoxy.rickandmortyencyclopedia.remote.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterDto
import javax.inject.Inject

class CharacterDtoMapper @Inject constructor(
    private val characterOriginDtoMapper: CharacterOriginDtoMapper,
    private val characterLocationDtoMapper: CharacterLocationDtoMapper
) : DtoMapper<CharacterDto, Character> {
    override fun mapFromModel(model: CharacterDto): Character {
        return with(model) {
            Character(
                id = id,
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender,
                origin = characterOriginDtoMapper.mapFromModel(origin),
                location = characterLocationDtoMapper.mapFromModel(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }
    }
}