package com.akokko.dataanalyze.dao

import com.akokko.dataanalyze.pojo.User
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.common.Mapper

@Repository
interface UserMapper: Mapper<User>
