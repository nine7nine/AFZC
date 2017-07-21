/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.UserInterface;

import flashablezipcreator.DiskOperations.Read;
import flashablezipcreator.DiskOperations.Write;
import flashablezipcreator.Protocols.PreferenceProperties;
import flashablezipcreator.Protocols.Project;
import flashablezipcreator.Protocols.Xml;
import static flashablezipcreator.UserInterface.Preference.pp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author Nikhil
 */
public class Preference extends javax.swing.JFrame {

    /**
     * Creates new form PreferenceUI
     */
    public JDialog dialog;
    public static PreferenceProperties pp = new PreferenceProperties();
    Write w;
    Read r;

    public Preference() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        w = new Write();
        r = new Read();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
        dialog = new JDialog(this, "Preferences", true);
        dialog.setResizable(false);
        mainPanel = new javax.swing.JPanel();
        lblAromaOptions = new javax.swing.JLabel();
        lblZipOptions = new javax.swing.JLabel();
        btnAromaZip = new javax.swing.JToggleButton();
        btnNormalZip = new javax.swing.JToggleButton();
        btnQuickSetup = new javax.swing.JToggleButton();
        btnSaveTools = new javax.swing.JToggleButton();
        btnCheckUpdates = new javax.swing.JToggleButton();
        lblToolOptions = new javax.swing.JLabel();
        lblAddonDOptions = new javax.swing.JLabel();
        btnEnableAddon = new javax.swing.JToggleButton();
        btnDisplayAddon = new javax.swing.JToggleButton();
        btnSave = new javax.swing.JButton();
        panelAromaBinary = new javax.swing.JPanel();
        btnMelati = new javax.swing.JButton();
        btnFlamboyan = new javax.swing.JButton();
        btnEdelweis = new javax.swing.JButton();

        File f = new File("Preferences.config");
        if (f.exists()) {
            pp.preferencesFilePresent = true;
            pp.preferencesConfig = r.getFileString("Preferences.config");
        }

        pp.themes = new ArrayList<>();
        pp.themes.add("Nikhil");
        pp.themes.add("Ics");
        pp.themes.add("RedBlack");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(23, 107, 144));

        lblAromaOptions.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAromaOptions.setForeground(new java.awt.Color(255, 255, 255));
        lblAromaOptions.setText("Aroma Binary Options");

        lblZipOptions.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblZipOptions.setForeground(new java.awt.Color(255, 255, 255));
        lblZipOptions.setText("Zip Options");

        btnAromaZip.setForeground(new java.awt.Color(255, 255, 255));
        btnAromaZip.setText("<html>Create Zip Type<br><p align='center'>Aroma</p></html>");
        btnAromaZip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnAromaZip.setContentAreaFilled(false);
        btnAromaZip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAromaZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAromaZipActionPerformed(evt);
            }
        });

        btnNormalZip.setForeground(new java.awt.Color(255, 255, 255));
        btnNormalZip.setText("<html>Create Zip Type<br><p align='center'>Normal</p></html>");
        btnNormalZip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnNormalZip.setContentAreaFilled(false);
        btnNormalZip.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNormalZip.setPreferredSize(new java.awt.Dimension(115, 37));
        btnNormalZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNormalZipActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent) {
            String czt = Xml.getCreateZipType(pp.preferencesConfig);
            switch (czt) {
                case "Aroma":
                    btnAromaZip.setContentAreaFilled(true);
                    btnAromaZip.setForeground(new java.awt.Color(0, 0, 0));
                    break;
                case "Normal":
                    btnNormalZip.setContentAreaFilled(true);
                    btnNormalZip.setForeground(new java.awt.Color(0, 0, 0));
                    break;
            }
            pp.createZipType = czt;
        }

        btnQuickSetup.setForeground(new java.awt.Color(255, 255, 255));
        btnQuickSetup.setText("Quick Setup");
        btnQuickSetup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnQuickSetup.setContentAreaFilled(false);
        btnQuickSetup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQuickSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickSetupActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent && Xml.getQuickSetup(pp.preferencesConfig)) {
            btnQuickSetup.setContentAreaFilled(true);
            btnQuickSetup.setForeground(new java.awt.Color(0, 0, 0));
            pp.isQuickSetup = true;
        }

        btnSaveTools.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveTools.setText("Enable Logging");
        btnSaveTools.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSaveTools.setContentAreaFilled(false);
        btnSaveTools.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSaveTools.setPreferredSize(new java.awt.Dimension(100, 37));
        btnSaveTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveToolsActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent && Xml.getLogsIndicator(pp.preferencesConfig)) {
            btnSaveTools.setContentAreaFilled(true);
            btnSaveTools.setForeground(new java.awt.Color(0, 0, 0));
            pp.saveLogs = true;
        }

        btnCheckUpdates.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckUpdates.setText("<html>Check For<br><p align='center'>Updates</p></html>");
        btnCheckUpdates.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnCheckUpdates.setContentAreaFilled(false);
        btnCheckUpdates.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCheckUpdates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckUpdatesActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent && Xml.getCheckUpdatesIndicator(pp.preferencesConfig)) {
            btnCheckUpdates.setContentAreaFilled(true);
            btnCheckUpdates.setForeground(new java.awt.Color(0, 0, 0));
            pp.checkUpdatesOnStartUp = true;
        }

        lblToolOptions.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblToolOptions.setForeground(new java.awt.Color(255, 255, 255));
        lblToolOptions.setText("Tool Options");

        lblAddonDOptions.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblAddonDOptions.setForeground(new java.awt.Color(255, 255, 255));
        lblAddonDOptions.setText("Addon.d Options");

        btnEnableAddon.setForeground(new java.awt.Color(255, 255, 255));
        btnEnableAddon.setText("<html>Enable Support<br><p align='center'>by default</p></html>");
        btnEnableAddon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnEnableAddon.setContentAreaFilled(false);
        btnEnableAddon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEnableAddon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableAddonActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent && Xml.getEnableAddonDSupport(pp.preferencesConfig)) {
            btnEnableAddon.setContentAreaFilled(true);
            btnEnableAddon.setForeground(new java.awt.Color(0, 0, 0));
            pp.enableAddonDSupport = true;
        }

        btnDisplayAddon.setForeground(new java.awt.Color(255, 255, 255));
        btnDisplayAddon.setText("<html>Display Addon.d<br><p align='center'>Menu in Aroma</p></html>");
        btnDisplayAddon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnDisplayAddon.setContentAreaFilled(false);
        btnDisplayAddon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDisplayAddon.setPreferredSize(new java.awt.Dimension(115, 37));
        btnDisplayAddon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayAddonActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent && Xml.getDisplayAddonDSupport(pp.preferencesConfig)) {
            btnDisplayAddon.setContentAreaFilled(true);
            btnDisplayAddon.setForeground(new java.awt.Color(0, 0, 0));
            pp.displayAddonDSupport = true;
        }

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnSaveActionPerformed(evt);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(Preference.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(Preference.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Preference.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        panelAromaBinary.setBackground(new java.awt.Color(66, 66, 66));

        btnMelati.setForeground(new java.awt.Color(255, 255, 255));
        btnMelati.setText("<html>Version 3.00b1<br><p align='center'>MELATI</p></html>");
        btnMelati.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnMelati.setContentAreaFilled(false);
        btnMelati.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMelati.setPreferredSize(new java.awt.Dimension(115, 37));
        btnMelati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMelatiActionPerformed(evt);
            }
        });

        btnFlamboyan.setForeground(new java.awt.Color(255, 255, 255));
        btnFlamboyan.setText("<html>Version 2.70 RC2<br>&nbsp;&nbsp;&nbsp;&nbsp;FLAMBOYAN</html>");
        btnFlamboyan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnFlamboyan.setContentAreaFilled(false);
        btnFlamboyan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFlamboyan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlamboyanActionPerformed(evt);
            }
        });

        btnEdelweis.setForeground(new java.awt.Color(255, 255, 255));
        btnEdelweis.setText("<html>Version 2.56<br><p align='center'>EDELWEIS</p></html>");
        btnEdelweis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnEdelweis.setContentAreaFilled(false);
        btnEdelweis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdelweis.setPreferredSize(new java.awt.Dimension(115, 37));
        btnEdelweis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdelweisActionPerformed(evt);
            }
        });

        if (pp.preferencesFilePresent) {
            String av = Xml.getAromaVersion(pp.preferencesConfig);
            switch (av) {
                case "Version 3.00b1 - MELATI":
                    btnMelati.setContentAreaFilled(true);
                    btnMelati.setForeground(new java.awt.Color(0, 0, 0));
                    break;
                case "Version 2.70 RC2 - FLAMBOYAN":
                    btnFlamboyan.setContentAreaFilled(true);
                    btnFlamboyan.setForeground(new java.awt.Color(0, 0, 0));
                    break;
                case "Version 2.56 - EDELWEIS":
                    btnEdelweis.setContentAreaFilled(true);
                    btnEdelweis.setForeground(new java.awt.Color(0, 0, 0));
                    break;
            }
            pp.aromaVersion = av;
        }

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblToolOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAddonDOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAromaOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(btnNormalZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addComponent(btnCheckUpdates)
                                    .addGap(30, 30, 30)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDisplayAddon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblZipOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMelati))
                                .addGap(29, 29, 29)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAromaZip, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(btnQuickSetup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnableAddon)
                            .addComponent(btnFlamboyan))
                        .addGap(29, 29, 29)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(btnSaveTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEdelweis, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblAromaOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMelati, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFlamboyan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdelweis, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblZipOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNormalZip, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAromaZip, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblToolOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCheckUpdates, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveTools, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuickSetup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAddonDOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDisplayAddon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnableAddon, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialog.getContentPane().add(mainPanel);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }// </editor-fold>                        

    private void btnMelatiActionPerformed(java.awt.event.ActionEvent evt) {
        btnMelati.setContentAreaFilled(true);
        btnMelati.setForeground(new java.awt.Color(0, 0, 0));
        btnFlamboyan.setContentAreaFilled(false);
        btnFlamboyan.setForeground(new java.awt.Color(255, 255, 255));
        btnEdelweis.setContentAreaFilled(false);
        btnEdelweis.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void btnFlamboyanActionPerformed(java.awt.event.ActionEvent evt) {
        btnFlamboyan.setContentAreaFilled(true);
        btnFlamboyan.setForeground(new java.awt.Color(0, 0, 0));
        btnMelati.setContentAreaFilled(false);
        btnMelati.setForeground(new java.awt.Color(255, 255, 255));
        btnEdelweis.setContentAreaFilled(false);
        btnEdelweis.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void btnEdelweisActionPerformed(java.awt.event.ActionEvent evt) {
        btnEdelweis.setContentAreaFilled(true);
        btnEdelweis.setForeground(new java.awt.Color(0, 0, 0));
        btnFlamboyan.setContentAreaFilled(false);
        btnFlamboyan.setForeground(new java.awt.Color(255, 255, 255));
        btnMelati.setContentAreaFilled(false);
        btnMelati.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void btnAromaZipActionPerformed(java.awt.event.ActionEvent evt) {
        btnAromaZip.setContentAreaFilled(true);
        btnAromaZip.setForeground(new java.awt.Color(0, 0, 0));
        btnNormalZip.setContentAreaFilled(false);
        btnNormalZip.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void btnNormalZipActionPerformed(java.awt.event.ActionEvent evt) {
        btnNormalZip.setContentAreaFilled(true);
        btnNormalZip.setForeground(new java.awt.Color(0, 0, 0));
        btnAromaZip.setContentAreaFilled(false);
        btnAromaZip.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void btnCheckUpdatesActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnCheckUpdates.isContentAreaFilled()) {
            btnCheckUpdates.setContentAreaFilled(false);
            btnCheckUpdates.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            btnCheckUpdates.setContentAreaFilled(true);
            btnCheckUpdates.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void btnQuickSetupActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnQuickSetup.isContentAreaFilled()) {
            btnQuickSetup.setContentAreaFilled(false);
            btnQuickSetup.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            btnQuickSetup.setContentAreaFilled(true);
            btnQuickSetup.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void btnSaveToolsActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnSaveTools.isContentAreaFilled()) {
            btnSaveTools.setContentAreaFilled(false);
            btnSaveTools.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            btnSaveTools.setContentAreaFilled(true);
            btnSaveTools.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void btnDisplayAddonActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnDisplayAddon.isContentAreaFilled()) {
            btnDisplayAddon.setContentAreaFilled(false);
            btnDisplayAddon.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            btnDisplayAddon.setContentAreaFilled(true);
            btnDisplayAddon.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void btnEnableAddonActionPerformed(java.awt.event.ActionEvent evt) {
        if (btnEnableAddon.isContentAreaFilled()) {
            btnEnableAddon.setContentAreaFilled(false);
            btnEnableAddon.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            btnEnableAddon.setContentAreaFilled(true);
            btnEnableAddon.setForeground(new java.awt.Color(0, 0, 0));
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, TransformerException, IOException {
        String xml = null;
        if (btnMelati.isContentAreaFilled()) {
            pp.aromaVersion = "Version 3.00b1 - MELATI";
        } else if (btnFlamboyan.isContentAreaFilled()) {
            pp.aromaVersion = "Version 2.70 RC2 - FLAMBOYAN";
        } else if (btnEdelweis.isContentAreaFilled()) {
            pp.aromaVersion = "Version 2.56 - EDELWEIS";
        }
        if (btnAromaZip.isContentAreaFilled()) {
            pp.createZipType = "Aroma";
        } else if (btnNormalZip.isContentAreaFilled()) {
            pp.createZipType = "Normal";
        }
        pp.androidVersionAboveLP = true;
        pp.enableAddonDSupport = btnEnableAddon.isContentAreaFilled();
        pp.displayAddonDSupport = btnDisplayAddon.isContentAreaFilled();
        pp.isQuickSetup = btnQuickSetup.isContentAreaFilled();
        pp.zipCreatorName = "Nikhil";
        pp.checkUpdatesOnStartUp = btnCheckUpdates.isContentAreaFilled();
        Project.zipCreator = pp.zipCreatorName;
        pp.zipVersion = "1.0";
        Project.releaseVersion = pp.zipVersion;
        pp.saveLogs = btnSaveTools.isContentAreaFilled();
        xml = Xml.getPreferenceConfigString(pp);
        Write w = new Write();
        w.writeStringToFile(xml, "Preferences.config");
        dialog.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PreferenceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreferenceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreferenceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreferenceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreferenceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton btnAromaZip;
    private javax.swing.JToggleButton btnCheckUpdates;
    private javax.swing.JToggleButton btnDisplayAddon;
    private javax.swing.JButton btnEdelweis;
    private javax.swing.JToggleButton btnEnableAddon;
    private javax.swing.JButton btnFlamboyan;
    private javax.swing.JButton btnMelati;
    private javax.swing.JToggleButton btnNormalZip;
    private javax.swing.JToggleButton btnQuickSetup;
    private javax.swing.JButton btnSave;
    private javax.swing.JToggleButton btnSaveTools;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblAddonDOptions;
    private javax.swing.JLabel lblAromaOptions;
    private javax.swing.JLabel lblToolOptions;
    private javax.swing.JLabel lblZipOptions;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelAromaBinary;
    // End of variables declaration                   
}
