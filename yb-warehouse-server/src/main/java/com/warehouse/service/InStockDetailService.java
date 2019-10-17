package com.warehouse.service;

import com.github.pagehelper.PageHelper;
import com.system.util.BusinessException;
import com.system.util.PagerInfo;
import com.system.util.ServiceResult;
import com.warehouse.entity.InStockDetailEntity;
import com.warehouse.mapper.InStockDetailMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

@Service("inStockDetailService")
public class InStockDetailService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(InStockDetailService.class);

    @Autowired
    private InStockDetailMapper inStockDetailMapper;

    /**
     * find list
     *
     * @param params
     * @param pagerInfo
     * @return
     */
    public ServiceResult<List<InStockDetailEntity>> findList(Map<String, Object> params, PagerInfo<?> pagerInfo) {
        Assert.notNull(this.inStockDetailMapper, "Property 'inStockDetailMapper' is required.");
        ServiceResult<List<InStockDetailEntity>> result = new ServiceResult<List<InStockDetailEntity>>();
        try {
            if (pagerInfo != null) {
                PageHelper.startPage(pagerInfo.getPageIndex(), pagerInfo.getPageSize());
            }
            result.setResult(this.inStockDetailMapper.findList(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockDetailService][findList]：query findList occur exception", e);
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
    public ServiceResult<InStockDetailEntity> findInfo(Map<String, Object> params) {
        Assert.notNull(this.inStockDetailMapper, "Property 'inStockDetailMapper' is required.");
        ServiceResult<InStockDetailEntity> result = new ServiceResult<InStockDetailEntity>();
        try {
            result.setResult(this.inStockDetailMapper.findInfo(params));
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockDetailService][findInfo]：query findInfo by param occur exception", e);
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
    public ServiceResult<Integer> doInsert(InStockDetailEntity inStockDetailEntity) {
        Assert.notNull(this.inStockDetailMapper, "Property 'inStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        int id = 0;
        try {
            int success = this.inStockDetailMapper.doInsert(inStockDetailEntity);
            if (success > 0) {
                id = inStockDetailEntity.getInStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockDetailService][doInsert]：query doInsert by id occur exception", e);
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
    public ServiceResult<Integer> doUpdate(InStockDetailEntity inStockDetailEntity) {
        Assert.notNull(this.inStockDetailMapper, "Property 'inStockDetailMapper' is required.");
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        Integer id = 0;
        try {
            Integer success = this.inStockDetailMapper.doUpdate(inStockDetailEntity);
            if (success > 0) {
                id = inStockDetailEntity.getInStockDetailId();
            }
            result.setResult(id);
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Unknown error!");
            LOGGER.error("[InStockDetailService][doUpdate]：query doInsert by id occur exception", e);
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
    public ServiceResult<Boolean> doDelete(int inStockDetailId) {
        Assert.notNull(this.inStockDetailMapper, "Property 'inStockDetailMapper' is required.");
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        boolean flag = false;
        try {
            int id = this.inStockDetailMapper.doDelete(inStockDetailId);
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
            LOGGER.error("[InStockDetailService][doDelete]：query doDelete by id occur exception", e);
        }
        return result;
    }
}