package com.system.service;

import com.github.pagehelper.PageHelper;
import com.system.entity.BusinessMasterEntity;
import com.system.mapper.BusinessMasterMapper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("businessMasterService")
public class BusinessMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BusinessMasterService.class);

    @Autowired
    private BusinessMasterMapper businessMasterMapper;

    /**
     * find list
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:42
     * @Param [params, pagerInfo]
     **/
    public ServiceResult<List<BusinessMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(businessMasterMapper, "Property 'businessMasterMapper' is required.");
        ServiceResult<List<BusinessMasterEntity>> result = new ServiceResult<>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.businessMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:42
     * @Param [params]
     **/
    public ServiceResult<BusinessMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(businessMasterMapper, "Property 'businessMasterMapper' is required.");
        ServiceResult<BusinessMasterEntity> result = new ServiceResult<>();
        try {
            result.setResult(this.businessMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessMasterService][findInfo]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:41
     * @Param [businessMasterEntity]
     **/
    public ServiceResult<Integer> doInsert(BusinessMasterEntity businessMasterEntity) {
        Assert.notNull(businessMasterMapper, "Property 'businessMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        int id = 0;
        try {
            Integer success = this.businessMasterMapper.doInsert(businessMasterEntity);
            if (success > 0) {
                id=businessMasterEntity.getBusinessId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessMasterService][doInsert]：do Insert occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author qinwanli
     * @Description //TODO
     * @Date 2019/5/20 13:41
     * @Param [businessMasterEntity]
     **/
    public ServiceResult<Integer> doUpdate(BusinessMasterEntity businessMasterEntity) {
        Assert.notNull(businessMasterMapper, "Property 'businessMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<>();
        Integer id = 0;
        try {
            Integer success = this.businessMasterMapper.doUpdate(businessMasterEntity);
            if (success > 0) {
                id = businessMasterEntity.getBusinessId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[BusinessMasterService][doUpdate]： do update occur exception", e);
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
        Assert.notNull(businessMasterMapper, "Property 'businessMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<>();
        boolean flag = false;
        try {
            int id = this.businessMasterMapper.doDelete(businessId);
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
            LOGGER.error("[BusinessMasterService][doDelete]：do delete occur exception", e);
        }
        return result;
    }

}
