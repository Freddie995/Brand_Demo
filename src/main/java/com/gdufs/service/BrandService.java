package com.gdufs.service;

import com.gdufs.mapper.BrandMapper;
import com.gdufs.pojo.Brand;
import com.gdufs.pojo.PageBean;
import com.gdufs.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Description:
 * Param:
 * return:
 * Author:Freddie
 * Date: 2022/6/28
 */


public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //查询所有
    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll()
        //2.获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3.获取brandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.调用方法
        List<Brand>  brands = mapper.selectAll();
        sqlSession.close();
        return brands;
    }

    public void add(Brand brand){
        SqlSession sqlSession = factory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();

        sqlSession.close();

    }
    public Brand selectById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        sqlSession.close();
        return brand;
    }
    public void update(Brand brand){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteByIds(int[] ids){
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
    public PageBean<Brand> selectByPage(int currentPage,int pageSize){
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;
        //5. 查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        //6. 查询总记录数
        int totalCount = mapper.selectTotalCount();
        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);

        pageBean.setTotalCount(totalCount);
        //8. 释放资源
        sqlSession.close();
        return pageBean;
    }
    public PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize,Brand brand){
        //2. 获取SqlSession对象
        SqlSession sqlSession =
                factory.openSession();
        //3. 获取BrandMapper
        BrandMapper mapper =
                sqlSession.getMapper(BrandMapper.class);
        //4. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        // 计算查询条目数
        int size = pageSize;
        // 处理brand条件，模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length()
                > 0) {brand.setBrandName("%" + brandName +
                "%");
        }
        String companyName = brand.getCompanyName();
        if (companyName != null &&
                companyName.length() > 0) {
            brand.setCompanyName("%" + companyName +
                    "%");
        }
         //5. 查询当前页数据
        List<Brand> rows =
                mapper.selectByPageAndCondition(begin, size, brand);
        //6. 查询总记录数
        int totalCount =
                mapper.selectTotalCountByCondition(brand);
        //7. 封装PageBean对象
        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);
        //8. 释放资源
        sqlSession.close();
        return pageBean;
    }



}
