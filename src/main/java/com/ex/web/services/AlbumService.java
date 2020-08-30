package com.ex.web.services;

//import com.ex.web.dao.AlbumDao;
import com.ex.web.models.Albums;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AlbumService {
    private SessionFactory sessionFactory;

    @Autowired
    public AlbumService(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /** @return Returns a list of all albums
     * */
//    @Override
    @Transactional
    public List<Albums> getAllAlbums() {
        Session session = sessionFactory.openSession();
        String hql = "FROM Albums";
        Query query = session.createQuery(hql);
        List<Albums> foundAlbums = query.list();
        return foundAlbums;
    }

    /** 
     * @param Genre_Id Genre ID to search by 
     * @return Returns a list of all albums with a matching Genre ID
     * */
//    @Override
    @Transactional
    public List<Albums> getAlbumsByGenre(int Genre_Id) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where genre_id = :g";
            Query query = session.createQuery(hql);
            query.setInteger("g", Genre_Id);

            List foundAlbums = (List)query.list();
            return foundAlbums;
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }
        //System.out.println(foundAlbums);
        //return foundAlbums;
        return null;
    }

    /** 
     * @param Artist_Id Artist ID to search by
     * @return Returns a list of all albums with a matching Artist ID
     * */
//    @Override
    @Transactional
    public List<Albums> getAlbumsByArtist(int Artist_Id) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where artist_id = :g";
            Query query = session.createQuery(hql);
            query.setInteger("g", Artist_Id);

            List foundAlbums = (List)query.list();
            return foundAlbums;

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return null;
    }

    /** 
     * @param Album_Title Title to search by
     * @return Returns a list of all albums with a matching Title
     * */
//    @Override
    @Transactional
    public List<Albums> getAlbumsByTitle(String Album_Title) {
        Session session = null;
        //List<Albums> foundAlbums = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            String hql = "from Albums where album_title = :g";
            Query query = session.createQuery(hql);
            query.setString("g", Album_Title);

            List foundAlbums = (List)query.list();
            return foundAlbums;

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return null;
    }

    /** 
     * @param Album_Id Album ID to search by
     * @return Returns a list of all albums with a matching Album ID
     * */
//    @Override
    @Transactional
    public Albums getAlbumById(int Album_Id) {
        Session session = null;
        Albums foundAlbums = null;
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            Criteria cr = session.createCriteria(Albums.class);
            cr.add(Restrictions.eq("Album_Id", Album_Id));
            foundAlbums = (Albums) cr.uniqueResult();
            session.getTransaction().commit();

        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return foundAlbums;
    }

    /** 
     * @param Album_Id Album ID to search by
     * @return Returns a description from the album with a matching ID, or null if ID is invalid
     * */
//    @Override
    @Transactional
    public String getAlbumDescription(int Album_Id) {
        Session session = null;
        Albums foundDescription = null;
        try{
            session = sessionFactory.openSession();
            foundDescription = (Albums) session.get(Albums.class, Album_Id);
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return foundDescription.getDescription();
    }

    /** 
     * @param Album_Id Album ID to search by
     * @return Returns a float representing the album's price, or null if ID is invalid
     * */
//    @Override
    @Transactional
    public float getPriceByAlbumId(int Album_Id){
        Session session = null;
        Albums foundPrice = null;
        try{
            session = sessionFactory.openSession();
            foundPrice = (Albums) session.get(Albums.class, Album_Id);
        } catch (HibernateException hex) {
            hex.printStackTrace();
            if(session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally {
            if(session != null) {
                session.close();
            }
        }

        return foundPrice.getPrice();
    }

}