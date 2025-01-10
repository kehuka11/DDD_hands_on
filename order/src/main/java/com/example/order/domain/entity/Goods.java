package com.example.order.domain.entity;

import com.example.order.domain.value.GoodsId;
import com.example.order.domain.value.MerchantId;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Goods {

    private final GoodsId goodsId;

    private final String goodsName;

    private final Long price;

    private final MerchantId merchantId;

    private Goods (GoodsId goodsId, String goodsName, Long price, MerchantId merchantId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.merchantId = merchantId;
    }

    public static Goods newGoods(GoodsId goodsId, String goodsName, Long price, MerchantId merchantId) {
        if (Objects.isNull(goodsId) || Objects.isNull(goodsName) || Objects.isNull(price) || Objects.isNull(merchantId))
            throw new IllegalArgumentException("");

        return new Goods(
                goodsId,
                goodsName,
                price,
                merchantId
        );
    }
}
