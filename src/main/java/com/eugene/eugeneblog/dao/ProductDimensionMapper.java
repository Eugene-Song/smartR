package com.eugene.eugeneblog.dao;

import com.eugene.eugeneblog.entity.Blog;
import com.eugene.eugeneblog.entity.ProductDimension;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDimensionMapper {

    ProductDimension selectAllRecord();

    List<ProductDimension> findProductBasicInfoList(PageQueryUtil pageUtil);

    int getTotalProducts(PageQueryUtil pageUtil);
}