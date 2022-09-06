package apicourse.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apicourse.repositories.ModuleRepository;
import apicourse.services.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
    ModuleRepository moduleRepository;

}
