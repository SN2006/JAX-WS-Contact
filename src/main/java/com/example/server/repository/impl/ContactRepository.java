package com.example.server.repository.impl;

import com.example.server.entity.Contact;
import com.example.server.repository.AppRepository;
import com.example.server.utils.Constants;
import com.example.server.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ContactRepository implements AppRepository<Contact> {
    @Override
    public String create(Contact obj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            String hql = "INSERT INTO Contact (name, phone) VALUES (:name, :phone)";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("name", obj.getName());
            query.setParameter("phone", obj.getPhone());
            query.executeUpdate();

            transaction.commit();

            return Constants.DATA_INSERT_MSG;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public Optional<List<Contact>> read() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Contact";
            List<Contact> contacts = session.createQuery(hql, Contact.class).list();

            transaction.commit();

            return Optional.of(contacts);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public String update(Contact obj) {
        if (readById(obj.getId()).isEmpty()) return Constants.NO_DATA_MSG;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            String hql = "UPDATE Contact SET name = :name, phone = :phone WHERE id = :id";
            MutationQuery query = session.createMutationQuery(hql);

            query.setParameter("name", obj.getName());
            query.setParameter("phone", obj.getPhone());
            query.setParameter("id", obj.getId());

            query.executeUpdate();

            transaction.commit();

            return Constants.DATA_UPDATE_MSG;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public String delete(Long id) {
        if (readById(id).isEmpty()) return Constants.NO_DATA_MSG;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            String hql = "DELETE FROM Contact WHERE id = :id";

            MutationQuery query = session.createMutationQuery(hql);
            query.setParameter("id", id);

            query.executeUpdate();
            transaction.commit();

            return Constants.DATA_DELETE_MSG;
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            return e.getMessage();
        }
    }

    @Override
    public Optional<Contact> readById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            String hql = "FROM Contact WHERE id = :id";
            Query<Contact> query = session.createQuery(hql, Contact.class);
            query.setParameter("id", id);

            Optional<Contact> contactOptional = query.uniqueResultOptional();

            transaction.commit();
            return contactOptional;
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
