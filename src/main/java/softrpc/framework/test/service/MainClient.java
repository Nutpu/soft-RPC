package softrpc.framework.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xctian
 * @date 2020/1/1
 */
public class MainClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainClient.class);

    private static Service1 service1;
    private static Service2 service2;

    static {
        long startTime = System.currentTimeMillis();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rpc-reference.xml");
        // 通过 getBean()方法返回的不是FactoryBean本身，而是FactoryBean#getObject()方法所返回的对象，相当于
        // FactoryBean#getObject()代理了getBean()方法
        service1 = (Service1)context.getBean("Service1");
        service2 = (Service2) context.getBean("Service2");
        long duration = System.currentTimeMillis() - startTime;
        LOGGER.info("客户端初始化完成，耗时{}ms",duration);
    }

    public static void main(String[] args) {
        int $idname;
        service1.sayHi();
        String s = service2.sayMessage("ZJU");
        System.out.println(s);
    }
}
