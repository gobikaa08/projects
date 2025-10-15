package mynewproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TimedQuiz {
    private static JFrame frame;
    private static JPanel panel;
    private static CardLayout cardLayout;
    private static JLabel resultLabel;
    private static String capitalAnswer = "None";
    private static List<String> selectedCrops;

    public static void main(String[] args) {
        frame = new JFrame("Timed Quiz");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panel = new JPanel(cardLayout);

        panel.add(createQuestion1(), "Q1");
        panel.add(createQuestion2(), "Q2");
        panel.add(createResultPanel(), "Result");

        frame.add(panel);
        frame.setVisible(true);

        // Start with Question 1 and schedule transition
        cardLayout.show(panel, "Q1");
        new Timer(60000, e -> {
            cardLayout.show(panel, "Q2");
            ((Timer) e.getSource()).stop();
            new Timer(60000, e2 -> {
                cardLayout.show(panel, "Result");
                ((Timer) e2.getSource()).stop();
            }).start();
        }).start();
    }

    private static JPanel createQuestion1() {
        JPanel q1Panel = new JPanel(new GridLayout(6, 1));
        JLabel q1 = new JLabel("1) What is the capital of India?");
        JRadioButton opt1 = new JRadioButton("Chennai");
        JRadioButton opt2 = new JRadioButton("Kolkata");
        JRadioButton opt3 = new JRadioButton("New Delhi");
        JRadioButton opt4 = new JRadioButton("Trivandrum");

        ButtonGroup group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        group.add(opt4);

        ActionListener selectListener = e -> {
            capitalAnswer = ((JRadioButton) e.getSource()).getText();
        };

        opt1.addActionListener(selectListener);
        opt2.addActionListener(selectListener);
        opt3.addActionListener(selectListener);
        opt4.addActionListener(selectListener);

        q1Panel.add(q1);
        q1Panel.add(opt1);
        q1Panel.add(opt2);
        q1Panel.add(opt3);
        q1Panel.add(opt4);

        return q1Panel;
    }

    private static JPanel createQuestion2() {
        JPanel q2Panel = new JPanel(new BorderLayout());
        JLabel q2 = new JLabel("2) List the crops available in India in all seasons:");
        String[] crops = {"Rice", "Maize", "Jute", "Ragi"};
        JList<String> cropList = new JList<>(crops);
        cropList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(cropList);

        cropList.addListSelectionListener(e -> {
            selectedCrops = cropList.getSelectedValuesList();
        });

        q2Panel.add(q2, BorderLayout.NORTH);
        q2Panel.add(scrollPane, BorderLayout.CENTER);

        return q2Panel;
    }

    private static JPanel createResultPanel() {
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultLabel = new JLabel();
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);

        resultPanel.add(resultLabel, BorderLayout.CENTER);

        // Update result when shown
        resultPanel.addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
                String crops = (selectedCrops != null && !selectedCrops.isEmpty())
                        ? String.join(", ", selectedCrops)
                        : "None";
                resultLabel.setText("<html><h3>Results:</h3>Capital: " + capitalAnswer + "<br>Crops: " + crops + "</html>");
            }
        });

        return resultPanel;
    }
}