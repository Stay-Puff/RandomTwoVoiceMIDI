import jm.music.data.Note;
import jm.music.data.Phrase;

public class RunnableDemo implements Runnable {
	   private Thread thread;
	   private String name;
	   private Phrase phrase;
	   
	   RunnableDemo(String name, Phrase phrase) {
	      this.name = name;
	      this.phrase = phrase;
	      System.out.println("Creating " +  name );
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  name );
	      if (thread == null) {
	         thread = new Thread (this, name);
	         thread.start ();
	      }
	   }
		@Override
		public void run() {
			//Generates unique notes for each phrase. Every note is an eighth note.
			for (int i=0; i< 200; i++) {
				Note n = new Note(60 + (int)(Math.random() * 24), 0.125);
				phrase.addNote(n);
			}
			//Sets starting time at the first measure
			phrase.setStartTime(1.0);
			System.out.println(name + " is done writing.");
	}
}