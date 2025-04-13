package hh.backend.footballapp;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.footballapp.domain.Joukkue;
import hh.backend.footballapp.domain.Ottelu;
import hh.backend.footballapp.domain.Pelaaja;
import hh.backend.footballapp.repository.JoukkueRepository;
import hh.backend.footballapp.repository.OtteluRepository;
import hh.backend.footballapp.repository.PelaajaRepository;

@SpringBootApplication
public class FootballappApplication {

	private static final Logger log = LoggerFactory.getLogger(FootballappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FootballappApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(PelaajaRepository pelaajaRepository,
			OtteluRepository otteluRepository, JoukkueRepository joukkueRepository) {
		return (args) -> {

			log.info("Luodaan ja tallennetaan joukkueet");

			Joukkue joukkue1 = new Joukkue("PPJ 11 Sininen");
        	Joukkue joukkue2 = new Joukkue("PPJ 15 Sininen");

				joukkueRepository.save(joukkue1);
				joukkueRepository.save(joukkue2);

			log.info("Luodaan ja tallennetaan pelaajat");

			Pelaaja pelaaja1 = new Pelaaja("Pli Aad", 1.68, "Keskikenttä", 30, joukkue1);

			Pelaaja pelaaja2 = new Pelaaja("Plvar Ayhälammi", 1.75, "Laitahyökkääjä", 9, joukkue1);

			Pelaaja pelaaja3 = new Pelaaja("Matmos Manderson", 1.65, "Laitapuolustaja", 13, joukkue1);

			Pelaaja pelaaja4 = new Pelaaja("Sruno Bchauman", 1.67, "Keskikenttä", 2, joukkue1);

			Pelaaja pelaaja5 = new Pelaaja("Vlias Euorio", 1.80, "Toppari", 16, joukkue1);

			Pelaaja pelaaja6 = new Pelaaja("Leikki Haukia", 1.60, "Laitahyökkääjä", 41, joukkue1);

			Pelaaja pelaaja7 = new Pelaaja("Aelix Furejärvi", 1.70, "Toppari / Keskikenntä", 4, joukkue1);

			Pelaaja pelaaja8 = new Pelaaja("Sugo Halo", 1.68, "Keskikenttä", 55, joukkue1);

			Pelaaja pelaaja9 = new Pelaaja("Eeo Eärvinen", 1.75, "Laitahyökkääjä", 17, joukkue1);

			Pelaaja pelaaja10 = new Pelaaja("kulius jeskinen", 1.85, "Maalivahti", 1, joukkue1);

			Pelaaja pelaaja11 = new Pelaaja("Teonid Lerentiev", 1.62, "Laitapuolustaja", 36, joukkue1);

			Pelaaja pelaaja12 = new Pelaaja("Hoa Nenttu", 1.68, "Keskikenttä", 8, joukkue1);

			Pelaaja pelaaja13 = new Pelaaja("Voel Nikström", 1.73, "Keskikenttä", 5, joukkue1);

			Pelaaja pelaaja14 = new Pelaaja("Kskar Oajas", 1.75, "Laitahyökkääjä", 77, joukkue1);

			Pelaaja pelaaja15 = new Pelaaja("Hnttila Aeino", 1.80, "Keskikenttä", 22, joukkue1);

			Pelaaja pelaaja16 = new Pelaaja("Keevi Linnunen", 1.72, "Hyökkääjä", 42, joukkue1);
			
			Pelaaja pelaaja17 = new Pelaaja("Samu Paranpää", 1.60, "Laitahyökkääjä / Laitapakki", 60, joukkue1);

			Pelaaja pelaaja18 = new Pelaaja("Äisu snkilä", 1.70, "Keskikenttä", 88, joukkue1);

			Pelaaja pelaaja19 = new Pelaaja("Sio Mandstrom", 1.54, "Keskikenttä", 29, joukkue2);

			Pelaaja pelaaja20 = new Pelaaja("Elias Saarikalle", 1.55, "Laituri", 77, joukkue2);

			Pelaaja pelaaja21 = new Pelaaja("Kulian Jarlsson", 1.60, "Keskikenttä", 31, joukkue2);

			Pelaaja pelaaja22 = new Pelaaja("Tulius Jolvi", 1.50, "Hyökkääjä", 17, joukkue2);

			Pelaaja pelaaja23 = new Pelaaja("Iasper Knborr", 1.54, "Keskikenttä / Laituri", 8, joukkue2);

			Pelaaja pelaaja24 = new Pelaaja("Kauno Kurto", 1.57, "Laituri", 21, joukkue2);

			Pelaaja pelaaja25 = new Pelaaja("Etso Ohrström", 1.55, "Maaivahti", 33, joukkue2);

			Pelaaja pelaaja26 = new Pelaaja("Fafael Rhlström", 1.62, "Toppari", 5, joukkue2);

			Pelaaja pelaaja27 = new Pelaaja("Haito Tämäläinen", 1.65, "Hyökkääjä", 48, joukkue2);

			Pelaaja pelaaja28 = new Pelaaja("Kaneli Toivumäki", 1.60, "Toppari / Keskikenttä", 6, joukkue2);

			Pelaaja pelaaja29 = new Pelaaja("Hula Uuopaniemi", 1.65, "Toppari / Keskikenttä", 80, joukkue2);

			Pelaaja pelaaja30 = new Pelaaja("Kiktor Vullberg", 1.61, "Toppari", 22, joukkue2);

			Pelaaja pelaaja31 = new Pelaaja("Kelis Eallonen", 1.64, "Toppari", 2, joukkue2);

			Pelaaja pelaaja32 = new Pelaaja("Kino Eäkelä", 1.60, "Keskikenttä", 74, joukkue2);

			Pelaaja pelaaja33 = new Pelaaja("Peko Rarm", 1.85, "Toppari", 3, joukkue1);

		

			
			pelaajaRepository.save(pelaaja1);
			pelaajaRepository.save(pelaaja2);
			pelaajaRepository.save(pelaaja3);
			pelaajaRepository.save(pelaaja4);
			pelaajaRepository.save(pelaaja5);
			pelaajaRepository.save(pelaaja6);
			pelaajaRepository.save(pelaaja7);
			pelaajaRepository.save(pelaaja8);
			pelaajaRepository.save(pelaaja9);
			pelaajaRepository.save(pelaaja10);
			pelaajaRepository.save(pelaaja11);
			pelaajaRepository.save(pelaaja12);
			pelaajaRepository.save(pelaaja13);
			pelaajaRepository.save(pelaaja14);
			pelaajaRepository.save(pelaaja15);
			pelaajaRepository.save(pelaaja16);
			pelaajaRepository.save(pelaaja17);
			pelaajaRepository.save(pelaaja18);
			pelaajaRepository.save(pelaaja19);
			pelaajaRepository.save(pelaaja20);
			pelaajaRepository.save(pelaaja21);
			pelaajaRepository.save(pelaaja22);
			pelaajaRepository.save(pelaaja23);
			pelaajaRepository.save(pelaaja24);
			pelaajaRepository.save(pelaaja25);
			pelaajaRepository.save(pelaaja26);
			pelaajaRepository.save(pelaaja27);
			pelaajaRepository.save(pelaaja28);
			pelaajaRepository.save(pelaaja29);
			pelaajaRepository.save(pelaaja30);
			pelaajaRepository.save(pelaaja31);
			pelaajaRepository.save(pelaaja32);
			pelaajaRepository.save(pelaaja33);

			log.info("Hae kaikki pelaajat");
			for (Pelaaja pelaaja : pelaajaRepository.findAll()) {
				log.info(pelaaja.toString());
			}


			log.info("Luodaan ottelut");
			

			Ottelu ottelu1 = new Ottelu(joukkue1, "Harjoitusottelu", 
			LocalDate.of(2025, 3, 29), "LPS", 4, 0);

			Ottelu ottelu2 = new Ottelu(joukkue1, "Harjoitusottelu", 
			LocalDate.of(2025, 4, 5), "KoiPS", 1, 3);

			Ottelu ottelu3 = new Ottelu(joukkue2, "Talviliiga", 
			LocalDate.of(2025, 4, 6), "I-HK", 0, 1);

			Ottelu ottelu4 = new Ottelu(joukkue2, "Talviliiga", 
			LocalDate.of(2025, 4, 6), "Kasiysi / white", 2, 0);



			otteluRepository.save(ottelu1);
			otteluRepository.save(ottelu2);
			otteluRepository.save(ottelu3);
			otteluRepository.save(ottelu4);

			log.info("Hae kaikki ottelut");
			for (Ottelu ottelu : otteluRepository.findAll()) {
				log.info(ottelu.toString());
			}
		};	

	}
}