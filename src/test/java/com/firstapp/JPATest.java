package com.firstapp;

import com.firstapp.domain.UserJPA;
import com.firstapp.repository.UserJPARepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApp.class)
public class JPATest {
    @Autowired
    private UserJPARepository userJPARepository;

    @Test
    public void test(){
        List<UserJPA> list = userJPARepository.findAll();
        System.out.println(list);
    }

}
