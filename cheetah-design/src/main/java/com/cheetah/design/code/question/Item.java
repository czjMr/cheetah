package com.cheetah.design.code.question;

import java.math.BigDecimal;

public class Item {

    /**
     * 桌号
     */
    private Integer tNumber;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 数量
     */
    private Integer quantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;


    public Item(Integer tNumber, String name, Integer quantity, BigDecimal unitPrice) {
        this.tNumber = tNumber;
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }


    private BigDecimal getAmount() {
        return this.unitPrice.multiply(new BigDecimal(this.quantity));
    }

    @Override
    public String toString() {
        return  "  桌号:" + tNumber +
                ", 项目名称:'" + name + '\'' +
                ", 数量:" + quantity +
                ", 单价:" + unitPrice +
                ", 消费金额为:" + getAmount();
    }
}
