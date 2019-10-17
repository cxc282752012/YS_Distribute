package com.purchase.service;

import com.github.pagehelper.PageHelper;
import com.purchase.entity.PurchasePlanMasterEntity;
import com.purchase.mapper.PurchasePlanMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("purchasePlanMasterService")
public class PurchasePlanMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchasePlanMasterService.class);

    @Autowired
    private PurchasePlanMasterMapper purchasePlanMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<PurchasePlanMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.purchasePlanMasterMapper, "Property 'purchasePlanMasterMapper' is required.");
        ServiceResult<List<PurchasePlanMasterEntity>> result = new ServiceResult<List<PurchasePlanMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.purchasePlanMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params]
     **/
    public ServiceResult<PurchasePlanMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.purchasePlanMasterMapper, "Property 'purchasePlanMasterMapper' is required.");
        ServiceResult<PurchasePlanMasterEntity> result = new ServiceResult<PurchasePlanMasterEntity>();
        try {
            result.setResult(this.purchasePlanMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchasePlanMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(PurchasePlanMasterEntity purchasePlanMasterEntity) {
        Assert.notNull(this.purchasePlanMasterMapper, "Property 'purchasePlanMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.purchasePlanMasterMapper.doInsert(purchasePlanMasterEntity);
            if (success > 0) {
                id = purchasePlanMasterEntity.getPurchasePlanId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchasePlanMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(PurchasePlanMasterEntity purchasePlanMasterEntity) {
        Assert.notNull(this.purchasePlanMasterMapper, "Property 'purchasePlanMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.purchasePlanMasterMapper.doUpdate(purchasePlanMasterEntity);
            if (success > 0) {
                id = purchasePlanMasterEntity.getPurchasePlanId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:55
     * @Param [purchasePlanId]
     **/
    public ServiceResult<Boolean> doDelete(int purchasePlanId) {
        Assert.notNull(this.purchasePlanMasterMapper, "Property 'purchasePlanMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.purchasePlanMasterMapper.doDelete(purchasePlanId);
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
            LOGGER.error("[PurchasePlanMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}