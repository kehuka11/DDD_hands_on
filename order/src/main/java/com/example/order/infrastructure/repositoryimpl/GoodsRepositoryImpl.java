package com.example.order.infrastructure.repositoryimpl;

import com.example.order.domain.entity.Goods;
import com.example.order.domain.repository.GoodsRepository;
import com.example.order.domain.value.GoodsId;
import com.example.order.domain.value.MerchantId;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

import static jooq.gen.tables.Goods.GOODS;

@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

    @Autowired
    DSLContext dslContext;

    @Override
    public Goods getById(String id) {
        return
                 dslContext.select(
                        GOODS.GOODS_ID,
                        GOODS.GOODS_NAME,
                        GOODS.AMOUNT,
                         GOODS.MERCHANT_ID
                ).from(GOODS)
                        .where(GOODS.GOODS_ID.eq(id))
                         .fetchOne(record -> Goods.newGoods(
                                 GoodsId.toGoodsId(record.get(GOODS.GOODS_ID)),
                                 record.get(GOODS.GOODS_NAME),
                                 record.get(GOODS.AMOUNT),
                                 MerchantId.toMerchantId(record.get(GOODS.MERCHANT_ID))

                         ));
    }

    @Override
    public void register(Goods goods) {

        dslContext.insertInto(GOODS)
                .set(GOODS.GOODS_ID, goods.getGoodsId().toString())
                .set(GOODS.GOODS_NAME, goods.getGoodsName())
                .set(GOODS.AMOUNT, goods.getPrice())
                .set(GOODS.MERCHANT_ID, goods.getMerchantId().toString())
                .execute();
    }
}
