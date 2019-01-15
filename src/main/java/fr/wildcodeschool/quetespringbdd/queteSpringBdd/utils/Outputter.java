package fr.wildcodeschool.quetespringbdd.queteSpringBdd.utils;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.wildcodeschool.quetespringbdd.queteSpringBdd.entities.City;
import fr.wildcodeschool.quetespringbdd.queteSpringBdd.repositories.CityDao;
import jdk.internal.jline.internal.Log;


@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wild");

    @Autowired
    private CityDao cityDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD        
        LOG.info("******************");
        LOG.info("Objects in DB : " + cityDao.count());
        
        
        //*************  CREATE
        // Crée une nouvelle ville et l'enregistre dans la BDD
        City City1 = new City("Reims", "51100");
        LOG.info("******************");
        LOG.info(City1 + " has been created !");
        cityDao.save(City1);
        LOG.info(City1 + " has been saved !");

        // Crée une nouvelle ville et l'enregistre dans la BDD
        City City2 = new City("Vervine", "02140");
        LOG.info("******************");
        LOG.info(City2 + " has been created !");
        cityDao.save(City2);
        LOG.info(City2 + " has been saved !");
        
     // Crée une nouvelle ville et l'enregistre dans la BDD
        City City3 = new City("Lille", "59000");
        LOG.info("******************");
        LOG.info(City3 + " has been created !");
        cityDao.save(City3);
        LOG.info(City3 + " has been saved !");
        
        LOG.info("******************");
        LOG.info("Objects in DB should be 3: " + cityDao.count());
        for(City myCity: cityDao.findAll()) {
        	LOG.info(myCity.getCityName());
        }
        LOG.info("******************");
        
        
        //*************  RETRIEVE
        // Recherche la 2ere ville créée
        City tempCity = cityDao.findById(2L).get();
        
        //*************  UPDATE
        tempCity.setCityName("Vervins");
        cityDao.save(tempCity);
        
        //*************	 DELETE
        cityDao.delete(City1);
        
        LOG.info("******************");
        LOG.info("Objects in DB should be 2: " + cityDao.count());
        
        
        
        for(City myCity: cityDao.findAll()) {
        	LOG.info(myCity.toString());
        }
        LOG.info("******************");
        LOG.info("LILLE & VERVINS SHOULD BE LISTED ABOVE");
    }    
}