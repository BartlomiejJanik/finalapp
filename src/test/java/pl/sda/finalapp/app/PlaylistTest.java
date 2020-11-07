package pl.sda.finalapp.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.sda.finalapp.playlists.Movie;
import pl.sda.finalapp.playlists.Music;
import pl.sda.finalapp.playlists.Playlist;

class PlaylistTest {

    @Test
    public void shouldPlaySequentially(){
        Playlist playlist = new Playlist();
        playlist.addElements(new Music("Kazik","12 groszy"));
        playlist.addElements(new Movie("Kler"));
        Playlist subPlayList = new Playlist();
        subPlayList.addElements(new Music("Perfect","Autobiografia"));
        subPlayList.addElements(new Music("Bomfunk MC","Super Fly"));
        subPlayList.addElements(new Movie("Casablanca"));
        playlist.addElements(subPlayList);

        System.out.println(playlist.play());

    }
    @Test
    public void shouldPlayRandomlly(){
        Playlist playlist = new Playlist();
        playlist.addElements(new Music("Kazik","12 groszy"));
        playlist.addElements(new Movie("Kler"));
        Playlist subPlayList = new Playlist();
        subPlayList.setRandom();
        subPlayList.addElements(new Music("Perfect","Autobiografia"));
        subPlayList.addElements(new Music("Bomfunk MC","Super Fly"));
        subPlayList.addElements(new Movie("Casablanca"));
        playlist.addElements(subPlayList);

        System.out.println(playlist.play());

    }
    @Test
    public void shouldPlayLoop(){
        Playlist playlist = new Playlist();
        playlist.addElements(new Music("Kazik","12 groszy"));
        playlist.addElements(new Movie("Kler"));
        Playlist subPlayList = new Playlist();
        subPlayList.setLoop(2);
        subPlayList.addElements(new Music("Perfect","Autobiografia"));
        subPlayList.addElements(new Music("Bomfunk MC","Super Fly"));
        subPlayList.addElements(new Movie("Casablanca"));
        playlist.addElements(subPlayList);

        System.out.println(playlist.play());

        String result= "12 groszy Kazik\n" +
                "Kler\n" +
                "Autobiografia Perfect\n" +
                "Super Fly Bomfunk MC\n" +
                "Casablanca\n" +
                "Autobiografia Perfect\n" +
                "Super Fly Bomfunk MC\n" +
                "Casablanca";
        Assertions.assertEquals(playlist.play(),result);

    }
}