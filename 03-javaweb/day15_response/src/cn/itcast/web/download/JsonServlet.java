package cn.itcast.web.download;

import cn.itcast.web.jsonTest.Person;
import cn.itcast.web.jsonTest.Result;
import cn.itcast.web.jsonTest.SchoolInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType ( "text/html;charset=utf-8" );
        PrintWriter out = response.getWriter ();


        Result result = new Result();
        result.setResult(1);
        ArrayList<Person> list = new ArrayList<>();
        result.setPersonData(list);

        SchoolInfo schoolInfo1 = new SchoolInfo();
        schoolInfo1.setSchool_name("北大1");

        SchoolInfo schoolInfo2 = new SchoolInfo();
        schoolInfo2.setSchool_name("北大2");

        SchoolInfo schoolInfo3 = new SchoolInfo();
        schoolInfo3.setSchool_name("北大3");

        SchoolInfo schoolInfo4 = new SchoolInfo();
        schoolInfo4.setSchool_name("北大4");


        Person person1 = new Person("xiaoming", 15, "https://i.bdcache.com/pp1/720/96/968b609652a7872f298ba0d2ed5e33b8608bccb1.jpg");
        ArrayList<SchoolInfo> schoolInfos1 = new ArrayList<>();
        schoolInfos1.add(schoolInfo1);
        schoolInfos1.add(schoolInfo2);
        person1.setSchoolInfo(schoolInfos1);

        Person person2 = new Person("xiaoming", 15, "https://i.bdcache.com/pp1/720/d0/d077915a6811e9163585ab3d0b238e6127ab9523.jpg");
        ArrayList<SchoolInfo> schoolInfos2 = new ArrayList<>();
        schoolInfos2.add(schoolInfo3);
        schoolInfos2.add(schoolInfo4);
        person2.setSchoolInfo(schoolInfos2);

        list.add(person1);
        list.add(person2);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString ( result );

        System.out.println(json);
        out.println (json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println ("1234567");
        this.doPost ( request, response );
    }

    private void initJsonData() {
        Result result = new Result();
        result.setResult(1);
        ArrayList<Person> list = new ArrayList<>();
        result.setPersonData(list);

        SchoolInfo schoolInfo1 = new SchoolInfo();
        schoolInfo1.setSchool_name("北大1");

        SchoolInfo schoolInfo2 = new SchoolInfo();
        schoolInfo2.setSchool_name("北大2");

        SchoolInfo schoolInfo3 = new SchoolInfo();
        schoolInfo3.setSchool_name("北大3");

        SchoolInfo schoolInfo4 = new SchoolInfo();
        schoolInfo4.setSchool_name("北大4");


        Person person1 = new Person("xiaoming", 15, "http://baidu.com");
        ArrayList<SchoolInfo> schoolInfos1 = new ArrayList<>();
        schoolInfos1.add(schoolInfo1);
        schoolInfos1.add(schoolInfo2);
        person1.setSchoolInfo(schoolInfos1);

        Person person2 = new Person("xiaoming", 15, "http://baidu.com");
        ArrayList<SchoolInfo> schoolInfos2 = new ArrayList<>();
        schoolInfos2.add(schoolInfo3);
        schoolInfos2.add(schoolInfo4);
        person2.setSchoolInfo(schoolInfos2);

        list.add(person1);
        list.add(person2);

        Gson gson = new Gson();
        System.out.println(gson.toJson(result));


    }
}
