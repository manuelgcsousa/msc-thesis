package lyntax.editor;

import java.awt.FileDialog;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

/**
 * Editor class.
 * 
 * @author gcsousa
 */
public class Editor extends javax.swing.JFrame
{
    private final Facade facade;
    private char areaFocused;
    private String fileName;
    private String fileAddress;
    
    private UndoManager umRules;
    private UndoManager umInput;
    
    /**
     * Editor constructor.
     * @param facade
     */
    public Editor(Facade facade) {
        this.facade = facade;
        this.areaFocused = 'r';
        
        initComponents();
        
        /* Rules text area UndoManager. */
        this.umRules = new UndoManager();
        this.RulesArea
            .getDocument()
            .addUndoableEditListener((UndoableEditEvent e) -> {
                umRules.addEdit(e.getEdit());
            });
        
        /* Input text area UndoManager. */
        this.umInput = new UndoManager();
        this.InputArea
            .getDocument()
            .addUndoableEditListener((UndoableEditEvent e) -> {
                umInput.addEdit(e.getEdit());
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        RulesArea = new javax.swing.JTextArea();
        RulesLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputArea = new javax.swing.JTextArea();
        InputLabel = new javax.swing.JLabel();
        runBtn = new javax.swing.JButton();
        genBtn = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        SubmenuRules = new javax.swing.JMenu();
        SubmenuRulesNew = new javax.swing.JMenuItem();
        SubmenuRulesOpen = new javax.swing.JMenuItem();
        SubmenuRulesSave = new javax.swing.JMenuItem();
        SubmenuRulesSaveAs = new javax.swing.JMenuItem();
        SubmenuInput = new javax.swing.JMenu();
        SubmenuInputNew = new javax.swing.JMenuItem();
        SubmenuInputOpen = new javax.swing.JMenuItem();
        SubmenuInputSave = new javax.swing.JMenuItem();
        SubmenuInputSaveAs = new javax.swing.JMenuItem();
        SubmenuExit = new javax.swing.JMenuItem();
        MenuEdit = new javax.swing.JMenu();
        Undo = new javax.swing.JMenuItem();
        Redo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyntax Editor");
        setMinimumSize(new java.awt.Dimension(830, 500));

        RulesArea.setColumns(20);
        RulesArea.setRows(5);
        RulesArea.setTabSize(2);
        RulesArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        RulesArea.setMinimumSize(new java.awt.Dimension(20, 20));
        RulesArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RulesAreaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(RulesArea);

        RulesLabel.setText("Rules");

        InputArea.setColumns(20);
        InputArea.setRows(5);
        InputArea.setTabSize(2);
        InputArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        InputArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                InputAreaFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(InputArea);

        InputLabel.setText("Input");

        runBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lyntax/editor/run.png"))); // NOI18N
        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        genBtn.setText("Generate");
        genBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genBtnActionPerformed(evt);
            }
        });

        MenuBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MenuBar.setToolTipText("");

        MenuFile.setText("File");

        SubmenuRules.setText("Rules");

        SubmenuRulesNew.setText("New");
        SubmenuRulesNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuRulesNewMousePressed(evt);
            }
        });
        SubmenuRules.add(SubmenuRulesNew);

        SubmenuRulesOpen.setText("Open");
        SubmenuRulesOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuRulesOpenMousePressed(evt);
            }
        });
        SubmenuRules.add(SubmenuRulesOpen);

        SubmenuRulesSave.setText("Save");
        SubmenuRulesSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuRulesSaveMousePressed(evt);
            }
        });
        SubmenuRules.add(SubmenuRulesSave);

        SubmenuRulesSaveAs.setText("Save As");
        SubmenuRulesSaveAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuRulesSaveAsMousePressed(evt);
            }
        });
        SubmenuRules.add(SubmenuRulesSaveAs);

        MenuFile.add(SubmenuRules);

        SubmenuInput.setText("Input");

        SubmenuInputNew.setText("New");
        SubmenuInputNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuInputNewMousePressed(evt);
            }
        });
        SubmenuInput.add(SubmenuInputNew);

        SubmenuInputOpen.setText("Open");
        SubmenuInputOpen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuInputOpenMousePressed(evt);
            }
        });
        SubmenuInput.add(SubmenuInputOpen);

        SubmenuInputSave.setText("Save");
        SubmenuInputSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuInputSaveMousePressed(evt);
            }
        });
        SubmenuInput.add(SubmenuInputSave);

        SubmenuInputSaveAs.setText("Save As");
        SubmenuInputSaveAs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SubmenuInputSaveAsMousePressed(evt);
            }
        });
        SubmenuInput.add(SubmenuInputSaveAs);

        MenuFile.add(SubmenuInput);

        SubmenuExit.setText("Exit");
        MenuFile.add(SubmenuExit);

        MenuBar.add(MenuFile);

        MenuEdit.setText("Edit");

        Undo.setText("Undo");
        Undo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                UndoMousePressed(evt);
            }
        });
        MenuEdit.add(Undo);

        Redo.setText("Redo");
        Redo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RedoMousePressed(evt);
            }
        });
        MenuEdit.add(Redo);

        MenuBar.add(MenuEdit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addComponent(RulesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InputLabel)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(genBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(runBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {genBtn, runBtn});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RulesLabel)
                    .addComponent(InputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genBtn))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {genBtn, runBtn});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /***************************/
    /****** RULES SUBMENU ******/
    /***************************/ 
    
    private void RulesAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RulesAreaFocusGained
        this.areaFocused = 'r';
    }//GEN-LAST:event_RulesAreaFocusGained

    private void SubmenuRulesNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuRulesNewMousePressed
        this.facade.onNew();
    }//GEN-LAST:event_SubmenuRulesNewMousePressed

    private void SubmenuRulesOpenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuRulesOpenMousePressed
        FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String filePath = fd.getDirectory();
            
            boolean open = this.facade.onOpen(fileName, filePath, 'r');
            if (!open) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when opening file!", "Open", 0);
            } else {
                this.RulesArea.setText("");
                this.RulesLabel.setText("Rules: \"" + fileName + "\"");
                
                this.facade
                    .getRulesFile()
                    .getContent()
                    .forEach(line -> {
                        this.RulesArea.append(line + "\n");
                    });
            }
        }
    }//GEN-LAST:event_SubmenuRulesOpenMousePressed

    private void SubmenuRulesSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuRulesSaveMousePressed
        if (this.facade.getRulesFile() == null) {
            this.SubmenuRulesSaveAsMousePressed(evt);
        } else {
            boolean saved = this.facade.onSave(this.RulesArea.getText(), 'r');
            if (!saved) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when saving file!", "Open", 0);
            }
        }
    }//GEN-LAST:event_SubmenuRulesSaveMousePressed

    private void SubmenuRulesSaveAsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuRulesSaveAsMousePressed
        FileDialog fd = new FileDialog(this, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String filePath = fd.getDirectory();
            
            boolean saved = this.facade.onSaveAs(fileName, filePath, this.RulesArea.getText(), 'r');
            if (!saved) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when saving file!", "Open", 0);
            } else {
                this.RulesLabel.setText("Rules: \"" + fileName + "\"");
            }
        }
    }//GEN-LAST:event_SubmenuRulesSaveAsMousePressed

    
    /***************************/
    /****** INPUT SUBMENU ******/
    /***************************/ 
    
    private void InputAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_InputAreaFocusGained
        this.areaFocused = 'i';
    }//GEN-LAST:event_InputAreaFocusGained

    private void SubmenuInputNewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuInputNewMousePressed
        this.facade.onNew();
    }//GEN-LAST:event_SubmenuInputNewMousePressed

    private void SubmenuInputOpenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuInputOpenMousePressed
        FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String filePath = fd.getDirectory();
            
            boolean open = this.facade.onOpen(fileName, filePath, 'i');
            if (!open) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when opening file!", "Open", 0);
            } else {
                this.InputArea.setText("");
                this.InputLabel.setText("Input: \"" + fileName + "\"");
                
                this.facade
                    .getInputFile()
                    .getContent()
                    .forEach(line -> {
                        this.InputArea.append(line + "\n");
                    });
            }
        }
    }//GEN-LAST:event_SubmenuInputOpenMousePressed

    private void SubmenuInputSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuInputSaveMousePressed
        if (this.facade.getInputFile() == null) {
            this.SubmenuInputSaveAsMousePressed(evt);
        } else {
            boolean saved = this.facade.onSave(this.InputArea.getText(), 'i');
            if (!saved) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when saving file!", "Open", 0);
            }
        }
    }//GEN-LAST:event_SubmenuInputSaveMousePressed

    private void SubmenuInputSaveAsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmenuInputSaveAsMousePressed
        FileDialog fd = new FileDialog(this, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        
        if (fd.getFile() != null) {
            String fileName = fd.getFile();
            String filePath = fd.getDirectory();
            
            boolean saved = this.facade.onSaveAs(fileName, filePath, this.InputArea.getText(), 'i');
            if (!saved) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error when saving file!", "Open", 0);
            } else {
                this.InputLabel.setText("Input: \"" + fileName + "\"");
            }
        }
    }//GEN-LAST:event_SubmenuInputSaveAsMousePressed

    private void UndoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UndoMousePressed
        if (this.areaFocused == 'r')
            this.umRules.undo();
        
        if (this.areaFocused == 'i')
            this.umInput.undo();
    }//GEN-LAST:event_UndoMousePressed

    private void RedoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RedoMousePressed
        if (this.areaFocused == 'r')
            this.umRules.redo();
        
        if (this.areaFocused == 'i')
            this.umInput.redo();
    }//GEN-LAST:event_RedoMousePressed

    private void genBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genBtnActionPerformed
        String msg = this.facade.onGen(this.RulesArea.getText(), this.InputArea.getText());
        
        if (!msg.isEmpty())
            if (msg.equals("err"))
                javax.swing.JOptionPane.showMessageDialog(this, "Internal error...", "Generate", 0);
            else
                javax.swing.JOptionPane.showMessageDialog(this, msg, "Generate", 0);
        else
            javax.swing.JOptionPane.showMessageDialog(this, "Grammar generated with success!", "Generate", 1);
    }//GEN-LAST:event_genBtnActionPerformed
    
    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        this.setEnabled(false);
        this.facade.onRun();
        this.setEnabled(true);
    }//GEN-LAST:event_runBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea InputArea;
    private javax.swing.JLabel InputLabel;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuEdit;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem Redo;
    private javax.swing.JTextArea RulesArea;
    private javax.swing.JLabel RulesLabel;
    private javax.swing.JMenuItem SubmenuExit;
    private javax.swing.JMenu SubmenuInput;
    private javax.swing.JMenuItem SubmenuInputNew;
    private javax.swing.JMenuItem SubmenuInputOpen;
    private javax.swing.JMenuItem SubmenuInputSave;
    private javax.swing.JMenuItem SubmenuInputSaveAs;
    private javax.swing.JMenu SubmenuRules;
    private javax.swing.JMenuItem SubmenuRulesNew;
    private javax.swing.JMenuItem SubmenuRulesOpen;
    private javax.swing.JMenuItem SubmenuRulesSave;
    private javax.swing.JMenuItem SubmenuRulesSaveAs;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JButton genBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton runBtn;
    // End of variables declaration//GEN-END:variables
}
