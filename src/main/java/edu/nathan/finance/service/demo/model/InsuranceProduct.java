package edu.nathan.finance.service.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class InsuranceProduct {
    @Id
    @JsonProperty("id")
    private int id;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("term")
    private int term;

    @JsonProperty("type")
    private String type;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("main_image_url")
    private String mainImageUrl;

    @JsonProperty("clause_id")
    private int clauseId;

    // 创建一个yyyy-MM-dd格式的日期
    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public InsuranceProduct(InsuranceProductInput insuranceProductInput) {
        this.productName = insuranceProductInput.getProductName();
        this.term = insuranceProductInput.getTerm();
        this.type = insuranceProductInput.getType();
        this.paymentMethod = insuranceProductInput.getPaymentMethod();
        this.price = insuranceProductInput.getPrice();
        this.description = insuranceProductInput.getDescription();
        this.mainImageUrl = insuranceProductInput.getMainImageUrl();
        this.clauseId = insuranceProductInput.getClauseId();
    }
}
