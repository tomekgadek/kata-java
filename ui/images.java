/** Obsługa obrazków. */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

    private static final String NET_IMAGE_URL = "https://gravatar.com/avatar/cb9a615ca9d71054e28a37cc604320c3?s=400&d=robohash&r=x";
    private static final String DISK_IMAGE_URL = "../static/ui_file_001.png";

    private Optional<BufferedImage> diskImage;
    private Optional<BufferedImage> netImage;

    ImagePanel() {
        super();

        netImage = this.tryLoadFileFromNet(NET_IMAGE_URL);
        diskImage = this.tryLoadFileFromDisk(DISK_IMAGE_URL);

        int panelWidth = 0;
        int panelHeight = 0;

        if(netImage.isPresent()) {
            panelWidth += netImage.get().getWidth();
            panelHeight += netImage.get().getHeight();
        }

        if(diskImage.isPresent()) {
            panelWidth += diskImage.get().getWidth();
            panelHeight = panelHeight > diskImage.get().getHeight() ? panelHeight : diskImage.get().getHeight();
        }
        
        setPreferredSize(new Dimension(panelWidth, panelHeight));
    }

    private Optional<BufferedImage> tryLoadFileFromNet(final String url) {
        try {
            URL imageUrl = new URL(url);
            netImage = Optional.ofNullable(ImageIO.read(imageUrl));

            return netImage;

        } catch(IOException e) {
            System.err.printf("Exception (load file from net): %s \n", e.getMessage());
        }

        return Optional.empty();
    }

    private Optional<BufferedImage> tryLoadFileFromDisk(final String url) {
        try {
            File imageFile = new File(url);
            diskImage = Optional.ofNullable(ImageIO.read(imageFile));

            return diskImage;

        } catch(IOException e) {
            System.err.printf("Exception (load file from disk): %s \n", e.getMessage());
        }

        return Optional.empty();
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics;

        diskImage.ifPresent(imageFromDisk -> graphics2d.drawImage(imageFromDisk, 0, 0, this));

        netImage.ifPresent(imageFromNet -> 
            graphics2d.drawImage(imageFromNet, diskImage.map(imageFromDisk -> 
                imageFromDisk.getWidth()).orElse(0), 0, null)
        );
    }
}

class Window extends JFrame {

    Window() {
        super("Test images");

        add(new ImagePanel());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }
}

class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Window(); // tworzymy okienko
            }
        });
    }
}
