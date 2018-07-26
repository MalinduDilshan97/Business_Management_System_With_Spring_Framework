package lk.ijse.eCommerce.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GRNDetails_PK implements Serializable {

    private int grnId;
    private int iCode;

    public GRNDetails_PK() {
    }

    public GRNDetails_PK(int grnId, int iCode) {
        this.grnId = grnId;
        this.iCode = iCode;
    }
}
