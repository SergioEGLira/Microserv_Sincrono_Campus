package apiauthuser.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiauthuser.models.UserCourseModel;
import apiauthuser.models.UserModel;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourseModel, UUID> {

	boolean existsByUserAndCourseId(UserModel userModel, UUID courseId);

}
