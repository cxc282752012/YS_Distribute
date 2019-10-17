package com.purchase.service;

import com.github.pagehelper.PageHelper;
import com.purchase.entity.PurchasePlanDetailEntity;
import com.purchase.mapper.PurchasePlanDetailMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("purchasePlanDetailService")
public class PurchasePlanDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PurchasePlanDetailService.class);

    @Autowired
    private PurchasePlanDetailMapper purchasePlanDetailMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:53
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<PurchasePlanDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.purchasePlanDetailMapper, "Property 'purchasePlanDetailMapper' is required.");
        ServiceResult<List<PurchasePlanDetailEntity>> result = new ServiceResult<List<PurchasePlanDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.purchasePlanDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanDetailService][findList]：query findList occur exception", e);
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
    public ServiceResult<PurchasePlanDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.purchasePlanDetailMapper, "Property 'purchasePlanDetailMapper' is required.");
        ServiceResult<PurchasePlanDetailEntity> result = new ServiceResult<PurchasePlanDetailEntity>();
        try {
            result.setResult(this.purchasePlanDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanDetailService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchasePlanDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(PurchasePlanDetailEntity purchasePlanDetailEntity) {
        Assert.notNull(this.purchasePlanDetailMapper, "Property 'purchasePlanDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.purchasePlanDetailMapper.doInsert(purchasePlanDetailEntity);
            if (success > 0) {
                id = purchasePlanDetailEntity.getPurchasePlanDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanDetailService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:54
     * @Param [purchasePlanDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(PurchasePlanDetailEntity purchasePlanDetailEntity) {
        Assert.notNull(this.purchasePlanDetailMapper, "Property 'purchasePlanDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.purchasePlanDetailMapper.doUpdate(purchasePlanDetailEntity);
            if (success > 0) {
                id = purchasePlanDetailEntity.getPurchasePlanDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[PurchasePlanDetailService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 14:55
     * @Param [purchasePlanDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int purchasePlanDetailId) {
        Assert.notNull(this.purchasePlanDetailMapper, "Property 'purchasePlanDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.purchasePlanDetailMapper.doDelete(purchasePlanDetailId);
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
            LOGGER.error("[PurchasePlanDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}