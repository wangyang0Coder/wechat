package common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: Azhu
 * @Date: 2019/5/5 17:44
 * Description:
 */
@Component
@Scope("singleton")
public class AppContext {

    private static final Logger logger= LoggerFactory.getLogger(AppContext.class);
    @PostConstruct
    public void init() {
        for(int i=1;i<=10;i++)
        {
            logger.info("PostConstruct"+i);
        }
    }
}
