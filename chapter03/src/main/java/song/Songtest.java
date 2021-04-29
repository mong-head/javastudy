package song;

public class Songtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song();
		Song song2 = new Song("Rollin","브레이브걸스");
		song.setArtist("IU");
		song.setAlbum("Real");
		song.setTitle("좋은날");
		song.setComposer("이민수");
		song.setTrack(3);
		song.setYear(2010);
		
		song.show();
		song2.show();
	}

}
