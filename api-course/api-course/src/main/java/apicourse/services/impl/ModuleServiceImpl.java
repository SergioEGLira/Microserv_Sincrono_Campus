package apicourse.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.models.LessonModel;
import apicourse.models.ModuleModel;
import apicourse.repositories.LessonRepository;
import apicourse.repositories.ModuleRepository;
import apicourse.services.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
    ModuleRepository moduleRepository;

	@Autowired
    LessonRepository lessonRepository;
	
	@Override
    public ModuleModel save(ModuleModel moduleModel) {
        return moduleRepository.save(moduleModel);
    }

	@Transactional
	@Override
	public void delete(ModuleModel moduleModel) {
		List<LessonModel> lessonModelList = lessonRepository.findAllLessonsIntoModule(moduleModel.getModuleId());
		if (!lessonModelList.isEmpty()) {
			lessonRepository.deleteAll(lessonModelList);
		}
		moduleRepository.delete(moduleModel);
	}
	
	@Override
    public Optional<ModuleModel> findModuleIntoCourse(UUID courseId, UUID moduleId) {
        return moduleRepository.findModuleIntoCourse(courseId, moduleId);
    }

}
