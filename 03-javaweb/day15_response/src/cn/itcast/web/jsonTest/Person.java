package cn.itcast.web.jsonTest;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/20.
 */

public class Person {
    private String name;
    private int age;
    private String url;
    private List<SchoolInfo> schoolInfo;


    public List<SchoolInfo> getSchoolInfo() {
        return schoolInfo;
    }

    public void setSchoolInfo(List<SchoolInfo> schoolInfo) {
        this.schoolInfo = schoolInfo;
    }

    public Person(String name, int age, String url) {
        this.name = name;
        this.age = age;
        this.url = url;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
