package TrainingjavaSpring.boot.cabinet.controller;

import TrainingjavaSpring.boot.cabinet.dto.request.CabinetRequest;
import TrainingjavaSpring.boot.cabinet.dto.response.CabinetResponse;
import TrainingjavaSpring.boot.cabinet.service.CabinetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cabinets")
@Slf4j
public class CabinetController {
    private final CabinetService service;

    public CabinetController(CabinetService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CabinetResponse create(@RequestBody CabinetRequest request){
        log.info(" === Start api create new cabinet === ");
        log.info(" === Request Body : {} === ", request);
        CabinetResponse response = service.create(request);
        log.info(" === Finish api create new cabinet, Cabinet Id : {} ===", response.getId());
        return response;
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CabinetResponse getById(@PathVariable ("id") String id){
        log.info(" === Start api getById cabinet === ");
        log.info(" === String id :{} === ", id);
        CabinetResponse response = service.getById(id);
        log.info(" === Finish api getById cabinet, Cabinet Id : {} === ",response.getId());
        return response;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CabinetResponse update(@RequestBody CabinetRequest request, @PathVariable ("id") String id){
        log.info(" === Start api update cabinet === ");
        log.info(" === Request Body : {}, String id : {} === ", request, id);
        CabinetResponse response = service.update(request, id);
        log.info(" === Finish api update cabinet, Cabinet Id : {} === ", response.getId());
        return response;
    }
}
