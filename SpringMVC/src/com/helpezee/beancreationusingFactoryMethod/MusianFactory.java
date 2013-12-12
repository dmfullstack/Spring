package com.helpezee.beancreationusingFactoryMethod;

public class MusianFactory {
	 public Musician createDuplicate(final String musician) {
	        final Musician newMusician = new Musician();
	        newMusician.setInstrument(musician);
	        return newMusician;
	    }
}
