package com.xiaobao.test;

import com.xiaobao.config.SpringConfiguration;
import com.xiaobao.service.IMyAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class MyAccountServiceTest {


    @Autowired
    private IMyAccountService service;
    @Test
    public void demo(){
        service.transfer ( "aaa","bbb", (float) 100 );
    }
}
