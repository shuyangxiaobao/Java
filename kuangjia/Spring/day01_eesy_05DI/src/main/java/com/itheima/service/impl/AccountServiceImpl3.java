package com.itheima.service.impl;

import com.itheima.service.IAccountService;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Map;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] myStrs;
    private String[] xlpStrs;

    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;
    private Properties xlpProps;

    public void setXlpProps(Properties xlpProps) {
        this.xlpProps = xlpProps;
    }



    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    public void setXlpStrs(String[] xlpStrs) {
        this.xlpStrs = xlpStrs;
    }

    public void  saveAccount(){
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(myProps);
    }


}
