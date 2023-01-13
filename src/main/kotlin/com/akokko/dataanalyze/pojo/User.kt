package com.akokko.dataanalyze.pojo

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "t_user")
data class User(
    @Column(name = "id") val id: Int?,
    @Column(name = "username") val username: String?,
    @Column(name = "password") val password: String?
) {
    constructor(): this(null, null, null)
}
