package com.leyou.item.service;

import com.github.pagehelper.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.entry.Brand;
import com.leyou.item.mapper.BrandMapper;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-16 15:16
 * @desc 品牌biz
 **/
@Service
public class BrandService {

    @Autowired
    BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, Boolean desc,
            String key) {
        // 开始分页
        PageHelper.startPage(page, rows);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().andLike("name", "%" + key + "%").orEqualTo("letter", key);
        }
        if (StringUtils.isNotBlank(sortBy)) {
            // 排序
            String orderByClause = sortBy + (desc ? " desc" : " asc");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(pageInfo.getTotal(), pageInfo);
    }

    public void saveBrand(Brand brand, List<Long> cids) {
        this.brandMapper.insertSelective(brand);
        for (Long cid : cids) {
            this.brandMapper.insertCategoryBrand(cid, brand.getId());
        }
    }

    public void deleteBrand(Long bid) {
        this.brandMapper.deleteByPrimaryKey(bid);
        this.brandMapper.deleteCategoryAndBrandByBid(bid);
    }
}