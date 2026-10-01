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
        fireTableDataChanged();
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
        UsuarioEntity usu = lista.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> usu.getId();
            case 1 -> usu.getNome();
            case 2 -> usu.getEmail();
            case 3 -> usu.getSenha();
            case 4 -> usu.getFuncao();
            case 5 -> usu.isAtivo();
            default -> "";
        };
    }
    
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Codigo";
            case 1 -> "nome";
            case 2 -> "Email";
            case 3 -> "Senha";
            case 4 -> "Função";
            case 5 -> "Status";
            default -> "";
        };
    }
    
}
