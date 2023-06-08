package com.eugene.eugeneblog.service.impl;


import com.eugene.eugeneblog.controller.vo.BlogDetailVO;
import com.eugene.eugeneblog.controller.vo.BlogListVO;
import com.eugene.eugeneblog.controller.vo.SimpleBlogListVO;
import com.eugene.eugeneblog.dao.*;
import com.eugene.eugeneblog.entity.*;
import com.eugene.eugeneblog.service.BlogService;
import com.eugene.eugeneblog.service.ProductService;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import com.eugene.eugeneblog.utils.PageResult;
import com.eugene.eugeneblog.utils.PatternUtil;
import com.eugene.eugeneblog.utils.MarkDownUtil;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDimensionMapper productDimensionMapper;


//    @Override
//    public PageResult getBlogsPage(PageQueryUtil pageUtil) {
//        List<Blog> blogList = blogMapper.findBlogList(pageUtil);
//        int total = blogMapper.getTotalBlogs(pageUtil);
//        PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), pageUtil.getPage());
//        return pageResult;
//    }
//
//    @Override
//    public int getTotalBlogs() {
//        return blogMapper.getTotalBlogs(null);
//    }

    @Override
    public PageResult getAllProductBasicInfo(PageQueryUtil pageUtil) {
        List<ProductDimension> productBasicInfoListList = productDimensionMapper.findProductBasicInfoList(pageUtil);
        int total = productDimensionMapper.getTotalProducts(pageUtil);
        PageResult pageResult = new PageResult(productBasicInfoListList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
}
