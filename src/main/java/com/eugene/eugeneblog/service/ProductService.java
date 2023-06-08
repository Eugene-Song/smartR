package com.eugene.eugeneblog.service;



import com.eugene.eugeneblog.controller.vo.BlogDetailVO;
import com.eugene.eugeneblog.controller.vo.SimpleBlogListVO;
import com.eugene.eugeneblog.entity.Blog;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import com.eugene.eugeneblog.utils.PageResult;

import java.util.List;

public interface ProductService {
    PageResult getAllProductBasicInfo(PageQueryUtil pageUtil);
}
