package org.htsg.tacocloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 注解 @RunWith(SpringRunner.class) 在 Junit 5 由 @ExtendWith(SpringExtension.class) 代替
 Spring 2.1.x 后 @ExtendWith(SpringExtension.class) 已添加到 @SpringBootTest
 */
@SpringBootTest
class TacoCloudApplicationTests {

    @Test
    void contextLoads() {
    }

}
