package service.impl;

import model.mapper.UserInfoMapper;
import model.po.UserInfo;
import model.vo.ResponseJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.RegisterService;
import util.FileUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @Author: Azhu
 * @Date: 2019/5/19 9:44
 * Description:
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private final static String SERVER_URL_PREFIX = "http://localhost:8080/wechat/";//这里是访问URL
    private final static String FILE_STORE_PATH = "static/img/avatar";
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseJson register(String username, String password, String avatarShow, String mail, HttpSession session) {
        UserInfo userInfo = userInfoMapper.getByUsername(username);
        if (userInfo == null) {
            userInfo = new UserInfo(username, password, avatarShow,mail);
            userInfoMapper.insert(userInfo);
            LOGGER.info(userInfo.toString() + "注册成功并写入数据库");
            return new ResponseJson().success("注册成功");
        } else {
            return new ResponseJson().error("用户名已存在");
        }
    }

    @Override
    public ResponseJson uploadAvatar(MultipartFile file, HttpServletRequest request) {
        // 重命名文件，防止重名
        String filename = getRandomUUID();
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        String fileSize = FileUtils.getFormatSize(file.getSize());
        // 截取文件的后缀名
        if (originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        filename = filename + suffix;
        String prefix = request.getSession().getServletContext().getRealPath("/") + FILE_STORE_PATH;

        System.out.println("头像存储路径为:" + prefix + "/" + filename);
        Path filePath = Paths.get(prefix, filename);
        try {
            Files.copy(file.getInputStream(), filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseJson().error("头像上传发生错误！");
        }
        return new ResponseJson().success().setMsg("上传头像成功")
                .setData("originalFilename", originalFilename)
                .setData("fileSize", fileSize)
                .setData("fileUrl", FILE_STORE_PATH + "/" + filename);
    }

    /**
     * UUID由以下几部分的组合：
     * （1）当前日期和时间，UUID的第一个部分与时间有关，如果你在生成一个UUID之后，过几秒又生成一个UUID，则第一个部分不同，其余相同。
     * （2）时钟序列。
     * （3）全局唯一的IEEE机器识别号，如果有网卡，从网卡MAC地址获得，没有网卡以其他方式获得。
     *
     * @return
     */
    private String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
