package com.green.DataPractice.vo;

public class StuInfoVO {
    private String name;
    private String grade;
    private String tel;
    private String gender;
    private String korScore;
    private String engScore;
    private String mathScore;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKorScore() {
        return korScore;
    }

    public void setKorScore(String korScore) {
        this.korScore = korScore;
    }

    public String getEngScore() {
        return engScore;
    }

    public void setEngScore(String engScore) {
        this.engScore = engScore;
    }

    public String getMathScore() {
        return mathScore;
    }

    public void setMathScore(String mathScore) {
        this.mathScore = mathScore;
    }

    @Override
    public String toString() {
        return "StuInfoVO{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", korScore='" + korScore + '\'' +
                ", engScore='" + engScore + '\'' +
                ", mathScore='" + mathScore + '\'' +
                '}';
    }


}
