package com.api.utils;

import com.api.service.IProductMasterService;
import com.product.entity.ProductMasterEntity;
import com.system.util.ServiceResult;
import com.system.util.SystemException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionRedisUtil {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SessionRedisUtil.class);

    @Autowired
    private IProductMasterService productMasterService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${environment.config}")
    private String environmentConfig;

    public static void main(String[] args) {
    }

    public void saveSessionCache(int productId) {
        Map<String, Object> params = null;

        try {
            params = new HashMap<String, Object>();
            params.put("productId", productId);
            ServiceResult<ProductMasterEntity> result = productMasterService.findInfo(params);
            if (result.getSuccess() && result.getResult() != null) {
                ProductMasterEntity productMasterEntity = result.getResult();
                saveCache(String.valueOf(productId), productMasterEntity.getProductId() + "");
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }

    public void saveCache(String key, String value) {
        stringRedisTemplate.opsForValue().set(environmentConfig + key, value);
    }

    public String getCache(String key) {
        String result = stringRedisTemplate.opsForValue().get(environmentConfig + key);
        return result;
    }

    public void removeCache(String key) {
        if (stringRedisTemplate.hasKey(environmentConfig + key)) {
            String result = stringRedisTemplate.opsForValue().get(environmentConfig + key);
            stringRedisTemplate.delete(environmentConfig + key);
            result = stringRedisTemplate.opsForValue().get(environmentConfig + key);
        }

    }
}
