package com.purchase.service;

import com.github.pagehelper.PageHelper;
import com.purchase.entity.PurchaseOrderMasterEntity;
import com.purchase.mapper.PurchaseOrderMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("purchaseOrderMasterService")
public class PurchaseOrderMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchaseOrderMasterService.class);

    @Autowired
    private PurchaseOrderMasterMapper purchaseOrderMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<PurchaseOrderMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.purchaseOrderMasterMapper, "Property 'purchaseOrderMasterMapper' is required.");
        ServiceResult<List<PurchaseOrderMasterEntity>> result = new ServiceResult<List<PurchaseOrderMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.purchaseOrderMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderMasterService][findList]：query findList occur exception", e);
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
    public ServiceResult<PurchaseOrderMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.purchaseOrderMasterMapper, "Property 'purchaseOrderMasterMapper' is required.");
        ServiceResult<PurchaseOrderMasterEntity> result = new ServiceResult<PurchaseOrderMasterEntity>();
        try {
            result.setResult(this.purchaseOrderMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchaseOrderMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(PurchaseOrderMasterEntity purchaseOrderMasterEntity) {
        Assert.notNull(this.purchaseOrderMasterMapper, "Property 'purchaseOrderMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.purchaseOrderMasterMapper.doInsert(purchaseOrderMasterEntity);
            if (success > 0) {
                id = purchaseOrderMasterEntity.getPurchaseId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchaseOrderMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(PurchaseOrderMasterEntity purchaseOrderMasterEntity) {
        Assert.notNull(this.purchaseOrderMasterMapper, "Property 'purchaseOrderMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.purchaseOrderMasterMapper.doUpdate(purchaseOrderMasterEntity);
            if (success > 0) {
                id = purchaseOrderMasterEntity.getPurchaseId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchaseOrderMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:55
     * @Param [purchaseId]
     **/
    public ServiceResult<Boolean> doDelete(int purchaseId) {
        Assert.notNull(this.purchaseOrderMasterMapper, "Property 'purchaseOrderMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.purchaseOrderMasterMapper.doDelete(purchaseId);
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
            LOGGER.error("[PurchaseOrderMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}