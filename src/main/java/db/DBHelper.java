package db;

import models.CategoryType;
import models.Journalist;
import models.Article;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> void deleteAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results) {
                session.delete(result);
            }
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            results = cr.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T find(int id, Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            Criteria cr = session.createCriteria(classType);
            cr.add(Restrictions.eq("id", id));
            result = (T) cr.uniqueResult();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println(result);
        return result;
    }

    public static List<Article> articlesForJournalist(Journalist journalist) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;

        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("journalist", journalist));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;

    }

    public static List<Article> orderByPageViewsFewestFirst() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.asc("pageViews"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> orderByPageViewsMostFirst() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("pageViews"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> orderByDateCreatedOldestFirst() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.asc("dateCreated"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> orderByDateCreatedNewestFirst() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("dateCreated"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> findByCategoryOldestFirst(CategoryType category) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("category", category));
            cr.addOrder(Order.asc("dateCreated"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> findByCategoryNewestFirst(CategoryType category) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("category", category));
            cr.addOrder(Order.desc("dateCreated"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    public static List<Article> searchArticlesHeadline(String search) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> results = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.ilike("headline", "%" + search + "%"));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (results.size() > 0) {
        return results;}
        else return null;
    }

    public static List<Article> searchArticlesSummary(String search) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> results = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.ilike("summary", "%" + search + "%"));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (results.size() > 0) {
            return results;}
        else return null;
    }

    public static List<Journalist> searchJournalists(String search) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Journalist> results = null;
        try {
            Criteria cr = session.createCriteria(Journalist.class);
            cr.add(Restrictions.ilike("name", "%" + search + "%"));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (results.size() > 0) {
            return results;}
        else return null;
    }

    public static Boolean checkForEmptyList(String search) {
        List<Article> headlines = DBHelper.searchArticlesHeadline(search);
        List<Article> summary = DBHelper.searchArticlesSummary(search);
        List<Journalist> journalists = DBHelper.searchJournalists(search);

        return (headlines.size() != 0) && (summary.size() != 0) && (journalists.size() !=0);
    }


//    public static List<Article> searchAll(String search) {
//
//        if (DBHelper.checkForEmptyList(search) == false) {
//            return null;
//        }
//
//        List<Article> headlines = DBHelper.searchArticlesHeadline(search);
//        List<Article> summary = DBHelper.searchArticlesSummary(search);
//        List<Journalist> journalists = DBHelper.searchJournalists(search);
//        List<Article> journalistArticles = null;
//
//        for (Journalist journalist : journalists) {
//            journalistArticles.addAll(articlesForJournalist(journalist));
//        }
//
//        List<Article> allArticles = new ArrayList<>();
//
//        if (journalistArticles.size() > 0) {
//            allArticles.addAll(journalistArticles);
//        }
//        if (headlines.size() > 0) {
//            allArticles.addAll(headlines);
//        }
//        if (summary.size() >0 ) {
//            allArticles.addAll(summary);
//        }
//
//        Set<Article> removeDuplicates = new HashSet<>();
//        removeDuplicates.addAll(allArticles);
//        List<Article> uniqueArticles = new ArrayList<>();
//        allArticles.addAll(removeDuplicates);
//        return uniqueArticles;
//    }


}