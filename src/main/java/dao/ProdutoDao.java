/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ProdutoEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author u08538003160
 */
public class ProdutoDao {
    
    public void salvar(ProdutoEntity produto){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            sessao.persist(produto);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao salvar!");
        }//fecha o catch
        
    }//fecha salvar
    
    public void atualizar(ProdutoEntity produto){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            //preciso verificar se o produto realmente existe
            sessao.merge(produto);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao atualizar!"+e);
        }
    }//fecha atualizar
    
    public ProdutoEntity buscar(int id){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.find(ProdutoEntity.class, id);    
        }//try
    }//buscar
    
    public List<ProdutoEntity> listar(){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.createQuery("FROM ProdutoEntity",ProdutoEntity.class).list();
        }//try
    }//listar
    
    public void deletar(int id){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            ProdutoEntity produtoEntity = sessao.find(ProdutoEntity.class, id);
            sessao.remove(produtoEntity);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao deletar!"+e);
        }//catch
    }//deletar
    
}//fecha a classe
