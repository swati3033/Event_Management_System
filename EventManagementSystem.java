import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EventManagementSystem extends JFrame {

    // Declare JTextField variables as class variables
    private JTextField eventNameTextField;
    private JTextField subEventNameTextField;
    private JTextField locationTextField;
    private JTextField amountToPayTextField;
    private JTextField timeTextField;
    private JTextField departmentTextField;

    public EventManagementSystem() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Event Details");

        // Create a JFrame (the main window)
        JFrame frame = new JFrame("Event Details");
        // frame.setLocationRelativeTo(null);
        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        frame.setSize(800, 600);

        // Create a JPanel for the header
        JPanel header = new JPanel();
        header.setBackground(new Color(118, 178, 199)); // Header color
        frame.add(header, BorderLayout.NORTH);

        // Create a JLabel for the header
        JLabel headerLabel = new JLabel(" Add Events");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(Color.white);
        header.add(headerLabel);

        // Create a JPanel for the main content
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.lightGray); // Main panel color
        mainPanel.setLayout(new GridLayout(8, 2, 10, 10)); // GridLayout for labels and components
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        frame.add(mainPanel, BorderLayout.CENTER);

        // Add labels and components for event details
        /*JTextField eventNameTextField=*/addLabeledTextField(mainPanel, "Event Name:", 200);
        addComboBox(mainPanel, "Event Type:", new String[]{"Conference", "Seminar", "Technical", "Non-technical"});
        addLabeledTextField(mainPanel, "SubEvent Name:", 200);
        addLabeledTextField(mainPanel, "Location:", 200);
        addLabeledTextField(mainPanel, "Amount to pay:", 200);
        addDatePicker(mainPanel, "Date:");
        addLabeledTextField(mainPanel, "Time:", 200);
        addLabeledTextField(mainPanel, "Department:", 300); // New Department label and text field

        // Create a JPanel for the footer
        JPanel footer = new JPanel();
        footer.setBackground(new Color(118, 178, 199)); // Footer color
        frame.add(footer, BorderLayout.SOUTH);

        // Create save, edit, and delete buttons
        JButton saveButton = new JButton("Save");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        JButton Back = new JButton("Back");
        // Add buttons to the footer
        footer.add(saveButton);
        footer.add(editButton);
        footer.add(deleteButton);
        footer.add(Back);

        // Add action listeners for the buttons
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle save button action
                JOptionPane.showMessageDialog(frame, "Record saved successfully..");
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle edit button action
                JOptionPane.showMessageDialog(frame, "Record updated successfully..");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle delete button action
                JOptionPane.showMessageDialog(frame, "Record deleted successfully ");
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cframe.setVisible(true);
                EventManagement em=new EventManagement();
                em.cmemberTask();
            }
        });
        // Make the frame visible
        frame.setVisible(true);
        //   frame.setVisible(true);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
    }

    // Helper method to add labeled text fields to the main panel
    private static void addLabeledTextField(JPanel panel, String labelText, int textFieldWidth) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(textFieldWidth, 30));
        textField.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.add(textField);
    }

    // Helper method to add a labeled combo box to the main panel
    private static void addComboBox(JPanel panel, String labelText, String[] items) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label);

        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox.setPreferredSize(new Dimension(200, 30));
        panel.add(comboBox);
    }

    // Helper method to add a labeled date picker to the main panel
    private static void addDatePicker(JPanel panel, String labelText) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(label);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setPreferredSize(new Dimension(150, 30));
        panel.add(dateChooser);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventManagementSystem::new);

    }
}
