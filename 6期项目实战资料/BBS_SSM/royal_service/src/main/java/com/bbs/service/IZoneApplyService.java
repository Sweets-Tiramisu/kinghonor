package com.bbs.service;

import com.bbs.domain.ZoneApply;

import java.util.List;

public interface IZoneApplyService {

    List<ZoneApply> findByPage();

    void changeStatus(Integer zid);

    void add(ZoneApply zoneApply);
}
