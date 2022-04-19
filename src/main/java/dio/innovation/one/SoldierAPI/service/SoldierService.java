package dio.innovation.one.SoldierAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dio.innovation.one.SoldierAPI.controller.SoldierController;
import dio.innovation.one.SoldierAPI.entity.Soldier;
import dio.innovation.one.SoldierAPI.exception.SoldierNotFoundException;
import dio.innovation.one.SoldierAPI.repository.SoldierRepository;
import dio.innovation.one.SoldierAPI.resource.SoldierResource;
import dio.innovation.one.SoldierAPI.response.SoldierListResponse;
import dio.innovation.one.SoldierAPI.response.SoldierResponse;
import org.apache.tomcat.util.digester.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class SoldierService {

    private final SoldierRepository soldierRepository;
    private final SoldierResource soldierResource;
    private final ObjectMapper objectMapper;

    @Autowired
    public SoldierService(SoldierRepository soldierRepository, SoldierResource soldierResource, ObjectMapper objectMapper) {
        this.soldierRepository = soldierRepository;
        this.soldierResource = soldierResource;
        this.objectMapper = objectMapper;
    }

    public List<SoldierListResponse> getAll(){
        List<Soldier> all = soldierRepository.findAll();
        List<SoldierListResponse> soldierListResponses = all.stream()
                .map(soldierResource::createLink)
                .collect(Collectors.toList());
        return soldierListResponses;
    }

    public SoldierResponse getSoldier(Long id) {

        final Optional<Soldier> soldier = soldierRepository.findById(id);
        SoldierResponse soldierResponse;

        if (soldier.isPresent()) {
            soldierResponse = objectMapper.convertValue(soldier, SoldierResponse.class);
        } else {
            throw new SoldierNotFoundException(id);
        }
        return soldierResponse;

    }

    public void createSoldier(Soldier soldier){
        soldierRepository.save(soldier);
    }

    public Soldier updateSoldier(Soldier soldierDTO, Long id) {
        final Optional<Soldier> soldierOptional = soldierRepository.findById(id);
        final Soldier soldier;

        if (soldierOptional.isPresent()){
            soldier = soldierOptional.get();
        }
        else{
            throw new SoldierNotFoundException(id);
        }

        soldier.setName(soldierDTO.getName());
        soldier.setRace(soldierDTO.getRace());
        soldier.setWeapon(soldierDTO.getWeapon());

        return soldierRepository.save(soldier);

    }

    public void deleteSoldier(Long id) {
        final SoldierResponse soldierResponse = getSoldier(id);
        soldierRepository.deleteById(id);
    }
}
