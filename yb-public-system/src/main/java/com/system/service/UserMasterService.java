package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.UserMasterEntity;
import com.system.mapper.UserMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("userMasterService")
public class UserMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserMasterService.class);

    @Autowired
    private UserMasterMapper userMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:35
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<UserMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.userMasterMapper, "Property 'userMasterMapper' is required.");
        ServiceResult<List<UserMasterEntity>> result = new ServiceResult<List<UserMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.userMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:34
     * @Param [params]
     **/
    public ServiceResult<UserMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.userMasterMapper, "Property 'userMasterMapper' is required.");
        ServiceResult<UserMasterEntity> result = new ServiceResult<UserMasterEntity>();
        try {
            result.setResult(this.userMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:34
     * @Param [userMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(UserMasterEntity userMasterEntity) {
        Assert.notNull(this.userMasterMapper, "Property 'userMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.userMasterMapper.doInsert(userMasterEntity);
            if (success > 0) {
                id = userMasterEntity.getUserId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:34
     * @Param [userMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(UserMasterEntity userMasterEntity) {
        Assert.notNull(this.userMasterMapper, "Property 'userMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.userMasterMapper.doUpdate(userMasterEntity);
            if (success > 0) {
                id = userMasterEntity.getUserId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[UserMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 14:34
     * @Param [userId]
     **/
    public ServiceResult<Boolean> doDelete(int userId) {
        Assert.notNull(this.userMasterMapper, "Property 'userMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.userMasterMapper.doDelete(userId);
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
            LOGGER.error("[UserMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}