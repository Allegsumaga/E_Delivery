package models;

import javax.swing.*;
import java.util.List;

public class Chef extends JFrame {

    private static Chef instance; // Singleton instance

    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel jLabel1;
    private JTextArea jta1;
    private JTextArea jta2;
    private JTextArea jta3;
    private JTextArea jta4;
    private JTextArea jta5;
    private JTextArea jta6;

    private JCheckBox jcb1;
    private JCheckBox jcb2;
    private JCheckBox jcb3;
    private JCheckBox jcb4;
    private JCheckBox jcb5;
    private JCheckBox jcb6;

    private Chef() {
        initComponents();  // Initialize GUI components
    }

    // Method to get the singleton instance of Chef
    public static synchronized Chef getInstance() {
        if (instance == null) {
            instance = new Chef();
        }
        return instance;
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jta1 = new JTextArea();
        jta2 = new JTextArea();
        jta3 = new JTextArea();
        jta4 = new JTextArea();
        jta5 = new JTextArea();
        jta6 = new JTextArea();
        jcb1 = new JCheckBox();
        jcb2 = new JCheckBox();
        jcb3 = new JCheckBox();
        jcb4 = new JCheckBox();
        jcb5 = new JCheckBox();
        jcb6 = new JCheckBox();
        JButton jButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButton5 = new JButton();
        JButton jButton6 = new JButton();
        JButton jButton7 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KITCHEN TO DO LIST");

        jPanel1.add(jLabel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        // Initialize JTextAreas with initial text
        jta1.setText("No hay ordenes aquí.");
        jta2.setText("No hay ordenes aquí.");
        jta3.setText("No hay ordenes aquí.");
        jta4.setText("No hay ordenes aquí.");
        jta5.setText("No hay ordenes aquí.");
        jta6.setText("No hay ordenes aquí.");

        jButton1.setText("DONE");
        jButton1.addActionListener(evt -> {
            if (jcb1.isSelected()) {
                jta1.setText("No hay ordenes aquí.");
                jcb1.setSelected(false);
            }
        });

        jButton2.setText("DONE");
        jButton2.addActionListener(evt -> {
            if (jcb2.isSelected()) {
                jta2.setText("No hay ordenes aquí.");
                jcb2.setSelected(false);
            }
        });

        jButton3.setText("DONE");
        jButton3.addActionListener(evt -> {
            if (jcb3.isSelected()) {
                jta3.setText("No hay ordenes aquí.");
                jcb3.setSelected(false);
            }
        });

        jButton5.setText("DONE");
        jButton5.addActionListener(evt -> {
            if (jcb4.isSelected()) {
                jta4.setText("No hay ordenes aquí.");
                jcb4.setSelected(false);
            }
        });

        jButton6.setText("DONE");
        jButton6.addActionListener(evt -> {
            if (jcb5.isSelected()) {
                jta5.setText("No hay ordenes aquí.");
                jcb5.setSelected(false);
            }
        });

        jButton7.setText("DONE");
        jButton7.addActionListener(evt -> {
            if (jcb6.isSelected()) {
                jta6.setText("No hay ordenes aquí.");
                jcb6.setSelected(false);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(jta1, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(jta2)
                        .addComponent(jta3)
                        .addComponent(jta4)
                        .addComponent(jta5)
                        .addComponent(jta6))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jcb1)
                        .addComponent(jcb2)
                        .addComponent(jcb3)
                        .addComponent(jcb4)
                        .addComponent(jcb5)
                        .addComponent(jcb6))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(jButton7))
                    .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(jcb1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jcb2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)
                        .addComponent(jcb3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)
                        .addComponent(jcb4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6)
                        .addComponent(jcb5))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jta6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton7)
                        .addComponent(jcb6))
                    .addContainerGap(48, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    // Method to update order in JTextAreas
    public void updateOrder(List<String> dishes) {
        StringBuilder orderText = new StringBuilder();
        for (String dish : dishes) {
            orderText.append(dish).append("\n");
        }
        String orderString = orderText.toString();

        if (jta1.getText().equals("No hay ordenes aquí.")) {
            jta1.setText(orderString);
        } else if (jta2.getText().equals("No hay ordenes aquí.")) {
            jta2.setText(orderString);
        } else if (jta3.getText().equals("No hay ordenes aquí.")) {
            jta3.setText(orderString);
        } else if (jta4.getText().equals("No hay ordenes aquí.")) {
            jta4.setText(orderString);
        } else if (jta5.getText().equals("No hay ordenes aquí.")) {
            jta5.setText(orderString);
        } else if (jta6.getText().equals("No hay ordenes aquí.")) {
            jta6.setText(orderString);
        } else {
            JOptionPane.showMessageDialog(this, "No hay espacio para nuevas órdenes.");
        }
    }

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> Chef.getInstance().setVisible(true));
    }
}




