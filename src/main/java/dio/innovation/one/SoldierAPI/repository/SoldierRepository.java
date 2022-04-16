package dio.innovation.one.SoldierAPI.repository;

import dio.innovation.one.SoldierAPI.dto.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Long> {
}
