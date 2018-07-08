package main;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


/**
 * 注解@Primary：首选要装配的Bean
 */
@Primary
@Repository
public class AccountInfoRepository {

    public void say(){
        System.out.println("hi");
    }

}
