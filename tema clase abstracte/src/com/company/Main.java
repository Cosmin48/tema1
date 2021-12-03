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
    public Membru lider;
    public Membru[]membri=new Membru[numarMaximMembri];
    public Echipa(String nume, int numarMaximMembri){
        this.nume=nume;
        this.numarMaximMembri=numarMaximMembri;
    }
    public int getNumarAniExperienta(){
        int numarAniExperienta;
        return numarAniExperienta;
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

class DevTeam extends Echipa{
    public DevTeam(String nume,int numar){
        super(nume,numar);
    }
    public double getCost(){
        double cost=0;
        for(int i=0;i<membri.length();i++){
            if(membri.equals(lider)){
                cost=cost+2500+250*lider.getNumarAniExperienta();
            }
            else
                if(getNumarAniExperienta()<2){
                    cost=cost+1500;
                }
                else
                    if(getNumarAniExperienta()>=2&&getNumarAniExperienta()<=5){
                        cost=cost+1500+0.25*getNumarAniExperienta();
                    }
                    else
                        cost=cost+1500+0.5*getNumarAniExperienta();
        }
        return cost;
    }
}

class HR extends Echipa{
    public HR(String nume,int numar){
        super(nume,numar);
    }
    public double getCost(){
        double cost=0;
        for(int i=0;i< membri.length();i++){
            if(membri.equals(lider)){
                cost=cost+1350+300*getNumarAniExperienta();
            }
            else
            if(getNumarAniExperienta()<2){
                cost=cost+1000;
            }
            else
            if(getNumarAniExperienta()>=2&&getNumarAniExperienta()<=5){
                cost=cost+1000+0.25*getNumarAniExperienta();
            }
            else
                cost=cost+1000+0.5*getNumarAniExperienta();
        }
        return cost;
    }
}

class main {
    public static void main(String[] argv){
        Membru lider_nepotrivit=new Membru("Popescu","Vasile",18,3000,3);
        Membru lider_potrivit=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem1=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem2=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem3=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem4=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem5=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem6=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem7=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem8=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem9=new Membru("Popescu","Vasile",18,3000,7);
        Membru mem10=new Membru("Popescu","Vasile",18,3000,7);
        DevTeam dv=new DevTeam("Lapte gros",34);
        HR hr=new HR("De ce Audi mananca ulei-_-",72);
        dv.setLeader(lider_nepotrivit);
        dv.setLeader(lider_nepotrivit);
        dv.addMember(Membru);
        dv.addMember(mem1);
        dv.addMember(mem2);
        dv.addMember(mem4);
        dv.addMember(mem5);
        hr.addMember(mem6);
        hr.addMember(mem7);
        hr.addMember(mem8);
        hr.addMember(mem9);
        hr.addMember(mem10);
        dv.toString();
        hr.toString();
    }
}