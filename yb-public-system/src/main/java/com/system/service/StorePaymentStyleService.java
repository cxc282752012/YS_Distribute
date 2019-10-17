package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.StorePaymentStyleEntity;
import com.system.mapper.StorePaymentStyleMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("storePaymentStyleService")
public class StorePaymentStyleService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StorePaymentStyleService.class);

    @Autowired
    private StorePaymentStyleMapper storePaymentStyleMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:32
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<StorePaymentStyleEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(storePaymentStyleMapper, "Property 'storePaymentStyleMapper' is required.");
        ServiceResult<List<StorePaymentStyleEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.storePaymentStyleMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StorePaymentStyleService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:32
     * @Param [params]
     **/
    public ServiceResult<StorePaymentStyleEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(storePaymentStyleMapper, "Property 'storePaymentStyleMapper' is required.");
        ServiceResult<StorePaymentStyleEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.storePaymentStyleMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StorePaymentStyleService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do Insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:32
     * @Param [storePaymentStyleEntity]
     **/
    public ServiceResult<Integer> doInsert(StorePaymentStyleEntity storePaymentStyleEntity) {
        Assert.notNull(storePaymentStyleMapper, "Property 'storePaymentStyleMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.storePaymentStyleMapper.doInsert(storePaymentStyleEntity);
            if (success > 0) {
                id=storePaymentStyleEntity.getPaymentStyleId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StorePaymentStyleService][doInsert]：do Insert occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:31
     * @Param [storePaymentStyleEntity]
     **/
    public ServiceResult<Integer> doUpdate(StorePaymentStyleEntity storePaymentStyleEntity) {
        Assert.notNull(storePaymentStyleMapper, "Property 'storePaymentStyleMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.storePaymentStyleMapper.doUpdate(storePaymentStyleEntity);
            if (success > 0) {
                id=storePaymentStyleEntity.getPaymentStyleId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[StorePaymentStyleService][doUpdate]： do update occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 11:31
     * @Param [userRolePermissionId]
     **/
    public ServiceResult<Boolean> doDelete(int userRolePermissionId) {
        Assert.notNull(storePaymentStyleMapper, "Property 'storePaymentStyleMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.storePaymentStyleMapper.doDelete(userRolePermissionId);
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
            LOGGER.error("[StorePaymentStyleService][doDelete]：do delete occur exception", e);
        }
        return result;
    }

}
