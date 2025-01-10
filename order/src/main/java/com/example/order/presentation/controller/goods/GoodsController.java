package com.example.order.presentation.controller.goods;

import com.example.order.presentation.model.goods.RegisterGoodsRequest;
import com.example.order.usecase.goods.RegisterGoodsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    private final RegisterGoodsService registerGoodsService;

    public GoodsController(RegisterGoodsService registerGoodsService) {
        this.registerGoodsService = registerGoodsService;
    }

    @PostMapping(value = "/goods/register")
    public void registerGoods(@Valid @RequestBody RegisterGoodsRequest request) {
        registerGoodsService.registerGoods(request.getGoodsName(), request.getPrice());
    }
}
