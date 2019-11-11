package com.changgou.service.goods.service.impl;


import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.dao.BrandMapper;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    //根据id查询
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     *新增品牌
     * @param brand
     */
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 修改品牌数据方法put
     * @param brand
     */
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void delete(Integer id){
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 条件查询
     * 具体是怎么个操作还没有弄清楚,先敲为敬
     * @param searchMap
     * @return
     */
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap!=null){
            //品牌名称
            if (searchMap.get("name")!=null&&!"".equals(searchMap.get("name"))){
                criteria.andLike("name","%"+searchMap.get("name")+"%");
            }
            //根据品牌的首字母进行查询
            if (searchMap.get("letter")!=null&&!"".equals(searchMap.get("letter"))){
                criteria.andLike("letter","%"+searchMap.get("letter")+"%");
            }
        }
        return brandMapper.selectByExample(example);
    }

    @Override
    public Page<Brand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        return (Page<Brand>)brandMapper.selectAll();
    }
}
