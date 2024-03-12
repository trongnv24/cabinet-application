package TrainingjavaSpring.boot.cabinet.service.impl;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;
import TrainingjavaSpring.boot.cabinet.dto.response.CabinetResponse;
import TrainingjavaSpring.boot.cabinet.entity.CabinetEntity;
import TrainingjavaSpring.boot.cabinet.repository.CabinetRepository;
import TrainingjavaSpring.boot.cabinet.service.CabinetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static TrainingjavaSpring.boot.cabinet.service.mapping.CabinetMapping.convertDtoToEntity;
import static TrainingjavaSpring.boot.cabinet.service.mapping.CabinetMapping.convertEntityToCabinetResponse;

@Service
@Slf4j
public class CabinetServiceImpl implements CabinetService {
    private final CabinetRepository cabinetRepository;

    public CabinetServiceImpl(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public CabinetResponse create(CabinetRequest request) {
        log.info(" === Start api create new cabinet === ");
        log.info(" === Request Body : {} === ", request);
        CabinetEntity entity = convertDtoToEntity(request);
        entity = cabinetRepository.save(entity);
        CabinetResponse response = convertEntityToCabinetResponse(entity);
        log.info(" === Finish api create new cabinet, Cabinet Id : { }", response.getId());
        return response;
    }
}
