/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author u08538003160
 */
@Entity
@Table(name="movimento")
public class MovimentoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String data;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String nf;
    
    @ManyToOne//cardinalidade
    @JoinColumn(name="usuario_id", foreignKey = @ForeignKey(name="fk_usuarioId"), nullable = false)//nome da coluna que armazena o id/nome do fk
    private UsuarioEntity usuatio;
    
    @ManyToOne//cardinalidade
    @JoinColumn(name="fornecedor_id", foreignKey = @ForeignKey(name="fk_fornecedorId"), nullable = false)//nome da coluna que armazena o id/nome do fk
    private FornecedorEntity fornecedor;

    @OneToMany(mappedBy = "movimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovimentoItemEntity> itens = new ArrayList<>();
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nf
     */
    public String getNf() {
        return nf;
    }

    /**
     * @param nf the nf to set
     */
    public void setNf(String nf) {
        this.nf = nf;
    }

    /**
     * @return the usuatio
     */
    public UsuarioEntity getUsuatio() {
        return usuatio;
    }

    /**
     * @param usuatio the usuatio to set
     */
    public void setUsuatio(UsuarioEntity usuatio) {
        this.usuatio = usuatio;
    }

    /**
     * @return the fornecedor
     */
    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the itens
     */
    public List<MovimentoItemEntity> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<MovimentoItemEntity> itens) {
        this.itens = itens;
    }
    
}
