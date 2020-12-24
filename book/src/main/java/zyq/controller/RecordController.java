package zyq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import zyq.pojo.Books;
import zyq.pojo.Records;
import zyq.pojo.Users;
import zyq.service.book.BookService;
import zyq.service.record.RecordService;
import zyq.service.user.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2020/12/18.
 */
@Controller
public class RecordController {

    @Autowired
    private RecordService rs;

    @Autowired
    private UserService us;


    //查询所有的借书记录
    @RequestMapping(value="Recordlist",method= RequestMethod.GET)
    public String Recordlist(
            Model model,@RequestParam(value = "uid",defaultValue = "")Integer uid

    ){
        List<Records> records = rs.selectRecords();
        if (uid==null){
            //用户不登录也可以查看所有借阅记录
        }else {
            //但登录的话就要记住登录信息
            Users user = us.selectByPrimaryKey(uid);
            model.addAttribute("user",user);

        }
        model.addAttribute("records",records);
        return "record";
    }

    //点击借书后增加一条借书记录
    @RequestMapping(value="addRecord",method= RequestMethod.GET)
    public String jieshu(
            @RequestParam(value = "bid",defaultValue = "")Integer rbid,
            @RequestParam(value = "uid",defaultValue = "")Integer ruid,
            Model model
    ){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        String date =format.format(new Date());

        Records records = new Records(null,rbid,ruid,date);
        rs.insert(records);
        model.addAttribute("uid",ruid);
        return "redirect:jiaUbnum.do";
    }

    //点击还书后删除对应的借书记录
    @RequestMapping(value="delRecord",method= RequestMethod.GET)
    public String huanshu(
            @RequestParam(value = "rbid",defaultValue = "")Integer rbid,
            @RequestParam(value = "uid",defaultValue = "")Integer uid,
            Model model
    ){

        rs.deleteByPrimaryKey(rbid);
        model.addAttribute("uid",uid);
        return "redirect:jianUbnum.do";
    }



}
