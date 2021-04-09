package com.xiaobao.test;

import com.xiaobao.domain.MyAccount;
import com.xiaobao.service.IMyAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAccountServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext ( "bean.xml" );
        IMyAccountService service = (IMyAccountService)context.getBean ( "accountService" );

//        MyAccount account = new MyAccount ();
//        account.setMymoney ( 9999 );
//        account.setMyname ( "aa111" );
//        account.setId ( 4 );
//
//        service.updateAccount (account  );
        service.transfer ( "aaa","bbb", (float) 100 );

    }
}
