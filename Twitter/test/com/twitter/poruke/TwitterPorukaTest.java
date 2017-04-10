/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dunja Damjanovic
 *
 */
public class TwitterPorukaTest {
	private TwitterPoruka t ;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		t.setKorisnik("Zika");
		
		assertEquals("Zika", t.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		t.setKorisnik(null);
		
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		t.setKorisnik("");
		
	}
	
	@Test
	public void testSetPoruka() {
		t.setPoruka("Ima nas");
		
		assertEquals("Ima nas", t.getPoruka());
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		t.setPoruka(null);
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString(){
		t.setPoruka("");
	}
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugackaPoruka(){
		t.setPoruka("Srbija:"
				+ "Jedina zemlja demokratskog uredjenja u kojoj je isti covek i predsednik i premijer i predsednik vladajuce stranke."
				+ "Jedina zemlja u kojoj se izborna kradja prihvata kao nesto uobicajeno,a slobodna vodja gradjana najostije osudjuje."
				+ "Jedina zemlja u kojoj se studenti nazivaju huliganima,a neobrazovani i priuceni postavljaju sisteme vrednosti."
				+ "Jedina zemlja gde se srpska omladina koja se bori protiv diktature naziva narkomanima i neradnicima."
				+ "Jedina zemlja u kojoj se na glasanje pozivaju mrtvi i odseljeni."
				+ "Jedina zemlja u kojoj moras da podignes kredit da bi kupio radno mesto za koje si se skolovao."
				+ "Jedina zemlja u cijem glavnom gradu 30 000 ljudi seta ulicom ne bi li se njihov glas cuo,a o tome na Televiziji nema ni reci."
				+ "Jedina zemlja u kojoj vladaju oni sa kupljenim diplomama, a oni koji su iz zasluzili mogu sa njima samo da se slikaju."
				+ "Jedina zemlja u kojoj ljudi koji su se u njoj rodili  samo gledaju kako da odu iz nje.");

	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	
	public void testToString() {
		t.setKorisnik("Zika");
		t.setPoruka("Ima nas");
		 
		 assertEquals("KORISNIK:Zika PORUKA:Ima nas", t.toString());
	}

}
