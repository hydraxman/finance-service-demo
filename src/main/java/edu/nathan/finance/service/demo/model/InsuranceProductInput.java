package edu.nathan.finance.service.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
public class InsuranceProductInput {

    private String productName;

    private int term;

    private String type;

    private String paymentMethod;

    private BigDecimal price;

    private String description;

    private String startDate;

    private String mainImageUrl;

    private int userId;

}
