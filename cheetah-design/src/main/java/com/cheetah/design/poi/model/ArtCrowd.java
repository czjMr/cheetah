package com.cheetah.design.poi.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ArtCrowd {
    // index代表列索引，从0开始
    @ExcelProperty(index = 1)
    private String name;

}

