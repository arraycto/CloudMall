package com.suzhou.love.autumn.admin.service.impl;


import com.suzhou.love.autumn.admin.service.OmsCompanyAddressService;
import com.suzhou.love.autumn.mapper.OmsCompanyAddressMapper;
import com.suzhou.love.autumn.model.OmsCompanyAddress;
import com.suzhou.love.autumn.model.OmsCompanyAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by macro on 2018/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
