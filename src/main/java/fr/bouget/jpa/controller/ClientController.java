package fr.bouget.jpa.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bouget.jpa.model.Adresse;
import fr.bouget.jpa.model.Client;
import fr.bouget.jpa.repository.ClientRepository;

/**
 * @author Philippe
 *
 */
@CrossOrigin("*")
@RestController
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/accueil")
	@ResponseBody
	public String home()
	{

		Client client1=new Client("MARTIN","Jean");
		client1=clientRepository.save(client1);

		Adresse adresse1=new Adresse("5, rue du Renard","","75015","PARIS","FRANCE");
		Client client2=new Client("DUPONT","sophie",adresse1);
		clientRepository.save(client2);

		Client client3=new Client("DURAND","Pierre",new Adresse("20, boulevard Gambetta","","78300","POISSY","FRANCE"));
		client3=clientRepository.save(client3);

		Client client4=new Client("MADEC","Denis",new Adresse("29, boulevard Devaux","","78300","POISSY","FRANCE"));
		client4=clientRepository.save(client4);

		System.out.println("Liste de tous les clients:");
		this.affiche(clientRepository.findAll());


		System.out.println("MARTIN Jean habite désormais avec DUPONT Sophie");
		client1.setAdresse(adresse1);
		clientRepository.save(client1);


		System.out.println("DURAND Pierre change d'adresse");
		Adresse newAdresse = new Adresse("6 place de l'église","","35740","PACE","FRANCE");
		client3.setAdresse(newAdresse);
		clientRepository.save(client3);
		

		System.out.println("MADEC Denis se désinscrit");
		clientRepository.delete(client4);

		System.out.println("Liste de tous les clients:");
		this.affiche(clientRepository.findAll());

		StringBuilder sb = new StringBuilder();
		sb.append("<h1>Regardez dans votre console et dans votre base de données MySQL <strong>JPA</strong></h1>");
		sb.append("<a href='http://localhost:8080/clients'>Voir la liste des clients enregistrés</a>");
		return  sb.toString();

	}

	@GetMapping(value = "/clients")
	public ResponseEntity<?> getAll(){
		List<Client> liste = null;
		try
		{
			liste = clientRepository.findAll();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

		return ResponseEntity.status(HttpStatus.OK).body(liste);
	}

	/**
	 * Méthode pour affichage dans la console
	 * @param liste
	 */
	private void affiche(Collection<Client> liste)
	{

		for (Client client : liste) {

			System.out.println(client);
		}



	}




}
