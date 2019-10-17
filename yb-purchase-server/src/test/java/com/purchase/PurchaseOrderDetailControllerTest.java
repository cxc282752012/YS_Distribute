package com.purchase;

import com.purchase.entity.PurchaseOrderDetailEntity;
import com.system.util.JsonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseOrderDetailControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void findListTest() throws Exception {
        String result = mockMvc.perform(
                get("/purchaseOrderDetail/findList")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("返回结果{" + result + "}");
    }

    @Test
    public void findInfoTest() throws Exception {
        String result = mockMvc.perform(
                get("/purchaseOrderDetail/findInfo")
                        .param("purchaseDetailId", "1")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("返回结果{" + result + "}");
    }

    @Test
    public void doInsertTest() throws Exception {
        PurchaseOrderDetailEntity entity = new PurchaseOrderDetailEntity();
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setColorName("红色");
        entity.setCustomCode("0001");
        entity.setProductBarcode("00000000");
        entity.setProductDetailId(1);
        entity.setProductPrice(188.0);
        entity.setProductDiscount(1.0);
        entity.setStoreId(1);
        entity.setSizeName("27m");
        String result = mockMvc.perform(
                post("/purchaseOrderDetail/doInsert")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                        .content(JsonUtil.toJson(entity))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("返回结果{" + result + "}");
    }

    @Test
    public void doUpdateTest() throws Exception {
        PurchaseOrderDetailEntity entity = new PurchaseOrderDetailEntity();
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setColorName("红色");
        entity.setCustomCode("0001");
        entity.setProductBarcode("00000000");
        entity.setProductDetailId(1);
        entity.setProductPrice(188.0);
        entity.setProductDiscount(1.0);
        entity.setStoreId(1);
        entity.setSizeName("27m");
        entity.setProductDetailId(1);
        String result = mockMvc.perform(
                post("/purchaseOrderDetail/doUpdate")
                        .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                        .content(JsonUtil.toJson(entity))
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("返回结果{" + result + "}");
    }

    @Test
    public void doDeleteTest() throws Exception {

        String result = mockMvc.perform(
                post("/purchaseOrderDetail/doUpdate")
                        .param("purchaseDetailId", "1")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andReturn()
                .getResponse()
                .getContentAsString();
        System.out.println("返回结果{" + result + "}");
    }

}
