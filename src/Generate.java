import jm.music.data.*;
import jm.util.Play;

public class Generate {
	public static void main(String[] args) {
		//Creates instruments
        Part percussion = new Part(Part.MARIMBA, 0);
        Part lead = new Part(Part.SPACE_VOICE, 1);
        //Creates empty phrases to add notes to
        Phrase phrase1 = new Phrase(0.0);
        Phrase phrase2 = new Phrase(0.0);
        //Generates unique notes for each phrase. Every note is an eighth note.
		for (int i=0; i< 200; i++) {
			Note n = new Note(60 + (int)(Math.random() * 24), 0.125);
			phrase1.addNote(n);
		}
		for (int i=0; i<200;i++){
			Note n = new Note(60 + (int)(Math.random() * 24), 0.125);
			phrase2.addNote(n);
		}
		//Sets starting time at the first measure
		phrase1.setStartTime(1.0);
		phrase2.setStartTime(1.0);
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