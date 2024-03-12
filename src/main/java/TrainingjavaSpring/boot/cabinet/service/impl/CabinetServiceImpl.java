package TrainingjavaSpring.boot.cabinet.service.impl;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;
import TrainingjavaSpring.boot.cabinet.dto.response.CabinetResponse;
import TrainingjavaSpring.boot.cabinet.entity.CabinetEntity;
import TrainingjavaSpring.boot.cabinet.exception.NotFoundException;
import TrainingjavaSpring.boot.cabinet.repository.CabinetRepository;
import TrainingjavaSpring.boot.cabinet.service.CabinetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    @Override
    public CabinetResponse getById(String id){
        log.info(" === Start api getById cabinet === ");
        log.info(" === String id : {} === ", id);
        Optional<CabinetEntity> optionalCabinet = cabinetRepository.findById(id);
        if ( !optionalCabinet.isPresent()){
            throw new NotFoundException(" không tìm thấy", id, null);
        }
        CabinetEntity entity = optionalCabinet.get();
        entity = cabinetRepository.save(entity);
        CabinetResponse response = convertEntityToCabinetResponse(entity);
        log.info(" === Finish api getById cabinet, Cabinet Id : {} ", response.getId());
        return response;
    }
    @Override
    public CabinetResponse update(CabinetRequest request, String id){
        log.info(" === Start api update cabinet === ");
        log.info(" === Request Body : {}, String id : {} ", request, id);
        Optional<CabinetEntity>optionalCabinet = cabinetRepository.findById(id);
        if (!optionalCabinet.isPresent()){
            throw  new RuntimeException();
        }
        CabinetEntity entity = optionalCabinet.get();
        entity.setName(request.getName());
        entity.setQuantity(request.getQuantity());
        entity.setPrice(request.getPrice());
        entity = cabinetRepository.save(entity);
        CabinetResponse response = convertEntityToCabinetResponse(entity);
        log.info(" === Finish api update cabinet, Cabinet id {} : ", response.getId());
        return response;
    }

    @Override
    public void deleteById(String id) {
        log.info(" === Start api delete cabinet === ");
        log.info(" === String id : {} === ", id);
        Optional<CabinetEntity> optionalCabinet = cabinetRepository.findById(id);
        if (!optionalCabinet.isPresent()){
            throw new RuntimeException();
        }
        log.info(" === Finish api delete cabinet, Cabinet Id : {} === ");
        cabinetRepository.deleteById(id);
    }
}
