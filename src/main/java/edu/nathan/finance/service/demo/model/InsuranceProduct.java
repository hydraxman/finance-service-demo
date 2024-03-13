package edu.nathan.finance.service.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InsuranceProduct {
    @Id
    private int id;

    private String productName;

    private int term;

    private String type;

    private String paymentMethod;

    private BigDecimal price;

    private String description;

    private String startDate;

    private String mainImageUrl;

    private int userId;


    public InsuranceProduct(InsuranceProductInput insuranceProductInput) {
        this.productName = insuranceProductInput.getProductName();
        this.term = insuranceProductInput.getTerm();
        this.type = insuranceProductInput.getType();
        this.paymentMethod = insuranceProductInput.getPaymentMethod();
        this.price = insuranceProductInput.getPrice();
        this.description = insuranceProductInput.getDescription();
        this.startDate = insuranceProductInput.getStartDate();
        this.mainImageUrl = insuranceProductInput.getMainImageUrl();
        this.userId = insuranceProductInput.getUserId();
    }
}
