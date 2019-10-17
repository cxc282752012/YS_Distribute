package com.sales.service;

import com.github.pagehelper.PageHelper;
import com.sales.entity.CustomerLevelEntity;
import com.sales.mapper.CustomerLevelMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("customerLevelService")
public class CustomerLevelService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerLevelService.class);

    @Autowired
    private CustomerLevelMapper customerLevelMapper;

    /**
     * find list
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:54
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<CustomerLevelEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.customerLevelMapper, "Property 'customerLevelMapper' is required.");
        ServiceResult<List<CustomerLevelEntity>> result = new ServiceResult<List<CustomerLevelEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.customerLevelMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerLevelService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [params]
     **/
    public ServiceResult<CustomerLevelEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.customerLevelMapper, "Property 'customerLevelMapper' is required.");
        ServiceResult<CustomerLevelEntity> result = new ServiceResult<CustomerLevelEntity>();
        try {
            result.setResult(this.customerLevelMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerLevelService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [customerLevelEntity]
     **/
    public ServiceResult<Integer> doInsert(CustomerLevelEntity customerLevelEntity) {
        Assert.notNull(this.customerLevelMapper, "Property 'customerLevelMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.customerLevelMapper.doInsert(customerLevelEntity);
            if (success > 0) {
                id = customerLevelEntity.getCustomerLevelId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerLevelService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [customerLevelEntity]
     **/
    public ServiceResult<Integer> doUpdate(CustomerLevelEntity customerLevelEntity) {
        Assert.notNull(this.customerLevelMapper, "Property 'customerLevelMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.customerLevelMapper.doUpdate(customerLevelEntity);
            if (success > 0) {
                id = customerLevelEntity.getCustomerLevelId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[CustomerLevelService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Date 2019-05-20 16:55
     * @Param [customerLevelId]
     **/
    public ServiceResult<Boolean> doDelete(int customerLevelId) {
        Assert.notNull(this.customerLevelMapper, "Property 'customerLevelMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.customerLevelMapper.doDelete(customerLevelId);
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
            LOGGER.error("[CustomerLevelService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}