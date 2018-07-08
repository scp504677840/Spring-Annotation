package main;

import org.springframework.stereotype.Service;

@Service
public class AccountInfoService {

    /**
     * 注解@Autowired：自动注入
     * 1.优先按照类型去找要装配的组件。如：ctx.getBean(AccountInfoRepository.class)
     * 2.其次按照属性名去找。如：ctx.getBean("accountInfoRepository")
     * 3.也可以使用@Qualifier指定要装配的组件。
     * 4.当没有找到合适的组件时，就会报错，但是@Autowired的属性required也可以设置false，不是必须装配。
     * 5.当有多个相同类型的Bean时，我们可以在Bean加上@Primary来指定首选要装配的Bean。
     *
     * 注解@Qualifier：指定要装配的Bean
     *
     * 注意：
     * 注解@Resource也可以实现自动注入功能，但是它跟@Autowired的区别：
     * 1.@Resource是Java规范，@Autowired是Spring规范。
     * 2.@Resource是根据属性名称来注入的，不受@Primary影响。
     * 3.@Resource没有required属性。
     */
    @Resource
    private AccountInfoRepository accountInfoRepository;

    public void say() {
        accountInfoRepository.say();
    }

}
