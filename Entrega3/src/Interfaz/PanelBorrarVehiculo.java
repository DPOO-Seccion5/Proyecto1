package Interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBorrarVehiculo extends JPanel {
    private JPanel cardPanel;
	private CardLayout cardLayout;

	public PanelBorrarVehiculo(JPanel cardPanel, CardLayout cardLayout) {
   	 
   	 	this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
    	setLayout(new BorderLayout());

        // Title Panel (North)
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Borrar Vehiculo");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        
     // Second Panel (Center)
        JPanel infoPanel = new JPanel(new GridLayout(3, 1)); // Two rows and two columns

        // Labels and Text Fields
        JLabel label1 = new JLabel(" Placa:");
        label1.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField textField1 = new JTextField(1);
        textField1.setPreferredSize(new Dimension(15, 30)); // Set a fixed size for the text field

        infoPanel.add(label1);
        infoPanel.add(textField1);
        
        add(infoPanel, BorderLayout.CENTER);
        
        // Third Panel (South)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton confirmButton = new JButton("Eliminar");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String placa = textField1.getText();
            	JOptionPane.showMessageDialog(null, "Se eliminio el vehiculo de placa: "+placa);
            	cardLayout.show(cardPanel, "panelEmpleado");
            	
            }
        });
        
        JButton returnButton = new JButton("Devolverse");
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(cardPanel, "panelABVehi");
            	
            }
        });

        buttonPanel.add(returnButton);

        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
 }


	
}
