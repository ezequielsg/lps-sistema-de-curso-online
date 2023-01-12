package br.com.ezequiellabs.curso_online.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@AllArgsConstructor
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Module> modules;

    public Course() {
        this.id = -1;
        this.title = "";       
        this.author = "";
        
        this.modules = new ArrayList<>();

    }        

}
