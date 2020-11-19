/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package champollion;

import java.util.Date;

/**
 *
 * @author gauthierpous
 */
public class Intervention {
    private Salle s;
    private UE u;
    private Enseignant e;
    private TypeIntervention ti;
    
    private Date debut;
    private int duree;
    private boolean annulee = false;
    
    
    public Intervention(Salle s, UE u, Enseignant e, TypeIntervention ti, Date deb, int duree){  
        this.s = s;
        this.u = u;
        this.e = e;
        this.ti = ti;
        this.debut = deb;
        this.duree = duree;
    }

    public void setS(Salle s) {
        this.s = s;
    }

    public void setU(UE u) {
        this.u = u;
    }

    public void setE(Enseignant e) {
        this.e = e;
    }

    public void setTi(TypeIntervention ti) {
        this.ti = ti;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public Salle getS() {
        return s;
    }

    public UE getU() {
        return u;
    }

    public Enseignant getE() {
        return e;
    }

    public TypeIntervention getTi() {
        return ti;
    }

    public Date getDebut() {
        return debut;
    }

    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }
    
    
}
