package com.example.board.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.example.board.domain.entity.MemberEntity;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExRepository {
    private final EntityManager em;

    public void saveUser(MemberEntity user){
        em.persist(user);
    }

    public MemberEntity findUserByEmail(String email){
        TypedQuery<MemberEntity> query = em.createQuery("select m from User as m where m.email = ?1", MemberEntity.class)
                .setParameter(1, email);
        return query.getSingleResult();
    }
}
