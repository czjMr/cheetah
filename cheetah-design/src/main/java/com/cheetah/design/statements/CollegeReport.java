package com.cheetah.design.statements;

import com.cheetah.design.statements.mode.param.ReportParam;

import java.io.File;

public interface CollegeReport {

    /**
     * 根据模版写入数据
     * 根据模版获取的数据生成对应报表的数据
     */
    void generate();

    /**
     * @return
     *         模版路径包含名称
     */
    File templateFile();

    /**
     * @return
     *       生成文件路径包含名称
     */
    File generateFile();

    /**
     * 报表数据参数
     * @return ReportParam
     */
    ReportParam getParam();
}
