package main.entities;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class AccountInfo {
    private BigInteger id;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String name;
    private BigDecimal balance;

    public AccountInfo() {
        System.out.println("call AccountInfo");
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

    @PostConstruct
    public void init(){
        System.out.println("call init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("call destroy");
    }

}
