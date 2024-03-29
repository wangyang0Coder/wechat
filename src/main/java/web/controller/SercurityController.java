package web.controller;

import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SecurityService;


import javax.servlet.http.HttpSession;

/**
 * @Author: Azhu
 * @Date: 2019/5/11 9:56
 * Description:
 */
@Controller
public class SercurityController {
    private static Logger logger = LoggerFactory.getLogger(SercurityController.class);
    @Autowired
    SecurityService securityService;


    //入口  url=http://localhost:8080/wechat/Login -> login_old.html
    @RequestMapping(value = {"/login", "/Login", "/"}, method = RequestMethod.GET)
    public String toLogin() {
        return "/login";//这里是返回html名称
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson login(HttpSession session,
                              @RequestParam String username,
                              @RequestParam String password) {
        logger.info("收到登入请求");
        return securityService.login(username, password, session);
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson logout(HttpSession session) {
        logger.info("收到登出请求");
        return securityService.logout(session);
    }
    @RequestMapping(value = "sendPasswordMail", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson sendPasswordMail(HttpSession session,@RequestParam String username) {
        return securityService.sendMail(session,username);
    }

}
