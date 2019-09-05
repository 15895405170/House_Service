package com.yrxh.service;

import com.yrxh.modle.House;
import com.yrxh.util.ParamMap;

import java.util.List;

/**
 * Created by 91383 on 2019/8/23.
 */
public interface HouseService {
    int insert(House house) throws Exception;

    List<House> findList(ParamMap paramMap);

    Integer findListCount(ParamMap paramMap);

}
