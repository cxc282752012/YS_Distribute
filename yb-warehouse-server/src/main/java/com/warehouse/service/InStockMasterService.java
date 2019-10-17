package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.InStockMasterEntity;
import com.warehouse.mapper.InStockMasterMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("inStockMasterService")
public class InStockMasterService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InStockMasterService.class);

    @Autowired
    private InStockMasterMapper inStockMasterMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<InStockMasterEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.inStockMasterMapper, "Property 'inStockMasterMapper' is required.");
        ServiceResult<List<InStockMasterEntity>> result = new ServiceResult<List<InStockMasterEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.inStockMasterMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockMasterService][findList]：query findList occur exception", e);
        }
        return result;
    }

    /**
     * find info
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:53
     * @Param [params]
     **/
    public ServiceResult<InStockMasterEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.inStockMasterMapper, "Property 'inStockMasterMapper' is required.");
        ServiceResult<InStockMasterEntity> result = new ServiceResult<InStockMasterEntity>();
        try {
            result.setResult(this.inStockMasterMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockMasterService][findInfo]：query findInfo by param occur exception", e);
        }
        return result;
    }

    /**
     * do insert
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailEntity]
     **/
    public ServiceResult<Integer> doInsert(InStockMasterEntity inStockMasterEntity) {
        Assert.notNull(this.inStockMasterMapper, "Property 'inStockMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.inStockMasterMapper.doInsert(inStockMasterEntity);
            if (success > 0) {
                id = inStockMasterEntity.getInStockId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockMasterService][doInsert]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do update
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailEntity]
     **/
    public ServiceResult<Integer> doUpdate(InStockMasterEntity inStockMasterEntity) {
        Assert.notNull(this.inStockMasterMapper, "Property 'inStockMasterMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.inStockMasterMapper.doUpdate(inStockMasterEntity);
            if (success > 0) {
                id = inStockMasterEntity.getInStockId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockMasterService][doUpdate]：query doInsert by id occur exception", e);
        }
        return result;
    }

    /**
     * do delete
     *
     * @Author chenxichao
     * @Description //TODO
     * @Date 2019-05-17 15:54
     * @Param [checkStockDetailId]
     **/
    public ServiceResult<Boolean> doDelete(int inStockId) {
        Assert.notNull(this.inStockMasterMapper, "Property 'inStockMasterMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.inStockMasterMapper.doDelete(inStockId);
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
            LOGGER.error("[InStockMasterService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}