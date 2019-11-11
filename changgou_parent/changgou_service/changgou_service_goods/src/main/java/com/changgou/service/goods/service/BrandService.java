package com.changgou.service.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有品牌的
     */
    public List<Brand> findAll();

    /**
     * 根据id查询
     */
    public Brand findById(Integer id);
}
