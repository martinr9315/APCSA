package unit11assesment;

public class ArtistRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song ttls = new Song("Twinkle, Twinkle Little Star", "CCGGAAG FFEEDDG");
		Song mhall = new Song("Mary Had a Little Lamb", "EDCDEEE DDDEGG");
		Song hcs = new Song("Hot Cross Buns", "BAGBAG GGGGAAAA BAG");
		
		Album SfK = new Album("Songs for Kids!", 3);
		
		SfK.addSong(0, ttls);
		SfK.addSong(1, mhall);
		SfK.addSong(2, hcs);
		
		Song twontb = new Song("The Wheels on the Bus", "DGGGG FFEEDDG");
		Song hbty = new Song("Happy Birthday To You", "AABADC AABAED");
		Song omhaf = new Song("Old McDonald Had a Farm", "GGGDEED BBAAG");
		
		Album MSfK = new Album("More Songs for Kids!", 3);
		
		MSfK.addSong(0, twontb);
		MSfK.addSong(1, hbty);
		MSfK.addSong(2, omhaf);
		
		
		Artist A = new Artist("Mr. Potato Head",2 );
		
		A.addAlbum(0, SfK);
		A.addAlbum(1, MSfK);
		
		System.out.println(A.toString());
		
		System.out.println(ttls.toString());

	}

}
