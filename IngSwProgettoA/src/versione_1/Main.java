package versione_1;
import java.io.File;
import java.util.*;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;
import it.unibs.fp.mylib.ServizioFile;

public class Main {
	
	//dichiarazioni costanti
	
	//Titoli Menù
	public static final String TITOLO= "Benvenuti nel Sistema Domotico";
	public static final String TITOLOFRUITORE= "Benvenuti nel menù del Fruitore ";
	public static final String TITOLOMANUTENTORE= "Benvenuti menù del Manutentore";
	public static final String TITOLOUNITADOMOTICA= "Menù inserimento unità domotica";
	public static final String TITOLOUNITARILEVAZIONE = "Menù inserimento unità rilevazione";
	
	//Voci Menù
	public static final String UTENTE1= "Manutentore";
	public static final String UTENTE2= "Fruitore";
	public static final String [] VOCIFRUITORE= {"Visualizza Descrizione Unità Immobiliare",			
												"Visualizza Categorie Unità",
												"Visualizza Valori"};
	
	
	public static final String [] VOCIMANUTENTORE= {"Inserire Unità Immobiliare",
													"Inserisci Unità Domotica",
													"Inserire Categoria Attuatori",
													"Inserire Categoria Sensori",
													"Inserisci Attuatore",
													"Inserisci Sensore",
													"Visualizza Unità Immobiliari",
													"Visualizza Categorie Unità"};
	
	public static final String [] VOCIUNITADOMOTICA= {"Stanza","Artefatto"};
	
	public static final String[] VOCIUNITARILEVAZIONE = {"Attuatore","Sensore"};
	
	//Messaggi Input Dati
	public static final String SCELTAUSCITA= "Vuoi uscire dal sistema? (Digitare esci per uscire)";
	public static final String MESSAGGIO_INSERIMENTO_UNITA_IMMOBILIARE ="Inserire il nome dell'unità immobiliare";
	public static final String MESSAGGIO_INSERIMENTO_UNITA_DOMOTICA = "Inserisci nome unità domotica";
	public static final String MESSAGGIO_INSERIMENTO_CATEGORIA = "Inserisci il nome della categoria";
	public static final String MESSAGGIO_INSERIMENTO_DESCRIZIONE_CATEGORIA = "Inserisci la descrizione della categoria";
	public static final String MESSAGGIO_INSERIMENTO_NOME_MODALITA_OPERATIVA = "Inserisci nome Modalità Operativa";
	public static final String MESSAGGIO_INSERIMENTO_DESCRIZIONE_MODALITA_OPERATIVA = "Inserisci descrizione Modalità Operativa";
	public static final String MESSAGGIO_INSERIMENTO_NOME_INFO_RILEVABILE = "Inserisci nome info rilevabile";
	public static final String MESSAGGIO_INSERIMENTO_UNITA_RILEVAZIONE = "Inserisci nome Unità Rilevazione ";
	public static final String MESSAGGIO_ASSOC_STANZA_ARTEFATTO = "Vuoi assegnare l'artefatto ad una stanza?";

	//Messaggi di Errore
	private static final String MESSAGGIO_ELEMENTO_ESISTENTE = "L'elemento inserito è già presente";
	
	//Messaggi successo procedure
	public static final String MESSAGGIO_SUCCESSO_INPUT = "Inserimento avvenuto con successo";
	
	//Tipi Classi
	public static final String TYPESTANZA="Stanza";
	public static final String TYPEARTEFATTO="Artefatto";
	public static final String TYPEATTUATORE="Attuatore";
	public static final String TYPESENSORE="Sensore";
	
	//costanti numeriche
	public static final int MAXCHAR=144;
	public static final int MIN = 0;
	
	
	//Dichiarazioni variabili delle classi sistema domotico
	private static Utente userManutentore= new Utente();
	private static Utente userFruitore= new Utente();
	private static ListaCategorie listaCategoriaAttuatori;
	private static ListaCategorie listaCategoriaSensori;
	private static UnitaImmobiliare immobile;
	//private static ArrayList<UnitaDomotica> listaUnitaDomotiche = new ArrayList <UnitaDomotica>();
	private static ArrayList<UnitaRilevazione> listaSensori;
	private static ArrayList<UnitaRilevazione> listaAttuatori;
	
	
	public static void main(String[] args) {
		
		
		//Dichiarazione variabili main
		String[] vociUtente = { UTENTE1, UTENTE2 };
		MyMenu menu= new MyMenu(TITOLO, vociUtente);
		MyMenu menuManutentore=new MyMenu(TITOLOMANUTENTORE,VOCIMANUTENTORE);
		MyMenu menuFruitore=new MyMenu(TITOLOFRUITORE,VOCIFRUITORE);
		String sceltaMenuDomotico = null;
		int scelta;
		
		/*Caricamenti da File
		 * Se il file non esiste istanzio l'oggetto, altrimenti carico i dati dal file
		 */
		File fileCategorieAttuatori = new File("ListaCategorieAttuatori.txt");
		if(fileCategorieAttuatori.exists() && fileCategorieAttuatori.length() !=0)
			listaCategoriaAttuatori = (ListaCategorie) ServizioFile.caricaSingoloOggetto(fileCategorieAttuatori);
		else
			listaCategoriaAttuatori = new ListaCategorie();
		
		File fileCategorieSensori = new File ("ListaCategorieSensori.txt");
		if(fileCategorieSensori.exists() && fileCategorieSensori.length() !=0)
			listaCategoriaSensori = (ListaCategorie) ServizioFile.caricaSingoloOggetto(fileCategorieSensori);
		else
			listaCategoriaSensori = new ListaCategorie();
		
		File fileListaSensori = new File ("ListaSensori.txt");
		if(fileListaSensori.exists() && fileListaSensori.length() !=0)
			listaSensori =  (ArrayList<UnitaRilevazione>) ServizioFile.caricaSingoloOggetto(fileListaSensori);
		else
			listaSensori = new ArrayList<UnitaRilevazione>();
		
		File fileListaAttuatori = new File ("ListaAttuatori.txt");
		if(fileListaAttuatori.exists() && fileListaAttuatori.length() !=0)
			listaAttuatori =  (ArrayList<UnitaRilevazione>) ServizioFile.caricaSingoloOggetto(fileListaAttuatori);
		else
			listaAttuatori =  new ArrayList<UnitaRilevazione>();
		
		File fileUnitaImmobiliare = new File ("UnitaImmobiliare.txt");
		if(fileUnitaImmobiliare.exists() && fileUnitaImmobiliare.length() !=0)
			immobile =  (UnitaImmobiliare) ServizioFile.caricaSingoloOggetto(fileUnitaImmobiliare);
		else
			immobile =  new UnitaImmobiliare("");
		
		do {
			do 
			{
				scelta=menu.scegli();
				switch(scelta)
				{
					case 0: break;
					case 1:	userManutentore.setNomeUtente(UTENTE1);
							userFruitore.setNomeUtente("null"); //se non si istanzia sarà impostato come nome null
							scelta = 0; //per uscire dal menù
						break;
					case 2: userFruitore.setNomeUtente(UTENTE2);
							userManutentore.setNomeUtente("null"); //se non si istanzia sarà impostato come nome null
							scelta=0; //per uscire dal menù
						break;
				}
			} while (scelta != 0);
			
			//menu manutentore
			if(userManutentore.getNomeUtente().equalsIgnoreCase(UTENTE1))
			{	
				do {
					scelta = menuManutentore.scegli();
					switch(scelta)
					{
						case 0: break;
						
						case 1: //metodo inserisci unità immobiliare
							inserisciUnitaImmobiliare();
							break;
						case 2: //metodi inserisci unità domotica
							inserisciUnitaDomotica();
							break;
						case 3: //metodo inserisci categoria attuatore
							listaCategoriaAttuatori= inserisciCategoria(new CategoriaAttuatori(),listaCategoriaAttuatori,TYPEATTUATORE);
							break;
						case 4 : //metodo inserisci categoria sensore
							//inserisciCategoriaSensore();
							listaCategoriaSensori= inserisciCategoria(new CategoriaSensori(),listaCategoriaSensori,TYPESENSORE);
							break;
						case 5 : //metodo inserisci attuatore
							listaAttuatori= inserisciUnitaRilevazione(new Attuatore(),listaAttuatori,TYPEATTUATORE,listaCategoriaAttuatori);
							break;
						case 6 : //metodo inserisci Sensore
							listaSensori = inserisciUnitaRilevazione(new Sensore(),listaSensori,TYPESENSORE,listaCategoriaSensori);
							break;
						case 7: //metodo visualizza unità immobiliari
							visualizzaUnitaImmobiliari();
							break;	
						case 8: //metodo visualizza categorie
							visualizzaCategorie();
							break;
					}
				
				}while(scelta != 0);
				
			}
			
			//menu fruitore
			else if(userFruitore.getNomeUtente().equalsIgnoreCase(UTENTE2))
			{
				do {
					scelta = menuFruitore.scegli();
					switch(scelta)
					{
						case 0: break;
						
						case 1: //metodo visualizza descrizione unità immobiliari
							visualizzaUnitaImmobiliari();
							break;
						case 2: //metodo visualizza categoria unità
							visualizzaCategorie();
							break;
						case 3: //visualizza valori sensori
							visualizzaValoriSensori();
							break;
					}
				
				}while(scelta != MIN);
			}
			sceltaMenuDomotico = InputDati.leggiStringaNonVuota(SCELTAUSCITA);
		} while(!sceltaMenuDomotico.equalsIgnoreCase("Esci"));
		
		//salvataggio file
		
		ServizioFile.salvaSingoloOggetto(fileCategorieAttuatori, listaCategoriaAttuatori);
		ServizioFile.salvaSingoloOggetto(fileCategorieSensori, listaCategoriaSensori);
		ServizioFile.salvaSingoloOggetto(fileListaAttuatori, listaAttuatori);
		ServizioFile.salvaSingoloOggetto(fileListaSensori,listaSensori);
		ServizioFile.salvaSingoloOggetto(fileUnitaImmobiliare,immobile);
		
	}//chiusura main
	
	//METODI DEL MENU' DEL MANUTENTORE
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------
	 * METODI INSERIMENTO UNITA' IMMOBILIARI E UNITA' DOMOTICHE 
	 * ------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	public static void inserisciUnitaImmobiliare()
	{
		//qui non va il controllo se è unico o no perchè tanto richiamando questo metodo setto solo una variabile e non istanzio nessun nuovo oggetto
		immobile.setdestinazione(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_UNITA_IMMOBILIARE));
		
	}
	public static void inserisciUnitaDomotica()
	{
		if(!immobile.getdestinazione().equalsIgnoreCase(""))
		{
			MyMenu menuUnitaDomotica=new MyMenu(TITOLOUNITADOMOTICA,VOCIUNITADOMOTICA);
			int scelta;
			do 
			{
				scelta=menuUnitaDomotica.scegli();
				switch(scelta)
				{
					case 0: break;
					case 1:	//inserisci stanza
						
						Stanza stanza = new Stanza(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_UNITA_DOMOTICA));
						boolean esiste = immobile.verificaPresenzaUnitaDomotica(stanza.getUnitName(),TYPESTANZA);
						if(!esiste) {
							immobile.addUnitaDomotica(stanza);
							System.out.println(MESSAGGIO_SUCCESSO_INPUT );
						}
						else
							System.out.println(MESSAGGIO_ELEMENTO_ESISTENTE);
						break;
						
					case 2: //inserisci artefatto
						
						Artefatto artefatto = new Artefatto(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_UNITA_DOMOTICA));
						
						boolean giaPresente= immobile.verificaPresenzaUnitaDomotica(artefatto.getUnitName(),TYPEARTEFATTO);
						
						if(!giaPresente) 
						{
							String insStanza = InputDati.leggiStringaNonVuota(MESSAGGIO_ASSOC_STANZA_ARTEFATTO);
							if(insStanza.equalsIgnoreCase("si"))
							{
								boolean presente = false;
								do {
										for(int i = 0; i<immobile.size();i++)
										{
						
											if(immobile.getUnitaDomotica(i).getClass().getName().substring(11).equals(TYPESTANZA))
												System.out.println("Nome della stanza : " + immobile.getUnitaDomotica(i).getUnitName());
										}
										String nomeStanza=InputDati.leggiStringaNonVuota("Inserire il nome della stanza");
										presente=immobile.verificaPresenzaUnitaDomotica(nomeStanza,TYPESTANZA);
										if (presente)	
											artefatto.setStanza(nomeStanza);
										else
										{
											System.out.println("Stanza non esistente");
										}
								}while(!presente);
								
							}
							immobile.addUnitaDomotica(artefatto);
							System.out.println(MESSAGGIO_SUCCESSO_INPUT);
						}
						else
							System.out.println("Artefatto già esistente");
						break;
				}
			} while (scelta != MIN);
			
		}	
		
		else
		{
			System.out.println("Immobile non esistente");
		}
		
	}
		
/*-------------------------------------------------------------------------------------------------------------------------------------------------
 * METODI INSERIMENTO CATEGORIE ATTUATORI E SENSORI 
 * ------------------------------------------------------------------------------------------------------------------------------------------------
 */
		
	//metodo da provare per unificare inserisci Categoria attuatore e sensore
	public static ListaCategorie inserisciCategoria(Categoria categoria, ListaCategorie listaCategorie,String tipoUnitaRilevazione)
	{	
		String nomeCategoria = InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_CATEGORIA);
		
		if(!listaCategorie.categoriaGiaPresente(categoria.getNomeCategoria()))
		{
			categoria.setNomeCategoria(nomeCategoria);
			//controllo che la descrizione inserita non superi i 144 char come deciso nell'uml
			String descrizione;
			do {
				descrizione= InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_DESCRIZIONE_CATEGORIA);
				if(descrizione.length()>MAXCHAR)
					System.out.println("Numero di caratteri superiore al numero consentito");
			}while(descrizione.length()>MAXCHAR);
			categoria.setDescrizioneCategoria(descrizione);
			
			//INSERIMENTO CATEGORIA ATTUATORI
			if(tipoUnitaRilevazione.equalsIgnoreCase(TYPEATTUATORE))
			{
					System.out.println("Inserisco Attuatore"); 
					//metodo che prima chiede l'inserimento delle infoRilevabili e poi aggiunge l'oggetto categoria all'arrayList
					listaCategorie.addCategoria(inserisciModalitaOperative((CategoriaAttuatori)categoria));
					
			}
			//INSERIMENTO CATEGORIA SENSORI
			else if (tipoUnitaRilevazione.equalsIgnoreCase(TYPESENSORE))
			{ 
					System.out.println("Inserisco Sensore");//metodo da eliminare
					//metodo che prima chiede l'inserimento delle infoRilevabili e poi aggiunge l'oggetto categoria all'arrayList
					listaCategorie.addCategoria(inserisciInfoRilevabili((CategoriaSensori)categoria));
			}
		}
		else
		{
			System.out.println("Categoria" + tipoUnitaRilevazione+ " già Presente");
		}
		
		return listaCategorie;
	}
	
	private static CategoriaSensori inserisciInfoRilevabili(CategoriaSensori categoria)
	{
		System.out.println("Inserire le info rilevabili");
		String risposta;
		do
		{
			InfoRilevabile infoRil = new InfoRilevabile(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_NOME_INFO_RILEVABILE));
			//anche le info rilevabili devono essere univoche per cui ho aggiunto questo controllo
			if(!categoria.infoGiaPresente(infoRil.getTipoInfoRilevabile()))
			{
				categoria.addInfoRilevabili(infoRil);
			}
			else
				System.out.println("Info rilevabile già presente");
			
			risposta=InputDati.leggiStringaNonVuota("Vuoi Inserire un'altra informazione rilevabile? (si o no)");
			
		}while(risposta.equalsIgnoreCase("Si"));
		
		return categoria;
	}
	
	private static CategoriaAttuatori inserisciModalitaOperative(CategoriaAttuatori categoria)
	{
		System.out.println("Inserire le modalità Operative");
		String risposta;
		do
		{
			ModalitaOperativa modOp = new ModalitaOperativa(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_NOME_MODALITA_OPERATIVA), InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_DESCRIZIONE_MODALITA_OPERATIVA));
			//anche le modalità operative devono essere univoche per cui ho aggiunto questo controllo
			if(!categoria.modalitaGiaPresente(modOp.getNomeModOperativa()))
			{
				categoria.addModalitaOperativa(modOp);
			}
			else
				System.out.println("Modalità Operativa già presente");
			
			risposta=InputDati.leggiStringaNonVuota("Vuoi Inserire un'altra modalità operativa? (si o no)");
			
		}while(risposta.equalsIgnoreCase("Si"));
		
		return categoria;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------
	 * METODI INSERIMENTO UNITA' RILEVAZIONE (SENSORI / ATTUATORI)
	 * ------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	public static ArrayList<UnitaRilevazione> inserisciUnitaRilevazione(UnitaRilevazione unita, ArrayList<UnitaRilevazione> listaUnita,String tipoUnita, ListaCategorie listaCategorie)
	{	
		/*
		 * se la lista delle categorie e la lista delle unità domotiche sono vuote non ha senso inserire un attuatore
		 * perchè un attuatore va associato ad una categoria e ad una stanza o artefatto
		 */
		if(listaCategorie.size()!=0 && !immobile.isEmpty())
		{
			//setto l'unità domotica
			System.out.println("Elenco delle Unità Domotiche disponibili");
			for(int i =0;i<immobile.size();i++)
				System.out.println(i+"- "+immobile.getUnitaDomotica(i).getUnitName());
			int numeroUnitaDomotica = InputDati.leggiIntero("Inserire il numero dell'Unità Domotica", MIN, immobile.size()-1);
			unita.setUnitaDomotica(immobile.getUnitaDomotica(numeroUnitaDomotica));
			
			int numeroCategoria;
			
			System.out.println("Elenco delle categorie");
			int numeroCategorieDisponibili = 0;
			for(int i=0;i<listaCategorie.size();i++)
			{	
				if(!listaUnita.isEmpty())
				{
					boolean esiste= false;
					for(int c=0; c<listaUnita.size() && !esiste;c++)
					{
						if(listaCategorie.getElemento(i).getNomeCategoria().equalsIgnoreCase(listaUnita.get(c).getCategoria().getNomeCategoria()) && listaUnita.get(c).getUnitaDomotica().getUnitName().equalsIgnoreCase(immobile.getUnitaDomotica(numeroUnitaDomotica).getUnitName()) )
									esiste=true;
					}
					if(!esiste) 
					{
						System.out.println(i+"- "+listaCategorie.getElemento(i).getNomeCategoria());
						numeroCategorieDisponibili++;
					}
				}
				else {
					System.out.println(i+"- "+listaCategorie.getElemento(i).getNomeCategoria());
					numeroCategorieDisponibili++;
				}
			}
					
			if(numeroCategorieDisponibili>0)
			{
				numeroCategoria = InputDati.leggiIntero("Inserire il numero della categoria ", MIN, listaCategorie.size());
				unita.setCategoria(listaCategorie.getElemento(numeroCategoria));
				
				//inserimento del nome dell'unità di rilevazione, fare try catch per il nome
				unita.setNomeUnita(InputDati.leggiStringaNonVuota(MESSAGGIO_INSERIMENTO_UNITA_RILEVAZIONE) 
						+ (listaUnita.size())+"_"+listaCategorie.getElemento(numeroCategoria).getNomeCategoria());
				
				if(tipoUnita.equalsIgnoreCase(TYPEATTUATORE))
				{
					System.out.println("Il nome dell'attuatore è : "+ unita.getNomeUnita());
					listaUnita.add(scegliModalitaOperativa((Attuatore)unita, (CategoriaAttuatori)listaCategorie.getElemento(numeroCategoria)));
					
				}
				else if (tipoUnita.equalsIgnoreCase(TYPESENSORE))
				{
					System.out.println("Il nome del sensore è : "+ unita.getNomeUnita());
					
					//inserimento di valori rilevati in modo casuale
						
					//il ciclo for assegna un valore casuale per ogni infoRilevabile della i-esima categoria
					for(int c=0;c<((CategoriaSensori)listaCategorie.getElemento(numeroCategoria)).size();c++)
					{	
						((CategoriaSensori)listaCategorie.getElemento(numeroCategoria)).setValoreInfoRilevabile(
								unita.getNomeUnita(),
								NumeriCasuali.estraiIntero(0, 40) , 
								((CategoriaSensori)listaCategorie.getElemento(numeroCategoria)).getInfoRilevabile(c).getTipoInfoRilevabile());					
						
					}
					listaUnita.add(unita);
				}
			}
			else
				System.out.println("Tutte le categorie sono già state assegnate a : "+ immobile.getUnitaDomotica(numeroUnitaDomotica).getUnitName());
				
		}
		else
			System.out.println("Inserimento non valido");
		
		return listaUnita;
	}
	private static Attuatore scegliModalitaOperativa(Attuatore attuatore, CategoriaAttuatori categoria)
	{
		//setto la modalità operativa
		System.out.println("Lista delle Modalità Operative");
		for(int i =0;i<categoria.size();i++)
			System.out.println(i+"- "+categoria.getModalitaOperative(i).getNomeModOperativa());
		int numeroModalitaOperativa = InputDati.leggiIntero("Inserire il numero della Modalità Operativa", MIN, categoria.size()-1);
		attuatore.setModOperativa(categoria.getModalitaOperative(numeroModalitaOperativa));
		return attuatore;
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------
	 * METODO VISUALIZZAZIONE UNITA' IMMOBILIARI , STANZE E ARTEFATTI
	 * ------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	
	public static void visualizzaUnitaImmobiliari()
	{
		System.out.println("Unità Immobiliare: "+ immobile.getdestinazione());
		
		System.out.println("Lista Unità Domotiche");
		for(int i=0;i<immobile.size();i++)
		{
			if(immobile.getUnitaDomotica(i).getClass().getName().substring(11).equalsIgnoreCase(TYPEARTEFATTO) && ((Artefatto)immobile.getUnitaDomotica(i)).getStanza() != null )
			{
				System.out.println(immobile.getUnitaDomotica(i).getUnitName() + " - "+ immobile.getUnitaDomotica(i).getClass().getName().substring(11)+ 
						" - Fa parte di: "+((Artefatto)immobile.getUnitaDomotica(i)).getStanza());
			}
			else
			System.out.println(immobile.getUnitaDomotica(i).getUnitName() + " - "+ immobile.getUnitaDomotica(i).getClass().getName().substring(11));
		}
	}
	
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------
	 * METODO VISUALIZZAZIONE CATEGORIE SENSORI E ATTUATORI CON LE RISPETTIVE UNITA' DI RILEVAZIONE
	 * ------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	
	public static void visualizzaCategorie()
	{
		System.out.println("");
		
		//stampo attuatori
		System.out.println("Elenco delle Categorie di Attuatori");
		for(int i=0;i<listaCategoriaAttuatori.size();i++)
		{
			System.out.println("Categoria : " + listaCategoriaAttuatori.getElemento(i).getNomeCategoria());
			System.out.println("Descrizione : " + listaCategoriaAttuatori.getElemento(i).getDescrizioneCategoria());
			for(int c=0;c<listaAttuatori.size();c++)
				System.out.println("Attuatore : " + listaAttuatori.get(c).getNomeUnita());
		}
		
		System.out.println("");
		
		//stampo sensori
		System.out.println("Elenco delle Categorie di Sensori");
		for(int i=0;i<listaCategoriaSensori.size();i++)
		{
			System.out.println("Categoria : " + listaCategoriaSensori.getElemento(i).getNomeCategoria());
			System.out.println("Descrizione : " + listaCategoriaSensori.getElemento(i).getDescrizioneCategoria());
			for(int c=0;c<listaSensori.size();c++)
				System.out.println("Sensore : " + listaSensori.get(c).getNomeUnita());
		}
		
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------
	 * METODO VISUALIZZAZIONE VALORI RILEVATI SENSORI
	 * ------------------------------------------------------------------------------------------------------------------------------------------------
	 */	
	
	public static void visualizzaValoriSensori()
	{
		System.out.println("Stampo la lista valori rilevati");
		for(int i =0; i<listaCategoriaSensori.size(); i++)
		{
			System.out.println("Categoria : "+ listaCategoriaSensori.getElemento(i).getNomeCategoria());
			
			for(int c =0; c<((CategoriaSensori)listaCategoriaSensori.getElemento(i)).size();c++)
			{
				Map <String,Integer> temp = ((CategoriaSensori)listaCategoriaSensori.getElemento(i)).getInfoRilevabile(c).getListaMisurazioni();
				temp.entrySet().forEach(entry->{
				    System.out.println(entry.getKey() + " - " + entry.getValue());  
				 });
			}
		}
	}

}//chiusura classe
