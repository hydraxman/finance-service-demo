package edu.nathan.finance.service.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
public class InsuranceProductInput {

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

    @JsonProperty("start_date")
    private Date startDate;

    @JsonProperty("main_image_url")
    private String mainImageUrl;

    @JsonProperty("clause_id")
    private int clauseId;

    @JsonProperty("end_date")
    private Date endDate;
}
