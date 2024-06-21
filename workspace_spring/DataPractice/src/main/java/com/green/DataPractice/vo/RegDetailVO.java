package com.green.DataPractice.vo;

import java.util.Arrays;

public class RegDetailVO {
    private String school;
    private String menu;
    private String[] license;
    private String[] company;
    private String introduce;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String[] getLicense() {
        return license;
    }

    public void setLicense(String[] license) {
        this.license = license;
    }

    public String[] getCompany() {
        return company;
    }

    public void setCompany(String[] company) {
        this.company = company;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "RegDetailVO{" +
                "school='" + school + '\'' +
                ", menu='" + menu + '\'' +
                ", license=" + Arrays.toString(license) +
                ", company=" + Arrays.toString(company) +
                ", introduce='" + introduce + '\'' +
                '}';
    }


}
