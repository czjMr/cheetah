package com.cheetah.design.statements.mode;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WriteData<T> {

    List<T> listData;

    Map<String, Object> reserveMap;

    public WriteData(){

    }

    public WriteData(List<T> listData) {
        this.listData = listData;
    }

    public WriteData(List<T> listData,Map<String, Object> reserveMap) {
        this.listData = listData;
        this.reserveMap = reserveMap;
    }
}
