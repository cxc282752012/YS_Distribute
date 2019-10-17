package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.CustomerMasterEntity;
import com.sales.mapper.CustomerMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("customerMasterService")
public class CustomerMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerMasterService.class);

    @Autowired
    private CustomerMasterMapper customerMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 17:27
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<CustomerMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.customerMasterMapper, "Property 'customerMasterMapper' is required.");
        ServiceResult<List<CustomerMasterEntity>> result = new ServiceResult<List<CustomerMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.customerMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 17:27
     * @Param [params]
     **/
    public ServiceResult<CustomerMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.customerMasterMapper, "Property 'customerMasterMapper' is required.");
        ServiceResult<CustomerMasterEntity> result = new ServiceResult<CustomerMasterEntity>();
        try {
            result.setResult(this.customerMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 17:27
     * @Param [customerMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(CustomerMasterEntity customerMasterEntity) {
        Assert.notNull(this.customerMasterMapper, "Property 'customerMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.customerMasterMapper.doInsert(customerMasterEntity);
            if (success > 0) {
                id = customerMasterEntity.getCustomerId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 17:27
     * @Param [customerMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(CustomerMasterEntity customerMasterEntity) {
        Assert.notNull(this.customerMasterMapper, "Property 'customerMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.customerMasterMapper.doUpdate(customerMasterEntity);
            if (success > 0) {
                id = customerMasterEntity.getCustomerId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 17:28
     * @Param [customerId]
     **/
    public ServiceResult<Boolean> doDelete(int customerId) {
        Assert.notNull(this.customerMasterMapper, "Property 'customerMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.customerMasterMapper.doDelete(customerId);
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
            LOGGER.error("[CustomerMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}