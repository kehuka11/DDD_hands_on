package com.example.order.domain.repository;

import com.example.order.domain.entity.Goods;

public interface GoodsRepository {
    Goods getById(String id);
    void register(Goods goods);
}
