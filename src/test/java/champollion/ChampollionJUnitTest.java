package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testAjouteHeuresCM() {
                //6 CM pour UML
                untel.ajouteEnseignement(uml, 6, 0, 0);
                //9 car 6*1.5
                assertEquals(9, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 9 heures prévues pour l'UE 'uml'");
        }
        
        @Test
        public void testAjouteHeuresTP() {
                //16 TP pour java
                untel.ajouteEnseignement(java, 0, 0, 16);
                //12 car 16*0.75
                assertEquals(12, untel.heuresPrevuesPourUE(java),
                        "L'enseignant doit maintenant avoir 15 heures prévues pour l'UE 'uml'");
        }
	
        @Test
        public void testEnSousService() {
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertEquals(true, untel.enSousService(), "L'enseignant doit être en sous-service car il n'a pas 192 heures équivalent TD (ici il en a 10)");
            untel.ajouteEnseignement(uml, 0, 182, 0);
            assertEquals(false, untel.enSousService(), "L'enseignant n'est pas en sous-service car il a au moins 192 heures équivalent TD (ici il en a 192)");
            untel.ajouteEnseignement(uml, 0, 10, 0);
            assertEquals(false, untel.enSousService(), "L'enseignant n'est pas en sous-service car il a au moins 192 heures équivalent TD (ici il en a 202)");
        }
        
        @Test
        public void testHeuresPlanifiees(){
            
        }
}
