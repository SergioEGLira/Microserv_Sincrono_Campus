package apicoursespecifications;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import apicourse.models.CourseModel;
import apicourse.models.ModuleModel;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

public class SpecificationTemplate {

	@And({ @Spec(path = "courseLevel", spec = Equal.class), 
			@Spec(path = "courseStatus", spec = Equal.class),
			@Spec(path = "name", spec = Like.class) })
	public interface CourseSpec extends Specification<CourseModel> {
	}

	@Spec(path = "title", spec = Like.class)
    public interface ModuleSpec extends Specification<ModuleModel> {		
	}
		
	public static Specification<ModuleModel> moduleCourseId(final UUID courseId) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<ModuleModel> module = root;
            Root<CourseModel> course = query.from(CourseModel.class);
            Expression<Collection<ModuleModel>> coursesModules = course.get("modules");
            return cb.and(cb.equal(course.get("courseId"), courseId), cb.isMember(module, coursesModules));
        };
    }
}
