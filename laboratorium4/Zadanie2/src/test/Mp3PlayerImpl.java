package test;

import java.util.ArrayList;

public class Mp3PlayerImpl implements Mp3Player {

	//Rozpocznij odtwarzanie od utworu znajdujacego sie na szczycie listy utworow lub nie rob nic gdy lista jest pusta.
	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

	//Wstrzymaj odtwarzanie. Odtwarzanie bedzie pozniej wznowione od tego miejsca.
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	//Zatrzymaj odtwarzanie. Biezacy utwor pozostaje na szczycie listy, ale odtwarzanie zostanie wznowione od jego poczatku.
	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	// Zwraca liczbe sekund od poczatku biezacego utworu.
	@Override
	public double currentPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	//Zwraca nazwe odtwarzanego pliku.
	@Override
	public String currentSong() {
		// TODO Auto-generated method stub
		return null;
	}

	//Przechodzi do nastepnego utworu na liscie i rozpoczyna jego odtwarzanie.
	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	//Wraca do poprzedniego utworu na liscie i rozpoczyna jego odtwarzanie.
	@Override
	public void prev() {
		// TODO Auto-generated method stub

	}

	//Zwraca true gdy odtwarzany jest utwor.
	@Override
	public boolean isPlaying() {
		// TODO Auto-generated method stub
		return false;
	}

	//Laduje pliki na liste utworow.
	@Override
	public void loadSongs(ArrayList names) {
		// TODO Auto-generated method stub

	}

}
