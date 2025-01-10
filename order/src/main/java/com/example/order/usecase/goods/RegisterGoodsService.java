package com.example.order.usecase.goods;

import com.example.order.domain.entity.Goods;
import com.example.order.domain.repository.GoodsRepository;
import com.example.order.domain.value.GoodsId;
import com.example.order.domain.value.MerchantId;
import org.springframework.stereotype.Service;

@Service
public class RegisterGoodsService {

    private final GoodsRepository goodsRepository;

    public RegisterGoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public void registerGoods(String goodsName, Long price) {
        Goods goods = Goods.newGoods(
                GoodsId.newGoodsId(),
                goodsName,
                price,
                MerchantId.newMerchantId()
        );

        goodsRepository.register(goods);
    }
}
