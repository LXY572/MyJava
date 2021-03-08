package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("accountService")
public class AccountServiceImpl implements AccountService{

    //注入AccountDao接口（按类的类型进行属性装配）
    @Autowired
    private AccountDao accountDao;


    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户。。。");
        return accountDao.findAll();
    }

    @Override
    public void saveAccout(Account account) {
        System.out.println("业务层：保存账户。。。");
        accountDao.saveAccount(account);

    }
}
