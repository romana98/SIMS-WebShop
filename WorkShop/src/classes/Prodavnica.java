package classes;
/***********************************************************************
 * Module:  Prodavnica.java
 * Author:  Vukasin
 * Purpose: Defines the Class Prodavnica
 ***********************************************************************/

import java.util.*;

/** @pdOid 3e3c3061-8a16-4300-a65a-3919a829d8b0 */
public class Prodavnica {
   /** @pdOid f45efef4-7c2d-41d6-9e78-161de38bd556 */
   private String pocetakRadVr;
   /** @pdOid b9e82adb-252d-4974-b400-201377d1519e */
   private String krajRadVr;
   /** @pdOid 0498c6d2-3605-4531-9d1b-140da2b6fb6f */
   private String naziv;
   /** @pdOid 8868d89c-3a51-4761-bcc1-13a92bc289fe */
   private String email;
   private int idProd;
   
   public HashMap<Artikl, Integer> Raspolozivo;
   /** @pdRoleInfo migr=no name=Adresa assc=association5 mult=1..1 */
   public Adresa adresa;
   
   
   public Prodavnica() {
	   Raspolozivo = new HashMap<Artikl,Integer>();
   }
   
   public Prodavnica(int id, String pocetakRadVr, String krajRadVr, String naziv, String email,
		HashMap<Artikl, Integer> raspolozivo, Adresa adresa) 
   {
	super();
	this.idProd = id;
	this.pocetakRadVr = pocetakRadVr;
	this.krajRadVr = krajRadVr;
	this.naziv = naziv;
	this.email = email;
	Raspolozivo = raspolozivo;
	this.adresa = adresa;
   }


/** @param sifraArtikla
    * @pdOid 02fbda89-6eb2-41e1-a260-134ecd2d6d3c */
   public void dodajArtikl(Artikl art) {
	   Raspolozivo.put(art, 0);
   }
   
   /** @pdOid c3a7e8de-6cca-4d7f-8096-be28eb408627 */
   public void azurirajArtikl() {
	   Raspolozivo.entrySet().removeIf(entry -> entry.getKey().getAktivan() == false);
   }
   
   /** @param sifraArtikla 
    * @param kolicina
    * @pdOid 37f27c38-398c-4587-8af0-a1af08dd3f4b */
   public Boolean prodatArtikl(String sifraArtikla, int kolicina) {
	   
	   for (Map.Entry<Artikl, Integer> entry : Raspolozivo.entrySet())  
           if(sifraArtikla.equals(entry.getKey().getNaziv())) 
           {
        	   int newValue = entry.getValue() - 1;
        	   entry.setValue(newValue); 
        	   return true;
           }   
	   return false;
   }
   
   /** @param sifraArtikla 
    * @param kolicina
    * @pdOid ed522e49-835f-48dc-8ffd-a4a0cfb34f46 */
   public Boolean stigaoArtikl(String sifraArtikla, int kolicina) {
	   for (Map.Entry<Artikl, Integer> entry : Raspolozivo.entrySet())  
           if(sifraArtikla.equals(entry.getKey().getNaziv())) 
           {
        	   entry.setValue(kolicina); 
        	   return true;
           }
	   return false;
   }
        	   

	public String getPocetakRadVr() {
		return pocetakRadVr;
	}
	
	public void setPocetakRadVr(String pocetakRadVr) {
		this.pocetakRadVr = pocetakRadVr;
	}
	
	public String getKrajRadVr() {
		return krajRadVr;
	}
	
	public void setKrajRadVr(String krajRadVr) {
		this.krajRadVr = krajRadVr;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Adresa getAdresa() {
		return adresa;
	}
	
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public HashMap<Artikl, Integer> getRaspolozivo() {
		return Raspolozivo;
	}

	public void setRaspolozivo(HashMap<Artikl, Integer> raspolozivo) {
		Raspolozivo = raspolozivo;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

}