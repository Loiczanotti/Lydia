package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Id
import com.loicz.lydiaproject.data.model.db.IdDBEntity
import javax.inject.Inject

class IdDBEntityDataMapper @Inject constructor(): BaseMapper<IdDBEntity, Id>() {
    override fun transformModelToDBEntity(input: Id): IdDBEntity {
        return IdDBEntity(
            name = input.name ?: "",
            value = input.value ?: ""
        )
    }

    override fun transformDBEntityToModel(input: IdDBEntity): Id {
        return Id(
            name = input.name,
            value = input.value
        )
    }
}