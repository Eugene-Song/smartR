package com.eugene.eugeneblog.service.impl;

import com.eugene.eugeneblog.dao.AdminUserMapper;
import com.eugene.eugeneblog.entity.AdminUser;
import com.eugene.eugeneblog.service.AdminUserService;
import com.eugene.eugeneblog.utils.MD5Util;
import com.eugene.eugeneblog.utils.PageQueryUtil;
import com.eugene.eugeneblog.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;
//
//    @Override
//    public PageResult getAdminUserPage(PageQueryUtil pageUtil) {
//        //当前页的用户列表
//        List<AdminUser> users = adminUserMapper.findAdminUsers(pageUtil);
//        //用户总数
//        int total = adminUserMapper.getTotalAdminUser(pageUtil);
//        //分页信息封装
//        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
//        return pageResult;
//    }

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        if (adminUser != null){
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //修改信息
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }

}
