package com.yrxh.service.impl;

import com.yrxh.dao.HouseDao;
import com.yrxh.modle.House;
import com.yrxh.service.HouseService;
import com.yrxh.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 91383 on 2019/8/23.
 */
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseDao houseDao;

    @Override
    public int insert(House house) throws Exception {

        return  houseDao.insert(house);
    }

}
