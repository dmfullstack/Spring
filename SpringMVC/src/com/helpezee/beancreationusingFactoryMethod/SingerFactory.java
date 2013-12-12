package com.helpezee.beancreationusingFactoryMethod;

public class SingerFactory {
	
	    public static synchronized Singer createSinger(final String song) {
	        Singer singer = new Singer();
	        singer.setSong(song);
	        return singer;
	    }
	    
	    public Musician createDuplicate(final Musician musician) {
	        final Musician newMusician = new Musician();
	        newMusician.setInstrument(musician.getInstrument());
	        return newMusician;
	    }
	}

