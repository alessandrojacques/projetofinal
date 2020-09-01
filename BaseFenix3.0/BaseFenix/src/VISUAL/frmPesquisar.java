/**
 *
 * @author alessandro jacques
 */
package VISUAL;

import DAO.conectaBD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
//import java.awt.Component;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
//import com.sun.istack.internal.logging.Logger;

public class frmPesquisar extends javax.swing.JInternalFrame {

    Connection conecta;
    PreparedStatement pst;
    ResultSet rs;

    public frmPesquisar() throws ClassNotFoundException {
        initComponents();
        this.setLocation(460, 120);
        conecta = conectaBD.conectabd();
        listarPesquisas();
       // Imprimir();
    }

    public void listarPesquisas() {

        String sql = "select * from base"; //buscar users no banco de dados

        try {
            pst = conecta.prepareStatement(sql);
            rs = pst.executeQuery();
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void pesquisarClientes() {
        String sql = "select * from base where nome like ?";

        try {
            pst = conecta.prepareStatement(sql);
            pst.setString(1, txtPesquisar.getText() + "%");
            rs = pst.executeQuery();
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }

    public void limparPesquisa() {
        txtPesquisar.setText("");
    }

    public void mostrarItens() {
        int seleciona = tblClientes.getSelectedRow();
        txtCodigo.setText(tblClientes.getModel().getValueAt(seleciona, 0).toString());
        txtNome.setText(tblClientes.getModel().getValueAt(seleciona, 1).toString());
        txtDataCadastro.setText(tblClientes.getModel().getValueAt(seleciona, 2).toString());
        txtCPF.setText(tblClientes.getModel().getValueAt(seleciona, 3).toString());
        txtEndereco.setText(tblClientes.getModel().getValueAt(seleciona, 4).toString());
        txtNumero.setText(tblClientes.getModel().getValueAt(seleciona, 5).toString());
        txtComplemento.setText(tblClientes.getModel().getValueAt(seleciona, 6).toString());
        txtBairro.setText(tblClientes.getModel().getValueAt(seleciona, 7).toString());
        txtCidade.setText(tblClientes.getModel().getValueAt(seleciona, 8).toString());
        txtUF.setText(tblClientes.getModel().getValueAt(seleciona, 9).toString());
        txtCEP.setText(tblClientes.getModel().getValueAt(seleciona, 10).toString());
        txtEmail.setText(tblClientes.getModel().getValueAt(seleciona, 11).toString());
        txtTelefone.setText(tblClientes.getModel().getValueAt(seleciona, 12).toString());
        txtCelular.setText(tblClientes.getModel().getValueAt(seleciona, 13).toString());
        txtNSerie.setText(tblClientes.getModel().getValueAt(seleciona, 14).toString());
        txtProduto.setText(tblClientes.getModel().getValueAt(seleciona, 15).toString());
        txtNotaFiscal.setText(tblClientes.getModel().getValueAt(seleciona, 16).toString());
        txtDataCompra.setText(tblClientes.getModel().getValueAt(seleciona, 17).toString());
        txtDescricao.setText(tblClientes.getModel().getValueAt(seleciona, 18).toString());

        txtDescricao.setLineWrap(true); //quebra de linha automático
        txtDescricao.setWrapStyleWord(true); //quebra de linha automático
    }
    
 /*   public void Imprimir() {

        PrinterJob pj = PrinterJob.getPrinterJob();
     //   pj.setJobName(" Print Component ");

        pj.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            
            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            
            conteudoCliente.paint(g2);        // o JPanel aqui
            
            return Printable.PAGE_EXISTS;
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    } */
    


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        conteudoCliente = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNSerie = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtNotaFiscal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtDataCadastro = new javax.swing.JFormattedTextField();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
        txtDataCompra = new javax.swing.JFormattedTextField();
        btnImprimir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        txtLimpar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pesquisar clientes");
        setVisible(true);

        conteudoCliente.setBackground(new java.awt.Color(204, 204, 204));
        conteudoCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        conteudoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conteudoCliente.setEnabled(false);

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setText("Razão Social/Nome");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setText("Código");

        txtNome.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel3.setText("CNPJ/CPF");

        txtCPF.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCPF.setAlignmentX(0.0F);
        txtCPF.setAlignmentY(0.0F);
        txtCPF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCPF.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel4.setText("Endereço");

        txtEndereco.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEndereco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEndereco.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel5.setText("UF");

        txtUF.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtUF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtUF.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel6.setText("CEP");

        txtCEP.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCEP.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCEP.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel7.setText("Cidade");

        txtCidade.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtCidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCidade.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel8.setText("Número");

        txtNumero.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNumero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumero.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNumero.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel9.setText("Complemento");

        txtComplemento.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtComplemento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtComplemento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtComplemento.setEnabled(false);
        txtComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComplementoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel10.setText("Bairro");

        txtBairro.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtBairro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBairro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtBairro.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel11.setText("Email");

        txtEmail.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtEmail.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel13.setText("Telefone");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel14.setText("Celular");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setText("Cadastrado em");

        jLabel16.setBackground(new java.awt.Color(255, 255, 0));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setText("PRODUTO   ADQUIRIDO");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel17.setText("Número de série");

        txtNSerie.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNSerie.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNSerie.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel18.setText("Produto");

        txtProduto.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProduto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtProduto.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel19.setText("Nota Fiscal");

        txtNotaFiscal.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtNotaFiscal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNotaFiscal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNotaFiscal.setEnabled(false);
        txtNotaFiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaFiscalActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setText("Data de compra");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel23.setText("Observações");

        txtDescricao.setColumns(20);
        txtDescricao.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtDescricao.setRows(5);
        txtDescricao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDescricao.setEnabled(false);
        txtObservacao.setViewportView(txtDescricao);

        try {
            txtDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataCadastro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataCadastro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDataCadastro.setEnabled(false);
        txtDataCadastro.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) - ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTelefone.setEnabled(false);
        txtTelefone.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) - ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCelular.setEnabled(false);
        txtCelular.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        try {
            txtDataCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDataCompra.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDataCompra.setEnabled(false);
        txtDataCompra.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/printer_empty.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/email.png"))); // NOI18N
        jButton1.setText("E-mail");

        javax.swing.GroupLayout conteudoClienteLayout = new javax.swing.GroupLayout(conteudoCliente);
        conteudoCliente.setLayout(conteudoClienteLayout);
        conteudoClienteLayout.setHorizontalGroup(
            conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoClienteLayout.createSequentialGroup()
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addGroup(conteudoClienteLayout.createSequentialGroup()
                                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                                        .addComponent(txtNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addGap(80, 80, 80)
                                        .addComponent(jLabel19)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtDataCompra)))
                            .addGroup(conteudoClienteLayout.createSequentialGroup()
                                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                                        .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, conteudoClienteLayout.createSequentialGroup()
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6))
                                            .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                        .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel1)
                                                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel15)
                                                            .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCPF)
                                            .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(conteudoClienteLayout.createSequentialGroup()
                                            .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel10))
                                                .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(conteudoClienteLayout.createSequentialGroup()
                                            .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addComponent(txtTelefone))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel6))
                                                .addComponent(jLabel14)
                                                .addGroup(conteudoClienteLayout.createSequentialGroup()
                                                    .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, conteudoClienteLayout.createSequentialGroup()
                                                            .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(67, 67, 67)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(conteudoClienteLayout.createSequentialGroup()
                                .addGap(237, 237, 237)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(conteudoClienteLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        conteudoClienteLayout.setVerticalGroup(
            conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conteudoClienteLayout.createSequentialGroup()
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addGap(9, 9, 9)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnImprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(21, 21, 21)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(conteudoClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        jScrollPane1.setViewportView(conteudoCliente);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setText("Pesquisar cliente:");

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/user_edit.png"))); // NOI18N

        tblClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        tblClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        txtLimpar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONES/close.png"))); // NOI18N
        txtLimpar.setText("Limpar pesquisa");
        txtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLimpar)
                .addContainerGap(451, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22))
                    .addComponent(txtLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComplementoActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        pesquisarClientes();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        mostrarItens();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void tblClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblClientesKeyReleased

    private void txtNotaFiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaFiscalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaFiscalActionPerformed

    private void txtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimparActionPerformed
        // TODO add your handling code here:
        limparPesquisa();

    }//GEN-LAST:event_txtLimparActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
             // Imprimir();
                     PrinterJob pj = PrinterJob.getPrinterJob();
        pj.setJobName(" Dados Cliente ");

        pj.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            
            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            
            conteudoCliente.paint(g2);    // o JPanel aqui
            
            return Printable.PAGE_EXISTS;
        });
        if (pj.printDialog() == false) {
            return;
        }

        try {
            pj.print();
        } catch (PrinterException ex) {
            // handle exception
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JPanel conteudoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtDataCadastro;
    private javax.swing.JFormattedTextField txtDataCompra;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JButton txtLimpar;
    private javax.swing.JTextField txtNSerie;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNotaFiscal;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JScrollPane txtObservacao;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtUF;
    // End of variables declaration//GEN-END:variables

    private void System(String cls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
