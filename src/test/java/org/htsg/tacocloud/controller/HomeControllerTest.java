package org.htsg.tacocloud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                // 响应应该具备 HTTP 200 （OK）状态
                .andExpect(status().isOk())
                // 视图的逻辑名称应该是 home
                .andExpect(view().name("home"))
                // 渲染后的视图应该包含文本 “Welcome to...”
                .andExpect(content().string(containsString("Welcome to...")));
    }
}