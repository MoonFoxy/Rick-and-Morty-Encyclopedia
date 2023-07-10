package com.moonfoxy.rickandmortyencyclopedia.local.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterLocation
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterLocationEntity
import javax.inject.Inject

class CharacterLocationEntityMapper @Inject constructor() :
    EntityMapper<CharacterLocationEntity, CharacterLocation> {
    override fun mapFromModel(model: CharacterLocationEntity): CharacterLocation {
        return with(model) {
            CharacterLocation(
                name = name,
                url = url
            )
        }
    }

    override fun mapToModel(entity: CharacterLocation): CharacterLocationEntity {
        return with(entity) {
            CharacterLocationEntity(
                name = name,
                url = url
            )
        }
    }

}