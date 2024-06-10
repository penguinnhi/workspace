package class_basic.song;

import jdk.swing.interop.SwingInterOpUtils;

public class Song {

    String title;
    String artist;
    String album;
    int year;
    String[] composer=new String[3]; //****ㅁㄹ

    public void initSong(String title1,String artist1,String album1,int year1,String[] compser1){
        title=title1;
        artist=artist1;
        album=album1;
        year=year1;
        composer=compser1;
    }

    /*public void setTitle(String t1){
        title=t1;
    }

    public void setArtist(String a1){
        artist=a1;
    }

    public void setAlbum(String ab1){
        album=ab1;
    }

    public void setYear(int y1){
        year=y1;
    }

    public void setComposer(String[] c3){
        composer=c3;
    }*/
    //14

    public void printSongInfo(){
        System.out.println("노래 : "+title);
        System.out.println("가수 : "+artist);
        System.out.println("앨범 : "+album);
        System.out.println("연도 : "+year);
        System.out.print("작곡가 : ");
        for (int i=0;i<composer.length;i++){
            System.out.print(composer[i]+" ");
        } // ** ㄷㅂ
    }
    //15-1 , 배열은 배열 변수명 그대로 쓰면 안됨 아 맞다

    public static void main(String[] args) {


        Song s1=new Song();

        s1.printSongInfo();

        s1.title="Supernova";
        s1.artist="aespa";
        s1.album="몰라";
        s1.year=2024;
        //s1.composer

        s1.printSongInfo();

        //15-2


    }

}
