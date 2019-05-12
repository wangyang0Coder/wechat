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

import javax.servlet.http.HttpSession;

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
        session.setAttribute(Constant.USER_TOKEN, userInfo.getUserId());
        return new ResponseJson().success();
    }

    @Override
    public ResponseJson logout(HttpSession session) {
        return null;
    }

    @Override
    public ResponseJson register(String username, String password, HttpSession session) {
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        System.out.println("调用register");
        if (userInfo == null) {
            userInfo = new UserInfo(username, password);
            userInfoMapper.insert(userInfo);
            return new ResponseJson().success("注册成功");
        } else {
            return new ResponseJson().error("用户名已存在");
        }
    }
}
