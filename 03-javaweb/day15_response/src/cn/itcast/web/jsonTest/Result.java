package cn.itcast.web.jsonTest;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/20.
 */

public class Result {
    private int result;
    private List<Person> personData;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<Person> getPersonData() {
        return personData;
    }

    public void setPersonData(List<Person> personData) {
        this.personData = personData;
    }
}
