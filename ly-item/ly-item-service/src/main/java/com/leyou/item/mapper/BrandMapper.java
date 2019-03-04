package com.leyou.item.mapper;

import com.leyou.item.entry.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 18070943
 * @create 2018-12-16 15:15
 * @desc 品牌接口
 **/
public interface BrandMapper extends Mapper<Brand> {

    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long id);

    @Delete("DELETE FROM tb_category_brand WHERE brand_id=#{bid}")
    void deleteCategoryAndBrandByBid(Long bid);
}