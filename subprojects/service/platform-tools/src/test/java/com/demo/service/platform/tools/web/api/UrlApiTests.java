package com.demo.service.platform.tools.web.api;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.framework.service.web.api.BaseTest;

@RunWith(SpringRunner.class)
@WebMvcTest(UrlApi.class)
// @AutoConfigureRestDocs(outputDir = "build/generated-snippets")
public class UrlApiTests extends BaseTest {
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/urls").accept(MediaType.APPLICATION_JSON)) // 调用"/urls"接口，返回application/json格式的响应
                .andExpect(status().isOk()) // 调用成功
                .andDo(document("index")); // 生成文档
    }
}
