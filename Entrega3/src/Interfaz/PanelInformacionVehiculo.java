package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class PanelInformacionVehiculo extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelInformacionVehiculo(JPanel cardPanel, CardLayout cardLayout) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
    	setLayout(new BorderLayout());

        // First Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Informacion del Vehiculo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Second Panel (Center)
        JPanel infoPanel = new JPanel(new GridLayout(3, 1)); // Two rows and two columns

        // Labels and Text Fields
        JLabel label1 = new JLabel("                     Disponibilidad:");
        JTextField textField1 = new JTextField(20);
        textField1.setText("Disponibilidad que viene desde afuera");
        textField1.setEditable(false); // Make the text field uneditable
        textField1.setPreferredSize(new Dimension(15, 25)); // Set a fixed size for the text field

        // Customize the text field's appearance
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("                     Ubicacion:");
        JTextField textField2 = new JTextField(20);
        textField2.setText("Ubicacion que viene desde afuera");
        textField2.setEditable(false); // Make the text field uneditable
        textField2.setPreferredSize(new Dimension(15, 25)); // Set a fixed size for the text field

        // Customize the text field's appearance
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        
        JLabel label3 = new JLabel(" Fecha Nueva de Disponibilidad:");
        //label1.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField textField3 = new JTextField(1);
        textField1.setPreferredSize(new Dimension(15, 30)); // Set a fixed size for the text field

        infoPanel.add(label1);
        infoPanel.add(textField1);
        infoPanel.add(label2);
        infoPanel.add(textField2);
        infoPanel.add(label3);
        infoPanel.add(textField3);
        
        
        add(infoPanel, BorderLayout.CENTER);

        // Third Panel (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton confirmButton = new JButton("Mantenimiento");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String fechaNueva = (String) textField3.getText();
            	JOptionPane.showMessageDialog(null, "La nueva fecha de disponibilidad quedo el: "+fechaNueva);
            	cardLayout.show(cardPanel, "panelEmpleado");
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                	cardLayout.show(cardPanel, "panelBuscarVehi");
                
               
            }
        });

        buttonPanel.add(returnButton);
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
