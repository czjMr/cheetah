package com.cheetah.design.statements.listener;


import com.cheetah.design.statements.CollegeReport;
import com.cheetah.design.statements.abstracts.AbstractCollegeReportListener;
import com.cheetah.design.statements.mode.ReadSchoolMode;
import com.cheetah.design.statements.mode.WriteSchoolMode;

/**
 * 易加学院登录情况（学校）报表 监听
 */
public class YiJiaCollegeReportSchoolListener extends AbstractCollegeReportListener<ReadSchoolMode> {


    private CollegeReport collegeReport;

    public YiJiaCollegeReportSchoolListener(CollegeReport collegeReport) {
            this.collegeReport = collegeReport;
    }

    @Override
    public void after() {
        collegeReport.generate();
    }
}
