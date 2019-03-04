package com.leyou.item.service;

import com.leyou.item.entry.Category;
import com.leyou.item.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-16 10:01
 * @desc sevvice
 **/
@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByParentId(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }

    public List<Category> queryByBrandId(Long bid) {
        return this.categoryMapper.queryByBrandId(bid);
    }
}