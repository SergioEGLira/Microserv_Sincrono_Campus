package apicourse.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import apicourse.clients.AuthUserClient;
import apicourse.models.CourseModel;
import apicourse.models.CourseUserModel;
import apicourse.repositories.CourseUserRepository;
import apicourse.services.CourseUserService;

@Service
public class CourseUserServiceImpl implements CourseUserService {

	@Autowired
	CourseUserRepository courseUserRepository;

	@Autowired
    AuthUserClient authUserClient;
	
	@Override
    public boolean existsByCourseAndUserId(CourseModel courseModel, UUID userId) {
        return courseUserRepository.existsByCourseAndUserId(courseModel, userId);
    }

	@Transactional
    @Override
    public CourseUserModel saveAndSendSubscriptionUserInCourse(CourseUserModel courseUserModel) {
        courseUserModel = courseUserRepository.save(courseUserModel);
        authUserClient.postSubscriptionUserInCourse(courseUserModel.getCourse().getCourseId(), courseUserModel.getUserId());
        return courseUserModel;
    }

}
