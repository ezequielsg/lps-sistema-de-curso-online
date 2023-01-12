package br.com.ezequiellabs.curso_online.controller;

import br.com.ezequiellabs.curso_online.model.User;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TMCadUser extends AbstractTableModel {

    private List<User> lista;
    
    private final int COL_NAME = 0;   
    private final int COL_EMAIL = 1;    

    public TMCadUser(List<User> lst) {        
        lista = lst;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        User aux = new User();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_NAME:
                    return aux.getName();
                case COL_EMAIL:
                    return aux.getEmail();
                 
               
                default: 
                    break;
            }
        }
        return aux;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        
        switch (column) {
            case COL_NAME:
                return "Name";
            case COL_EMAIL:
                return "E-mail";
                        
            default:
                break;
        }

        return "";
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }

}
