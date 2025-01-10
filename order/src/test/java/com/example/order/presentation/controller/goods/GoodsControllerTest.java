package com.example.order.presentation.controller.goods;

import com.example.order.usecase.goods.RegisterGoodsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class GoodsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RegisterGoodsService registerGoodsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("正常: 商品登録リクエストが成功する")
    void 商品登録リクエストが成功する() throws Exception {
        // Arrange
        String requestBody = """
            {
                "goodsName": "Test Goods",
                "price": 500
            }
        """;

        // Act & Assert
        mockMvc.perform(post("/goods/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());


        // Verify
        verify(registerGoodsService).registerGoods("Test Goods", 500L);
    }

    @Test
    @DisplayName("異常: 商品名がブランクでバリデーションエラー")
    void 商品名がブランクでバリデーションエラー() throws Exception {
        // Arrange
        String requestBody = """
            {
                "goodsName": "",
                "price": 500
            }
        """;

        // Act & Assert
        mockMvc.perform(post("/goods/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.goodsName").value("必須項目です"));


    }

    @Test
    @DisplayName("異常: 商品名が最大文字数を超えてバリデーションエラー")
    void 商品名が最大文字数を超えてバリデーションエラー() throws Exception {
        // Arrange
        String requestBody = """
            {
                "goodsName": "あいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあいうえおあ",
                "price": 500
            }
        """;

        // Act & Assert
        mockMvc.perform(post("/goods/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.goodsName").value("0文字以上100文字以内が有効です"));

    }

    @Test
    @DisplayName("異常: 金額が最小より小さくバリデーションエラー")
    void 金額が最小より小さくバリデーションエラー() throws Exception {
        // Arrange
        String requestBody = """
            {
                "goodsName": "テスト商品",
                "price": -500
            }
        """;

        // Act & Assert
        mockMvc.perform(post("/goods/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.price").value("0以上を指定してください"));

    }

    @Test
    @DisplayName("異常: 金額がNullバリデーションエラー")
    void 金額がNullバリデーションエラー() throws Exception {
        // Arrange
        String requestBody = """
            {
                "goodsName": "テスト商品"
            }
        """;

        // Act & Assert
        mockMvc.perform(post("/goods/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.price").value("必須項目です"));

    }
}
