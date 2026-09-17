/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.UsuarioEntity;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author u08538003160
 */
public class UsuarioDao {
    public void salvar(UsuarioEntity usuario){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            sessao.persist(usuario);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao salvar!");
        }//fecha o catch
        
    }//fecha salvar
    
    public void atualizar(UsuarioEntity usuario){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            //preciso verificar se o produto realmente existe
            sessao.merge(usuario);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao atualizar!"+e);
        }
    }//fecha atualizar
    
    public UsuarioEntity buscar(int id){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.find(UsuarioEntity.class, id);    
        }//try
    }//buscar
    
    public List<UsuarioEntity> listar(){
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            return sessao.createQuery("FROM UsuarioEntity",UsuarioEntity.class).list();
        }//try
    }//listar
    
    public void deletar(int id){
        Transaction tx = null;
        try(Session sessao = HibernateUtil.getSessao().openSession();){
            tx=sessao.beginTransaction();
            UsuarioEntity usuarioEntity = sessao.find(UsuarioEntity.class, id);
            sessao.remove(usuarioEntity);
            tx.commit();
        }catch(Exception e){
            if(tx!=null) tx.rollback();
            System.err.println("Eroo ao deletar!"+e);
        }//catch
    }//deletar
}
