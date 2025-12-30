package P2_E3;

public class VideoStream_Adaptador implements Media{
	private VideoStream videoStream;

    public VideoStream_Adaptador(VideoStream videoStream) {
        this.videoStream = videoStream;
    }

    @Override
    public void play() {
        videoStream.reproduce();
    }
}
