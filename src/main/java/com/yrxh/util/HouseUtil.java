package com.yrxh.util;

import com.yrxh.modle.House;

/**
 * Created by 91383 on 2019/9/5.
 */
public class HouseUtil {
    public static House getStatus(House house){
        String str="";
        if(house.getHouseType1()!=null&&!house.getHouseType1().equals("")){
            str+="自住 ";
        }else if(house.getHouseType2()!=null&&!house.getHouseType2().equals("")){
            str+="出租 ";
        }
        if(house.getHouseType3()!=null&&!house.getHouseType3().equals("")){
            str+="空置 ";
        }
        if(house.getRepair1()!=null&&!house.getRepair1().equals("")){
            str+="毛坯 ";
        }
        if(house.getRepair2()!=null&&!house.getRepair2().equals("")){
            str+="已翻建 ";
        }
        house.setHouseType(str);
        return house;
    }
}
