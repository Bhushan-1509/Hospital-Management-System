import javax.print.attribute.standard.Media;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class PlayAudio {
    public PlayAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Transition.wav").getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();

    }
}
