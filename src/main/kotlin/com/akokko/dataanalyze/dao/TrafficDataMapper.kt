package com.akokko.dataanalyze.dao

import com.akokko.dataanalyze.pojo.Traffic
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.common.Mapper

@Repository
interface TrafficDataMapper: Mapper<Traffic>