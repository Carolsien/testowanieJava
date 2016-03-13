package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestMp3Player {
	private Mp3Player mp3;
	private ArrayList list = new ArrayList();
	
	private static double EPSILON = 1E-15;

	@Before
	public void setUp() {
		mp3 = new MockMp3Player();
		list = new ArrayList();
		list.add("Bill Chase −− Open Up Wide");
		list.add("Jethro Tull −− Locomotive Breath");
		list.add("The Boomtown Rats −− Monday");
		list.add("Carl Orff −− O Fortuna");
	}

	@Test
	public void testPlay() {
		mp3.loadSongs(list);
		assertNotNull(mp3.currentSong());
		mp3.play();
		assertEquals(list.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		mp3.pause();
		assertEquals(list.get(0), mp3.currentSong());
		assertFalse(mp3.isPlaying());
		mp3.stop();
		assertEquals(list.get(0), mp3.currentSong());
		assertFalse(mp3.isPlaying());
	}

	@Test(expected = NullPointerException.class)
	public void testPlayNoList() {
		assertNull(mp3.currentSong());
		mp3.play();
		assertNull(mp3.currentSong());
		assertFalse(mp3.isPlaying());
		mp3.pause();
		assertNull(mp3.currentSong());
		assertFalse(mp3.isPlaying());
		mp3.stop();
		assertNull(mp3.currentSong());
		assertFalse(mp3.isPlaying());
	}

	@Test
	public void testAdvance() {
		mp3.loadSongs(list);
		mp3.play();
		assertEquals(list.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		mp3.prev();
		assertEquals(list.get(0), mp3.currentSong());
		assertTrue(mp3.isPlaying());
		mp3.next();
		assertEquals(list.get(1), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());
		mp3.prev();
		assertEquals(list.get(1), mp3.currentSong());	
		mp3.next();
		assertEquals(list.get(2), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(3), mp3.currentSong());
		mp3.next();
		assertEquals(list.get(0), mp3.currentSong());	
		assertTrue(mp3.isPlaying());
	}

	@After
	public void teardown() {
		mp3 = null;
		list = null;
	}
}