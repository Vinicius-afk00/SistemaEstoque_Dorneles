/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import dao.ProdutoDao;
import entity.ProdutoEntity;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author u08538003160
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
//        ProdutoEntity prod = new ProdutoEntity();
//        prod.setCategoria("Refrigerantes");
//        prod.setDescricao("Sprite");
//        
//        Session sessao = HibernateUtil.getSessao().openSession();
//        sessao.beginTransaction();//solicita o acesso ao bd
//        sessao.persist(prod);//operação de gravar
//        sessao.getTransaction().commit();//efetiva a gravação
//        sessao.close();//fecha a sessão

            ProdutoDao produtoDao = new ProdutoDao();
            ProdutoEntity prod = produtoDao.buscar(1);
            System.out.println("Retorno: " + prod.getDescricao());
            
            List<ProdutoEntity> lista = produtoDao.listar();
            for(ProdutoEntity produto : lista){
                System.out.println(produto.getId()+"    - "+produto.getDescricao());
            }//for

    }//mais 
}
