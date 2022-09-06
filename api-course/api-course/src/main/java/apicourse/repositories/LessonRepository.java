package apicourse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicourse.models.LessonModel;

@Repository
public interface LessonRepository extends JpaRepository<LessonModel, UUID> {

}
