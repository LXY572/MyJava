package cn.itcast.dao;

import cn.itcast.domain.Account;
import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户接口
 */
//@Repository用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean
@Repository
public interface AccountDao {

    //查询所有账户信息
    @Select("select * from account")
    public List<Account> findAll();

    //保存账户信息,#{name}表示从accout取值
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void saveAccount(Account account);







}
