package service.impl;

import model.mapper.ContactMapper;
import model.mapper.UserInfoMapper;
import model.po.Contact;
import model.po.UserInfo;
import model.vo.ResponseJson;
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

    @Autowired
    ContactMapper contactMapper;

    @Override
    public ResponseJson getByUserId(Integer userId) {
        UserInfo userInfo = userInfoMapper.getByUserId(userId);
        return new ResponseJson().success()
                .setData("userInfo", userInfo);
    }

    @Override
    public UserInfo get(Integer i) {
        return userInfoMapper.get(i);
    }

    @Override
    public ResponseJson contact(Integer userId, String findName) {
        UserInfo userInfo = userInfoMapper.getByUsername(findName);
        if (userInfo == null) {
            return new ResponseJson().error("不存在该用户名,请检查");
        }
        contactMapper.join(userId, userInfo.getUserId());
        contactMapper.join(userInfo.getUserId(), userId);
        return new ResponseJson().success().setMsg("用户" + userId + "添加用户" + userInfo.getUserId() + "好友成功！");
    }
}
