package com.moonfoxy.rickandmortyencyclopedia.remote.mappers

interface DtoMapper<M, E> {
    fun mapFromModel(model: M): E
}