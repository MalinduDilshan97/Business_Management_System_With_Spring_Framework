package lk.ijse.eCommerce.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SupplierOrderDetails_PK implements Serializable {

    private int soid;
    private int iCode;

    public SupplierOrderDetails_PK() {
    }

    public SupplierOrderDetails_PK(int soid, int iCode) {
        this.soid = soid;
        this.iCode = iCode;
    }
}
