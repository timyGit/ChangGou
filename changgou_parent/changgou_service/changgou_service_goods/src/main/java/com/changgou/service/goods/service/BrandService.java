package com.changgou.service.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有品牌的
     */
    public List<Brand> findAll();

    /**
     * 根据id查询
     */
    public Brand findById(Integer id);

    /**
     * 新增品牌
     */
    public void add(Brand brand);
    /**
     * 修改品牌
     */
    public void update(Brand brand);
    /**
     * 删除品牌了了了了了了了
     * @param id
     */
    public void delete(Integer id);

    /**
     * 多条件搜索品牌数据的方法
     * @param searchMap
     * @return
     */
    public List<Brand> findList(Map<String,Object> searchMap);
}
