package test;

import java.util.ArrayList;

public interface Mp3Player {
	public void play();
	public void pause();
	public void stop();
	public double currentPosition();
	public String currentSong();
	public void next();
	public void prev();
	public boolean isPlaying();
	public void loadSongs(ArrayList names);
}
