package com.leyou.item.entry;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 18070943
 * @create 2018-12-21 14:40
 * @desc 分组
 **/
@Table(name = "tb_specification")
public class Specification implements Serializable {
    private static final long serialVersionUID = -2002200390916993624L;
    @Id
    private Long categoryId;
    private String specifications;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

}