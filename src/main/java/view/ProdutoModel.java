/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.ProdutoEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08538003160
 */
public class ProdutoModel extends AbstractTableModel{
    
    private List<ProdutoEntity> lista;
    
      /**
     * @return the lista
     */
    public List<ProdutoEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<ProdutoEntity> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoEntity prod = lista.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> prod.getId();
            case 1 -> prod.getDescricao();
            case 2 -> prod.getCategoria();
            case 3 -> prod.getMarca();
            case 4 -> prod.getPreco();
            case 5 -> prod.isAtivo()? "Ativo": "Inativo";
            default -> "";
        };
        
    }
    
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Codigo";
            case 1 -> "Produto";
            case 2 -> "Categoria";
            case 3 -> "Marca";
            case 4 -> "Preco";
            case 5 -> "Status";
            default -> "";
        };
    }
    
}
