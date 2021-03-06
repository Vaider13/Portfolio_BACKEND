package com.proyecto.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.portfolio.security.model.Usuario;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String fecha_nacimiento;
    @NotNull
    private String telefono;
    @NotNull
    private String titulo;
    @NotNull
    private String acerca_de;
    private String urlAvatar;
    private String urlBanner;
    //Relacion uno a uno entre la clase "Usuario" y "Persona"
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    //Relacion muchos a uno entre la clase "Localidad" y "Persona"
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;
    //Relacion uno a muchos entre la clase "Persona" y "Educacion".
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<Educacion> educaciones;
    //Relacion uno a muchos entre la clase "Persona" y "Experiencia Laboral".
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<ExperienciaLaboral> experienciaLaboral;
    //Relacion uno a muchos entre la clase "Persona" y "Proyecto".
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<Proyecto> proyecto;
    //Relacion uno a muchos entre la clase "Persona" y "Skill".
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<Skill> skill;
    //Relacion uno a uno entre la clase "Persona" y "Red Social".
    @JsonIgnore
    @OneToOne(mappedBy = "persona", cascade = CascadeType.MERGE)
    private RedSocial redes;
     //Relacion uno a uno entre la clase "Persona" y "Experiencia Idioma".
    @JsonIgnore
    @OneToMany(mappedBy = "persona", cascade = CascadeType.MERGE)
    private List<ExperienciaIdioma> experienciaIdioma;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellido, String fecha_nacimiento, String telefono, String titulo, String acerca_de, String urlAvatar, String urlBanner, Usuario usuario, Localidad localidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.titulo = titulo;
        this.acerca_de = acerca_de;
        this.urlAvatar = urlAvatar;
        this.urlBanner = urlBanner;
        this.usuario = usuario;
        this.localidad = localidad;
    }

}
