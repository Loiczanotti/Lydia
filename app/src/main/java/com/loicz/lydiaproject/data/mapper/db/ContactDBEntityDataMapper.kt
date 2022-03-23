package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Contact
import com.loicz.lydiaproject.data.model.db.ContactDBEntity
import javax.inject.Inject

class ContactDBEntityDataMapper @Inject constructor(
    private val idDBEntityDataMapper: IdDBEntityDataMapper,
    private val nameDBEntityDataMapper: NameDBEntityDataMapper,
    private val locationDBEntityDataMapper: LocationDBEntityDataMapper,
    private val loginDBEntityDataMapper: LoginDBEntityDataMapper,
    private val pictureDBEntityDataMapper: PictureDBEntityDataMapper
) : BaseMapper<ContactDBEntity, Contact>() {

    override fun transformModelToDBEntity(input: Contact): ContactDBEntity {
        return ContactDBEntity(
            id = idDBEntityDataMapper.transformModelToDBEntity(input.id),
            name = nameDBEntityDataMapper.transformModelToDBEntity(input.name),
            email = input.email,
            cell = input.cell,
            dob = input.dob,
            gender = input.gender,
            location = locationDBEntityDataMapper.transformModelToDBEntity(input.location),
            login = loginDBEntityDataMapper.transformModelToDBEntity(input.login),
            nat = input.nat,
            phone = input.phone,
            picture = pictureDBEntityDataMapper.transformModelToDBEntity(input.picture),
            registered = input.registered
        )
    }

    override fun transformDBEntityToModel(input: ContactDBEntity): Contact {
        return Contact(
            id = idDBEntityDataMapper.transformDBEntityToModel(input.id),
            name = nameDBEntityDataMapper.transformDBEntityToModel(input.name),
            email = input.email,
            cell = input.cell,
            dob = input.dob,
            gender = input.gender,
            location = locationDBEntityDataMapper.transformDBEntityToModel(input.location),
            login = loginDBEntityDataMapper.transformDBEntityToModel(input.login),
            nat = input.nat,
            phone = input.phone,
            picture = pictureDBEntityDataMapper.transformDBEntityToModel(input.picture),
            registered = input.registered
        )
    }
}