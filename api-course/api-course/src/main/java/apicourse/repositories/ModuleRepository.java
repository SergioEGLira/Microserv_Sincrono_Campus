package apicourse.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import apicourse.models.ModuleModel;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleModel, UUID> {

	@Query(value="select * from tb_modules where course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllLModulesIntoCourse(@Param("courseId") UUID courseId);

}
