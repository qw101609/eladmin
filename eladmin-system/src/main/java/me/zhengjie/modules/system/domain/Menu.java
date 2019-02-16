package me.zhengjie.modules.system.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2018-12-17
 */
@Entity
@Data
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true)
    private Long sort;

    @Column(name = "path")
    private String path;

    private String component;

    private String icon;

    /**
     * 上级菜单ID
     */
    @Column(name = "pid", nullable = false)
    private Long pid;

    /**
     * 是否为外链 true/false
     */
    @Column(name = "i_frame")
    private Boolean iFrame;

    @ManyToMany
    @JoinTable(name = "menus_roles", joinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;
}
