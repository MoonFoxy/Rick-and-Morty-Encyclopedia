package com.moonfoxy.rickandmortyencyclopedia.data.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterLocation
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterLocationEntity
import javax.inject.Inject

class CharacterLocationMapper @Inject constructor() :
    Mapper<CharacterLocation, CharacterLocationEntity> {
    override fun mapFromModel(type: CharacterLocation): CharacterLocationEntity {
        return with(type) {
            CharacterLocationEntity(
                name = name,
                url = url
            )
        }
    }

    override fun mapToModel(type: CharacterLocationEntity): CharacterLocation {
        return with(type) {
            CharacterLocation(
                name = name,
                url = url
            )
        }
    }
}