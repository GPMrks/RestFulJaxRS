package dio.innovation.one.SoldierAPI.controller;

import dio.innovation.one.SoldierAPI.dto.Soldier;
import dio.innovation.one.SoldierAPI.service.SoldierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SoldierController {

    private SoldierService soldierService;

    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @GetMapping("/v1/soldier")
    public List<Soldier> getAll() {
        return soldierService.getAll();
    }

    @GetMapping("/v1/soldier/{id}")
    public ResponseEntity<Soldier> getSoldier(@PathVariable("id") Long id) {
        final Soldier soldier = soldierService.getSoldier(id);
        return ResponseEntity.ok(soldier);
    }

    @PostMapping("/v1/soldier")
    public ResponseEntity createSoldier(@Valid @RequestBody Soldier soldier) {

        soldierService.createSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1/soldier/{id}")
    public ResponseEntity updateSoldier(@Valid @RequestBody Soldier soldierDTO, @PathVariable("id") Long id) {
        final Soldier soldier = soldierService.updateSoldier(soldierDTO, id);
        return ResponseEntity.ok(soldier);
    }

    @DeleteMapping("/v1/soldier/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoldier(@PathVariable("id") Long id) {
        soldierService.deleteSoldier(id);
    }

}
