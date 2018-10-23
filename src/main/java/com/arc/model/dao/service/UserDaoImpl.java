package com.arc.model.dao.service;

import com.arc.model.dao.User;
import com.arc.model.dao.UserRole;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String username) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root).where(builder.equal(root.get("name"), username));


        return entityManager.createQuery(cq).getSingleResult();
    }

    @Override
    public List<User> getAllUsers(boolean withoutCurrent) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = builder.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);

        if (withoutCurrent) {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            cq.where(builder.notEqual(root.get("name"), name));
        }

        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public User addUser(String name, String password, boolean enabled, String role) {
        if (findByUserName(name) != null) {
            throw new DuplicateKeyException("Пользователь с таким именем уже существует!");
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEnabled(enabled);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        user.setUserRole(userRole);

        entityManager.persist(user);

        return user;
    }
}
