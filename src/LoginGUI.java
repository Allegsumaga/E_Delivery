import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {
    private JButton exitBtn, loginBtn; 
    private JTextField userLog; 
    private JPasswordField passwordLog; 

    public LoginGUI() {
        setTitle("Kitchen 악몽");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Set the Icon for application (Globally)
        setIconImage(new ImageIcon(getClass().getResource("/images/Gmarketlogo.png")).getImage());

        // Set bounds GUI so screen center 
        setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding

        // Username label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Username:"), gbc);

        userLog = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(userLog, gbc);

        // Password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Password:"), gbc);

        passwordLog = new JPasswordField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(passwordLog, gbc);

        // Login button
        loginBtn = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        add(loginBtn, gbc);

        // Exit button
        exitBtn = new JButton("출구");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setBackground(Color.BLACK);
        exitBtn.setOpaque(true);
        exitBtn.setBorderPainted(false);
        exitBtn.addActionListener(this);
        add(exitBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitBtn) {
            System.exit(0);
        } else if (e.getSource() == loginBtn) {
            String username = userLog.getText();
            char[] password = passwordLog.getPassword();
            // Handle login logic here (e.g., sending credentials to the server)
            System.out.println("Username: " + username);
            System.out.println("Password: " + new String(password));
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}


