package main.entities;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 注解@Value：属性赋值。
 * 1.可以直接写String
 * 2.可以写SpEL
 * 3.可以使用#{}和${}
 * 4.可以取配置文件中的值
 */
public class AccountInfo {
    @Value("#{20-2}")
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    @Value("Tom")
    private String name;
    @Value("${accountInfo.balance}")
    private BigDecimal balance;

    public AccountInfo() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
