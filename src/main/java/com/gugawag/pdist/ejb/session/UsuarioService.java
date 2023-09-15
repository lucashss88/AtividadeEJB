package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);
        if(novoUsuario.getId() == 4){
//            this.mensagemDAO.pesquisarPorId()
            Mensagem m = new Mensagem(4,"Mensagem u4");
            this.mensagemDAO.inserir(m);
        }
        if(novoUsuario.getId() == 5){
//            this.mensagemDAO.pesquisarPorId()
            Mensagem m = new Mensagem(5,"Mensagem u5");
            this.mensagemDAO.inserir(m);
            throw new RuntimeException();
        }
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
