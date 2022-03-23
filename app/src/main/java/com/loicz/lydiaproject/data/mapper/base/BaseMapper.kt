package com.loicz.lydiaproject.data.mapper.base

abstract class BaseMapper<K, T> {

    fun transformModelListToDBEntity(input: List<T>): List<K> {
        return input.mapNotNull {
            try {
                transformModelToDBEntity(it)
            } catch (e: Exception) {
                null
            }
        }
    }

    fun transformDBEntityToModelList(input: List<K>): List<T> {
        return input.mapNotNull {
            try {
                transformDBEntityToModel(it)
            } catch (e: Exception) {
                null
            }
        }
    }

    abstract fun transformModelToDBEntity(input: T): K
    abstract fun transformDBEntityToModel(input: K): T
}