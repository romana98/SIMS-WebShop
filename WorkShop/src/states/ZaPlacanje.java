package states;

import classes.Porudzbina;

public class ZaPlacanje extends StanjePorudzbine {

	public ZaPlacanje(Porudzbina aKontekst) {
		super(aKontekst);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void entry() {
		// TODO Auto-generated method stub

	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plati() {
		// TODO Auto-generated method stub
		//ovde ide kod za automat koji skida novac ili sta vec

	}

	@Override
	public void otpremi() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Za Placanje";
	}

	@Override
	public void prihvati() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void odbij() {
		// TODO Auto-generated method stub
		
	}
	
	

}
