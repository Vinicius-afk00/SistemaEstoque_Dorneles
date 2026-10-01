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
        fireTableDataChanged();
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
        FornecedorEntity forne = lista.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> forne.getId();
            case 1 -> forne.getRazao_social();
            case 2 -> forne.getNome_fantasia();
            case 3 -> forne.getCnpj();
            case 4 -> forne.getTelefone();
            case 5 -> forne.getEmail();
            case 6 -> forne.getCidade();
            default -> "";
        };
    }
    
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Codigo";
            case 1 -> "Razão Social";
            case 2 -> "Nome Fantasia";
            case 3 -> "CNPJ";
            case 4 -> "Telefone";
            case 5 -> "Email";
            case 6 -> "Cidade";
            default -> "";
        };
    }
    
}
