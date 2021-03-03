package aeroplane;

import java.util.*;

public class Seat {
	private final static Set<Integer> EMERGENCY_EXITS = Set.of(1, 10, 30); 
	private final static int MAXIMUM_ROW = 50;
	private final static char MAXIMUM_LETTER = 'F';
	private final static char MINIMUM_LETTER = 'A';
	private final int row;
	private final char letter;

	Seat (int row, char letter){
		this.row = row;
		this.letter = letter;
	}

	@Override
	public String toString(){
		return Integer.toString(row) + letter;
	}
	
	boolean isEmergencyExit() {
		return EMERGENCY_EXITS.contains(row);
	}

	private boolean hasNext() {
		return !(this.row == MAXIMUM_ROW && this.letter == MAXIMUM_LETTER);
	}

	// (cond) ? <then> : <else>
	Seat next() throws NoSuchElementException {
		if(!hasNext()) throw new NoSuchElementException(); 

		return new Seat(row + 1, (letter == MAXIMUM_LETTER) ? MINIMUM_LETTER : (char) (letter + 1));
	}
}
