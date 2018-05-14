package com._4mila.backend.service.exception;

import static spark.Spark.after;
import static spark.Spark.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import com._4mila.backend.server.json.JsonHelper;
import com._4mila.backend.service.AbstractRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.UnitOfWork;

public class ExceptionRestService extends AbstractRestService<ExceptionDatabaseService> {

	@Inject
	JsonHelper jsonHelper;
	
	@Inject
	UnitOfWork unitOfWork;
	
	@Inject
	public ExceptionRestService(Injector injector) {
		super(injector, ExceptionDatabaseService.class);
	}

	@Override
	public void init() {
		after("/services/*", (req, res) -> {
			unitOfWork.end(); // make sure jpa transactions/db connections are closed
		});
		
		exception(Exception.class, (exception, request, response) -> {
			unitOfWork.end(); // make sure jpa transactions/db connections are closed
			if (exception instanceof BackendValidationException) {
				response.status(405);
				TranslatedMessage message = new TranslatedMessage();
				message.messageKey = ((BackendValidationException) exception).getMessageKey();
				message.parameters = ((BackendValidationException) exception).getParameters();
				response.body(jsonHelper.getGson().toJson(message));
			} else {
				response.status(500);
				StringWriter errors = new StringWriter();
				exception.printStackTrace(new PrintWriter(errors));
				ErrorMessage message = new ErrorMessage();
				message.title = "Error: " + exception.getMessage();
				message.error = errors.toString();
				response.body(jsonHelper.getGson().toJson(message));
				exception.printStackTrace();
			}
		});

	}

	@SuppressWarnings("unused")
	private class TranslatedMessage {

		private String messageKey;
		private List<String> parameters;

	}

	@SuppressWarnings("unused")
	private class ErrorMessage {

		private String title;
		private String error;

	}

}
