package com.cheetah.common.poi;

import java.awt.*;

public class PoiUtil {


    public static void main(String[] args) {
        Point location = MouseInfo.getPointerInfo().getLocation();
        location.move(100,100);
    }




}
