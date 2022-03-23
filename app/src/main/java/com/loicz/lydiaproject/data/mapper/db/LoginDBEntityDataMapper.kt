package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Login
import com.loicz.lydiaproject.data.model.db.LoginDBEntity
import javax.inject.Inject

class LoginDBEntityDataMapper @Inject constructor(): BaseMapper<LoginDBEntity, Login>() {
    override fun transformModelToDBEntity(input: Login): LoginDBEntity {
        return LoginDBEntity(
            md5 = input.md5,
            password = input.password,
            salt = input.salt,
            sha1 = input.sha1,
            sha256 = input.sha256,
            username = input.username
        )
    }

    override fun transformDBEntityToModel(input: LoginDBEntity): Login {
        return Login(
            md5 = input.md5,
            password = input.password,
            salt = input.salt,
            sha1 = input.sha1,
            sha256 = input.sha256,
            username = input.username
        )
    }
}