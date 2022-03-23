package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Name
import com.loicz.lydiaproject.data.model.db.NameDBEntity
import javax.inject.Inject

class NameDBEntityDataMapper @Inject constructor(): BaseMapper<NameDBEntity, Name>() {
    override fun transformModelToDBEntity(input: Name): NameDBEntity {
        return NameDBEntity(
            title = input.title,
            first = input.first,
            last = input.last
        )
    }

    override fun transformDBEntityToModel(input: NameDBEntity): Name {
        return Name(
            title = input.title,
            first = input.first,
            last = input.last
        )
    }
}