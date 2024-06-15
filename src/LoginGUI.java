import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import models.Log_User; // Import the Log_User model
//Audio files 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//Array List data structure 
import java.util.ArrayList;
import java.util.List;
//File Writer 
import java.io.FileWriter;
import java.io.IOException;

public class LoginGUI extends JFrame {
    private BufferedImage defaultImage;
    private JTextField userIdField; // Make userIdField an instance variable
    private JPasswordField passwordField; // Make passwordField an instance variable
    private Clip audioClip;
    //Initialize list to store selected dishes
    private List<String> selectedDishes = new ArrayList<>();
    private int dishCount = 0; //Counter for selected
    private JLabel productCountLabel;

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

        // Load the audio file
        loadAudio("/resources/sound/TLOUMT.wav");

        // Initialize the first screen
        initFirstScreen();

        // Set the Icon for application (Globally)
        setIconImage(new ImageIcon(getClass().getResource("/resources/images/TLOC WB.png")).getImage());

        // Play the audio when the application starts
        playAudio();
    }

    private void loadAudio(String audioFilePath) {
        try {
            URL audioUrl = getClass().getResource(audioFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioUrl);
            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();
        }
    }

    private void playAudio() {
        if (audioClip != null) {
            audioClip.start();
        }
    }

    private void stopAudio() {
        if (audioClip != null) {
            audioClip.stop();
            audioClip.close();
        }
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
                stopAudio();
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
        choiceScreenPanel.add(exitButton);

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
        customerScreenPanel.setLayout(new BorderLayout());  // Use BorderLayout for proper menu placement
    
        // Create the JMenuBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.BLACK);
        menuBar.setForeground(Color.WHITE);
        menuBar.setBorder(null);
    
        // Menu structure
        JMenu overviewMenu = new JMenu("Overview");
        overviewMenu.setForeground(Color.WHITE);
        overviewMenu.setBackground(Color.BLACK);
        overviewMenu.setOpaque(true);
    
        // Create the JMenuItem
        JMenuItem appVersion = new JMenuItem("Version");
        overviewMenu.add(appVersion);
    
        // Action Listener
        appVersion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LoginGUI.this, "Runner V1.0", "Application Version", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
        JMenu languageMenu = new JMenu("Language");
        languageMenu.setForeground(Color.WHITE);
        languageMenu.setBackground(Color.BLACK);
        languageMenu.setOpaque(true);
        JMenuItem KRversion = new JMenuItem("한국어");
        languageMenu.add(KRversion);
    
        JMenu aboutUsMenu = new JMenu("About Us");
        aboutUsMenu.setForeground(Color.WHITE);
        aboutUsMenu.setBackground(Color.BLACK);
        aboutUsMenu.setOpaque(true);
    
        // Add JMenuItem to "About Us"
        JMenuItem aboutUSItem = new JMenuItem("About us info");
        aboutUSItem.setForeground(Color.WHITE);
        aboutUSItem.setBackground(Color.BLACK);
        aboutUSItem.setOpaque(true);
        aboutUsMenu.add(aboutUSItem);
    
        // Add ActionListener to the JMenuItem
        aboutUSItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(customerScreenPanel, "Seville, Spain Iberian Industries 2024, Naughty Dogs & Sony Interactive Studios & Magana Enterprise", "The Last Of Cuisine", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
        // Add menus to the menu bar
        menuBar.add(overviewMenu);
        menuBar.add(languageMenu);
        menuBar.add(aboutUsMenu);
    
        // Add the menu bar to the panel at the top
        customerScreenPanel.add(menuBar, BorderLayout.NORTH);
    
        // Create a JPanel for the content below the menu
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.BLACK);
        contentPanel.setLayout(null);  // Use absolute positioning
    
        // Create the Title label
        JLabel titleLabel = new JLabel("Catalan Dishes");
        titleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50, 20, 250, 40);
        contentPanel.add(titleLabel);
    
        // Sample dish options with prices
        String[] dishes = {"Canelons - €12", "Faves a la Catalana - €10", "Fricandó - €15", "Catalan cream - €8", "Botifarra amb mongetes - €5"};
        JList<String> dishList = new JList<>(dishes);
        dishList.setFont(new Font("Press Gothic Regular", Font.PLAIN, 20));
        dishList.setForeground(Color.WHITE);
        dishList.setBackground(Color.BLACK);
    
        // Make the dish list scrollable
        JScrollPane dishScrollPane = new JScrollPane(dishList);
        dishScrollPane.setBounds(50, 100, 250, 150);
        dishScrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        contentPanel.add(dishScrollPane);
    
        // Basket section
        JLabel basketTitleLabel = new JLabel("Basket");
        basketTitleLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 30));
        basketTitleLabel.setForeground(Color.WHITE);
        basketTitleLabel.setBounds(350, 20, 150, 40);
        contentPanel.add(basketTitleLabel);
    
        try {
            BufferedImage basketImage = ImageIO.read(getClass().getResource("/resources/images/CartB.png"));
            JLabel basketImageLabel = new JLabel(new ImageIcon(basketImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            basketImageLabel.setBounds(350, 70, 50, 50);
            contentPanel.add(basketImageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        productCountLabel = new JLabel("Products:");
        productCountLabel.setFont(new Font("Press Gothic Regular", Font.BOLD, 20));
        productCountLabel.setForeground(Color.WHITE);
        productCountLabel.setBounds(350, 130, 150, 30);
        contentPanel.add(productCountLabel);
    
        // Create the Back button to go back to choice screen
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        backButton.setBounds(50, 350, 100, 50);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(null);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToChoiceScreen();
            }
        });
        contentPanel.add(backButton);
    
        // Create the Add button to add selected product
        JButton addButton = new JButton("Add");
        addButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        addButton.setBounds(170, 350, 100, 50);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(null);
        addButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the selected dish to the basket
                String selectedDish = dishList.getSelectedValue();
                if (selectedDish != null) {
                    if(selectedDishes.size() < 30){
                        selectedDishes.add(selectedDish);
                        dishCount++;
                        productCountLabel.setText("Products: ("+ dishCount + ")");
                    } else{
                        JOptionPane.showMessageDialog(LoginGUI.this,"Maximum 30 dishes reached","Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Please select a dish to add.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        contentPanel.add(addButton);
    
        // Create the Checkout button to show products in a JTable
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        checkoutButton.setBounds(290, 350, 150, 50);
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setBackground(null);
        checkoutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCheckoutTable(); // Call showCheckoutTable() instead of showing a JOptionPane
            }
        });
        contentPanel.add(checkoutButton);
    
        // Add the content panel to the customer screen panel
        customerScreenPanel.add(contentPanel, BorderLayout.CENTER);
    
        // Replace the content pane with the customer screen panel
        setContentPane(customerScreenPanel);
        revalidate(); // Refresh the frame to apply changes
    }
    
    
    
    private void showCheckoutTable() {
        // Convert selectedDishes list to table data
        String[] columnNames = {"Product", "Price"};
        Object[][] data = new Object[selectedDishes.size()][2];
    
        for (int i = 0; i < selectedDishes.size(); i++) {
            String dish = selectedDishes.get(i);
            String[] parts = dish.split(" - "); // Split by " - " to separate name and price
            data[i][0] = parts[0]; // Product name
            data[i][1] = parts[1]; // Price
        }
    
        // Create JTable with data
        JTable infoTable = new JTable(data, columnNames);
        infoTable.setFillsViewportHeight(true);
        infoTable.setBackground(Color.BLACK);
        infoTable.setForeground(Color.WHITE);
        infoTable.setFont(new Font("Press Gothic Regular", Font.PLAIN, 16));
        infoTable.getTableHeader().setBackground(Color.BLACK);
        infoTable.getTableHeader().setForeground(Color.WHITE);
        infoTable.getTableHeader().setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
    
        // Create JScrollPane for the table
        JScrollPane tableScrollPane = new JScrollPane(infoTable);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));
    
        // Create JPanel to hold the table
        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.BLACK);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);
    
        // Create Back button to go back to customer screen
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(null);
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedDishes.clear(); // Clear selected dishes for new checkout
                dishCount = 0;
                productCountLabel.setText("Products: (" + dishCount + ")");
                switchToCustomerScreen(); // Go back to customer screen
            }
        });
    
        // Create Pay button to process payment (placeholder functionality)
        JButton payButton = new JButton("Pay");
        payButton.setFont(new Font("Press Gothic Regular", Font.BOLD, 16));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(null);
        payButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Write the checkout data to Chef.java
                try (FileWriter writer = new FileWriter("Chef.java")) {
                    for (String dish : selectedDishes) {
                        writer.write(dish + "\n");
                    }
                    JOptionPane.showMessageDialog(LoginGUI.this, "Payment processed successfully! Data sent to Chef.java", "Payment", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Error writing to Chef.java", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    
        // Create JPanel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        buttonPanel.add(payButton);
    
        // Create JFrame to display checkout table
        JFrame tableFrame = new JFrame("Checkout");
        tableFrame.setSize(450, 300);
        tableFrame.setLocationRelativeTo(null);
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose frame on close
        tableFrame.getContentPane().setBackground(Color.BLACK);
        tableFrame.setLayout(new BorderLayout());
        tableFrame.add(tablePanel, BorderLayout.CENTER);
        tableFrame.add(buttonPanel, BorderLayout.SOUTH);
        tableFrame.setVisible(true);
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

//Pending for other branches to pass











