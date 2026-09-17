/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.FornecedorEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08538003160
 */
public class FornecedorModel extends AbstractTableModel{
    
    private List<FornecedorEntity> lista;
    
    /**
     * @return the lista
     */
    public List<FornecedorEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<FornecedorEntity> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
