package com.green.DataPractice.vo;

import java.util.Arrays;

//주문정보
public class OrderVO {
    private String chicken;
    private int num;
    private String[] add;
    private String plus;

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String[] getAdd() {
        return add;
    }

    public void setAdd(String[] add) {
        this.add = add;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "chicken='" + chicken + '\'' +
                ", num=" + num +
                ", add=" + Arrays.toString(add) +
                ", plus='" + plus + '\'' +
                '}';
    }
}
