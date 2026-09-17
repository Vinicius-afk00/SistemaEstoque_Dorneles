/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import entity.UsuarioEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u08538003160
 */
public class UsuarioModel extends AbstractTableModel{
    
    private List<UsuarioEntity> lista;

    /**
     * @return the lista
     */
    public List<UsuarioEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<UsuarioEntity> lista) {
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
