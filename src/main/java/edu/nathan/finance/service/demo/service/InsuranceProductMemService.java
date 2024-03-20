package edu.nathan.finance.service.demo.service;

import edu.nathan.finance.service.demo.model.InsuranceProduct;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InsuranceProductMemService {
    List<InsuranceProduct> products = new ArrayList<>();

    {
        InsuranceProduct insuranceProduct = null;
        for (int i = 1; i <= 10; i++) {
            insuranceProduct = new InsuranceProduct();
            insuranceProduct.setId(i);
            insuranceProduct.setProductName("Life Insurance " + i);
            insuranceProduct.setDescription("This is a life insurance product " + i);
            insuranceProduct.setType("Life");
            insuranceProduct.setTerm(100000 + i);
            insuranceProduct.setPrice(BigDecimal.valueOf(1000 + i));
            insuranceProduct.setPaymentMethod(i % 2 == 0 ? "OneTimeOff" : "Installment");
            insuranceProduct.setMainImageUrl("https://ins.product.com/image/" + i);
            insuranceProduct.setUserId(i);
            products.add(insuranceProduct);
        }
    }

    // 保险产品findAll方法，返回一个InsuranceProduct对象列表
    public List<InsuranceProduct> findAllInsuranceProducts() {
        // 根据保险产品InsuranceProduct定义，生成10个保险产品对象数据
        return products;
    }

    // 保险产品create方法，返回一个InsuranceProduct对象
    public InsuranceProduct createInsuranceProduct(InsuranceProduct insuranceProduct) {
        // 实现创建新保险产品的方法
        insuranceProduct.setId(products.size() + 1);
        products.add(insuranceProduct);
        return insuranceProduct;
    }

    // 保险产品put方法，返回一个InsuranceProduct对象
    public InsuranceProduct updateInsuranceProduct(Integer id, InsuranceProduct insuranceProduct) {
        // 实现更新现有保险产品的方法
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.set(i, insuranceProduct);
                return insuranceProduct;
            }
        }
        insuranceProduct.setId(id);
        products.add(insuranceProduct);
        return insuranceProduct;
    }


    public void deleteInsuranceProduct(String id) {

    }
}