/**
 * @author alessandro jacques
 */
package VISUAL;

import DAO.conectaBD;
import java.awt.Toolkit;
import java.sql.*;
//import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class frmLogin extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public frmLogin() throws ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = conectaBD.conectabd();
        this.populaJComboBox();
        setIcon();
    }

    public void populaJComboBox() {
        String sql = "Select * from login";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                cmbUser.addItem(rs.getString("usuario"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void setIcon(){
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ICONES/fenix-pequenonin.png")));
    }

    public void Logar() {

        String sql = "Select * from login where usuario = ? and senha = ?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, (String) cmbUser.getSelectedItem());
            pst.setString(2, txtSenha.getText());

            rs = pst.executeQuery();

            if (rs.next()) {
                frmPrincipal frm = new frmPrincipal();
                frm.setVisible(true);
                dispose(); //fecha a tela de login, depois que logar.
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e senha inválidos!");
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        telaLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        txtSenha = new javax.swing.JPasswordField();
        txtEntrar = new javax.swing.JButton();
        txtSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        telaLogin.setBackground(new java.awt.Color(0, 51, 153));
        telaLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login de usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 1, 11), new java.awt.Color(51, 102, 255))); // NOI18N
        telaLogin.setLayout(new java.awt.GridBagLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/loginfrm.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        telaLogin.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Usuário:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        telaLogin.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        telaLogin.add(jLabel3, gridBagConstraints);

        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        telaLogin.add(cmbUser, gridBagConstraints);

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 300;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        telaLogin.add(txtSenha, gridBagConstraints);

        txtEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/accept.png"))); // NOI18N
        txtEntrar.setText("ENTRAR");
        txtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        telaLogin.add(txtEntrar, gridBagConstraints);

        txtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/cancel.png"))); // NOI18N
        txtSair.setText("SAIR");
        txtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSairActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        telaLogin.add(txtSair, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sistema desenvolvido pela equipe T.I - Alessandro Jacques / Alexandre Rosário");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(telaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(telaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed

    }//GEN-LAST:event_txtSenhaActionPerformed

    private void txtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_txtSairActionPerformed

    private void txtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntrarActionPerformed
        Logar();
    }//GEN-LAST:event_txtEntrarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmLogin().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel telaLogin;
    private javax.swing.JButton txtEntrar;
    private javax.swing.JButton txtSair;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
