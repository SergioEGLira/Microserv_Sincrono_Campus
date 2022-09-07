package apicourse.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import apicourse.models.CourseModel;

public interface CourseService {

	void delete(CourseModel courseModel);

	Optional<CourseModel> findById(UUID courseId);

	Object save(CourseModel courseModel);

	List<CourseModel> findAll();
}
