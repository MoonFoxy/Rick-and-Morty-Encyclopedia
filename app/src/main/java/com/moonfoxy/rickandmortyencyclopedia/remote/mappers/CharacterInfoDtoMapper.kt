package com.moonfoxy.rickandmortyencyclopedia.remote.mappers

import com.moonfoxy.rickandmortyencyclopedia.data.models.CharacterInfo
import com.moonfoxy.rickandmortyencyclopedia.remote.models.CharacterInfoDto
import javax.inject.Inject

class CharacterInfoDtoMapper @Inject constructor() : DtoMapper<CharacterInfoDto, CharacterInfo> {
    override fun mapFromModel(model: CharacterInfoDto): CharacterInfo {
        return with(model) {
            CharacterInfo(
                count = count,
                pages = pages
            )
        }
    }
}
