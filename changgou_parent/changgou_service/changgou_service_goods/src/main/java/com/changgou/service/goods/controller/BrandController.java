package com.changgou.service.goods.controller;

import com.changgou.common.pojo.PageResult;
import com.changgou.common.pojo.Result;
import com.changgou.common.pojo.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据id进行删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除品牌ojbk");
    }

    /**
     * 根据所传查询条件进行模糊查询
     * @param searchMap
     * @return
     */
    @GetMapping("/search")
    public Result findList(@RequestParam Map searchMap){
        List<Brand> list = brandService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 分页查询功能
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable int page,@PathVariable int size){
        //Page<Brand> pageList = brandService.findPage(page, size);
        Page<Brand> pageList = brandService.findPage(page, size);
        //new PageResult(pageList.getTotal(),pageList.getResult())
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"分页搜索ojbk",pageResult);
    }
    /**
     * 分页查询功能
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/search/{page}/{size}")
    public Page<Brand> findPage(@RequestParam Map searchMap,@PathVariable int page,@PathVariable int size){
        Page<Brand> findPageByMap = brandService.findPage(searchMap, page, size);
        return findPageByMap;
    }

}
