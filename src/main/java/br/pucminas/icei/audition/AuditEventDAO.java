package br.pucminas.icei.audition;

import info.atende.audition.model.AuditEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Giovanni Silva.
 */
@Repository
public class AuditEventDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(AuditEvent event){
        em.persist(event);
    }
}
