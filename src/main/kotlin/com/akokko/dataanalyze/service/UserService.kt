package com.akokko.dataanalyze.service

import com.akokko.dataanalyze.dao.UserMapper
import com.akokko.dataanalyze.entity.Result
import com.akokko.dataanalyze.entity.StatusCode
import com.akokko.dataanalyze.pojo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

   @Autowired
   lateinit var userMapper: UserMapper

   fun login(user: User): Result<User> {
       if (userMapper.selectOne(user) == null) {
           return Result(false, StatusCode.ERROR, "登录失败！账户或密码错误！")
       } else {
           return Result(true, StatusCode.OK, "登录成功！")
       }

   }

}
