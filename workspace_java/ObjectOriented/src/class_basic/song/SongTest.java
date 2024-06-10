package class_basic.song;

public class SongTest {
    public static void main(String[] args) {

        Song s0=new Song();
        String[] cc={"유","야","영"};//******ㄷㅂ

        s0.initSong("Melt Away","태연","ㅁㄹ",2000,cc);

        s0.printSongInfo();

    }
}
