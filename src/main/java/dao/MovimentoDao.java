/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.MovimentoEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author u08538003160
 */
public class MovimentoDao {
     public void salvar(MovimentoEntity movimento){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            sessao.persist(movimento);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao salvar!");
        }//fecha o catch
        
    }//fecha salvar
    
    public void atualizar(MovimentoEntity movimento){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            //preciso verificar se o produto realmente existe
            sessao.merge(movimento);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao atualizar!"+e);
        }
    }//fecha atualizar
    
    public MovimentoEntity buscar(int id){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.find(MovimentoEntity.class, id);    
        }//try
    }//buscar
    
    public List<MovimentoEntity> listar(){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.createQuery("FROM MovimentoEntity",MovimentoEntity.class).list();
        }//try
    }//listar
    
    public void deletar(int id){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            MovimentoEntity movimentoEntity = sessao.find(MovimentoEntity.class, id);
            sessao.remove(movimentoEntity);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao deletar!"+e);
        }//catch
    }//deletar
}
