package lk.ijse.eCommerce.controller;


import lk.ijse.eCommerce.dto.PlaceSupplierOrderDTO;
import lk.ijse.eCommerce.service.PlaceSupplierOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/PlaceSupplierOrder")
public class PlaceSupplierOrderController {

    @Autowired
    private PlaceSupplierOrderService placeSupplierOrderService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeSupplierOrder(@RequestBody PlaceSupplierOrderDTO placeSupplierOrderDTO){
        return placeSupplierOrderService.placeSupplierOrder(placeSupplierOrderDTO);
    }

}
