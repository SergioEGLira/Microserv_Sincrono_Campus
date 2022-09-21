package apiauthuser.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiauthuser.models.UserCourseModel;
import apiauthuser.models.UserModel;
import apiauthuser.repositories.UserCourseRepository;
import apiauthuser.services.UserCourseService;

@Service
public class UserCourseServiceImpl implements UserCourseService {
	
	 @Autowired
	 UserCourseRepository userCourseRepository;

	 @Override
	    public boolean existsByUserAndCourseId(UserModel userModel, UUID courseId) {
	        return userCourseRepository.existsByUserAndCourseId(userModel, courseId);
	    }

	    @Override
	    public UserCourseModel save(UserCourseModel userCourseModel) {
	        return userCourseRepository.save(userCourseModel);
	    }

}
