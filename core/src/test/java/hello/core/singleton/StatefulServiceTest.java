package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA 사용자A 10000원 주문
        statefulService1.order("UserA", 10000);

        //ThreadB 사용자B 20000원 주문
        statefulService1.order("UserB", 20000);



    }

    static class  TestConfig{

        @Bean
        public StatefulServiceTest statefulService(){
            return new StatefulServiceTest();
        }
    }
}