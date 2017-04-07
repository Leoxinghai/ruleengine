package cciij.WSUtil;

/**
 * Title:        CCII Server Side GUI Development
 * Description:  A project to create all the server side servlets and JSP that will be required to implement the CCII interface on a browser on the clients machine.
 * Copyright:    Copyright (c) 2007
 * Company:      FedEx Services
 * @author Liu Xinghai
 * @version 1.0
 */

public class CCIILanguages implements java.io.Serializable
{
  private static final String m_whatVersion = "@(#) $RCSfile: CCIILanguages.java,v $ $Revision: 1.1 $ $Author: xinghai $ $Date: 2006/06/26 07:26:18 $\n";
  //Generic stuff that is used all over
  /*
  public final static String GENERIC_PAGE_INSTRUCTIONS[] =
     {"","Generic Page Instructions"
      ,"Instrucciones Gen�ricas De la Paginaci�n"
      ,"Instructions G�n�riques De Page"
      ,"Generische Seite Anweisungen"};
      */
  public final static String SUBMIT_PROMPT[]={""
    ,"Submit Form"
    ,"Someta La Forma"
    ,"Soumettez La Forme"
    ,"Legen Sie Formular Ein"};
  public final static String RESET_PROMPT[]={""
    ,"Reset Form"
    ,"Reajuste La Forma"
    ,"Remettez � l'�tat initial La Forme"
    ,"Setzen Sie Formular Zur�ck"};
  public final static String OPTIONAL_PROMPT[] = { ""
    ,"(Optional)"
    ,"(opcional)"
    ,"(facultatif)"
    ,"(wahlweise freigestellt)"};
  public final static String TRACKING_NUMBER[] = { ""
    ,"Tracking Number"
    ,"N�mero El Seguir"
    ,"Nombre De Cheminement"
    ,"GleichlaufZahl"};
  public final static String GENERIC_CONS_PROMPT[] = {""
    ,"CONS"
    ,"CONS"
    ,"CONS"
    ,"CONS"};
  public final static String STAGING_AREA[] = { ""
    ,"Staging Area"
    ,"�rea Del Estacionamiento"
    ,"R�gion D'�chafaudage"
    ,"InszenierungBereich"};
  public final static String CHOOSE_DIFFERENT_PRINTER[] = { ""
    ,"Choose different printer"
    ,"Elija diversa impresora"
    ,"Choisissez diff�rente l'imprimante"
    ,"W�hlen Sie unterschiedlichen Drucker "};
  public final static String WAREHOUSE_CODE [] = {""
    ,"Warehouse Code"
    ,"C�digo Del Almac�n"
    ,"Code D'Entrep�t"
    ,"Lager-Code"};
  public final static String PRINTER_PROMPT [] = { ""
    ,"Printer: "
    ,"Impresora: "
    ,"Imprimante: "
    ,"Drucker: "};
  public final static String LABEL_SUCCESS [] = { ""
    ,"label succeded"
    ,"etiqueta tenida �xito"
    ,"�tiquette r�ussie"
    ,"Aufkleber folgte"};
  public final static String LABEL_FAILED[] = {""
    ,"label failed"
    ,"la etiqueta fall�"
    ,"l'�tiquette a �chou�"
    ,"Aufkleber fiel aus"};
  public final static String NO_VALUE[] = {""
    ,"No Value Choosen"
    ,"Ning�n Valor Elegido"
    ,"Aucune Valeur Choisie"
    ,"Kein Wert Gew�hlt"};
    //End of genericStuff

  //Associate CRN
  public final static String ASSOCIATE_CRN_TITLE[] = { ""
    ,"Associate CRN to Master"
    ,"Asociado CRN al amo"
    ,"Associ� CRN au ma�tre"
    ,"Teilnehmer CRN zum Meister"};
  public final static String ASSOCIATE_CRN_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter CRN and Master AWB to associate"
    ,"Incorpore CRN y AWB principal para asociarse"
    ,"�crivez CRN et AWB principal pour s'associer"
    ,"Tragen Sie CRN und Vorlagen-cAwb ein, um zu verbinden"};
  public final static String ASSOCIATE_CRN_AWB_INSTRUCTIONS[] = { ""
    ,"CRN"
    ,"CRN"
    ,"CRN"
    ,"CRN"};
  public final static String ASSOCIATE_CRN_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Master AWB"
    ,"Domine Awb"
    ,"Ma�trisez Awb"
    ,"Erarbeiten Sie Awb"};
  //autologout
  public final static String AUTOLOGOUT_TITLE[] = { ""
    ,"Auto Logout"
    ,"Registro de estado de la m�quina Auto"
    ,"Sortie du syst�me Automatique. "
    ,"SelbstcLogout"};
  public final static String AUTOLOGOUT_PAGE_TEXT[] = { ""
    ,"Your session has timed out and you have been logged off the system.  "
    +"Please select if you want to return to the "
    ,"Su sesi�n ha medido el tiempo hacia fuera y le han salido el sistema.  "
    +"Seleccione por favor si usted desea volver a "
    ,"Votre session a chronom�tr� dehors et vous avez �t� sortis le syst�me.  "
    +"Choisissez svp si vous voulez retourner au "
    ,"Ihr Lernabschnitt hat heraus Zeit festgesetzt und Sie sind weg vom System geloggt worden.  "
    +"W�hlen Sie bitte vor, wenn Sie zu zur�ckkommen m�chten "};
  public final static String AUTOLOGOUT_OR_TEXT[] = { ""
    ,"or"
    ,"o"
    ,"ou"
    ,"oder"};
  public final static String AUTOLOGOUT_LOGIN[] = { ""
    ,"CCII Login Screen"
    ,"CCII Pantalla De la Conexi�n"
    ,"CCII �cran D'Ouverture"
    ,"CCII LOGON-Schirm"};
  public final static String AUTOLOGOUT_HOMEPAGE[] = { ""
    ,"Home Page"
    ,"Home Page"
    ,"Home Page"
    ,"Home Page"};
  //bond in
  public final static String BONDIN_TITLE[] = { ""
    ,"Bond In"
    ,"Enlace Adentro"
    ,"Lien Dedans"
    ,"Bindung Innen"};
  public final static String BONDIN_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String BONDIN_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String BONDIN_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String BONDIN_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String BONDIN_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String BONDIN_DAMAGED[] = { ""
    ,"Damaged"
    ,"Da�ado"
    ,"Endommag�"
    ,"Besch�digt"};
  public final static String BONDIN_WRONG_FLIGHT[] = {""
    ,"Wrong Flight"
    ,"Vuelo Incorrecto"
    ,"Vol Faux"
    ,"Falscher Flug"};
  public final static String BONDIN_FLIGHT_DELAY[] = {""
    ,"Flight Delay"
    ,"El Vuelo Retrasa"
    ,"Le Vol Retarde"
    ,"Flug Verz�gert"};

  //BONDOUT
  public final static String BONDOUT_TITLE[] = { ""
    ,"Bond Out"
    ,"enlace hacia fuera "
    ,"lien dehors "
    ,"Bindung heraus "};
  // First element 0 does not have a language associated.
  public final static String BONDOUT_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String BONDOUT_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String BONDOUT_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String BONDOUT_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String BONDOUT_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String BONDOUT_MISSED_SHUTTLE[] = { ""
    ,"Missed Shuttle"
    ,"furgoneta faltada"
    ,"fourgon manqu�"
    ,"Vermissen"};

    //Cage Scan
  public final static String CAGE_TITLE[] = { ""
    ,"Cage Scan"
    ,"Exploraci�n de la Jaula"
    ,"Balayage de Camp "
    ,"Rahmenscan"};
  public final static String CAGE_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String CAGE_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String CAGE_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String CAGE_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String CAGE_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //strings for Chagne Password Success JSP Bean
  public final static String CHANGE_PASSWORD_SUCCESS_TITLE[]={""
     ,"Change Password Successful"
     ,"Cambie La Palabra de paso Acertada"
     ,"Changez Le Mot de passe R�ussi"
     ,"�ndern Sie Das Erfolgreiche Kennwort"};
  public final static String CHANGE_PASSWORD_SUCCESS_PREFIX_TEXT[] = {""
    ,"If this page does not automatically forward "
    ,"Si esta paginaci�n autom�ticamente no remite "
    ,"Si cette page automatiquement n'exp�die pas "
    ,"Wenn diese Seite nicht automatisch nachschickt "};
  public final static String CHANGE_PASSWORD_SUCCESS_TEXT[]= {""
     ,"Click here to continue</a>"
     ,"Haga clic aqu� para continuar</a>"
     ,"Cliquetez ici pour continuer</a>"
     ,"Klicken Sie hier, um fortzufahren</a>"};
  //Choose Application Settings
  public final static String CHOOSE_APP_TITLE[]={""
     ,"Choose Application"
     ,"Elija La Aplicaci�n"
     ,"Choisissez L'Application"
     ,"W�hlen Sie Anwendung"};
  public final static String CHOOSE_APP_TEXT[]= {""
     ,"Choose Application to use from menu above"
     ,"Elija la aplicaci�n para utilizar de men� sobre"
     ,"Choisissez l'application pour utiliser du menu au-dessus de "
     ,"Beschlie�en Sie Anwendung, um vom Men� zu verwenden �ber "};
  //choose Printer JSP Bean
  public final static String CHOOSE_PRINTER_TITLE[] = { ""
    ,"Choose Printer"
    ,"Elija La Impresora"
    ,"Choisissez L'Imprimante"
    ,"W�hlen Sie Drucker"};
  public final static String CHOOSE_PRINTER_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a printer for labels"
    ,"Elija una impresora para las escrituras de la etiqueta"
    ,"Choisissez une imprimante pour des �tiquettes"
    ,"W�hlen Sie einen Drucker f�r Kenns�tze"};
  public final static String CHOOSE_PRINTER_CODE_INSTRUCTIONS[] = { ""
    ,"Printers"
    ,"Impresoras"
    ,"Imprimantes"
    ,"Drucker"};
  //choose sort date
  public final static String CHOOSE_SORT_TITLE[] = { ""
    ,"Choose Sort Date"
    ,"Elija La Fecha De la Clase"
    ,"Choisissez La Date De Tri"
    ,"W�hlen Sie SortierungDatum"};
  public final static String CHOOSE_SORT_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a Sort Date to work with"
    ,"Elija una fecha de la clase para trabajar con"
    ,"Choisissez une date de tri pour travailler avec"
    ,"Beschlie�en Sie ein Sortierungdatum, um mit zu arbeiten"};
  public final static String CHOOSE_SORT_CODE_INSTRUCTIONS[] = { ""
    ,"Sort Dates"
    ,"Clasifique Las Fechas"
    ,"Triez Les Dates"
    ,"Sortieren Sie Daten"};
  //Choose Specific Function Settings
  public final static String CHOOSE_SPECIFC_TITLE[] = {""
     ,"Choose Specific functionality"
     ,"Elija las funciones espec�ficas"
     ,"Choisissez la fonctionnalit� sp�cifique"
     ,"W�hlen Sie spezifische Funktionalit�t"};
  public final static String CHOOSE_SPECIFIC_TEXT[] = {""
     ,"Choose specific functionality from menu on left"
     ,"Elija las funciones espec�ficas del men� en izquierda"
     ,"Choisissez la fonctionnalit� sp�cifique du menu sur la gauche"
     ,"W�hlen Sie spezifische Funktionalit�t vom Men� auf links"};
  //choose Stage Area JSP Bean
  public final static String CHOOSE_STAGE_AREA_TITLE[] = { ""
    ,"Choose a Stage area"
    ,"Elija un �rea de la etapa"
    ,"Choisissez une r�gion d'�tape"
    ,"W�hlen Sie einen Stadiumsbereich"};
  public final static String CHOOSE_STAGE_AREA_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a Stage area"
    ,"Elija un �rea de la etapa"
    ,"Choisissez une r�gion d'�tape"
    ,"W�hlen Sie einen Stadiumsbereich"};
  public final static String CHOOSE_STAGE_AREA_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String CHOOSE_STAGE_AREA_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  //corporate CMT Scan
  public final static String CMT_INPUT_PAGE_TITLE[] = {""
      ,"Comment (CMT) Input Page"
      ,"P�gina Entrada Del Comentario (CMT)"
      ,"Page Entr�e Du Commentaire (CMT)"
      ,"Anmerkung (CMT) Eingegebene Seite "};
  public final static String CMT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for CMT Scan"
      ,"Incorpore AWB para la exploraci�n del CMT."
      ,"�crivez AWB pour le balayage de CMT"
      ,"Tragen Sie AWB f�r CMT Scan ein"};
  public final static String CMT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String CMT_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Comments"
      ,"Comentarios"
      ,"Commentaires"
      ,"Anmerkungen"};
  // corporate CONS Scan
  public final static String CONS_INPUT_PAGE_TITLE[] = {""
      ,"Consolidated Shipment (CONS) Input Page"
      ,"P�gina consolidada de la entrada del env�o (CONS)"
      ,"Page consolid�e d'entr�e de l'exp�dition (CONS)"
      ,"Vereinigte Eingang Seite des Versand-(CONS)"};
  public final static String CONS_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add to CONS"
      ,"Incorpore AWB para agregar a CONS"
      ,"�crivez AWB pour s'ajouter � CONS"
      ,"Tragen Sie AWB ein, um CONS hinzuzuf�gen"};
  public final static String CONS_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String CONS_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"CONS Number"
      ,"n�mero de CONS"
      ,"nombre de CONS"
      ,"CONS Zahl"};

  public final static String CORPSCANS_TITLE[] = { ""
    ,"Corporate Scans"
    ,"Exploraciones Corporativas"
    ,"Balayages De corporation"
    ,"Korporative Scans"};
  public final static String CORPSCANS_SCAN[] = { ""
      ,"Scans"
      ,"Exploraciones"
      ,"Balayages"
      ,"Scans"};
  public final static String CORPSCANS_CMT[] = { ""
    ,"CMT"
    ,"CMT"
    ,"CMT"
    ,"CMT"};
  public final static String CORPSCANS_HIP[] = { ""
    ,"HIP"
    ,"HIP"
    ,"HIP"
    ,"HIP"};
  public final static String CORPSCANS_HOP[] = { ""
    ,"HOP"
    ,"HOP"
    ,"HOP"
    ,"HOP"};
  public final static String CORPSCANS_RIP[] = { ""
    ,"RIP"
    ,"RIP"
    ,"RIP"
    ,"RIP"};
  public final static String CORPSCANS_ROP[] = { ""
    ,"ROP"
    ,"ROP"
    ,"ROP"
    ,"ROP"};
  public final static String CORPSCANS_SIP[] = { ""
    ,"SIP"
    ,"SIP"
    ,"SIP"
    ,"SIP"};
  public final static String CORPSCANS_SOP[] = { ""
    ,"SOP"
    ,"SOP"
    ,"SOP"
    ,"SOP"};
   public final static String CORPSCANS_STAT[] = { ""
    ,"STAT"
    ,"STAT"
    ,"STAT"
    ,"STAT"};
  public final static String CORPSCANS_STAT_SPECIALTY[] = { ""
    ,"Special STAT Scans"
    ,"Special STAT Scans"
    ,"Special STAT Scans"
    ,"Special STAT Scans"};
  public final static String CORPSCANS_STAT37[] = { ""
    ,"STAT 37"
    ,"STAT 37"
    ,"STAT 37"
    ,"STAT 37"};
  public final static String CORPSCANS_STAT69[] = { ""
    ,"STAT 69"
    ,"STAT 69"
    ,"STAT 69"
    ,"STAT 69"};
  public final static String CORPSCANS_STAT6877BOTH[] = { ""
    ,"STAT 68 or 77"
    ,"STAT 68 or 77"
    ,"STAT 68 or 77"
    ,"STAT 68 or 77"};
  public final static String CORPSCANS_STAT6877JUST68[] = { ""
    ,"STAT 68"
    ,"STAT 68"
    ,"STAT 68"
    ,"STAT 68"};
  public final static String CORPSCANS_STAT6877JUST77[] = { ""
    ,"STAT 77"
    ,"STAT 77"
    ,"STAT 77"
    ,"STAT 77"};
  public final static String CORPSCANS_STAT8590BOTH[] = { ""
    ,"STAT 85 or 90"
    ,"STAT 85 or 90"
    ,"STAT 85 or 90"
    ,"STAT 85 or 90"};
  public final static String CORPSCANS_STAT8590JUST85[] = { ""
    ,"STAT 85"
    ,"STAT 85"
    ,"STAT 85"
    ,"STAT 85"};
  public final static String CORPSCANS_STAT8590JUST90[] = { ""
    ,"STAT 90"
    ,"STAT 90"
    ,"STAT 90"
    ,"STAT 90"};
  // corporate DCON Scan
  public final static String DCON_INPUT_PAGE_TITLE[] = {""
      ,"De-Consolidated Shipment (DCON) Input Page"
      ,"P�gina consolidada de la entrada del env�o (DCON)"
      ,"Page consolid�e d'entr�e de l'exp�dition (DCON)"
      ,"Vereinigte Eingang Seite des Versand-(DCON)"};
  public final static String DCON_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add to DCON"
      ,"Incorpore AWB para agregar a DCON"
      ,"�crivez AWB pour s'ajouter � DCON"
      ,"Tragen Sie AWB ein, um DCON hinzuzuf�gen"};
  public final static String DCON_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String DCON_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"DCON Number"
      ,"n�mero de DCON"
      ,"nombre de DCON"
      ,"DCON Zahl"};

  // Detaiment In Scan
  public final static String DETAINMENT_IN_INPUT_PAGE_TITLE[] = {""
      ,"Detainment In (DIN) Input Page"
      ,"Detainment In (DIN) Input Page"
      ,"Detainment In (DIN) Input Page"
      ,"Detainment In (DIN) Input Page"};
  public final static String DETAINMENT_IN_CODE_INSTRUCTIONS[] = { ""
      ,"Enter Reason Code (optional) to apply with DIN"
      ,"Enter Reason Code (optional) to apply with DIN"
      ,"Enter Reason Code (optional) to apply with DIN"
      ,"Enter Reason Code (optional) to apply with DIN"};
  public final static String DETAINMENT_IN_AWB_INSTURCTIONS[] = TRACKING_NUMBER;

  //DetainLoc
  public final static String DETAIN_LOC_TITLE[] = { ""
    ,"Show Detainment Location Screen"
    ,"Muestre La Pantalla De la Localizaci�n De la Detenci�n"
    ,"Montrez L'�cran D'Emplacement De D�tention"
    ,"Zeigen Sie Zur�ckbehaltungStandortBildschirm"};
  public final static String DETAIN_LOC_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find detainment location"
    ,"Incorpore N�mero El Seguir para encontrar la localizaci�n de la detenci�n"
    ,"�crivez Nombre De Cheminement pour trouver l'emplacement de d�tention"
    ,"Tragen Sie GleichlaufZahl ein, um Zur�ckbehaltungstandort zu finden"};
  public final static String DETAIN_LOC_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;

  //DetainmentLocaLabel
  public final static String DETAINMENT_LOC_LABEL_TITLE[] = {""
    ,"Detainment Location Label"
    ,"Etiqueta De la Localizaci�n De la Detenci�n"
    ,"�tiquette D'Endroit De D�tention"
    ,"Zur�ckbehaltung-Position Aufkleber"};
  public final static String DETAINMENT_LOC_LABEL_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String DETAINMENT_LOC_LABEL_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String DETAINMENT_LOC_LABEL_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String DETAINMENT_LOC_LABEL_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String DETAINMENT_LOC_LABEL_SINGLELINE_INSTRUCTIONS[] = {""
    ,"Detainment Location"
    ,"Descripci�n De la Localizaci�n De la Detenci�n"
    ,"Endroit De D�tention"
    ,"Zur�ckbehaltung-Position"};

  // Detaiment Out Scan
  public final static String DETAINMENT_OUT_INPUT_PAGE_TITLE[] = {""
      ,"Detainment Out (DOUT) Input Page"
      ,"Detainment Out (DOUT) Input Page"
      ,"Detainment Out (DOUT) Input Page"
      ,"Detainment Out (DOUT) Input Page"};
  public final static String DETAINMENT_OUT_CODE_INSTRUCTIONS[] = { ""
      ,"Enter Release Code (optional) to apply with DOUT"
      ,"Enter Release Code (optional) to apply with DOUT"
      ,"Enter Release Code (optional) to apply with DOUT"
      ,"Enter Release Code (optional) to apply with DOUT"};
  public final static String DETAINMENT_OUT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;

  //DownloadFormats
  public final static String DOWNLOAD_FORMATS_TITLE[]={""
    ,"Download Printer Formats"
    ,"Localizaci�n De la Detenci�n "
    ,"Formats D'Imprimeur De T�l�chargement"
    ,"Download-Drucker-Formate"};
  public final static String DOWNLOAD_FORMATS_INSTRUCTIONS[]={""
    ,"Choose Printer Name to Download Formats "
    ,"Elija el nombre de la impresora para descargar formatos "
    ,"Choisissez le nom d'imprimeur pour t�l�charger des formats "
    ,"Beschlie�en Sie Druckernamen, um Formate zu downloaden "};
  public final static String DOWNLOAD_FORMATS_CODE_INSTRUCTIONS[]={""
     ,"Printer ID"
    ,"Identificaci�n De la Impresora"
    ,"Identification D'Imprimeur"
    ,"Drucker Identifikation "};
  public final static String DOWNLOAD_EXCEPTION_ALL_PRINTERS [] = {""
    ,"All printers"
    ,"Todas las impresoras"
    ,"Tous les imprimeurs"
    ,"Alle Drucker"};

    //Empty input JSP
  public final static String EMPTY_INPUT_TITLE[] = {""
    ,"Form Fields not complete"
    ,"Forme los campos no completos"
    ,"Formez les zones non compl�tes"
    ,"Bilden Sie die kompletten Felder nicht"};
  public final static String EMPTY_INPUT_TEXT[] = { ""
    ,"Not Enough information was filled in to process this screen.  \n<br>"
    + "Use your browser's back button to go back and complete the form and resubmit."
    ,"No bastante informaci�n fue completada para procesar esta pantalla.  \n<br>"
    +"Utilice el bot�n posterior de su browser para ir detr�s y para llenar el formulario y para resometerlo."
    ,"Pas assez d'information a �t� compl�t�e pour traiter cet �cran.  \n<br>"
    +"Utilisez le bouton arri�re de votre browser's pour retourner et pour remplir le formulaire et pour se resoumettre."
    ,"Nicht gen�gende Informationen wurden ausgef�llt, um diesen Bildschirm zu verarbeiten.  \n<br>"
    +"Benutzen Sie r�ckseitige Taste Ihrer Datenbanksuchroutine, um zur�ck zu gehen und das Formular auszuf�llen und wieder zu unterwerfen."};
  //GenericStatusServlet
  public final static String GENERIC_STATUS_AWB[] = { ""
    ,"AWB"
    ,"AWB"
    ,"AWB"
    ,"AWB"};
  public final static String GENERIC_STATUS_STATUS_OR_LOCATION[] = { ""
    ,"Status"
    ,"Estatus"
    ,"Mode"
    ,"Status"};
  //Handling Instructions
  public final static String HI_INPUT_PAGE_TITLE[] = {"","Handling Instruction Input Page"
     ,"Manipulaci�n De la Paginaci�n De la Entrada de informaci�n De la Instrucci�n"
     ,"Manipulation De la Page D'Entr�e D'Instruction"
     ,"Behandlung Der Anweisung InputSeite"};
  public final static String HI_CODE_INSTRUCTIONS[] =
     {"","Select a Handling Instruction to apply"
      ,"Seleccione una instrucci�n de direcci�n de aplicarse"
      ,"Choisissez une instruction de manipulation de s'appliquer"
      ,"W�hlen Sie eine anfassenanweisung aus zuzutreffen"};
  public final static String HI_TEXT_INSTRUCTIONS[] =
     {"","or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"};
  public final static String HI_AWB_INSTURCTIONS[] =
     {"","Enter the Tracking Number to apply Handling Instruction"
      ,"Incorpore de N�mero El Seguir para aplicar la manipulaci�n de la instrucci�n"
      ,"�crivez d'cNombre De Cheminement pour appliquer manipuler l'instruction"
      ,"Tragen Sie die GleichlaufZahl-Zahl ein, um die Behandlung von Anweisung anzuwenden"};
  // Corporate HIP scan
  public final static String HIP_INPUT_PAGE_TITLE[] = {""
      ,"Hub In (HIP) Input Page"
      ,"Cubo en p�gina de la entrada del (HIP)"
      ,"Moyeu en page d'entr�e de (HIP)"
      ,"Nabe in der (HIP) Eingang Seite"};
  public final static String HIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for HIP Scan"
      ,"Incorpore AWB para la exploraci�n del HIP."
      ,"�crivez AWB pour le balayage de HIP"
      ,"Tragen Sie AWB f�r HIP Scan ein"};
  public final static String HIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate HOP Scan
   public final static String HOP_INPUT_PAGE_TITLE[] = {""
      ,"Hub Out (HOP) Input Page"
      ," Cubo fuera de la p�gina de la entrada del (HOP)"
      ,"Moyeu hors de page d'entr�e de (HOP)"
      ,"Nabe aus (HOP) Eingang Seite"};
  public final static String HOP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for HOP Scan"
      ,"Incorpore AWB para la exploraci�n del HOP"
      ,"�crivez AWB pour le balayage de HOP"
      ,"Tragen Sie AWB f�r HOP Scan ein"};
  public final static String HOP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //left menu intercept
  public final static String INTER_MENU_TITLE[]={""
     ,"Intercept Menu"
     ,"Men� De la Interceptaci�n"
     ,"Menu D'Interception"
     ,"AbschnittMen�"};
  public final static String INTER_MENU_SCANS[] = {""
      ,"Scans"
      ,"Exploraciones"
      ,"Balayages"
      ,"Scans"};
  public final static String INTER_MENU_PACKAGE_ARRIVAL[] = {""
      ,"Package Arrival"
      ,"Llegada Del Conjunto"
      ,"Arriv�e De Module"
      ,"PaketAnkunft"};
  public final static String INTER_MENU_STAGE_IN[] = {""
      ,"Stage In"
      ,"Etapa Adentro"
      ,"�tape Dedans"
      ,"Stadium Innen"};
  public final static String INTER_MENU_STAGE_OUT[] = {""
      ,"Stage Out"
      ,"Etapa Hacia fuera"
      ,"�tape Dehors"
      ,"Stadium Heraus"};
   public final static String INTER_MENU_STAGE_OUT_STRIP[] = {""
      ,"Stage Out Strip"
      ,"Etapa Fuera De la Tira"
      ,"�tape Hors De Bande"
      ,"Stadium Aus Streifen"};
  public final static String INTER_MENU_LEAVE_FACILITY[] = {""
      ,"Package Departure"
      ,"Salida Del Conjunto"
      ,"D�part De Module"
      ,"PaketAbfahrt"};
  public final static String INTER_MENU_STATUS[] = { ""
    ,"Status"
    ,"Estatus"
    ,"Mode"
    ,"Status"};
  public final static String INTER_MENU_STAGE_PICKLIST[] = { ""
    ,"Stage Pick List"
    ,"Lista De la Selecci�n De la Etapa"
    ,"Liste De S�lection D'�tape"
    ,"Stadium AuswahlListe"};
  public final static String INTER_MENU_STAGE_STATUS[] = { ""
    ,"Package Status"
    ,"Estatus Del Conjunto"
    ,"Mode De Module"
    ,"PaketStatus"};
  public final static String INTER_MENU_LOCATION_HISTORY[] = { ""
    ,"Location & History"
    ,"Localizaci�n Y Historia"
    ,"Emplacement Et Histoire"
    ,"Standort U. Geschichte"};
  public final static String INTER_MENU_OTHER[] = { ""
    ,"Other"
    ,"Otro"
    ,"Autre"
    ,"Anderes"};
  public final static String INTER_MENU_MANIPULATE_INTERCEPT[] = { ""
    ,"Mass Entry Intercept"
    ,"Manipule La Interceptaci�n"
    ,"Manipulez L'Interception"
    ,"Manipulieren Sie Abschnitt"};
  public final static String INTER_MENU_REGULATORY_RELEASE[] = { ""
    ,"Regulatory Release"
    ,"Desbloquear Regulador"
    ,"Version De normalisation"
    ,"Regelnde Freigabe"};
  public final static String INTER_MENU_ASSOCIATE_CRN[] = { ""
    ,"Associate CRN"
    ,"Asociado CRN"
    ,"Associ� CRN"
    ,"Teilnehmer CRN"};
  public final static String INTER_MENU_ROUTE_MAINT[] = { ""
    ,"Route Maintenance"
    ,"Encamine El Mantenimiento"
    ,"Conduisez L'Entretien"
    ,"Verlegen Sie Wartung"};
  public final static String INTER_MENU_ADMIN[] = { ""
    ,"Administration"
    ,"Administraci�n"
    ,"Gestion"
    ,"Leitung"};
  public final static String INTER_MENU_ADMINAPPS[] = { ""
    ,"Admin Apps"
    ,"Admin Apps"
    ,"Admin Apps"
    ,"Admin Apps"};
  public final static String INTER_MENU_WARNING[]= {""
    ,"WARNING"
    ,"ALERTA"
    ,"AVERTISSEMENT"
    ,"WARNING"};
  public final static String INTER_MENU_PLUGIN[]= {""
    ,"Java Web Start Plugin is NOT installed on this system"
    ,"El comienzo del Web de Java plugin no est� instalado en este sistema"
    ,"Le d�but de Web de Java plugin n'est pas install� sur ce syst�me"
    ,"Der steckbare Javaweb-Anfang ist nicht auf dieses System installiert"};
  public final static String INTER_MENU_INSTALL[]= {""
    ,"In order to run the admin apps you need to install"
    ,"Para ejecutar los apps del admin que usted necesita instalar"
    ,"Afin d'ex�cuter les apps d'admin que vous devez installer"
    ,"Zwecks die admin-apps laufen lassen, die Sie installieren m�ssen"};
  public final static String INTER_MENU_JWS[]= {""
    ,"Java Web Start"
    ,"Principio Del Web De Java"
    ,"Commencement De Web De Java"
    ,"JavaWeb-Anfang "};

    //left menu intercept APAC
  public final static String INTER_APAC_MENU_TITLE[]=INTER_MENU_TITLE;
  public final static String INTER_APAC_MENU_SCANS[] = INTER_MENU_SCANS;
  public final static String INTER_APAC_MENU_BONDIN[] = {""
      ,"Bond In"
      ,"Enlace Adentro"
      ,"Lien Dedans"
      ,"Bindung Innen"};
  public final static String INTER_APAC_MENU_BONDOUT[] = {""
      ,"Bond Out"
      ,"Enlace Hacia fuera"
      ,"Lien Dehors"
      ,"Bindung Heraus"};
  public final static String INTER_APAC_MENU_MOVEMENT[] = {""
      ,"Movement"
      ,"Movimiento"
      ,"Mouvement"
      ,"Bewegung"};
   public final static String INTER_APAC_MENU_CAGE[] = {""
      ,"Cage"
      ,"Jaula"
      ,"Camp"
      ,"Rahmen"};
  public final static String INTER_APAC_MENU_STATUS[] = INTER_MENU_STATUS;
  public final static String INTER_APAC_MENU_QUERY[] = { ""
    ,"Query"
    ,"Pregunta"
    ,"Question"
    ,"Frage"};
  public final static String INTER_APAC_MENU_LOCATION_HISTORY[] = INTER_MENU_LOCATION_HISTORY;
  public final static String INTER_APAC_MENU_OTHER[] = INTER_MENU_OTHER;
  public final static String INTER_APAC_MENU_ROUTE_MAINT[] = INTER_MENU_ROUTE_MAINT;


  //left menu inventory
  public final static String INV_MENU_TITLE[]={""
     ,"Inventory Menu"
     ,"Men� Del Inventario"
     ,"Menu De Inventaire"
     ,"InhaltMen�"};
  public final static String INV_MENU_SCANS[] = {""
      ,"Scans"
      ,"Exploraciones"
      ,"Balayages"
      ,"Scans"};
  public final static String INV_MENU_REASON_SCAN[] = {""
      ,"Reason Scan"
      ,"Exploraci�n De la Raz�n"
      ,"Balayage De Raison"
      ,"GrundScan"};
  public final static String INV_MENU_RELEASE_SCAN[] = {""
      ,"Release Scan"
      ,"Release/versi�n La Exploraci�n"
      ,"Lib�rez Le Balayage"
      ,"Geben Sie Scan Frei"};
  public final static String INV_MENU_HANDLING_INST[] = {""
      ,"Handling Instructions"
      ,"Manipulaci�n De Instrucciones"
      ,"Manipulation Des Instructions"
      ,"Behandlung Von Anweisungen"};
  public final static String INV_MENU_SHIPMENT_REMARK[] = {""
      ,"Shipment Remark"
      ,"Observaci�n Del Env�o"
      ,"Remarque D'Exp�dition"
      ,"VersandAnmerkung"};
  public final static String INV_MENU_STATUS[] = { ""
    ,"Status"
    ,"Estatus"
    ,"Mode"
    ,"Status"};
  public final static String INV_MENU_DETAIN_LOC[] = { ""
    ,"Detainment Location"
    ,"Localizaci�n De la Detenci�n"
    ,"Emplacement De D�tention"
    ,"Zur�ckbehaltungStandort"};
  public final static String INV_MENU_PACKAGE_STATUS[] = { ""
    ,"Package Status"
    ,"Estatus Del Conjunto"
    ,"Mode De Module"
    ,"PaketStatus"};
  public final static String INV_MENU_OTHER[] = { ""
    ,"Other"
    ,"Otro"
    ,"Autre"
    ,"Anderes"};
  public final static String INV_MENU_RETURN_SHIP[] = { ""
    ,"Return Shipment"
    ,"Env�o De vuelta"
    ,"Exp�dition De retour"
    ,"R�ckholVersand"};
  public final static String INV_MENU_CONFIG[] = { ""
    ,"Configuration"
    ,"Configuraci�n"
    ,"Configuration"
    ,"Konfiguration"};
  public final static String INV_MENU_CONFIG_LOCATION[] = { ""
    ,"Location"
    ,"Localizaci�n"
    ,"Emplacement"
    ,"Standort"};
  public final static String INV_MENU_CONFIG_REASON_CODE[] = { ""
    ,"Reason Code"
    ,"C�digo De Raz�n"
    ,"Code compl�mentaire"
    ,"GrundCode"};
  public final static String INV_MENU_CONFIG_RELEASE_CODE[] = { ""
    ,"Release Code"
    ,"Release/versi�n El C�digo"
    ,"Lib�rez Le Code"
    ,"Geben Sie Code Frei"};
  public final static String INV_MENU_CONFIG_HANDLING_INST[] = { ""
    ,"Handling Instruction"
    ,"Manipulaci�n De la Instrucci�n"
    ,"Manipulation De l'Instruction"
    ,"Behandlung Von Anweisung"};
  public final static String INV_MENU_REMARKS[] = { ""
    ,"Remarks"
    ,"Observaciones"
    ,"Remarques"
    ,"Anmerkungen"};
  public final static String INV_MENU_DETAINMENT_IN [] = { ""
    ,"Detainment In"
    ,"Detenci�n Del Pulg"
    ,"D�tention De Po"
    ,"Zur�ckbehaltung-Inch"};
  public final static String INV_MENU_DETAINMENT_OUT [] = { ""
    ,"Detainment Out"
    ,"De la Detenci�n Hacia fuera"
    ,"De D�tention Dehors"
    ,"Zur�ckbehaltung Heraus"};
   //leave facility
  public final static String LEAVE_FACILITY_TITLE[] = { ""
      ,"Package Departure"
      ,"Salida Del Conjunto"
      ,"D�part De Module"
      ,"PaketAbfahrt"};
  /*
  public final static String LEAVE_FACILITY_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB of the departing package"
      ,"Incorpore AWB que sale del conjunto"
      ,"�crivez AWB partant du module"
      ,"Tragen Sie AWB des abreisenpakets ein"};
    */
   public final static String LEAVE_FACILITY_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String LEAVE_FACILITY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String LEAVE_FACILITY_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //Login
  public final static String LOGIN_PAGE_TITLE[] = {""
       ,"CCII Login"
       ,"CCII Conexi�n"
       ,"CCII Proc�dure de connexion"
       ,"CCII LOGON"};
  public final static String LOGIN_PAGE_INSTRUCTIONS[]={""
      ,"Please enter your username and password"
      ,"Incorpore por favor su username y palabra de paso"
      ,"Veuillez entrer votre username et mot de passe"
      ,"Tragen Sie bitte Ihr username und Kennwort ein"};
  public final static String LOGIN_USER_NAME_PROMPT[] = {"","User Name"
     ,"Nombre Del Utilizador","Nom D'Utilisateur","BenutzerName"};
  public final static String LOGIN_PASSWORD_PROMPT[] = {"","Password"
     ,"Palabra de paso","Mot de passe","Kennwort"};
  public final static String LOGIN_SITE_PROMPT[] = {"","Site"
      ,"Sitio","Emplacement","Aufstellungsort"};
  public final static String LOGIN_LANGUAGE_TITLE[] = {"","Choose Language"
     ,"Elija El Lenguaje","Choisissez Le Langage","W�hlen Sie Sprache"};
  public final static String LOGIN_CHANGE_PASSWORD_PROMPT[]= {"","Change Password"
     ,"Cambie La Palabra de paso"
     ,"Changez Le Mot de passe"
     ,"�ndern Sie Kennwort"};
  public final static String LOGIN_NEW_PASSWORD_PROMPT[] = {"","New Password"
     ,"Nueva Palabra de paso"
     ,"Nouveau Mot de passe"
     ,"Neues Kennwort"};
  public final static String LOGIN_CONFIRM_PASSWORD_PROMPT[] = {"","Confirm Password"
     ,"Confirme La Palabra de paso"
     ,"Confirmez Le Mot de passe"
     ,"Best�tigen Sie Kennwort"};
  public final static String LOGIN_EXPIRED_SESSION_ERROR_MSG[]={""
     ,"Session has expired or is not valid, you must log in again"
     ,"La sesi�n ha expirado o es inv�lida, usted debe abrirse una sesi�n otra vez "
     ,"La session a expir� ou est incorrecte, vous doit ouvrir une session encore "
     ,"Sitzung ist abgelaufen oder ist unzul�ssig, Sie mu� in wieder protokollieren "};
  public final static String LOGIN_ACTIVE_USER_ERROR_MSG[]={""
     ,"You are not an active user, please see your manager to be reactivated"
     ,"Usted no es un utilizador activo, ve por favor a su encargado que se reactivar� "
     ,"Vous n'�tes pas un utilisateur actif, voyez s'il vous pla�t votre gestionnaire � r�activer"
     ,"You are not an active user, please see your manager to be reactivated"};
  public final static String LOGIN_ENABLED_USER_ERROR_MSG[]={""
     ,"You are not an enabled user, please see your manager to be Enabled"
     ,"Usted no es un utilizador permitido, ve por favor a su encargado que se permitir� "
     ,"Vous n'�tes pas un utilisateur permis, voyez s'il vous pla�t votre gestionnaire � permettre "
     ,"Sie sind nicht ein aktivierter Benutzer, sehen bitte Ihren zu aktivierenden Manager "};
  public final static String LOGIN_PASSWORD_CORRECT_ERROR_MSG[]={""
     ,"Your user name or password is incorrect, please login again"
     ,"Su nombre o palabra de paso del utilizador es incorrecta, por favor conexi�n otra vez "
     ,"Votre nom ou mot de passe d'utilisateur est incorrect, s'il vous pla�t proc�dure de connexion encore "
     ,"Ihr Benutzername oder -kennwort ist falsch, bitte LOGON wieder "};
  public final static String LOGIN_EXPIRED_USER_ERROR_MSG[]={""
     ,"Your password has expired, you must change your password before logging in"
     ,"Su palabra de paso ha expirado, usted debe cambiar su palabra de paso antes que entraba "
     ,"Votre mot de passe a expir�, vous doit changer votre mot de passe avant entrant "
     ,"Ihr Kennwort ist, Sie mu� Ihr Kennwort �ndern abgelaufen, bevor es protokollierte in "};
  public final static String LOGIN_PASSWORDS_DO_NOT_MATCH_ERROR_MSG[] = {""
     ,"On Change Password, Passwords do not match.  Please try again."
     ,"En palabra de paso del cambio, las palabras de paso no corresponden con. Por favor intento otra vez"
     ,"Sur le mot de passe de changement, les mots de passe ne s'assortissent pas. S'il vous pla�t essai encore. "
     ,"Auf �nderung Kennwort passen Kennw�rter nicht zusammen. Bitte Versuch wieder.  "};
  public final static String LOGIN_NEW_PASSWORD_NO_CHANGE_ALLOWED_ERROR_MSG[] = {""
     ,"User not allowed to change password"
     ,"Utilizador no permitido cambiar palabra de paso"
     ,"Utilisateur non permis de changer le mot de passe"
     ,"Benutzer nicht erlaubt, Kennwort zu �ndern"};
  public final static String LOGIN_NEW_PASSWORD_LENGTH_ERROR_MSG[] = {""
     ,"Password length error"
     ,"Error de longitud de la palabra de paso"
     ,"Erreur de longueur de mot de passe"
     ,"Kennwortl�ngenfehler"};
  public final static String LOGIN_NEW_PASSWORD_INVALID_CHARS_ERROR_MSG[] = {""
     ,"Password contains invalid characters"
     ,"La palabra de paso contiene caracteres inv�lidos"
     ,"Le mot de passe contient les caract�res incorrects"
     ,"Kennwort enth�lt unzul�ssige Zeichen"};
  public final static String LOGIN_NO_LOGIN_GROUP_ERROR_MSG[] = { ""
    ,"You are not a member of any login group.  Please see your manager to be added to a login group."
    ,"Usted no es un miembro de cualquier grupo de la conexi�n. Vea por favor a su encargado que se agregar� a un grupo de la conexi�n."
    ,"Vous n'�tes pas un membre de tout groupe de proc�dure de connexion. Veuillez voir le votre gestionnaire � ajouter � un groupe de proc�dure de connexion."
    ,"Sie sind nicht ein Bauteil irgendeiner LOGON-Gruppe. Sehen Sie bitte Ihren einer LOGON-Gruppe hinzuzuf�genden Manager."};
  public final static String LOGIN_LANGUAGE1[] = {""
    ," DEFAULT> English"
    ,"> Ingl�s"
     ,"> Anglais"
     ,"> Englische"};
  public final static String LOGIN_LANGUAGE2[] = {""
    ,"> Spanish"
    ," DEFAULT> Espa�ol"
    ,"> Espagnole"
    ,"> Spanische"};
  public final static String LOGIN_LANGUAGE3[] = {""
   ,"> French"
   ,"> Franc�s"
    ," DEFAULT> Fran�aise"
    ,"> Franz�sische"};
   public final static String LOGIN_LANGUAGE4[] = {""
     ,"> German"
     ,"> Alem�n"
    ,"> Allemande"
    ," DEFAULT> Deutsche"};
  //logoutSucess
  public final static String LOGOUT_SUCCESS_TITLE[] = {""
    ,"Logout Successful"
    ,"Fin de comunicaci�n Acertada"
    ,"Sortie du syst�me R�ussie"
    ,"Logout Erfolgreich"};
  public final static String LOGOUT_SUCCESS_TEXT[] = {""
    ,"Click here to return to login screen"
    ,"Tecleo aqu� a volver a la pantalla de la conexi�n"
    ,"D�clic ici � retourner � l'�cran de proc�dure de connexion"
    ,"Klicken hier zum Zur�ckgehen zum LOGON-Bildschirm"};
  public final static String LOGOUT_SUCCESS_FORWARD_TO_HOMEPAGE[] = {""
    ,"Automatically forwarding to browser homepage"
    ,"Autom�ticamente expedici�n al homepage del browser"
    ,"Automatiquement exp�dition au homepage de browser"
    ,"Automatisch Versenden zu Datenbanksuchroutinehomepage"};
  //main frame
  public final static String MAIN_FRAME_TITLE[] = { ""
     ,"CCII Application"
     ,"CCII Aplicaci�n"
     ,"CCII Application"
     ,"CCII Anwendung"};
  //manipulate Intercepts
  public final static String MANIPULATE_INTERCEPT_INTERCEPT[] = {""
    ,"Intercept"
    ,"Interceptaci�n"
    ,"Interception"
    ,"Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_INPUT_PAGE_TITLE[] = {""
    ,"Add, Remove, or Satisfy an Intercept"
    ,"Agregue, quite, o satisfaga una intercepci�n"
    ,"Ajoutez, enlevez, ou satisfaites une interception"
    ,"Addieren Sie, entfernen Sie oder erf�llen Sie einen Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_CODE_INSTRUCTIONS[] = {""
    ,"Choose an Agency"
    ,"Elija una agencia"
    ,"Choisissez une agence"
    ,"W�hlen Sie eine Agentur"};
  public final static String MANIPULATE_INTERCEPT_CODE2_INSTRUCTIONS[] = {""
    ,"Choose an Intercept"
    ,"Elija una interceptaci�n"
    ,"Choisissez une interception"
    ,"W�hlen Sie einen Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_AWB_INSTURCTIONS[] = {""
    ,"Enter one or more AWB numbers"
    ,"Incorpore unos o m�s n�meros de AWB"
    ,"�crivez un ou plusieurs nombres d'cAwb"
    ,"Geben Sie eine oder mehr AWB-Zahlen ein"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_ADD[] = {""
    ,"Add"
    ,"Agregue"
    ,"Ajoutez"
    ,"F�gen Sie hinzu"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_DELETE[] = {""
    ,"Remove"
    ,"Quitan"
    ,"Retirent"
    ,"L�schen"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_SATISFY[] = { ""
    ,"Satisfy"
    ,"Satisfacen"
    ,"Satisfont"
    ,"Erf�llen"};
  public final static String MANIPULATE_INTERCEPT_WARNING[] = {""
    ,"This screen manipulates shipment level intercepts"
    ,"Esta pantalla manipula interceptaciones del nivel del env�o"
    ,"Cet �cran manipule des interceptions de niveau d'exp�dition"
    ,"Dieser Bildschirm manipuliert Versandstufe Abschnitte"};
  public final static String MANIPULATE_INTERCEPT_SHIPMENT_LEVEL[] = {""
    ,"Shipment Level"
    ,"Nivel Del Env�o"
    ,"Niveau D'Exp�dition"
    ,"Versand-Niveau"};
  public final static String MANIPULATE_INTERCEPT_PIECE_LEVEL[] = {""
    ,"Piece Level"
    ,"Nivel Del Pedazo"
    ,"Niveau De Morceau"
    ,"St�ck-Niveau"};
  //movement scan
  public final static String MOVEMENT_TITLE[] = { ""
    ,"Movement Scan"
    ,"Exploraci�n Del Movimiento"
    ,"Balayage De Mouvement"
    ,"Bewegung Scan"};
  public final static String MOVEMENT_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String MOVEMENT_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String MOVEMENT_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String MOVEMENT_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String MOVEMENT_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //No permission
  public final static String NO_PERMISSION_TITLE[]={""
     ,"No Permission"
     ,"Ning�n Permiso"
     ,"Aucune Permission"
     ,"Keine Erlaubnis"};
  public final static String NO_PERMISSION_TEXT[]= {""
     ,"You do not have permission to use this functionality.  "
     + "Please choose a different function from the menu.  "
     + "If you feel you should have this functionality, please see your manager. "
     ,"Usted no tiene permiso de utilizar estas funciones.  "
     + "Elija por favor una diversa funci�n del men�.  "
     + "Si usted se siente usted debe tener estas funciones, ve por favor a su encargado.  "
     ,"Vous n'avez pas la permission d'utiliser cette fonctionnalit�.  "
     + "Veuillez choisir une fonction diff�rente du menu.  "
     + "Si vous vous sentez vous devriez avoir cette fonctionnalit�, voyez s'il vous pla�t votre gestionnaire.  "
     ,"Sie haben nicht Erlaubnis, diese Funktionalit�t zu verwenden"
     + "W�hlen Sie bitte eine andere Funktion vom Men�.  "
     + "Wenn Sie glauben, sollten Sie diese Funktionalit�t haben, sehen bitte Ihren Manager." };
  //package arrivale
  public final static String PACKAGE_ARRIVAL_TITLE[] = { ""
    ,"Package Arrival"
    ,"Llegada Del Conjunto"
    ,"Arriv�e De Module"
    ,"PaketAnkunft"};
  public final static String PACKAGE_ARRIVAL_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String PACKAGE_ARRIVAL_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String PACKAGE_ARRIVAL_CODE_INSTRUCTIONS[] = { ""
    ,"Route Number"
    ,"N�meros De la Ruta"
    ,"Nombres D'Itin�raire"
    ,"WegZahlen"};
  public final static String PACKAGE_ARRIVAL_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //package History
  public final static String PACKAGE_HISTORY_TITLE[] = { ""
    ,"Show Package Location and History"
    ,"Muestre la localizaci�n del conjunto e historia"
    ,"Montrez l'emplacement et l'histoire de module"
    ,"Zeigen Sie Paketstandort und -geschichte"};
  public final static String PACKAGE_HISTORY_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Location and History"
    ,"Incorpore N�mero El Seguir para encontrar la localizaci�n e historia"
    ,"�crivez Nombre De Cheminement pour trouver l'emplacement et l'histoire"
    ,"Tragen Sie GleichlaufZahl ein, um Standort und Geschichte zu finden"};
  public final static String PACKAGE_HISTORY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String PACKAGE_HISTORY_DUPLICATES_FOUND[] = {""
    ," Duplicates found for: "
    ," Los art�culos con llave de validaci�n encontraron para: "
    ," Les doubles ont trouv� pour: "
    ," Duplikate fanden f�r: "};
  public final static String PACKAGE_HISTORY_OF[] = {""
    ," of "
    ," de "
    ," de "
    ," von "};
  public final static String PACKAGE_HISTORY_NO_PACKAGE_FOUND[] = {""
    ,"No Package found for: "
    ,"Ning�n conjunto encontrado para: "
    ,"Aucun module n'a trouv� pour: "
    ,"Kein Paket fand f�r: "};
  public final static String PACKAGE_HISTORY_TRACKINGNUMBER[] = {""
    ,"Tracking Number"
    ,"Seguir N�mero"
    ,"Cheminement Du Nombre"
    ,"Gleichlauf Von Zahl"};
  public final static String PACKAGE_HISTORY_LAST_USER[] = {""
    ,"Last User"
    ,"Utilizador Pasado"
    ,"Dernier Utilisateur"
    ,"Letzter Benutzer"};
  public final static String PACKAGE_HISTORY_LAST_DATE[] = {""
    ,"Last Date Time"
    ,"La Vez Pasada De la Fecha"
    ,"La Fois Pass�e De Date"
    ,"Letztes DatumMal"};
  public final static String PACKAGE_HISTORY_STAGING_AREA[] = STAGING_AREA;
  public final static String PACKAGE_HISTORY_DETAINMENT_LOC[] = {""
    ,"Detainment Loc"
    ,"Localizaci�n De la Detenci�n"
    ,"Emplacement De D�tention"
    ,"Zur�ckbehaltungStandort"};
  public final static String PACKAGE_HISTORY_STATUS[] = GENERIC_STATUS_STATUS_OR_LOCATION;
  public final static String PACKAGE_HISTORY_NO_SCANS[] = { ""
    ,"No scans found for: "
    ,"Ningunas exploraciones encontraron para: "
    ,"Aucuns balayages trouv�s pour: "
    ,"Keine Scans gefunden f�r: "};
  public final static String PACKAGE_HISTORY_LOCAL_SCANS[]= {""
    ,"Local Scans for: "
    ,"Exploraciones locales para: "
    ,"Balayages locaux pour: "
    ,"Lokale Scans f�r: "};
  public final static String PACKAGE_HISTORY_DATE_TIME [] = { ""
    ,"Date/Time"
    ,"Tiempo De la Fecha"
    ,"Temps De Date"
    ,"DatumZeit"};
   public final static String PACKAGE_HISTORY_SCAN_CODE [] = { ""
    ,"Scan Type"
    ,"Tipo De la Exploraci�n"
    ,"Type De Balayage"
    ,"Scan-Art"};
  public final static String PACKAGE_HISTORY_STAT_CODE [] = { ""
    ,"Stat Code"
    ,"C�digo De Estatus"
    ,"Code De Mode"
    ,"Status-Code"};
   public final static String PACKAGE_HISTORY_EMPLOYEE_NUM [] = { ""
    ,"Employee Number"
    ,"N�mero Del Empleado"
    ,"Nombre Des Employ�s"
    ,"AngestelltZahl"};
  public final static String PACKAGE_HISTORY_END_DUPLICATES[] = {""
    ,"end of duplicates found for: "
    ,"el extremo de art�culos con llave de validaci�n encontr� para: "
    ,"end of duplicates found for: "
    ,"Ende der Duplikate gefunden f�r: "};
  public final static String PACKAGE_HISTORY_ORIGIN[] = { ""
    ,"Orgn Loc"
    ,"Orgn Loc"
    ,"Orgn Loc"
    ,"Orgn Loc"};
  public final static String PACKAGE_HISTORY_DEST[] = { ""
    ,"Dest Loc"
    ,"Dest Loc"
    ,"Dest Loc"
    ,"Dest Loc"};
  public final static String PACKAGE_HISTORY_CUSTOMS_CLEARED [] = { ""
    ,"Customs Cleared"
    ,"Costumbres Borrados"
    ,"Coutumes Effac�es"
    ,"Gewohnheiten Gel�scht"};
  //package Stage staus
  public final static String PACKAGE_STAGE_STATUS_TITLE[] = { ""
    ,"Show Package Status"
    ,"Demuestre El Estado Del Paquete"
    ,"Montrez Le Statut De Paquet"
    ,"Zeigen Sie Paket-Status"};
  public final static String PACKAGE_STAGE_STATUS_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Status"
    ,"Incorpore N�mero El Seguir para encontrar estatus"
    ,"�crivez Nombre De Cheminement pour trouver le mode"
    ,"Tragen Sie GleichlaufZahl ein, um Status zu finden"};
  public final static String PACKAGE_STAGE_STATUS_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  //package status
  public final static String PACKAGE_STATUS_TITLE[] = { ""
    ,"Show Package Status Screen"
    ,"Muestre La Pantalla Del Estatus Del Conjunto"
    ,"Montrez L'�cran De Mode De Module"
    ,"Zeigen Sie PaketStatusBildschirm"};
  public final static String PACKAGE_STATUS_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Status"
    ,"Incorpore N�mero El Seguir para encontrar estatus"
    ,"�crivez Nombre De Cheminement pour trouver le mode"
    ,"Tragen Sie GleichlaufZahl ein, um Status zu finden"};
  public final static String PACKAGE_STATUS_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  //printer ID label
  public final static String PRINTERID_TITLE[] = { ""
    ,"Printer ID Label"
    ,"Etiqueta de la Identificaci�n De la Impresora"
    ,"�tiquette d'Identification D'Imprimeur"
    ,"Aufkleber Des Drucker-Identifikation"};
  public final static String PRINTERID_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose Printer name to print Printer ID label"
    ,"Elija el nombre de la impresora para imprimir la etiqueta de la identificaci�n de la impresora "
    ,"Choisissez le nom d'imprimeur pour imprimer l'�tiquette d'identification d'imprimeur "
    ,"Beschlie�en Sie Druckernamen, um Aufkleber des Druckers Identifikation zu drucken "};
  public final static String PRINTERID_CODE_INSTRUCTIONS[] = { ""
    ,"Printer ID"
    ,"Identificaci�n De la Impresora"
    ,"Identification D'Imprimeur"
    ,"Drucker Identifikation "};
   public final static String PRINTERID_EXCEPTION_ALL_PRINTERS [] = {""
    ,"All printers"
    ,"Todas las impresoras"
    ,"Tous les imprimeurs"
    ,"Alle Drucker"};
  //printer Option menu
  public final static String PRINTEROPT_MENU_TITLE[] = {""
    ,"Printer Options"
    ,"Opciones De la Impresora"
    ,"Options D'Imprimeur"
    ,"Drucker-Wahlen"};
  public final static String PRINTEROPT_PRINTEROPT[] = {""
    ,"Print ID labels"
    ,"Etiquetas de la identificaci�n de la impresi�n"
    ,"�tiquettes d'identification d'impression"
    ,"Aufkleber des Druckes Identifikation"};
  public final static String PRINTEROPT_DETAIN_AREA_LOC_LABEL[] = {""
    ,"Detainment Loc Label"
    ,"Etiqueta De la Localizaci�n De la Detenci�n"
    ,"�tiquette D'Endroit De D�tention"
    ,"Zur�ckbehaltung-Position Aufkleber"};
  public final static String PRINTEROPT_DOWNLOAD_FORMATS[] = {""
    ,"Download Formats"
    ,"Formatos De la Transferencia directa"
    ,"Formats De T�l�chargement"
    ,"Download-Formate"};
  public final static String PRINTEROPT_PRINTERID_LABEL[] = {""
    ,"Printer ID Label"
    ,"Etiqueta de la Identificaci�n De la Impresora"
    ,"�tiquette d'Identification D'Imprimeur"
    ,"Aufkleber Des Drucker-Identifikation"};
  public final static String PRINTEROPT_STAGEAREAID_LABEL[] = {""
    ,"Staging Area ID Label"
    ,"Etiqueta de la Identificaci�n Del �rea Que efect�a"
    ,"�tiquette d'Identification De Secteur Mettant en sc�ne"
    ,"Inszenierung Bereich Identifikation Aufkleber"};
  public final static String PRINTEROPT_WHSEID_LABEL[] = { ""
    ,"Warehouse Id Label"
    ,"Etiqueta De la Identificaci�n Del Almac�n"
    ,"�tiquette D'Identification D'Entrep�t"
    ,"Lager-Kennzeichnung Aufkleber"};
  //query
  public final static String QUERY_TITLE[] = { ""
      ,"Query Scan"
      ,"Exploraci�n De la Pregunta"
      ,"Balayage De Question"
      ,"Frage Scan"};
  public final static String QUERY_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String QUERY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String QUERY_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //reason code
  public final static String REASON_INPUT_PAGE_TITLE[] = {""
    ,"Reason Code Input Page"
    ,"Paginaci�n De la Entrada de informaci�n Del C�digo De Raz�n"
    ,"Page D'Entr�e De Code compl�mentaire"
    ,"GrundCode-InputSeite"};
  public final static String REASON_CODE_INSTRUCTIONS[] = {""
    ,"Select one or more Reason codes"
    ,"Seleccione unos o m�s c�digos de raz�n"
    ,"Choisissez un ou plusieurs codes compl�mentaires"
    ,"W�hlen Sie ein oder mehr Grundcodes aus"};
  public final static String REASON_AWB_INSTURCTIONS[] = {""
    ,"Enter one or more Tracking Number numbers"
    ,"Incorpore unos o m�s n�meros El Seguir"
    ,"�crivez un ou plusieurs nombres De Cheminement"
    ,"Geben Sie eine oder mehr GleichlaufZahl-Zahlen ein"};
  //regulatory releease
  public final static String REGULATORY_RELEASE_TITLE[] = { ""
    ,"Regulatory Release"
    ,"Regulador Desbloquear"
    ,"De normalisation Version"
    ,"Regelnde Freigabe"};
  public final static String REGULATORY_RELEASE_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter the tracking number and release number of the package to be released"
    ,"Incorpore el n�mero que sigue y release/versi�n el n�mero del conjunto que release/versi�n"
    ,"�crivez le nombre de cheminement et lib�rez le nombre du module � lib�rer"
    ,"Tragen Sie die aufsp�renzahl ein und geben Sie Zahl des freizugebenden Pakets frei "};
  public final static String REGULATORY_RELEASE_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String REGULATORY_RELEASE_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Release Number"
    ,"Release/versi�n El N�mero"
    ,"Lib�rez Le Nombre"
    ,"Geben Sie Zahl Frei"};
  //release code
  public final static String RELEASE_INPUT_PAGE_TITLE[] = {""
    ,"Release Code Input Page"
    ,"Release/versi�n La Paginaci�n De la Entrada de informaci�n Del C�digo"
    ,"Lib�rez La Page D'Entr�e De Code"
    ,"Geben Sie CodeInputSeite Frei"};
  public final static String RELEASE_CODE_INSTRUCTIONS[] = {""
      ,"Select one or more Realease codes"
      ,"Seleccione unos o m�s c�digos de Realease"
      ,"Choisissez un ou plusieurs codes de Realease"
      ,"W�hlen Sie ein oder mehr Codes Realease aus"};
  public final static String RELEASE_AWB_INSTURCTIONS[] =
     {"","Enter one or more Tracking Numbers"
      ,"Incorpore unos o m�s n�meros El Seguir"
      ,"�crivez un ou plusieurs nombres De Cheminement"
      ,"Geben Sie eine oder mehr GleichlaufZahl-Zahlen ein"};
  public final static String REPORT_NOT_HERE_TITLE[]= {""
    ,"Reports not on this system"
    ,"Informes no sobre este sistema."
    ,"�tats pas sur ce syst�me."
    ,"Berichte nicht �ber dieses System."};
  public final static String REPORT_NOT_HERE_MESSAGE[]= {""
    ,"Reports are not located on this system.  Please use the Eureka report viewer to access the reports."
    ,"Se�ale no est�n situados en este system. Utilice por favor el espectador del informe de Eureka para tener acceso a los informes."
    ,"Enregistrez ne sont pas situ�s sur ce system. Veuillez employer le visualisateur d'�tat de Eureka pour acc�der aux �tats."
    ,"Berichten Sie sind nicht auf diesem system. Benutzen Sie bitte den Eureka-Reportprojektor, um die Reports zuzugreifen."};
  //Reprocess
  public final static String REPROCESS__TITLE [] = {""
    ,"Reprocess"
    ,"Trate de nuevo"
    ,"Retraitez"
    ,"Bereiten Sie wieder auf"};
   public final static String REPROCESS__TRACKING_NBR [] = {""
    ,"Tracking Number: "
    ,"Seguir N�mero: "
    ,"Cheminement Du Nombre: "
    ,"Gleichlauf Von Zahl: "};
  public final static String REPROCESS__ATTEMPT_SCAN [] = {""
    ,"Attempting Scan: "
    ,"Procurar La Exploraci�n: "
    ,"Essayer Le Balayage: "
    ,"Versuchen Des Scans: "};
  public final static String REPROCESS__ERROR_MSG [] = {""
    ,"Error Messages: "
    ,"Mensajes De Error: "
    ,"Messages D'Erreur: "
    ,"Fehlermeldungen: "};
  public final static String REPROCESS__ATTEMPT_REASON [] = {""
    ,"Attempted Reason Code: "
    ,"C�digo De Raz�n Procurado: "
    ,"Code compl�mentaire Essay�: "
    ,"Versuchter GrundCode: "};
  public final static String REPROCESS__ATTEMPT_RELEASE [] = {""
    ,"Attempted Release Code: "
    ,"C�digo Procurado Del Desbloquear: "
    ,"Code Essay� De Version: "
    ,"Versuchter FreigabeCode: "};
  public final static String REPROCESS__ATTEMPT_HANDLING [] = {""
    ,"Attempted Handling Code: "
    ,"Procurado Manejando C�digo: "
    ,"Essay� Manipulant Le Code: "
    ,"Versucht, Code Anfassend: "};
  public final static String REPROCESS__ATTEMPT_REMARK [] = {""
    ,"Attempted Remark Code: "
    ,"C�digo Procurado De la Observaci�n: "
    ,"Code Essay� De Remarque: "
    ,"Versuchter AnmerkungCode: "};
  public final static String REPROCESS__ATTEMPT_STAGEAREA [] = {""
    ,"Attempted Stage Area Code: "
    ,"C�digo De �rea Procurado De la Etapa: "
    ,"Indicatif r�gional Essay� D'�tape: "
    ,"Versuchte Stadium Ortsnetzkennzahl: "};
  public final static String REPROCESS__NEW_AWB [] = {""
    ,"Enter new Tracking Number: "
    ,"Incorpore N�mero El Seguir: "
    ,"�crivez Nombre De Cheminement: "
    ,"Tragen Sie neues GleichlaufZahl ein: "};
   public final static String REPROCESS__ENTER_MASTER [] = {""
    ,"Enter Master: "
    ,"Entre en El Amo: "
    ,"Entrez dans Le Ma�tre: "
    ,"Betreten Sie Meister: "};
  public final static String REPROCESS__MASTER_UNKNOWN[] = {""
    ,"Check here if Master is unknown: "
    ,"Controle aqu� si el amo es desconocido: "
    ,"Contr�lez ici si le ma�tre est inconnu: "
    ,"�berpr�fen Sie hier, ob Meister unbekannt ist: "};
   public final static String REPROCESS__ENTER_FORM_CODE [] = {""
    ,"Enter Form Code: "
    ,"Introduzca El C�digo De la Forma: "
    ,"�crivez Le Code De Forme: "
    ,"Geben Sie FormularCode Ein: "};
   public final static String REPROCESS__DETAINMENT_LOC [] = {""
    ,"Enter Detainment Location: "
    ,"Entre en La Localizaci�n De la Detenci�n: "
    ,"Entrez L'Emplacement De D�tention: "
    ,"Geben Sie Zur�ckbehaltungStandort Ein: "};
   public final static String REPROCESS__UNKNOWN_ERROR [] = {""
    ,"Unknown error Type"
    ,"Desconocido tipo de error"
    ,"Inconnu type d'erreur"
    ,"Unbekannte Fehlerart"};
  public final static String REPROCESS__OVERRIDE_ERROR [] = {""
    ,"Override Error"
    ,"Error De la Invalidaci�n"
    ,"Erreur De Priorit�"
    ,"�bersteuerung Fehler"};

  //ReprocessComplete
  public final static String REPROCESS_COMPLETE_TITLE [] = {""
    ,"Reprocess Complete"
    ,"Trate de nuevo Completo"
    ,"Retraitez Complet"
    ,"Bereiten Sie Komplettes Wieder auf"};
  public final static String REPROCESS_COMPLETE_TEXT[] = {""
    ,"Reprocess is complete, choose another function to perform"
    ,"Trate de nuevo es completo, elige otra funci�n para realizarse "
    ,"Retraitez est complet, choisit une autre fonction pour ex�cuter "
    ,"Bereiten Sie ist komplett, beschlie�t eine andere Funktion, um durchzuf�hren wieder auf"};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART1[] = {""
    ,"Return to "
    ,"Vuelva a la "
    ,"Revenez � "
    ,"Gehen Sie zum urspr�nglichen "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART2[] = {""
    ," original "
    ," pantalla  "
    ," l'�cran  "
    ," Bildschirm   "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART3[] = {""
    ," screen"
    ," original"
    ," initial"
    ," zur�ck"};

/*  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART1[] = {""
    ,"Automatically "
    ,"Autom�ticamente "
    ,"Automatiquement "
    ,"Automatisch "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART2[] = {""
    ," forwarding "
    ," expedici�n "
    ," exp�dition "
    ," Versenden "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART3[] = {""
    ," to original input page"
    ," a la paginaci�n original de la entrada de informaci�n"
    ," � la page initiale d'entr�e"
    ," zur urspr�nglichen Inputseite"};
    */
  //ReprocesDup
  public final static String REPROCESS_DUP_TITLE [] = {""
    ,"Reprocess: Resolve Duplicate"
    ,"Trate de nuevo: Resuelva El Art�culo con llave de validaci�n"
    ,"Retraitez:  R�solvez Le Double"
    ,"Bereiten Sie wieder auf:  Beheben Sie Duplikat"};
  public final static String REPROCESS_DUP_TRACKING_NBR [] = {""
    ,"Tracking Number: "
    ,"Seguir N�mero: "
    ,"Cheminement Du Nombre: "
    ,"Gleichlauf Von Zahl: "};
  public final static String REPROCESS_DUP_ATTEMPT_SCAN [] = {""
    ,"Attempting Scan: "
    ,"Procurar La Exploraci�n: "
    ,"Essayer Le Balayage: "
    ,"Versuchen Des Scans: "};
  public final static String REPROCESS_DUP_CHOOSE [] = {""
    ,"Choose"
    ,"Elija"
    ,"Choisissez"
    ,"W�hlen Sie"};
  public final static String REPROCESS_DUP_SHIP_DATE [] = {""
    ,"Shipment Date"
    ,"Fecha Del Env�o"
    ,"Date D'Exp�dition"
    ,"VersandDatum"};
  public final static String REPROCESS_DUP_SHIP_DESC [] = {""
    ,"Shipment Desc"
    ,"Env�o Desc"
    ,"Exp�dition Desc"
    ,"Versand Desc"};
  public final static String REPROCESS_DUP_SERVICE_CODE [] = {""
    ,"SVC Cd"
    ,"SVC Cd"
    ,"SVC Cd"
    ,"SVC Cd"};
  public final static String REPROCESS_DUP_MANIFEST_STATUS [] = {""
    ,"Mnf Stat"
    ,"Mnf Stat"
    ,"Mnf Stat"
    ,"Mnf Stat"};
  public final static String REPROCESS_DUP_CUSTOMS_VALUE [] = {""
    ,"Customs Value"
    ,"Valor De los Costumbres"
    ,"Valeur De Douane"
    ,"Gewohnheiten Wert"};
  public final static String REPROCESS_DUP_CARRIAGE_VALUE [] = {""
    ,"Carriage Value"
    ,"Valor Del Carro"
    ,"Valeur De Chariot"
    ,"WagenWert"};
  public final static String REPROCESS_DUP_ORIGN_COUNTRY [] = {""
    ,"Orgn Cnty"
    ,"Orgn Cnty"
    ,"Orgn Cnty"
    ,"Orgn Cnty"};
   public final static String REPROCESS_DUP_DESTINATION_COUNTRY [] = {""
    ,"Dest Cnty"
    ,"Dest Cnty"
    ,"Dest Cnty"
    ,"Dest Cnty"};
   public final static String REPROCESS_DUP_ORIGN_LOCATION [] = {""
    ,"Orgn Loc"
    ,"Orgn Loc"
    ,"Orgn Loc"
    ,"Orgn Loc"};
   public final static String REPROCESS_DUP_DESTINATION_LOCATION [] = {""
    ,"Dest Loc"
    ,"Dest Loc"
    ,"Dest Loc"
    ,"Dest Loc"};
   public final static String REPROCESS_DUP_SHIPPER_INFO [] = {""
    ,"Shipper, country, postal"
    ,"Expedidor, pa�s, postal"
    ,"Exp�diteur, pays, postal"
    ,"Verlader, Land, Post"};
   public final static String REPROCESS_DUP_CONSIGNEE_INFO [] = {""
    ,"Consignee, country, postal"
    ,"Consignatario, pa�s, postal"
    ,"Destinataire, pays, postal"
    ,"Empf�nger, Land, Post"};
   public final static String REPROCESS_DUP_NO_DUPS_FOUND [] = {""
    ,"No duplicates found to resolve"
    ,"Ningunos art�culos con llave de validaci�n encontraron para resolver. "
    ,"Double n'a pas trouv� pour r�soudre"
    ,"Keine Duplikate gefunden, um zu beheben"};
   public final static String REPROCESS_DUP_UNABLE_FETCH [] = {""
    ,"Unable to fetch info on duplicate"
    ,"Incapaz traer el Info en el art�culo con llave de validaci�n"
    ,"Incapable de chercher l'information sur le double"
    ,"Nicht imstande, INFO auf Duplikat zu holen"};
  //ReprocessProcess
  public final static String REPROCESS_PROCESS_REPROCESS[] = {""
    ,"Reprocessed"
    ,"Tratado de nuevo"
    ,"Retrait�"
    ,"Wieder aufbereitet"};
   //ReprocessUnable
  public final static String REPROCESS_UNABLE_TITLE [] = {""
    ,"Unable to reprocess"
    ,"Incapaz tratar de nuevo"
    ,"Incapable de retraiter"
    ,"Nicht imstande wieder aufzubereiten"};
  public final static String REPROCESS_UNABLE_TEXT[] = {""
    ,"Unable to reprocess"
    ,"Incapaz tratar de nuevo"
    ,"Incapable de retraiter"
    ,"Nicht imstande wieder aufzubereiten"};
  public final static String REPROCESS_UNABLE_INFO[] = {""
    ,"Info"
    ,"Info"
    ,"Information"
    ,"INFO"};
  public final static String REPROCESS_UNABLE_DELETE[] = {""
    ,"Delete"
    ,"Cancelaci�n"
    ,"Effacement"
    ,"L�schung"};
  //result window
  public final static String RESULT_WINDOW_TITLE [] = {""
    ,"Result Window"
    ,"Window Del Resultado"
    ,"Window De R�sultat"
    ,"Resultat Window"};
  public final static String RESULT_WINDOW_SUCCESS [] = {""
    ,"Success: "
    ,"�xito: "
    ,"Succ�s: "
    ,"Erfolg: "};
  public final static String RESULT_WINDOW_FAIL [] = {""
    ,"Fail: "
    ,"Fall: "
    ,"�chouer: "
    ,"Ausfallen: "};
  public final static String RESULT_WINDOW_AWB [] = {""
    ,"AWB"
    ,"AWB"
    ,"AWB"
    ,"AWB"};
  public final static String RESULT_WINDOW_SCAN_NAME [] = {""
    ,"Scan Type"
    ,"Tipo De la Exploraci�n"
    ,"Type De Balayage"
    ,"Scan-Art"};
  public final static String RESULT_WINDOW_CODE_OR_DESC [] = {""
    ,"Code or Description"
    ,"C�digo o descripci�n"
    ,"Code ou description"
    ,"Code oder Beschreibung"};
  public final static String RESULT_WINDOW_SCAN_RESULT[] = {""
    ,"Scan Result"
    ,"Resultado De Exploraci�n"
    ,"R�sultat De Balayage"
    ,"Scan-Resultat"};
  public final static String RESULT_WINDOW_NONE [] = {""
    ,"None"
    ,"Ningunos"
    ,"Aucun"
    ,"Keine"};
  public final static String RESULT_WINDOW_NONE_YET [] = {""
    ,"None Processed yet"
    ,"Ninguno procesada todav�a"
    ,"Aucun trait� encore"
    ,"Keine verarbeiteten schon"};
  public final static String RESULT_WINDOW_REMOVE_ALL[] = {""
    ,"Remove All"
    ,"Quite Todos"
    ,"Retirez Tous"
    ,"L�schen Sie Alle"};
  public final static String RESULT_WINDOW_REMOVE_SUCCESSFUL[] = {""
    ,"Remove Successful"
    ,"Quitan Acertado"
    ,"Retirez R�ussi"
    ,"L�schen Sie Erfolgreiches"};
  public final static String RESULT_WINDOW_REPROCESS_ALL[] = { ""
    ,"Reprocess All"
    ,"Trate de nuevo Todos"
    ,"Retraitez Tous"
    ,"Bereiten Sie Alles Wieder auf"};
  //return package to shipper
  public final static String RETURN_PKG_SHIPPER_TITLE[] = { ""
    ,"Return Package to Shipper"
    ,"Conjunto de vuelta al expedidor"
    ,"Module de retour � l'exp�diteur"
    ,"R�ckholpaket zum Verlader"};
  public final static String RETURN_PKG_SHIPPER_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter the original AWB and the new AWB to return a package to shipper"
    ,"Incorpore el AWB original y el AWB nuevo para volver un conjunto al expedidor"
    ,"Entrez dans l'cAwb initial et le nouvel AWB pour renvoyer un module � l'exp�diteur"
    ,"Tragen Sie das urspr�ngliche AWB und das neue AWB ein, um ein Paket zum Verlader zur�ckzubringen"};
  public final static String RETURN_PKG_SHIPPER_AWB_INSTRUCTIONS[] = { ""
    ,"Original AWB"
    ,"Awb Original"
    ,"Awb Initial"
    ,"Urspr�ngliches Awb"};
  public final static String RETURN_PKG_SHIPPER_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Return AWB"
    ,"Awb De vuelta"
    ,"Awb De retour"
    ,"R�ckhol-Awb"};
     // Corporate RIP scan
  public final static String RIP_INPUT_PAGE_TITLE[] = {""
      ,"Ramp In (RIP) Input Page"
      ,"Rampa en p�gina de la entrada del (RIP)"
      ,"Rampe en page d'entr�e de (RIP)"
      ,"Rampe in der x(RIP)x Eingang Seite"};
  public final static String RIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for RIP Scan"
      ,"Incorpore AWB para la exploraci�n del RIP."
      ,"�crivez AWB pour le balayage de RIP"
      ,"Tragen Sie AWB f�r RIP Scan ein"};
  public final static String RIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate ROP Scan
   public final static String ROP_INPUT_PAGE_TITLE[] = {""
      ,"Ramp Out (ROP) Input Page"
      ,"Rampa fuera de la p�gina de la entrada del (ROP)"
      ,"Rampe hors de page d'entr�e de (ROP)"
      ,"Rampe aus (ROP) Eingang Seite"};
  public final static String ROP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for ROP Scan"
      ,"Incorpore AWB para la exploraci�n del ROP."
      ,"�crivez AWB pour le balayage de ROP"
      ,"Tragen Sie AWB f�r ROP Scan ein"};
  public final static String ROP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //route edit
  public final static String ROUTE_EDIT_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginaci�n"
      ,"L'Itin�raire �ditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y despu�s someta"
      ,"Modifiez l'itin�raire choisi et puis soumettez"
      ,"�ndern Sie den ausgew�hlten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itin�raire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itin�raire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itin�raire"
     ,"WegDatum"};
  public final static String ROUTE_EDIT_SORT_DATE[] = {""
     ,"Sort Date"
     ,"Fecha De la Clase"
     ,"Date De Tri"
     ,"SortierungDatum"};
  public final static String ROUTE_EDIT_BROKER_COMPLETE[] = {""
     ,"Broker Complete"
     ,"Corredor Completo"
     ,"Courtier Complet"
     ,"Vermittler Komplett"};
  public final static String ROUTE_EDIT_CUSTOMS_COMPLETE[] = {""
     ,"Customs Complete"
     ,"Los Costumbres Terminan"
     ,"Les Coutumes Se terminent"
     ,"Gewohnheiten F�hren Durch"};
  public final static String ROUTE_EDIT_ROUTE_CLOSED[] = {""
     ,"Route Leg Closed"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itin�raire S'est ferm�e"
     ,"WegBein Schlo�"};
  public final static String ROUTE_EDIT_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itin�raire Non trouv�"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separaci�n"
    ,"Histoire D'Activit� De D�gagement"
    ,"Abstand Aktivit�t Geschichte  "};
   public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripci�n"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separaci�n encontr�"
    ,"Aucune activit� de d�gagement trouv�e"
    ,"Keine Abstand Aktivit�t gefunden"};
   //route edit APAC
  public final static String ROUTE_EDIT_APAC_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginaci�n"
      ,"L'Itin�raire �ditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_APAC_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y despu�s someta"
      ,"Modifiez l'itin�raire choisi et puis soumettez"
      ,"�ndern Sie den ausgew�hlten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_APAC_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itin�raire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_APAC_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itin�raire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_APAC_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itin�raire"
     ,"WegDatum"};
  public final static String ROUTE_EDIT_APAC_SORT_DATE[] = {""
     ,"Sort Date"
     ,"Fecha De la Clase"
     ,"Date De Tri"
     ,"SortierungDatum"};
  public final static String ROUTE_EDIT_APAC_BROKER_COMPLETE[] = {""
     ,"Broker Complete"
     ,"Corredor Completo"
     ,"Courtier Complet"
     ,"Vermittler Komplett"};
  public final static String ROUTE_EDIT_APAC_CUSTOMS_COMPLETE[] = {""
     ,"Customs Complete"
     ,"Los Costumbres Terminan"
     ,"Les Coutumes Se terminent"
     ,"Gewohnheiten F�hren Durch"};
  public final static String ROUTE_EDIT_APAC_ROUTE_CLOSED[] = {""
     ,"Route Leg Closed"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itin�raire S'est ferm�e"
     ,"WegBein Schlo�"};
  public final static String ROUTE_EDIT_APAC_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itin�raire Non trouv�"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separaci�n"
    ,"Histoire D'Activit� De D�gagement"
    ,"Abstand Aktivit�t Geschichte  "};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripci�n"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separaci�n encontr�"
    ,"Aucune activit� de d�gagement trouv�e"
    ,"Keine Abstand Aktivit�t gefunden"};
  public final static String ROUTE_EDIT_APAC_YES[] = { ""
    ,"Yes"
    ,"S�"
    ,"Oui"
    ,"Ja"};
  public final static String ROUTE_EDIT_APAC_NO[] = { ""
    ,"New"
    ,"Nuevo"
    ,"Nouveau"
    ,"Neu"};
  public final static String ROUTE_EDIT_APAC_COMPLETE[] = {""
    ,"Complete"
    ,"Completo"
    ,"Complet"
    ,"Komplett"};
  public final static String ROUTE_EDIT_APAC_SHUT[] = {""
    ,"Shut"
    ,"Cerrado"
    ,"Ferm�"
    ,"Geschlossen"};
  public final static String ROUTE_EDIT_APAC_DELETE[] = {""
    ,"Delete"
    ,"Cancelaci�n"
    ,"Effacement"
    ,"L�schung"};
   //route edit US
  public final static String ROUTE_EDIT_US_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginaci�n"
      ,"L'Itin�raire �ditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_US_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y despu�s someta"
      ,"Modifiez l'itin�raire choisi et puis soumettez"
      ,"�ndern Sie den ausgew�hlten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_US_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itin�raire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_US_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itin�raire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_US_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itin�raire"
     ,"WegDatum"};
  public final static String ROUTE_EDIT_US_SORT_DATE[] = {""
     ,"Sort Date"
     ,"Fecha De la Clase"
     ,"Date De Tri"
     ,"SortierungDatum"};
  public final static String ROUTE_EDIT_US_BROKER_COMPLETE[] = {""
     ,"Broker Complete"
     ,"Corredor Completo"
     ,"Courtier Complet"
     ,"Vermittler Komplett"};
  public final static String ROUTE_EDIT_US_CUSTOMS_COMPLETE[] = {""
     ,"Customs Complete"
     ,"Los Costumbres Terminan"
     ,"Les Coutumes Se terminent"
     ,"Gewohnheiten F�hren Durch"};
  public final static String ROUTE_EDIT_US_ROUTE_CLOSED[] = {""
     ,"Route Leg Status"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itin�raire S'est ferm�e"
     ,"WegBein Schlo�"};
  public final static String ROUTE_EDIT_US_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itin�raire Non trouv�"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separaci�n"
    ,"Histoire D'Activit� De D�gagement"
    ,"Abstand Aktivit�t Geschichte  "};
   public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_US_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripci�n"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separaci�n encontr�"
    ,"Aucune activit� de d�gagement trouv�e"
    ,"Keine Abstand Aktivit�t gefunden"};
  public final static String ROUTE_EDIT_US_YES[] = { ""
    ,"Scanning"
    ,"S�"
    ,"Oui"
    ,"Ja"};
  public final static String ROUTE_EDIT_US_NO[] = { ""
    ,"New"
    ,"Nuevo"
    ,"Nouveau"
    ,"Neu"};
  public final static String ROUTE_EDIT_US_COMPLETE[] = {""
    ,"Complete"
    ,"Completo"
    ,"Complet"
    ,"Komplett"};
  //route maint
  public final static String ROUTE_MAINT_INPUT_PAGE_TITLE[] = {""
      ,"Route Maintenance Page"
      ,"Paginaci�n Del Mantenimiento De la Ruta"
      ,"Page D'Entretien D'Itin�raire"
      ,"WegWartung Seite"};
  public final static String ROUTE_MAINT_INSTRUCTIONS[] ={ ""
      ,"Select a route to modify"
      ,"Seleccione encam�nelo para modificarse"
      ,"Choisissez le conduisez pour modifier"
      ,"W�hlen Sie verlegen Sie, um zu �ndern"};
  public final static String ROUTE_MAINT_SORT_DATE_SUBMIT[] = {""
     ,"Choose Sort Date"
     ,"Elija La Fecha De la Clase"
     ,"Choisissez La Date De Tri"
     ,"W�hlen Sie SortierungDatum"};
  public final static String ROUTE_MAINT_EDIT_ROUTE[] = { ""
     ,"Edit Route"
     ,"Corrija La Ruta"
     ,"�ditez L'Itin�raire"
     ,"Bearbeiten Sie Weg"};
  public final static String ROUTE_MAINT_TABLE_CHOOSE_ROUTE [] = { ""
     ,"Choose Route"
     ,"Elija La Ruta"
     ,"Choisissez L'Itin�raire"
     ,"W�hlen Sie Weg"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_NUMBER[] = { ""
     ,"Route Number"
     ,"Encamine El N�mero"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_LEG_NBR[] = {""
     ,"Route Leg Number"
     ,"Encamine El N�mero"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_TABLE_BROKER_COMPLETE[] = {""
     ,"Broker Complete"
     ,"Corredor Completo"
     ,"Courtier Complet"
     ,"Vermittler Komplett"};
  public final static String ROUTE_MAINT_TABLE_CUSTOMS_COMPLETE[] = { ""
     ,"Customs Complete"
     ,"Ruta Cerrada"
     ,"Les Coutumes Se terminent"
     ,"Gewohnheiten F�hren Durch"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_CLOSED[] = { ""
     ,"Route Status"
     ,"Los Costumbres Terminan"
     ,"Itin�raire Ferm�"
     ,"Weg Geschlossen"};
  public final static String ROUTE_MAINT_NO_ROUTES [] = { ""
     ,"No Routes for this date"
     ,"Ningunas rutas para esta fecha"
     ,"Aucun itin�raire pour cette date"
     ,"Keine Wege f�r dieses Datum"};
  public final static String ROUTE_MAINT_CURRENT_TIME[] = {""
     ,"Current Time"
     ,"Tiempo Actual"
     ,"Temps Actuel"
     ,"Aktuelle Uhrzeit"};
  public final static String ROUTE_MAINT_SORT_DATE[] = {""
     ,"Current Sort Date"
     ,"Fecha Actual De la Clase"
     ,"Date Actuelle De Tri"
     ,"Aktuelles SortierungDatum"};
  public final static String ROUTE_MAINT_VIEWING_DATE[] = {""
     ,"Viewing Sort Date"
     ,"Fecha De la Clase De la Visi�n"
     ,"Date De Tri De Visionnement"
     ,"Betrachtung SortierungDatum"};
  public final static String ROUTE_MAINT_ROUTE_DATE[] = {""
    ,"Route Date"
    ,"Fecha De la Ruta"
    ,"Date D'Itin�raire"
    ,"WegDatum"};
  public final static String ROUTE_MAINT_ORIGIN_LOC_CODE [] = {""
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"};
  public final static String ROUTE_MAINT_DEST_LOC_CODE [] = {""
    ,"Dest Loc Code"
    ,"Dest Loc Code"
    ,"Dest Loc Code"
    ,"Dest Loc Code"};
  //route maint APAC
  public final static String ROUTE_MAINT_APAC_INPUT_PAGE_TITLE[] = {""
      ,"Route Maintenance Page"
      ,"Paginaci�n Del Mantenimiento De la Ruta"
      ,"Page D'Entretien D'Itin�raire"
      ,"WegWartung Seite"};
  public final static String ROUTE_MAINT_APAC_INSTRUCTIONS[] ={ ""
      ,"Select a route to modify"
      ,"Seleccione encam�nelo para modificarse"
      ,"Choisissez le conduisez pour modifier"
      ,"W�hlen Sie verlegen Sie, um zu �ndern"};
  public final static String ROUTE_MAINT_APAC_SORT_DATE_SUBMIT[] = {""
     ,"Choose Sort Date"
     ,"Elija La Fecha De la Clase"
     ,"Choisissez La Date De Tri"
     ,"W�hlen Sie SortierungDatum"};
  public final static String ROUTE_MAINT_APAC_EDIT_ROUTE[] = { ""
     ,"Edit Route"
     ,"Corrija La Ruta"
     ,"�ditez L'Itin�raire"
     ,"Bearbeiten Sie Weg"};
  public final static String ROUTE_MAINT_APAC_TABLE_CHOOSE_ROUTE [] = { ""
     ,"Choose Route"
     ,"Elija La Ruta"
     ,"Choisissez L'Itin�raire"
     ,"W�hlen Sie Weg"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_NUMBER[] = { ""
     ,"Route Number"
     ,"Encamine El N�mero"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_LEG_NBR[] = {""
     ,"Route Leg Number"
     ,"Encamine El N�mero"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_APAC_TABLE_BROKER_COMPLETE[] = {""
     ,"Broker Complete"
     ,"Corredor Completo"
     ,"Courtier Complet"
     ,"Vermittler Komplett"};
  public final static String ROUTE_MAINT_APAC_TABLE_CUSTOMS_COMPLETE[] = { ""
     ,"Customs Complete"
     ,"Ruta Cerrada"
     ,"Les Coutumes Se terminent"
     ,"Gewohnheiten F�hren Durch"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_CLOSED[] = { ""
     ,"Route Flag"
     ,"Bandera De la Ruta"
     ,"Drapeau D'Itin�raire"
     ,"Weg-Markierungsfahne "};
  public final static String ROUTE_MAINT_APAC_NO_ROUTES [] = { ""
     ,"No Routes for this date"
     ,"Ningunas rutas para esta fecha"
     ,"Aucun itin�raire pour cette date"
     ,"Keine Wege f�r dieses Datum"};
  public final static String ROUTE_MAINT_APAC_CURRENT_TIME[] = {""
     ,"Current Time"
     ,"Tiempo Actual"
     ,"Temps Actuel"
     ,"Aktuelle Uhrzeit"};
  public final static String ROUTE_MAINT_APAC_SORT_DATE[] = {""
     ,"Current Sort Date"
     ,"Fecha Actual De la Clase"
     ,"Date Actuelle De Tri"
     ,"Aktuelles SortierungDatum"};
  public final static String ROUTE_MAINT_APAC_VIEWING_DATE[] = {""
     ,"Viewing Sort Date"
     ,"Fecha De la Clase De la Visi�n"
     ,"Date De Tri De Visionnement"
     ,"Betrachtung SortierungDatum"};
  public final static String ROUTE_MAINT_APAC_ROUTE_DATE[] = {""
    ,"Route Date"
    ,"Fecha De la Ruta"
    ,"Date D'Itin�raire"
    ,"WegDatum"};
  public final static String ROUTE_MAINT_APAC_ORIGIN_LOC_CODE [] = {""
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"
    ,"Orgn Loc Code"};
  public final static String ROUTE_MAINT_APAC_DEST_LOC_CODE [] = {""
    ,"Dest Loc Code"
    ,"Dest Loc Code"
    ,"Dest Loc Code"
    ,"Dest Loc Code"};
  //ServerUnavailable
  public final static String SERVER_UNAVAILABLE_TITLE[] = {""
    ,"Server Unavailable"
    ,"Servidor Inasequible"
    ,"Server Unavailable"
    ,"Server Nicht erreichbar"};
  public final static String SERVER_UNAVAILABLE_TEXT[] = {""
    ,"Contact Lan support or operations to assist you"
    ,"Ayuda u operaciones del Lan del contacto para asistirle"
    ,"Contact Lan support or operations to assist you"
    ,"Kontaktlan-Support oder -operationen zum Unterst�tzen Sie"};
  //shipment remarks
  public final static String SHIP_REMARK_INPUT_PAGE_TITLE[] =
     {"","Shipment Remark Input Page"
      ,"Paginaci�n De la Entrada de informaci�n De la Observaci�n Del Env�o"
      ,"Page D'Entr�e De Remarque D'Exp�dition"
      ,"VersandAnmerkung-InputSeite"};
  public final static String SHIP_REMARK_CODE_INSTRUCTIONS[] =
     {"","Select a Shipment Remark to apply"
      ,"Seleccione una observaci�n del env�o para aplicarse"
      ,"Choisissez une remarque d'exp�dition pour s'appliquer"
      ,"W�hlen Sie eine Versandanmerkung aus, um zuzutreffen"};
  public final static String SHIP_REMARK_TEXT_INSTRUCTIONS[] =
     {"","or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"};
  public final static String SHIP_REMARK_AWB_INSTURCTIONS[] =
     {"","Enter the Tracking Number to apply Shipment Remark"
      ,"Incorpore el n�mero de N�mero El Seguir para aplicar la observaci�n del env�o"
      ,"�crivez le Nombre De Cheminement pour appliquer la remarque d'exp�dition"
      ,"Tragen Sie die GleichlaufZahl-Zahl ein, um Versandanmerkung anzuwenden"};
  //STAGE AREA ID label
  public final static String STAGEAREAID_TITLE[] = { ""
    ,"Stage Area ID Label"
    ,"Etiqueta de la Identificaci�n Del �rea De la Etapa"
    ,"�tiquette d'Identification De R�gion D'�tape"
    ,"Stadium Bereich Identifikation Aufkleber"};
  public final static String STAGEAREAID_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String STAGEAREAID_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEAREAID_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String STAGEAREAID_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String STAGEAREAID_EXCPETION_ALL_STAGE_AREAS [] = {""
    ,"All stage areas"
    ,"Todas las �reas de la etapa"
    ,"Tous les secteurs d'�tape"
    ,"Alle Stadium Bereiche"};
  //corporate SIP Scan
    public final static String SIP_INPUT_PAGE_TITLE[] = {""
      ,"Station In (SIP) Input Page"
      ,"Estaci�n en p�gina de la entrada del (SIP)"
      ,"Station en page d'entr�e de (SIP)"
      ,"Station in der (SIP) Eingang Seite"};
  public final static String SIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for SIP Scan"
      ,"Incorpore AWB para la exploraci�n del SIP."
      ,"�crivez AWB pour le balayage de SIP"
      ,"Tragen Sie AWB f�r SIP Scan ein"};
  public final static String SIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate SOP Scan
   public final static String SOP_INPUT_PAGE_TITLE[] = {""
      ,"Station Out (SOP) Input Page"
      ,"Estaci�n fuera de la p�gina de la entrada del (SOP)"
      ,"Station hors de page d'entr�e de (SOP)"
      ,"Station aus (SOP) Eingang Seite"};
  public final static String SOP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for SOP Scan"
      ,"Incorpore AWB para la exploraci�n del SOP."
      ,"�crivez AWB pour le balayage de SOP"
      ,"Tragen Sie AWB f�r SOP Scan ein"};
  public final static String SOP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //stage area pick list
  public final static String STAGE_AREA_PICK_INPUT_PAGE_TITLE[] = { ""
      ,"Stage Area Pick List"
      ,"Lista De la Selecci�n Del �rea De la Etapa"
      ,"Liste De S�lection De R�gion D'�tape"
      ,"Stadium Bereich AuswahlListe"};
  public final static String STAGE_AREA_PICK_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"List of tracking numbers that have satisfied intercepts but are still in staging area.  Select checkbox next to tracking number to print pick list labels."
      ,"La lista de los n�meros que siguen que han satisfecho interceptaciones pero todav�a est� en �rea del estacionamiento. Checkbox selecto al lado del n�mero que sigue para imprimir escrituras de la etiqueta de la lista de la selecci�n. "
      ,"La liste de nombres de cheminement qui ont satisfait des interceptions mais sont toujours dans la zone d'�chafaudage. Checkbox choisi � c�t� du nombre de cheminement pour imprimer des �tiquettes de liste de s�lection. "
      ,"Liste der aufsp�renzahlen, die Abschnitte aber erf�llt, noch im Inszenierungbereich sind haben. Auserw�hltes checkbox nahe bei der aufsp�renzahl zum Drucken der Auswahlliste Kenns�tze."};
  public final static String STAGE_AREA_PICK_SUBMIT[] = { ""
      ,"Submit selected"
      ,"Som�tase escogido"
      ,"Soumettre choisi"
      ,"Reichen Sie ausgew�hlt ein"};
  public final static String STAGE_AREA_PICK_SUBMIT_ALL[] = { ""
      ,"Submit All"
      ,"Som�tase Todo"
      ,"Soumettre Tout"
      ,"Reichen Sie Alle ein"};
  public final static String STAGE_AREA_PICK_SUBMIT_EMPTY[] = { ""
      ,"Choose a different Staging Area"
      ,"Escoja una Area diferente que Prepara"
      ,"Choisir un Domaine diff�rent qui monte"
      ,"W�hlen Sie Ein Verschiedenes Inszenierendes Gebiet"};
  public final static String STAGE_AREA_PICK_NO_DATA[] = {""
      ,"No Data to Display"
      ,"Ningunos datos a visualizar"
      ,"Aucunes donn�es � afficher"
      ,"Keine anzuzeigenden Daten"};
  public final static String STAGE_AREA_PICK_STAGE_AREA[]=STAGING_AREA;
  public final static String STAGE_AREA_PICK_CHOOSE [] = {""
      ,"Choose"
      ,"Elija"
      ,"Choisissez"
      ,"W�hlen Sie"};
  public final static String STAGE_AREA_PICK_TRACKING_NBR [] = {""
      ,"Tracking Number"
      ,"Seguir N�mero"
      ,"Cheminement Du Nombre"
      ,"Gleichlauf Von Zahl"};
  public final static String STAGE_AREA_PICK_DETAINMENT_LOC [] = {""
      ,"Detainment Loc"
      ,"Localizaci�n De la Detenci�n"
      ,"Emplacement De D�tention"
      ,"Zur�ckbehaltungStandort"};
  public final static String STAGE_AREA_PICK_NO_PACKAGE [] = {""
      ,"No Packages to display"
      ,"Ningunos conjuntos a visualizar"
      ,"Aucuns modules � afficher"
      ,"Keine anzuzeigenden Pakete"};
  public final static String STAGE_AREA_PICK_STATUS [] = GENERIC_STATUS_STATUS_OR_LOCATION;
  //stage in
  public final static String STAGEIN_INPUT_PAGE_TITLE[] = { ""
      ,"Stage In Input Page"
      ,"Etapa En La Paginaci�n De la Entrada de informaci�n"
      ,"�tape En Page D'Entr�e"
      ,"Stadium In der InputSeite"};
  public final static String STAGEIN_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage In"
      ,"Seleccione el �rea correcta de la etapa y despu�s incorpore unos o m�s N�mero El Seguir para la etapa adentro"
      ,"Choisissez la r�gion correcte d'�tape et puis �crivez un ou plusieurs Nombre De Cheminement pour l'�tape dedans"
      ,"W�hlen Sie den korrekten Stadium Bereich aus und geben Sie dann ein oder mehr GleichlaufZahl f�r Stadium innen ein"};
  public final static String STAGEIN_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEIN_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEIN_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Detainment location"
      ,"Localizaci�n de la detenci�n"
      ,"Emplacement de d�tention"
      ,"Zur�ckbehaltungstandort"};
  //stage out
  public final static String STAGEOUT_INPUT_PAGE_TITLE[] = {""
      ,"Stage Out Input Page"
      ,"Etapa Fuera De la Paginaci�n De la Entrada de informaci�n"
      ,"�tape Hors De Page D'Entr�e"
      ,"Stadium Aus InputSeite"};
  public final static String STAGEOUT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage Out"
       + "<p>" + "Printer: "
      ,"Seleccione el �rea correcta de la etapa y despu�s incorpore unos o m�s N�mero El Seguir para la etapa hacia fuera"
       + "<p>" + "Impresora: "
      ,"Choisissez la r�gion correcte d'�tape et puis �crivez un ou plusieurs Nombre De Cheminement pour l'�tape dehors"
       + "<p>" + "Imprimante: "
      ,"W�hlen Sie den korrekten Stadium Bereich aus und geben Sie dann ein oder mehr GleichlaufZahl f�r Stadium heraus ein"
       + "<p>" + "Drucker: "};
  public final static String STAGEOUT_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEOUT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEOUT_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //stage out STRIP
  public final static String STAGEOUTSTRIP_INPUT_PAGE_TITLE[] = {""
      ,"Stage Out Strip Input Page"
      ,"Etapa Fuera De la Paginaci�n De la Entrada de informaci�n De la Tira"
      ,"�tape Hors De Page D'Entr�e De Bande"
      ,"Stadium Aus StreifenInputSeite"};
  public final static String STAGEOUTSTRIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage Out Strip"
       + "<p>" + "Printer: "
      ,"Seleccione el �rea correcta de la etapa y despu�s entre en uno o m�s que sigue el n�mero para la etapa fuera de la tira"
       + "<p>" + "Impresora: "
      ,"Choisissez la r�gion correcte d'�tape et puis entrez dans un ou plusieurs qui d�piste le nombre pour l'�tape hors de la bande"
       + "<p>" + "Imprimante: "
      ,"W�hlen Sie den korrekten Stadium Bereich aus und betreten Sie dann eins oder mehr, die aufsp�ren Zahl f�r Stadium aus Streifen"
       + "<p>" + "Drucker: "};
  public final static String STAGEOUTSTRIP_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEOUTSTRIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEOUTSTRIP_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
    // corporate STAT Scan
  public final static String STAT_INPUT_PAGE_TITLE[] = {""
      ,"Status (STAT) Input Page"
      ,"P�gina de la entrada del (STAT) del estado"
      ,"Page d'entr�e de (STAT) de statut"
      ,"Status (STAT) Eingang Seite"};
  public final static String STAT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT"
      ,"Incorpore AWB para agregar el STAT"
      ,"�crivez AWB pour ajouter le STAT"
      ,"Tragen Sie AWB ein, um STAT zu addieren"};
  public final static String STAT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Comments or Reason"
      ,"Comentarios o raz�n"
      ,"Commentaires ou raison"
      ,"Anmerkungen oder Grund"};
    /*public final static String STAT_SUBMIT2_PROMPT[] = { ""
    ,"Choose different printer"
    ,"Elija diversa impresora"
    ,"Choisissez diff�rente l'imprimante"
    ,"W�hlen Sie unterschiedlichen Drucker "};*/
  /*public final static String STAT_ADDITIONAL_INFO[] = { ""
      ,"Additional Information *"
      ,"Informaci�n Adicional *"
      ,"L'Information Additionnelle *"
      ,"Zus�tzliche Informationen *"};
  public final static String STAT_ADDITIONAL_INFO_EXPLAIN[] = { ""
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "};
      */
      // corporate STAT37 Scan
  public final static String STAT37_INPUT_PAGE_TITLE[] = {""
      ,"Status 37 (STAT 37) Input Page"
      ,"P�gina de la entrada del (STAT 37) del estado"
      ,"Page d'entr�e de (STAT 37) de statut"
      ,"Status (STAT 37) Eingang Seite"};
  public final static String STAT37_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 37"
      ,"Incorpore AWB para agregar el STAT 37"
      ,"�crivez AWB pour ajouter le STAT 37"
      ,"Tragen Sie AWB ein, um STAT 37 zu addieren"};
  public final static String STAT37_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT37_CODE_INSTRUCTIONS[] = { ""
      ,"Package Condition"
      ,"Condici�n Del Paquete"
      ,"�tat De Paquet"
      ,"Paket-Zustand"};
  public final static String STAT37_CODE_A[] = { ""
      ,"Crushed"
      ,"Machacado"
      ,"�cras�"
      ,"Zerquetscht"};
  public final static String STAT37_CODE_B[] = { ""
      ,"Wet"
      ,"Mojado"
      ,"Humide"
      ,"Na�"};
  public final static String STAT37_CODE_C[] = { ""
      ,"Torn"
      ,"Rasgado"
      ,"D�chir�"
      ,"Heftig gezerrissen"};
  public final static String STAT37_CODE_D[] = { ""
      ,"Rewrap"
      ,"Rewrap"
      ,"Rewrap"
      ,"Rewrap"};
  public final static String STAT37_CODE_E[] = { ""
      ,"Retape"
      ,"Retape"
      ,"Retape"
      ,"Retape"};
  public final static String STAT6877_INPUT_PAGE_TITLE[] = {""
      ,"Status 68 or 77 (STAT 68 or 77) Input Page"
      ,"P�gina de la entrada del (STAT 68 or 77) del estado"
      ,"Page d'entr�e de (STAT 68 or 77) de statut"
      ,"Status (STAT 68 or 77) Eingang Seite"};
  public final static String STAT6877_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 68 or 77"
      ,"Incorpore AWB para agregar el STAT 68 or 77"
      ,"�crivez AWB pour ajouter le STAT 68 or 77"
      ,"Tragen Sie AWB ein, um STAT 68 or 77 zu addieren"};
  public final static String STAT6877_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT6877_SINGLE_LINE_INSTURCTIONS1[] = { ""
      ,"Routing (STAT 68) or MDERouting (STAT 77)"
      ,"Routing (STAT 68) or MDERouting (STAT 77)"
      ,"Routing (STAT 68) or MDERouting (STAT 77)"
      ,"Routing (STAT 68) or MDERouting (STAT 77)"};
  public final static String STAT6877_SINGLE_LINE_INSTURCTIONS2[] = { ""
      ,"Comments"
      ,"Comentarios"
      ,"Commentaires"
      ,"Anmerkungen"};
  // corporate STAT69 Scan
  public final static String STAT69_INPUT_PAGE_TITLE[] = {""
      ,"Status 69 (STAT 69) Input Page"
      ,"P�gina de la entrada del (STAT 69) del estado"
      ,"Page d'entr�e de (STAT 69) de statut"
      ,"Status (STAT 69) Eingang Seite"};
  public final static String STAT69_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 69"
      ,"Incorpore AWB para agregar el STAT 69"
      ,"�crivez AWB pour ajouter le STAT 69"
      ,"Tragen Sie AWB ein, um STAT 69 zu addieren"};
  public final static String STAT69_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT69_SINGLE_LINE_INSTURCTIONS1[] = { ""
      ,"Astray"
      ,"Astray"
      ,"Astray"
      ,"Astray"};
  public final static String STAT69_SINGLE_LINE_INSTURCTIONS2[] = { ""
      ,"Comments"
      ,"Comentarios"
      ,"Commentaires"
      ,"Anmerkungen"};
  // corporate STAT8590 Scan
  public final static String STAT8590_INPUT_PAGE_TITLE[] = {""
      ,"Status 85 & 90 (STAT 85 & 90) Input Page"
      ,"P�gina de la entrada del (STAT 85 & 90) del estado"
      ,"Page d'entr�e de (STAT 85 & 90) de statut"
      ,"Status (STAT 85 & 90) Eingang Seite"};
  public final static String STAT8590_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 85 or 90"
      ,"Incorpore AWB para agregar el STAT 85 or 90"
      ,"�crivez AWB pour ajouter le STAT 85 or 90"
      ,"Tragen Sie AWB ein, um STAT 85 or 90 zu addieren"};
  public final static String STAT8590_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT8590_SINGLE_LINE_INSTURCTIONS1[] = { ""
      ,"Flight Number"
      ,"N�mero De Vuelo"
      ,"Num�ro De Vol"
      ,"Flugnummer"};
   public final static String STAT8590_SINGLE_LINE_INSTURCTIONS2[] = { ""
      ,"Flight Date"
      ,"Fecha Del Vuelo"
      ,"Date De Vol"
      ,"Flug-Datum"};
  public final static String STAT8590_SINGLE_LINE_INSTURCTIONS3[] = { ""
      ,"Comments"
      ,"Comentarios"
      ,"Commentaires"
      ,"Anmerkungen"};
  //top menu
  public final static String TOP_MENU_TITLE[] = { ""
    ,"CCII Menu"
    ,"Ccii Men�"
    ,"Ccii Menu"
    ,"Ccii Men�"};
  public final static String TOP_MENU_SITE_LOC[] = { ""
    ,"Site"
    ,"Sitio"
    ,"Emplacement"
    ,"Aufstellungsort"};
  public final static String TOP_MENU_INVENTORY[]= {""
    ,"Inventory Screens"
    ,"Inventario"
    ,"Inventaire"
    ,"Warenbestand"};
  public final static String TOP_MENU_INTERCEPT[] = {""
    ,"Intercept Screens"
    ,"Intercepci�n"
    ,"Interception"
    ,"Abschnitt"};
  public final static String TOP_MENU_CORP_SCANS[] = {""
    ,"Corporate Scans"
    ,"Balayages De corporation"
    ,"Exploraciones Corporativas"
    ,"Korporative Scans"};
  public final static String TOP_MENU_PRINTER_OPTS[] = {""
    ,"Printer Options"
    ,"Options D'Imprimeur"
    ,"Opciones De la Impresora"
    ,"Drucker-Wahlen"};
  public final static String TOP_MENU_REPORTS[] = {""
    ,"Reports"
    ,"Informes"
    ,"�tats"
    ,"Reports"};
  public final static String TOP_MENU_SECURITY_ADMIN[] = {""
    ,"Security Admin"
    ,"Seguridad Admin"
    ,"S�curit� Admin"
    ,"Sicherheit Admin"};
  public final static String TOP_MENU_LOGOFF[] = {""
    ,"Logoff"
    ,"T�rmino de sesi�n"
    ,"Fermeture de session"
    ,"Logoff"};
//Warehouse ID label
  public final static String WAREHOUSEID_TITLE[] = { ""
    ,"Warehouse ID Label"
    ,"Etiqueta de la Identificaci�n Del Almac�n "
    ,"�tiquette d'Identification D'Entrep�t"
    ,"Aufkleber Des Lager-Identifikation"};
  public final static String WAREHOUSEID_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String WAREHOUSEID_CODE_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String WAREHOUSEID_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String WAREHOUSEID_EXCEPTION_ALL_WAREHOUSES[] = {""
    ,"All warehouses"
    ,"Todos los almacenes"
    ,"Tous les entrep�ts"
    ,"Alle Lager"};

  public CCIILanguages()
  {
  }
}
