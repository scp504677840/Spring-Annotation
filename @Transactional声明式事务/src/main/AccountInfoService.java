package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注解@Transactional：声明式事务
 */
@Transactional
@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public void saveAccountInfo(AccountInfo accountInfo) {
        accountInfoRepository.saveAccountInfo(accountInfo);
        int result = 1 / 0;
    }

}
