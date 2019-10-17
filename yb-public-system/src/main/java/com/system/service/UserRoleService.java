package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.UserRoleEntity;
import com.system.mapper.UserRoleMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("userRoleService")
public class UserRoleService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserRoleService.class);

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:22
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<UserRoleEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(userRoleMapper, "Property 'userRoleMapper' is required.");
        ServiceResult<List<UserRoleEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.userRoleMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRoleService][findList]：query findList occur exception", e);
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
    public ServiceResult<UserRoleEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(userRoleMapper, "Property 'userRoleMapper' is required.");
        ServiceResult<UserRoleEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.userRoleMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRoleService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 16:46
     * @Param [userRoleEntity]
     **/
    public ServiceResult<Integer> doInsert(UserRoleEntity userRoleEntity) {
        Assert.notNull(userRoleMapper, "Property 'userRoleMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.userRoleMapper.doInsert(userRoleEntity);
            if (success > 0) {
                id=userRoleEntity.getUserRoleId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRoleService][doInsert]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:06
     * @Param [userRoleEntity]
     **/
    public ServiceResult<Integer> doUpdate(UserRoleEntity userRoleEntity) {
        Assert.notNull(userRoleMapper, "Property 'userRoleMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.userRoleMapper.doUpdate(userRoleEntity);
            if (success > 0) {
                id=userRoleEntity.getUserRoleId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserRoleService][doUpdate]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/17 17:14
     * @Param [userRoleId]
     **/
    public ServiceResult<Boolean> doDelete(int userRoleId) {
        Assert.notNull(userRoleMapper, "Property 'userRoleMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.userRoleMapper.doDelete(userRoleId);
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
            LOGGER.error("[UserRoleService][doDelete]：query findList occur exception", e);
        }
        return result;
    }

}
