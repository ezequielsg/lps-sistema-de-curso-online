package br.com.ezequiellabs.curso_online.controller;
import br.com.ezequiellabs.curso_online.model.Course;
import br.com.ezequiellabs.curso_online.model.User;
import br.com.ezequiellabs.curso_online.model.dao.jpa.CourseDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMCourse extends AbstractTableModel {

    private List<Course> lista;
    
    private final int COL_TITLE = 0;   
    private final int COL_AUTHOR = 1;  
    private final int COL_PROGRESS = 2;   
    
    private User user;
    
    private CourseDAO repositorio;
    private ProgressController progressController;

    public TMCourse(List<Course> lst, User user) {        
        this.lista = lst;   
        this.user = user;
        
        repositorio = new CourseDAO();
        progressController = new ProgressController();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {               
        Course aux = new Course();
        if (lista.isEmpty()) {
            return aux;
        } else {
            aux = lista.get(rowIndex);

            switch (columnIndex) {
                case -1:
                    return aux;
                case COL_TITLE:
                    return aux.getTitle();
                case COL_AUTHOR:
                    return aux.getAuthor();
                case COL_PROGRESS:
                    return progressController.getProgressByCourse(user, aux) + "%";
                 
               
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
            case COL_AUTHOR:
                return "Autor";
            case COL_PROGRESS:
                return "Progresso";
                        
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
