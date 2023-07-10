package com.moonfoxy.rickandmortyencyclopedia.data.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterEntity
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val characterOriginMapper: CharacterOriginMapper,
    private val characterLocationMapper: CharacterLocationMapper
) : Mapper<Character, CharacterEntity> {
    override fun mapFromModel(type: Character): CharacterEntity {
        return with(type) {
            CharacterEntity(
                id = id,
                name = name,
                status = status,
                species = species,
                type = this@with.type,
                gender = gender,
                origin = characterOriginMapper.mapFromModel(origin),
                location = characterLocationMapper.mapFromModel(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }
    }

    override fun mapToModel(type: CharacterEntity): Character {
        return with(type) {
            Character(
                id = id,
                name = name,
                status = status,
                species = species,
                type = this@with.type,
                gender = gender,
                origin = characterOriginMapper.mapToModel(origin),
                location = characterLocationMapper.mapToModel(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }    }
}