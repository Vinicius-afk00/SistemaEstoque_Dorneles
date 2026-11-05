/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;

/**
 *
 * @author u08538003160
 */
@Entity
@Table(name="Movimento_item")
public class MovimentoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private int qtd;
    @Column(nullable = false)
    private double valor;
    
    @ManyToOne//cardinalidade
    @JoinColumn(name="produto_id", foreignKey = @ForeignKey(name="fk_produoId"), nullable = false)//nome da coluna que armazena o id/nome do fk
    private ProdutoEntity produto;
    
    @ManyToOne//cardinalidade
    @JoinColumn(name="movimento_id", foreignKey = @ForeignKey(name="fk_movimentoId"), nullable = false)//nome da coluna que armazena o id/nome do fk
    private MovimentoEntity movimento;

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
     * @return the qtd
     */
    public int getQtd() {
        return qtd;
    }

    /**
     * @param qtd the qtd to set
     */
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the produto
     */
    public ProdutoEntity getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }

    /**
     * @return the movimento
     */
    public MovimentoEntity getMovimento() {
        return movimento;
    }

    /**
     * @param movimento the movimento to set
     */
    public void setMovimento(MovimentoEntity movimento) {
        this.movimento = movimento;
    }
}
