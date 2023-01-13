package com.akokko.dataanalyze.controller

import com.akokko.dataanalyze.entity.Result
import com.akokko.dataanalyze.pojo.User
import com.akokko.dataanalyze.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping("/login")
    fun login(@RequestBody user: User): Result<User> {
        return userService.login(user)
    }

}
