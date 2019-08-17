package com.bbs.service;

import com.bbs.domain.Report;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/21.
 */
public interface IReportService {
    void addReport(Report report);

    List<Report> findByPage();

    void changeStatus(Integer aid);
}
