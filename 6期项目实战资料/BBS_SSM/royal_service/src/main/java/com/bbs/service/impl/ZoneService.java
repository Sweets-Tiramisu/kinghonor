package com.bbs.service.impl;

import com.bbs.dao.ZoneApplyDao;
import com.bbs.dao.ZoneDao;
import com.bbs.domain.Zone;
import com.bbs.domain.ZoneApply;
import com.bbs.service.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService implements IZoneService{

    @Autowired
    private ZoneDao zoneDao;

    @Autowired
    private ZoneApplyDao zoneApplyDao;

    @Override
    public List<Zone> findZoneList() {
        return zoneDao.selectByExample(null);
    }

    @Override
    public void addZone(Integer zid) {
        ZoneApply zoneApply = zoneApplyDao.selectByPrimaryKey(zid);
        List<Zone> zoneList = findZoneList();
        for (Zone zone : zoneList) {
            if (zone.getZonename().equals(zoneApply.getZonename()))
                return;
        }
        Zone zone = new Zone();
        zone.setIsdef(2);
        zone.setZonename(zoneApply.getZonename());
        zoneDao.insert(zone);
    }
}
