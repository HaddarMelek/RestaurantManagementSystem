// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import dao.MenuDAO;
import models.MenuPlat;
import dao.PlatDAO;
import models.Plat;
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
import models.Menu;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class AjouterPlat extends JFrame
{
    private JPanel paneCrees;
    
    public AjouterPlat(final Menu menu, final DefaultTableModel modelTablePlat) {
        this.setUndecorated(true);
        this.setDefaultCloseOperation(2);
        this.getRootPane().setWindowDecorationStyle(2);
        this.setTitle("Ajouter...");
        this.setBounds(14, 14, 500, 500);
        this.setVisible(true);
        this.setSize(1014, 631);
        (this.paneCrees = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.paneCrees);
        this.paneCrees.setLayout(null);
        final JLabel lblAjouterPlat = new JLabel("Ajouter un plat...");
        lblAjouterPlat.setBounds(404, 70, 312, 67);
        lblAjouterPlat.setForeground(new Color(128, 0, 0));
        lblAjouterPlat.setFont(new Font("Tahoma", 1, 36));
        this.paneCrees.add(lblAjouterPlat);
        final JLabel lblNomPlat = new JLabel("Nom plat: \r\n");
        lblNomPlat.setBounds(157, 153, 244, 61);
        lblNomPlat.setFont(new Font("Tahoma", 1, 16));
        this.paneCrees.add(lblNomPlat);
        final JLabel lblPrixPlat = new JLabel("Prix plat:");
        lblPrixPlat.setBounds(157, 231, 244, 61);
        lblPrixPlat.setFont(new Font("Tahoma", 1, 16));
        this.paneCrees.add(lblPrixPlat);
        final JLabel lblNotes = new JLabel("Notes: ");
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
                AjouterPlat.this.dispose();
            }
        });
        btnAnnuler.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnAnnuler);
        final JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setBounds(554, 395, 164, 37);
        btnAjouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String name = txtNomPlat.getText();
                double prix = 0.0;
                try {
                    prix = Double.parseDouble(txtPrixPlat.getText());
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
                final String notes = txtNotesPlat.getText();
                if (!name.isBlank() && !name.isEmpty() && prix != 0.0) {
                    final Plat plat = new Plat();
                    plat.setNom(name);
                    plat.setPrix(prix);
                    plat.setNotes(notes);
                    final int idPlat = PlatDAO.create(plat);
                    final List<MenuPlat> listPlat = menu.getPlats();
                    listPlat.add(new MenuPlat(menu.getId(), idPlat));
                    MenuDAO.Update(menu);
                    modelTablePlat.setRowCount(0);
                    final List<Plat> list = PlatDAO.getByMenu(menu.getId());
                    for (final Plat p : list) {
                        final Vector<Object> plats = new Vector<Object>();
                        plats.add(p.getNom());
                        plats.add(p.getPrix());
                        modelTablePlat.addRow(plats);
                    }
                    AjouterPlat.this.dispose();
                }
            }
        });
        btnAjouter.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnAjouter);
    }
}
