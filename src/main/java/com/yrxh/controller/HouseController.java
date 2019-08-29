package com.yrxh.controller;

import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.ParamMap;
import com.yrxh.util.XmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        XmlUtil xmlUtil =new XmlUtil();
        List<House> list =xmlUtil.addInfo();
        return this.houseService.insert(house);
    }
}
