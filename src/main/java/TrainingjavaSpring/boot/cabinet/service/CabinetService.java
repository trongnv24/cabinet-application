package TrainingjavaSpring.boot.cabinet.service;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;
import TrainingjavaSpring.boot.cabinet.dto.response.CabinetResponse;

public interface CabinetService {
    CabinetResponse create(CabinetRequest request);

    CabinetResponse getById(String id);
}
