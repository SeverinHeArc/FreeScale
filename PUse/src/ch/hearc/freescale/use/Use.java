
package ch.hearc.freescale.use;

import ch.hearc.freescale.api.exception.VoitureException;
import ch.hearc.freescale.api.gui.VoitureGUI;
import ch.hearc.freescale.api.image.ImageSize;
import ch.hearc.freescale.api.voitureInputStream.TrameEvent;
import ch.hearc.freescale.api.voitureInputStream.TrameListener;
import ch.hearc.freescale.use.trames.TrameReceived;
import ch.hearc.freescale.use.trames.TrameSend;

/**
 * Principe :
 *
 * 			(P1) Cr�ation d'une VoitureGUI pour l'affichage graphique.
 *
 *					1. Pour recevoir une trame TrameSendTuto
 *					2. Pour envoier des trame TrameSendTuto
 *
 *
 * 			(P1) Utilisation de l'appID
 *
 *					(U1) Est utilis� pour enregistrer les placement des fen�tre
 *					(U2) Deux ID diff�rents permettent de faire tourner deux instance
 *						 de l'application sans conflit
 *					(U3) En chageant l'ID. Le placement des fen�tre est resete
 *
 *
 * 			(P3) Utilisation de la voiture pour recevoire les trame
 * 				 et les afficher en console
 *
 * 					Un listener est ajouter � la voiuter
 *
 */
public class Use
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Static							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		// Facultatif
			{
			final int IMAGE_SIZE = 143;
			ImageSize.init(IMAGE_SIZE); // Default value 143
			}

		try
			{
			monitoringGUI();
			}
		catch (VoitureException e)
			{
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void monitoringGUI() throws VoitureException
		{
		//Creation d'un objet VoitureGUI. L'objet voiture GUI lit les annotations des trames pass� en param�tres et affiches les fen�tres demmand�es.
		//L'URL de connection est enregist� dans le fichier "Settings/SettingsConnection.txt"
		VoitureGUI voitureGUI = new VoitureGUI(AppID, new TrameReceived(), new TrameSend());

		//Il est possible de r�cupp�rer l'objet voiture afin d'ajouter ses propres listeners
		voitureGUI.getVoiture().addTrameListener(new TrameListener()
			{

			@Override
			public void tramePerformed(TrameEvent event)
				{
				System.out.println("Trame received : " + event.getTrame().toString());
				}
			});
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final int AppID = 333;
	}
