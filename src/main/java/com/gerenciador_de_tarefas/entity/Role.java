package com.gerenciador_de_tarefas.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 20)
    private String nome;

    /**
     * Valor precisar ser o mesmo que o criado na classe USUARIO = private List<Role> roles;'
     */
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}
