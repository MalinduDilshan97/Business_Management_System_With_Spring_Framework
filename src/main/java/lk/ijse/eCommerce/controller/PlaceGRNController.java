package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.PlaceGRNDTO;
import lk.ijse.eCommerce.service.PlaceGRNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/PlaceGRN")
public class PlaceGRNController {

    @Autowired
    private PlaceGRNService placeGRNService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeGRN(@RequestBody PlaceGRNDTO placeGRNDTO){
        return placeGRNService.PlaceGRN(placeGRNDTO);
    }

}
