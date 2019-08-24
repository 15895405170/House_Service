package com.yrxh.controller;

import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 91383 on 2019/8/23.
 */
@RestController
public class HouseController {
    @Autowired
    HouseService houseService;

    @PostMapping("/insert")
    public Integer insert(House house) throws Exception{
        return this.houseService.insert(house);
    }
}
