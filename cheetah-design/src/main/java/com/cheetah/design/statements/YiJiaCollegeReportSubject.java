package com.cheetah.design.statements;

import com.cheetah.design.statements.abstracts.AbstractCollegeReport;
import com.cheetah.design.statements.constant.Constants;
import com.cheetah.design.statements.mode.ReadSubjectMode;
import com.cheetah.design.statements.mode.WriteData;
import com.cheetah.design.statements.mode.WriteSubjectMode;
import com.cheetah.design.statements.mode.param.ReportParam;
import com.google.common.collect.Maps;

import java.util.*;

public class YiJiaCollegeReportSubject extends AbstractCollegeReport<ReadSubjectMode,WriteSubjectMode> {


    private String templatePath = "/Users/cuizhijia/Documents/";

    private String templateName = "temp";

    private String generatePath = "/Users/cuizhijia/Documents/";

    private String generateName;


    @Override
    protected WriteData<WriteSubjectMode> writeData(List<ReadSubjectMode> data, ReportParam param) {
        // 查数据拼接报表要统计的数据
        ArrayList<WriteSubjectMode> writeSchoolModeList = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            WriteSubjectMode writeSubjectMode = new WriteSubjectMode();
            writeSubjectMode.setTeacherLoginNumber(12+i);
            writeSubjectMode.setPilotTeacherNumber(22+i);
            writeSubjectMode.setTeacherLoginTimes(11+i);
            writeSchoolModeList.add(writeSubjectMode);
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("total",2222);
        this.generateName = "20210430-test-easy-excel";
        return new WriteData<>(writeSchoolModeList,map);
    }


    @Override
    protected List<ReadSubjectMode> readData() {
        return Constants.SUBJECT_LIST;
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
        new YiJiaCollegeReportSubject().param(ReportParam.builder().start(new Date()).end(new Date()).build()).generate();
    }
}
