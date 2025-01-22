// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import dao.PlatDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import dao.MenuDAO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import dao.CommandeDAO;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.EventQueue;
import dao.UtilisateurDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.Vector;
import models.Commande;
import dao.ServeuseDAO;
import enums.StatutCommande;
import javax.swing.table.DefaultTableModel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import models.Utilisateur;
import javax.swing.JTable;
import javax.swing.JPanel;
import models.Plat;
import models.Menu;
import javax.swing.JFrame;

public class HomeCuisinier extends JFrame
{
    int idSelectedMenu;
    int idSelectedPlat;
    Menu selectedMenu;
    Plat selectedPlat;
    private JPanel paneCrees;
    private JTable tableCommandesEnCours;
    private JTable tableCommandesDemandees;
    private JTable tableCommandesServies;
    private JTable tableMenus;
    private JTable tablePlats;
    
    public HomeCuisinier(final Utilisateur utilisateur) {
        this.idSelectedMenu = -1;
        this.idSelectedPlat = -1;
        final int id = utilisateur.getId();
        this.setDefaultCloseOperation(3);
        this.setTitle("Compte Cuisinier ");
        this.setBounds(100, 100, 1150, 700);
        (this.paneCrees = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.paneCrees);
        this.paneCrees.setLayout(null);
        final DefaultTableModel modelCommandeDemandee = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelCommandeDemandee.addColumn("Code");
        modelCommandeDemandee.addColumn("Total");
        modelCommandeDemandee.addColumn("Date");
        final List<Commande> commandesDemandees = ServeuseDAO.AfficherCommande(StatutCommande.CREATED);
        for (final Commande commande : commandesDemandees) {
            final Vector<Object> commandes = new Vector<Object>();
            commandes.add(commande.getId());
            commandes.add(commande.getTotal());
            commandes.add(commande.getDateCreation());
            modelCommandeDemandee.addRow(commandes);
        }
        final DefaultTableModel modelCommandeEnCours = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelCommandeEnCours.addColumn("Code");
        modelCommandeEnCours.addColumn("Total");
        modelCommandeEnCours.addColumn("Date");
        final List<Commande> commandesEnCours = ServeuseDAO.AfficherCommande(StatutCommande.INPROGRESS);
        for (final Commande commande2 : commandesEnCours) {
            final Vector<Object> commandes2 = new Vector<Object>();
            commandes2.add(commande2.getId());
            commandes2.add(commande2.getTotal());
            commandes2.add(commande2.getDateCreation());
            modelCommandeEnCours.addRow(commandes2);
        }
        final DefaultTableModel modelCommandeServie = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelCommandeServie.addColumn("Code");
        modelCommandeServie.addColumn("Total");
        modelCommandeServie.addColumn("Date");
        final List<Commande> commandesServies = ServeuseDAO.AfficherCommande(StatutCommande.COMPLETED);
        for (final Commande commande3 : commandesServies) {
            final Vector<Object> commandes3 = new Vector<Object>();
            commandes3.add(commande3.getId());
            commandes3.add(commande3.getTotal());
            commandes3.add(commande3.getDateCreation());
            modelCommandeServie.addRow(commandes3);
        }
        final JButton btnMonCompte = new JButton("Mon compte ");
        btnMonCompte.setBounds(950, 3, 150, 30);
        btnMonCompte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final MonCompte frame = new MonCompte(UtilisateurDAO.Profile(id));
                            frame.setVisible(true);
                        }
                        catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnMonCompte.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnMonCompte);
        final JTabbedPane tabbedPane = new JTabbedPane(1);
        tabbedPane.setBounds(0, 14, 1100, 600);
        final JPanel plCommandes = new JPanel();
        final JPanel plMenus = new JPanel();
        tabbedPane.add("Gestion des commandes", plCommandes);
        plCommandes.setLayout(null);
        final JLabel lblCommandesDemandees = new JLabel("Commandes demand\u00e9es\r\n");
        lblCommandesDemandees.setBounds(10, 14, 158, 16);
        plCommandes.add(lblCommandesDemandees);
        lblCommandesDemandees.setFont(new Font("Tahoma", 1, 13));
        final JLabel lblCommandesEnCours = new JLabel("Commandes en cours ");
        lblCommandesEnCours.setBounds(362, 14, 142, 16);
        plCommandes.add(lblCommandesEnCours);
        lblCommandesEnCours.setFont(new Font("Tahoma", 1, 13));
        final JLabel lblCommandesServi = new JLabel("Commandes servies");
        lblCommandesServi.setBounds(749, 14, 129, 16);
        plCommandes.add(lblCommandesServi);
        lblCommandesServi.setFont(new Font("Tahoma", 1, 13));
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 330, 466);
        plCommandes.add(scrollPane);
        scrollPane.setViewportView(this.tableCommandesDemandees = new JTable());
        this.tableCommandesDemandees.setModel(modelCommandeDemandee);
        final JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(362, 40, 338, 466);
        plCommandes.add(scrollPane_1);
        scrollPane_1.setViewportView(this.tableCommandesEnCours = new JTable());
        this.tableCommandesEnCours.setModel(modelCommandeEnCours);
        final JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(749, 40, 301, 466);
        plCommandes.add(scrollPane_2);
        scrollPane_2.setViewportView(this.tableCommandesServies = new JTable());
        this.tableCommandesServies.setModel(modelCommandeServie);
        final JButton btnPasserEnCours = new JButton("Passer en cours");
        btnPasserEnCours.setBounds(182, 516, 158, 41);
        plCommandes.add(btnPasserEnCours);
        btnPasserEnCours.setFont(new Font("Tahoma", 1, 12));
        final JButton btnPasserServie = new JButton("Passer servie");
        btnPasserServie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int index = HomeCuisinier.this.tableCommandesEnCours.getSelectedRow();
                final TableModel model = HomeCuisinier.this.tableCommandesEnCours.getModel();
                final int codeCommande = Integer.parseInt(model.getValueAt(index, 0).toString());
                final Commande commande = CommandeDAO.Get(codeCommande);
                commande.setStatut(StatutCommande.COMPLETED);
                final boolean updated = CommandeDAO.Update(commande);
                if (updated) {
                    modelCommandeEnCours.removeRow(HomeCuisinier.this.tableCommandesEnCours.getSelectedRow());
                    final Vector<Object> commandes = new Vector<Object>();
                    commandes.add(commande.getId());
                    commandes.add(commande.getTotal());
                    commandes.add(commande.getDateCreation());
                    modelCommandeServie.addRow(commandes);
                }
            }
        });
        btnPasserServie.setFont(new Font("Tahoma", 1, 12));
        btnPasserServie.setBounds(454, 516, 158, 41);
        plCommandes.add(btnPasserServie);
        final JButton btnEnvoyerNotification = new JButton("Envoyer notification");
        btnEnvoyerNotification.setFont(new Font("Tahoma", 1, 12));
        btnEnvoyerNotification.setBounds(827, 516, 158, 41);
        plCommandes.add(btnEnvoyerNotification);
        final JButton btnAnnuler_2 = new JButton("Annuler");
        btnAnnuler_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (HomeCuisinier.this.tableCommandesDemandees.getSelectedRow() != -1) {
                    final int index = HomeCuisinier.this.tableCommandesDemandees.getSelectedRow();
                    final int codeCommande = Integer.parseInt(modelCommandeDemandee.getValueAt(index, 0).toString());
                    final Commande commande = CommandeDAO.Get(codeCommande);
                    commande.setStatut(StatutCommande.CANCLED);
                    final boolean updated = CommandeDAO.Update(commande);
                    if (updated) {
                        modelCommandeDemandee.removeRow(HomeCuisinier.this.tableCommandesDemandees.getSelectedRow());
                        final boolean deleted = CommandeDAO.delete(commande.getId());
                        if (deleted) {
                            JOptionPane.showMessageDialog(null, "la commande a \u00e9t\u00e9 supprim\u00e9 ");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez selectionner une commande !");
                }
            }
        });
        btnAnnuler_2.setFont(new Font("Tahoma", 1, 12));
        btnAnnuler_2.setBounds(10, 516, 158, 41);
        plCommandes.add(btnAnnuler_2);
        btnPasserEnCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int index = HomeCuisinier.this.tableCommandesDemandees.getSelectedRow();
                final int codeCommande = Integer.parseInt(modelCommandeDemandee.getValueAt(index, 0).toString());
                final Commande commande = CommandeDAO.Get(codeCommande);
                commande.setStatut(StatutCommande.INPROGRESS);
                final boolean updated = CommandeDAO.Update(commande);
                if (updated) {
                    modelCommandeDemandee.removeRow(HomeCuisinier.this.tableCommandesDemandees.getSelectedRow());
                    final Vector<Object> commandes = new Vector<Object>();
                    commandes.add(commande.getId());
                    commandes.add(commande.getTotal());
                    commandes.add(commande.getDateCreation());
                    modelCommandeEnCours.addRow(commandes);
                }
            }
        });
        tabbedPane.add("Gestion des menus", plMenus);
        plMenus.setLayout(null);
        final JButton btnDeleteMenu = new JButton();
        btnDeleteMenu.setBounds(240, 520, 50, 50);
        btnDeleteMenu.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/deleteicon.png")));
        plMenus.add(btnDeleteMenu);
        final DefaultTableModel modelTableMenus = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelTableMenus.addColumn("id");
        modelTableMenus.addColumn("nom");
        final List<Menu> listMenu = MenuDAO.Get();
        for (final Menu menu : listMenu) {
            final Vector<Object> menus = new Vector<Object>();
            menus.add(menu.getId());
            menus.add(menu.getNom());
            modelTableMenus.addRow(menus);
        }
        final JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(10, 47, 308, 466);
        plMenus.add(scrollPane_3);
        scrollPane_3.setViewportView(this.tableMenus = new JTable());
        this.tableMenus.setModel(modelTableMenus);
        final DefaultTableModel modelTablePlats = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelTablePlats.addColumn("id");
        modelTablePlats.addColumn("nom");
        modelTablePlats.addColumn("prix");
        this.tableMenus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                final int index = HomeCuisinier.this.tableMenus.getSelectedRow();
                final TableModel model = HomeCuisinier.this.tableMenus.getModel();
                HomeCuisinier.this.idSelectedMenu = Integer.parseInt(model.getValueAt(index, 0).toString());
                HomeCuisinier.this.selectedMenu = MenuDAO.Get(HomeCuisinier.this.idSelectedMenu);
                modelTablePlats.setRowCount(0);
                final List<Plat> listPlat = PlatDAO.getByMenu(HomeCuisinier.this.idSelectedMenu);
                for (final Plat plat : listPlat) {
                    final Vector<Object> plats = new Vector<Object>();
                    plats.add(plat.getId());
                    plats.add(plat.getNom());
                    plats.add(plat.getPrix());
                    modelTablePlats.addRow(plats);
                }
            }
        });
        final JScrollPane scrollPane_3_1 = new JScrollPane();
        scrollPane_3_1.setBounds(396, 47, 308, 466);
        plMenus.add(scrollPane_3_1);
        scrollPane_3_1.setViewportView(this.tablePlats = new JTable());
        this.tablePlats.setModel(modelTablePlats);
        final JLabel lblMenus = new JLabel("Menus");
        lblMenus.setFont(new Font("Tahoma", 1, 13));
        lblMenus.setBounds(10, 26, 158, 16);
        plMenus.add(lblMenus);
        final JLabel lblPlats = new JLabel("Plats");
        lblPlats.setFont(new Font("Tahoma", 1, 13));
        lblPlats.setBounds(396, 26, 158, 16);
        plMenus.add(lblPlats);
        final JButton btnUpdate = new JButton();
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String name = JOptionPane.showInputDialog("Modifier menu ");
                HomeCuisinier.this.selectedMenu.setNom(name);
                Boolean existed = false;
                for (final Menu _menu : listMenu) {
                    if (_menu.getNom().equals(name) && _menu.getId() != HomeCuisinier.this.idSelectedMenu) {
                        existed = true;
                        break;
                    }
                }
                if (!existed) {
                    MenuDAO.Update(HomeCuisinier.this.selectedMenu);
                    modelTableMenus.setRowCount(0);
                    final List<Menu> list = MenuDAO.Get();
                    for (final Menu m : list) {
                        final Vector<Object> menus = new Vector<Object>();
                        menus.add(m.getId());
                        menus.add(m.getNom());
                        modelTableMenus.addRow(menus);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Un menu avec ce nom existe deja! Vous devez choisir un autre nom.");
                }
            }
        });
        btnUpdate.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/editicon.png")));
        btnUpdate.setBounds(127, 520, 50, 50);
        plMenus.add(btnUpdate);
        final JButton btnCreate = new JButton();
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String nameMenu = JOptionPane.showInputDialog("Nouveau menu");
                if (!nameMenu.isBlank() && !nameMenu.isEmpty()) {
                    final Menu menu = new Menu();
                    menu.setNom(nameMenu);
                    MenuDAO.create(menu);
                    modelTableMenus.setRowCount(0);
                    final List<Menu> list = MenuDAO.Get();
                    for (final Menu m : list) {
                        final Vector<Object> menus = new Vector<Object>();
                        menus.add(m.getId());
                        menus.add(m.getNom());
                        modelTableMenus.addRow(menus);
                    }
                }
            }
        });
        btnCreate.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/addicon.png")));
        btnCreate.setBounds(30, 520, 50, 50);
        plMenus.add(btnCreate);
        final JButton btnAjoutPlat = new JButton();
        btnAjoutPlat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final AjouterPlat frame = new AjouterPlat(HomeCuisinier.this.selectedMenu, modelTablePlats);
                            frame.setVisible(true);
                        }
                        catch (final Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnAjoutPlat.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/addicon.png")));
        btnAjoutPlat.setBounds(406, 520, 50, 50);
        plMenus.add(btnAjoutPlat);
        final JButton btnUpdatePlat = new JButton();
        btnUpdatePlat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (HomeCuisinier.this.tableMenus.getSelectedRow() == -1 || HomeCuisinier.this.tablePlats.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "selectionner le menu et le plat correspendant!");
                }
                else {
                    final int indexMenu = HomeCuisinier.this.tableMenus.getSelectedRow();
                    final int indexPlat = HomeCuisinier.this.tablePlats.getSelectedRow();
                    HomeCuisinier.this.idSelectedMenu = Integer.parseInt(modelTableMenus.getValueAt(indexMenu, 0).toString());
                    HomeCuisinier.this.idSelectedPlat = Integer.parseInt(modelTablePlats.getValueAt(indexPlat, 0).toString());
                    final List<Plat> plats = PlatDAO.getByMenu(HomeCuisinier.this.idSelectedMenu);
                    for (final Plat p : plats) {
                        if (p.getId() == HomeCuisinier.this.idSelectedPlat) {
                            EventQueue.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        final ModifierPlat frame = new ModifierPlat(p, modelTablePlats);
                                        frame.setVisible(true);
                                    }
                                    catch (final Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    }
                }
            }
        });
        btnUpdatePlat.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/editicon.png")));
        btnUpdatePlat.setBounds(526, 520, 50, 50);
        plMenus.add(btnUpdatePlat);
        final JButton btnDeletePlat = new JButton();
        btnDeletePlat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (HomeCuisinier.this.tablePlats.getSelectedRow() != -1) {
                    final int indexM = HomeCuisinier.this.tableMenus.getSelectedRow();
                    HomeCuisinier.this.idSelectedMenu = Integer.parseInt(modelTablePlats.getValueAt(indexM, 0).toString());
                    final int index = HomeCuisinier.this.tablePlats.getSelectedRow();
                    HomeCuisinier.this.idSelectedPlat = Integer.parseInt(modelTablePlats.getValueAt(index, 0).toString());
                    if (PlatDAO.delete(HomeCuisinier.this.idSelectedPlat)) {
                        modelTablePlats.removeRow(HomeCuisinier.this.tablePlats.getSelectedRow());
                        final List<Plat> plats = PlatDAO.getByMenu(HomeCuisinier.this.idSelectedMenu);
                        modelTablePlats.setRowCount(0);
                        for (final Plat p : plats) {
                            final Vector<Object> pl = new Vector<Object>();
                            pl.add(p.getId());
                            pl.add(p.getNom());
                            pl.add(p.getPrix());
                            modelTablePlats.addRow(pl);
                        }
                        JOptionPane.showMessageDialog(null, "Plat supprim\u00e9 avec succ\u00e8es");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "un erreur se produit ", "Erreur", 0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez s\u00e9l\u00e9ctionner un plat ! ", "Erreur", 0);
                }
            }
        });
        btnDeletePlat.setIcon(new ImageIcon(HomeCuisinier.class.getResource("/images/deleteicon.png")));
        btnDeletePlat.setBounds(647, 520, 50, 50);
        plMenus.add(btnDeletePlat);
        btnDeleteMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (HomeCuisinier.this.tableMenus.getSelectedRow() != -1) {
                    final int index = HomeCuisinier.this.tableMenus.getSelectedRow();
                    HomeCuisinier.this.idSelectedMenu = Integer.parseInt(modelTableMenus.getValueAt(index, 0).toString());
                    if (MenuDAO.Delete(HomeCuisinier.this.idSelectedMenu)) {
                        modelTableMenus.removeRow(HomeCuisinier.this.tableMenus.getSelectedRow());
                        final List<Plat> plats = PlatDAO.getByMenu(HomeCuisinier.this.idSelectedMenu);
                        for (final Plat plat : plats) {
                            PlatDAO.delete(plat.getId());
                        }
                        modelTablePlats.setRowCount(0);
                        for (final Plat p : plats) {
                            final Vector<Object> pl = new Vector<Object>();
                            pl.add(p.getId());
                            pl.add(p.getNom());
                            pl.add(p.getPrix());
                            modelTablePlats.addRow(pl);
                        }
                        JOptionPane.showMessageDialog(null, "Menu supprim\u00e9 avec succ\u00e8es");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "un erreur se produit ", "Erreur", 0);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Veuillez s\u00e9l\u00e9ctionner un menu ! ", "Erreur", 0);
                }
            }
        });
        this.paneCrees.add(tabbedPane);
    }
}
