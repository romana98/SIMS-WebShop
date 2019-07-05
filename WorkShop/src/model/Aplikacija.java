package model;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import classes.*;
import enums.Boja;
import enums.Pol;
import enums.TipKorisnika;
import states.Stanje;

/***********************************************************************
 * Module:  Aplikacija.java
 * Author:  Vukasin
 * Purpose: Defines the Class Aplikacija
 ***********************************************************************/


public class Aplikacija {
	
   private TipKorisnika aktivniKorisnik;
   private int id;
   
   public ArrayList<Grad> gradovi;
   public ArrayList<Artikl> artikli;
   public ArrayList<Korisnik> korisnici;
   public ArrayList<Korpa> korpe;
   public ArrayList<Kategorija> kategorije;
   public ArrayList<Prodavnica> prodavnice;
   public ArrayList<Porudzbina> porudzbine;
   
   public SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy.");
   
   public Aplikacija() {}
   
   public Aplikacija(ArrayList<String> naziviFajlova)
   {
	   //TODO Mico, good luck
	   try{
		   ucitajIzFajla(naziviFajlova); 
	   }
	   catch(IOException e){
		   e.printStackTrace();
	   }catch(ParseException e){
		   e.printStackTrace();
	   }
   }
   
   public Aplikacija(TipKorisnika aktivniKorisnik, int id, ArrayList<Grad> grad, ArrayList<Artikl> artikl,
		ArrayList<Korisnik> korisnik, ArrayList<Korpa> korpa, ArrayList<Kategorija> kategorija,
		ArrayList<Prodavnica> prodavnica) 
   {
	super();
	this.aktivniKorisnik = aktivniKorisnik;
	this.id = id;
	this.gradovi = grad;
	this.artikli = artikl;
	this.korisnici = korisnik;
	this.korpe = korpa;
	this.kategorije = kategorija;
	this.prodavnice = prodavnica;
   }   
   

   public void dodajKorisnika(Korisnik korisnik) {
	   if (korisnik == null)
	         return;
	      if (this.korisnici == null)
	         this.korisnici = new ArrayList<Korisnik>();
	      if (!this.korisnici.contains(korisnik))
	         this.korisnici.add(korisnik);
   }
   

   public void obrisiKorisnika(Korisnik korisnik) {
	   if (korisnik == null)
	         return;
	      if (this.korisnici != null)
	         if (this.korisnici.contains(korisnik))
	            this.korisnici.remove(korisnik);
   }
   

   public Korisnik nadjiKorisnika(int jmbg) {
      for (Korisnik korisnik : korisnici) {
    	  if (korisnik.getJmbg() == jmbg) {
    		  return korisnik;
    	  }
      }
      return null;
   }
  
   
   public void dodajProdavnicu(Prodavnica prodavnica) {
	   if (prodavnica == null)
	         return;
	      if (this.prodavnice == null)
	         this.prodavnice = new ArrayList<Prodavnica>();
	      if (!this.prodavnice.contains(prodavnica))
	         this.prodavnice.add(prodavnica);
   }
   
   public void obrisiProdavnicu(Prodavnica prodavnica) {
	   if (prodavnica == null)
	         return;
	      if (this.prodavnice != null)
	         if (this.prodavnice.contains(prodavnica))
	            this.prodavnice.remove(prodavnica);   
	      
   }
   
   public Prodavnica nadjiProdavnicu(int idProdavnice) {
	      for (Prodavnica prodavnica : prodavnice) {
	    	  if (prodavnica.getIdProd() == idProdavnice) {
	    		  return prodavnica;
	    	  }
	      }
	      return null;
	   }
   
   
   public void dodajArtikl(Artikl artikl) {
	   if (artikl == null)
	         return;
	      if (this.artikli == null)
	         this.artikli = new ArrayList<Artikl>();
	      if (!this.artikli.contains(artikl))
	         this.artikli.add(artikl);
   }
   
   public Artikl nadjiArtikl(String sifraArtikla) {
      for (Artikl artikl : artikli) {
    	  if (artikl.getSifra() == sifraArtikla) {
    		  return artikl;
    	  }
      }
      return null;
   }
   
   public void obrisiArtikl(Artikl art) {
	   if (art == null)
	         return;
	      if (this.artikli != null)
	         if (this.artikli.contains(art))
	            this.artikli.remove(art);   
	  }
   
   public void dodajKategoriju(Kategorija kategorija) {
	   if (kategorija == null)
	         return;
	      if (this.kategorije == null)
	         this.kategorije = new ArrayList<Kategorija>();
	      if (!this.kategorije.contains(kategorija))
	         this.kategorije.add(kategorija);
   }
   
   public void obrisiKategoriju(Kategorija kategorija) {
	   if (kategorija == null)
	         return;
	      if (this.kategorije != null)
	         if (this.kategorije.contains(kategorija))
	            this.kategorije.remove(kategorija);   }
   
   
   public void izmeniKategoriju(String naziv, String noviNaziv) {
      for (Kategorija kategorija: kategorije) {
    	  if (kategorija.getNaziv().equalsIgnoreCase(naziv)) {
    		  kategorija.setNaziv(noviNaziv);
    		  return;
    	  }
      }
   }
   
   
   public void dodajKorpu(Korpa korpa) {
	   if (korpa == null)
	         return;
	      if (this.korpe == null)
	         this.korpe = new ArrayList<Korpa>();
	      if (!this.korpe.contains(korpa))
	         this.korpe.add(korpa);   }
   
   
   public void obrisiKorpu(Korpa korpa) {
	   if (korpa == null)
	         return;
	      if (this.korpe != null)
	         if (this.korpe.contains(korpa))
	            this.korpe.remove(korpa);
   }
   
   //Metoda koja pronalazi korpu neulogovanog korisnika
   public Korpa nadjiKorpu(int vlasnikId) {
      for (Korpa korpa: korpe) {
    	  if (korpa.getIdNeulog() == vlasnikId) {
    		  return korpa;
    	  }
      }
      return null;
   }
   
   public void dodajGrad(Grad grad) {
	   if (grad == null)
	         return;
	      if (this.gradovi == null)
	         this.gradovi = new ArrayList<Grad>();
	      if (!this.gradovi.contains(grad))
	         this.gradovi.add(grad);   
	   }
   
   
   public Grad nadjiGrad(int postanskiBroj) {
      for (Grad grad: gradovi) {
    	  if (grad.getPostanskiBroj() == postanskiBroj) {
    		  return grad;
    	  }
      }
      return null;
   }
    
   
	public TipKorisnika getAktivniKorisnik() 
	{
		return aktivniKorisnik;
	}
	
	public void setAktivniKorisnik(TipKorisnika aktivniKorisnik) 
	{
		this.aktivniKorisnik = aktivniKorisnik;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	   
	public void ucitajIzFajla(ArrayList<String> naziviFajlova) throws IOException, ParseException
	{
		//TODO: Mico ovde ide tvoja implementacija ucitavanja iz fajla.
		for(String fajl:naziviFajlova){
			if (fajl.equals("Grad")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				String temp;
				while((temp = br.readLine())!= null){
					Grad grad = new Grad();
					String[] delimiter = temp.split("\\|");
					grad.setMesto(delimiter[0]);
					grad.setPostanskiBroj(Integer.parseInt(delimiter[1]));
					gradovi.add(grad);
				}
				br.close();
			}else if(fajl.equals("Kategorija")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				String temp;
				HashMap<Kategorija,String[]> mapa = new HashMap<Kategorija,String[]>();
				while((temp=br.readLine())!=null){
					Kategorija kategorija = new Kategorija();
					String[]delimiter = temp.split("\\|");
					kategorija.setNaziv(delimiter[0]);
					kategorije.add(kategorija);
					String[] delimiter2 = delimiter[1].split("\\,");
					mapa.put(kategorija, delimiter2);
				}
			}else if(fajl.equals("Artikl")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				String temp;
				while((temp=br.readLine())!=null){
					Artikl artikl = new Artikl();
					String[] delimiter = temp.split("\\|");
					artikl.setSifra(delimiter[0]);
					artikl.setSlika(delimiter[1]);
					artikl.setNaziv(delimiter[2]);
					artikl.setStanje(Integer.parseInt(delimiter[3]));
					artikl.setCena(Integer.parseInt(delimiter[4]));
					artikl.setBoja(Boja.valueOf(delimiter[5]));
					artikl.setAktivan(Boolean.parseBoolean(delimiter[6]));
					for(Kategorija k:kategorije){
						if(k.getNaziv().equals(delimiter[7])){
							artikl.setKategorija(k);
						}
					}
					artikli.add(artikl);
				}
				br.close();
			}else if(fajl.equals("Korisnik")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				String temp;
				while((temp=br.readLine())!=null){
					Korisnik k = new Korisnik();
					String[] delimiter = temp.split("\\|");
					k.setEmail(delimiter[0]);
					k.setTelefon(delimiter[1]);
					k.setIme(delimiter[2]);
					k.setPrezime(delimiter[3]);
					k.setJmbg(Integer.parseInt(delimiter[4]));
					k.setPol(Pol.valueOf(delimiter[5]));
					k.setKorisnickoIme(delimiter[6]);
					k.setSifra(delimiter[7]);
					k.setDatumRodj(format.parse(delimiter[8]));
					String[] delimiter2 = delimiter[9].split("\\%");
					Adresa a = new Adresa();
					a.setUlica(delimiter2[0]);
					a.setBroj(Integer.parseInt(delimiter2[1]));
					for(Grad g:gradovi){
						if(g.getPostanskiBroj()==Integer.parseInt(delimiter2[2])){
							a.setGrad(g);
						}
					}
					k.setAdresa(a);
					ArrayList<Porudzbina> porudzbineK = new ArrayList<Porudzbina>();
					String[] delimiter3 = delimiter[10].split("\\,");
					for(int i = 0;i<delimiter3.length;i++){
						for(Porudzbina p:porudzbine){
							if(p.getBrojPor()==Integer.parseInt(delimiter3[i])){
								porudzbineK.add(p);
							}
						}
					}
					k.setPorudzbina(porudzbineK);
					String[] delimiter4 = delimiter[11].split("\\,");
					ArrayList<Artikl> listaZeljaK = new ArrayList<Artikl>();
					for(int i = 0;i<delimiter4.length;i++){
						for(Artikl a1:artikli){
							if(a1.getSifra().equals(delimiter4[i])){
								listaZeljaK.add(a1);
							}
						}
					}
					k.setArtikl(listaZeljaK);
					String[] delimiter5 = delimiter[12].split("\\,");
					ArrayList<Stavka> stavkeK = new ArrayList<Stavka>();
					for(int i = 0;i<delimiter5.length;i++){
						String[] delimiter6 = delimiter5[i].split("\\%");
						for(Artikl a2:artikli){
							if(a2.getSifra().equals(delimiter6[0])){
								Stavka s = new Stavka();
								s.setArtikl(a2);
								s.setKolicina(Integer.parseInt(delimiter6[1]));
								stavkeK.add(s);
							}
						}
					}
					Korpa korpa = new Korpa();
					korpa.setStavka(stavkeK);
					k.setKorpa(korpa);
				}
				br.close();
			}else if(fajl.equals("Prodavnica")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				
				String temp;
				while((temp=br.readLine())!=null){
					Prodavnica p = new Prodavnica();
					String[] delimiter = temp.split("\\|");
					p.setPocetakRadVr(delimiter[0]);
					p.setKrajRadVr(delimiter[1]);
					p.setNaziv(delimiter[2]);
					p.setEmail(delimiter[3]);
					String[] delimiter2 = delimiter[4].split("\\,");
					HashMap<Artikl,Integer> raspolozivost = new HashMap<Artikl,Integer>();
					for(int i = 0;i<delimiter2.length;i++){
						String[]delimiter3 = delimiter2[i].split("\\%");
						for(Artikl a3:artikli){
							if(a3.getSifra().equals(delimiter3[0])){
								raspolozivost.put(a3, Integer.parseInt(delimiter3[1]));
							}
						}
					}
					p.setRaspolozivo(raspolozivost);
					String[] delimiter4 = delimiter[5].split("\\%");
					Adresa adresa = new Adresa();
					adresa.setUlica(delimiter4[0]);
					adresa.setBroj(Integer.parseInt(delimiter4[1]));
					for(Grad g:gradovi){
						if(g.getPostanskiBroj()==Integer.parseInt(delimiter4[2])){
							adresa.setGrad(g);
						}
					}
					p.setAdresa(adresa);
				}
				br.close();
			}else if(fajl.equals("Porudzbina")){
				BufferedReader br = new BufferedReader(new FileReader(".\\Files\\"+fajl+".txt"));
				
				String temp;
				while((temp=br.readLine())!=null){
					Porudzbina p = new Porudzbina();
					String[] delimiter = temp.split("\\|");
					p.setBrojPor(Integer.parseInt(delimiter[0]));
					p.setUkupnaCena(Integer.parseInt(delimiter[1]));
					p.setDatumPorucivanja(format.parse(delimiter[2]));
					String[] delimiter2 = delimiter[3].split("\\,");
					HashMap<String,Integer> mapa = new HashMap<String,Integer>();
					for(int i = 0;i<delimiter2.length;i++){
						String[] delimiter3 = delimiter2[i].split("\\%");
						mapa.put(delimiter3[0], Integer.parseInt(delimiter3[1]));
					}
					p.setCene(mapa);
					//NISAM DODAO STANJE JER NZM :)
				}
			}
		}
	}
	
	public void sacuvajUFajl(ArrayList<String> naziviFajlova) throws IOException
	{
		File fajlGrad = new File(".\\Files\\" + naziviFajlova.get(0) +".txt");
		File fajlArtikl = new File(".\\Files\\" + naziviFajlova.get(1) +".txt");
		File fajlKorisnik = new File(".\\Files\\" + naziviFajlova.get(2) +".txt");
		File fajlKategorija = new File(".\\Files\\" + naziviFajlova.get(3) +".txt");
		File fajlProdavnica = new File(".\\Files\\" + naziviFajlova.get(4) +".txt");
		File fajlPorudzbina = new File(".\\Files\\" + naziviFajlova.get(5) +".txt");
		
		fajlGrad.createNewFile();
		fajlArtikl.createNewFile();
		fajlKorisnik.createNewFile();
		fajlKategorija.createNewFile();
		fajlProdavnica.createNewFile();
		fajlPorudzbina.createNewFile();
		
		PrintWriter pwGrad = new PrintWriter(new FileWriter(fajlGrad));
		PrintWriter pwArtikl = new PrintWriter(new FileWriter(fajlArtikl));
		PrintWriter pwKorisnik = new PrintWriter(new FileWriter(fajlKorisnik));
		PrintWriter pwKategorija = new PrintWriter(new FileWriter(fajlKategorija));
		PrintWriter pwProdavnica = new PrintWriter(new FileWriter(fajlProdavnica));
		PrintWriter pwPorudzbina = new PrintWriter(new FileWriter(fajlPorudzbina));
		
		Iterator<Grad> itGrad = gradovi.iterator();
		Iterator<Artikl> itArtikl = artikli.iterator();
		Iterator<Korisnik> itKorisnik = korisnici.iterator();
		Iterator<Kategorija> itKategorija = kategorije.iterator();
		Iterator<Prodavnica> itProdavnica = prodavnice.iterator();
		
		String unos;
		
		while(itGrad.hasNext())
		{
			unos = itGrad.next().getMesto() + "|" + itGrad.next().getPostanskiBroj();
			pwGrad.println(unos);
			pwGrad.flush();
		}
		 
		while(itArtikl.hasNext())
		{
			unos = itArtikl.next().getSifra() + "|" + itArtikl.next().getSlika() + "|" + itArtikl.next().getNaziv() + "|" + 
					itArtikl.next().getStanje() + "|" + itArtikl.next().getCena() + "|" + itArtikl.next().getBoja() + "|" + 
					itArtikl.next() + "|" + itArtikl.next().getAktivan() + "|" + itArtikl.next().getKategorija().getNaziv();
			pwArtikl.println(unos);
			pwArtikl.flush();
		}
		
		String unosPor;
		while(itKorisnik.hasNext())
		{
			StringBuilder sbKorPor = new StringBuilder();
			StringBuilder sbKorLisZ = new StringBuilder();
			StringBuilder sbKorKorpa = new StringBuilder();
			Iterator<Porudzbina> itPor = itKorisnik.next().getIteratorPorudzbina();
			Iterator<Artikl> itLisZ = itKorisnik.next().getIteratorListaZelja();
			Iterator<Stavka> itKorpa = itKorisnik.next().getKorpa().getIteratorStavka();
			
			while(itPor.hasNext())
			{
				sbKorPor.append(itPor.next().getBrojPor() + ",");
				
				StringBuilder sbPor = new StringBuilder();
				
				for (Map.Entry<String, Integer> entry : itPor.next().getCene().entrySet())  
				{
					sbPor.append(entry.getKey() + ":" + entry.getValue() + ",");
				}
				sbPor.deleteCharAt(sbPor.length() - 1);
		
				unosPor = itPor.next().getBrojPor() + "|" + itPor.next().getUkupnaCena() + "|" + 
						format.format(itPor.next().getDatumPorucivanja()) + "|" + sbPor.toString() + "|" + itPor.next().getStanje();
				pwPorudzbina.println(unosPor);
				pwPorudzbina.flush();
				
			}
			sbKorPor.deleteCharAt(sbKorPor.length() - 1);
			
			while(itLisZ.hasNext())
			{
				sbKorLisZ.append(itLisZ.next().getSifra() + ",");
			}
			sbKorLisZ.deleteCharAt(sbKorLisZ.length() - 1);
			
			while(itKorpa.hasNext())
			{
				sbKorKorpa.append(itKorpa.next().getArtikl().getSifra() + "%" + itKorpa.next().getKolicina() + ",");
			}
			sbKorKorpa.deleteCharAt(sbKorKorpa.length() - 1);
			
			unos = itKorisnik.next().getEmail() + "|" + itKorisnik.next().getTelefon() + "|" + itKorisnik.next().getIme() + "|" + 
					itKorisnik.next().getPrezime() + "|" + itKorisnik.next().getJmbg() + "|" + itKorisnik.next().getPol() + "|" + 
					itKorisnik.next().getKorisnickoIme() + "|" + itKorisnik.next().getSifra() + "|" + format.format(itKorisnik.next().getDatumRodj())
					+ "|" + itKorisnik.next().getAdresa().getUlica() + "%" + itKorisnik.next().getAdresa().getBroj() + itKorisnik.next().getAdresa().getGrad().getPostanskiBroj()
					+ "|" + sbKorPor.toString() + "|" + sbKorLisZ.toString() + "|" + sbKorKorpa.toString();
			pwKorisnik.println(unos);
			pwKorisnik.flush();
		}
		
		while(itKategorija.hasNext())
		{
			StringBuilder sbKat = new StringBuilder();
			Iterator<Kategorija> itKatKat = itKategorija.next().getIteratorKategorijaB();
			
			while(itKatKat.hasNext())
			{
				sbKat.append(itKatKat.next().getNaziv() + ",");
			}
			sbKat.deleteCharAt(sbKat.length() - 1);
			
			unos = itKategorija.next().getNaziv() + "|" + sbKat.toString();
			pwKategorija.println(unos);
			pwKategorija.flush();
		}
		
		while(itProdavnica.hasNext())
		{
			StringBuilder sbPro = new StringBuilder();
			
			for (Map.Entry<Artikl, Integer> entry : itProdavnica.next().getRaspolozivo().entrySet())  
			{
				sbPro.append(entry.getKey() + ":" + entry.getValue() + ",");
			}
			sbPro.deleteCharAt(sbPro.length() - 1);
			
			unos = itProdavnica.next().getPocetakRadVr() + "|" + itProdavnica.next().getKrajRadVr() + "|" +
					itProdavnica.next().getNaziv() + "|" + itProdavnica.next().getEmail() + "|" + sbPro.toString() + "|" + 
					itProdavnica.next().getAdresa().getUlica() + "%" + itProdavnica.next().getAdresa().getBroj() + "%" +
					itProdavnica.next().getAdresa().getGrad().getPostanskiBroj();
			pwProdavnica.println(unos);
			pwProdavnica.flush();
		}
		
		
		pwGrad.close();
		pwArtikl.close();
		pwKorisnik.close();
		pwKategorija.close();
		pwProdavnica.close();
		pwPorudzbina.close();	
	}

}