package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Picture
import com.loicz.lydiaproject.data.model.db.PictureDBEntity
import javax.inject.Inject

class PictureDBEntityDataMapper @Inject constructor(): BaseMapper<PictureDBEntity, Picture>() {
    override fun transformModelToDBEntity(input: Picture): PictureDBEntity {
        return PictureDBEntity(
            large = input.large,
            medium = input.medium,
            thumbnail = input.thumbnail
        )
    }

    override fun transformDBEntityToModel(input: PictureDBEntity): Picture {
        return Picture(
            large = input.large,
            medium = input.medium,
            thumbnail = input.thumbnail
        )
    }
}