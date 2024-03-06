package edu.nathan.finance.service.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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
    private String startDate;

    @JsonProperty("main_image_url")
    private String mainImageUrl;

    @JsonProperty("clause_id")
    private int clauseId;

    @JsonProperty("end_date")
    private String endDate;
}
