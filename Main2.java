class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount >= songs.length) {
            System.out.println("Playlist is full.");
            return;
        }

        songs[songCount] = song;
        songCount++;
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Main2 {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        System.out.println("Songs in playlist:");

        String[] actualSongs = p.getSongs();

        for (String song : actualSongs) {
            System.out.println(song);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}