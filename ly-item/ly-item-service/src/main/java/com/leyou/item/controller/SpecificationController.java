package com.leyou.item.controller;

import com.leyou.item.entry.Specification;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 18070943
 * @create 2018-12-21 14:44
 * @desc Specification
 **/
@Controller
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;

    @GetMapping("/groups/{id}")
    public ResponseEntity<String> querySpecificationByCategoryId(@PathVariable("id") Long id) {

        Specification specification = specificationService.queryById(id);
        if (specification == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(specification.getSpecifications());
    }

}