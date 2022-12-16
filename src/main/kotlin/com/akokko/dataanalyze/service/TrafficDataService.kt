package com.akokko.dataanalyze.service

import com.akokko.dataanalyze.dao.TrafficDataMapper
import com.akokko.dataanalyze.entity.Result
import com.akokko.dataanalyze.entity.StatusCode
import com.akokko.dataanalyze.pojo.Traffic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

// 遗骸
/*val example = Example(Traffic::class.java)
    val criteria = example.createCriteria()
    val listCriteria = criteria.andEqualTo("year", year)
    val dataList = trafficDataMapper.selectByExample(listCriteria)*/

@Service
class TrafficDataService {

    @Autowired
    lateinit var trafficDataMapper: TrafficDataMapper

    fun getAllData(): Result<List<Traffic>> {
        val allData = trafficDataMapper.selectAll()
        return if (allData.isNullOrEmpty()) {
            Result(false, StatusCode.ERROR, "获取数据失败！")
        } else {
            Result(true, StatusCode.OK, "获取数据成功！", allData)
        }
    }

    fun getDataByYear(year: Int): Result<List<Traffic>> {
        val searchTraffic = Traffic()
        searchTraffic.year = year
        val dataList = trafficDataMapper.select(searchTraffic)
        println(dataList)
        return if (dataList == null) {
            Result(false, StatusCode.ERROR, "获取数据失败，请稍后重试！")
        } else {
            Result(true, StatusCode.OK, "获取数据成功！", dataList)
        }
    }

    fun getVehicleTypeByYear(year: Int): Result<Map<String, Double>> {
        val searchTraffic = Traffic()
        searchTraffic.year = year
        val dataList = trafficDataMapper.select(searchTraffic)
        var motorVehicleCount = 0.0
        var carsCount = 0.0
        dataList.forEach {
            motorVehicleCount += it.all_motor_vehicles!!
            carsCount += it.cars_and_taxis!!
        }
        val result = mapOf(
            "motorVehicleCount" to motorVehicleCount,
            "carsCount" to carsCount
        )
        return Result(true, StatusCode.OK, "查询成功", result)
    }

    fun getDataByCity(city: String): Result<List<Traffic>> {
        val searchTraffic = Traffic()
        searchTraffic.name = city
        val dataList = trafficDataMapper.select(searchTraffic)
        return Result(true, StatusCode.OK, "查询成功", dataList)
    }

    fun getDataByCityAndYear(city: String, year: Int): Result<List<Traffic>> {
        val searchTraffic = Traffic()
        searchTraffic.name = city
        searchTraffic.year = year
        val dataList = trafficDataMapper.select(searchTraffic)
        return Result(true, StatusCode.OK, "查询成功", dataList)
    }

}