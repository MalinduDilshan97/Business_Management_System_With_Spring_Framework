package lk.ijse.eCommerce.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CustomerOrderDetails_PK implements Serializable {

    private int coid;
    private int iCode;
    private int batchId;

    public CustomerOrderDetails_PK() {
    }

    public CustomerOrderDetails_PK(int coid, int iCode, int batchId) {
        this.coid = coid;
        this.iCode = iCode;
        this.batchId = batchId;
    }
}
