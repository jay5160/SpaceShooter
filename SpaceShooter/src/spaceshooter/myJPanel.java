/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.BorderLayout;

public class myJPanel extends JPanel implements ActionListener {

    JButton start;

    myJPanel() {
        
        this.setLayout(new BorderLayout());
        start = new JButton("Go!");
        this.add(start, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
