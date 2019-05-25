package service;

import model.po.UserInfo;
import model.vo.ResponseJson;

/**
 * @Author: Azhu
 * @Date: 2019/5/8 13:05
 * Description:
 */
public interface UserInfoService {
    ResponseJson getByUserId(Integer userId);

    UserInfo get(Integer i);

    ResponseJson contact(Integer userId, String addUserId);
}
