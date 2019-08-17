package com.bbs.service.impl;

import com.bbs.dao.ZoneApplyDao;
import com.bbs.domain.ZoneApply;
import com.bbs.domain.ZoneApplyExample;
import com.bbs.service.IZoneApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneApplyServiceImpl implements IZoneApplyService {

    @Autowired
    private ZoneApplyDao zoneApplyDao;

    @Override
    public List<ZoneApply> findByPage() {
        ZoneApplyExample example=new ZoneApplyExample();
        ZoneApplyExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        return zoneApplyDao.selectByExample(example);
    }

    @Override
    public void changeStatus(Integer zid) {
        zoneApplyDao.changeStatus(zid);
    }

    @Override
    public void add(ZoneApply zoneApply) {
        zoneApplyDao.insert(zoneApply);
    }
}
