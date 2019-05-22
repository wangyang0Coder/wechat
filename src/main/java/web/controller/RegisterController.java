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
import org.springframework.web.multipart.MultipartFile;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * @Author: Azhu
 * @Date: 2019/5/19 10:11
 * Description:
 */
@Controller
public class RegisterController {

    private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    RegisterService registerService;

    @RequestMapping(value = {"/toRegister"}, method = RequestMethod.GET)
    public String toRegister() {
        return "register";//这里是返回html名称
    }

    @RequestMapping(value = {"/reg", "/register"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson Register(HttpSession session,
                                 @RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String avatarShow) {
        logger.info("收到注册请求");
        return registerService.register(username, password, avatarShow, session);
    }

    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    @ResponseBody
    public ResponseJson upload(
            @RequestParam(value = "file", required = true) MultipartFile file, HttpServletRequest request) {
        logger.info("接收的uploadAvatar访问");
        return registerService.uploadAvatar(file, request);
    }

}
