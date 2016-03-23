package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

import static org.mockito.Mockito.*;

public class MessageAppMockitoTest {

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";
	private final String INVALID_SERVER2 = "abc";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";
	
	@Mock
	MessageService service;
	private Messenger messenger;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		messenger = new Messenger(service);
	}

	@After
	public void tearDown() throws Exception {
		messenger = null;
		service = null;
	}

	@Test
	public void testConnection_CorrectServer() {
		when(service.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.SUCCESS);
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(0, result);
		verify(service).checkConnection(VALID_SERVER);
	}

	@Test
	public void testConnection_CorrectServer_WithoutSuccess() {
		when(service.checkConnection(VALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = messenger.testConnection(VALID_SERVER);
		assertEquals(1, result);
		verify(service).checkConnection(VALID_SERVER);
	}
	
	@Test
	public void testConnection_WrongServer() {
		when(service.checkConnection(INVALID_SERVER)).thenReturn(ConnectionStatus.FAILURE);
		int result = messenger.testConnection(INVALID_SERVER);
		assertEquals(1, result);
		verify(service).checkConnection(INVALID_SERVER);
	}
	
	@Test
	public void testConnection_NullServer() {
		when(service.checkConnection(null)).thenReturn(ConnectionStatus.FAILURE);
		int result = messenger.testConnection(null);
		assertEquals(1, result);
		verify(service).checkConnection(null);
	}
	
	@Test
	public void checkSendingMessage_CorrectAll_MessageSent() throws MalformedRecipientException {
		when(service.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENT);
		int result = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(0, result);
		verify(service).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_CorrectAll_MessageNotSent() throws MalformedRecipientException {
		when(service.send(VALID_SERVER, VALID_MESSAGE)).thenReturn(SendingStatus.SENDING_ERROR);
		int result = messenger.sendMessage(VALID_SERVER, VALID_MESSAGE);
		assertEquals(1, result);
		verify(service).send(VALID_SERVER, VALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_CorrectServer_WrongMessage() throws MalformedRecipientException {
		when(service.send(VALID_SERVER, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(service).send(VALID_SERVER, INVALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_CorrectServer_NullMessage() throws MalformedRecipientException {
		when(service.send(VALID_SERVER, null)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(VALID_SERVER, null);
		assertEquals(2, result);
		verify(service).send(VALID_SERVER, null);
	}
	
	@Test
	public void checkSendingMessage_WrongServer_CorrectMessage() throws MalformedRecipientException {
		when(service.send(INVALID_SERVER2, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(INVALID_SERVER2, VALID_MESSAGE);
		assertEquals(2, result);
		verify(service).send(INVALID_SERVER2, VALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_WrongServer_WrongMessage() throws MalformedRecipientException {
		when(service.send(INVALID_SERVER2, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(INVALID_SERVER2, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(service).send(INVALID_SERVER2, INVALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_WrongServer_NullMessage() throws MalformedRecipientException {
		when(service.send(INVALID_SERVER2, null)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(INVALID_SERVER2, null);
		assertEquals(2, result);
		verify(service).send(INVALID_SERVER2, null);
	}
	
	@Test
	public void checkSendingMessage_NullServer_CorrectMessage() throws MalformedRecipientException {
		when(service.send(null, VALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(null, VALID_MESSAGE);
		assertEquals(2, result);
		verify(service).send(null, VALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_NullServer_WrongMessage() throws MalformedRecipientException {
		when(service.send(null, INVALID_MESSAGE)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(null, INVALID_MESSAGE);
		assertEquals(2, result);
		verify(service).send(null, INVALID_MESSAGE);
	}
	
	@Test
	public void checkSendingMessage_NullServer_NullMessage() throws MalformedRecipientException {
		when(service.send(null, null)).thenThrow(new MalformedRecipientException());
		int result = messenger.sendMessage(null, null);
		assertEquals(2, result);
		verify(service).send(null, null);
	}
}
