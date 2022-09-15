package apiauthuser.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apiauthuser.repositories.UserCourseRepository;
import apiauthuser.services.UserCourseService;

@Service
public class UserCourseServiceImpl implements UserCourseService {
	
	 @Autowired
	 UserCourseRepository userCourseRepository;

}
