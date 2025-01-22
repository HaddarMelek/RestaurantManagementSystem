// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ModifierCommande extends JFrame
{
    private JPanel contentPane;
    
    public ModifierCommande() {
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 450, 300);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
    }
}
