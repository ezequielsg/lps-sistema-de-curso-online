package br.com.ezequiellabs.curso_online.controller;
import br.com.ezequiellabs.curso_online.model.Lesson;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMCadLesson extends AbstractTableModel {

    private List<Lesson> lista;
    
    private final int COL_TITLE = 0;    

    public TMCadLesson(List<Lesson> lstPage) {        
        lista = lstPage;        
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Lesson aux = new Lesson();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_TITLE:
                    return aux.getTitle();
                 
               
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
            case COL_TITLE:
                return "Título";
                        
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
