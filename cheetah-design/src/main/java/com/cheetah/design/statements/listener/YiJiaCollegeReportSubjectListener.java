package com.cheetah.design.statements.listener;


import com.cheetah.design.statements.CollegeReport;
import com.cheetah.design.statements.abstracts.AbstractCollegeReportListener;
import com.cheetah.design.statements.mode.ReadSubjectMode;
import com.cheetah.design.statements.mode.WriteSubjectMode;

/**
 * 易加学院登录情况（学校）报表 监听
 */
public class YiJiaCollegeReportSubjectListener extends AbstractCollegeReportListener<ReadSubjectMode> {


    private CollegeReport collegeReport;

    public YiJiaCollegeReportSubjectListener(CollegeReport collegeReport) {
            this.collegeReport = collegeReport;
    }

    @Override
    public void after() {
        collegeReport.generate();
    }
}
