package service.impl;

import model.mapper.UserInfoMapper;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SecurityService;
import util.Constant;
import util.MailUtil;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.text.MessageFormat;

/**
 * @Author: Azhu
 * @Date: 2019/5/9 10:13
 * Description:
 */
@Service
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityServiceImpl.class);
    @Override
    public ResponseJson login(String username, String password, HttpSession session) {
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if (userInfo == null) {
            return new ResponseJson().error("不存在该用户名");
        }
        if (!userInfo.getPassword().equals(password)) {
            return new ResponseJson().error("密码不正确");
        }
        if (Constant.onlineUserMap.get(String.valueOf(userInfo.getUserId())) != null) {
            return new ResponseJson().error("该用户已经登录");
        }
        session.setAttribute(Constant.USER_TOKEN, userInfo.getUserId());
        session.setAttribute("Azhu", "测试session在JS中怎么读取");
        return new ResponseJson().success();
    }

    @Override
    public ResponseJson logout(HttpSession session) {
        Object userId = session.getAttribute(Constant.USER_TOKEN);
        if (userId == null) {
            return new ResponseJson().error("请先登录！");
        }
        LOGGER.info(MessageFormat.format("userId为 {0} 的用户已注销登录!", userId));
        System.out.println(Constant.webSocketHandshakerMap.size());
        return new ResponseJson().success();
    }

    @Override
    public ResponseJson sendMail(HttpSession session, String username) {
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if (userInfo == null) {
            return new ResponseJson().error("不存在该用户名,请确认");
        }
        if (userInfo.getEmail()==null) {
            return new ResponseJson().error("之前没有设置邮箱,无法找回密码");
        }
        try {
            MailUtil.sendMail(userInfo);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return new ResponseJson().success().setMsg("密码已经发送至你邮箱");
    }
}
