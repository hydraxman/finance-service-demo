package edu.nathan.finance.service.demo.controller;

import edu.nathan.finance.service.demo.model.InsuranceProduct;
import edu.nathan.finance.service.demo.model.Result;
import edu.nathan.finance.service.demo.service.InsuranceProductMemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/insurance-products")
public class InsuranceProductRESTController {

    @Autowired
    private InsuranceProductMemService insuranceProductService;

    @GetMapping
    public List<InsuranceProduct> getAllInsuranceProducts() {
        return insuranceProductService.findAllInsuranceProducts();
    }

    @PostMapping
    public Result createInsuranceProduct(@RequestBody InsuranceProduct insuranceProduct) {
        // Implement the method to create a new insurance product
        Result result = new Result();
        InsuranceProduct newInsuranceProduct = insuranceProductService.createInsuranceProduct(insuranceProduct);
        result.add(linkTo(methodOn(InsuranceProductRESTController.class).getAllInsuranceProducts()).withRel("get all insurance products"));
        result.setData(newInsuranceProduct);
        return result;
    }

    @PutMapping("/{id}")
    public InsuranceProduct updateInsuranceProduct(@PathVariable Integer id, @RequestBody InsuranceProduct insuranceProduct) {
        // Implement the method to update an existing insurance product
        return insuranceProductService.updateInsuranceProduct(id, insuranceProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteInsuranceProduct(@PathVariable String id) {
        // Implement the method to delete an existing insurance product
        insuranceProductService.deleteInsuranceProduct(id);
    }
}