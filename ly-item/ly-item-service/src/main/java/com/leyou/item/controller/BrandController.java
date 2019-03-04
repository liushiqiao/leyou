package com.leyou.item.controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.node.JsonNodeCreator;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.entry.Brand;
import com.leyou.item.entry.Category;
import com.leyou.item.service.BrandService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-16 16:34
 * @desc 品牌api
 **/
@Controller
@RequestMapping("brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key) {
        PageResult<Brand> pageResult = brandService.queryBrandByPageAndSort(page, rows, sortBy, desc, key);
        if (pageResult == null || CollectionUtils.isEmpty(pageResult.getItems())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 新增品牌
     * 
     * @param brand
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveBrand(Brand brand, @RequestParam("cids") List<Long> cids) {
        this.brandService.saveBrand(brand, cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *
     * 删除品牌
     */
    @DeleteMapping("/delete/bid/{bid}")
    public ResponseEntity<Void> deleteBrand(@PathVariable("bid") Long bid) {
        this.brandService.deleteBrand(bid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}