package com.moonfoxy.rickandmortyencyclopedia.local.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterOrigin
import com.moonfoxy.rickandmortyencyclopedia.local.models.CharacterOriginEntity
import javax.inject.Inject

class CharacterOriginEntityMapper @Inject constructor() :
    EntityMapper<CharacterOriginEntity, CharacterOrigin> {
    override fun mapFromModel(model: CharacterOriginEntity): CharacterOrigin {
        return with(model) {
            CharacterOrigin(
                name = name,
                url = url
            )
        }
    }

    override fun mapToModel(entity: CharacterOrigin): CharacterOriginEntity {
        return with(entity) {
            CharacterOriginEntity(
                name = name,
                url = url
            )
        }
    }

}