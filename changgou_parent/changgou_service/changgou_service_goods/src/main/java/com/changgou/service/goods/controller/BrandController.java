package com.changgou.service.goods.controller;

import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping
    public Result findAll(){
        List<Brand> brandList = brandService.findAll();
        return new Result(true, StatusCode.OK,"查询ojbk",brandList);
    }
    /**
     * 根据id查询品牌数据
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Brand brand = brandService.findById(id);
        return new Result(true,StatusCode.OK,"根据id查Ojbk",brand);
    }
    /**
     * 新增品牌数据
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"添加Ojbk");
    }
    /**
     * 修改修改put
     */
    @PutMapping("/{id}")
    public Result update(@RequestBody Brand brand,@PathVariable Integer id){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"修改ojbj");
    }
}
