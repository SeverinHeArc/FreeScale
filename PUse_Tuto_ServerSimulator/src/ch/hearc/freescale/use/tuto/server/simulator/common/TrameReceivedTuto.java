
package ch.hearc.freescale.use.tuto.server.simulator.common;

import ch.hearc.freescale.api.gui.presenter.annotation.container.DisplaySplit;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayCurveAbsolute;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayCurveRelatif;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayDigit;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayGauge;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayImageCurve;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayImageRoll;
import ch.hearc.freescale.api.gui.presenter.annotation.jcomponent.DisplayLevel;
import ch.hearc.freescale.api.image.Image;
import ch.hearc.freescale.api.protocol.Trame_I;

/**
 * Hypothese :
 *
 * 			La voiture envoie une trame contenant les valeures ordonnées suivantes :
 * 					Byte : AppID 	(constant pour une même trame)
 * 					Byte : TrameID 	(constant pour une même trame)
 * 					Float
 * 					Integer [-2^31, 2^31-1]
 * 					Short 	[-2^15, 2^15-1]
 * 					Byte	[-128, 127]
 * 					Image	Byte[143]
 *
 *
 * Contrainte :
 *
 * 			Implementer une classe :
 * 				(C1) avec les attribus ci-dessus
 * 				(C2) Avec un constructeur vide
 * 				(C3) Avec un contructeur plein
 * 				(C4) Implemantant Trame_I
 *
 * 			Eventuellement
 * 				Une méthode toString
 *
 * But :
 *
 * 			Afficher le contenu de la trame dans une console
 *
 * Note :
 *
 * 			Voire pUse_Tuto_ClientGui pour un affichage graphique
 * 			Voire pUse_Tuto_Server pour un l'utilisation du simulateur
 *
 */
@DisplaySplit
public class TrameReceivedTuto implements Trame_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public TrameReceivedTuto()
		{
		//Rien
		}

	public TrameReceivedTuto(Float floatField, Integer integerField, Short shortField, Byte byteField, Image imageField)
		{
		this.floatField = floatField;
		this.integerField = integerField;
		this.shortField = shortField;
		this.byteField = byteField;
		this.imageField = imageField;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("DemoTrame [floatField=");
		builder.append(this.floatField);
		builder.append(", integerField=");
		builder.append(this.integerField);
		builder.append(", shortField=");
		builder.append(this.shortField);
		builder.append(", byteField=");
		builder.append(this.byteField);
		builder.append(", imageField=");
		builder.append(this.imageField);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	//L'id indentifie chaque trame. Il doit être différent pour chaque trame
	@Override
	public byte getTrameID()
		{
		return 1;
		}

	//L'app ID indique à quel application appartient la trame
	@Override
	public byte getAppID()
		{
		return 10;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Meme ordre que les parametres envoyé par la voiture, sans ni AppID ni TrameID
	@DisplayCurveAbsolute(pointsToDisplay= 100, min=-1000, max= 1000)
	private Float floatField;

	@DisplayCurveRelatif(pointsToDisplay= 150)
	private Integer integerField;

	@DisplayDigit(title="Short Field",decimalCount=0)
	private Short shortField;

	@DisplayGauge(min=-100, max = 100)
	@DisplayLevel(min=-100, max = 100)
	private Byte byteField;

	@DisplayImageRoll
	@DisplayImageCurve
	private Image imageField;
	}
