package com.ex.web.services;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.ex.web.models.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class GenreServiceTest extends TestCase {

    private static SessionFactory sessionFactory;
    private static GenreService genreService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        genreService = new GenreService(sessionFactory);
    }

    @Test
    public void testGetAllGenres() {
        assertNotNull("Able to get genres", genreService.getAllGenres().get(0).getGenre_Id());
    }

    @Test
    public void testGetGenreIdByGenre() {
        assertEquals("Got ID by genre", genreService.getGenreIdByGenre("Rap"), 3);
    }

    @Test
    public void testGetGenreById() {
        assertEquals("Got Genre by ID", genreService.getGenreById(3), "Rap");
    }

}