package com._4mila.backend.service.ecard.websocket;

import static spark.Spark.get;

import com._4mila.backend.service.AbstractRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DownloadStationApiRestService extends AbstractRestService<DownloadStationApiDatabaseService> {

	@Inject
	public DownloadStationApiRestService(Injector injector) {
		super(injector, DownloadStationApiDatabaseService.class);
	}

	@Override
	public void init() {

		get("services/api/sportident/:ecardNo", (req, res) -> {
			String eCardNo = req.params("ecardNo");
			DownloadStationApiWebSocket.sendDownloadNotification("download");
			return eCardNo;
		}, getJsonTransformer());

	}

}
