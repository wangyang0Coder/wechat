package web.controller;


import model.po.Belong;
import model.po.GroupInfo;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.ChatService;
import service.UserInfoService;
import util.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChatroomController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    ChatService chatService;
    
    /**
     * 描述：登录成功后，调用此接口进行页面跳转
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String toChatroom() {
        return "chatroom";
    }
    
    /**
     * 描述：登录成功跳转页面后，调用此接口获取用户信息
     * @param
     * @return
     */
    @RequestMapping(value = "/get_userinfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson getUserInfo(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        return userInfoService.getByUserId((String)userId);
    }
    @RequestMapping("showUser")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("show");
        String s="";
        for(int i=1;i<6;i++)
        {
            UserInfo userInfo=userInfoService.get(i);
            s=s+userInfo.toString()+"\n";
        }

        mav.addObject("message", s);
        //System.out.println("注解方式——》");
        return mav;
    }
    @RequestMapping("showGroup")
    public ModelAndView handleRequest1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("show");
        String s = "";
        List<GroupInfo> list=chatService.listAll();
        for(GroupInfo groupInfo:list){
            System.out.println(groupInfo.toString());
            s = s+groupInfo.toString()+"\n";
            List<Belong> list1=groupInfo.getMembers();

            if(null!=list1){
                for(Belong belong:list1){
                    s = s+"\t"+belong.getUserInfo()+"\n";
                    System.out.format("\t%s\t%s\t%s\n",belong.toString(),belong.getUserInfo().getUserName(),belong.getGroupInfo().getGroupName());
                }
            }
        }
        mav.addObject("message", s);
        //System.out.println("注解方式——》");
        return mav;
    }
}
