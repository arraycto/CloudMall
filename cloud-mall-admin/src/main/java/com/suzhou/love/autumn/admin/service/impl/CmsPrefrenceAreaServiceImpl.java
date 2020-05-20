package com.suzhou.love.autumn.admin.service.impl;


import com.suzhou.love.autumn.admin.service.CmsPrefrenceAreaService;
import com.suzhou.love.autumn.mapper.CmsPrefrenceAreaMapper;
import com.suzhou.love.autumn.model.CmsPrefrenceArea;
import com.suzhou.love.autumn.model.CmsPrefrenceAreaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by macro on 2018/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
