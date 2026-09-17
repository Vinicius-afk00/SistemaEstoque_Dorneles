/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.FornecedorEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author u08538003160
 */
public class FornecedorDao {
    public void salvar(FornecedorEntity fornecedor){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            sessao.persist(fornecedor);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao salvar!");
        }//fecha o catch
        
    }//fecha salvar
    
    public void atualizar(FornecedorEntity fornecedor){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            //preciso verificar se o produto realmente existe
            sessao.merge(fornecedor);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao atualizar!"+e);
        }
    }//fecha atualizar
    
    public FornecedorEntity buscar(int id){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.find(FornecedorEntity.class, id);    
        }//try
    }//buscar
    
    public List<FornecedorEntity> listar(){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.createQuery("FROM FornecedorEntity",FornecedorEntity.class).list();
        }//try
    }//listar
    
    public void deletar(int id){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            FornecedorEntity fornecedorEntity = sessao.find(FornecedorEntity.class, id);
            sessao.remove(fornecedorEntity);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao deletar!"+e);
        }//catch
    }//deletar
}
