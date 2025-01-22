// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

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
import models.Utilisateur;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class MonCompte extends JFrame
{
    private JPanel contentPane;
    
    public MonCompte(final Utilisateur utilisateur) {
        this.setDefaultCloseOperation(3);
        this.setTitle("Mon Compte ");
        this.setBounds(100, 100, 450, 300);
        this.setSize(1014, 631);
        (this.contentPane = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(null);
        final JLabel lblId = new JLabel(new StringBuilder().append(utilisateur.getId()).toString());
        lblId.setForeground(new Color(20, 12, 186));
        lblId.setBackground(new Color(192, 192, 192));
        lblId.setFont(new Font("Comic Sans MS", 3, 19));
        lblId.setBounds(299, 156, 292, 27);
        this.contentPane.add(lblId);
        final JLabel lblNomComplet = new JLabel(utilisateur.getNomComplet());
        lblNomComplet.setForeground(new Color(20, 12, 186));
        lblNomComplet.setBackground(new Color(192, 192, 192));
        lblNomComplet.setFont(new Font("Comic Sans MS", 3, 19));
        lblNomComplet.setBounds(299, 195, 292, 27);
        this.contentPane.add(lblNomComplet);
        final JLabel lblMotDePasse = new JLabel(utilisateur.getMotDePasse());
        lblMotDePasse.setForeground(new Color(20, 12, 186));
        lblMotDePasse.setBackground(new Color(192, 192, 192));
        lblMotDePasse.setFont(new Font("Comic Sans MS", 3, 19));
        lblMotDePasse.setBounds(299, 237, 292, 27);
        this.contentPane.add(lblMotDePasse);
        final JLabel lblUsername = new JLabel(utilisateur.getUsername());
        lblUsername.setForeground(new Color(20, 12, 186));
        lblUsername.setBackground(new Color(192, 192, 192));
        lblUsername.setFont(new Font("Comic Sans MS", 3, 19));
        lblUsername.setBounds(299, 285, 292, 27);
        this.contentPane.add(lblUsername);
        final JLabel lblTel = new JLabel(utilisateur.getTel());
        lblTel.setForeground(new Color(20, 12, 186));
        lblTel.setBackground(new Color(192, 192, 192));
        lblTel.setFont(new Font("Comic Sans MS", 3, 19));
        lblTel.setBounds(299, 339, 292, 27);
        this.contentPane.add(lblTel);
        final JLabel lblAdresse = new JLabel(utilisateur.getAdresse());
        lblAdresse.setForeground(new Color(20, 12, 186));
        lblAdresse.setBackground(new Color(192, 192, 192));
        lblAdresse.setFont(new Font("Comic Sans MS", 3, 19));
        lblAdresse.setBounds(299, 396, 292, 27);
        this.contentPane.add(lblAdresse);
        final JLabel lblType = new JLabel(new StringBuilder().append(utilisateur.getType()).toString());
        lblType.setForeground(new Color(20, 12, 186));
        lblType.setBackground(new Color(192, 192, 192));
        lblType.setFont(new Font("Comic Sans MS", 3, 19));
        lblType.setBounds(299, 445, 292, 27);
        this.contentPane.add(lblType);
        final JLabel lblBienvenue = new JLabel("Vos Coordon\u00e9es");
        lblBienvenue.setForeground(new Color(16, 182, 37));
        lblBienvenue.setFont(new Font("Tahoma", 1, 31));
        lblBienvenue.setBounds(239, 21, 265, 72);
        this.contentPane.add(lblBienvenue);
        final JButton btnFermer = new JButton("Fermer");
        btnFermer.setFont(new Font("Tahoma", 1, 12));
        btnFermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        btnFermer.setBounds(666, 484, 115, 27);
        this.contentPane.add(btnFermer);
        final JLabel lblAffId = new JLabel("vote Id : ");
        lblAffId.setFont(new Font("Tahoma", 1, 14));
        lblAffId.setBounds(53, 156, 213, 27);
        this.contentPane.add(lblAffId);
        final JLabel lblAffNomComplet = new JLabel("votre nom complet : ");
        lblAffNomComplet.setFont(new Font("Tahoma", 1, 14));
        lblAffNomComplet.setBounds(53, 195, 213, 27);
        this.contentPane.add(lblAffNomComplet);
        final JLabel lblAffMotDePasse = new JLabel("votre mot de passe :");
        lblAffMotDePasse.setFont(new Font("Tahoma", 1, 14));
        lblAffMotDePasse.setBounds(53, 237, 213, 27);
        this.contentPane.add(lblAffMotDePasse);
        final JLabel lblAffUsername = new JLabel("votre nom d'utilisateur : ");
        lblAffUsername.setFont(new Font("Tahoma", 1, 14));
        lblAffUsername.setBounds(53, 285, 213, 27);
        this.contentPane.add(lblAffUsername);
        final JLabel lblAffTel = new JLabel("votre numero de t\u00e9l\u00e9phone : ");
        lblAffTel.setFont(new Font("Tahoma", 1, 14));
        lblAffTel.setBounds(53, 339, 213, 27);
        this.contentPane.add(lblAffTel);
        final JLabel lblAffAdresse = new JLabel("votre adresse : ");
        lblAffAdresse.setFont(new Font("Tahoma", 1, 14));
        lblAffAdresse.setBounds(53, 396, 213, 27);
        this.contentPane.add(lblAffAdresse);
        final JLabel lblAffType = new JLabel("votre type :");
        lblAffType.setFont(new Font("Tahoma", 1, 14));
        lblAffType.setBounds(53, 445, 213, 23);
        this.contentPane.add(lblAffType);
    }
}
