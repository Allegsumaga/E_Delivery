import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import models.Log_User; // Import the Log_User model

public class LoginGUI extends JFrame {
    private BufferedImage defaultImage;
    private JTextField userIdField; // Make userIdField an instance variable
    private JPasswordField passwordField; // Make passwordField an instance variable

    public LoginGUI() {
        // Load the image for the first screen
        String defaultImagePath = "/resources/images/BTLOUFB.jpeg";
        URL imageUrl = getClass().getResource(defaultImagePath);
        if (imageUrl != null) {
            try {
                defaultImage = ImageIO.read(imageUrl);
                defaultImage = scaleImage(defaultImage, 650, 650); // Scale the image to fit 650x650
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Image not found: " + defaultImagePath);
        }

        initFirstScreen();

        // Set the Icon for application (Globally)
        setIconImage(new ImageIcon(getClass().getResource("/resources/images/TLOC WB.png")).getImage());
    }

    private void initFirstScreen() {
        // Set up the JFrame
        setTitle("The last of Cuisine");
        setSize(650, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true); // Remove Win Decorations
        setLayout(new BorderLayout());

        // Create a JPanel for the first screen
        JPanel firstScreenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (defaultImage != null) {
                    g.drawImage(defaultImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.err.println("Image is null, cannot draw.");
                }
            }
        };
        firstScreenPanel.setLayout(null);  // Use absolute positioning

        // Create the label and add it to the center
        JLabel label = new JLabel("PRESS ANY BUTTON", SwingConstants.CENTER);
        label.setFont(new Font("Press Gothic Regular", Font.BOLD, 16)); // ORIGINAL SIZE 16
        label.setForeground(Color.WHITE);
        label.setBounds(0, 275, 650, 50); // Centered vertically

        // Add the label to the first screen panel
        firstScreenPanel.add(label);

        // Add mouse listener to switch to the choice screen when clicked
        firstScreenPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchToChoiceScreen();
            }
        });

        // Set the first screen panel as the content pane
        setContentPane(firstScreenPanel);
    }

    private void switchToChoiceScreen() {
        // Create a JPanel for the choice screen
        JPanel choiceScreenPanel = new JPanel();
        choiceScreenPanel.setBackground(Color.BLACK);
        choiceScreenPanel.setLayout(null);  // Use absolute positioning

        // Create the Title label
        JLabel titleLabel = new JLabel("The Last of Cuisine");
        titleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(150, 50, 350, 40);
        choiceScreenPanel.add(titleLabel);

        // Create the Employee button
        JButton employeeButton = new JButton("Employee");
        employeeButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        employeeButton.setBounds(200, 200, 250, 50);
        employeeButton.setForeground(Color.WHITE);
        employeeButton.setBackground(null);
        employeeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToEmployeeScreen();
            }
        });
        choiceScreenPanel.add(employeeButton);

        // Create the Customer button
        JButton customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        customerButton.setBounds(200, 300, 250, 50);
        customerButton.setForeground(Color.WHITE);
        customerButton.setBackground(null);
        customerButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToCustomerScreen();
            }
        });
        choiceScreenPanel.add(customerButton);

        // Replace the content pane with the choice screen panel
        setContentPane(choiceScreenPanel);
        revalidate(); // Refresh the frame to apply changes
    }

    private void switchToEmployeeScreen() {
        // Create a JPanel for the second screen with the background color
        JPanel secondScreenPanel = new JPanel();
        secondScreenPanel.setBackground(new Color(3, 4, 4)); // RGB color #030404
        secondScreenPanel.setLayout(null);  // Use absolute positioning

        // Create the Title label
        JLabel titleLabel = new JLabel("THE LAST OF CUISINE");
        titleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50, 20, titleLabel.getPreferredSize().width, titleLabel.getPreferredSize().height);

        // Create the UserID section
        URL userIdImageUrl = getClass().getResource("/resources/images/PSTB.png");
        if (userIdImageUrl != null) {
            ImageIcon userIdIcon = new ImageIcon(userIdImageUrl);
            // Adjust the size of the icon
            int iconWidth = 30; // Adjust as needed
            int iconHeight = 30; // Adjust as needed
            Image scaledIcon = userIdIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledUserIdIcon = new ImageIcon(scaledIcon);
            JLabel userIdLabel = new JLabel(scaledUserIdIcon);
            userIdLabel.setBounds(100, 100, iconWidth, iconHeight);

            // Create the userID text field with pre-text 
            userIdField = new JTextField("Ellie Williams");
            userIdField.setForeground(Color.WHITE); // Add Foreground to set it visible
            userIdField.setBounds(150, 100, 250, 30); // Adjust the X position
            userIdField.setBorder(null);
            userIdField.setBackground(null);

            // Add focus listener to the user ID text field
            userIdField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (userIdField.getText().equals("Ellie Williams")) {
                        userIdField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (userIdField.getText().isEmpty()) {
                        userIdField.setText("Ellie Williams");
                    }
                }
            });

            // Add the user ID label and text field to the second screen panel
            secondScreenPanel.add(userIdLabel);
            secondScreenPanel.add(userIdField);
        }

        // Create the Password section
        URL passwordImageUrl = getClass().getResource("/resources/images/Weye.jpg");
        if (passwordImageUrl != null) {
            ImageIcon passwordIcon = new ImageIcon(passwordImageUrl);
            int iconWidth = 30; // Adjust as needed
            int iconHeight = 30; // Adjust as needed
            Image scaledIcon = passwordIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
            ImageIcon scaledPasswordIcon = new ImageIcon(scaledIcon);
            JLabel passwordIconLabel = new JLabel(scaledPasswordIcon);
            passwordIconLabel.setBounds(100, 150, iconWidth, iconHeight);
            secondScreenPanel.add(passwordIconLabel);
        }

        passwordField = new JPasswordField("Password");
        passwordField.setBounds(150, 150, 250, 30);
        passwordField.setForeground(Color.WHITE); // PREVENTS TO BE INVISIBLE
        passwordField.setBorder(null);
        passwordField.setBackground(null);

        // Add focus listener to the password text field
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                }
            }
        });
        secondScreenPanel.add(passwordField);

        // Create the Login button
        JButton loginButton = new JButton("LOGIN");
        loginButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(null);
        loginButton.setBackground(null);
        loginButton.setBounds(300, 200, 150, 40);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userIdField.getText();
                String password = new String(passwordField.getPassword());

                Log_User logUser = new Log_User(user, password);
                if (logUser.validate()) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    // Proceed to the Waitress screen
                    switchToWaitressScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials, please try again.");
                }
            }
        });
        secondScreenPanel.add(loginButton);

        // Create the Exit button with a custom image
        JButton exitButton = new JButton();
        try {
            BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/FirefliesW.png"));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(50, 50, Image.SCALE_SMOOTH)); // Original 50x50
            exitButton.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        exitButton.setBounds(550, 550, 50, 50); // Original 570 550
        exitButton.setBorderPainted(false); // Remove the border
        exitButton.setFocusPainted(false); // Remove the focus border
        exitButton.setContentAreaFilled(false); // Make content area transparent
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
        secondScreenPanel.add(exitButton);

        // Add components to the second screen panel
        secondScreenPanel.add(titleLabel);

        // Replace the content pane with the second screen panel
        setContentPane(secondScreenPanel);
        revalidate(); // Refresh the frame to apply changes
    }

    private void switchToCustomerScreen() {
        // Create a JPanel for the customer screen
        JPanel customerScreenPanel = new JPanel();
        customerScreenPanel.setBackground(Color.BLACK);
        customerScreenPanel.setLayout(null);  // Use absolute positioning

        // Create the Title label
        JLabel titleLabel = new JLabel("Dish Options");
        titleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(200, 50, 250, 40);
        customerScreenPanel.add(titleLabel);

        // Sample dish options
        String[] dishes = {"Dish 1", "Dish 2", "Dish 3"};
        JList<String> dishList = new JList<>(dishes);
        dishList.setFont(new Font("Press Gothic Regular", Font.PLAIN, 20));
        dishList.setBounds(200, 150, 250, 150);
        customerScreenPanel.add(dishList);

        // Create the Back button to go back to choice screen
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        backButton.setBounds(200, 350, 250, 50);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(null);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToChoiceScreen();
            }
        });
        customerScreenPanel.add(backButton);

        // Replace the content pane with the customer screen panel
        setContentPane(customerScreenPanel);
        revalidate(); // Refresh the frame to apply changes
    }

    private void switchToWaitressScreen() {
        // Create a JPanel for the waitress screen (currently a placeholder)
        JPanel waitressScreenPanel = new JPanel();
        waitressScreenPanel.setBackground(Color.BLACK); 
        waitressScreenPanel.setLayout(null);  // Use absolute positioning

        // Create the Title label
        JLabel titleLabel = new JLabel("Waitress Screen");
        titleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(200, 50, 250, 40);
        waitressScreenPanel.add(titleLabel);

        // Add more components as needed for the waitress screen

        // Replace the content pane with the waitress screen panel
        setContentPane(waitressScreenPanel);
        revalidate(); // Refresh the frame to apply changes
    }

    private BufferedImage scaleImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();
        return resizedImage;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            LoginGUI app = new LoginGUI();
            app.setVisible(true);
        });
    }
}










