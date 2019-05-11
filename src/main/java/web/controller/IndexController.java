package web.controller;

/**
 * @Author: Azhu
 * @Date: 2019/5/5 19:23
 * Description:这里是对整个框架的测试,前端能否访问到后台的数据
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.po.Belong;
import model.po.GroupInfo;
import model.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ChatService;
import service.UserInfoService;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ChatService chatService;

    @RequestMapping("index")
    public ModelAndView handleRequest12(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    @RequestMapping("showUser")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("show");
        String s = "";
        for (int i = 1; i < 6; i++) {
            UserInfo userInfo = userInfoService.get(i);
            s = s + userInfo.toString() + "\n";
        }

        mav.addObject("message", s);
        //System.out.println("注解方式——》");
        return mav;
    }

    @RequestMapping("showGroup")
    public ModelAndView handleRequest1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("show");
        String s = "";
        List<GroupInfo> list = chatService.listAll();
        for (GroupInfo groupInfo : list) {
            System.out.println(groupInfo.toString());
            s = s + groupInfo.toString() + "\n";
            List<Belong> list1 = groupInfo.getMembers();

            if (null != list1) {
                for (Belong belong : list1) {
                    s = s + "\t" + belong.getUserInfo() + "\n";
                    System.out.format("\t%s\t%s\t%s\n", belong.toString(), belong.getUserInfo().getUserName(), belong.getGroupInfo().getGroupName());
                }
            }
        }
        mav.addObject("message", s);
        //System.out.println("注解方式——》");
        return mav;
    }
}