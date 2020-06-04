package com.etf.telfor.api;

import com.etf.telfor.data.Author;
import com.etf.telfor.data.AuthorPaper;
import com.etf.telfor.data.Chairperson;
import com.etf.telfor.data.Paper;
import com.etf.telfor.data.Section;
import com.etf.telfor.data.Session;

import java.util.ArrayList;

public class FakeApi {

    public static ArrayList<Author> getAuthors(){
        ArrayList<Author> list = new ArrayList<>();

        list.add(new Author(1,"Pavel","Bradic","bpavle0@gmail.com","Serbia","School of Electrical Engineering"));
        list.add(new Author(1,"Aleksandar","Micic","cicim100@gmail.com","Serbia","School of Electrical Engineering"));
        list.add(new Author(1,"Filip","Popadic","pop@spc.com","Serbia","Economist with bank of SPC"));
        list.add(new Author(1,"Marina","Popadic","popadiicm@gmail.com","Serbia","Lawyer in lawyers office Popadic"));
        list.add(new Author(1,"Jelena","Bradic","jelena.bradic68@gmail.com","Serbia","Founder and multi milionare at Lenaspassport"));
        list.add(new Author(1,"Milos","Cvetkovic","cvetko@kukuriku.gov.rs","Serbia","Chef executive of Kukuriku city"));
        list.add(new Author(1,"Pavel","Bradic","bpavle0@gmail.com","Serbia","School of Electrical Engineering"));
        list.add(new Author(1,"Pavel","Bradic","bpavle0@gmail.com","Serbia","School of Electrical Engineering"));
        list.add(new Author(1,"Pavel","Bradic","bpavle0@gmail.com","Serbia","School of Electrical Engineering"));

        return list;
    }
    public static ArrayList<Paper> getPapers(){
        ArrayList<Paper> list = new ArrayList<>();
        list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                        " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                        "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Ovo je malo duzi naslov nekog velikog naucog rada na telfor koferenciji. I ona mora lepo da se vidi i bude fino prikazan",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));
         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));

         list.add(new Paper(1,"Pregled svih radova na telfor konferenciji",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));
         list.add(new Paper(1,"Naslov",
                 "U ovom radu ce biti opisani svi radovi na ovogodisnjoj telfor konferenciji."
                         +"Specijalna zahvalnost katedri za telekomunikacije elektrotehnickog fakulteta" +
                         " univerziteta u beogradu.Zahvljujemo se i kompanijama " +
                         "koje su svojm dolaskom uvelicale ovaj doganjaj.","pregled,radovi,zahvalnica"));



        return list;
     }
    public static ArrayList<Section> getSections(){
        ArrayList<Section> list = new ArrayList<>();

        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));
        list.add(new Section(1,"Neka sekcija o telekomunikacijma nemam pojma"));


        return list;
    }
    public static ArrayList<Chairperson> getChairpersons(){
        ArrayList<Chairperson> list = new ArrayList<>();

        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));
        list.add(new Chairperson(1,"Timislav","Timkovic"));


        return list;
    }
    public static ArrayList<AuthorPaper> getAuthorPapers(){
        ArrayList<AuthorPaper> list = new ArrayList<>();

        Author a1 = new Author(1,"PAvle","Bradic","pbrada","Serbia","School of Electrical Engineering");
        Author a2 = new Author(1,"Pera","Peric","zpera","Serbia","School of Electrical Engineering");
        Author a3 = new Author(1,"Mika","Mikic","mmika","Serbia","School of Electrical Engineering");
        Author a4 = new Author(1,"Zika","Zikic","zikole","Serbia","Faculty of organization science");

        Paper p1 = new Paper(1,"Upravljanje procesima u telekomunikacijama","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p2 = new Paper(1,"Modelovanje tacka-tacka linkova u optickim telekomunikacijama","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p3 = new Paper(1,"Kratak naslov","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p4 = new Paper(1,"Naslovkojisesastojioddugackenekestrucnereci","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");

        list.add(new AuthorPaper(1,a1,p1,"1.4"));
        list.add(new AuthorPaper(1,a1,p2,"1.4"));
        list.add(new AuthorPaper(1,a1,p3,"1.4"));
        list.add(new AuthorPaper(1,a1,p4,"1.4"));
        list.add(new AuthorPaper(1,a2,p1,"1.4"));
        list.add(new AuthorPaper(1,a3,p1,"1.4"));
        list.add(new AuthorPaper(1,a1,p1,"1.4"));
        list.add(new AuthorPaper(1,a1,p1,"1.4"));
        list.add(new AuthorPaper(1,a4,p4,"1.4"));


        return list;
    }
    public static ArrayList<Session> getSessions(){
        ArrayList<Session> list = new ArrayList<>();
        Author a1 = new Author(1,"PAvle","Bradic","pbrada","Serbia","School of Electrical Engineering");
        Author a2 = new Author(1,"Pera","Peric","zpera","Serbia","School of Electrical Engineering");
        Author a3 = new Author(1,"Mika","Mikic","mmika","Serbia","School of Electrical Engineering");
        Author a4 = new Author(1,"Zika","Zikic","zikole","Serbia","Faculty of organization science");

        Paper p1 = new Paper(1,"Upravljanje procesima u telekomunikacijama","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p2 = new Paper(1,"Modelovanje tacka-tacka linkova u optickim telekomunikacijama","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p3 = new Paper(1,"Kratak naslov","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");
        Paper p4 = new Paper(1,"Naslovkojisesastojioddugackenekestrucnereci","Ovo bi bio primer onog abstract dela u kojem pise skraceni opis samog reda. Njega kao o kewords deo cu da ukljucim u pretragu kada korisnig bude pretrazivao radove","rad,telekomunikacije,upravljanje");

        Chairperson c1 = new Chairperson(1,"Predsednik","Predsedavajuci");
        Chairperson c2 = new Chairperson(1,"Dejan","Bodiroga");
        Chairperson c3 = new Chairperson(1,"Vlade","Divac");
        Chairperson c4 = new Chairperson(1,"Sasa","Djordjevic");

        Section s1 = new Section(1,"Naslov sekcije neke duzine");
        Section s2 = new Section(1,"Razvoj mobilnih servisa na smeru za telekomunikacije");
        Section s3 = new Section(1,"Projektovanje optickih linkova");
        Section s4 = new Section(1,"Saradnja sa policijskom upravom na projektu SAFE CITY");


        AuthorPaper ap1=(new AuthorPaper(1,a1,p1,"1.4"));
        AuthorPaper ap2=(new AuthorPaper(1,a1,p2,"1.4"));
        AuthorPaper ap3=(new AuthorPaper(1,a1,p3,"1.4"));
        AuthorPaper ap4=(new AuthorPaper(1,a1,p4,"1.4"));
        AuthorPaper ap5=(new AuthorPaper(1,a2,p1,"1.4"));
        AuthorPaper ap6=(new AuthorPaper(1,a3,p1,"1.4"));
        AuthorPaper ap7=(new AuthorPaper(1,a1,p1,"1.4"));
        AuthorPaper ap8=(new AuthorPaper(1,a1,p1,"1.4"));
        AuthorPaper ap9=(new AuthorPaper(1,a4,p4,"1.4"));
        list.add(new Session(1,"Hala 2","22.3.2020.",s1,c1,ap1));
        list.add(new Session(1,"Hala 3","22.3.2020.",s1,c2,ap2));
        list.add(new Session(1,"Hala 2","22.3.2020.",s1,c3,ap3));
        list.add(new Session(1,"Hala 1","22.3.2020.",s2,c4,ap4));
        list.add(new Session(1,"Soba 0","22.3.2020.",s3,c1,ap5));
        list.add(new Session(1,"Hodnik","22.3.2020.",s4,c2,ap6));

        return list;
    }
}
