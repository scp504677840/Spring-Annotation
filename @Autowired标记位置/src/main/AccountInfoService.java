package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    /**
     * 注解@Autowired标记在属性上
     */
    /*@Autowired
    private AccountInfoRepository accountInfoRepository;*/

    private AccountInfoRepository accountInfoRepository;

    /**
     * 注解@Autowired标记在方法上
     *
     * @param accountInfoRepository AccountInfoRepository
     */
    @Autowired
    public AccountInfoService(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }

    /**
     * 注解@Autowired标记在参数上
     *
     * @param accountInfoRepository AccountInfoRepository
     */
    /*public AccountInfoService(@Autowired AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }*/

    /**
     * 当只有一个参数时，无论是构造函数还是普通函数，都将默认使用@Autowired自动注入。
     * 所以@Autowired可以省略不写。
     */
    /*public AccountInfoService(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }*/

    public void say() {
        accountInfoRepository.say();
    }

}
