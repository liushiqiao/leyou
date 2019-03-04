package com.leyou.item.mapper;

import com.leyou.item.entry.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 18070943
 * @create 2018-12-16 10:02
 * @desc 接口
 **/

public interface CategoryMapper extends Mapper<Category> {

    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}
