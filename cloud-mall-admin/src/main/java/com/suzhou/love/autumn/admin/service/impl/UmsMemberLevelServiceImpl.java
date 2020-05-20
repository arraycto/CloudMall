package com.suzhou.love.autumn.admin.service.impl;


import com.suzhou.love.autumn.admin.service.UmsMemberLevelService;
import com.suzhou.love.autumn.mapper.UmsMemberLevelMapper;
import com.suzhou.love.autumn.model.UmsMemberLevel;
import com.suzhou.love.autumn.model.UmsMemberLevelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员等级管理Service实现类
 * Created by macro on 2018/4/26.
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
