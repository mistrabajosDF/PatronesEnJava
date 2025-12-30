package P2_E3;
/*
 * La clase Media player reproduce archivos de audio y video en formatos diversos. Cada Media se puede reproducir con el mensaje play().
Para continuar con el desarrollo, se desea incorporar la posibilidad de reproducir Video Stream. 
Para ello, se dispone de la clase VideoStream que pertenece a una librería de terceros y no se puede modificar. 
Hacer que la clase MediaPlayer pueda interactuar con la clase VideoStream.
 */

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
	    private List<Media> playlist = new ArrayList<>();
	    //no tiene constructor porque ya inicializa ahi

	    public void addMedia(Media media) {
	        playlist.add(media);
	    }

	    public void playAll() {
	    	playlist.stream().forEach(Media::play);
	    }
}
