/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Dunja Damjanovic
 *
 */
public class TwitterTest {
	Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		
		
		for (int i = 0; i < 10; i++) {
			t.unesi("Marko", "Ima nas");
		}
		assertEquals(10, t.vratiSvePoruke().size());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		
		String korisnik = "Marko";
		String poruka = "Ima nas";
		
		t.unesi(korisnik, poruka);
		LinkedList<TwitterPoruka> lista = t.vratiSvePoruke();
		assertEquals(poruka, lista.getLast().getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPoruke() {
		
		t.unesi("Marko", "Ima ");
		t.unesi("ZIka", "nas");
		t.unesi("Janko", "Ima vas");
		int uk=0;
		
		TwitterPoruka [] niz = t.vratiPoruke(50, "Ima");
		for (int i=0;i<niz.length;i++){
			if(niz[i] != null)
				uk++;
		}
		assertEquals(2, uk);
	}
	@Test
	public void testVratiPorukePrvi() {
		TwitterPoruka[] niz = t.vratiPoruke(15, "nas");
		assertEquals(15,niz.length);
	}
	
	@Test
	public void testVratiPorukeDrugi() {

		TwitterPoruka[] niz = t.vratiPoruke(-1, "nas");
		assertEquals(100,niz.length);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull(){
		t.vratiPoruke(10,null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanTag(){
		t.vratiPoruke(10,"");
	}
}
