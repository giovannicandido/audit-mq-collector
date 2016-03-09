package br.pucminas.icei.audition;

import br.pucminas.icei.audition.entity.AuditEvent;
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
