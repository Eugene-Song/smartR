package com.eugene.eugeneblog.controller.admin;


import com.eugene.eugeneblog.entity.Blog;
import com.eugene.eugeneblog.service.BlogService;
import com.eugene.eugeneblog.service.CategoryService;
import com.eugene.eugeneblog.service.ProductService;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import com.eugene.eugeneblog.utils.Result;
import com.eugene.eugeneblog.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;


@Controller
@RequestMapping("/admin")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/products/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(productService.getAllProductBasicInfo(pageUtil));
    }

    @GetMapping("/products")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "products");
        return "admin/product";
    }

}
