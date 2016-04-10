package com.example.mockdemo.app;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageServiceMock implements MessageService {

	private boolean connectionExists = false;
	private boolean messageSent = false;
	
	public void setConnection(boolean b) {
		connectionExists = b;
	}
	
	public void setMessageSent(boolean b) {
		messageSent = b;
	}
	
	@Override
	public ConnectionStatus checkConnection(String server) {
		if (connectionExists && server != null && server.endsWith(".pl")) {
			return ConnectionStatus.SUCCESS;
		}
		return ConnectionStatus.FAILURE;
	}

	@Override
	public SendingStatus send(String server, String message)
			throws MalformedRecipientException {
		if (server == null || message == null)
			throw new MalformedRecipientException();
		if (server.length() < 4 || message.length() < 3)
			throw new MalformedRecipientException();
		if (messageSent)
			return SendingStatus.SENT;
		return SendingStatus.SENDING_ERROR;
	}

}
