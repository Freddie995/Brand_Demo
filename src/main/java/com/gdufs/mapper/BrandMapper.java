package com.gdufs.mapper;

import com.gdufs.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/28
 */


public interface BrandMapper {
    //查询所有
    @Select("select * from brand order by id desc")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    //插入数据
    @Insert("insert into brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    //根据id查询
    @Select("select * from brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改
     * @param brand
     */
    @Update("update brand set brand_name = #{brandName},company_name = #{companyName},ordered =#{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);

    @Delete("delete from brand where id = #{id}")
    void deleteById(int id);

    //批量删除
    void deleteByIds(@Param("ids") int[] ids);

    //分页查询
    @Select("select * from brand limit #{begin} , #{size}")
    @ResultMap("brandResultMap")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("size") int size );

    //查询总记录数
    @Select("select count(*) from brand ")
    int selectTotalCount();

    //分页条件查询
    List<Brand> selectByPageAndCondition(@Param("begin")int begin,@Param("size")int size,@Param("brand")Brand brand);
    //根据条件查询总记录
    int selectTotalCountByCondition(Brand brand);
}