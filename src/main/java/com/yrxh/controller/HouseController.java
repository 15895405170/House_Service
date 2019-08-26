package com.yrxh.controller;

import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 91383 on 2019/8/23.
 */
@Controller
@ResponseBody
public class HouseController {
    @Autowired
    HouseService houseService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public Integer insert(@RequestBody  House house) throws Exception{
        house.setArea("197.55");
        System.out.println(house.toString());
        return this.houseService.insert(house);
    }
}
