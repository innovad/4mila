package com._4mila.backend.service.ecard.websocket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebSocket
public class DownloadStationApiWebSocket {

    private static final Queue<Session> sessions = new ConcurrentLinkedQueue<>();
	private static final Logger logger = LoggerFactory.getLogger(DownloadStationApiWebSocket.class);

    @OnWebSocketConnect
    public void connected(Session session) {
    	logger.info("WebSocket session connect from " + session.getRemoteAddress().getHostString());
        sessions.add(session);
    }

    @OnWebSocketClose
    public void closed(Session session, int statusCode, String reason) {
    	logger.info("WebSocket session close from " + session.getRemoteAddress().getHostString());
        sessions.remove(session);
    }

    @OnWebSocketMessage
    public void message(Session session, String message) throws IOException {
        System.out.println("Got: " + message);   // Print message
        session.getRemote().sendString(message); // and send it back
    }
    
    public static void sendDownloadNotification(String notification) throws IOException {
    	// TODO choose client
    	for (Session session : sessions) {
    		session.getRemote().sendString(notification);
    	}
    }

}