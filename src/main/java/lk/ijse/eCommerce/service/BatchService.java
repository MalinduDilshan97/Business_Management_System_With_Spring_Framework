package lk.ijse.eCommerce.service;

import lk.ijse.eCommerce.dto.BatchDTO;

import java.util.List;

public interface BatchService {

    public boolean addBatch(BatchDTO batchDTO);

    public boolean removeBatch(int id);

    public boolean updateBatch(BatchDTO batchDTO);

    public List<BatchDTO> getAllBatches();

    public BatchDTO getBatch(int id);

}
