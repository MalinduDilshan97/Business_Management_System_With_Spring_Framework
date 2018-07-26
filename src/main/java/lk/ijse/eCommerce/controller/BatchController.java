package lk.ijse.eCommerce.controller;

import lk.ijse.eCommerce.dto.BatchDTO;
import lk.ijse.eCommerce.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addBatch(@RequestBody BatchDTO batchDTO){
        return batchService.addBatch(batchDTO);
    }

    @DeleteMapping(value = "{batchId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteBatch(@PathVariable("batchId") int batchId){
        return batchService.removeBatch(batchId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateBatch(@RequestBody BatchDTO batchDTO){
        return batchService.updateBatch(batchDTO);
    }

    @GetMapping(value = "{batchId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public BatchDTO getBatch(@PathVariable("batchId") int batchId){
        return batchService.getBatch(batchId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BatchDTO> getAllBatches(){
        return batchService.getAllBatches();
    }
}
