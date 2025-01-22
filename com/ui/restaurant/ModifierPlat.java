// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import dao.PlatDAO;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import models.Plat;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ModifierPlat extends JFrame
{
    private JPanel paneCrees;
    
    public ModifierPlat(final Plat selectedPlat, final DefaultTableModel modelTablePlat) {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(2);
        this.getRootPane().setWindowDecorationStyle(2);
        this.setTitle("Modifier...");
        this.setBounds(14, 14, 500, 500);
        this.setVisible(true);
        this.setSize(1014, 631);
        (this.paneCrees = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.paneCrees);
        this.paneCrees.setLayout(null);
        final JLabel lblModifierPlat = new JLabel("Modifier un plat...");
        lblModifierPlat.setBounds(404, 70, 312, 67);
        lblModifierPlat.setForeground(new Color(128, 0, 0));
        lblModifierPlat.setFont(new Font("Tahoma", 1, 36));
        this.paneCrees.add(lblModifierPlat);
        final JLabel lblNomPlat = new JLabel("Modifier nom : \r\n");
        lblNomPlat.setBounds(157, 153, 244, 61);
        lblNomPlat.setFont(new Font("Tahoma", 1, 16));
        this.paneCrees.add(lblNomPlat);
        final JLabel lblPrixPlat = new JLabel("Modifier prix:");
        lblPrixPlat.setBounds(157, 231, 244, 61);
        lblPrixPlat.setFont(new Font("Tahoma", 1, 16));
        this.paneCrees.add(lblPrixPlat);
        final JLabel lblNotes = new JLabel("Modifier notes: ");
        lblNotes.setBounds(157, 309, 244, 61);
        lblNotes.setFont(new Font("Tahoma", 1, 16));
        this.paneCrees.add(lblNotes);
        final JTextField txtNomPlat = new JTextField();
        txtNomPlat.setBounds(364, 153, 347, 43);
        txtNomPlat.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(txtNomPlat);
        txtNomPlat.setColumns(10);
        final JTextField txtPrixPlat = new JTextField();
        txtPrixPlat.setBounds(364, 241, 347, 43);
        txtPrixPlat.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(txtPrixPlat);
        txtPrixPlat.setColumns(10);
        final JTextField txtNotesPlat = new JTextField();
        txtNotesPlat.setBounds(369, 319, 347, 43);
        txtNotesPlat.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(txtNotesPlat);
        txtNotesPlat.setColumns(10);
        final JButton btnAnnuler = new JButton("Annuler");
        btnAnnuler.setBounds(380, 395, 164, 37);
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                ModifierPlat.this.dispose();
            }
        });
        btnAnnuler.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnAnnuler);
        final JButton btnModifier = new JButton("Modifier");
        btnModifier.setBounds(554, 395, 164, 37);
        btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                boolean updated = false;
                final String name = txtNomPlat.getText();
                double prix = 0.0;
                final String notes = txtNotesPlat.getText();
                try {
                    if (txtPrixPlat.getText().isEmpty() || txtPrixPlat.getText().isBlank()) {
                        prix = 0.0;
                    }
                    else {
                        prix = Double.parseDouble(txtPrixPlat.getText());
                    }
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
                if (!name.isBlank() && !name.isEmpty()) {
                    selectedPlat.setNom(name);
                }
                if (!txtPrixPlat.getText().isBlank() && txtPrixPlat.getText().isEmpty() && prix != 0.0) {
                    selectedPlat.setPrix(prix);
                }
                if (!notes.isBlank() && !notes.isEmpty()) {
                    selectedPlat.setNotes(notes);
                }
                if (name.isEmpty() && prix == 0.0 && notes.isEmpty()) {
                    updated = false;
                    JOptionPane.showMessageDialog(null, "veuillez remplir au moins un champs !");
                }
                else if (name.equals(selectedPlat.getNom()) && prix == selectedPlat.getPrix() && selectedPlat.getNotes().equals(notes)) {
                    updated = false;
                    JOptionPane.showMessageDialog(null, "plat existe d\u00e9j\u00e0 !");
                }
                else {
                    updated = PlatDAO.Update(selectedPlat);
                    modelTablePlat.setRowCount(0);
                    final List<Plat> listPlats = PlatDAO.getByMenu(selectedPlat.getId());
                    for (final Plat p : listPlats) {
                        final Vector<Object> plats = new Vector<Object>();
                        plats.add(p.getNom());
                        plats.add(p.getPrix());
                        modelTablePlat.addRow(plats);
                    }
                    JOptionPane.showMessageDialog(null, "plat modifi\u00e9 !");
                }
            }
        });
        btnModifier.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnModifier);
    }
}
