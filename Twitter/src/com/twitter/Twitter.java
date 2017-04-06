
package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * 
 * @author Dunja Damjanovic
 *@version 1.1
 *Klasa vrsi unos twitova u listu Poruke ,na kraj same liste
 * i pretragu liste za porukama da odgovarajucim tagom i vraca niz pronadjenih poruka
 *  ako broj poruka ne prelazi unapred odredjenu duzinu niza.
 */
public class Twitter {
	/**
	 * Lista objekata tipa TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Vraca celokupnu listu "poruke" koju cine objekti tipa TwitterPoruka.
	 * @return listu objekata tipa TwitterPoruka.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
	/***
	 * Unosi novu poruku na kraj liste "poruke".
	 * @param korisnik kao novo ime korisnika.
	 * @param poruka kao novi tekst poruke.
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Pretrazuje poruke koje sadrze odredjeni tag, i odgovarajuce puni
	 *  u niz koji potom vraca kao povratnu vrednost.
	 * @param maxBroj kao maksimalna duzina niza.
	 * @param tag kao kriterijum za pretrazivanje poruka.
	 * @return niz objekata tipa TwitterPoruka koji sadrzi poruke nadjene prema zadatom tagu.
	 * @throws java.lang.RuntimeException ako je uneti tag:
	 * <ul>
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
