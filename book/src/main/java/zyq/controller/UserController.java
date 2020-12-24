package zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import zyq.pojo.Books;
import zyq.pojo.Records;
import zyq.pojo.Users;
import zyq.service.book.BookService;
import zyq.service.record.RecordService;
import zyq.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/12/17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @Autowired
    private BookService bs;

    @Autowired
    private RecordService rs;

    //记录uid并返回主页的方法
    @RequestMapping("/index")
    public String index(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){
        if(uid==null){
            return "index";
        }else {
            Users user = us.selectByPrimaryKey(uid);
            model.addAttribute("user",user);
            return "index";
        }

    }



    //去登录页面的方法
    @RequestMapping(value="tologin",method= RequestMethod.GET)
    public String tologin(){
        return "login";
    }

    //验证登录的方法
    @RequestMapping(value="login",method=RequestMethod.POST)
    public String login(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            @RequestParam(value = "upwd",defaultValue = "非")String upwd,
            Model model,HttpSession session
    ){
        Users user = us.selectUser(uid, upwd);
      /*  Users users = us.selectByPrimaryKey(uid);*/
        if (user!=null){
            model.addAttribute("user",user);
            return "index";
        }else {
            session.setAttribute("flag",0);
            return "index";
        }

    }


    //去注册页面方法
    @RequestMapping(value="toadd",method= RequestMethod.GET)
    public String toadd(){
        return "register";
    }

    //注册账号结束后返回主页
    @RequestMapping(value="add",method=RequestMethod.POST)
    public String add(Users users){
        us.insert(users);
        return "index";
    }


    //用户修改信息数据回显方法
    @RequestMapping(value="toupdateUser",method= RequestMethod.GET)
    public String toupdateUser(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){
        Users user = us.selectByPrimaryKey(uid);
        model.addAttribute("user",user);
        return "updateUser";
    }


    //修改好数据后返回主页
    @RequestMapping(value="updateUser",method= RequestMethod.POST)
    public String updateUser(Users users){
        us.updateByPrimaryKeySelective(users);
        return "index";
    }

    //点击借书后用户名下书籍数目加1
    @RequestMapping(value="jiaUbnum",method= RequestMethod.GET)
    public String jieshu(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){
        us.jiaUbnum(uid);
        model.addAttribute("uid",uid);
        return "redirect:bookList.do";
    }

    //点击借书后用户名下书籍数目减1
    @RequestMapping(value="jianUbnum",method= RequestMethod.GET)
    public String huanshu(
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){
        us.jianUbnum(uid);
        model.addAttribute("uid",uid);
        return "redirect:user.do";
    }

    //去用户中心方法
    @RequestMapping("/user")
    public String user(
            Model model,Users users,HttpSession session,
            @RequestParam(value = "uid",defaultValue = "")Integer uid
    ){

        if (uid==null){
            session.setAttribute("flag",1);
            return "index";
        }else {
            Users user = us.selectByPrimaryKey(uid);
            model.addAttribute("user",user);
        }

        List<Records> records = rs.selectByPrimaryKey(uid);
        List<Books> books = bs.selectBooks();
        model.addAttribute("books",books);
        model.addAttribute("records",records);
        return "user";
    }


}
