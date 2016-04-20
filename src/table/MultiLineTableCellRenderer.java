/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Ashraf Atef
 */
public class MultiLineTableCellRenderer extends JTextArea
        implements TableCellRenderer {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private List<List<Integer>> rowColHeight = new ArrayList<List<Integer>>();
    Font font;

    public MultiLineTableCellRenderer(JTable table) {

        this.font = font;
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);

        JTableHeader header;
        header = table.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        //https://community.oracle.com/thread/1352240?start=0&tstart=0
        header.setBackground(Color.white);
        header.setForeground(new java.awt.Color(72, 72, 72));
        header.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 17));
        DefaultTableCellRenderer renderer;
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        table.setShowGrid(false);
        // table.setBackground(Color.red);
        //table.setGridColor(new Color(234, 183, 55));
        table.setRowHeight(25);

        table.setBackground(Color.white);

       // table.setOpaque(true);
        table.setFillsViewportHeight(true);

       

        setFont(new java.awt.Font("Tahoma", 0, 16));
        setBackground(Color.WHITE);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        //  http://stackoverflow.com/questions/17188117/i-would-like-to-add-a-right-padding-to-a-jtable-column-is-it-possible
        setBorder(BorderFactory.createEmptyBorder(3, 5, 0, 5));
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {

//    
//       
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
//        for (int i = 0; i < table.getColumnCount(); i++) {
//            table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
//        }
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }

        if (value != null) {
            setText(value.toString());
        } else {
            setText("");
        }
        adjustRowHeight(table, row, column);
        return this;
    }

    /**
     * Calculate the new preferred height for a given row, and sets the height
     * on the table.
     */
    private void adjustRowHeight(JTable table, int row, int column) {
  //The trick to get this to work properly is to set the width of the column to the 
        //textarea. The reason for this is that getPreferredSize(), without a width tries 
        //to place all the text in one line. By setting the size with the with of the column, 
        //getPreferredSize() returnes the proper height which the row should have in
        //order to make room for the text.

        int cWidth = table.getTableHeader().getColumnModel().getColumn(column).getWidth();
        setSize(new Dimension(cWidth, 1000));

        int prefH = getPreferredSize().height;

        while (rowColHeight.size() <= row) {
            rowColHeight.add(new ArrayList<Integer>(column));
        }
        List<Integer> colHeights = rowColHeight.get(row);
        while (colHeights.size() <= column) {
            colHeights.add(0);
        }
        colHeights.set(column, prefH);
        int maxH = prefH;
        for (Integer colHeight : colHeights) {
            if (colHeight > maxH) {
                maxH = colHeight;
            }
        }
        if (table.getRowHeight(row) != maxH) {
            table.setRowHeight(row, maxH + 5);

        }

    }

}




