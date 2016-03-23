package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MessageAppTest {

	private MessageServiceMock msm;
	private Messenger messenger;

	private final String VALID_SERVER = "inf.ug.edu.pl";
	private final String INVALID_SERVER = "inf.ug.edu.eu";

	private final String VALID_MESSAGE = "some message";
	private final String INVALID_MESSAGE = "ab";

	@Before
	public void setUp() throws Exception {
		msm = new MessageServiceMock();
		messenger = new Messenger(msm);
	}

	@Test
	public void testConnectionCorrectServerWithConnection() {
		msm.setConnection(true);
		assertEquals(0, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testConnectionCorrectServerNoConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(VALID_SERVER));
	}
	
	@Test
	public void testConnectionWrongServerWithConnection() {
		msm.setConnection(true);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testConnectionWrongServerNoConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(INVALID_SERVER));
	}
	
	@Test
	public void testConnectionNullServerWithConnection() {
		msm.setConnection(true);
		assertEquals(1, messenger.testConnection(null));
	}
	
	@Test
	public void testConnectionNullServerNoConnection() {
		msm.setConnection(false);
		assertEquals(1, messenger.testConnection(null));
	}
	
	@Test
	public void sendMessageSent() {
		msm.setMessageSent(true);
		assertEquals(0, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void sendMessageNotSent() {
		msm.setMessageSent(false);
		assertEquals(1, messenger.sendMessage(VALID_SERVER, VALID_MESSAGE));
	}
	
	@Test
	public void sendMessageCorrectServerWrongMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, INVALID_MESSAGE));
	}
	
	@Test
	public void sendMessageCorrectServerNullMessage() {
		assertEquals(2, messenger.sendMessage(VALID_SERVER, null));
	}
	
	@Test
	public void sendMessageNullServerCorrectMessage() {
		assertEquals(2, messenger.sendMessage(null, VALID_MESSAGE));
	}
	
	@Test
	public void sendMessageNullServerWrongMessage() {
		assertEquals(2, messenger.sendMessage(null, INVALID_MESSAGE));
	}
	
	@Test
	public void sendMessageNullServerNullMessage() {
		assertEquals(2, messenger.sendMessage(null, null));
	}
	
	@After
	public void tearDown() throws Exception {
		messenger = null;
		msm = null;
	}
}
