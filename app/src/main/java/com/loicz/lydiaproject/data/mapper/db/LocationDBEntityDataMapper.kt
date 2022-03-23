package com.loicz.lydiaproject.data.mapper.db

import com.loicz.lydiaproject.data.mapper.base.BaseMapper
import com.loicz.lydiaproject.data.model.Location
import com.loicz.lydiaproject.data.model.db.LocationDBEntity
import javax.inject.Inject

class LocationDBEntityDataMapper @Inject constructor(): BaseMapper<LocationDBEntity, Location>() {
    override fun transformModelToDBEntity(input: Location): LocationDBEntity {
        return LocationDBEntity(
            city = input.city,
            postcode = input.postcode,
            state = input.state,
            street = input.street
        )
    }

    override fun transformDBEntityToModel(input: LocationDBEntity): Location {
        return Location(
            city = input.city,
            postcode = input.postcode,
            state = input.state,
            street = input.street
        )
    }
}