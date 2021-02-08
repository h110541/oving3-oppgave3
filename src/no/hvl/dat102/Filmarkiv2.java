package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private int antall;
	private LinearNode<Film> start;

	public Filmarkiv2() {
		antall = 0;
		start = null;
	}

	@Override
	public Film[] hentFilmTabell() {
		Film[] filmer = new Film[antall];
		LinearNode<Film> node = start;

		for(int i = 0; i < filmer.length; i++) {
			filmer[i] = node.getElement();
			node = node.getNeste();
		}

		return filmer;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;
		LinearNode<Film> current = start;
		LinearNode<Film> prev = null;

		while(current != null && !funnet) {
			if(current.getElement().getFilmnr() == filmnr) {
				funnet = true;
			} else {
				prev = current;
				current = current.getNeste();
			}
		}

		if(funnet) {
			if(prev == null) {
				start = start.getNeste();
			} else {
				prev.setNeste(current.getNeste());
			}

			antall--;
		}

		return funnet;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		String delstrengLower = delstreng.toLowerCase();
		Film[] resultatTab = new Film[antall];
		int antallMatches = 0;

		LinearNode<Film> node = start;
		while(node != null) {
			if(node.getElement().getTittel().toLowerCase().contains(delstrengLower)) {
				resultatTab[antallMatches] = node.getElement();
				antallMatches++;
			}

			node = node.getNeste();
		}

		return trimTab(resultatTab, antallMatches);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		String delstrengLower = delstreng.toLowerCase();
		Film[] resultatTab = new Film[antall];
		int antallMatches = 0;

		LinearNode<Film> node = start;
		while(node != null) {
			if(node.getElement().getProdusent().toLowerCase().contains(delstrengLower)) {
				resultatTab[antallMatches] = node.getElement();
				antallMatches++;
			}

			node = node.getNeste();
		}

		return trimTab(resultatTab, antallMatches);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antallSjanger = 0;
		LinearNode<Film> node = start;

		while(node != null) {
			if(node.getElement().getSjanger() == sjanger) {
				antallSjanger++;
			}

			node = node.getNeste();
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
