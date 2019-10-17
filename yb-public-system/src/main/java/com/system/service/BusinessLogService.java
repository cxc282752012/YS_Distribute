package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.BusinessLogEntity;
import com.system.mapper.BusinessLogMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("businessLogService")
public class BusinessLogService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BusinessLogService.class);

    @Autowired
    private BusinessLogMapper businessLogMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:56
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<BusinessLogEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(businessLogMapper, "Property 'businessLogMapper' is required.");
        ServiceResult<List<BusinessLogEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.businessLogMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessLogService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:57
     * @Param [params]
     **/
    public ServiceResult<BusinessLogEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(businessLogMapper, "Property 'businessLogMapper' is required.");
        ServiceResult<BusinessLogEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.businessLogMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessLogService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:57
     * @Param [businessLogEntity]
     **/
    public ServiceResult<Integer> doInsert(BusinessLogEntity businessLogEntity) {
        Assert.notNull(businessLogMapper, "Property 'businessLogMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.businessLogMapper.doInsert(businessLogEntity);
            if (success > 0) {
                id=businessLogEntity.getBusinessLogId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessLogService][doInsert]：do Insert occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:56
     * @Param [businessLogEntity]
     **/
    public ServiceResult<Integer> doUpdate(BusinessLogEntity businessLogEntity) {
        Assert.notNull(businessLogMapper, "Property 'businessLogMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.businessLogMapper.doUpdate(businessLogEntity);
            if (success > 0) {
                id=businessLogEntity.getBusinessLogId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessLogService][doUpdate]： do update occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:41
     * @Param [businessId]
     **/
    public ServiceResult<Boolean> doDelete(int businessId) {
        Assert.notNull(businessLogMapper, "Property 'businessLogMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.businessLogMapper.doDelete(businessId);
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
            LOGGER.error("[BusinessLogService][doDelete]：do delete occur exception", e);
        }
        return result;
    }

}
