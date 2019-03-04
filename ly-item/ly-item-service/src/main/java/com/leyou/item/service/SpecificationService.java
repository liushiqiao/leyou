package com.leyou.item.service;

import com.leyou.item.entry.Specification;
import com.leyou.item.mapper.SpecificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-21 14:45
 * @desc Specification
 **/
@Service
public class SpecificationService {

    @Autowired
    SpecificationMapper specificationMapper;

    public Specification queryById(Long id) {
        return this.specificationMapper.selectByPrimaryKey(id);
    }
}