package com.cheetah.design.poi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ArtCrowdWrite {
    // index代表列索引，从0开始
    @ExcelProperty(index = 2)
    private Integer count;

    // index代表列索引，从0开始
    @ExcelProperty(index = 3)
    private Integer count1;


}

