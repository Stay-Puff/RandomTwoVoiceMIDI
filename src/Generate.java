import jm.music.data.Part;
import jm.music.data.Phrase;
import jm.music.data.Score;
import jm.util.Play;

public class Generate {
	public static void main(String[] args) {
		//Creates instruments
	        Part percussion = new Part(Part.MARIMBA, 0);
		Part lead = new Part(Part.SPACE_VOICE, 1);
		//Creates empty phrases to add notes to
	        Phrase phrase1 = new Phrase(0.0);
	        Phrase phrase2 = new Phrase(0.0);
		// Creates two threads to add notes to each phrase in each thread
		RunnableDemo R1 = new RunnableDemo( "Thread-1", phrase1);
		R1.start();
		RunnableDemo R2 = new RunnableDemo( "Thread-2", phrase2);
		R2.start();
		//Adds phrases to instrument parts.
		lead.add(phrase1);
		percussion.add(phrase2);
		//Creates score with 50bpm, adds parts to score.
		Score score = new Score("Test", 50.0);
		score.addPart(percussion);
		score.addPart(lead);
		//Plays MIDI generated from score.
		Play.midi(score);
	}
}
