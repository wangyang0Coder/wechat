package service.impl;

import model.mapper.UserInfoMapper;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserInfoService;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:07
 * Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public ResponseJson getByUserId(Long userId) {
        UserInfo userInfo = userInfoMapper.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

    @Override
    public UserInfo get(long i) {
        return userInfoMapper.get(i);
    }
}
