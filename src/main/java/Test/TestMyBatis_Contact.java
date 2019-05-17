package Test;


import model.mapper.ContactMapper;
import model.mapper.GroupInfoMapper;
import model.po.Contact;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MyBatisUtil;

import java.util.Collections;
import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/13 19:01
 * Description:
 */
public class TestMyBatis_Contact {
    private static Logger logger = LoggerFactory.getLogger(TestMyBatis_Contact.class.getName());

    @Test
    public void list() {
        SqlSession session = MyBatisUtil.getSesssion();
        ContactMapper mapper = session.getMapper(ContactMapper.class);
        List<Contact> list = mapper.listByUserId(1);
        for (Contact c : list) {
            logger.info(c.getUserInfo1().getUserName() + " " + c.getUserInfo2().getUserName());
        }
    }
}
