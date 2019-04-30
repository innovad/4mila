package com._4mila.backend.service.runner.csv;

import static spark.Spark.post;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.model.runner.csv.RunnerImport;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.ecard.EcardDatabaseService;
import com._4mila.backend.service.exception.BackendValidationException;
import com._4mila.backend.service.runner.RunnerDatabaseService;
import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RunnerImportRestService extends AbstractCrudRestService<RunnerImport, Long, RunnerImportDatabaseService> {

	private static final Logger logger = LoggerFactory.getLogger(RunnerImportRestService.class);

	@Inject
	RunnerDatabaseService runnerDatabaseService;
	
	@Inject
	EcardDatabaseService ecardDatabaseService;

	@Inject
	public RunnerImportRestService(Injector injector) {
		super(injector, RunnerImportDatabaseService.class);
	}

	@Override
	protected void initPost() {
		super.initPost();

		post("services/upload", (req, res) -> {
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
			Part part = req.raw().getPart("upload");
			try (InputStream is = part.getInputStream()) {
				// Read file
				InputStreamReader ir = new InputStreamReader(part.getInputStream());
				Iterable<CSVRecord> records = CSVFormat.EXCEL
						.withDelimiter(';')
						.withFirstRecordAsHeader()
						.withIgnoreSurroundingSpaces()
						.withNullString("")
						.parse(ir);

				// Get existing runners
				List<Runner> existingRunners = runnerDatabaseService.list();
				HashMap<String, Runner> existingRunnerLookup = new HashMap<>();
				for (Runner existingRunner : existingRunners) {
					if (!Strings.isNullOrEmpty(existingRunner.getId())) {
						existingRunnerLookup.put(existingRunner.getId(), existingRunner);
					}
				}

				// Get existing ecards
				List<Ecard> existingECards = ecardDatabaseService.list();
				HashMap<String, Ecard> existingECardLookup = new HashMap<>();
				for (Ecard existingEcard : existingECards) {
					if (!Strings.isNullOrEmpty(existingEcard.getId())) {
						existingECardLookup.put(existingEcard.getId(), existingEcard);
					}
				}
				
				// TODO support other header languages
				for (CSVRecord record : records) {
					if (record.getRecordNumber() % 500 == 0) {
						logger.info("Importing record " + record.getRecordNumber());
					}
					String id = record.get("Datenbank Id");
					Runner runner = existingRunnerLookup.get(id);
					if (runner == null) {
						runner = new Runner();
						runner.setId(id);
					}
					Ecard ecard = null;
					String ecardId = record.get("Chipnr SI");
					if (!Strings.isNullOrEmpty(ecardId)) {
						ecard = existingECardLookup.get(ecardId);
						if (ecard == null) {
							ecard = new Ecard();
							ecard.setId(ecardId);
						}
					}
					runner.setDefaultEcard(ecard);
					
					if (record.isSet("Nachname")) {
						runner.setFamilyName(record.get("Nachname"));
					}
					if (record.isSet("Vorname")) {
						runner.setFirstName(record.get("Vorname"));
					}
					if (record.isSet("Ort")) {
						runner.setCity(record.get("Ort"));
					}
					if (record.isSet("EMail")) {
						runner.setEmail(record.get("EMail"));
					}
					if (record.isSet("Jg")) {
						runner.setYearOfBirth(Ints.tryParse(record.get("Jg") + ""));
					}
					if (record.isSet("G")) {
						String sex = record.get("G");
						if ("M".equalsIgnoreCase(sex)) {
							runner.setSex("m");
						} else if ("F".equalsIgnoreCase(sex)) {
							runner.setSex("f");
						}
					}
					
					// persist
					if (ecard != null) {
						if (ecard.getKey() == null) {
							ecardDatabaseService.create(ecard);
						} else {
							ecardDatabaseService.update(ecard);
						}
					}
					if (runner.getKey() == null) {
						runnerDatabaseService.create(runner);
					} else {
						runnerDatabaseService.update(runner);
					}
				}

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
