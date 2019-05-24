package service;

import model.vo.ResponseJson;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Azhu
 * @Date: 2019/5/22 14:24
 * Description:
 */
public interface RegisterService {
    ResponseJson uploadAvatar(MultipartFile file, HttpServletRequest request);
    ResponseJson register(String username, String password, String avatarShow, String mail,HttpSession session);
}
