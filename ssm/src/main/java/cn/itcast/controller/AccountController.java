package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    //按类型注入AccountService
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层，查询所有的账户信息。。。");
        //调用service的方法（业务层）
        List<Account> list = accountService.findAll();
        //将list进行储存
        model.addAttribute("list",list);
        //注意，这个返回的list会在视图管理器管理的页面中会有一个对应的list.jsp
        return "list";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccout(account);
        //重定向,
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        //注意，这个返回的list会在视图管理器管理的页面中会有一个对应的list.jsp
        return;
    }
}













