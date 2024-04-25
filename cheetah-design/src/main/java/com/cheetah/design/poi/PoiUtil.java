package com.cheetah.design.poi;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.cheetah.design.poi.model.ArtCrowdWrite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PoiUtil {


    public static void main(String[] args) {

        File file = new File("/Users/cuizhijia/Documents/test-easy-excel.xlsx");
        File fileTmp = new File("/Users/cuizhijia/Documents/temp.xlsx");


        String templateFileName = fileTmp.getPath();
        String fileName = file.getPath();

        EasyExcel.write(fileName).withTemplate(templateFileName).sheet().doFill(data());

    }
    private static List<ArtCrowdWrite> data() {
        List<ArtCrowdWrite> list = new ArrayList<>();


        ArtCrowdWrite artCrowdWrite = new ArtCrowdWrite();
        artCrowdWrite.setCount(13);
        artCrowdWrite.setCount1(26);
        list.add(artCrowdWrite);

        ArtCrowdWrite artCrowdWrite1 = new ArtCrowdWrite();
        artCrowdWrite1.setCount(15);
        artCrowdWrite1.setCount1(30);
        list.add(artCrowdWrite1);
        return list;
    }



}
