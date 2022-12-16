package com.akokko.dataanalyze

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import tk.mybatis.spring.annotation.MapperScan

@SpringBootApplication
@MapperScan(basePackages = ["com.akokko.dataanalyze.dao"])
class DataAnalyzeApplication

fun main(args: Array<String>) {
    runApplication<DataAnalyzeApplication>(*args)
}
