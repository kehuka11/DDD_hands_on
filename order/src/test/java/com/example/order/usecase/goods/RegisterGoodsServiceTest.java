package com.example.order.usecase.goods;

import com.example.order.domain.entity.Goods;
import com.example.order.domain.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class RegisterGoodsServiceTest {

    @Mock
    private GoodsRepository goodsRepository;

    private RegisterGoodsService registerGoodsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        registerGoodsService = new RegisterGoodsService(goodsRepository);
    }

    @Test
    void registerGoods_shouldRegisterNewGoods() {
        // Arrange
        String goodsName = "Test Goods";
        Long price = 1000L;

        // Act
        registerGoodsService.registerGoods(goodsName, price);

        // Assert
        ArgumentCaptor<Goods> goodsCaptor = ArgumentCaptor.forClass(Goods.class);
        verify(goodsRepository).register(goodsCaptor.capture());

        Goods capturedGoods = goodsCaptor.getValue();
        assertEquals(goodsName, capturedGoods.getGoodsName());
        assertEquals(price, capturedGoods.getPrice());
    }

}
