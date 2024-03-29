package web.controller;


import model.po.Belong;
import model.po.GroupInfo;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/chatroom")
public class ChatroomController {

    Logger logger = LoggerFactory.getLogger(ChatroomController.class);
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
        logger.info("直接进入聊天室");
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
        Integer userId = (Integer) session.getAttribute(Constant.USER_TOKEN);
        logger.info("输出userID: " + userId);
        //ResponseJson json = userInfoService.getByUserId(userId);
        return userInfoService.getByUserId(userId);
    }

    @RequestMapping(value = "/add_friend", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson addfriend(HttpSession session, @RequestParam String findName) {
        Integer userId = (Integer) session.getAttribute(Constant.USER_TOKEN);
        //ResponseJson json = userInfoService.getByUserId(userId);
        logger.info("接收添加好友请求");
        System.out.println(userId);
        return userInfoService.contact(userId, findName);
    }
}
