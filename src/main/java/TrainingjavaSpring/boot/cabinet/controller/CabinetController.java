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
}
