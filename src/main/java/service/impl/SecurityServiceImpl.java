package service.impl;

import model.mapper.UserInfoMapper;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.SecurityService;

import javax.servlet.http.HttpSession;

/**
 * @Author: Azhu
 * @Date: 2019/5/9 10:13
 * Description:
 */
public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityServiceImpl.class);
    @Override
    public ResponseJson login(String username, String password, HttpSession session) {
        return null;
    }

    @Override
    public ResponseJson logout(HttpSession session) {
        return null;
    }
}
