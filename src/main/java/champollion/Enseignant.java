package champollion;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Enseignant extends Personne {

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML
    private Intervention e;
    private LinkedList<Intervention> listIntervention = new LinkedList<>();
    private ArrayList<ServicePrevu> servicePrevu = new ArrayList<>();
    

    
    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        float totalEquivalentTD = 0;
        for(ServicePrevu service : servicePrevu){
             totalEquivalentTD += (service.getVolumeCM() * 1.5);
             totalEquivalentTD += (service.getVolumeTD() * 1);
             totalEquivalentTD += (service.getVolumeTP() * 0.75);
        }
        return Math.round(totalEquivalentTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        float totalEquivalentTDUE = 0;
        for(ServicePrevu service : servicePrevu){
            if (service.getUe().equals(ue)) {
                totalEquivalentTDUE += (service.getVolumeCM() * 1.5);
                totalEquivalentTDUE += (service.getVolumeTD() * 1);
                totalEquivalentTDUE += (service.getVolumeTP() * 0.75);
            }
        }
        return Math.round(totalEquivalentTDUE);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
            ServicePrevu sp = new ServicePrevu(volumeCM, volumeTD, volumeTP, this, ue);
            servicePrevu.add(sp);
    }
    
    public void ajouteIntervention(Intervention e){
        Intervention intervention = new Intervention(e.getS(), e.getU(), this, e.getTi(), e.getDebut(), e.getDuree());
            listIntervention.add(intervention);
    }
    
    public int heuresPlanifiees(){
        /*
        -----------------------------MESSAGE-----------------------------
        LE CODE NE FONCTIONNE PAS MAIS JE NE SAIS PAS POURQUOI…
        IL Y A DONC UNE VERSION FONCTIONNELLE EN DESSOUS.
        JE VOULAIS SEULEMENT VOUS MONTRER L'AXE SUR LEQUEL J'ÉTAIS PARTI
        MÊME S'IL N'A PAS ABOUTI
        -----------------------------------------------------------------
        
        float heuresPlanifiees = 0;
        listIntervention.forEach((i) -> {
            switch(i.getTi()) {
                case CM:
                    heuresPlanifiees += 1.5*(i.getDuree());
                    break;
                    
                case TD:
                    heuresPlanifiees += 1*(i.getDuree());
                    break;
                    
                case TP:
                    heuresPlanifiees += 0.75*(i.getDuree());
                    break;
                    
                default:
                    break;
            }
        });
        
        return Math.round(heuresPlanifiees);
        */
        float heuresPlanifiees = 0;
        for (int i = 0; i < listIntervention.size(); i++) {
            switch(listIntervention.get(i).getTi()){
                case CM:
                    heuresPlanifiees += 1.5*listIntervention.get(i).getDuree();
                    break;
                
                case TD:
                    heuresPlanifiees += 1*listIntervention.get(i).getDuree();
                    break;
                    
                case TP:
                    heuresPlanifiees += 0.75*listIntervention.get(i).getDuree();
                    break;
            }
        }
        return Math.round(heuresPlanifiees);
    }

    public boolean enSousService(){
        if (heuresPrevues() < 192) {
            return true;
        }
        else{
            return false;
        }
    } 
    

}
