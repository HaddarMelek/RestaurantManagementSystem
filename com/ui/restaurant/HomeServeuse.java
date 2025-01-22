// 
// Decompiled by Procyon v0.6.0
// 

package com.ui.restaurant;

import javax.swing.JOptionPane;
import models.MenuPlat;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.List;
import models.Plat;
import dao.PlatDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import models.Menu;
import dao.MenuDAO;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
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
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import models.Utilisateur;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class HomeServeuse extends JFrame
{
    private JPanel paneCrees;
    private int idSelectedMenu;
    private double total;
    private static final DecimalFormat df;
    
    static {
        df = new DecimalFormat("0.00");
    }
    
    public HomeServeuse(final Utilisateur utilisateur) {
        this.total = 0.0;
        final int id = utilisateur.getId();
        this.setDefaultCloseOperation(3);
        this.setTitle("Compte Serveuse  ");
        this.setBounds(100, 100, 1150, 700);
        (this.paneCrees = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.paneCrees);
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
        for (final Commande commande : commandesEnCours) {
            final Vector<Object> commandes = new Vector<Object>();
            commandes.add(commande.getId());
            commandes.add(commande.getTotal());
            commandes.add(commande.getDateCreation());
            modelCommandeEnCours.addRow(commandes);
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
        for (final Commande commande2 : commandesServies) {
            final Vector<Object> commandes2 = new Vector<Object>();
            commandes2.add(commande2.getId());
            commandes2.add(commande2.getTotal());
            commandes2.add(commande2.getDateCreation());
            modelCommandeServie.addRow(commandes2);
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
        this.paneCrees.setLayout(null);
        btnMonCompte.setFont(new Font("Tahoma", 1, 12));
        this.paneCrees.add(btnMonCompte);
        final JTabbedPane tabbedPane = new JTabbedPane(1);
        tabbedPane.setBounds(0, 14, 1100, 600);
        final JPanel plCommandes = new JPanel();
        final JPanel plMenus = new JPanel();
        final JPanel plMesComandes = new JPanel();
        tabbedPane.add("Commandes", plCommandes);
        plCommandes.setLayout(null);
        final JLabel lblCommandesEnCours = new JLabel("Commandes en cours ");
        lblCommandesEnCours.setBounds(81, 14, 142, 16);
        plCommandes.add(lblCommandesEnCours);
        lblCommandesEnCours.setFont(new Font("Tahoma", 1, 13));
        final JLabel lblCommandesServi = new JLabel("Commandes servies");
        lblCommandesServi.setBounds(597, 14, 129, 16);
        plCommandes.add(lblCommandesServi);
        lblCommandesServi.setFont(new Font("Tahoma", 1, 13));
        final JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(91, 40, 338, 466);
        plCommandes.add(scrollPane_1);
        final JTable tableCommandesEnCours = new JTable();
        scrollPane_1.setViewportView(tableCommandesEnCours);
        tableCommandesEnCours.setModel(modelCommandeEnCours);
        final JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(596, 40, 301, 466);
        plCommandes.add(scrollPane_2);
        final JTable tableCommandesServies = new JTable();
        scrollPane_2.setViewportView(tableCommandesServies);
        tableCommandesServies.setModel(modelCommandeServie);
        tabbedPane.add("Menu", plMenus);
        plMenus.setLayout(null);
        tabbedPane.add("Mes Commandes", plMesComandes);
        plMesComandes.setLayout(null);
        final JLabel lblMesCommandes = new JLabel("Mes commandes ");
        lblMesCommandes.setBounds(81, 14, 142, 16);
        plMesComandes.add(lblMesCommandes);
        lblMesCommandes.setFont(new Font("Tahoma", 1, 13));
        final DefaultTableModel modelCommande = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelCommande.addColumn("Code");
        modelCommande.addColumn("Total");
        modelCommande.addColumn("Date");
        modelCommande.addColumn("Statut");
        final List<Commande> mesCommandes = UtilisateurDAO.AfficherCommande(utilisateur.getId());
        for (final Commande commande3 : mesCommandes) {
            final Vector<Object> commandes3 = new Vector<Object>();
            commandes3.add(commande3.getId());
            commandes3.add(commande3.getTotal());
            commandes3.add(commande3.getDateCreation());
            commandes3.add((commande3.getStatut() == StatutCommande.INPROGRESS) ? "En cours" : ((commande3.getStatut() == StatutCommande.COMPLETED) ? "Servie" : "En attente"));
            modelCommande.addRow(commandes3);
        }
        final JScrollPane sp = new JScrollPane();
        sp.setBounds(91, 40, 375, 466);
        plMesComandes.add(sp);
        final JTable tableMesCommandes = new JTable();
        sp.setViewportView(tableMesCommandes);
        tableMesCommandes.setModel(modelCommande);
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
        final JTable tableMenus = new JTable();
        scrollPane_3.setViewportView(tableMenus);
        tableMenus.setModel(modelTableMenus);
        final DefaultTableModel modelTablePlats = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelTablePlats.addColumn("id");
        modelTablePlats.addColumn("nom");
        modelTablePlats.addColumn("prix");
        tableMenus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                final int index = tableMenus.getSelectedRow();
                final TableModel model = tableMenus.getModel();
                MenuDAO.Get(HomeServeuse.this.idSelectedMenu = Integer.parseInt(model.getValueAt(index, 0).toString()));
                modelTablePlats.setRowCount(0);
                final List<Plat> listPlat = PlatDAO.getByMenu(HomeServeuse.this.idSelectedMenu);
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
        final JTable tablePlats = new JTable();
        scrollPane_3_1.setViewportView(tablePlats);
        tablePlats.setModel(modelTablePlats);
        final JLabel lblMenus = new JLabel("Menus");
        lblMenus.setFont(new Font("Tahoma", 1, 13));
        lblMenus.setBounds(10, 26, 158, 16);
        plMenus.add(lblMenus);
        final JLabel lblPlats = new JLabel("Plats");
        lblPlats.setFont(new Font("Tahoma", 1, 13));
        lblPlats.setBounds(396, 26, 158, 16);
        plMenus.add(lblPlats);
        this.paneCrees.add(tabbedPane);
        final DefaultTableModel modelTablePanier = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(final int row, final int column) {
                return false;
            }
        };
        modelTablePanier.addColumn("id");
        modelTablePanier.addColumn("nom");
        modelTablePanier.addColumn("quantit\u00e9");
        modelTablePanier.addColumn("prix total");
        final JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(763, 47, 308, 391);
        plMenus.add(scrollPane_4);
        final JTable tablePanier = new JTable();
        scrollPane_4.setViewportView(tablePanier);
        tablePanier.setModel(modelTablePanier);
        final JButton btnPasserCommande = new JButton("Commander ");
        btnPasserCommande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        com/ui/restaurant/HomeServeuse$9.val$tablePanier:Ljavax/swing/JTable;
                //     4: invokevirtual   javax/swing/JTable.getRowCount:()I
                //     7: ifne            22
                //    10: aconst_null    
                //    11: ldc             "La commande n'a pas \u00e9t\u00e9 cr\u00e9e!"
                //    13: ldc             "Erreur"
                //    15: iconst_0       
                //    16: invokestatic    javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
                //    19: goto            338
                //    22: new             Lmodels/Commande;
                //    25: dup            
                //    26: iconst_0       
                //    27: aload_0         /* this */
                //    28: getfield        com/ui/restaurant/HomeServeuse$9.val$utilisateur:Lmodels/Utilisateur;
                //    31: invokevirtual   models/Utilisateur.getId:()I
                //    34: getstatic       enums/StatutCommande.CREATED:Lenums/StatutCommande;
                //    37: aload_0         /* this */
                //    38: getfield        com/ui/restaurant/HomeServeuse$9.this$0:Lcom/ui/restaurant/HomeServeuse;
                //    41: getfield        com/ui/restaurant/HomeServeuse.total:D
                //    44: new             Ljava/util/Date;
                //    47: dup            
                //    48: invokespecial   java/util/Date.<init>:()V
                //    51: ldc             ""
                //    53: invokespecial   models/Commande.<init>:(IILenums/StatutCommande;DLjava/util/Date;Ljava/lang/String;)V
                //    56: astore_2        /* newCommande */
                //    57: new             Ljava/util/ArrayList;
                //    60: dup            
                //    61: invokespecial   java/util/ArrayList.<init>:()V
                //    64: astore_3        /* listPlat */
                //    65: aload_0         /* this */
                //    66: getfield        com/ui/restaurant/HomeServeuse$9.val$modelTablePanier:Ljavax/swing/table/DefaultTableModel;
                //    69: invokevirtual   javax/swing/table/DefaultTableModel.getDataVector:()Ljava/util/Vector;
                //    72: invokevirtual   java/util/Vector.iterator:()Ljava/util/Iterator;
                //    75: astore          5
                //    77: goto            133
                //    80: aload           5
                //    82: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                //    87: checkcast       Ljava/util/Vector;
                //    90: astore          vector
                //    92: new             Lmodels/CommandePlat;
                //    95: dup            
                //    96: iconst_0       
                //    97: aload           vector
                //    99: iconst_0       
                //   100: invokevirtual   java/util/Vector.get:(I)Ljava/lang/Object;
                //   103: checkcast       Ljava/lang/Integer;
                //   106: invokevirtual   java/lang/Integer.intValue:()I
                //   109: aload           vector
                //   111: iconst_2       
                //   112: invokevirtual   java/util/Vector.get:(I)Ljava/lang/Object;
                //   115: checkcast       Ljava/lang/Integer;
                //   118: invokevirtual   java/lang/Integer.intValue:()I
                //   121: invokespecial   models/CommandePlat.<init>:(III)V
                //   124: astore          cmd
                //   126: aload_3         /* listPlat */
                //   127: aload           cmd
                //   129: invokevirtual   java/util/ArrayList.add:(Ljava/lang/Object;)Z
                //   132: pop            
                //   133: aload           5
                //   135: invokeinterface java/util/Iterator.hasNext:()Z
                //   140: ifne            80
                //   143: aload_2         /* newCommande */
                //   144: aload_3         /* listPlat */
                //   145: invokevirtual   models/Commande.setPlats:(Ljava/util/List;)V
                //   148: aload_2         /* newCommande */
                //   149: invokestatic    dao/CommandeDAO.Create:(Lmodels/Commande;)I
                //   152: istore          idCommande
                //   154: iload           idCommande
                //   156: iconst_m1      
                //   157: if_icmpne       172
                //   160: aconst_null    
                //   161: ldc             "La commande n'a pas \u00e9t\u00e9 cr\u00e9e!"
                //   163: ldc             "Erreur"
                //   165: iconst_0       
                //   166: invokestatic    javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
                //   169: goto            338
                //   172: aload_0         /* this */
                //   173: getfield        com/ui/restaurant/HomeServeuse$9.val$modelCommande:Ljavax/swing/table/DefaultTableModel;
                //   176: iconst_0       
                //   177: invokevirtual   javax/swing/table/DefaultTableModel.setRowCount:(I)V
                //   180: aload_0         /* this */
                //   181: getfield        com/ui/restaurant/HomeServeuse$9.val$utilisateur:Lmodels/Utilisateur;
                //   184: invokevirtual   models/Utilisateur.getId:()I
                //   187: invokestatic    dao/UtilisateurDAO.AfficherCommande:(I)Ljava/util/List;
                //   190: astore          mesCommandes
                //   192: aload           mesCommandes
                //   194: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
                //   199: astore          7
                //   201: goto            313
                //   204: aload           7
                //   206: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                //   211: checkcast       Lmodels/Commande;
                //   214: astore          commande
                //   216: new             Ljava/util/Vector;
                //   219: dup            
                //   220: invokespecial   java/util/Vector.<init>:()V
                //   223: astore          commandes
                //   225: aload           commandes
                //   227: aload           commande
                //   229: invokevirtual   models/Commande.getId:()I
                //   232: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   235: invokevirtual   java/util/Vector.add:(Ljava/lang/Object;)Z
                //   238: pop            
                //   239: aload           commandes
                //   241: aload           commande
                //   243: invokevirtual   models/Commande.getTotal:()D
                //   246: invokestatic    java/lang/Double.valueOf:(D)Ljava/lang/Double;
                //   249: invokevirtual   java/util/Vector.add:(Ljava/lang/Object;)Z
                //   252: pop            
                //   253: aload           commandes
                //   255: aload           commande
                //   257: invokevirtual   models/Commande.getDateCreation:()Ljava/util/Date;
                //   260: invokevirtual   java/util/Vector.add:(Ljava/lang/Object;)Z
                //   263: pop            
                //   264: aload           commandes
                //   266: aload           commande
                //   268: invokevirtual   models/Commande.getStatut:()Lenums/StatutCommande;
                //   271: getstatic       enums/StatutCommande.INPROGRESS:Lenums/StatutCommande;
                //   274: if_acmpne       282
                //   277: ldc             "En cours"
                //   279: goto            300
                //   282: aload           commande
                //   284: invokevirtual   models/Commande.getStatut:()Lenums/StatutCommande;
                //   287: getstatic       enums/StatutCommande.COMPLETED:Lenums/StatutCommande;
                //   290: if_acmpne       298
                //   293: ldc             "Servie"
                //   295: goto            300
                //   298: ldc             "En attente"
                //   300: invokevirtual   java/util/Vector.add:(Ljava/lang/Object;)Z
                //   303: pop            
                //   304: aload_0         /* this */
                //   305: getfield        com/ui/restaurant/HomeServeuse$9.val$modelCommande:Ljavax/swing/table/DefaultTableModel;
                //   308: aload           commandes
                //   310: invokevirtual   javax/swing/table/DefaultTableModel.addRow:(Ljava/util/Vector;)V
                //   313: aload           7
                //   315: invokeinterface java/util/Iterator.hasNext:()Z
                //   320: ifne            204
                //   323: aload_0         /* this */
                //   324: getfield        com/ui/restaurant/HomeServeuse$9.this$0:Lcom/ui/restaurant/HomeServeuse;
                //   327: getfield        com/ui/restaurant/HomeServeuse.paneCrees:Ljavax/swing/JPanel;
                //   330: ldc             "Commande cr\u00e9e"
                //   332: ldc             "Info"
                //   334: iconst_1       
                //   335: invokestatic    javax/swing/JOptionPane.showMessageDialog:(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
                //   338: return         
                //    StackMapTable: 00 0A 16 FF 00 39 00 06 07 00 01 07 00 D8 07 00 36 07 00 51 00 07 00 61 00 00 34 FF 00 26 00 05 07 00 01 07 00 D8 07 00 36 07 00 51 01 00 00 FF 00 1F 00 08 07 00 01 07 00 D8 07 00 36 07 00 51 01 07 00 91 00 07 00 61 00 00 FF 00 4D 00 09 07 00 01 07 00 D8 07 00 36 07 00 51 01 07 00 91 07 00 36 07 00 61 07 00 5B 00 01 07 00 5B 4F 07 00 5B FF 00 01 00 09 07 00 01 07 00 D8 07 00 36 07 00 51 01 07 00 91 07 00 36 07 00 61 07 00 5B 00 02 07 00 5B 07 00 DA FF 00 0C 00 08 07 00 01 07 00 D8 07 00 36 07 00 51 01 07 00 91 00 07 00 61 00 00 FF 00 18 00 02 07 00 01 07 00 D8 00 00
                // 
                // The error that occurred was:
                // 
                // java.lang.UnsupportedOperationException: The requested operation is not supported.
                //     at com.strobel.util.ContractUtils.unsupported(ContractUtils.java:27)
                //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:284)
                //     at com.strobel.assembler.metadata.TypeReference.getRawType(TypeReference.java:279)
                //     at com.strobel.assembler.metadata.TypeReference.makeGenericType(TypeReference.java:154)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:225)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                //     at com.strobel.assembler.metadata.CoreMetadataFactory$UnresolvedGenericType.accept(CoreMetadataFactory.java:653)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:211)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:211)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitParameterizedType(TypeSubstitutionVisitor.java:25)
                //     at com.strobel.assembler.metadata.ParameterizedType.accept(ParameterizedType.java:103)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visit(TypeSubstitutionVisitor.java:40)
                //     at com.strobel.assembler.metadata.TypeSubstitutionVisitor.visitMethod(TypeSubstitutionVisitor.java:314)
                //     at com.strobel.decompiler.ast.TypeAnalysis.inferCall(TypeAnalysis.java:2611)
                //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:1040)
                //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
                //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:782)
                //     at com.strobel.decompiler.ast.TypeAnalysis.doInferTypeForExpression(TypeAnalysis.java:892)
                //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypeForExpression(TypeAnalysis.java:815)
                //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:684)
                //     at com.strobel.decompiler.ast.TypeAnalysis.inferTypesForVariables(TypeAnalysis.java:593)
                //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:405)
                //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:95)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:109)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1151)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:993)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:548)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:534)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:377)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:318)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:213)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:799)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:635)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
                //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
                //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
                //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:147)
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        });
        btnPasserCommande.setFont(new Font("Tahoma", 1, 13));
        btnPasserCommande.setBounds(934, 508, 127, 55);
        plMenus.add(btnPasserCommande);
        final JLabel lblTotalValue = new JLabel("0,00");
        final JButton btnAjouterAuPanier = new JButton("Ajouter Menus et/ou Plats au panier");
        btnAjouterAuPanier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (tableMenus.getSelectedRow() != -1 && tablePlats.getSelectedRow() != -1) {
                    final int indexPlat = tablePlats.getSelectedRow();
                    final int idPlat = Integer.parseInt(modelTablePlats.getValueAt(indexPlat, 0).toString());
                    final Plat plat = PlatDAO.get(idPlat);
                    final Vector<Object> ajoutPanier = new Vector<Object>();
                    ajoutPanier.add(plat.getId());
                    ajoutPanier.add(plat.getNom());
                    ajoutPanier.add(1);
                    ajoutPanier.add(plat.getPrix());
                    final HomeServeuse this$0 = HomeServeuse.this;
                    this$0.total += plat.getPrix();
                    modelTablePanier.addRow(ajoutPanier);
                }
                else if (tableMenus.getSelectedRow() != -1 && tablePlats.getSelectedRow() == -1) {
                    final int index = tableMenus.getSelectedRow();
                    final int idMenu = Integer.parseInt(modelTableMenus.getValueAt(index, 0).toString());
                    final Menu menu = MenuDAO.Get(idMenu);
                    final List<MenuPlat> menuPlats = menu.getPlats();
                    for (final MenuPlat menuPlat : menuPlats) {
                        final int idPlat2 = menuPlat.getIdPlat();
                        final Plat plat2 = PlatDAO.get(idPlat2);
                        final Vector<Object> ajoutPanier2 = new Vector<Object>();
                        ajoutPanier2.add(plat2.getId());
                        ajoutPanier2.add(plat2.getNom());
                        ajoutPanier2.add(1);
                        ajoutPanier2.add(plat2.getPrix());
                        modelTablePanier.addRow(ajoutPanier2);
                        final HomeServeuse this$2 = HomeServeuse.this;
                        this$2.total += plat2.getPrix();
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Selectionnez un menu ou un plat", "Erreur", 0);
                }
                lblTotalValue.setText(HomeServeuse.df.format(HomeServeuse.this.total));
            }
        });
        btnAjouterAuPanier.setFont(new Font("Tahoma", 1, 13));
        btnAjouterAuPanier.setBounds(99, 523, 472, 40);
        plMenus.add(btnAjouterAuPanier);
        final JLabel lblPanier = new JLabel("Panier");
        lblPanier.setFont(new Font("Tahoma", 1, 13));
        lblPanier.setBounds(765, 26, 158, 16);
        plMenus.add(lblPanier);
        final JLabel lblTotal = new JLabel("Total");
        lblTotal.setFont(new Font("Tahoma", 1, 13));
        lblTotal.setBounds(763, 461, 80, 16);
        plMenus.add(lblTotal);
        lblTotalValue.setHorizontalAlignment(4);
        lblTotalValue.setHorizontalTextPosition(4);
        lblTotalValue.setFont(new Font("Tahoma", 1, 13));
        lblTotalValue.setBounds(892, 464, 179, 16);
        plMenus.add(lblTotalValue);
        final JButton btnVider = new JButton("Vider Panier");
        btnVider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                modelTablePanier.setRowCount(0);
                lblTotalValue.setText(HomeServeuse.df.format(0.0));
            }
        });
        btnVider.setFont(new Font("Tahoma", 1, 13));
        btnVider.setBounds(763, 508, 127, 55);
        plMenus.add(btnVider);
    }
}
