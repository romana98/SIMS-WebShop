package view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import classes.Artikl;
import classes.Kategorija;
import classes.Korisnik;
import classes.Korpa;
import classes.Stavka;
import model.Aplikacija;
import enums.Boja;
import enums.TipKorisnika;

public class ArticleWindow extends JFrame {
	
	private static final long serialVersionUID = 4L;
	JLabel globus_label;
	JLabel globus_label2;
	JScrollPane js;
	JLabel shops_label;
	JLabel login_label;
	JLabel register_label;
	JLabel cart_label;
	ArrayList<JLabel> subcategories = new ArrayList<JLabel>();
	ArrayList<JLabel> subcategories2 = new ArrayList<JLabel>();
	// labele - kategorije
	ArrayList<JLabel> kategorijeLabele = new ArrayList<JLabel>();
	JLabel articlePic, articleName, articleId, articlePrice, articleColor;
	JButton addCart, addWishList;
	JLabel number;
	JLabel naziv;
	JLabel cena;
	JLabel sifra;
	JLabel boja;
	JLabel uzeto;
	JLabel brojUzetih;
	JTextField vrednost;
	JButton plus;
	JButton minus;
	JButton pozoviProdavnice;
	
	
	public ArticleWindow(String articleid, Aplikacija app){
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setTitle("Article view");
		this.setMinimumSize(new Dimension(500, 500));
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		ImageIcon image3 = new ImageIcon("white_background.jpg");
		Image image_tmp3 = getScaledImage(image3.getImage(), screenWidth, screenHeight + 400);
		image3.setImage(image_tmp3);
		
		JLabel background = new JLabel(image3);
		
		//DODAVANJE KATEGORIJA U LABELE
		int x_offset = 220;
		int y_offset = 70;
		for (Kategorija kat : app.kategorije) {
			JLabel label = new JLabel(kat.getNaziv());
			label.setFont(new Font("Serif", Font.PLAIN, 20));
			label.setBounds(x_offset, y_offset, 80, 40);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label.setHorizontalAlignment(JLabel.CENTER);
			kategorijeLabele.add(label);
			background.add(label);
			x_offset = x_offset + 100;
		}
		
		//DODAVANJE NASLOVA
		globus_label = new JLabel("TINY  HOUSE");
		globus_label.setFont(new Font("Serif", Font.BOLD, 40));
		globus_label.setBounds(screenWidth / 2 - 100, 20, 280, 30);
		globus_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE NASLOVA2
		globus_label2 = new JLabel("TINY  HOUSE");
		globus_label2.setFont(new Font("Serif", Font.BOLD, 30));
		globus_label2.setBounds(screenWidth-350,200,250,50);
		globus_label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE NAZIVA ARTIKLA
		Artikl trazeni = new Artikl();
		for(Artikl a:app.artikli){
			if(a.getSifra().equals(articleid)){
				trazeni = a;
				naziv = new JLabel("Ime artikla: ");
				naziv.setFont(new Font("Serif",Font.BOLD,20));
				naziv.setBounds(screenWidth/2 + 20, 200, 300, 40);
				
				articleName = new JLabel(a.getNaziv());
				articleName.setFont(new Font("Serif", Font.PLAIN,20));
				articleName.setBounds(screenWidth/2 + 150, 200, 300, 40);
				
				cena = new JLabel("Cena artikla: ");
				cena.setFont(new Font("Serif", Font.BOLD, 20));
				cena.setBounds(screenWidth/2 + 20, 250, 300, 40);
				
				articlePrice  = new JLabel("RSD " + Integer.toString(a.getCena()));
				articlePrice.setFont(new Font("Serif",Font.PLAIN,20));
				articlePrice.setBounds(screenWidth/2+150,250,300,40);
				
				sifra = new JLabel("Sifra artikla: ");
				sifra.setFont(new Font("Serif", Font.ITALIC,15));
				sifra.setBounds(screenWidth/2 + 20, 300, 300, 40);
				
				articleId = new JLabel(a.getSifra());
				articleId.setFont(new Font("Serif", Font.ITALIC, 15));
				articleId.setBounds(screenWidth/2+150, 300, 300, 40);
				
				boja = new JLabel("Boja: ");
				boja.setFont(new Font("Serif", Font.PLAIN, 17));
				boja.setBounds(screenWidth/2 + 20, 350, 300, 40);
				
				articleColor = new JLabel(a.getBoja().toString());
				articleColor.setFont(new Font("Serif",Font.PLAIN,17));
				articleColor.setBounds(screenWidth/2 + 150,350,300,40);
				
				uzeto = new JLabel("Izabrana kolicina: ");
				uzeto.setFont(new Font("Serif", Font.PLAIN,17));
				uzeto.setBounds(screenWidth/2 + 20, 400, 300, 40);
				
				brojUzetih = new JLabel("1");
				brojUzetih.setFont(new Font("Serif", Font.PLAIN,17));
				brojUzetih.setBounds(screenWidth/2 + 150,400,300,40);
				
				minus = new JButton("-");
				minus.setFont(new Font("Serif",Font.BOLD,20));
				minus.setBounds(screenWidth/2 + 20, 450, 100, 40);
				
				vrednost = new JTextField("1");
				vrednost.setFont(new Font("Serif", Font.PLAIN,20));
				vrednost.setBounds(screenWidth/2 + 120, 450, 100, 40);
				vrednost.setHorizontalAlignment(JTextField.CENTER);
				vrednost.setEditable(false);
				
				plus = new JButton("+");
				plus.setFont(new Font("Serif", Font.BOLD, 20));
				plus.setBounds(screenWidth/2 + 200, 450, 100, 40);
				
				addCart = new JButton("Dodaj u korpu");
				addCart.setFont(new Font("Serif", Font.BOLD,20));
				addCart.setBounds(screenWidth/2 + 20, 500, 200,40);
				
				addWishList = new JButton();
				addWishList.setBounds(screenWidth/2 + 220, 500, 100,40);
				ImageIcon image = new ImageIcon("wishlist.png");
				Image image_tmp = getScaledImage(image.getImage(), 60, 30);
				image.setImage(image_tmp);
				addWishList.setIcon(image);
				
				pozoviProdavnice = new JButton("Pregled prodavnica u kojim se moze naci ovaj artikl");
				pozoviProdavnice.setFont(new Font("Serif", Font.BOLD,20));
				pozoviProdavnice.setBounds(screenWidth/2 + 20, 550, 500,40);
				
				articlePic = new JLabel();
				articlePic.setBounds(screenWidth/2 - 500, 120, 500, 600);
				ImageIcon image2 = new ImageIcon(a.getSlika());
				Image image_tmp2 = getScaledImage(image2.getImage(),400,500);
				image2.setImage(image_tmp2);
				articlePic.setIcon(image2);
				
				break;
			}
		}
		
		
		//DODAVANJE LABELE ZA REGISTRACIJU
		register_label = new JLabel("Register");
		register_label.setBounds(screenWidth - 285, 10, 60, 30);
		register_label.setFont(new Font("Serif", Font.PLAIN, 17));
		register_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE LOGIN LABELE
		login_label = new JLabel("Log in");
		login_label.setBounds(screenWidth - 215, 10, 60, 30);
		login_label.setFont(new Font("Serif", Font.PLAIN, 17));
		login_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE /
		JLabel tmp_slash = new JLabel("\\");
		tmp_slash.setBounds(screenWidth - 225, 10, 5, 30);
		tmp_slash.setFont(new Font("Serif", Font.PLAIN, 17));
		
		//DODAVANJE LABELE ZA KORPU i NJENE SLIKE
		cart_label = new JLabel("Cart");
		cart_label.setBounds(screenWidth - 130, 10, 40, 30);
		cart_label.setFont(new Font("Serif", Font.PLAIN, 17));
		cart_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ImageIcon image1 = new ImageIcon("korpica.png");
		Image image_tmp1 = getScaledImage(image1.getImage(), 20, 20);
		image1.setImage(image_tmp1);

		JLabel cart_pic = new JLabel(image1);
		cart_pic.setBounds(screenWidth - 95, 10, 30, 30);
		cart_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//DODAVANJE LABELE SHOP i SLIKE LOKACIJE
		shops_label = new JLabel("Shops");
		shops_label.setBounds(30, 10, 40, 30);
		shops_label.setFont(new Font("Serif", Font.PLAIN, 17));
		shops_label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ImageIcon image2 = new ImageIcon("location_icon.png");
		Image image_tmp2 = getScaledImage(image2.getImage(), 20, 20);
		image2.setImage(image_tmp2);

		JLabel location_pic = new JLabel(image2);
		location_pic.setBounds(72, 15, 20, 20);
		location_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		background.add(location_pic);
		background.add(shops_label);
		background.add(cart_pic);
		background.add(cart_label);
		background.add(register_label);
		background.add(login_label);
		background.setLayout(null);
		background.add(globus_label);
		background.add(globus_label2);
		background.add(articleName);
		background.add(articlePrice);
		background.add(articleId);
		background.add(naziv);
		background.add(cena);
		background.add(sifra);
		background.add(boja);
		background.add(articleColor);
		background.add(uzeto);
		background.add(brojUzetih);
		background.add(minus);
		background.add(plus);
		background.add(vrednost);
		background.add(addWishList);
		background.add(addCart);
		background.add(pozoviProdavnice);
		background.add(articlePic);
		
		this.add(background);
		this.setVisible(true);

		
		addCart.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				Stavka s = new Stavka();
				Artikl a = new Artikl();
				for(Artikl a1:app.artikli){
					if(a1.getSifra().equals(articleid)){
						a = a1;
						break;
					}
				}
				if(app.getAktivniKorisnik() == TipKorisnika.neulogovanKorisnik){
					s.setArtikl(a);
					s.setKolicina(Integer.parseInt(vrednost.getText()));
					boolean nadjena = false;
					int indeks = 0;
					for(int i = 0;i<app.korpe.size();i++){
						if(app.korpe.get(i).getIdNeulog()==0){
							nadjena = true;
							indeks = i;
							break;
						}
					}
					
					if(nadjena == true){
						app.korpe.get(indeks).dodajStavku(s);
					}else{
						Korpa k = new Korpa();
						k.setIdNeulog(app.getId());
						k.dodajStavku(s);
						app.korpe.add(k);
					}
				}else{
					for(Korisnik k:app.korisnici){
						if(k.getJmbg()==app.getId()){
							
						}
					}
				}
				
			}  
	    });  
		
		
	}
		
	
	@SuppressWarnings("unused")
	private Image getScaledImage(Image srcImg, int w, int h) {
		BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, w, h, null);
		g2.dispose();

		return resizedImg;
	}
	

}