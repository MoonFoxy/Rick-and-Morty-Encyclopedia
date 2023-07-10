package com.moonfoxy.rickandmortyencyclopedia.data.mappers

interface Mapper<M, E> {
    fun mapFromModel(type: M): E
    fun mapToModel(type: E): M
}