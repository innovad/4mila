package com._4mila.backend.service.course;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Collection;

import com._4mila.backend.model.course.Course;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CourseRestService extends AbstractCrudRestService<Course, Long, CourseDatabaseService> {

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	public CourseRestService(Injector injector) {
		super(injector, CourseDatabaseService.class);
	}

	@Override
	protected void initList() {
		super.initList();

		get("services/event/:eventKey/course", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			return getDatabaseService().createPathList(eventDatabaseService.read(eventNr).getCourses());
		}, getJsonTransformer());
		
		get("services/event/:eventKey/course/summary", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			Collection<PathListEntry<Long>> resultList = new ArrayList<>();
			PathListEntry<Long> entry = new PathListEntry<>();
			entry.setName("Courses"); // translation
			entry.setKey(eventNr, "eventKey");
			entry.getDetails().add("" + eventDatabaseService.read(eventNr).getCourses().size());
			resultList.add(entry);
			return resultList;
		}, getJsonTransformer());
	}

}
