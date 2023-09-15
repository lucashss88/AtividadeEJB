package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "bd2")
    private EntityManager em;

    public void inserir(Mensagem novaMensagem) {
        em.persist(novaMensagem);
    }

    public List<Mensagem> listar() {
        return em.createQuery("SELECT m FROM  tb_mensagem_pdist m").getResultList();
    }

    public Mensagem pesquisarPorId(Long idMensagem) {
        Query query = em.createQuery("SELECT m FROM tb_mensagem_pdist m WHERE m.id = :id");
        query.setParameter("id", idMensagem);
        return (Mensagem) query.getSingleResult();
    }
}
