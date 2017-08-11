package akihiro0710.scoutingChallenge.pict;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by ta on 2017/08/08.
 */
public class PictCtrl implements ChangePictListener {
    private final File pictDir;
    private final LinkedList<ChangePictListener> listenerList;

    public PictCtrl(String path){
        this.pictDir = new File(path);
        if(!pictDir.exists()) pictDir.mkdir();
        System.out.println(getClass().getName() + ":" + pictDir.getAbsolutePath());
        listenerList = new LinkedList<>();
    }
    public void addChangePictListener(ChangePictListener listener){
        listenerList.add(listener);
    }
    private void saveImage(BufferedImage image){
        new Thread(() -> {
            File file = new File(pictDir.getPath() + "/" + System.currentTimeMillis() + ".png");
            try {
                if (file.createNewFile()) ImageIO.write(image, "PNG", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void setPict(BufferedImage image) {
        for (ChangePictListener listener : listenerList) {
            listener.setPict(image);
        }
        saveImage(image);
    }
}
