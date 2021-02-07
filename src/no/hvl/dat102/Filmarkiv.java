package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private static final int STANDARD_KAPASITET = 10;

	private int antall;
	private Film[] filmer;

	public Filmarkiv() {
		this(STANDARD_KAPASITET);
	}

	public Filmarkiv(int kapasitet) {
		antall = 0;
		filmer = new Film[kapasitet];
	}

	@Override
	public Film[] hentFilmTabell() {
		return trimTab(filmer, antall);
	}

	@Override
	public void leggTilFilm(Film nyFilm) {

		if(antall == filmer.length) {
			utvidKapasitet();
		}

		filmer[antall] = nyFilm;
		antall++;
	}

	private void utvidKapasitet() {
		int nyKapasitet = (int) Math.ceil(1.1 * filmer.length);
		Film[] nyTabell = new Film[nyKapasitet];

		for(int i = 0; i < antall; i++) {
			nyTabell[i] = filmer[i];
		}

		filmer = nyTabell;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;

		for(int i = 0; i < antall && !funnet; i++) {
			if(filmer[i].getFilmnr() == filmnr) {
				filmer[i] = filmer[antall - 1];
				filmer[antall - 1] = null;
				antall--;
				funnet = true;
			}
		}

		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		String delstrengLower = delstreng.toLowerCase();
		Film[] resultatTab = new Film[antall];
		int antallMatches = 0;

		for(int i = 0; i < antall; i++) {
			if(filmer[i].getTittel().toLowerCase().contains(delstrengLower)) {
				resultatTab[antallMatches] = filmer[i];
				antallMatches++;
			}
		}

		return trimTab(resultatTab, antallMatches);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		String delstrengLower = delstreng.toLowerCase();
		Film[] resultatTab = new Film[antall];
		int antallMatches = 0;

		for(int i = 0; i < antall; i++) {
			if(filmer[i].getProdusent().toLowerCase().contains(delstrengLower)) {
				resultatTab[antallMatches] = filmer[i];
				antallMatches++;
			}
		}

		return trimTab(resultatTab, antallMatches);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;

		for(int i = 0; i < antall; i++) {
			if(filmer[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}

		return antallSjanger;
	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimTab(Film[] tab, int n) {
		Film[] filmtab2 = new Film[n];

		for(int i = 0; i < n; i++) {
			filmtab2[i] = tab[i];
		}

		return filmtab2;
	}

}
