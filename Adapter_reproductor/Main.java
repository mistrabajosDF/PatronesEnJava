package P2_E3;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.addMedia(new Audio());
        player.addMedia(new VideoFile());
        player.addMedia(new VideoStream_Adaptador(new VideoStream()));

        player.playAll();
    }
}