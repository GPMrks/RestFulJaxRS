package dio.innovation.one.SoldierAPI.service;

import dio.innovation.one.SoldierAPI.dto.Soldier;
import dio.innovation.one.SoldierAPI.exception.SoldierNotFoundException;
import dio.innovation.one.SoldierAPI.repository.SoldierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldierService {

    private SoldierRepository soldierRepository;

    public SoldierService(SoldierRepository soldierRepository) {
        this.soldierRepository = soldierRepository;
    }

    public List<Soldier> getAll(){
        return soldierRepository.findAll();
    }

    public Soldier getSoldier(Long id){

        final Optional<Soldier> soldier = soldierRepository.findById(id);

        if (soldier.isPresent()){
            return soldier.get();
        }
        else{
            throw new SoldierNotFoundException(id);
        }

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
        final Soldier soldier = getSoldier(id);
        soldierRepository.deleteById(id);
    }
}
