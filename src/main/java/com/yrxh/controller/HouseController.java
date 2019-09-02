package com.yrxh.controller;

import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.ParamMap;
import com.yrxh.util.Response;
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
        int count=0;
        for(int i=0;i<500;i++){
            count+=this.houseService.insert(list.get(i));
        }
        return count;
    }

    @RequestMapping(value="/getList",method= RequestMethod.POST)
    public Response getList(@RequestBody  ParamMap paramMap) throws Exception{
        List<House> list =this.houseService.findList(paramMap);
        Integer count = 0;
        return Response.newResponse().setResults(count,list);
    }
}
