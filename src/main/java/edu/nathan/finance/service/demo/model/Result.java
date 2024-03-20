package edu.nathan.finance.service.demo.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class Result extends RepresentationModel<Result> {
    private int code;
    private String message;
    private Object data;
}
