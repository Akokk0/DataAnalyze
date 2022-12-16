package com.akokko.dataanalyze.pojo

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "local_authority_traffic")
data class Traffic(
    @Column(name = "Local_authority_id") var Local_authority_id: String?,
    @Column(name = "name") var name: String?,
    @Column(name = "ONS_code") var ONS_code: String?,
    @Column(name = "year") var year: Int?,
    @Column(name = "link_length_km") var link_length_km: Double?,
    @Column(name = "link_length_miles") var link_length_miles: Double?,
    @Column(name = "cars_and_taxis") var cars_and_taxis: Double?,
    @Column(name = "all_motor_vehicles") var all_motor_vehicles: Double?
) {
    constructor(): this(null, null, null, null, null, null, null, null)
}
