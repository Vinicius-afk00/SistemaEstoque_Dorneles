/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import dao.FornecedorDao;
import dao.ProdutoDao;
import dao.UsuarioDao;
import entity.FornecedorEntity;
import entity.ProdutoEntity;
import entity.UsuarioEntity;
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
            FornecedorDao fornecedorDao = new FornecedorDao();
            UsuarioDao usuarioDao = new UsuarioDao();
            ProdutoEntity prod = produtoDao.buscar(1);
            FornecedorEntity forne = fornecedorDao.buscar(1);
            UsuarioEntity usu = usuarioDao.buscar(1);
            System.out.println("Retorno: " + prod.getDescricao() + forne.getNome_fantasia() + usu.getNome());
            
            List<ProdutoEntity> lista = produtoDao.listar();
            List<FornecedorEntity> lista1 = fornecedorDao.listar();
            List<UsuarioEntity> lista2 = usuarioDao.listar();
            for(ProdutoEntity produto : lista){
                System.out.println(produto.getId()+"    - "+produto.getDescricao());
            }//for
            for(FornecedorEntity produto : lista1){
                System.out.println(produto.getId()+"    - "+forne.getNome_fantasia());
            }
            for(UsuarioEntity produto : lista2){
                System.out.println(produto.getId()+"    - "+usu.getNome());
            }

    }//mais 
}
