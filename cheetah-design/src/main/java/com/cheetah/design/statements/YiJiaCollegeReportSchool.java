package com.cheetah.design.statements;

import com.cheetah.design.statements.abstracts.AbstractCollegeReport;
import com.cheetah.design.statements.mode.ReadSchoolMode;
import com.cheetah.design.statements.mode.WriteData;
import com.cheetah.design.statements.mode.WriteSchoolMode;
import com.cheetah.design.statements.mode.WriteSubjectMode;
import com.cheetah.design.statements.mode.param.ReportParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YiJiaCollegeReportSchool extends AbstractCollegeReport<ReadSchoolMode,WriteSchoolMode> {


    private String templatePath = "/Users/cuizhijia/Documents/";

    private String templateName = "temp";

    private String generatePath = "/Users/cuizhijia/Documents/";

    private String generateName;


    @Override
    protected WriteData<WriteSchoolMode> writeData(List<ReadSchoolMode> data, ReportParam param) {

        ArrayList<WriteSchoolMode> writeSchoolModeList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            WriteSchoolMode writeSchoolMode = new WriteSchoolMode();
            writeSchoolMode.setTeacherLoginNumber(12+i);
            writeSchoolMode.setPilotTeacherNumber(22+i);
            writeSchoolModeList.add(writeSchoolMode);
        }
        this.generateName = "20210430-test-easy-excel";
        return new WriteData<>(writeSchoolModeList);
    }

    @Override
    protected List<ReadSchoolMode> readData() {
        return null;
    }

    @Override
    protected String templatePath() {
        return templatePath;
    }

    @Override
    protected String templateName() {
        return templateName;
    }

    @Override
    protected String generatePath() {
        return generatePath;
    }

    @Override
    protected String generateName() {
        return generateName;
    }


    public static void main(String[] args) {
        new YiJiaCollegeReportSchool()
                .param(ReportParam.builder()
                                  .start(new Date())
                                  .end(new Date()).build())
                .generate();
    }
}
