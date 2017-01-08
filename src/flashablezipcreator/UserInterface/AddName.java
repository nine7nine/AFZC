/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.UserInterface;

import flashablezipcreator.Core.FolderNode;
import flashablezipcreator.Core.GroupNode;
import flashablezipcreator.Core.ProjectItemNode;
import flashablezipcreator.Core.ProjectNode;
import flashablezipcreator.Core.SubGroupNode;
import flashablezipcreator.MyTree;
import flashablezipcreator.Operations.TreeOperations;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Nikhil
 */
public class AddName extends javax.swing.JFrame {

    /**
     * Creates new form AddGroupNameUI
     */
    int groupType = -1;
    int subGroupType = -1;
    int projectType = -1;
    ProjectNode pNode;
    GroupNode gNode;
    ProjectItemNode rNode;
    FolderNode fNode;
    SubGroupNode sNode;
    String location;
    String extension;
    String projectLabelTitle;
    String projectDialogTitle;
    String projectHeaderTitle;

    TreeOperations to = new TreeOperations();

    public AddName() {

    }

    public AddName(String nodeType, int type, ProjectItemNode parent) {
        switch (parent.type) {
            case ProjectItemNode.NODE_ROOT:
                this.rNode = parent;
                this.projectType = type;
                break;
            case ProjectItemNode.NODE_GROUP:
                gNode = (GroupNode) parent;
                break;
            case ProjectItemNode.NODE_SUBGROUP:
                sNode = (SubGroupNode) parent;
                break;
            case ProjectItemNode.NODE_FOLDER:
                fNode = (FolderNode) parent;
                break;
        }
        this.projectDialogTitle = "Add " + nodeType + " Name";
        this.projectHeaderTitle = "   Add " + nodeType + "";
        this.projectLabelTitle = "" + nodeType + " Name ";
        initProjectComponents();
    }

    public AddName(String location, int type, String extension, boolean isSelectBox, ProjectItemNode parent) {
        txtLocation.setText(location);
        txtLocation.setEditable(false);
        txtExtension.setEditable(false);
        rbCheck.setEnabled(false);
        rbRadio.setEnabled(false);
        txtExtension.setText(extension);
        if (!isSelectBox) {
            rbCheck.setSelected(true);
        } else {
            rbRadio.setSelected(true);
        }
        switch (parent.type) {
            case ProjectItemNode.NODE_PROJECT:
                this.pNode = (ProjectNode) parent;
                if (pNode.projectType == ProjectNode.PROJECT_THEMES) {
                    lblHeader.setText("   Add Theme");
                    lblGroupName.setText("Theme Name");
                    panelHeader.setBackground(new java.awt.Color(245, 127, 23));
                } else {
                    lblHeader.setText("   Add Group");
                    lblGroupName.setText("Group Name");
                    panelHeader.setBackground(new java.awt.Color(109, 192, 102));
                }
                this.groupType = type;
                break;
            case ProjectItemNode.NODE_GROUP:
                lblHeader.setText("   Add SubGroup");
                lblGroupName.setText("SubGroup Name");
                this.subGroupType = type;
                this.gNode = (GroupNode) parent;
                panelHeader.setBackground(new java.awt.Color(96, 125, 139));
                break;
        }
        if (location.equals("kernel")) {
            txtLocation.setText("");
            txtLocation.setEditable(true);
        }
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 

    private void initProjectComponents() {
        dialog = new JDialog(this, this.projectDialogTitle, true);
        dialog.setResizable(false);
        panelAddProjectName = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        lblProjectName = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        txtProjectName = new javax.swing.JTextField();
        panelBottom = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelAddProjectName.setBackground(new java.awt.Color(255, 255, 255));

        panelHeader.setBackground(new java.awt.Color(66, 66, 66));

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        lblHeader.setText(this.projectHeaderTitle);

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));

        lblProjectName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProjectName.setText(this.projectLabelTitle);

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
                panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLeftLayout.setVerticalGroup(
                panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLeftLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRight.setBackground(new java.awt.Color(255, 255, 255));

        txtProjectName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
                panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
        );
        panelRightLayout.setVerticalGroup(
                panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRightLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBottom.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
                panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBottomLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
        );
        panelBottomLayout.setVerticalGroup(
                panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBottomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAddProjectNameLayout = new javax.swing.GroupLayout(panelAddProjectName);
        panelAddProjectName.setLayout(panelAddProjectNameLayout);
        panelAddProjectNameLayout.setHorizontalGroup(
                panelAddProjectNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAddProjectNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddProjectNameLayout.createSequentialGroup()
                                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelAddProjectNameLayout.setVerticalGroup(
                panelAddProjectNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAddProjectNameLayout.createSequentialGroup()
                        .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddProjectNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panelAddProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        dialog.getContentPane().add(panelAddProjectName);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dialog.dispose();
            }
        });
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void initComponents() {

        dialog = new JDialog(this, "Add Group Name", true);
        dialog.setResizable(false);
        btnGroup = new javax.swing.ButtonGroup();
        panelAddGroupName = new javax.swing.JPanel();
        //panelHeader = new javax.swing.JPanel();
        //lblHeader = new javax.swing.JLabel();
        panelLeft = new javax.swing.JPanel();
        //lblGroupName = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblExtension = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        panelRight = new javax.swing.JPanel();
        txtGroupName = new javax.swing.JTextField();
        //txtLocation = new javax.swing.JTextField();
        //txtExtension = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        //rbRadio = new javax.swing.JRadioButton();
        //rbCheck = new javax.swing.JRadioButton();
        panelBottom = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        panelAddGroupName.setBackground(new java.awt.Color(255, 255, 255));

        //panelHeader.setBackground(new java.awt.Color(109, 192, 102));
        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(255, 255, 255));
        //lblHeader.setText("   Add Group");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHeaderLayout.setVerticalGroup(
                panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelLeft.setBackground(new java.awt.Color(255, 255, 255));

        //lblGroupName.setText("Group Name ");
        lblLocation.setText("Install Location ");

        lblExtension.setText("File Extension");

        lblDescription.setText("Description ");

        lblType.setText("Select Type ");

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
                panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblLocation)
                                                .addComponent(lblExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblDescription)))
                                .addGroup(panelLeftLayout.createSequentialGroup()
                                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblType))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        panelLeftLayout.setVerticalGroup(
                panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelLeftLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(lblType)
                        .addContainerGap())
        );

        panelRight.setBackground(new java.awt.Color(255, 255, 255));

        rbRadio.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(rbRadio);
        rbRadio.setText("Radio Button");

        rbCheck.setBackground(new java.awt.Color(255, 255, 255));
        btnGroup.add(rbCheck);
        rbCheck.setText("Check Box");

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
                panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtExtension, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtGroupName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                        .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(panelRightLayout.createSequentialGroup()
                                        .addComponent(rbRadio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbCheck)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRightLayout.setVerticalGroup(
                panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRightLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbRadio)
                                .addComponent(rbCheck))
                        .addContainerGap())
        );

        panelBottom.setBackground(new java.awt.Color(255, 255, 255));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        javax.swing.GroupLayout panelBottomLayout = new javax.swing.GroupLayout(panelBottom);
        panelBottom.setLayout(panelBottomLayout);
        panelBottomLayout.setHorizontalGroup(
                panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBottomLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
        );
        panelBottomLayout.setVerticalGroup(
                panelBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBottomLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelAddGroupNameLayout = new javax.swing.GroupLayout(panelAddGroupName);
        panelAddGroupName.setLayout(panelAddGroupNameLayout);
        panelAddGroupNameLayout.setHorizontalGroup(
                panelAddGroupNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAddGroupNameLayout.createSequentialGroup()
                        .addGroup(panelAddGroupNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(panelBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAddGroupNameLayout.createSequentialGroup()
                                        .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAddGroupNameLayout.setVerticalGroup(
                panelAddGroupNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelAddGroupNameLayout.createSequentialGroup()
                        .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAddGroupNameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelAddGroupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelAddGroupName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();

        dialog.getContentPane().add(panelAddGroupName);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        String name = txtGroupName.getText();
        String projectName = txtProjectName.getText();
        if (!projectName.equals("")) {
            if (this.rNode != null) {
                rNode.addChild(new ProjectNode(projectName, this.projectType, rNode), false);
            } else if (this.gNode != null) {
                gNode.addChild(new FolderNode(projectName, gNode), false);
            } else if (this.sNode != null) {
                sNode.addChild(new FolderNode(projectName, sNode), false);
            } else if (this.fNode != null) {
                fNode.addChild(new FolderNode(projectName, fNode), false);
            }
            dialog.dispose();
        } else if (!name.equals("")) {
            if (this.gNode != null) {
                gNode.addChild(new SubGroupNode(name, this.subGroupType, gNode), false);
            } else if (this.pNode != null) {
                pNode.addChild(new GroupNode(name, this.groupType, pNode), false);
            } else if (this.rNode != null) {
                rNode.addChild(new ProjectNode(projectName, this.projectType, rNode), false);
            } else if (this.fNode != null) {
                fNode.addChild(new FolderNode(name, fNode), false);
            }
            dialog.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Name cannot be empty..!!");
        }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddGroupNameUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddName().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    //Project
    private javax.swing.JLabel lblProjectName;
    private javax.swing.JPanel panelAddProjectName;
    private javax.swing.JTextField txtProjectName = new JTextField();

    //Group-Subgroup
    private javax.swing.JButton btnAdd;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblExtension;
    private javax.swing.JLabel lblGroupName = new JLabel();
    private javax.swing.JLabel lblHeader = new JLabel();
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel panelAddGroupName;
    private javax.swing.JPanel panelBottom;
    private javax.swing.JPanel panelHeader = new JPanel();
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JRadioButton rbCheck = new JRadioButton();
    private javax.swing.JRadioButton rbRadio = new JRadioButton();
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtExtension = new JTextField();
    private javax.swing.JTextField txtGroupName = new JTextField();
    private javax.swing.JTextField txtLocation = new JTextField();
    public JDialog dialog;
    // End of variables declaration                   
}
