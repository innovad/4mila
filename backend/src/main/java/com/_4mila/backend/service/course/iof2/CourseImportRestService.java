package com._4mila.backend.service.course.iof2;

import static spark.Spark.post;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.service.AbstractRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.exception.BackendValidationException;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CourseImportRestService extends AbstractRestService<CourseImportDatabaseService> {

	private static final Logger logger = LoggerFactory.getLogger(CourseImportRestService.class);
	
	@Inject
	public CourseImportRestService(Injector injector) {
		super(injector, CourseImportDatabaseService.class);
	}

	@Override
	public void init() {

		post("services/upload/course", (req, res) -> {
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
			Part part = req.raw().getPart("upload");
			try (InputStream is = part.getInputStream()) {
				// Read file
				part.getInputStream();
				// TODO import here
				logger.info("upload course");
				
			} catch (IOException e) {
				logger.error("File upload failed", e);
				throw new BackendValidationException("FileUploadError");
			}
			PathListEntry<String> result = new PathListEntry<>();
			result.setKey(UUID.randomUUID().toString(), "fileKey");
			return result;
		}, getJsonTransformer());

	}

}
