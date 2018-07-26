package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.PlaceCustomerOrderDTO;
import lk.ijse.eCommerce.service.PlaceCustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/PlaceCustomerOrder")
public class PlaceCustomerOrderController {

    @Autowired
    private PlaceCustomerOrderService placeCustomerOrderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeCustomerOrder(@RequestBody PlaceCustomerOrderDTO  placeCustomerOrderDTO){
        return placeCustomerOrderService.placeCustomerOrder(placeCustomerOrderDTO);
    }

}
