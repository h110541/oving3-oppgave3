package no.hvl.dat102.klient;

import no.hvl.dat102.Film;
import no.hvl.dat102.adt.FilmarkivADT;

public class Meny {

	private static final String STARTMENY_TEKST =
			"[1] Nytt arkiv\n" +
			"[2] Åpne eksisterende arkiv\n\n" +
			"Ditt valg: ";

	private static final String HOVEDMENY_TEKST =
			"[1] Legg til film\n" +
			"[2] Slett film\n" +
			"[3] Vis filmer, søk på tittel\n" +
			"[4] Vis filmer, søk på produsent\n" +
			"[5] Skriv ut statistikk\n" +
			"[6] Lagre filmarkiv\n" +
			"[7] Avslutt\n\n" +
			"Ditt valg: ";

	private FilmarkivADT fa;
	private Tekstgrensesnitt tekstgr;

	public Meny(FilmarkivADT fa) {
		this.fa = fa;
		tekstgr = new Tekstgrensesnitt();
	}

	public void start() {
		int valg;
		boolean ferdig = false;

		while(!ferdig) {
			System.out.print(STARTMENY_TEKST);
			valg = tekstgr.lesInt();
			System.out.println();

			switch(valg) {
				case 1:
					ferdig = true;
					break;
				case 2:
					fa = tekstgr.lastFilmarkiv();
					ferdig = true;
					break;
				default:
					System.out.println("Ugyldig valg\n");
			}
		}

		hovedmeny();
	}

	private void hovedmeny() {
		int valg;
		boolean ferdig = false;

		while(!ferdig) {
			System.out.print(HOVEDMENY_TEKST);
			valg = tekstgr.lesInt();
			System.out.println();

			switch(valg) {
				case 1:
					Film film = tekstgr.lesFilm();
					fa.leggTilFilm(film);
					break;
				case 2:
					tekstgr.slettFilm(fa);
					break;
				case 3:
					tekstgr.skrivUtFilmDelstrengITittel(fa);
					break;
				case 4:
					tekstgr.skrivUtFilmProdusent(fa);
					break;
				case 5:
					tekstgr.skrivUtStatistikk(fa);
					break;
				case 6:
					tekstgr.lagreFilmarkiv(fa);
					break;
				case 7:
					ferdig = true;
					break;
				default:
					System.out.println("Ugyldig valg\n");
			}
		}
	}

}
