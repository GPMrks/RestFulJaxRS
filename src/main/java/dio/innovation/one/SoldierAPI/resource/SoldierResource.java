package dio.innovation.one.SoldierAPI.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import dio.innovation.one.SoldierAPI.controller.SoldierController;
import dio.innovation.one.SoldierAPI.entity.Soldier;
import dio.innovation.one.SoldierAPI.response.SoldierListResponse;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SoldierResource {

    private ObjectMapper objectMapper;

    public SoldierResource(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldierListResponse createLink(Soldier soldier) {
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldier, SoldierListResponse.class);
        Link linkSelf = linkTo(methodOn(SoldierController.class).getSoldier(soldier.getId())).withSelfRel();
        Link linkGetCollection = linkTo(methodOn(SoldierController.class).getAll()).withRel("GET - COLLECTION");
        soldierListResponse.add(linkSelf, linkGetCollection);
        return soldierListResponse;
    }

}
