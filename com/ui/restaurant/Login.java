// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import java.awt.EventQueue;
import models.Utilisateur;
import enums.TypeUtilisateur;
import javax.swing.JOptionPane;
import dao.UtilisateurDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Login extends JFrame
{
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField passwordMotDePasse;
    
    public Login() {
        this.setDefaultCloseOperation(3);
        this.setTitle("Se connecter...");
        this.setBounds(100, 100, 450, 300);
        this.setSize(1014, 631);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lblSeConnecter = new JLabel("Se Connecter  ");
        lblSeConnecter.setBounds(404, 70, 312, 67);
        lblSeConnecter.setForeground(new Color(128, 0, 0));
        lblSeConnecter.setFont(new Font("Tahoma", 1, 36));
        this.contentPane.add(lblSeConnecter);
        final JLabel lblUsername = new JLabel("Nom d'utilisateur \r\n");
        lblUsername.setBounds(157, 153, 244, 61);
        lblUsername.setFont(new Font("Tahoma", 1, 16));
        this.contentPane.add(lblUsername);
        final JLabel lblMotDePasse = new JLabel("Mot de passe ");
        lblMotDePasse.setBounds(157, 231, 244, 61);
        lblMotDePasse.setFont(new Font("Tahoma", 1, 16));
        this.contentPane.add(lblMotDePasse);
        (this.txtUsername = new JTextField()).setBounds(364, 153, 347, 43);
        this.txtUsername.setFont(new Font("Tahoma", 1, 12));
        this.contentPane.add(this.txtUsername);
        this.txtUsername.setColumns(10);
        (this.passwordMotDePasse = new JPasswordField()).setBounds(364, 241, 347, 43);
        this.passwordMotDePasse.setFont(new Font("Tahoma", 1, 12));
        this.contentPane.add(this.passwordMotDePasse);
        final JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(373, 324, 164, 37);
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Login.this.dispose();
            }
        });
        btnAnnuler.setFont(new Font("Tahoma", 1, 12));
        this.contentPane.add(btnAnnuler);
        final JButton btnSeConnecter = new JButton("Se connecter");
        btnSeConnecter.setBounds(547, 324, 164, 37);
        btnSeConnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String username = Login.this.txtUsername.getText();
                final String password = new String(Login.this.passwordMotDePasse.getPassword());
                final Utilisateur utilisateur = UtilisateurDAO.Login(username, password);
                if (utilisateur == null) {
                    JOptionPane.showMessageDialog(null, "Verifiez votre login et mot de passe", "Erreur de login", 0);
                }
                else {
                    if (utilisateur.getType() == TypeUtilisateur.SERVEUSE) {
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    final HomeServeuse frame = new HomeServeuse(utilisateur);
                                    frame.setVisible(true);
                                }
                                catch (final Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (utilisateur.getType() == TypeUtilisateur.CUISINIER) {
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    final HomeCuisinier frame = new HomeCuisinier(utilisateur);
                                    frame.setVisible(true);
                                }
                                catch (final Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    else if (utilisateur.getType() == TypeUtilisateur.CUSTOMER) {
                        EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    final Home frame = new Home(utilisateur);
                                    frame.setVisible(true);
                                }
                                catch (final Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    Login.this.dispose();
                }
            }
        });
        btnSeConnecter.setFont(new Font("Tahoma", 1, 12));
        this.contentPane.add(btnSeConnecter);
    }
}
