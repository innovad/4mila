package com._4mila.backend.server.testdata;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.race.Race;
import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.model.user.User;
import com._4mila.backend.model.user.permission.PermissionFunction;
import com._4mila.backend.model.user.permission.PermissionFunctionEnum;
import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.DateUtility;
import com._4mila.backend.service.clazz.ClazzDatabaseService;
import com._4mila.backend.service.clazz.EventClazzDatabaseService;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.ecard.EcardDatabaseService;
import com._4mila.backend.service.entry.EntryDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;
import com._4mila.backend.service.race.RaceControlDatabaseService;
import com._4mila.backend.service.race.RaceDatabaseService;
import com._4mila.backend.service.runner.RunnerDatabaseService;
import com._4mila.backend.service.settings.SettingsDatabaseService;
import com._4mila.backend.service.user.UserDatabaseService;
import com._4mila.backend.service.user.permission.PermissionFunctionDatabaseService;
import com._4mila.backend.service.user.permission.PermissionRoleDatabaseService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class TestDataService extends AbstractDatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(TestDataService.class);

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	ControlDatabaseService controlDatabaseService;
	
	@Inject
	CourseDatabaseService courseDatabaseService;
	
	@Inject
	ClazzDatabaseService clazzDatabaseService;
	
	@Inject
	EventClazzDatabaseService eventClazzDatabaseService;
	
	@Inject
	CourseControlDatabaseService courseControlDatabaseService;
	
	@Inject
	RunnerDatabaseService runnerDatabaseService;
	
	@Inject
	SettingsDatabaseService settingsDatabaseService;
	
	@Inject
	EcardDatabaseService eCardDatabaseService;
	
	@Inject
	EntryDatabaseService entryDatabaseService;
	
	@Inject
	RaceDatabaseService raceDatabaseService;
	
	@Inject
	RaceControlDatabaseService raceControlDatabaseService;
	
	@Inject
	UserDatabaseService userDatabaseService;

	@Inject
	private PermissionRoleDatabaseService permissionRoleDatabaseService;

	@Inject
	private PermissionFunctionDatabaseService permissionFunctionDatabaseService;

	@Transactional
	public void create() {
		if (eventDatabaseService.list().size() > 0) {
			logger.info("No Test Data");
			return;
		}

		Event event1 = createTestEvent("Pfaffenholz-OL");
		Event event2 = createTestEvent("Swiss Championships");

		Control e1control31 = createTestControl(event1, "31");
		Control e1control32 = createTestControl(event1, "32");
		Control e1control33 = createTestControl(event1, "33");
		Control e1control34 = createTestControl(event1, "34");
		Control e1control35 = createTestControl(event1, "35");

		Control e2control31 = createTestControl(event2, "31");
		Control e2control99 = createTestControl(event2, "99");
		Control e2control100 = createTestControl(event2, "100");
		Control e2control101 = createTestControl(event2, "101");
		Control e2control102 = createTestControl(event2, "102");
		
		Course courseA = createTestCourse(event1, "Course A");
		Course courseB = createTestCourse(event1, "Course B");
		Course courseC = createTestCourse(event1, "Course C");

		Course courseLong = createTestCourse(event2, "Long");
		Course courseShort = createTestCourse(event2, "Short");
		
		Clazz he = createTestClass("HE");
		Clazz de = createTestClass("DE");
		Clazz h20 = createTestClass("H20");
		Clazz d20 = createTestClass("D20");
		
		EventClazz event1he = createTestEventClass(event1, he, courseA);
		EventClazz event1de = createTestEventClass(event1, de, courseB);
		EventClazz event2he = createTestEventClass(event2, he, courseLong);
		createTestEventClass(event2, de, courseLong);
		createTestEventClass(event2, h20, courseShort);
		createTestEventClass(event2, d20, courseShort);
		
		createTestCourseControl(1, courseA, e1control31);
		createTestCourseControl(2, courseA, e1control32);
		createTestCourseControl(1, courseB, e1control31);
		createTestCourseControl(1, courseC, e1control32);
		createTestCourseControl(2, courseC, e1control33);
		createTestCourseControl(3, courseC, e1control34);
		createTestCourseControl(4, courseC, e1control35);

		createTestCourseControl(1, courseShort, e2control31);
		createTestCourseControl(1, courseShort, e2control99);
		createTestCourseControl(1, courseShort, e2control100);
				
		CourseControl courseControlCourseLong1 = createTestCourseControl(1, courseLong, e2control100);
		CourseControl courseControlCourseLong2 = createTestCourseControl(2, courseLong, e2control101);
		CourseControl courseControlCourseLong3 = createTestCourseControl(3, courseLong, e2control102);

		Ecard ecard1 = createTestECard("123456");
		Ecard ecard2 = createTestECard("900004");
		createTestECard("1151975");
		createTestECard("770321");
		
		Runner runner1 = createTestRunner("Niggli-Luder", "Simone", ecard1);
		Runner runner2 = createTestRunner("Hubmann", "Daniel", ecard2);
		
		createTestRace(runner1, event1he);
		Race race12 = createTestRace(runner1, event2he);
		createTestRace(runner2, event1de);
		
		createTestRaceControl(race12, courseControlCourseLong1, 1);
		createTestRaceControl(race12, courseControlCourseLong2, 2);
		createTestRaceControl(race12, courseControlCourseLong3, 3);
		
		// create default settings
		Settings settings = new Settings();
		settings.setDefaultEvent(event1);
		settingsDatabaseService.create(settings);
		
		// User Permissions
		PermissionFunction administration = createDemoPermissionFunction(PermissionFunctionEnum.readAdministration, "Administration");
		PermissionRole administratorRole = createDemoPermissionRole("Administrator", administration);

		// Generic
		createTestUser("user");
		createTestUser("admin", administratorRole);
		
		logger.info("Test Data created.");
	}

	private Event createTestEvent(String name) {
		Event event = new Event();
		event.setName(name);
		eventDatabaseService.create(event);
		return event;
	}

	private Control createTestControl(Event event, String id) {
		Control control = new Control();
		control.setEvent(event);
		control.setId(id);
		controlDatabaseService.create(control);
		return control;
	}

	private Course createTestCourse(Event event, String name) {
		Course course = new Course();
		course.setEvent(event);
		course.setName(name);
		courseDatabaseService.create(course);
		return course;
	}
	
	private Clazz createTestClass(String name) {
		Clazz clazz = new Clazz();
		clazz.setName(name);
		clazzDatabaseService.create(clazz);
		return clazz;
	}
	
	private EventClazz createTestEventClass(Event event, Clazz clazz, Course course) {
		EventClazz eventClass = new EventClazz();
		eventClass.setEvent(event);
		eventClass.setClazz(clazz);
		eventClass.setCourse(course);
		eventClazzDatabaseService.create(eventClass);
		return eventClass;
	}
	
	private CourseControl createTestCourseControl(long sortOrder, Course course, Control control) {
		CourseControl courseControl = new CourseControl();
		courseControl.setCourse(course);
		courseControl.setControl(control);
		courseControl.setSortOrder(sortOrder);
		courseControlDatabaseService.create(courseControl);
		return courseControl;
	}
	
	private Runner createTestRunner(String familyName, String firstName, Ecard ecard) {
		Runner runner = new Runner();
		runner.setFamilyName(familyName);
		runner.setFirstName(firstName);
		runner.setDefaultEcard(ecard);
		runnerDatabaseService.create(runner);
		return runner;
	}
	
	private Ecard createTestECard(String id) {
		Ecard ecard = new Ecard();
		ecard.setId(id);
		eCardDatabaseService.create(ecard);
		return ecard;
	}
	
	private Race createTestRace(Runner runner, EventClazz eventClazz) {
		return entryDatabaseService.createEntryWithRace(null, runner.getKey(), eventClazz.getKey());
	}
	
	private RaceControl createTestRaceControl(Race race, CourseControl courseControl, long sortOrder) {
		RaceControl raceControl = new RaceControl();
		raceControl.setRace(race);
		raceControl.setCourseControl(courseControl);
		raceControl.setSortOrder(sortOrder);
		raceControlDatabaseService.create(raceControl);
		return raceControl;
	}
	
	private User createTestUser(String username, PermissionRole... permissionRoles) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(".");
		user.setRepeatPassword(".");
		user.setEvtCreationDate(DateUtility.truncateToDay(new Date()));
		user.getPermissionRoles().addAll(Arrays.asList(permissionRoles));
		userDatabaseService.create(user);
		return user;
	}

	private PermissionFunction createDemoPermissionFunction(PermissionFunctionEnum key, String name) {
		PermissionFunction function = new PermissionFunction();
		function.setKey(key.name());
		function.setName(name);
		permissionFunctionDatabaseService.create(function);
		return function;
	}

	private PermissionRole createDemoPermissionRole(String name, PermissionFunction... functions) {
		PermissionRole role = new PermissionRole();
		role.setName(name);
		role.getPermissionFunctions().addAll(Arrays.asList(functions));
		permissionRoleDatabaseService.create(role);
		return role;
	}
			
}