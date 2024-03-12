package TrainingjavaSpring.boot.cabinet.service.mapping;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;
import TrainingjavaSpring.boot.cabinet.dto.response.CabinetResponse;
import TrainingjavaSpring.boot.cabinet.entity.CabinetEntity;

public class CabinetMapping {
    public static CabinetEntity convertDtoToEntity(CabinetRequest dto){
        CabinetEntity entity = new CabinetEntity();
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        return entity;
    }
    public static CabinetResponse convertEntityToCabinetResponse(CabinetEntity entity){
        CabinetResponse dto = new CabinetResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
