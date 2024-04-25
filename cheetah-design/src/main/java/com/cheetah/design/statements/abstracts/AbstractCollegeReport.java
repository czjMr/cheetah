package com.cheetah.design.statements.abstracts;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.cheetah.design.statements.CollegeReport;
import com.cheetah.design.statements.constant.Constants;
import com.cheetah.design.statements.exception.FileNotExistsException;
import com.cheetah.design.statements.mode.WriteData;
import com.cheetah.design.statements.mode.param.ReportParam;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;


/**
 * 导出报表核心类
 * 整合了EasyExcel 封装读 和 写（填充模版）
 * 子类实现后实现对应的抽象类方法
 * @param <W>
 */
public abstract class AbstractCollegeReport<R,W>  implements CollegeReport {


    private ReportParam param;

    public CollegeReport param(ReportParam param) {
        this.param = param;
        return this;
    }

    @Override
    public void generate() {
        WriteData<W> writeData = writeData(readData(),getParam());
        ExcelWriter excelWriter = EasyExcel.write(generateFile()).withTemplate(templateFile()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        excelWriter.fill(writeData.getListData(), writeSheet);
        if(!CollectionUtils.isEmpty(writeData.getReserveMap())) {
            excelWriter.fill(writeData.getReserveMap(), writeSheet);
        }
        excelWriter.finish();
    }

    @Override
    public File templateFile() {
        File file = new File(templatePath() + templateName() + Constants.XLSX);
        if(!file.exists()) throw new FileNotExistsException("模版文件不存在");
        return file;
    }

    @Override
    public File generateFile() {
        return new File(generatePath() + generateName() + Constants.XLSX);
    }


    @Override
    public ReportParam getParam() {
        if(ReportParam.isNull(param)) {
            return ReportParam.defaultParam();
        }
        return param;
    }

    /**
     *
     * @param readData
     *        根据读取的学校 或者学科 查询统计出报表数据
     * @return writeData 要写入模版的数据
     */
    protected abstract WriteData<W> writeData(List<R> readData, ReportParam param);

    /**
     * 返回要查询数据的学校或者学科
     * @return readData
     */
    protected abstract List<R> readData();

    protected abstract String templatePath();

    protected abstract String templateName();

    protected abstract String generatePath();

    protected abstract String generateName();


}
