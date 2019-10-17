package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.UserPermissionEntity;
import com.system.mapper.UserPermissionMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("userPermissionService")
public class UserPermissionService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserPermissionService.class);

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:02
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<UserPermissionEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.userPermissionMapper, "Property 'userPermissionMapper' is required.");
        ServiceResult<List<UserPermissionEntity>> result = new ServiceResult<List<UserPermissionEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.userPermissionMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserPermissionService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:03
     * @Param [params]
     **/
    public ServiceResult<UserPermissionEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.userPermissionMapper, "Property 'userPermissionMapper' is required.");
        ServiceResult<UserPermissionEntity> result = new ServiceResult<UserPermissionEntity>();
        try {
            result.setResult(this.userPermissionMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserPermissionService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:03
     * @Param [userPermissionEntity]
     **/
    public ServiceResult<Integer> doInsert(UserPermissionEntity userPermissionEntity) {
        Assert.notNull(this.userPermissionMapper, "Property 'userPermissionMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.userPermissionMapper.doInsert(userPermissionEntity);
            if (success > 0) {
                id = userPermissionEntity.getPermissionId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserPermissionService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:04
     * @Param [userPermissionEntity]
     **/
    public ServiceResult<Integer> doUpdate(UserPermissionEntity userPermissionEntity) {
        Assert.notNull(this.userPermissionMapper, "Property 'userPermissionMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.userPermissionMapper.doUpdate(userPermissionEntity);
            if (success > 0) {
                id = userPermissionEntity.getPermissionId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserPermissionService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:04
     * @Param [userId]
     **/
    public ServiceResult<Boolean> doDelete(int userId) {
        Assert.notNull(this.userPermissionMapper, "Property 'userPermissionMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.userPermissionMapper.doDelete(userId);
            if (id > 0) {
                flag = true;
            }
            result.setResult(flag);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserPermissionService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}