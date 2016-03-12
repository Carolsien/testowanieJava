package test;

import java.util.ArrayList;
import java.util.List;

public class MockMp3Player implements Mp3Player {
	
	private List<String> song;
	private boolean songIsPlaying = false;
	private int idCurrentSong = 0;
	private int timeCurrentSong = 0;

	//Rozpocznij odtwarzanie od utworu znajdujacego sie na szczycie listy utworow lub nie rob nic gdy lista jest pusta.
	@Override
	public void play() {
		if(song.isEmpty()){
			throw new NullPointerException();
		} else {
			song.get(song.size() - 1);
			songIsPlaying = true;
		}
	}

	//Wstrzymaj odtwarzanie. Odtwarzanie bedzie pozniej wznowione od tego miejsca.
	@Override
	public void pause() {
		songIsPlaying = false;
	}

	//Zatrzymaj odtwarzanie. Biezacy utwor pozostaje na szczycie listy, ale odtwarzanie zostanie wznowione od jego poczatku.
	@Override
	public void stop() {
		song.get(song.size() - 1);
		songIsPlaying = false;

	}

	// Zwraca liczbe sekund od poczatku biezacego utworu.
	@Override
	public double currentPosition() {
		return timeCurrentSong;
	}

	//Zwraca nazwe odtwarzanego pliku.
	@Override
	public String currentSong() {
		if(song.isEmpty()){
			throw new NullPointerException();
		} else {
			return song.get(idCurrentSong);
		}
	}

	//Przechodzi do nastepnego utworu na liscie i rozpoczyna jego odtwarzanie.
	@Override
	public void next() {
		if(idCurrentSong == (song.size() - 1)) {
			idCurrentSong = 0;
		} else {
			idCurrentSong ++ ;
		}
		timeCurrentSong = 0;
		play();
	}

	//Wraca do poprzedniego utworu na liscie i rozpoczyna jego odtwarzanie.
	@Override
	public void prev() {	
		if(idCurrentSong != 0){
			idCurrentSong ++ ;
		}
		timeCurrentSong = 0;
		play();
	}

	//Zwraca true gdy odtwarzany jest utwor.
	@Override
	public boolean isPlaying() {
		return songIsPlaying;
	}

	//Laduje pliki na liste utworow.
	@Override
	public void loadSongs(ArrayList names) {
		song = names;
	}

}
