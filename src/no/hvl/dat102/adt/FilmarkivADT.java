package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {

	/**
	 * Returnerer en tabell som inneholder alle filmene i arkivet.
	 *
	 * @return tabell av Film-objekter
	 */
	Film[] hentFilmTabell();

	/**
	 * Legger en film til arkivet.
	 *
	 * @param nyFilm Film-objektet som legges til
	 */
	void leggTilFilm(Film nyFilm);

	/**
	 * Sletter en angitt film fra arkivet.
	 *
	 * @param filmnr id-nummer til film som skal slettes
	 * @return sann hvis filmen ble slettet, usann hvis den ikke ble funnet i arkivet
	 */
	boolean slettFilm(int filmnr);

	/**
	 * Finner filmer med en gitt delstreng i tittelen, og returnerer en tabell
	 * som inneholder filmene som matcher.
	 *
	 * @param delstreng er søkestrengen
	 * @return tabell av Film-objekter som matcher søket
	 */
	Film[] soekTittel(String delstreng);

	/**
	 * Finner filmer med en gitt delstreng i produsenten, og returnerer en tabell
	 * som inneholder filmene som matcher.
	 *
	 * @param delstreng er søkestrengen
	 * @return tabell av Film-objekter som matcher søket
	 */
	Film[] soekProdusent(String delstreng);

	/**
	 * Returnerer antall filmer med en gitt sjanger.
	 *
	 * @param sjanger angir sjangeren
	 * @return antall filmer med gitt sjanger
	 */
	int antall(Sjanger sjanger);

	/**
	 * Returnerer det totale antallet filmer i arkivet.
	 *
	 * @return antall filmer
	 */
	int antall();

}
