package com.purchase.service;

import com.github.pagehelper.PageHelper;
import com.purchase.entity.SupplierMasterEntity;
import com.purchase.mapper.SupplierMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("supplierMasterService")
public class SupplierMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SupplierMasterService.class);

    @Autowired
    private SupplierMasterMapper supplierMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:20
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<SupplierMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.supplierMasterMapper, "Property 'supplierMasterMapper' is required.");
        ServiceResult<List<SupplierMasterEntity>> result = new ServiceResult<List<SupplierMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.supplierMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SupplierMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:20
     * @Param [params]
     **/
    public ServiceResult<SupplierMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.supplierMasterMapper, "Property 'supplierMasterMapper' is required.");
        ServiceResult<SupplierMasterEntity> result = new ServiceResult<SupplierMasterEntity>();
        try {
            result.setResult(this.supplierMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SupplierMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:20
     * @Param [supplierMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(SupplierMasterEntity supplierMasterEntity) {
        Assert.notNull(this.supplierMasterMapper, "Property 'supplierMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.supplierMasterMapper.doInsert(supplierMasterEntity);
            if (success > 0) {
                id = supplierMasterEntity.getSupplierId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SupplierMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:21
     * @Param [supplierMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(SupplierMasterEntity supplierMasterEntity) {
        Assert.notNull(this.supplierMasterMapper, "Property 'supplierMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.supplierMasterMapper.doUpdate(supplierMasterEntity);
            if (success > 0) {
                id = supplierMasterEntity.getSupplierId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[SupplierMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/21 13:21
     * @Param [supplierId]
     **/
    public ServiceResult<Boolean> doDelete(int supplierId) {
        Assert.notNull(this.supplierMasterMapper, "Property 'supplierMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.supplierMasterMapper.doDelete(supplierId);
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
            LOGGER.error("[SupplierMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}