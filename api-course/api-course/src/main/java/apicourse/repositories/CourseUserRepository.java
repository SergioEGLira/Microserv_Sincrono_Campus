package apicourse.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apicourse.models.CourseModel;
import apicourse.models.CourseUserModel;

@Repository
public interface CourseUserRepository extends JpaRepository<CourseUserModel, UUID> {

	boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId);

}
