package org.htsg.tacocloud;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.swing.text.html.HTML;
import java.util.concurrent.TimeUnit;

// @RunWith(SpringRunner.class)
/*
public static final SpringBootTest.WebEnvironment RANDOM_PORT
创建 Web 应用程序上下文（基于响应式或 servlet）并设置server.port=0 Environment属性（通常会触发对随机端口的侦听）。
通常与测试中的@LocalServerPort注入字段结合使用。
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {
    /*
    注入在运行时分配的 HTTP 端口的字段或方法/构造函数参数级别的注释。
    为@Value("${local.server.port}")提供了一个方便的替代方案。
     */
    @LocalServerPort
    private int port;
    /*
    驱动HtmlUnit 的WebDriver实现，它是一个无头（无 GUI）浏览器模拟器。
    主要支持的浏览器是 Chrome、Firefox 和 Internet Explorer。
     */
    private static HtmlUnitDriver browser;

    /*
    @BeforeAll用于表示应在当前测试类中的所有测试之前执行带注释的方法。
     */
    @BeforeAll
    public static void setup() {
        browser = new HtmlUnitDriver();

        browser.manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*
    @AfterAll用于表示应在当前测试类中的所有测试之后执行带注释的方法。
    与@AfterEach方法相反， @AfterEach @AfterAll方法只针对给定的测试类执行一次。
     */
    @AfterAll
    public static void teardown() {
        browser.quit();
    }

    @Test
    public void testHomePage() {
        String homePageUrl = "http://localhost:" + port;
        browser.get(homePageUrl);

        String titleText = browser.getTitle();
        Assertions.assertEquals("Taco Cloud", titleText);

        String h1Text = browser.findElementByTagName(HTML.Tag.H1.toString())
                // 获取此元素的可见（即未被 CSS 隐藏）文本，包括子元素。
                .getText();
        Assertions.assertEquals("Welcome to...", h1Text);

        String imgSrc = browser.findElementByTagName(HTML.Tag.IMG.toString())
                // 获取元素的给定属性的值。
                .getAttribute(HTML.Attribute.SRC.toString());
        Assertions.assertEquals(homePageUrl + "/images/TacoCloud.png", imgSrc);
    }
}
