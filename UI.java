import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    JFrame window = new JFrame("Physics Calculator");
    JTextField tfMass = new JTextField("Enter mass (kg)");
    JTextField tfAcceleration = new JTextField("Enter acceleration (m/s^2)");
    JButton btnCalculate = new JButton("Calculate Force");

    public UI() {
        drawUI();
    }

    void drawUI(){
        window.add(tfMass, BorderLayout.NORTH);
        window.add(tfAcceleration, BorderLayout.CENTER);
        window.add(btnCalculate, BorderLayout.SOUTH);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Physics calc = new Physics();
                try {
                    float mass = Float.parseFloat(tfMass.getText());
                    float acceleration = Float.parseFloat(tfAcceleration.getText());
                    JOptionPane.showMessageDialog(null, "Force: " + calc.calculateForce(mass, acceleration) + " N");
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Enter only numeric values");
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "An error occurred");
                }
            }
        });

        window.setSize(300, 200);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}