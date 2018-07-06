package com._4mila.backend.service.course;

import static spark.Spark.get;

import java.util.TreeSet;

import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CourseControlRestService extends AbstractCrudRestService<CourseControl, Long, CourseControlDatabaseService> {

	@Inject
	CourseDatabaseService courseDatabaseService;

	@Inject
	public CourseControlRestService(Injector injector) {
		super(injector, CourseControlDatabaseService.class);
	}

	@Override
	protected void initList() {
		super.initList();

		get("services/course/:courseKey/courseControl", (req, res) -> {
			Long courseNr = Longs.tryParse(req.params("courseKey"));
			return getDatabaseService().createPathList(new TreeSet<>(courseDatabaseService.read(courseNr).getCourseControls()));
		}, getJsonTransformer());		
	}

}
