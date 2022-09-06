package apicourse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicourse.models.ModuleModel;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

}
