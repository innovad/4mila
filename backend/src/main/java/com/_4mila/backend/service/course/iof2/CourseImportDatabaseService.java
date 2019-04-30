package com._4mila.backend.service.course.iof2;

import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class CourseImportDatabaseService extends AbstractCrudDatabaseService<CourseImport, Long> {

	@Override
	public Class<CourseImport> getEntityClass() {
		return CourseImport.class;
	}

	@Override
	public void createPathListEntry(CourseImport entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
	}
	
}
