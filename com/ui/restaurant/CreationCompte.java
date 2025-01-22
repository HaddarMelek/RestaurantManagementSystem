// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import enums.TypeUtilisateur;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import dao.UtilisateurDAO;
import helpers.TypeUtilisateurHelper;
import models.Utilisateur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JRadioButton;
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

public class CreationCompte extends JFrame
{
    private JPanel contentPane;
    private JTextField txtNomComplet;
    private JPasswordField passwordMotDePasse;
    private JTextField txtTel;
    private JTextField txtAdresse;
    private JTextField txtUserName;
    
    public CreationCompte() {
        this.setDefaultCloseOperation(3);
        this.setTitle("Creation d'un compte...");
        this.setSize(1366, 768);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lblCreerCompte = new JLabel("Cr\u00e9er un compte ");
        lblCreerCompte.setForeground(new Color(128, 0, 0));
        lblCreerCompte.setFont(new Font("Tahoma", 1, 36));
        lblCreerCompte.setBounds(488, 35, 312, 67);
        this.contentPane.add(lblCreerCompte);
        final JLabel lblNomComplet = new JLabel("Nom Complet \r\n");
        lblNomComplet.setFont(new Font("Tahoma", 1, 16));
        lblNomComplet.setBounds(157, 153, 244, 61);
        this.contentPane.add(lblNomComplet);
        final JLabel lblTel = new JLabel("Num\u00e9ro de T\u00e9l\u00e9phone ");
        lblTel.setFont(new Font("Tahoma", 1, 16));
        lblTel.setBounds(157, 231, 244, 61);
        this.contentPane.add(lblTel);
        final JLabel lblAdresse = new JLabel("Adresse ");
        lblAdresse.setFont(new Font("Tahoma", 1, 16));
        lblAdresse.setBounds(157, 313, 244, 61);
        this.contentPane.add(lblAdresse);
        final JLabel lblType = new JLabel("Type ");
        lblType.setFont(new Font("Tahoma", 1, 16));
        lblType.setBounds(157, 452, 244, 61);
        this.contentPane.add(lblType);
        final JLabel lblUsername = new JLabel("Nom d'utilisateur");
        lblUsername.setFont(new Font("Tahoma", 1, 16));
        lblUsername.setBounds(157, 523, 244, 61);
        this.contentPane.add(lblUsername);
        final JLabel lblMotDePasse = new JLabel("Mot de passe ");
        lblMotDePasse.setFont(new Font("Tahoma", 1, 16));
        lblMotDePasse.setBounds(157, 594, 244, 61);
        this.contentPane.add(lblMotDePasse);
        (this.txtNomComplet = new JTextField()).setFont(new Font("Tahoma", 1, 12));
        this.txtNomComplet.setBounds(364, 153, 347, 43);
        this.contentPane.add(this.txtNomComplet);
        this.txtNomComplet.setColumns(10);
        final JRadioButton rdbtnCuisinier = new JRadioButton();
        rdbtnCuisinier.setText("Cuisinier");
        rdbtnCuisinier.setFont(new Font("Tahoma", 1, 12));
        rdbtnCuisinier.setBounds(364, 465, 103, 39);
        this.contentPane.add(rdbtnCuisinier);
        (this.passwordMotDePasse = new JPasswordField()).setFont(new Font("Tahoma", 1, 12));
        this.passwordMotDePasse.setBounds(364, 594, 347, 43);
        this.contentPane.add(this.passwordMotDePasse);
        (this.txtTel = new JTextField()).setFont(new Font("Tahoma", 1, 12));
        this.txtTel.setColumns(10);
        this.txtTel.setBounds(364, 231, 347, 43);
        this.contentPane.add(this.txtTel);
        (this.txtAdresse = new JTextField()).setFont(new Font("Tahoma", 1, 12));
        this.txtAdresse.setColumns(10);
        this.txtAdresse.setBounds(364, 313, 347, 129);
        this.contentPane.add(this.txtAdresse);
        (this.txtUserName = new JTextField()).setFont(new Font("Tahoma", 1, 12));
        this.txtUserName.setColumns(10);
        this.txtUserName.setBounds(364, 523, 347, 43);
        this.contentPane.add(this.txtUserName);
        final JRadioButton rdbtnServeuse = new JRadioButton();
        rdbtnServeuse.setText("Serveuse");
        rdbtnServeuse.setFont(new Font("Tahoma", 1, 12));
        rdbtnServeuse.setBounds(573, 465, 103, 39);
        this.contentPane.add(rdbtnServeuse);
        final JRadioButton rdbtnClient = new JRadioButton();
        rdbtnClient.setText("Client");
        rdbtnClient.setFont(new Font("Tahoma", 1, 12));
        rdbtnClient.setBounds(782, 465, 103, 39);
        this.contentPane.add(rdbtnClient);
        final JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setFont(new Font("Tahoma", 1, 12));
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        btnAnnuler.setBounds(364, 665, 164, 37);
        this.contentPane.add(btnAnnuler);
        final JButton btnCreerCompte = new JButton("Cr\u00e9er un compte");
        btnCreerCompte.setFont(new Font("Tahoma", 1, 12));
        btnCreerCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNomComplet(CreationCompte.this.txtNomComplet.getText());
                utilisateur.setTel(CreationCompte.this.txtTel.getText());
                utilisateur.setAdresse(CreationCompte.this.txtAdresse.getText());
                TypeUtilisateur type;
                if (rdbtnCuisinier.isSelected()) {
                    type = TypeUtilisateurHelper.GetTypeUtilisateur(3);
                }
                else if (rdbtnServeuse.isSelected()) {
                    type = TypeUtilisateurHelper.GetTypeUtilisateur(2);
                }
                else {
                    type = TypeUtilisateurHelper.GetTypeUtilisateur(1);
                }
                utilisateur.setType(type);
                utilisateur.setUsername(CreationCompte.this.txtUserName.getText());
                utilisateur.setMotDePasse(new String(CreationCompte.this.passwordMotDePasse.getPassword()));
                if (UtilisateurDAO.Inscrire(utilisateur) == -1) {
                    JOptionPane.showMessageDialog(null, "V\u00e9rifier que tous les champs sont remplis!", "Impossible de cr\u00e9er un compte ", 0);
                }
                else {
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                final MonCompte frame = new MonCompte(utilisateur);
                                frame.setVisible(true);
                            }
                            catch (final Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        btnCreerCompte.setBounds(547, 665, 164, 37);
        this.contentPane.add(btnCreerCompte);
        final JLabel lblVersion = new JLabel("version 1.0");
        lblVersion.setBounds(1277, 710, 75, 21);
        this.contentPane.add(lblVersion);
    }
}
