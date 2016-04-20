/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseMethods;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import models.*;
import controller.* ;
import java.sql.Time;
import javax.swing.JOptionPane;
import table.*;

/**
 *
 * @author Ashraf Atef
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/fonts/Hacen Saudi Arabia.ttf").openStream());
    int width, height, gap_width , gap_heght;
    JPanel opened_panel=null ;
    Border roundedBorder =null; 
    DatabaseMethods db_ob =new DatabaseMethods();
    InsertData in_ob ;
  
    
    GroupableTableHeader header ;
    DefaultTableModel model_table_cells;
    DefaultTableModel model_doctors;
    DefaultTableModel model_classes;
    DefaultTableModel model_labs;
    DefaultTableModel model_table;
    DefaultTableModel model_table_cell_probabilities;
    DefaultTableModel model_pre_table ;
    DefaultTableModel model_assign_docor ;
    
    public GUI() throws FontFormatException, IOException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        if (height > 768) {
            gap_heght = height - 768;
           
        }
        
        initComponents(); 
        db_ob.connect_to_database();
        in_ob =new InsertData();
        
        setExtendedState(MAXIMIZED_BOTH);
        opened_panel=jPanel_home;
        
        header = (GroupableTableHeader) jTable_table.getTableHeader();
        model_table = (DefaultTableModel) jTable_table.getModel();
        model_table_cells = (DefaultTableModel) jTable_table_cells.getModel();
        model_doctors = (DefaultTableModel) jTable_doctors.getModel();
        model_labs = (DefaultTableModel) jTable_labs.getModel();
        model_classes = (DefaultTableModel) jTable_classes.getModel();
        model_table_cell_probabilities = (DefaultTableModel) jTable_item_probabilites.getModel();
        model_assign_docor = (DefaultTableModel) jTable_assign_doctor.getModel();
        model_pre_table = (DefaultTableModel) jTable_pretable.getModel();
        
      


    }

    
        int rate_animation=10 ;
    void animation(final JPanel panel_in ,final int orignal_height )
  {
 
 // final int width=panel.getWidth() ;
 final JPanel panel=panel_in ;

    

 new Thread()
  {
      public  void  run()
      {
          if (panel.getHeight()>0)
          {
             
             while(panel.getHeight()>0)
             { panel.setSize(new Dimension(panel.getWidth(),panel.getHeight()-rate_animation));
               
           
                 
              try {
                  sleep(1);
              } catch (InterruptedException ex) {
                 
              }
               //  System.out.println("close:"+opened_main_screen.getName());
             
             }
             panel.setSize(new Dimension(panel.getWidth(),0));
          }
          else
          {
            
                while(panel.getHeight()<orignal_height)
             { panel.setSize(new Dimension(panel.getWidth(),panel.getHeight()+rate_animation));
               
              try {
                  sleep(1);
              } catch (InterruptedException ex) {
                 
                    
              }
              
             }
                 panel.setSize(new Dimension(panel.getWidth(),orignal_height));
          }
           
          
      }
  }.start();
 


  }
    int rate_separator=100 ;
  void animate_separator_x(final JPanel panel ,final int orinal_x)
  {
   
   
      new Thread()
      {
          @Override
          public void run()
          {
            
              if (panel.getX()>orinal_x)
              {
                  while(panel.getX()>orinal_x)
                  {
                      panel.setLocation(panel.getX()-rate_separator, panel.getY());
                      
                      try {
                          sleep(1);
                      } catch (InterruptedException ex) {
                          
                      }
                   
                  }
                  
              }
              else
              {
                   while(panel.getX()<orinal_x)
                  {
                      panel.setLocation(panel.getX()+rate_separator, panel.getY());
                      
                         try {
                          sleep(100);
                      } catch (InterruptedException ex) {
                         
                      }
                        
                  }
                   
              }
             panel.setLocation(orinal_x, panel.getY());
          }
      }.start();
   
  
  }
    
    List <TableCell> table =null ;
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_message = new javax.swing.JDialog();
        jPanel_message = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea_mesaage = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jDialog_preprocess = new javax.swing.JDialog();
        jPanel_date = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_date = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel_set_doctors = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_assign_doctor = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_pretable = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r , int rw , int col)
            {
                Component c=super.prepareRenderer( r, rw, col);

                if (model_pre_table.getValueAt(rw, 8)==null||String.valueOf(model_pre_table.getValueAt(rw, 8)).length()==0)
                {
                    c.setBackground(Color.pink);

                }

                return  c ;
            }
        };
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel_wait1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel_table = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_table_cells = new javax.swing.JTable(){
            public Component prepareRenderer(TableCellRenderer r , int rw , int col)
            {
                Component c=super.prepareRenderer( r, rw, col);

                if (model_table_cells.getValueAt(rw, 5)==null||String.valueOf(model_table_cells.getValueAt(rw, 5)).length()==0)
                {
                    c.setBackground(Color.pink);

                }

                return  c ;
            }
        };
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_item_probabilites = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel_main = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel_exit = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel_current_user = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel_reports = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel_reports2 = new javax.swing.JLabel();
        jPanel_design_tables = new javax.swing.JPanel();
        jLayeredPane_design_tables = new javax.swing.JLayeredPane();
        jPanel_table_classes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_classes = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_table = new javax.swing.JTable(){    public Component prepareRenderer(TableCellRenderer r , int rw , int col)
            {
                Component c=super.prepareRenderer( r, rw, col);

                try
                {
                    JOptionPane.showMessageDialog(null, (int)model_table.getValueAt(rw, 1));
                    if ((int)model_table.getValueAt(rw, 1)%2==0)
                    {
                        c.setBackground(new Color(242, 242, 242));
                    }
                    else
                    {
                        c.setBackground(Color.WHITE);
                    }

                }catch (Exception e){JOptionPane.showMessageDialog(null, e.getMessage());}

                return  c ;
            }};
            jPanel_table_doctors = new javax.swing.JPanel();
            jScrollPane9 = new javax.swing.JScrollPane();
            jTable_doctors = new javax.swing.JTable();
            jPanel_table_labs = new javax.swing.JPanel();
            jScrollPane10 = new javax.swing.JScrollPane();
            jTable_labs = new javax.swing.JTable();
            jPanel_insert_data = new javax.swing.JPanel();
            jLabel6 = new javax.swing.JLabel();
            jPanel_home = new javax.swing.JPanel();
            jLabel7 = new javax.swing.JLabel();

            //jDialog1.setSize(400,300);
            jDialog_message.getContentPane().setLayout(null);

            jPanel_message.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_message.setLayout(null);

            jTextArea_mesaage.setColumns(20);
            jTextArea_mesaage.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jTextArea_mesaage.setForeground(new java.awt.Color(51, 51, 51));
            jTextArea_mesaage.setRows(5);
            jTextArea_mesaage.setText("* This table  have values with null so :-\n- delete current table from database for year 2016 .\n- try to create new table again .\n- if it will have null values again , delete some constrains of doctors or\n places .\n- after that try again .");
            jScrollPane6.setViewportView(jTextArea_mesaage);

            jPanel_message.add(jScrollPane6);
            jScrollPane6.setBounds(10, 10, 490, 180);

            jPanel10.setBackground(new java.awt.Color(0, 0, 204));
            jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel10MouseReleased(evt);
                }
            });

            jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel17.setForeground(new java.awt.Color(255, 255, 255));
            jLabel17.setText("Done");

            javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
            jPanel10.setLayout(jPanel10Layout);
            jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addComponent(jLabel17)
                    .addGap(28, 28, 28))
            );
            jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_message.add(jPanel10);
            jPanel10.setBounds(210, 200, 93, 38);
            // the third parameter - true, says it's round
            roundedBorder = new LineBorder(Color.darkGray, 1, true);
            jPanel6.setBorder(roundedBorder);

            jDialog_message.getContentPane().add(jPanel_message);
            jPanel_message.setBounds(0, 0, 530, 250);
            jPanel_message.setBounds((width-510)/2,(height-250)/2, 510, 250);

            jDialog_message.setUndecorated(true);
            jDialog_message.setBackground(new Color(0, 0, 0, 100));
            jDialog_message.setModal(true);
            jDialog_message.setSize(width, height-30);

            jDialog_preprocess.getContentPane().setLayout(null);

            jPanel_date.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_date.setLayout(null);

            jPanel6.setBackground(new java.awt.Color(0, 0, 204));
            jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel6MouseReleased(evt);
                }
            });

            jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel9.setForeground(new java.awt.Color(255, 255, 255));
            jLabel9.setText("Done");

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addGap(29, 29, 29))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_date.add(jPanel6);
            jPanel6.setBounds(300, 150, 93, 38);
            // the third parameter - true, says it's round
            roundedBorder = new LineBorder(Color.darkGray, 1, true);
            jPanel6.setBorder(roundedBorder);

            jPanel7.setBackground(new java.awt.Color(153, 153, 153));
            jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel7MouseReleased(evt);
                }
            });

            jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel8.setForeground(new java.awt.Color(255, 255, 255));
            jLabel8.setText("Cancel");

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(23, 23, 23))
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_date.add(jPanel7);
            jPanel7.setBounds(60, 150, 93, 38);
            roundedBorder = new LineBorder(Color.BLUE, 1, true);
            jPanel7.setBorder(roundedBorder);
            jPanel_date.add(jTextField_date);
            jTextField_date.setBounds(130, 70, 250, 40);
            // the third parameter - true, says it's round
            roundedBorder = new LineBorder(Color.BLUE, 1, true);
            jTextField_date.setBorder(roundedBorder);

            jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel10.setForeground(new java.awt.Color(102, 102, 102));
            jLabel10.setText("Year");
            jPanel_date.add(jLabel10);
            jLabel10.setBounds(80, 70, 40, 40);

            jDialog_preprocess.getContentPane().add(jPanel_date);
            jPanel_date.setBounds(391, 182, 450, 200);
            jPanel_date.setBounds((width-450)/2, (height-350)/2, 450, 200);
            jPanel_date.setVisible(false);

            jPanel_set_doctors.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_set_doctors.setLayout(null);

            jTable_assign_doctor.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "Doctor Id", "Doctor Name", "Status"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane4.setViewportView(jTable_assign_doctor);
            jTable_assign_doctor.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_assign_doctor));
            jTable_assign_doctor.getColumnModel().getColumn(0).setPreferredWidth(35);

            jPanel_set_doctors.add(jScrollPane4);
            jScrollPane4.setBounds(920, 40, 320, 402);

            jTable_pretable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Course Id", "Course Name", "From Secton", "To Secton", "Class Id", "Class Name", "Type", "Doctor Id", "Doctor Name", "Status"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, true, false, false, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jTable_pretable.setSelectionForeground(new java.awt.Color(0, 0, 204));
            jScrollPane5.setViewportView(jTable_pretable);
            jTable_pretable.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_pretable));

            jPanel_set_doctors.add(jScrollPane5);
            jScrollPane5.setBounds(10, 40, 850, 400);

            jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/Previous_2-48.png"))); // NOI18N
            jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jLabel11MouseReleased(evt);
                }
            });
            jPanel_set_doctors.add(jLabel11);
            jLabel11.setBounds(865, 220, 50, 60);

            jPanel8.setBackground(new java.awt.Color(0, 0, 204));
            jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel8MouseReleased(evt);
                }
            });

            jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel12.setForeground(new java.awt.Color(255, 255, 255));
            jLabel12.setText("Done");

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel12)
                    .addContainerGap(32, Short.MAX_VALUE))
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_set_doctors.add(jPanel8);
            jPanel8.setBounds(700, 450, 93, 38);
            // the third parameter - true, says it's round
            roundedBorder = new LineBorder(Color.darkGray, 1, true);
            jPanel6.setBorder(roundedBorder);

            jPanel9.setBackground(new java.awt.Color(153, 153, 153));
            jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel9MouseReleased(evt);
                }
            });

            jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel13.setForeground(new java.awt.Color(255, 255, 255));
            jLabel13.setText("Cancel");

            javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
            jPanel9.setLayout(jPanel9Layout);
            jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(23, 23, 23))
            );
            jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_set_doctors.add(jPanel9);
            jPanel9.setBounds(460, 450, 93, 38);
            roundedBorder = new LineBorder(Color.BLUE, 1, true);
            jPanel7.setBorder(roundedBorder);

            jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
            jCheckBox1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
            jCheckBox1.setForeground(new java.awt.Color(51, 51, 51));
            jCheckBox1.setText("Random Mood");
            jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox1ActionPerformed(evt);
                }
            });
            jPanel_set_doctors.add(jCheckBox1);
            jCheckBox1.setBounds(1110, 470, 120, 23);

            jDialog_preprocess.getContentPane().add(jPanel_set_doctors);
            jPanel_set_doctors.setBounds(0, 0, 0, 0);
            jPanel_set_doctors.setBounds((width-1250)/2, (height-500)/2, 1250, 500);
            jPanel_set_doctors.setVisible(false);

            jPanel_wait1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_wait1.setLayout(null);

            jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
            jLabel14.setForeground(new java.awt.Color(51, 51, 51));
            jLabel14.setText("Please Wait .......");
            jPanel_wait1.add(jLabel14);
            jLabel14.setBounds(117, 179, 290, 55);

            jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/hour-glass.png"))); // NOI18N
            jPanel_wait1.add(jLabel15);
            jLabel15.setBounds(190, 11, 141, 162);

            jDialog_preprocess.getContentPane().add(jPanel_wait1);
            jPanel_wait1.setBounds(430, 160, 0, 250);
            jPanel_wait1.setBounds((width-500)/2, (height-250)/2, 500, 250);
            jPanel_wait1.setVisible(false);

            jPanel_table.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_table.setLayout(null);

            jTable_table_cells.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "Class Name", "From Section", "To Section", "Type", "Doctor Name", "Place Name", "Day", "From", "To", "CourseName"
                }
            ));
            jTable_table_cells.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTable_table_cellsMouseReleased(evt);
                }
            });
            jScrollPane7.setViewportView(jTable_table_cells);
            jTable_table_cells.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_table_cells));
            jTable_table_cells.setSelectionForeground (Color.BLUE);

            jPanel_table.add(jScrollPane7);
            jScrollPane7.setBounds(10, 11, 1230, 220);

            jTable_item_probabilites.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {
                    "Place Name", "Day", "From", "To", "mode"
                }
            ));
            jScrollPane8.setViewportView(jTable_item_probabilites);
            jTable_item_probabilites.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_item_probabilites));

            jPanel_table.add(jScrollPane8);
            jScrollPane8.setBounds(10, 280, 1230, 160);

            jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel16.setForeground(new java.awt.Color(51, 51, 51));
            jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel16.setText("Item probabilities");
            jPanel_table.add(jLabel16);
            jLabel16.setBounds(330, 230, 560, 50);

            jPanel11.setBackground(new java.awt.Color(0, 0, 204));
            jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel11MouseReleased(evt);
                }
            });

            jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
            jLabel18.setForeground(new java.awt.Color(255, 255, 255));
            jLabel18.setText("Done");

            javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
            jPanel11.setLayout(jPanel11Layout);
            jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                    .addContainerGap(31, Short.MAX_VALUE)
                    .addComponent(jLabel18)
                    .addGap(28, 28, 28))
            );
            jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            );

            jPanel_table.add(jPanel11);
            jPanel11.setBounds(560, 450, 93, 38);
            // the third parameter - true, says it's round
            roundedBorder = new LineBorder(Color.darkGray, 1, true);
            jPanel6.setBorder(roundedBorder);

            jDialog_preprocess.getContentPane().add(jPanel_table);
            jPanel_table.setBounds(0, 0, 0, 0);
            jPanel_table.setBounds((width-1250)/2, (height-500)/2, 1250, 500);
            jPanel_table.setVisible(false);

            jDialog_preprocess.setUndecorated(true);
            jDialog_preprocess.setBackground(new Color(0, 0, 0, 100));
            jDialog_preprocess.setModal(true);
            jDialog_preprocess.setSize(width, height-30);

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(new java.awt.CardLayout());

            jPanel_main.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_main.setLayout(null);

            jLayeredPane1.setOpaque(true);

            jPanel13.setBackground(new java.awt.Color(74, 74, 74));

            jPanel16.setBackground(new java.awt.Color(192, 64, 65));
            jPanel16.setPreferredSize(new java.awt.Dimension(81, 30));
            jPanel16.setRequestFocusEnabled(false);
            jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel16MouseReleased(evt);
                }
            });

            jLabel_exit.setFont(font.deriveFont(13f)
            );
            jLabel_exit.setForeground(new java.awt.Color(255, 255, 255));
            jLabel_exit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel_exit.setText("خروج");

            jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/exit.png"))); // NOI18N

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel_exit)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                    .addContainerGap(15, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            jLabel_current_user.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
            jLabel_current_user.setForeground(new java.awt.Color(234, 183, 55));
            jLabel_current_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/userSeek.png"))); // NOI18N
            jLabel_current_user.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jLabel_current_userMouseReleased(evt);
                }
            });

            javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
            jPanel13.setLayout(jPanel13Layout);
            jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(884, 884, 884)
                    .addComponent(jLabel_current_user, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1132, Short.MAX_VALUE))
            );
            jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(jLabel_current_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jLayeredPane1.add(jPanel13);
            jPanel13.setBounds(0, 0, 2320, 40);
            jPanel13.setSize(width,40);

            jPanel23.setBackground(new java.awt.Color(234, 183, 55));
            jPanel23.setLayout(null);

            jLabel_reports.setBackground(new java.awt.Color(255, 255, 255));
            jLabel_reports.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel_reports.setForeground(new java.awt.Color(255, 255, 255));
            jLabel_reports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel_reports.setText("Designing Table");
            jLabel_reports.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jLabel_reportsMouseReleased(evt);
                }
            });
            jPanel23.add(jLabel_reports);
            jLabel_reports.setBounds(260, 20, 160, 22);

            jPanel25.setBackground(new java.awt.Color(227, 60, 67));

            javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
            jPanel25.setLayout(jPanel25Layout);
            jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 30, Short.MAX_VALUE)
            );
            jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 8, Short.MAX_VALUE)
            );

            jPanel23.add(jPanel25);
            jPanel25.setBounds(48, 56, 30, 8);

            jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
            jPanel23.add(jSeparator1);
            jSeparator1.setBounds(80, 10, 10, 38);

            jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/home.png"))); // NOI18N
            jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jLabel34MouseReleased(evt);
                }
            });
            jPanel23.add(jLabel34);
            jLabel34.setBounds(50, 10, 22, 38);

            jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
            jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
            jPanel23.add(jSeparator2);
            jSeparator2.setBounds(250, 10, 10, 38);

            jLabel_reports2.setBackground(new java.awt.Color(255, 255, 255));
            jLabel_reports2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel_reports2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel_reports2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jLabel_reports2.setText("Inserting screen");
            jLabel_reports2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jLabel_reports2MouseReleased(evt);
                }
            });
            jPanel23.add(jLabel_reports2);
            jLabel_reports2.setBounds(90, 20, 160, 22);

            jLayeredPane1.add(jPanel23);
            jPanel23.setBounds(0, 40, 2320, 60);
            jPanel23.setSize(width,60);

            jPanel_design_tables.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_design_tables.setLayout(null);

            jPanel_table_classes.setBackground(new java.awt.Color(255, 255, 255));
            jPanel_table_classes.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(234, 183, 55)));
            jPanel_table_classes.setLayout(null);

            jScrollPane3.setBounds(10, 10, 700, 340);
            jScrollPane3.getViewport().setBackground(Color.WHITE);

            jTable_classes.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
                },
                new String [] {
                    "ID", "Class Name", "Section Number"
                }
            ));
            jTable_classes.setOpaque(false);
            jTable_classes.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jTable_classesMouseReleased(evt);
                }
            });
            jScrollPane3.setViewportView(jTable_classes);
            jTable_classes.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_classes));
            jTable_classes.getColumnModel().getColumn(0).setPreferredWidth(50);

            jPanel_table_classes.add(jScrollPane3);
            jScrollPane3.setBounds(12, 13, 696, 333);

            jLayeredPane_design_tables.add(jPanel_table_classes);
            jPanel_table_classes.setBounds(250, 55, 720, 0);
            jPanel_table_classes.setBounds((width-720)/2, 55, 720, 0);

            jPanel4.setBackground(new java.awt.Color(255, 255, 255));

            jPanel1.setBackground(new java.awt.Color(234, 67, 53));
            jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel1MouseReleased(evt);
                }
            });

            jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
            jLabel1.setText("Classes");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(74, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(76, 76, 76))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel2.setBackground(new java.awt.Color(66, 133, 244));
            jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel2MouseReleased(evt);
                }
            });

            jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 255, 255));
            jLabel2.setText("Doctors");

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(74, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(76, 76, 76))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel3.setBackground(new java.awt.Color(52, 168, 83));
            jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    jPanel3MouseReleased(evt);
                }
            });

            jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
            jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Labs");

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(92, 92, 92))
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
            jPanel4.setLayout(jPanel4Layout);
            jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE))
            );
            jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            jLayeredPane_design_tables.add(jPanel4);
            jPanel4.setBounds(250, 10, 720, 40);
            jPanel4.setBounds((width-720)/2, 5, 720, 40);

            jPanel5.setBackground(new java.awt.Color(255, 255, 255));

            jScrollPane2.setSize(1400,height-250);
            jScrollPane2.getViewport().setBackground(Color.WHITE);

            DefaultTableModel dm = new DefaultTableModel();
            dm.setDataVector(new Object[][]{
            },
            new Object[]{"G", "S", "9:00-11:30", "11:30-14:00", "14:00-16:30",
                "9:00-11:30", "11:30-14:00", "14:00-16:30",
                "9:00-11:30", "11:30-14:00", "14:00-16:30",
                "9:00-11:30", "11:30-14:00", "14:00-16:30",
                "9:00-11:30", "11:30-14:00", "14:00-16:30",
                "9:00-11:30", "11:30-14:00", "14:00-16:30"});
        jTable_table.setModel(dm);
        jTable_table = new JTable(dm) {
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };

        TableColumnModel cm = jTable_table.getColumnModel();

        ColumnGroup g_Section = new ColumnGroup("#");
        ColumnGroup g_Saturday = new ColumnGroup("SATURDAY");
        ColumnGroup g_Sunday = new ColumnGroup("SUNDAY");
        ColumnGroup g_Monday = new ColumnGroup("MONDAY");
        ColumnGroup g_Tuseday = new ColumnGroup("TUESDAY");
        ColumnGroup g_Wensday = new ColumnGroup("WEDNESDAY");
        ColumnGroup g_Tursday = new ColumnGroup("THURSDAY");

        g_Section.add(cm.getColumn(0));
        g_Section.add(cm.getColumn(1));
        g_Saturday.add(cm.getColumn(2));
        g_Saturday.add(cm.getColumn(3));
        g_Saturday.add(cm.getColumn(4));

        g_Sunday.add(cm.getColumn(5));
        g_Sunday.add(cm.getColumn(6));
        g_Sunday.add(cm.getColumn(7));

        g_Monday.add(cm.getColumn(8));
        g_Monday.add(cm.getColumn(9));
        g_Monday.add(cm.getColumn(10));

        g_Tuseday.add(cm.getColumn(11));
        g_Tuseday.add(cm.getColumn(12));
        g_Tuseday.add(cm.getColumn(13));

        g_Wensday.add(cm.getColumn(14));
        g_Wensday.add(cm.getColumn(15));
        g_Wensday.add(cm.getColumn(16));

        g_Tursday.add(cm.getColumn(17));
        g_Tursday.add(cm.getColumn(18));
        g_Tursday.add(cm.getColumn(19));
        jTable_table.getColumnModel().getColumn(0).setPreferredWidth(20);
        jTable_table.getColumnModel().getColumn(1).setPreferredWidth(20);
        GroupableTableHeader header = (GroupableTableHeader) jTable_table.getTableHeader();

        header.addColumnGroup(g_Section);
        header.addColumnGroup(g_Saturday);
        header.addColumnGroup(g_Saturday);
        header.addColumnGroup(g_Sunday);
        header.addColumnGroup(g_Monday);
        header.addColumnGroup(g_Tuseday);
        header.addColumnGroup(g_Wensday);
        header.addColumnGroup(g_Tursday);

        //  jTable_table.setBackground(Color.white);
        jTable_table.setFont(new java.awt.Font("Tahoma", 0, 14));
        header.setBackground(Color.white);
        jTable_table.setGridColor(Color.black);
        jTable_table.setOpaque(false);
        jScrollPane2.setViewportView(jTable_table);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i=0 ; i<jTable_table.getColumnCount() ; i++)
        jTable_table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel5);
        jPanel5.setSize(1400,height-250);

        jLayeredPane_design_tables.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 1260, 400);
        jScrollPane1.setBounds(10, 60, width-20, height-250);

        jPanel_table_doctors.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_table_doctors.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(234, 183, 55)));
        jPanel_table_doctors.setLayout(null);

        jScrollPane3.setBounds(10, 10, 700, 340);
        jScrollPane3.getViewport().setBackground(Color.WHITE);

        jTable_doctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jTable_doctors.setOpaque(false);
        jScrollPane9.setViewportView(jTable_doctors);
        jTable_doctors.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_doctors));
        jTable_doctors.getColumnModel().getColumn(0).setPreferredWidth(50);

        jPanel_table_doctors.add(jScrollPane9);
        jScrollPane9.setBounds(12, 13, 696, 333);

        jLayeredPane_design_tables.add(jPanel_table_doctors);
        jPanel_table_doctors.setBounds(250, 55, 720, 0);
        jPanel_table_doctors.setBounds((width-720)/2, 55, 720, 0);

        jPanel_table_labs.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_table_labs.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(234, 183, 55)));
        jPanel_table_labs.setLayout(null);

        jScrollPane3.setBounds(10, 10, 700, 340);
        jScrollPane3.getViewport().setBackground(Color.WHITE);

        jTable_labs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jTable_labs.setOpaque(false);
        jScrollPane10.setViewportView(jTable_labs);
        jTable_labs.setDefaultRenderer(Object.class, new MultiLineTableCellRenderer(jTable_labs));
        jTable_labs.getColumnModel().getColumn(0).setPreferredWidth(50);

        jPanel_table_labs.add(jScrollPane10);
        jScrollPane10.setBounds(12, 13, 696, 333);

        jLayeredPane_design_tables.add(jPanel_table_labs);
        jPanel_table_labs.setBounds(250, 55, 720, 0);
        jPanel_table_labs.setBounds((width-720)/2, 55, 720, 0);

        jPanel_design_tables.add(jLayeredPane_design_tables);
        jLayeredPane_design_tables.setBounds(0, 0, 1400, 700);
        jLayeredPane_design_tables.setBounds(0, 0, width, height);
        jLayeredPane_design_tables.add(jPanel4, new Integer(0), 0);
        jLayeredPane_design_tables.add(jScrollPane1, new Integer(1), 0);
        jLayeredPane_design_tables.add(jPanel_table_classes, new Integer(2), 0);
        jLayeredPane_design_tables.add(jPanel_table_doctors, new Integer(2), 0);
        jLayeredPane_design_tables.add(jPanel_table_labs, new Integer(2), 0);

        //jLayeredPane_design_tables.add(jPanel_preprocess, new Integer(3), 0);

        jLayeredPane1.add(jPanel_design_tables);
        jPanel_design_tables.setBounds(0, 100, 1450, 700);
        jPanel_design_tables.setBounds(0, 100, width, 0);

        jPanel_insert_data.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Soon ....");

        javax.swing.GroupLayout jPanel_insert_dataLayout = new javax.swing.GroupLayout(jPanel_insert_data);
        jPanel_insert_data.setLayout(jPanel_insert_dataLayout);
        jPanel_insert_dataLayout.setHorizontalGroup(
            jPanel_insert_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_insert_dataLayout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(254, 254, 254))
        );
        jPanel_insert_dataLayout.setVerticalGroup(
            jPanel_insert_dataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_insert_dataLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel_insert_data);
        jPanel_insert_data.setBounds(0, 0, 1326, 585);
        jPanel_insert_data.setBounds(0, 100, width, 0);

        jPanel_home.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_home.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ph/icons/application-vnd.ms-excel.png"))); // NOI18N
        jPanel_home.add(jLabel7);
        jLabel7.setBounds(519, 254, 128, 136);
        jLabel7.setBounds((width-128)/2, (height-228)/2, 128, 128);

        jLayeredPane1.add(jPanel_home);
        jPanel_home.setBounds(0, 0, 0, 0);
        jPanel_home.setBounds(0, 0, width, height);

        jPanel_main.add(jLayeredPane1);
        jLayeredPane1.setBounds(0, 0, 1400, 700);
        jLayeredPane1.setSize(width, height);

        getContentPane().add(jPanel_main, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_reportsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_reportsMouseReleased

        if (opened_panel.getHeight()>=height&&opened_panel!=jPanel_design_tables)
   {
     
       
       animation(opened_panel, height);
       
       animation(jPanel_design_tables , height);
       opened_panel=jPanel_design_tables ;
       animate_separator_x(jPanel25, 260);
       jPanel25.setSize(150,8);
       jPanel_date.setVisible(true);
       jDialog_preprocess.setVisible(true);
       
       model_table.setRowCount(0);
       jCheckBox1.setSelected(false);
   }
    }//GEN-LAST:event_jLabel_reportsMouseReleased

    private void jLabel34MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseReleased

        if (opened_panel.getHeight()>=height&&opened_panel!=jPanel_home)
   {
       
       
       animation(opened_panel, height);
       animation(jPanel_home , height);
       opened_panel=jPanel_home ;
       animate_separator_x(jPanel25, 48);
       jPanel25.setSize(30,8);
   }   
    }//GEN-LAST:event_jLabel34MouseReleased

    private void jPanel16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseReleased

    }//GEN-LAST:event_jPanel16MouseReleased

    private void jLabel_current_userMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_current_userMouseReleased

    }//GEN-LAST:event_jLabel_current_userMouseReleased

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
          animation(jPanel_table_classes, 359);
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseReleased
        animation(jPanel_table_doctors, 359);
     
    }//GEN-LAST:event_jPanel2MouseReleased

    private void jPanel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseReleased
        animation(jPanel_table_labs, 359);
    }//GEN-LAST:event_jPanel3MouseReleased

    private void jLabel_reports2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_reports2MouseReleased
       
        if (opened_panel.getHeight()>=height&&opened_panel!=jPanel_insert_data)
   {
     
       
       animation(opened_panel, height);
       animation(jPanel_insert_data , height);
       opened_panel=jPanel_insert_data ;
       animate_separator_x(jPanel25, 90);
       jPanel25.setSize(150, 8);
   }
    }//GEN-LAST:event_jLabel_reports2MouseReleased
 boolean flag_full_table=true ;
 boolean check_null_with_table()
{
    for (int i=0 ; i<table.size() ; i++)
                {
                    if (table.get(i).getPlace()==null)
                    {
                        return false ;
                    }
                }
    return true ;
}
 void display_table_class(int ClassId , int class_section_number , int max_section_group)
 {
     
     model_table.setRowCount(0);
    
   for (int i=1 ; i<=class_section_number ; i++)
   {
 
       model_table.addRow(new Object[]{(int)(Math.ceil((double)(i)/(double)(max_section_group))) , i});
       model_table.addRow(new Object[]{(int)(Math.ceil((double)(i)/(double)(max_section_group))) , i});
       model_table.addRow(new Object[]{(int)(Math.ceil((double)(i)/(double)(max_section_group))) , i});
   }
     
     
     
     
     for (int i= 0 ; i<table.size() ; i++)
     {
         if (table.get(i).getMclass().getClassId()==ClassId)
         {
             for (int v=0 ; v<jTable_table.getColumnCount() ; v++)
             {
                 //JOptionPane.showMessageDialog(null,table.get(i).getDay() +" "+header.getColumnGroups(jTable_table.getColumnModel().getColumn(v)).get(0).getHeaderValue());
                 if (table.get(i).getDay().equals(header.getColumnGroups(jTable_table.getColumnModel().getColumn(v)).get(0).getHeaderValue()))
                 {
                     String times[]=jTable_table.getColumnName(v).split("-");
                     
                    if( in_ob.TimeCompare(table.get(i).getStartTime(), table.get(i).getEndTime(),
                      in_ob.convert_string_to_time(times[0]), in_ob.convert_string_to_time(times[1])))
                    {
                        for (int iv=table.get(i).getStartSection() ; iv<=table.get(i).getEndSection() ; iv++)
                        {
                             model_table.setValueAt(table.get(i).getCourse().getCourseName(), ((iv-1)*3)+0, v);
                             model_table.setValueAt(table.get(i).getDoctor().getDoctorName(), ((iv-1)*3)+1, v);
                             model_table.setValueAt(table.get(i).getPlace().getPlaceName(), ((iv-1)*3)+2  , v);
                        }
                      
                    }
                 }
             }
         }
     }
 }
   List<Doctor> doctors=null;
   List<models.Class> classes=null;
   List<Place> labs=null;
 void display_types()
 {
    doctors=db_ob.getalltDoctors();
    model_doctors.setRowCount(0);
     for (int i=0 ; i<doctors.size() ; i++)
     {
         
         model_doctors.addRow(new Object[]{doctors.get(i).getDoctorId(),doctors.get(i).getDoctorName()});
     }
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     classes=db_ob.GetClasses() ;
    model_classes.setRowCount(0);
     for (int i=0 ; i<classes.size() ; i++)
     {
         
         model_classes.addRow(new Object[]{classes.get(i).getClassId(),classes.get(i).getClassName(),classes.get(i).getClass_Section_Number()});
     }
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
     
      labs=db_ob.getplaces() ;
     model_labs.setRowCount(0);
     for (int i=0 ; i<labs.size() ; i++)
     {
         
         model_labs.addRow(new Object[]{labs.get(i).getPlaceId(),labs.get(i).getPlaceName()});
     }
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
     
 }
 void diplay_table_cells()
 {
       model_table_cells.setRowCount(0);
      model_table_cell_probabilities.setRowCount(0);
      String place_name=null;
     
                   for (int i=0 ; i<table.size() ; i++)
                   {
                          place_name=null;
                        if (table.get(i).getPlace()!=null) place_name=table.get(i).getPlace().getPlaceName() ;
                            
                       model_table_cells.addRow(new Object[]{table.get(i).getMclass().getClassName(),table.get(i).getStartSection(),
                       table.get(i).getEndSection() , table.get(i).getType() ,table.get(i).getDoctor().getDoctorName() ,
                              place_name
                               , table.get(i).getDay() ,
                               table.get(i).getStartTime() , 
                               table.get(i).getEndTime(),
                         table.get(i).getCourse().getCourseName()});
                   }
 }
 public void make_alarm_null_with_table(String Text)
 {
    
                   diplay_table_cells();
                   jPanel_wait1.setVisible(false);
                   jTextArea_mesaage.setText(Text);
                   jDialog_message.setVisible(true);
                   jPanel_table.setVisible(true);
 }
    private void jPanel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseReleased
    
        if (db_ob.check_int(jTextField_date.getText()))
        {
            jTextField_date.setBackground(Color.white);
            jPanel_date.setVisible(false);
            jPanel_wait1.setVisible(true);
            
            table=db_ob.gettable(jTextField_date.getText());
            if (table.size()>0)
            {
                flag_full_table=check_null_with_table() ;
               
               if (flag_full_table==true)
               {
                  
                   display_types();
                   jPanel_wait1.setVisible(false);
                   jDialog_preprocess.setVisible(false);
               }
               else
               {
              
                  make_alarm_null_with_table("* This table  have values with null so :-\n"
                           + "- delete current table from database for year "+jTextField_date.getText()+" .\n"
                           + "- try to create new table again .\n"
                           + "- if it will have null values again , delete some constrains of doctors or\n"
                           + " places .\n"
                           + "- after that try again .");
               }
               
               
            }
            
            else
            {
                
                 in_ob.insert();
                 model_assign_docor.setRowCount(0);
                 for (int i=0 ; i<in_ob.List_doctors.size() ; i++)
                 {
                     
                     model_assign_docor.addRow(new Object[]{in_ob.List_doctors.get(i).getDoctorId() 
                             , in_ob.List_doctors.get(i).getDoctorName() , in_ob.List_doctors.get(i).getDoctorStatus()});
                 }
                 for (int i=0 ; i<in_ob.List_mo3id.size() ; i++)
                 {
                     
                     model_assign_docor.addRow(new Object[]{in_ob.List_mo3id.get(i).getDoctorId() 
                             , in_ob.List_mo3id.get(i).getDoctorName() , in_ob.List_mo3id.get(i).getDoctorStatus()});
                 }
                 model_pre_table.setRowCount(0);
                 for (int i=0 ; i<in_ob.table.size() ; i++)
                 {
                     
                     model_pre_table.addRow(new Object[]{in_ob.table.get(i).getCourse().getCourseId(),in_ob.table.get(i).getCourse().getCourseName()
                     ,in_ob.table.get(i).getStartSection() , in_ob.table.get(i).getEndSection(), in_ob.table.get(i).getMclass().getClassId()
                     , in_ob.table.get(i).getMclass().getClassName(), in_ob.table.get(i).getType() });
                 }
                 jPanel_wait1.setVisible(false);
                jPanel_set_doctors.setVisible(true);
                
            }
            
          
            
            
            
        }
        else
        {
            jTextField_date.setBackground(Color.pink);
        }
       
    }//GEN-LAST:event_jPanel6MouseReleased

    private void jPanel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseReleased
       jDialog_preprocess.setVisible(false);
       jPanel_date.setVisible(false);
       animation(opened_panel, height);
       animation(jPanel_home , height);
       opened_panel=jPanel_home ;
       animate_separator_x(jPanel25, 48);
       jPanel25.setSize(30,8);
    }//GEN-LAST:event_jPanel7MouseReleased

    private void jPanel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseReleased
    boolean flag=true ;
    for (int i=0 ; i<model_pre_table.getRowCount() ; i++)
    {
        if (model_pre_table.getValueAt(i, 8)==null ||String.valueOf(model_pre_table.getValueAt(i, 8)).length()==0)
        {
            flag=false ;
            break ;
        }
    }
    if (flag==true)
    {
        
      jPanel_set_doctors.setVisible(false);
      jPanel_wait1.setVisible(true);
        for (int i=0 ; i<model_pre_table.getRowCount() ; i++)
         {
           if (String.valueOf(model_pre_table.getValueAt(i, 9)).equals("Doctor"))
           {
              in_ob.table.get(i).setDoctor(in_ob.get_doctor_from_list((int)model_pre_table.getValueAt(i, 7)));
           }
           else
           {
                in_ob.table.get(i).setDoctor(in_ob.get_mo3id_from_list((int)model_pre_table.getValueAt(i, 7)));
           }
         }
        
        table=in_ob.insert2();
       
        
        flag_full_table=check_null_with_table();
        if (flag_full_table==true)
        {
             insert_types2();
            
            //jDialog_preprocess.setVisible(false);
             jPanel_wait1.setVisible(false);
             jPanel_table.setVisible(true);
             diplay_table_cells();
        }
        else
        {
            make_alarm_null_with_table("* This table  have values with null so :-\n"
                           +"delete some constrains of doctors or places .\n"
                           + "- try to create new table again .\n"
                          );
            
        }
   
      
     
    }
    else
    {
        jTextArea_mesaage.setText("Please fill pink rows :(");
        jDialog_message.setVisible(true);
    }
    }//GEN-LAST:event_jPanel8MouseReleased
void insert_types2()
{ model_classes.setRowCount(0);
    for (int i=0 ; i<in_ob.ListClass.size() ; i++)
    {
       
        model_classes.addRow(new Object[]{in_ob.ListClass.get(i).getClassId(),in_ob.ListClass.get(i).getClassName(),
            in_ob.ListClass.get(i).getClass_Section_Number()});
    }
}
    private void jPanel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseReleased
        jDialog_preprocess.setVisible(false);
       jPanel_set_doctors.setVisible(false);
       animation(opened_panel, height);
       animation(jPanel_home , height);
       opened_panel=jPanel_home ;
       animate_separator_x(jPanel25, 48);
       jPanel25.setSize(30,8);
    }//GEN-LAST:event_jPanel9MouseReleased

    private void jPanel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseReleased
      jDialog_message.setVisible(false);
    }//GEN-LAST:event_jPanel10MouseReleased

    private void jPanel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseReleased
      jDialog_preprocess.setVisible(false);
       jPanel_table.setVisible(false);
        if (flag_full_table==false)
      {
       
       animation(opened_panel, height);
       animation(jPanel_home , height);
       opened_panel=jPanel_home ;
       animate_separator_x(jPanel25, 48);
       jPanel25.setSize(30,8);
      }
      
    }//GEN-LAST:event_jPanel11MouseReleased

    private void jTable_table_cellsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_table_cellsMouseReleased
    if (jTable_table_cells.getSelectedRow()!=-1)
    {
        
        model_table_cell_probabilities.setRowCount(0);
      for (int i=0 ; i<table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places().size() ; i++)
      {
          model_table_cell_probabilities.addRow(new Object[]{
              table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places().get(i).getPlace().getPlaceName() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places().get(i).getDay() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places().get(i).getFrom() ,
                table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places().get(i).getTo() ,
                 "Good"
          });
      }
      for (int i=0 ; i<table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_generality().size() ; i++)
      {
          model_table_cell_probabilities.addRow(new Object[]{
              table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_generality().get(i).getPlace().getPlaceName() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_generality().get(i).getDay() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_generality().get(i).getFrom() ,
                table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_generality().get(i).getTo() ,
                 "Bad Mood Place Generality"
          });
      }
      for (int i=0 ; i<table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_number().size() ; i++)
      {
          model_table_cell_probabilities.addRow(new Object[]{
              table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_number().get(i).getPlace().getPlaceName() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_number().get(i).getDay() ,
               table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_number().get(i).getFrom() ,
                table.get(jTable_table_cells.getSelectedRow()).getPossible_prpbability_places_bad_mood_places_number().get(i).getTo() ,
                 "Bad Mood Place Number"
          });
      }
    }
    }//GEN-LAST:event_jTable_table_cellsMouseReleased

    private void jTable_classesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_classesMouseReleased
        animation(jPanel_table_classes, 359);
        display_table_class((int)model_classes.getValueAt(jTable_classes.getSelectedRow(), 0), 
                (int)model_classes.getValueAt(jTable_classes.getSelectedRow(), 2), in_ob.GINFO.getMaxGroupNumber());
    }//GEN-LAST:event_jTable_classesMouseReleased

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
       if (jTable_pretable.getSelectedRow()!=-1&&jTable_assign_doctor.getSelectedRow()!=-1)
       {
           model_pre_table.setValueAt(model_assign_docor.getValueAt(jTable_assign_doctor.getSelectedRow(), 0), jTable_pretable.getSelectedRow(), 7);
           model_pre_table.setValueAt(model_assign_docor.getValueAt(jTable_assign_doctor.getSelectedRow(), 1), jTable_pretable.getSelectedRow(), 8);
           model_pre_table.setValueAt(model_assign_docor.getValueAt(jTable_assign_doctor.getSelectedRow(), 2), jTable_pretable.getSelectedRow(), 9);
       }
    }//GEN-LAST:event_jLabel11MouseReleased

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
       if (jCheckBox1.isSelected())
       {
           in_ob.Random_insert();
            model_pre_table.setRowCount(0);
                 for (int i=0 ; i<in_ob.table.size() ; i++)
                 {
                     
                     model_pre_table.addRow(new Object[]{in_ob.table.get(i).getCourse().getCourseId(),in_ob.table.get(i).getCourse().getCourseName()
                     ,in_ob.table.get(i).getStartSection() , in_ob.table.get(i).getEndSection(), in_ob.table.get(i).getMclass().getClassId()
                     , in_ob.table.get(i).getMclass().getClassName(), in_ob.table.get(i).getType() , in_ob.table.get(i).getDoctor().getDoctorId()
                     , in_ob.table.get(i).getDoctor().getDoctorName(), in_ob.table.get(i).getDoctor().getDoctorStatus()});
                 }
       }
       else
       {
            model_pre_table.setRowCount(0);
                 for (int i=0 ; i<in_ob.table.size() ; i++)
                 {
                     
                     model_pre_table.addRow(new Object[]{in_ob.table.get(i).getCourse().getCourseId(),in_ob.table.get(i).getCourse().getCourseName()
                     ,in_ob.table.get(i).getStartSection() , in_ob.table.get(i).getEndSection(), in_ob.table.get(i).getMclass().getClassId()
                     , in_ob.table.get(i).getMclass().getClassName(), in_ob.table.get(i).getType() });
                 }
       }
    }//GEN-LAST:event_jCheckBox1ActionPerformed
  
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                    new GUI().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JDialog jDialog_message;
    private javax.swing.JDialog jDialog_preprocess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabel_current_user;
    private javax.swing.JLabel jLabel_exit;
    public javax.swing.JLabel jLabel_reports;
    public javax.swing.JLabel jLabel_reports2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane_design_tables;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_date;
    private javax.swing.JPanel jPanel_design_tables;
    private javax.swing.JPanel jPanel_home;
    private javax.swing.JPanel jPanel_insert_data;
    private javax.swing.JPanel jPanel_main;
    private javax.swing.JPanel jPanel_message;
    private javax.swing.JPanel jPanel_set_doctors;
    private javax.swing.JPanel jPanel_table;
    private javax.swing.JPanel jPanel_table_classes;
    private javax.swing.JPanel jPanel_table_doctors;
    private javax.swing.JPanel jPanel_table_labs;
    private javax.swing.JPanel jPanel_wait1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable_assign_doctor;
    private javax.swing.JTable jTable_classes;
    private javax.swing.JTable jTable_doctors;
    private javax.swing.JTable jTable_item_probabilites;
    private javax.swing.JTable jTable_labs;
    private javax.swing.JTable jTable_pretable;
    private javax.swing.JTable jTable_table;
    private javax.swing.JTable jTable_table_cells;
    private javax.swing.JTextArea jTextArea_mesaage;
    private javax.swing.JTextField jTextField_date;
    // End of variables declaration//GEN-END:variables

}
