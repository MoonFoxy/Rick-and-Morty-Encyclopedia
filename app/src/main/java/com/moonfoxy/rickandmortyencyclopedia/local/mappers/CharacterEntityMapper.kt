package com.moonfoxy.rickandmortyencyclopedia.local.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.Character
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterEntity
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor(
    private val characterOriginEntityMapper: CharacterOriginEntityMapper,
    private val characterLocationEntityMapper: CharacterLocationEntityMapper
) : EntityMapper<CharacterEntity, Character> {
    override fun mapFromModel(model: CharacterEntity): Character {
        return with(model) {
            Character(
                id = id,
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender,
                origin = characterOriginEntityMapper.mapFromModel(origin),
                location = characterLocationEntityMapper.mapFromModel(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }
    }

    override fun mapToModel(entity: Character): CharacterEntity {
        return with(entity) {
            CharacterEntity(
                id = id,
                name = name,
                status = status,
                species = species,
                type = type,
                gender = gender,
                origin = characterOriginEntityMapper.mapToModel(origin),
                location = characterLocationEntityMapper.mapToModel(location),
                image = image,
                episode = episode,
                url = url,
                created = created
            )
        }
    }
}