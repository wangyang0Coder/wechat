package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Azhu
 * @Date: 2019/5/6 10:03
 * Description:描述消息类型的枚举类
 */
public enum ChatType {
    LOGIN, REGISTER, SINGLE_SENDING, GROUP_SENDING, FILE_MSG_SINGLE_SENDING, FILE_MSG_GROUP_SENDING;
    private static final Logger logger= LoggerFactory.getLogger(ChatType.class);
    public static void main(String[] args) {
        logger.info(String.valueOf(ChatType.REGISTER));
    }
}
