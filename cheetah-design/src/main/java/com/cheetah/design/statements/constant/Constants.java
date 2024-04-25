package com.cheetah.design.statements.constant;

import com.cheetah.design.statements.mode.ReadSchoolMode;
import com.cheetah.design.statements.mode.ReadSubjectMode;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public class Constants {

    public static final List<ReadSchoolMode> SCHOOL_LIST = Lists.newArrayList(
            new ReadSchoolMode("车坊实验小学",""),
            new ReadSchoolMode("第二实验小学",""),
            new ReadSchoolMode("第三实验小学",""),
            new ReadSchoolMode("东沙湖小学",""),
            new ReadSchoolMode("方洲小学",""),
            new ReadSchoolMode("翰林小学",""),
            new ReadSchoolMode("跨塘实验小学",""),
            new ReadSchoolMode("娄葑实验小学",""),
            new ReadSchoolMode("胜浦实验小学",""),
            new ReadSchoolMode("唯亭实验小学",""),
            new ReadSchoolMode("文萃小学",""),
            new ReadSchoolMode("新城花园小学",""),
            new ReadSchoolMode("星海小学",""),
            new ReadSchoolMode("星洲小学",""),
            new ReadSchoolMode("东延路实验学校",""),
            new ReadSchoolMode("独墅湖学校",""),
            new ReadSchoolMode("金鸡湖学校",""),
            new ReadSchoolMode("景城学校",""),
            new ReadSchoolMode("莲花学校",""),
            new ReadSchoolMode("娄葑学校",""),
            new ReadSchoolMode("青剑湖学校",""),
            new ReadSchoolMode("斜塘学校",""),
            new ReadSchoolMode("星澄学校",""),
            new ReadSchoolMode("星港学校",""),
            new ReadSchoolMode("星汇学校",""),
            new ReadSchoolMode("星浦学校",""),
            new ReadSchoolMode("星湾学校",""),
            new ReadSchoolMode("星洋学校",""),
            new ReadSchoolMode("东沙湖实验中学",""),
            new ReadSchoolMode("西附初中",""),
            new ReadSchoolMode("星海实验中学",""),
            new ReadSchoolMode("苏大附中","")
    );

    public static final List<ReadSubjectMode> SUBJECT_LIST = Lists.newArrayList(
            new ReadSubjectMode("小学","","","语文"),
            new ReadSubjectMode("小学","","","数学"),
            new ReadSubjectMode("小学","","","英语"),
            new ReadSubjectMode("小学","","","科学"),
            new ReadSubjectMode("小学","","","信息技术"),
            new ReadSubjectMode("小学","","","音乐"),
            new ReadSubjectMode("小学","","","美术"),
            new ReadSubjectMode("小学","","","道德与法治"),
            new ReadSubjectMode("小学","","","体育与健康"),
            new ReadSubjectMode("小学","","","劳动与技术"),
            new ReadSubjectMode("小学","","","心理"),
            new ReadSubjectMode("小学","","","综合实践"),
            new ReadSubjectMode("初中","","","语文"),
            new ReadSubjectMode("初中","","","数学"),
            new ReadSubjectMode("初中","","","英语"),
            new ReadSubjectMode("初中","","","生物"),
            new ReadSubjectMode("初中","","","地理"),
            new ReadSubjectMode("初中","","","物理"),
            new ReadSubjectMode("初中","","","化学"),
            new ReadSubjectMode("初中","","","道德与法治"),
            new ReadSubjectMode("初中","","","历史"),
            new ReadSubjectMode("初中","","","美术"),
            new ReadSubjectMode("初中","","","体育"),
            new ReadSubjectMode("初中","","","音乐"),
            new ReadSubjectMode("初中","","","劳动与技术"),
            new ReadSubjectMode("初中","","","信息技术"),
            new ReadSubjectMode("初中","","","心理"),
            new ReadSubjectMode("初中","","","综合实践"),
            new ReadSubjectMode("高中","","","语文"),
            new ReadSubjectMode("高中","","","数学"),
            new ReadSubjectMode("高中","","","英语"),
            new ReadSubjectMode("高中","","","物理"),
            new ReadSubjectMode("高中","","","化学"),
            new ReadSubjectMode("高中","","","生物"),
            new ReadSubjectMode("高中","","","信息技术"),
            new ReadSubjectMode("高中","","","地理"),
            new ReadSubjectMode("高中","","","历史"),
            new ReadSubjectMode("高中","","","思想政治"),
            new ReadSubjectMode("高中","","","心理"),
            new ReadSubjectMode("高中","","","音乐"),
            new ReadSubjectMode("高中","","","美术"),
            new ReadSubjectMode("高中","","","体育"),
            new ReadSubjectMode("高中","","","综合实践"),
            new ReadSubjectMode("高中","","","通用技术")
    );


    public static final String REPORT_SCHOOL_NAME = "易加学院登录情况（学校）";

    public static final String REPORT_SUBJECT_NAME = "易加学院登录情况（学科）";

    public static final String REPORT_SUFFIX_NAME = "登录统计";


    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";
    public static final String TRUE = "true";
    public static final String FALSE = "false";
    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final String HTML_SUFFIX = ".html";
    public static final String COMMA = ",";
    public static final String QUOTES = "\"";
    public static final String CSV = ".csv";
    public static final String COLON = ":";
    public static final String ARROW = "->";
    public static final String SPOT = ".";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final String EQUAL = "=";

}
