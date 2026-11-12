/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import entity.MovimentoItemEntity;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author u08538003160
 */
public class MovimentoItemModel extends AbstractTableModel{
    private List<MovimentoItemEntity> lista;
    
    /**
     * @return the lista
     */
    public List<MovimentoItemEntity> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<MovimentoItemEntity> lista) {
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
        MovimentoItemEntity movi = lista.get(rowIndex);
        
        return switch (columnIndex) {
            case 0 -> movi.getId();
            case 1 -> movi.getProduto();
            case 2 -> movi.getMovimento();
            case 3 -> movi.getQtd();
            case 4 -> movi.getValor();
            default -> "";
        };
    }
    
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Codigo";
            case 1 -> "produto";
            case 2 -> "movimento";
            case 3 -> "quantidade";
            case 4 -> "valor";
            default -> "";
        };
    }
}
