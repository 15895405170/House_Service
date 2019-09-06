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
    public Response insert(@RequestBody  House house) throws Exception{
            switch (house.getHouseType()){
                case "1":house.setHouseType1("V");break;
                case "2":house.setHouseType2("V");break;
                case "3":house.setHouseType3("V");break;
                default:break;
            }
            switch (house.getRepair()){
                case "1":house.setRepair1("V");break;
                case "2":house.setRepair2("V");break;
                default:break;
            }
            Integer count=0;
            count=this.houseService.insert(house);
        return Response.newResponse().setResults(count,count==1?"添加成功":"添加失败");
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

    @RequestMapping(value="/delete",method= RequestMethod.POST)
    public Response delete(@RequestBody  ParamMap paramMap) throws Exception{
        String[] ids = paramMap.get("ids").toString().split(",");
        Integer count = 0;
        for(String id : ids ){
            count+=houseService.delHouse(Integer.parseInt(id.trim()));
        }
        return Response.newResponse().setResults(count,"删除数据成功");
    }


    @RequestMapping(value="/test",method= RequestMethod.GET)
    public Response test() throws Exception{

        return Response.newResponse().setData("成功");
    }
}
