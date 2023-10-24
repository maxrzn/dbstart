package de.hbrs.ia.code;

import de.hbrs.ia.model.SalesMan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ViewPersonal {

        public static void main(String[] args) {
            ManagePersonal mp = new ManagePersonal();
            JFrame frame = new JFrame("add personal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 200);

            JPanel panel = new JPanel();

            // Create input field
            JLabel idLabel = new JLabel("ID:");
            JTextField idField = new JTextField(10);


            JLabel firstnamelabel = new JLabel("firstname:");
            JTextField firstnamefield = new JTextField(10);

            JLabel lastnamelabel = new JLabel("lastname");
            JTextField lastnamefield = new JTextField(10);

            //output text field
            JTextArea outputTextArea = new JTextArea(5, 60);
            outputTextArea.setEditable(true);

            // Create a button to perform the action
            JButton createButton = new JButton("create");
            JButton showButton = new JButton("show");

            //create SalesMan
            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id = Integer.parseInt(idField.getText());
                    String firstname = firstnamefield.getText();
                    String lastname = lastnamefield.getText();
                    mp.createSalesMan(new SalesMan(firstname,lastname,id));
                    outputTextArea.setText("Sucessfull!");
                }
            });

            //read SalesMan
            showButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int id = Integer.parseInt(idField.getText());
                    if(mp.readSalesMan(id) != null) {
                        outputTextArea.setText("Requested Employee: " + mp.readSalesMan(id).getFirstname() +" " +
                                                                        mp.readSalesMan(id).getLastname() +" , ID: "+
                                                                        mp.readSalesMan(id).getId());
                    } else {
                        outputTextArea.setText("Employee not found!");
                    }
                }
            });

            // Add components to the panel
            panel.add(idLabel);
            panel.add(idField);
            panel.add(firstnamelabel);
            panel.add(firstnamefield);
            panel.add(lastnamelabel);
            panel.add(lastnamefield);
            panel.add(createButton);
            panel.add(outputTextArea);
            panel.add(showButton);

            // Add the panel to the frame
            frame.add(panel);

            frame.setVisible(true);
        }
    }