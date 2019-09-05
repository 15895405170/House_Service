package com.yrxh.controller;

import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.HouseUtil;
import com.yrxh.util.ParamMap;
import com.yrxh.util.Response;
import com.yrxh.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 91383 on 2019/8/23.
 */
@CrossOrigin
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
        for(int i=0;i<list.size();i++){
            count+=this.houseService.insert(list.get(i));
        }
        return count;
    }

    @RequestMapping(value="/getList",method= RequestMethod.POST)
    public Response getList(@RequestBody  ParamMap paramMap) throws Exception{
        if(paramMap.get("community").equals("")){
            paramMap.remove("community");
        }
        if(paramMap.get("maxArea").equals("")){
            paramMap.remove("maxArea");
        }
        if(paramMap.get("minArea").equals("")){
            paramMap.remove("minArea");
        }
        List<House> list =this.houseService.findList(paramMap);
        for(House house:list){
            HouseUtil.getStatus(house);
        }
        Integer count=this.houseService.findListCount(paramMap);
        return Response.newResponse().put("rows",list).put("total",count);
    }


    @RequestMapping(value="/test",method= RequestMethod.GET)
    public Response test() throws Exception{

        return Response.newResponse().setData("成功");
    }
}
