package com.company;

import java.io.OptionalDataException;

class Membru{
    private String nume;
    private String prenume;
    private int varsta;
    private double salariu;
    private int numarAniExperienta;

    public String getNume(){
        return nume;
    }
    public int getNumarAniExperienta(){
        return numarAniExperienta;
    }
}

abstract class Echipa{
    private String nume;
    private int numarMaximMembri;
    private int numarMembriCurenti;
    private Membru lider;
    public Membru[]membri=new Membru[numarMaximMembri];
    public Echipa(String nume, int numarMaximMembri){
        this.nume=nume;
        this.numarMaximMembri=numarMaximMembri;
    }


    public boolean addMember(Membru member){
        if(numarMembriCurenti<numarMaximMembri) {
            membri[numarMembriCurenti++] = member;
            return true;
        }else return false;
        }

        public boolean setLeader(Membru liderNou){
        if(liderNou.getNumarAniExperienta()>=5){
            lider=liderNou;
            return true;
        }
        return false;
    }
    public Membru removeMember(Membru member){
        for(int i=0;i<numarMembriCurenti;i++){
            if(member.equals(membri[i])==true){
                for(int j=i;j<numarMembriCurenti;j++)
                    membri[j]=membri[j+1];
                membri[numarMembriCurenti-1]=null;
                numarMembriCurenti--;
                return member;
            }
            return null;
        }

        public String toString(){
            String init="Lider echipa:"+lider.getNume()+"";
            for(int i=0;i<numarMembriCurenti;i++)
                init=init+membri[i].getNume()+"";
            return init;
        }

        public void setNumarMaximMembri(int numar,Membru member){
            if(this.getLider().equals(member))
                this.numarMaximMembri=numar;
            else{
                System.out.println("Doar liderul poate sa schimbe aceste date");
            }
        }

        public abstract double getCost();
    }

    protected abstract Object getLider();
}

