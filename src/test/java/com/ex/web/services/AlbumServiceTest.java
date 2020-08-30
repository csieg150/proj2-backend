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

public class AlbumServiceTest extends TestCase {


    private static SessionFactory sessionFactory;
    private static AlbumService albumService;


    @BeforeClass
    public void setUp() throws Exception {
        HibernateUtil.connect();
        sessionFactory = HibernateUtil.getSessionFactory();
        albumService = new AlbumService(sessionFactory);
    }


    @Test
    public void testGetAllAlbums() {
        assertNotNull("Album list not null", albumService.getAllAlbums().get(0).getAlbum_Title());
    }

    @Test
    public void testGetAlbumsByGenre() {
        assertEquals("Got Genre by ID", albumService.getAlbumsByGenre(1).get(0).getAlbum_Title(),"Bowie pop" );
    }

    @Test
    public void testGetAlbumsByArtist() {
        assertEquals("Got Album by artist", albumService.getAlbumsByArtist(2).get(0).getAlbum_Id(), 3);
    }

    @Test
    public void testGetAlbumsByTitle() {
        assertEquals("Got album by title", albumService.getAlbumsByTitle("Aladdin Sane").get(0).getAlbum_Title(), "Aladdin Sane");
    }

    @Test
    public void testGetAlbumById() {
        assertEquals("Got album by ID", albumService.getAlbumById(1).getAlbum_Title(), "Eminem rap");
    }

    @Test
    public void testGetAlbumDescription() {
        assertEquals("Found album description", albumService.getAlbumDescription(7), "Deep");
    }

    @Test
    public void testGetPriceByAlbumId() {
        assertEquals("Found Album Price", albumService.getPriceByAlbumId(2),9.99f);
    }

}