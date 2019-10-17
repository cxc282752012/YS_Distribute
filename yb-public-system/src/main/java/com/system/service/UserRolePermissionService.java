package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.UserRolePermissionEntity;
import com.system.mapper.UserRolePermissionMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("userRolePermissionService")
public class UserRolePermissionService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRolePermissionService.class);

    @Autowired
    private UserRolePermissionMapper userRolePermissionMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:22
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<UserRolePermissionEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(userRolePermissionMapper, "Property 'userRolePermissionMapper' is required.");
        ServiceResult<List<UserRolePermissionEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.userRolePermissionMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRolePermissionService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:42
     * @Param [params]
     **/
    public ServiceResult<UserRolePermissionEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(userRolePermissionMapper, "Property 'userRolePermissionMapper' is required.");
        ServiceResult<UserRolePermissionEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.userRolePermissionMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRolePermissionService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:46
     * @Param [userRolePermissionEntity]
     **/
    public ServiceResult<Integer> doInsert(UserRolePermissionEntity userRolePermissionEntity) {
        Assert.notNull(userRolePermissionMapper, "Property 'userRolePermissionMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.userRolePermissionMapper.doInsert(userRolePermissionEntity);
            if (success > 0) {
                id=userRolePermissionEntity.getRolePermissionId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRolePermissionService][doInsert]：do Insert occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:06
     * @Param [userRolePermissionEntity]
     **/
    public ServiceResult<Integer> doUpdate(UserRolePermissionEntity userRolePermissionEntity) {
        Assert.notNull(userRolePermissionMapper, "Property 'userRolePermissionMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.userRolePermissionMapper.doUpdate(userRolePermissionEntity);
            if (success > 0) {
                id=userRolePermissionEntity.getRolePermissionId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRolePermissionService][doUpdate]： do update occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:14
     * @Param [userRolePermissionId]
     **/
    public ServiceResult<Boolean> doDelete(int userRolePermissionId) {
        Assert.notNull(userRolePermissionMapper, "Property 'userRolePermissionMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.userRolePermissionMapper.doDelete(userRolePermissionId);
            if (id > 0) {
                flag = true;
            }
            result.setResult(flag);
        } catch (BusinessException be) {
            result.setResult(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRolePermissionService][doDelete]：do delete occur exception", e);
        }
        return result;
    }

}
