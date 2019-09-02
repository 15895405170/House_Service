package com.yrxh.dao;

import com.yrxh.modle.House;
import com.yrxh.util.ParamMap;

import java.util.List;

/**
 * Created by 91383 on 2019/8/23.
 */
public interface HouseDao {
    int insert(House house);

    List<House> selectHouseList(ParamMap paramMap);
}

