package TrainingjavaSpring.boot.cabinet.repository;

import TrainingjavaSpring.boot.cabinet.entity.CabinetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinetRepository extends JpaRepository<CabinetEntity, String> {
}
