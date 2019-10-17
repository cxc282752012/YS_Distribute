package com.admin.utils;

import com.system.entity.UserMasterEntity;
import com.system.util.BaseWebUtil;
import com.system.util.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class WebUtil extends BaseWebUtil {

    public static String domainName;

    @Value("${domain.path}")
    public void setDomainName(String path) {
        WebUtil.domainName = path;
    }

    /**
     * 从cookie中获取customer数据
     *
     * @param request
     * @return
     * @Description
     * @author chen
     */
    public static int getUserId(HttpServletRequest request) {
        int userId = 0;
        String userIdStr = readCookie(request, "userId");
        if (!StringUtil.isEmpty(userIdStr)) {
            userId = Integer.parseInt(userIdStr);
        }
        return userId;
    }

    /**
     * 判断用户是否登录
     *
     * @param request
     * @return
     * @Description
     * @author wangyuhai
     */
    public static boolean isCustomerLogin(HttpServletRequest request) {
        boolean isUserLogin = false;
        String userId = readCookie(request, "userId");
        if (!StringUtil.isEmpty(userId)) {
            isUserLogin = true;
        }
        return isUserLogin;
    }

    /**
     * 用户登录成功后保存cookie
     *
     * @param response
     * @param userMasterEntity
     * @Description
     * @author wangyuhai
     */
    public static void saveCookie(HttpServletResponse response, UserMasterEntity userMasterEntity) {
        if (userMasterEntity != null) {
            writeCookie(response, "userId", String.valueOf(userMasterEntity.getUserId()));
            writeCookie(response, "userName", StringUtil.nullSafeString(userMasterEntity.getUserName()));
            writeCookie(response, "userPhone", userMasterEntity.getUserPhone());
            writeCookie(response, "userPassword", userMasterEntity.getUserPassword());
        }
    }

    /**
     * 用户退出登录后删除所有cookie
     *
     * @param response
     * @Description
     * @author wangyuhai
     */
    public static void deleteAllCookies(HttpServletResponse response) {
        deleteCookie(response, "userId");
        deleteCookie(response, "userName");
        deleteCookie(response, "userPhone");
        deleteCookie(response, "userPassword");
    }

    public static void writeCookie(HttpServletResponse response, String name, String value) {
        writeCookie(response, domainName, name, value, 60 * 60 * 24 * 30);
    }

    public static void deleteCookie(HttpServletResponse response, String name) {
        deleteCookie(response, domainName, name);
    }
}
