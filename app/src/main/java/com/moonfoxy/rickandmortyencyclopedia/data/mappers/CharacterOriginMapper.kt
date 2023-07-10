package com.moonfoxy.rickandmortyencyclopedia.data.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterOrigin
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterOriginEntity
import javax.inject.Inject

class CharacterOriginMapper @Inject constructor() : Mapper<CharacterOrigin, CharacterOriginEntity> {
    override fun mapFromModel(type: CharacterOrigin): CharacterOriginEntity {
        return with(type) {
            CharacterOriginEntity(
                name = name,
                url = url
            )
        }
    }

    override fun mapToModel(type: CharacterOriginEntity): CharacterOrigin {
        return with(type) {
            CharacterOrigin(
                name = name,
                url = url
            )
        }
    }
}