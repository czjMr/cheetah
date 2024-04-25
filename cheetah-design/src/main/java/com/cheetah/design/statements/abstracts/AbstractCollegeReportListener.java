package com.cheetah.design.statements.abstracts;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.cheetah.design.statements.exception.CollegeReportException;

import java.util.ArrayList;
import java.util.List;


/**
 * 读取 excel 数据一条一条监听 invoke方法为核心  可做分批获取数据 目前为最大读取3000 一次处理
 * 此类 配合 导出抽象类一起使用
 * @See AbstractCollegeReport
 * @param <T>
 */
public abstract class AbstractCollegeReportListener<T> extends AnalysisEventListener<T> {

    private static final int DEFAULT_BATCH_COUNT = 3000;

    private List<T> dataList = new ArrayList<>();

    @Override
    public void invoke(T data, AnalysisContext analysisContext) {
        if(dataList.size() > DEFAULT_BATCH_COUNT) {
            throw new CollegeReportException("解析数据文件过大");
        }
        dataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        after();
    }

    protected List<T> data() {
        return this.dataList;
    }

    public abstract void after();




}
