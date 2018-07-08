package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountInfoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveAccountInfo(AccountInfo accountInfo) {
        String sql = "insert into account_info(gmt_create, gmt_modified, name, balance) values (?,?,?,?)";
        int count = jdbcTemplate.update(sql,
                accountInfo.getGmtCreate(),
                accountInfo.getGmtModified(),
                accountInfo.getName(),
                accountInfo.getBalance());
        System.out.println(count > 0);
    }

}
