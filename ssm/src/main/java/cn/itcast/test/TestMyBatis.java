package cn.itcast.test;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws Exception {
        //加载配置文件（将内容放在一个Configuration类中）
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //（SqlSessionFactoryBuilder会读取Configuration类中信息进而）创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //SqlSessionFactory创建SqlSession对象
        SqlSession session = factory.openSession();
        //SqlSession获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有账户信息
        List<Account> list = dao.findAll();
        for(Account account:list){
            System.out.println(account);
        }
        //关闭资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     * @throws Exception
     */
    @Test
    public void run2() throws Exception {
        Account account = new Account();
        account.setName("大王");
        account.setMoney(400d);
        //加载配置文件，将内容放在Configuration类中
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //SqlSessionFactoryBuilder读取Configuration类中的信息创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //SqlSessionFactory创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象，它获取对应的Mapper，让映射器通过命名空间
        // 和方法名称找到对应的SQL，发送给数据库执行后返回结果
        AccountDao dao = session.getMapper(AccountDao.class);

        //保存
        dao.saveAccount(account);

        //提交事务
        session.commit();

        //关闭资源
        session.close();
        in.close();
    }
}









