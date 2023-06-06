package com.eugene.eugeneblog.service;


import com.eugene.eugeneblog.entity.BlogTagCount;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import com.eugene.eugeneblog.utils.PageResult;

import java.util.List;

public interface TagService {

    /**
     * 查询标签的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getBlogTagPage(PageQueryUtil pageUtil);

    int getTotalTags();

    Boolean saveTag(String tagName);

    Boolean deleteBatch(Integer[] ids);

    List<BlogTagCount> getBlogTagCountForIndex();
}
