package com._4mila.backend.service.ecard.websocket;

import static spark.Spark.webSocket;

public class DownloadStationApiWebSocketService {

	public void init() {
		webSocket("/services/websocket", DownloadStationApiWebSocket.class);
	}

}
