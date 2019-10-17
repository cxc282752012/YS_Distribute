package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.StoreMasterEntity;
import com.system.mapper.StoreMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("storeMasterService")
public class StoreMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StoreMasterService.class);

    @Autowired
    private StoreMasterMapper storeMasterMapper;

    /**
     * find List
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:26
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<StoreMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(storeMasterMapper, "Property 'storeMasterMapper' is required.");
        ServiceResult<List<StoreMasterEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.storeMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StoreMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:26
     * @Param [params]
     **/
    public ServiceResult<StoreMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(storeMasterMapper, "Property 'storeMasterMapper' is required.");
        ServiceResult<StoreMasterEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.storeMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StoreMasterService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:26
     * @Param [storeMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(StoreMasterEntity storeMasterEntity) {
        Assert.notNull(storeMasterMapper, "Property 'storeMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.storeMasterMapper.doInsert(storeMasterEntity);
            if (success > 0) {
                id=storeMasterEntity.getStoreId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StoreMasterService][doInsert]：do Insert occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:26
     * @Param [storeMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(StoreMasterEntity storeMasterEntity) {
        Assert.notNull(storeMasterMapper, "Property 'storeMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.storeMasterMapper.doUpdate(storeMasterEntity);
            if (success > 0) {
                id=storeMasterEntity.getStoreId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StoreMasterService][doUpdate]： do update occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:25
     * @Param [userRolePermissionId]
     **/
    public ServiceResult<Boolean> doDelete(int userRolePermissionId) {
        Assert.notNull(storeMasterMapper, "Property 'storeMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.storeMasterMapper.doDelete(userRolePermissionId);
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
            LOGGER.error("[StoreMasterService][doDelete]：do delete occur exception", e);
        }
        return result;
    }

}
