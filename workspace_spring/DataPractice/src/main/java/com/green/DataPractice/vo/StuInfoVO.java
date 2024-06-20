package com.green.DataPractice.vo;

import java.util.Arrays;

public class StuInfoVO {
    private String name;
    private String grade;
    private String[] tel;
    private String gender;
    private int korScore;
    private int engScore;
    private int mathScore;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String[] getTel() {
        return tel;
    }

    public void setTel(String[] tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    @Override
    public String toString() {
        return "StuInfoVO{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", tel=" + Arrays.toString(tel) +
                ", gender='" + gender + '\'' +
                ", korScore=" + korScore +
                ", engScore=" + engScore +
                ", mathScore=" + mathScore ;
    }


}
