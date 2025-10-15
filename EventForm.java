package mynewproject;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EventForm extends JPanel {
    private JTextField titleField;
    private JComboBox<String> typeBox;
    private JTextField locationField;
    private JDateChooser dateChooser;
    private JButton addButton;
    private JLabel feedbackLabel;

    public EventForm() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Event Title:"), gbc);
        gbc.gridx = 1;
        titleField = new JTextField(20);
        add(titleField, gbc);

        // Type
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Event Type:"), gbc);
        gbc.gridx = 1;
        typeBox = new JComboBox<>(new String[]{"Seminar", "Workshop", "Fest", "Other"});
        add(typeBox, gbc);

        // Location
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Location:"), gbc);
        gbc.gridx = 1;
        locationField = new JTextField(20);
        add(locationField, gbc);

        // Date Picker
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Event Date:"), gbc);
        gbc.gridx = 1;
        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        add(dateChooser, gbc);

        // Add Button
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        addButton = new JButton("Add Event");
        add(addButton, gbc);

        // Feedback Label
        gbc.gridy = 5;
        feedbackLabel = new JLabel(" ");
        feedbackLabel.setForeground(Color.BLUE);
        add(feedbackLabel, gbc);

        // Button Action
        addButton.addActionListener(e -> handleAddEvent());
    }

    private void handleAddEvent() {
        String title = titleField.getText().trim();
        String type = (String) typeBox.getSelectedItem();
        String location = locationField.getText().trim();
        Date selectedDate = dateChooser.getDate();

        if (title.isEmpty() || location.isEmpty() || selectedDate == null) {
            feedbackLabel.setText("Please fill all fields.");
            feedbackLabel.setForeground(Color.RED);
            return;
        }

        LocalDate eventDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        feedbackLabel.setText("Event \"" + title + "\" scheduled on " + eventDate);
        feedbackLabel.setForeground(Color.GREEN);

        // You can now pass this data to your EventManager class
        // Example: eventManager.addEvent(new Event(title, eventDate, location, type));
    }
}