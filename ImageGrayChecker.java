package mynewproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageGrayChecker extends JFrame {
    private JLabel imageLabel = new JLabel();
    private JButton uploadButton = new JButton("Upload Image");

    public ImageGrayChecker() {
        setTitle("Image Grayscale Checker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        uploadButton.addActionListener(e -> handleUpload());
        add(uploadButton, BorderLayout.SOUTH);
        add(imageLabel, BorderLayout.CENTER);
    }

    private void handleUpload() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage inputImage = ImageIO.read(chooser.getSelectedFile());
                if (isGrayscale(inputImage)) {
                    JOptionPane.showMessageDialog(this, "The image is already in grayscale.");
                    imageLabel.setIcon(new ImageIcon(inputImage));
                } else {
                    BufferedImage grayImage = convertToGrayscale(inputImage);
                    imageLabel.setIcon(new ImageIcon(grayImage));
                    JOptionPane.showMessageDialog(this, "Converted to grayscale.");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error loading image.");
            }
        }
    }

    private boolean isGrayscale(BufferedImage img) {
        for (int y = 0; y < img.getHeight(); y += 10) {
            for (int x = 0; x < img.getWidth(); x += 10) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                if (!(r == g && g == b)) {
                    return false;
                }
            }
        }
        return true;
    }

    private BufferedImage convertToGrayscale(BufferedImage img) {
        BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = gray.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return gray;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ImageGrayChecker().setVisible(true));
    }
}