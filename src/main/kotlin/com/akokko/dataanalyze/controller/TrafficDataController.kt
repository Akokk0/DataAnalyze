package com.akokko.dataanalyze.controller

import com.akokko.dataanalyze.entity.Result
import com.akokko.dataanalyze.pojo.Traffic
import com.akokko.dataanalyze.service.TrafficDataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TrafficDataController {

    @Autowired
    lateinit var trafficDataService: TrafficDataService

    @GetMapping("/getAllData")
    fun getAllData(): Result<List<Traffic>> {
        return trafficDataService.getAllData()
    }

    @GetMapping("/getDataByYear/{year}")
    fun getDataByYear(@PathVariable("year") year: Int): Result<List<Traffic>> {
        return trafficDataService.getDataByYear(year)
    }

    @GetMapping("/getVehicleTypeByYear/{year}")
    fun getVehicleTypeByYear(@PathVariable("year") year: Int): Result<Map<String, Double>> {
        return trafficDataService.getVehicleTypeByYear(year)
    }

    @GetMapping("/getDataByCity/{city}")
    fun getDataByCity(@PathVariable("city") city: String): Result<List<Traffic>> {
        return trafficDataService.getDataByCity(city)
    }

    @GetMapping("/getDataByCity/{city}/{year}")
    fun getDataByCity(@PathVariable("city") city: String, @PathVariable("year") year: Int): Result<List<Traffic>> {
        return trafficDataService.getDataByCityAndYear(city, year)
    }
}