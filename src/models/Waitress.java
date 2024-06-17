package models;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Waitress extends JFrame {

    // Nested Pedido class
    class Pedido {
        String orden;
        String lugar_pedido;
        Pedido siguiente;

        public Pedido(String orden, String lugar_pedido) {
            this.orden = orden;
            this.lugar_pedido = lugar_pedido;
        }
    }

    // Fields
    private Pedido inicio;
    private int total = 0;
    private String orden = "";
    private String lugar_pedido;
    private Chef chef;  // Add a reference to the Chef class

    // GUI components
    private JPanel jPanel2;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JButton jButton2;
    private JPanel jPanel3;
    private JLabel jLabel3;
    private JPanel jPanel4;
    private JComboBox<String> jc_pedido;
    private JTextArea jt_preorden;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JLabel jLabel4;
    private JLabel total_pedido;
    private JButton jButton1;
    private JButton jButton11;

    // Constructor
    public Waitress() {
        initComponents();  // Initialize components first
        waitressMethod();   // Then call static method
        chef = new Chef();  // Instantiate the Chef class
        chef.setVisible(true);  // Show the Chef window
    }

    // Static method
    public static void waitressMethod() {
        // Implement the functionality for waitressMethod
        // This method should contain the logic specific to the waitress screen
        System.out.println("Waitress method called!");
    }

    // Method to add a new order
    private void agregarPedido(String nombre, String lugar_p) {
        Pedido nuevo = new Pedido(nombre, lugar_p);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        }
        System.out.println(inicio.orden + " " + inicio.lugar_pedido);
    }

    // Method to add an item to the current order
    private void agregarItem(String item, int precio) {
        orden += "\n" + item;
        jt_preorden.append("\n" + item + " ------------ $" + precio);
        total += precio;
    }

    // Method to format the order and send to Chef
    private void enviarOrdenAChef() {
        List<String> dishes = new ArrayList<>();
        String[] items = orden.split("\n");
        for (String item : items) {
            if (!item.trim().isEmpty()) {
                dishes.add(item.trim());
            }
        }
        dishes.add("En el local");  // Assuming "En el local" should be added at the end
        chef.updateOrder(dishes);
    }

    // Initialize GUI components
    private void initComponents() {
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jPanel1 = new JPanel(new GridLayout(3, 3));

        jButton2 = new JButton("Sushi");
        jButton2.addActionListener(evt -> agregarItem("Sushi", 100));
        jPanel1.add(jButton2);

        // Add other buttons similarly

        jPanel3 = new JPanel();
        jLabel3 = new JLabel();
        jPanel4 = new JPanel();
        jc_pedido = new JComboBox<>(new String[]{"Para llevar", "En el local"});
        jt_preorden = new JTextArea();
        jScrollPane1 = new JScrollPane(jt_preorden);
        jSeparator1 = new JSeparator();
        jLabel4 = new JLabel();
        total_pedido = new JLabel();
        jButton1 = new JButton("Cobrar y enviar a cocina");
        jButton1.addActionListener(evt -> {
            jt_preorden.setText("");
            total_pedido.setText("");
            int result = JOptionPane.showConfirmDialog(null, "¿Deseas confirmar el pedido y enviar a cocina?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Pedido realizado y enviado a cocina");
                lugar_pedido = jc_pedido.getSelectedItem().toString();
                agregarPedido(orden, lugar_pedido);
                enviarOrdenAChef();  // Send the order to Chef
                orden = "";  // Clear the order after sending
            }
            total = 0;
        });

        jButton11 = new JButton("Generar Total");
        jButton11.addActionListener(evt -> {
            if (total == 0) {
                JOptionPane.showMessageDialog(null, "No se han agregado artículos");
            } else {
                total_pedido.setText("$ " + total);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        jPanel2.setBackground(new Color(153, 0, 0));
        jLabel1.setFont(new Font("Oriya Sangam MN", Font.BOLD, 25));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setText("Todos los artículos");
        jPanel2.add(jLabel1);
        getContentPane().add(jPanel2, BorderLayout.NORTH);

        jPanel1.setBackground(Color.WHITE);
        getContentPane().add(jPanel1, BorderLayout.CENTER);

        jPanel3.setBackground(new Color(184, 137, 119));
        jLabel3.setFont(new Font("Oriya Sangam MN", Font.BOLD, 25));
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setText("Resumen de compra");
        jPanel3.add(jLabel3);
        getContentPane().add(jPanel3, BorderLayout.WEST);

        jPanel4.setBackground(Color.WHITE);
        jPanel4.setLayout(new GridLayout(7, 1));
        jPanel4.add(jc_pedido);
        jPanel4.add(jScrollPane1);
        jPanel4.add(jSeparator1);
        jPanel4.add(jLabel4);
        jPanel4.add(total_pedido);
        jPanel4.add(jButton11);
        jPanel4.add(jButton1);
        getContentPane().add(jPanel4, BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
    }

    // Main method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Waitress().setVisible(true));
    }
}




