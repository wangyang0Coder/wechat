package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Azhu
 * @Date: 2019/4/2 17:46
 * Description:
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory=null;
    /*
    SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，
    没有任何理由丢弃它或重新创建另一个实例。
    使用 SqlSessionFactory 的最佳实践是在应用运行期间不要重复创建多次，
    多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。
    因此 SqlSessionFactory 的最佳作用域是应用作用域。 有很多方法可以做到，
    最简单的就是使用单例模式或者静态单例模式。
    */
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   /*
   每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，
   因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域
   */
   public static SqlSession getSesssion(){
       return factory.openSession(true);
   }
   /*
        测试的时候一直可以查询但是不能修改，mybatis显示修改数据库成功, 但没有修改数据库的原因
        这个原因是因为mybatis默认不是自动提交事务的, 所以其实没有修改数据库,
        刚刚新增完后立即返回的结果,是从mybatis为了提高性能设置的缓存里读取的,不是从数据库读取的
        解决的办法一是在openSession() 的括号里写true, 设定自动提交事务, 一是在代码中加入sqlSession.commit()
        解决博客
        原文：https://blog.csdn.net/howard789/article/details/77801892
    */
}
