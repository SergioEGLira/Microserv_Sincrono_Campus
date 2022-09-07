package apicourse.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.models.CourseModel;
import apicourse.models.LessonModel;
import apicourse.models.ModuleModel;
import apicourse.repositories.CourseRepository;
import apicourse.repositories.LessonRepository;
import apicourse.repositories.ModuleRepository;
import apicourse.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
    CourseRepository courseRepository;

	@Autowired
    ModuleRepository moduleRepository;

    @Autowired
    LessonRepository lessonRepository;
	
	@Transactional
    @Override
    public void delete(CourseModel courseModel) {
        List<ModuleModel> moduleModelList = moduleRepository.findAllLModulesIntoCourse(courseModel.getCourseId());
        if (!moduleModelList.isEmpty()){
            for(ModuleModel module : moduleModelList){
                List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(module.getModuleId());
                if (!lessonModelList.isEmpty()){
                    lessonRepository.deleteAll(lessonModelList);
                }
            }
            moduleRepository.deleteAll(moduleModelList);
        }
        courseRepository.delete(courseModel);
    }

	@Override
    public Optional<CourseModel> findById(UUID courseId) {
        return courseRepository.findById(courseId);
    }

}
