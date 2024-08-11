package com.gerenciador_de_tarefas.entity;

import jakarta.persistence.*;

import java.util.List;
import java.io.Serializable;

/**
 * Com @Entity definimos a classe como entidade do banco de dados
 * Com @Table definimos o nome da table no banco de dados
 */
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Com @GeneratedValue após @Id definimos a estratégia para geração do ID; nesse caso será
     * do tipo sequencial.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, length = 50)
    private String username;

    @Column(unique = true, length = 50)
    private String password;

    /**
     * Define que a classe Usuario (atual) pode ter muitas permissões [@ManyToMany]
     *
     * @JoinTable = define o nome da tabela de junção que será criada no banco de dados para armazenar
     * as relações acima definidas, a tabela se chamará "usuarios_roles"
     *
     * 'joinColumns' = Define a coluna na tabela de junção que se refere à chave primária da entidade
     * principal (neste caso, a entidade que possui a anotação @ManyToMany).
     *
     * 'inverseJoinColumns' = Define a coluna na tabela de junção que se refere à chave primária da
     * entidade associada (neste caso, a entidade relacionada, como papéis/roles).
     *
     * 'uniqueConstraints' = Adiciona uma restrição de unicidade à tabela de junção para garantir que
     * não existam duplicatas na combinação de usuario_id e role_id. Isso garante que cada combinação
     * de usuário e papel seja única.
     */
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "role_id"}))
    private List<Role> roles;
}
