package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.domain.ReportExample;
import com.bbs.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by geekhoon on 2019/6/21.
 */
@Service
@Transactional
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportDao reportDao;

    @Override
    public void addReport(Report report) {
        reportDao.insert(report);
    }

    @Override
    public List<Report> findByPage() {
        ReportExample reportExample = new ReportExample();
        ReportExample.Criteria criteria = reportExample.createCriteria();
        criteria.andReportstatusEqualTo(0);
        reportExample.setOrderByClause("reportTime desc");
        List<Report> reportList = reportDao.selectByExample(reportExample);
        return reportList;
    }

    @Override
    public void changeStatus(Integer aid) {
        reportDao.changeStatus(aid);
    }
}
