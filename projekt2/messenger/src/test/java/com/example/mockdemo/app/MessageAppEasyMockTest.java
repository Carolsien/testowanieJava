package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MessageAppEasyMockTest {

	private Messenger messenger;
	private MessageService mockService;
	
	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "err";

	private final String VALID_MESSAGE = "correct message";
	private final String INVALID_MESSAGE = "er";
	
	@Before
	public void setUp() throws Exception {
		mockService = mock(MessageService.class);
		messenger = new Messenger(mockService);
	}

	private MessageService mock(Class<MessageService> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	@After
	public void tearDown() throws Exception {
		messenger = null;
		mockService = null;
	}

	@Test
	public void testConnection_CorrectServer() {
		expect(mockService.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.SUCCESS);
		replay(mockService);
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(mockService);
	}
	
	@Test
	public void testConnection_CorrectServer_WithoutConnection() {
		expect(mockService.checkConnection(VALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(mockService);
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(mockService);
	}

	@Test
	public void testConnection_WrongServer() {
		expect(mockService.checkConnection(INVALID_SERVER)).andReturn(ConnectionStatus.FAILURE);
		replay(mockService);
		int result = messenger.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(mockService);
	}
	
	@Test
	public void testConnection_NullServer() {
		expect(mockService.checkConnection(null)).andReturn(ConnectionStatus.FAILURE);
		replay(mockService);
		int result = messenger.testConnection(null);
		assertEquals(1, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_CorrectAll() throws MalformedRecipientException {
		expect(mockService.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENT);
		replay(mockService);
		int result = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_CorrectAll_NotSent() throws MalformedRecipientException {
		expect(mockService.send(VALID_SERVER, VALID_MESSAGE)).andReturn(SendingStatus.SENDING_ERROR);
		replay(mockService);
		int result = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_CorrectServer_WrongMessage() throws MalformedRecipientException {
		expect(mockService.send(VALID_SERVER, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_CorrectServer_NullMessage() throws MalformedRecipientException {
		expect(mockService.send(VALID_SERVER, null)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_WrongServer() throws MalformedRecipientException {
		expect(mockService.send(INVALID_SERVER2, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_WrongServer_WrongMessage() throws MalformedRecipientException {
		expect(mockService.send(INVALID_SERVER2, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(INVALID_SERVER2, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_WrongServer_NullMessage() throws MalformedRecipientException {
		expect(mockService.send(INVALID_SERVER2, null)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(INVALID_SERVER2, null);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_NullServer_CorrectMessage() throws MalformedRecipientException {
		expect(mockService.send(null, VALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_NullServer_WrongMessage() throws MalformedRecipientException {
		expect(mockService.send(null, INVALID_MESSAGE)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(mockService);
	}
	
	@Test
	public void sendMessage_NullServer_NullMessage() throws MalformedRecipientException {
		expect(mockService.send(null, null)).andThrow(new MalformedRecipientException());
		replay(mockService);
		int result = messenger.sendMessage(null, null);
		assertEquals(2, result);
		verify(mockService);
	}
}
