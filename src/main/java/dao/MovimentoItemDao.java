/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.MovimentoItemEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
/**
 *
 * @author u08538003160
 */
public class MovimentoItemDao {
    public void salvar(MovimentoItemEntity movimentoItem){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            sessao.persist(movimentoItem);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao salvar!");
        }//fecha o catch
        
    }//fecha salvar
    
    public void atualizar(MovimentoItemEntity movimentoItem){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            //preciso verificar se o produto realmente existe
            sessao.merge(movimentoItem);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao atualizar!"+e);
        }
    }//fecha atualizar
    
    public MovimentoItemEntity buscar(int id){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.find(MovimentoItemEntity.class, id);    
        }//try
    }//buscar
    
    public List<MovimentoItemEntity> listar(){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.createQuery("FROM MovimentoItemEntity",MovimentoItemEntity.class).list();
        }//try
    }//listar
    
    public void deletar(int id){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            MovimentoItemEntity movimentoItemEntity = sessao.find(MovimentoItemEntity.class, id);
            sessao.remove(movimentoItemEntity);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao deletar!"+e);
        }//catch
    }//deletar
}
