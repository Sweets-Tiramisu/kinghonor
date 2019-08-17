package com.bbs.service;

import com.bbs.domain.Zone;

import java.util.List;

public interface IZoneService {
    List<Zone> findZoneList();

    void addZone(Integer zid);
}
