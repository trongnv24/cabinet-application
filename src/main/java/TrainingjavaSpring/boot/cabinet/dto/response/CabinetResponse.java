package TrainingjavaSpring.boot.cabinet.dto.response;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;

public class CabinetResponse extends CabinetRequest {
    private String id;

    public CabinetResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CabinetResponse{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", quantity=" + getQuantity() +
                ", price=" + getPrice() +
                '}';
    }
}
