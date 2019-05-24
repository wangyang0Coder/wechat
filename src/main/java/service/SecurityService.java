package service;

import model.vo.ResponseJson;

import javax.servlet.http.HttpSession;

/**
 * @Author: Azhu
 * @Date: 2019/5/9 10:10
 * Description:
 */
public interface SecurityService {
    ResponseJson login(String username, String password, HttpSession session);

    ResponseJson logout(HttpSession session);

    ResponseJson sendMail(HttpSession session, String username);
}
