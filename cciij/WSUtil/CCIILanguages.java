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
      ,"Instrucciones Genéricas De la Paginación"
      ,"Instructions Génériques De Page"
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
    ,"Remettez à l'état initial La Forme"
    ,"Setzen Sie Formular Zurück"};
  public final static String OPTIONAL_PROMPT[] = { ""
    ,"(Optional)"
    ,"(opcional)"
    ,"(facultatif)"
    ,"(wahlweise freigestellt)"};
  public final static String TRACKING_NUMBER[] = { ""
    ,"Tracking Number"
    ,"Número El Seguir"
    ,"Nombre De Cheminement"
    ,"GleichlaufZahl"};
  public final static String GENERIC_CONS_PROMPT[] = {""
    ,"CONS"
    ,"CONS"
    ,"CONS"
    ,"CONS"};
  public final static String STAGING_AREA[] = { ""
    ,"Staging Area"
    ,"Área Del Estacionamiento"
    ,"Région D'Échafaudage"
    ,"InszenierungBereich"};
  public final static String CHOOSE_DIFFERENT_PRINTER[] = { ""
    ,"Choose different printer"
    ,"Elija diversa impresora"
    ,"Choisissez différente l'imprimante"
    ,"Wählen Sie unterschiedlichen Drucker "};
  public final static String WAREHOUSE_CODE [] = {""
    ,"Warehouse Code"
    ,"Código Del Almacén"
    ,"Code D'Entrepôt"
    ,"Lager-Code"};
  public final static String PRINTER_PROMPT [] = { ""
    ,"Printer: "
    ,"Impresora: "
    ,"Imprimante: "
    ,"Drucker: "};
  public final static String LABEL_SUCCESS [] = { ""
    ,"label succeded"
    ,"etiqueta tenida éxito"
    ,"étiquette réussie"
    ,"Aufkleber folgte"};
  public final static String LABEL_FAILED[] = {""
    ,"label failed"
    ,"la etiqueta falló"
    ,"l'étiquette a échoué"
    ,"Aufkleber fiel aus"};
  public final static String NO_VALUE[] = {""
    ,"No Value Choosen"
    ,"Ningún Valor Elegido"
    ,"Aucune Valeur Choisie"
    ,"Kein Wert Gewählt"};
    //End of genericStuff

  //Associate CRN
  public final static String ASSOCIATE_CRN_TITLE[] = { ""
    ,"Associate CRN to Master"
    ,"Asociado CRN al amo"
    ,"Associé CRN au maître"
    ,"Teilnehmer CRN zum Meister"};
  public final static String ASSOCIATE_CRN_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter CRN and Master AWB to associate"
    ,"Incorpore CRN y AWB principal para asociarse"
    ,"Écrivez CRN et AWB principal pour s'associer"
    ,"Tragen Sie CRN und Vorlagen-cAwb ein, um zu verbinden"};
  public final static String ASSOCIATE_CRN_AWB_INSTRUCTIONS[] = { ""
    ,"CRN"
    ,"CRN"
    ,"CRN"
    ,"CRN"};
  public final static String ASSOCIATE_CRN_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Master AWB"
    ,"Domine Awb"
    ,"Maîtrisez Awb"
    ,"Erarbeiten Sie Awb"};
  //autologout
  public final static String AUTOLOGOUT_TITLE[] = { ""
    ,"Auto Logout"
    ,"Registro de estado de la máquina Auto"
    ,"Sortie du système Automatique. "
    ,"SelbstcLogout"};
  public final static String AUTOLOGOUT_PAGE_TEXT[] = { ""
    ,"Your session has timed out and you have been logged off the system.  "
    +"Please select if you want to return to the "
    ,"Su sesión ha medido el tiempo hacia fuera y le han salido el sistema.  "
    +"Seleccione por favor si usted desea volver a "
    ,"Votre session a chronométré dehors et vous avez été sortis le système.  "
    +"Choisissez svp si vous voulez retourner au "
    ,"Ihr Lernabschnitt hat heraus Zeit festgesetzt und Sie sind weg vom System geloggt worden.  "
    +"Wählen Sie bitte vor, wenn Sie zu zurückkommen möchten "};
  public final static String AUTOLOGOUT_OR_TEXT[] = { ""
    ,"or"
    ,"o"
    ,"ou"
    ,"oder"};
  public final static String AUTOLOGOUT_LOGIN[] = { ""
    ,"CCII Login Screen"
    ,"CCII Pantalla De la Conexión"
    ,"CCII Écran D'Ouverture"
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
    ,"Dañado"
    ,"Endommagé"
    ,"Beschädigt"};
  public final static String BONDIN_WRONG_FLIGHT[] = {""
    ,"Wrong Flight"
    ,"Vuelo Incorrecto"
    ,"Vol Faux"
    ,"Falscher Flug"};
  public final static String BONDIN_FLIGHT_DELAY[] = {""
    ,"Flight Delay"
    ,"El Vuelo Retrasa"
    ,"Le Vol Retarde"
    ,"Flug Verzögert"};

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
    ,"fourgon manqué"
    ,"Vermissen"};

    //Cage Scan
  public final static String CAGE_TITLE[] = { ""
    ,"Cage Scan"
    ,"Exploración de la Jaula"
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
     ,"Changez Le Mot de passe Réussi"
     ,"Ändern Sie Das Erfolgreiche Kennwort"};
  public final static String CHANGE_PASSWORD_SUCCESS_PREFIX_TEXT[] = {""
    ,"If this page does not automatically forward "
    ,"Si esta paginación automáticamente no remite "
    ,"Si cette page automatiquement n'expédie pas "
    ,"Wenn diese Seite nicht automatisch nachschickt "};
  public final static String CHANGE_PASSWORD_SUCCESS_TEXT[]= {""
     ,"Click here to continue</a>"
     ,"Haga clic aquí para continuar</a>"
     ,"Cliquetez ici pour continuer</a>"
     ,"Klicken Sie hier, um fortzufahren</a>"};
  //Choose Application Settings
  public final static String CHOOSE_APP_TITLE[]={""
     ,"Choose Application"
     ,"Elija La Aplicación"
     ,"Choisissez L'Application"
     ,"Wählen Sie Anwendung"};
  public final static String CHOOSE_APP_TEXT[]= {""
     ,"Choose Application to use from menu above"
     ,"Elija la aplicación para utilizar de menú sobre"
     ,"Choisissez l'application pour utiliser du menu au-dessus de "
     ,"Beschließen Sie Anwendung, um vom Menü zu verwenden über "};
  //choose Printer JSP Bean
  public final static String CHOOSE_PRINTER_TITLE[] = { ""
    ,"Choose Printer"
    ,"Elija La Impresora"
    ,"Choisissez L'Imprimante"
    ,"Wählen Sie Drucker"};
  public final static String CHOOSE_PRINTER_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a printer for labels"
    ,"Elija una impresora para las escrituras de la etiqueta"
    ,"Choisissez une imprimante pour des étiquettes"
    ,"Wählen Sie einen Drucker für Kennsätze"};
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
    ,"Wählen Sie SortierungDatum"};
  public final static String CHOOSE_SORT_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a Sort Date to work with"
    ,"Elija una fecha de la clase para trabajar con"
    ,"Choisissez une date de tri pour travailler avec"
    ,"Beschließen Sie ein Sortierungdatum, um mit zu arbeiten"};
  public final static String CHOOSE_SORT_CODE_INSTRUCTIONS[] = { ""
    ,"Sort Dates"
    ,"Clasifique Las Fechas"
    ,"Triez Les Dates"
    ,"Sortieren Sie Daten"};
  //Choose Specific Function Settings
  public final static String CHOOSE_SPECIFC_TITLE[] = {""
     ,"Choose Specific functionality"
     ,"Elija las funciones específicas"
     ,"Choisissez la fonctionnalité spécifique"
     ,"Wählen Sie spezifische Funktionalität"};
  public final static String CHOOSE_SPECIFIC_TEXT[] = {""
     ,"Choose specific functionality from menu on left"
     ,"Elija las funciones específicas del menú en izquierda"
     ,"Choisissez la fonctionnalité spécifique du menu sur la gauche"
     ,"Wählen Sie spezifische Funktionalität vom Menü auf links"};
  //choose Stage Area JSP Bean
  public final static String CHOOSE_STAGE_AREA_TITLE[] = { ""
    ,"Choose a Stage area"
    ,"Elija un área de la etapa"
    ,"Choisissez une région d'étape"
    ,"Wählen Sie einen Stadiumsbereich"};
  public final static String CHOOSE_STAGE_AREA_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose a Stage area"
    ,"Elija un área de la etapa"
    ,"Choisissez une région d'étape"
    ,"Wählen Sie einen Stadiumsbereich"};
  public final static String CHOOSE_STAGE_AREA_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String CHOOSE_STAGE_AREA_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  //corporate CMT Scan
  public final static String CMT_INPUT_PAGE_TITLE[] = {""
      ,"Comment (CMT) Input Page"
      ,"Página Entrada Del Comentario (CMT)"
      ,"Page Entrée Du Commentaire (CMT)"
      ,"Anmerkung (CMT) Eingegebene Seite "};
  public final static String CMT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for CMT Scan"
      ,"Incorpore AWB para la exploración del CMT."
      ,"Écrivez AWB pour le balayage de CMT"
      ,"Tragen Sie AWB für CMT Scan ein"};
  public final static String CMT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String CMT_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Comments"
      ,"Comentarios"
      ,"Commentaires"
      ,"Anmerkungen"};
  // corporate CONS Scan
  public final static String CONS_INPUT_PAGE_TITLE[] = {""
      ,"Consolidated Shipment (CONS) Input Page"
      ,"Página consolidada de la entrada del envío (CONS)"
      ,"Page consolidée d'entrée de l'expédition (CONS)"
      ,"Vereinigte Eingang Seite des Versand-(CONS)"};
  public final static String CONS_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add to CONS"
      ,"Incorpore AWB para agregar a CONS"
      ,"Écrivez AWB pour s'ajouter à CONS"
      ,"Tragen Sie AWB ein, um CONS hinzuzufügen"};
  public final static String CONS_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String CONS_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"CONS Number"
      ,"número de CONS"
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
      ,"Página consolidada de la entrada del envío (DCON)"
      ,"Page consolidée d'entrée de l'expédition (DCON)"
      ,"Vereinigte Eingang Seite des Versand-(DCON)"};
  public final static String DCON_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add to DCON"
      ,"Incorpore AWB para agregar a DCON"
      ,"Écrivez AWB pour s'ajouter à DCON"
      ,"Tragen Sie AWB ein, um DCON hinzuzufügen"};
  public final static String DCON_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String DCON_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"DCON Number"
      ,"número de DCON"
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
    ,"Muestre La Pantalla De la Localización De la Detención"
    ,"Montrez L'Écran D'Emplacement De Détention"
    ,"Zeigen Sie ZurückbehaltungStandortBildschirm"};
  public final static String DETAIN_LOC_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find detainment location"
    ,"Incorpore Número El Seguir para encontrar la localización de la detención"
    ,"Écrivez Nombre De Cheminement pour trouver l'emplacement de détention"
    ,"Tragen Sie GleichlaufZahl ein, um Zurückbehaltungstandort zu finden"};
  public final static String DETAIN_LOC_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;

  //DetainmentLocaLabel
  public final static String DETAINMENT_LOC_LABEL_TITLE[] = {""
    ,"Detainment Location Label"
    ,"Etiqueta De la Localización De la Detención"
    ,"Étiquette D'Endroit De Détention"
    ,"Zurückbehaltung-Position Aufkleber"};
  public final static String DETAINMENT_LOC_LABEL_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String DETAINMENT_LOC_LABEL_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String DETAINMENT_LOC_LABEL_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String DETAINMENT_LOC_LABEL_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String DETAINMENT_LOC_LABEL_SINGLELINE_INSTRUCTIONS[] = {""
    ,"Detainment Location"
    ,"Descripción De la Localización De la Detención"
    ,"Endroit De Détention"
    ,"Zurückbehaltung-Position"};

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
    ,"Localización De la Detención "
    ,"Formats D'Imprimeur De Téléchargement"
    ,"Download-Drucker-Formate"};
  public final static String DOWNLOAD_FORMATS_INSTRUCTIONS[]={""
    ,"Choose Printer Name to Download Formats "
    ,"Elija el nombre de la impresora para descargar formatos "
    ,"Choisissez le nom d'imprimeur pour télécharger des formats "
    ,"Beschließen Sie Druckernamen, um Formate zu downloaden "};
  public final static String DOWNLOAD_FORMATS_CODE_INSTRUCTIONS[]={""
     ,"Printer ID"
    ,"Identificación De la Impresora"
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
    ,"Formez les zones non complètes"
    ,"Bilden Sie die kompletten Felder nicht"};
  public final static String EMPTY_INPUT_TEXT[] = { ""
    ,"Not Enough information was filled in to process this screen.  \n<br>"
    + "Use your browser's back button to go back and complete the form and resubmit."
    ,"No bastante información fue completada para procesar esta pantalla.  \n<br>"
    +"Utilice el botón posterior de su browser para ir detrás y para llenar el formulario y para resometerlo."
    ,"Pas assez d'information a été complétée pour traiter cet écran.  \n<br>"
    +"Utilisez le bouton arrière de votre browser's pour retourner et pour remplir le formulaire et pour se resoumettre."
    ,"Nicht genügende Informationen wurden ausgefüllt, um diesen Bildschirm zu verarbeiten.  \n<br>"
    +"Benutzen Sie rückseitige Taste Ihrer Datenbanksuchroutine, um zurück zu gehen und das Formular auszufüllen und wieder zu unterwerfen."};
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
     ,"Manipulación De la Paginación De la Entrada de información De la Instrucción"
     ,"Manipulation De la Page D'Entrée D'Instruction"
     ,"Behandlung Der Anweisung InputSeite"};
  public final static String HI_CODE_INSTRUCTIONS[] =
     {"","Select a Handling Instruction to apply"
      ,"Seleccione una instrucción de dirección de aplicarse"
      ,"Choisissez une instruction de manipulation de s'appliquer"
      ,"Wählen Sie eine anfassenanweisung aus zuzutreffen"};
  public final static String HI_TEXT_INSTRUCTIONS[] =
     {"","or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"};
  public final static String HI_AWB_INSTURCTIONS[] =
     {"","Enter the Tracking Number to apply Handling Instruction"
      ,"Incorpore de Número El Seguir para aplicar la manipulación de la instrucción"
      ,"Écrivez d'cNombre De Cheminement pour appliquer manipuler l'instruction"
      ,"Tragen Sie die GleichlaufZahl-Zahl ein, um die Behandlung von Anweisung anzuwenden"};
  // Corporate HIP scan
  public final static String HIP_INPUT_PAGE_TITLE[] = {""
      ,"Hub In (HIP) Input Page"
      ,"Cubo en página de la entrada del (HIP)"
      ,"Moyeu en page d'entrée de (HIP)"
      ,"Nabe in der (HIP) Eingang Seite"};
  public final static String HIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for HIP Scan"
      ,"Incorpore AWB para la exploración del HIP."
      ,"Écrivez AWB pour le balayage de HIP"
      ,"Tragen Sie AWB für HIP Scan ein"};
  public final static String HIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate HOP Scan
   public final static String HOP_INPUT_PAGE_TITLE[] = {""
      ,"Hub Out (HOP) Input Page"
      ," Cubo fuera de la página de la entrada del (HOP)"
      ,"Moyeu hors de page d'entrée de (HOP)"
      ,"Nabe aus (HOP) Eingang Seite"};
  public final static String HOP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for HOP Scan"
      ,"Incorpore AWB para la exploración del HOP"
      ,"Écrivez AWB pour le balayage de HOP"
      ,"Tragen Sie AWB für HOP Scan ein"};
  public final static String HOP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //left menu intercept
  public final static String INTER_MENU_TITLE[]={""
     ,"Intercept Menu"
     ,"Menú De la Interceptación"
     ,"Menu D'Interception"
     ,"AbschnittMenü"};
  public final static String INTER_MENU_SCANS[] = {""
      ,"Scans"
      ,"Exploraciones"
      ,"Balayages"
      ,"Scans"};
  public final static String INTER_MENU_PACKAGE_ARRIVAL[] = {""
      ,"Package Arrival"
      ,"Llegada Del Conjunto"
      ,"Arrivée De Module"
      ,"PaketAnkunft"};
  public final static String INTER_MENU_STAGE_IN[] = {""
      ,"Stage In"
      ,"Etapa Adentro"
      ,"Étape Dedans"
      ,"Stadium Innen"};
  public final static String INTER_MENU_STAGE_OUT[] = {""
      ,"Stage Out"
      ,"Etapa Hacia fuera"
      ,"Étape Dehors"
      ,"Stadium Heraus"};
   public final static String INTER_MENU_STAGE_OUT_STRIP[] = {""
      ,"Stage Out Strip"
      ,"Etapa Fuera De la Tira"
      ,"Étape Hors De Bande"
      ,"Stadium Aus Streifen"};
  public final static String INTER_MENU_LEAVE_FACILITY[] = {""
      ,"Package Departure"
      ,"Salida Del Conjunto"
      ,"Départ De Module"
      ,"PaketAbfahrt"};
  public final static String INTER_MENU_STATUS[] = { ""
    ,"Status"
    ,"Estatus"
    ,"Mode"
    ,"Status"};
  public final static String INTER_MENU_STAGE_PICKLIST[] = { ""
    ,"Stage Pick List"
    ,"Lista De la Selección De la Etapa"
    ,"Liste De Sélection D'Étape"
    ,"Stadium AuswahlListe"};
  public final static String INTER_MENU_STAGE_STATUS[] = { ""
    ,"Package Status"
    ,"Estatus Del Conjunto"
    ,"Mode De Module"
    ,"PaketStatus"};
  public final static String INTER_MENU_LOCATION_HISTORY[] = { ""
    ,"Location & History"
    ,"Localización Y Historia"
    ,"Emplacement Et Histoire"
    ,"Standort U. Geschichte"};
  public final static String INTER_MENU_OTHER[] = { ""
    ,"Other"
    ,"Otro"
    ,"Autre"
    ,"Anderes"};
  public final static String INTER_MENU_MANIPULATE_INTERCEPT[] = { ""
    ,"Mass Entry Intercept"
    ,"Manipule La Interceptación"
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
    ,"Associé CRN"
    ,"Teilnehmer CRN"};
  public final static String INTER_MENU_ROUTE_MAINT[] = { ""
    ,"Route Maintenance"
    ,"Encamine El Mantenimiento"
    ,"Conduisez L'Entretien"
    ,"Verlegen Sie Wartung"};
  public final static String INTER_MENU_ADMIN[] = { ""
    ,"Administration"
    ,"Administración"
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
    ,"El comienzo del Web de Java plugin no está instalado en este sistema"
    ,"Le début de Web de Java plugin n'est pas installé sur ce système"
    ,"Der steckbare Javaweb-Anfang ist nicht auf dieses System installiert"};
  public final static String INTER_MENU_INSTALL[]= {""
    ,"In order to run the admin apps you need to install"
    ,"Para ejecutar los apps del admin que usted necesita instalar"
    ,"Afin d'exécuter les apps d'admin que vous devez installer"
    ,"Zwecks die admin-apps laufen lassen, die Sie installieren müssen"};
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
     ,"Menú Del Inventario"
     ,"Menu De Inventaire"
     ,"InhaltMenü"};
  public final static String INV_MENU_SCANS[] = {""
      ,"Scans"
      ,"Exploraciones"
      ,"Balayages"
      ,"Scans"};
  public final static String INV_MENU_REASON_SCAN[] = {""
      ,"Reason Scan"
      ,"Exploración De la Razón"
      ,"Balayage De Raison"
      ,"GrundScan"};
  public final static String INV_MENU_RELEASE_SCAN[] = {""
      ,"Release Scan"
      ,"Release/versión La Exploración"
      ,"Libérez Le Balayage"
      ,"Geben Sie Scan Frei"};
  public final static String INV_MENU_HANDLING_INST[] = {""
      ,"Handling Instructions"
      ,"Manipulación De Instrucciones"
      ,"Manipulation Des Instructions"
      ,"Behandlung Von Anweisungen"};
  public final static String INV_MENU_SHIPMENT_REMARK[] = {""
      ,"Shipment Remark"
      ,"Observación Del Envío"
      ,"Remarque D'Expédition"
      ,"VersandAnmerkung"};
  public final static String INV_MENU_STATUS[] = { ""
    ,"Status"
    ,"Estatus"
    ,"Mode"
    ,"Status"};
  public final static String INV_MENU_DETAIN_LOC[] = { ""
    ,"Detainment Location"
    ,"Localización De la Detención"
    ,"Emplacement De Détention"
    ,"ZurückbehaltungStandort"};
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
    ,"Envío De vuelta"
    ,"Expédition De retour"
    ,"RückholVersand"};
  public final static String INV_MENU_CONFIG[] = { ""
    ,"Configuration"
    ,"Configuración"
    ,"Configuration"
    ,"Konfiguration"};
  public final static String INV_MENU_CONFIG_LOCATION[] = { ""
    ,"Location"
    ,"Localización"
    ,"Emplacement"
    ,"Standort"};
  public final static String INV_MENU_CONFIG_REASON_CODE[] = { ""
    ,"Reason Code"
    ,"Código De Razón"
    ,"Code complémentaire"
    ,"GrundCode"};
  public final static String INV_MENU_CONFIG_RELEASE_CODE[] = { ""
    ,"Release Code"
    ,"Release/versión El Código"
    ,"Libérez Le Code"
    ,"Geben Sie Code Frei"};
  public final static String INV_MENU_CONFIG_HANDLING_INST[] = { ""
    ,"Handling Instruction"
    ,"Manipulación De la Instrucción"
    ,"Manipulation De l'Instruction"
    ,"Behandlung Von Anweisung"};
  public final static String INV_MENU_REMARKS[] = { ""
    ,"Remarks"
    ,"Observaciones"
    ,"Remarques"
    ,"Anmerkungen"};
  public final static String INV_MENU_DETAINMENT_IN [] = { ""
    ,"Detainment In"
    ,"Detención Del Pulg"
    ,"Détention De Po"
    ,"Zurückbehaltung-Inch"};
  public final static String INV_MENU_DETAINMENT_OUT [] = { ""
    ,"Detainment Out"
    ,"De la Detención Hacia fuera"
    ,"De Détention Dehors"
    ,"Zurückbehaltung Heraus"};
   //leave facility
  public final static String LEAVE_FACILITY_TITLE[] = { ""
      ,"Package Departure"
      ,"Salida Del Conjunto"
      ,"Départ De Module"
      ,"PaketAbfahrt"};
  /*
  public final static String LEAVE_FACILITY_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB of the departing package"
      ,"Incorpore AWB que sale del conjunto"
      ,"Écrivez AWB partant du module"
      ,"Tragen Sie AWB des abreisenpakets ein"};
    */
   public final static String LEAVE_FACILITY_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String LEAVE_FACILITY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String LEAVE_FACILITY_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //Login
  public final static String LOGIN_PAGE_TITLE[] = {""
       ,"CCII Login"
       ,"CCII Conexión"
       ,"CCII Procédure de connexion"
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
     ,"Elija El Lenguaje","Choisissez Le Langage","Wählen Sie Sprache"};
  public final static String LOGIN_CHANGE_PASSWORD_PROMPT[]= {"","Change Password"
     ,"Cambie La Palabra de paso"
     ,"Changez Le Mot de passe"
     ,"Ändern Sie Kennwort"};
  public final static String LOGIN_NEW_PASSWORD_PROMPT[] = {"","New Password"
     ,"Nueva Palabra de paso"
     ,"Nouveau Mot de passe"
     ,"Neues Kennwort"};
  public final static String LOGIN_CONFIRM_PASSWORD_PROMPT[] = {"","Confirm Password"
     ,"Confirme La Palabra de paso"
     ,"Confirmez Le Mot de passe"
     ,"Bestätigen Sie Kennwort"};
  public final static String LOGIN_EXPIRED_SESSION_ERROR_MSG[]={""
     ,"Session has expired or is not valid, you must log in again"
     ,"La sesión ha expirado o es inválida, usted debe abrirse una sesión otra vez "
     ,"La session a expiré ou est incorrecte, vous doit ouvrir une session encore "
     ,"Sitzung ist abgelaufen oder ist unzulässig, Sie muß in wieder protokollieren "};
  public final static String LOGIN_ACTIVE_USER_ERROR_MSG[]={""
     ,"You are not an active user, please see your manager to be reactivated"
     ,"Usted no es un utilizador activo, ve por favor a su encargado que se reactivará "
     ,"Vous n'êtes pas un utilisateur actif, voyez s'il vous plaît votre gestionnaire à réactiver"
     ,"You are not an active user, please see your manager to be reactivated"};
  public final static String LOGIN_ENABLED_USER_ERROR_MSG[]={""
     ,"You are not an enabled user, please see your manager to be Enabled"
     ,"Usted no es un utilizador permitido, ve por favor a su encargado que se permitirá "
     ,"Vous n'êtes pas un utilisateur permis, voyez s'il vous plaît votre gestionnaire à permettre "
     ,"Sie sind nicht ein aktivierter Benutzer, sehen bitte Ihren zu aktivierenden Manager "};
  public final static String LOGIN_PASSWORD_CORRECT_ERROR_MSG[]={""
     ,"Your user name or password is incorrect, please login again"
     ,"Su nombre o palabra de paso del utilizador es incorrecta, por favor conexión otra vez "
     ,"Votre nom ou mot de passe d'utilisateur est incorrect, s'il vous plaît procédure de connexion encore "
     ,"Ihr Benutzername oder -kennwort ist falsch, bitte LOGON wieder "};
  public final static String LOGIN_EXPIRED_USER_ERROR_MSG[]={""
     ,"Your password has expired, you must change your password before logging in"
     ,"Su palabra de paso ha expirado, usted debe cambiar su palabra de paso antes que entraba "
     ,"Votre mot de passe a expiré, vous doit changer votre mot de passe avant entrant "
     ,"Ihr Kennwort ist, Sie muß Ihr Kennwort ändern abgelaufen, bevor es protokollierte in "};
  public final static String LOGIN_PASSWORDS_DO_NOT_MATCH_ERROR_MSG[] = {""
     ,"On Change Password, Passwords do not match.  Please try again."
     ,"En palabra de paso del cambio, las palabras de paso no corresponden con. Por favor intento otra vez"
     ,"Sur le mot de passe de changement, les mots de passe ne s'assortissent pas. S'il vous plaît essai encore. "
     ,"Auf Änderung Kennwort passen Kennwörter nicht zusammen. Bitte Versuch wieder.  "};
  public final static String LOGIN_NEW_PASSWORD_NO_CHANGE_ALLOWED_ERROR_MSG[] = {""
     ,"User not allowed to change password"
     ,"Utilizador no permitido cambiar palabra de paso"
     ,"Utilisateur non permis de changer le mot de passe"
     ,"Benutzer nicht erlaubt, Kennwort zu ändern"};
  public final static String LOGIN_NEW_PASSWORD_LENGTH_ERROR_MSG[] = {""
     ,"Password length error"
     ,"Error de longitud de la palabra de paso"
     ,"Erreur de longueur de mot de passe"
     ,"Kennwortlängenfehler"};
  public final static String LOGIN_NEW_PASSWORD_INVALID_CHARS_ERROR_MSG[] = {""
     ,"Password contains invalid characters"
     ,"La palabra de paso contiene caracteres inválidos"
     ,"Le mot de passe contient les caractères incorrects"
     ,"Kennwort enthält unzulässige Zeichen"};
  public final static String LOGIN_NO_LOGIN_GROUP_ERROR_MSG[] = { ""
    ,"You are not a member of any login group.  Please see your manager to be added to a login group."
    ,"Usted no es un miembro de cualquier grupo de la conexión. Vea por favor a su encargado que se agregará a un grupo de la conexión."
    ,"Vous n'êtes pas un membre de tout groupe de procédure de connexion. Veuillez voir le votre gestionnaire à ajouter à un groupe de procédure de connexion."
    ,"Sie sind nicht ein Bauteil irgendeiner LOGON-Gruppe. Sehen Sie bitte Ihren einer LOGON-Gruppe hinzuzufügenden Manager."};
  public final static String LOGIN_LANGUAGE1[] = {""
    ," DEFAULT> English"
    ,"> Inglés"
     ,"> Anglais"
     ,"> Englische"};
  public final static String LOGIN_LANGUAGE2[] = {""
    ,"> Spanish"
    ," DEFAULT> Español"
    ,"> Espagnole"
    ,"> Spanische"};
  public final static String LOGIN_LANGUAGE3[] = {""
   ,"> French"
   ,"> Francés"
    ," DEFAULT> Française"
    ,"> Französische"};
   public final static String LOGIN_LANGUAGE4[] = {""
     ,"> German"
     ,"> Alemán"
    ,"> Allemande"
    ," DEFAULT> Deutsche"};
  //logoutSucess
  public final static String LOGOUT_SUCCESS_TITLE[] = {""
    ,"Logout Successful"
    ,"Fin de comunicación Acertada"
    ,"Sortie du système Réussie"
    ,"Logout Erfolgreich"};
  public final static String LOGOUT_SUCCESS_TEXT[] = {""
    ,"Click here to return to login screen"
    ,"Tecleo aquí a volver a la pantalla de la conexión"
    ,"Déclic ici à retourner à l'écran de procédure de connexion"
    ,"Klicken hier zum Zurückgehen zum LOGON-Bildschirm"};
  public final static String LOGOUT_SUCCESS_FORWARD_TO_HOMEPAGE[] = {""
    ,"Automatically forwarding to browser homepage"
    ,"Automáticamente expedición al homepage del browser"
    ,"Automatiquement expédition au homepage de browser"
    ,"Automatisch Versenden zu Datenbanksuchroutinehomepage"};
  //main frame
  public final static String MAIN_FRAME_TITLE[] = { ""
     ,"CCII Application"
     ,"CCII Aplicación"
     ,"CCII Application"
     ,"CCII Anwendung"};
  //manipulate Intercepts
  public final static String MANIPULATE_INTERCEPT_INTERCEPT[] = {""
    ,"Intercept"
    ,"Interceptación"
    ,"Interception"
    ,"Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_INPUT_PAGE_TITLE[] = {""
    ,"Add, Remove, or Satisfy an Intercept"
    ,"Agregue, quite, o satisfaga una intercepción"
    ,"Ajoutez, enlevez, ou satisfaites une interception"
    ,"Addieren Sie, entfernen Sie oder erfüllen Sie einen Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_CODE_INSTRUCTIONS[] = {""
    ,"Choose an Agency"
    ,"Elija una agencia"
    ,"Choisissez une agence"
    ,"Wählen Sie eine Agentur"};
  public final static String MANIPULATE_INTERCEPT_CODE2_INSTRUCTIONS[] = {""
    ,"Choose an Intercept"
    ,"Elija una interceptación"
    ,"Choisissez une interception"
    ,"Wählen Sie einen Abschnitt"};
  public final static String MANIPULATE_INTERCEPT_AWB_INSTURCTIONS[] = {""
    ,"Enter one or more AWB numbers"
    ,"Incorpore unos o más números de AWB"
    ,"Écrivez un ou plusieurs nombres d'cAwb"
    ,"Geben Sie eine oder mehr AWB-Zahlen ein"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_ADD[] = {""
    ,"Add"
    ,"Agregue"
    ,"Ajoutez"
    ,"Fügen Sie hinzu"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_DELETE[] = {""
    ,"Remove"
    ,"Quitan"
    ,"Retirent"
    ,"Löschen"};
  public final static String MANIPULATE_INTERCEPT_SUBMIT_SATISFY[] = { ""
    ,"Satisfy"
    ,"Satisfacen"
    ,"Satisfont"
    ,"Erfüllen"};
  public final static String MANIPULATE_INTERCEPT_WARNING[] = {""
    ,"This screen manipulates shipment level intercepts"
    ,"Esta pantalla manipula interceptaciones del nivel del envío"
    ,"Cet écran manipule des interceptions de niveau d'expédition"
    ,"Dieser Bildschirm manipuliert Versandstufe Abschnitte"};
  public final static String MANIPULATE_INTERCEPT_SHIPMENT_LEVEL[] = {""
    ,"Shipment Level"
    ,"Nivel Del Envío"
    ,"Niveau D'Expédition"
    ,"Versand-Niveau"};
  public final static String MANIPULATE_INTERCEPT_PIECE_LEVEL[] = {""
    ,"Piece Level"
    ,"Nivel Del Pedazo"
    ,"Niveau De Morceau"
    ,"Stück-Niveau"};
  //movement scan
  public final static String MOVEMENT_TITLE[] = { ""
    ,"Movement Scan"
    ,"Exploración Del Movimiento"
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
     ,"Ningún Permiso"
     ,"Aucune Permission"
     ,"Keine Erlaubnis"};
  public final static String NO_PERMISSION_TEXT[]= {""
     ,"You do not have permission to use this functionality.  "
     + "Please choose a different function from the menu.  "
     + "If you feel you should have this functionality, please see your manager. "
     ,"Usted no tiene permiso de utilizar estas funciones.  "
     + "Elija por favor una diversa función del menú.  "
     + "Si usted se siente usted debe tener estas funciones, ve por favor a su encargado.  "
     ,"Vous n'avez pas la permission d'utiliser cette fonctionnalité.  "
     + "Veuillez choisir une fonction différente du menu.  "
     + "Si vous vous sentez vous devriez avoir cette fonctionnalité, voyez s'il vous plaît votre gestionnaire.  "
     ,"Sie haben nicht Erlaubnis, diese Funktionalität zu verwenden"
     + "Wählen Sie bitte eine andere Funktion vom Menü.  "
     + "Wenn Sie glauben, sollten Sie diese Funktionalität haben, sehen bitte Ihren Manager." };
  //package arrivale
  public final static String PACKAGE_ARRIVAL_TITLE[] = { ""
    ,"Package Arrival"
    ,"Llegada Del Conjunto"
    ,"Arrivée De Module"
    ,"PaketAnkunft"};
  public final static String PACKAGE_ARRIVAL_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String PACKAGE_ARRIVAL_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String PACKAGE_ARRIVAL_CODE_INSTRUCTIONS[] = { ""
    ,"Route Number"
    ,"Números De la Ruta"
    ,"Nombres D'Itinéraire"
    ,"WegZahlen"};
  public final static String PACKAGE_ARRIVAL_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //package History
  public final static String PACKAGE_HISTORY_TITLE[] = { ""
    ,"Show Package Location and History"
    ,"Muestre la localización del conjunto e historia"
    ,"Montrez l'emplacement et l'histoire de module"
    ,"Zeigen Sie Paketstandort und -geschichte"};
  public final static String PACKAGE_HISTORY_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Location and History"
    ,"Incorpore Número El Seguir para encontrar la localización e historia"
    ,"Écrivez Nombre De Cheminement pour trouver l'emplacement et l'histoire"
    ,"Tragen Sie GleichlaufZahl ein, um Standort und Geschichte zu finden"};
  public final static String PACKAGE_HISTORY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String PACKAGE_HISTORY_DUPLICATES_FOUND[] = {""
    ," Duplicates found for: "
    ," Los artículos con llave de validación encontraron para: "
    ," Les doubles ont trouvé pour: "
    ," Duplikate fanden für: "};
  public final static String PACKAGE_HISTORY_OF[] = {""
    ," of "
    ," de "
    ," de "
    ," von "};
  public final static String PACKAGE_HISTORY_NO_PACKAGE_FOUND[] = {""
    ,"No Package found for: "
    ,"Ningún conjunto encontrado para: "
    ,"Aucun module n'a trouvé pour: "
    ,"Kein Paket fand für: "};
  public final static String PACKAGE_HISTORY_TRACKINGNUMBER[] = {""
    ,"Tracking Number"
    ,"Seguir Número"
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
    ,"La Fois Passée De Date"
    ,"Letztes DatumMal"};
  public final static String PACKAGE_HISTORY_STAGING_AREA[] = STAGING_AREA;
  public final static String PACKAGE_HISTORY_DETAINMENT_LOC[] = {""
    ,"Detainment Loc"
    ,"Localización De la Detención"
    ,"Emplacement De Détention"
    ,"ZurückbehaltungStandort"};
  public final static String PACKAGE_HISTORY_STATUS[] = GENERIC_STATUS_STATUS_OR_LOCATION;
  public final static String PACKAGE_HISTORY_NO_SCANS[] = { ""
    ,"No scans found for: "
    ,"Ningunas exploraciones encontraron para: "
    ,"Aucuns balayages trouvés pour: "
    ,"Keine Scans gefunden für: "};
  public final static String PACKAGE_HISTORY_LOCAL_SCANS[]= {""
    ,"Local Scans for: "
    ,"Exploraciones locales para: "
    ,"Balayages locaux pour: "
    ,"Lokale Scans für: "};
  public final static String PACKAGE_HISTORY_DATE_TIME [] = { ""
    ,"Date/Time"
    ,"Tiempo De la Fecha"
    ,"Temps De Date"
    ,"DatumZeit"};
   public final static String PACKAGE_HISTORY_SCAN_CODE [] = { ""
    ,"Scan Type"
    ,"Tipo De la Exploración"
    ,"Type De Balayage"
    ,"Scan-Art"};
  public final static String PACKAGE_HISTORY_STAT_CODE [] = { ""
    ,"Stat Code"
    ,"Código De Estatus"
    ,"Code De Mode"
    ,"Status-Code"};
   public final static String PACKAGE_HISTORY_EMPLOYEE_NUM [] = { ""
    ,"Employee Number"
    ,"Número Del Empleado"
    ,"Nombre Des Employés"
    ,"AngestelltZahl"};
  public final static String PACKAGE_HISTORY_END_DUPLICATES[] = {""
    ,"end of duplicates found for: "
    ,"el extremo de artículos con llave de validación encontró para: "
    ,"end of duplicates found for: "
    ,"Ende der Duplikate gefunden für: "};
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
    ,"Coutumes Effacées"
    ,"Gewohnheiten Gelöscht"};
  //package Stage staus
  public final static String PACKAGE_STAGE_STATUS_TITLE[] = { ""
    ,"Show Package Status"
    ,"Demuestre El Estado Del Paquete"
    ,"Montrez Le Statut De Paquet"
    ,"Zeigen Sie Paket-Status"};
  public final static String PACKAGE_STAGE_STATUS_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Status"
    ,"Incorpore Número El Seguir para encontrar estatus"
    ,"Écrivez Nombre De Cheminement pour trouver le mode"
    ,"Tragen Sie GleichlaufZahl ein, um Status zu finden"};
  public final static String PACKAGE_STAGE_STATUS_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  //package status
  public final static String PACKAGE_STATUS_TITLE[] = { ""
    ,"Show Package Status Screen"
    ,"Muestre La Pantalla Del Estatus Del Conjunto"
    ,"Montrez L'Écran De Mode De Module"
    ,"Zeigen Sie PaketStatusBildschirm"};
  public final static String PACKAGE_STATUS_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter Tracking Number to find Status"
    ,"Incorpore Número El Seguir para encontrar estatus"
    ,"Écrivez Nombre De Cheminement pour trouver le mode"
    ,"Tragen Sie GleichlaufZahl ein, um Status zu finden"};
  public final static String PACKAGE_STATUS_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  //printer ID label
  public final static String PRINTERID_TITLE[] = { ""
    ,"Printer ID Label"
    ,"Etiqueta de la Identificación De la Impresora"
    ,"Étiquette d'Identification D'Imprimeur"
    ,"Aufkleber Des Drucker-Identifikation"};
  public final static String PRINTERID_PAGE_INSTRUCTIONS[] = { ""
    ,"Choose Printer name to print Printer ID label"
    ,"Elija el nombre de la impresora para imprimir la etiqueta de la identificación de la impresora "
    ,"Choisissez le nom d'imprimeur pour imprimer l'étiquette d'identification d'imprimeur "
    ,"Beschließen Sie Druckernamen, um Aufkleber des Druckers Identifikation zu drucken "};
  public final static String PRINTERID_CODE_INSTRUCTIONS[] = { ""
    ,"Printer ID"
    ,"Identificación De la Impresora"
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
    ,"Etiquetas de la identificación de la impresión"
    ,"Étiquettes d'identification d'impression"
    ,"Aufkleber des Druckes Identifikation"};
  public final static String PRINTEROPT_DETAIN_AREA_LOC_LABEL[] = {""
    ,"Detainment Loc Label"
    ,"Etiqueta De la Localización De la Detención"
    ,"Étiquette D'Endroit De Détention"
    ,"Zurückbehaltung-Position Aufkleber"};
  public final static String PRINTEROPT_DOWNLOAD_FORMATS[] = {""
    ,"Download Formats"
    ,"Formatos De la Transferencia directa"
    ,"Formats De Téléchargement"
    ,"Download-Formate"};
  public final static String PRINTEROPT_PRINTERID_LABEL[] = {""
    ,"Printer ID Label"
    ,"Etiqueta de la Identificación De la Impresora"
    ,"Étiquette d'Identification D'Imprimeur"
    ,"Aufkleber Des Drucker-Identifikation"};
  public final static String PRINTEROPT_STAGEAREAID_LABEL[] = {""
    ,"Staging Area ID Label"
    ,"Etiqueta de la Identificación Del Área Que efectúa"
    ,"Étiquette d'Identification De Secteur Mettant en scène"
    ,"Inszenierung Bereich Identifikation Aufkleber"};
  public final static String PRINTEROPT_WHSEID_LABEL[] = { ""
    ,"Warehouse Id Label"
    ,"Etiqueta De la Identificación Del Almacén"
    ,"Étiquette D'Identification D'Entrepôt"
    ,"Lager-Kennzeichnung Aufkleber"};
  //query
  public final static String QUERY_TITLE[] = { ""
      ,"Query Scan"
      ,"Exploración De la Pregunta"
      ,"Balayage De Question"
      ,"Frage Scan"};
  public final static String QUERY_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String QUERY_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String QUERY_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //reason code
  public final static String REASON_INPUT_PAGE_TITLE[] = {""
    ,"Reason Code Input Page"
    ,"Paginación De la Entrada de información Del Código De Razón"
    ,"Page D'Entrée De Code complémentaire"
    ,"GrundCode-InputSeite"};
  public final static String REASON_CODE_INSTRUCTIONS[] = {""
    ,"Select one or more Reason codes"
    ,"Seleccione unos o más códigos de razón"
    ,"Choisissez un ou plusieurs codes complémentaires"
    ,"Wählen Sie ein oder mehr Grundcodes aus"};
  public final static String REASON_AWB_INSTURCTIONS[] = {""
    ,"Enter one or more Tracking Number numbers"
    ,"Incorpore unos o más números El Seguir"
    ,"Écrivez un ou plusieurs nombres De Cheminement"
    ,"Geben Sie eine oder mehr GleichlaufZahl-Zahlen ein"};
  //regulatory releease
  public final static String REGULATORY_RELEASE_TITLE[] = { ""
    ,"Regulatory Release"
    ,"Regulador Desbloquear"
    ,"De normalisation Version"
    ,"Regelnde Freigabe"};
  public final static String REGULATORY_RELEASE_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter the tracking number and release number of the package to be released"
    ,"Incorpore el número que sigue y release/versión el número del conjunto que release/versión"
    ,"Écrivez le nombre de cheminement et libérez le nombre du module à libérer"
    ,"Tragen Sie die aufspürenzahl ein und geben Sie Zahl des freizugebenden Pakets frei "};
  public final static String REGULATORY_RELEASE_AWB_INSTRUCTIONS[] = TRACKING_NUMBER;
  public final static String REGULATORY_RELEASE_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Release Number"
    ,"Release/versión El Número"
    ,"Libérez Le Nombre"
    ,"Geben Sie Zahl Frei"};
  //release code
  public final static String RELEASE_INPUT_PAGE_TITLE[] = {""
    ,"Release Code Input Page"
    ,"Release/versión La Paginación De la Entrada de información Del Código"
    ,"Libérez La Page D'Entrée De Code"
    ,"Geben Sie CodeInputSeite Frei"};
  public final static String RELEASE_CODE_INSTRUCTIONS[] = {""
      ,"Select one or more Realease codes"
      ,"Seleccione unos o más códigos de Realease"
      ,"Choisissez un ou plusieurs codes de Realease"
      ,"Wählen Sie ein oder mehr Codes Realease aus"};
  public final static String RELEASE_AWB_INSTURCTIONS[] =
     {"","Enter one or more Tracking Numbers"
      ,"Incorpore unos o más números El Seguir"
      ,"Écrivez un ou plusieurs nombres De Cheminement"
      ,"Geben Sie eine oder mehr GleichlaufZahl-Zahlen ein"};
  public final static String REPORT_NOT_HERE_TITLE[]= {""
    ,"Reports not on this system"
    ,"Informes no sobre este sistema."
    ,"États pas sur ce système."
    ,"Berichte nicht über dieses System."};
  public final static String REPORT_NOT_HERE_MESSAGE[]= {""
    ,"Reports are not located on this system.  Please use the Eureka report viewer to access the reports."
    ,"Señale no están situados en este system. Utilice por favor el espectador del informe de Eureka para tener acceso a los informes."
    ,"Enregistrez ne sont pas situés sur ce system. Veuillez employer le visualisateur d'état de Eureka pour accéder aux états."
    ,"Berichten Sie sind nicht auf diesem system. Benutzen Sie bitte den Eureka-Reportprojektor, um die Reports zuzugreifen."};
  //Reprocess
  public final static String REPROCESS__TITLE [] = {""
    ,"Reprocess"
    ,"Trate de nuevo"
    ,"Retraitez"
    ,"Bereiten Sie wieder auf"};
   public final static String REPROCESS__TRACKING_NBR [] = {""
    ,"Tracking Number: "
    ,"Seguir Número: "
    ,"Cheminement Du Nombre: "
    ,"Gleichlauf Von Zahl: "};
  public final static String REPROCESS__ATTEMPT_SCAN [] = {""
    ,"Attempting Scan: "
    ,"Procurar La Exploración: "
    ,"Essayer Le Balayage: "
    ,"Versuchen Des Scans: "};
  public final static String REPROCESS__ERROR_MSG [] = {""
    ,"Error Messages: "
    ,"Mensajes De Error: "
    ,"Messages D'Erreur: "
    ,"Fehlermeldungen: "};
  public final static String REPROCESS__ATTEMPT_REASON [] = {""
    ,"Attempted Reason Code: "
    ,"Código De Razón Procurado: "
    ,"Code complémentaire Essayé: "
    ,"Versuchter GrundCode: "};
  public final static String REPROCESS__ATTEMPT_RELEASE [] = {""
    ,"Attempted Release Code: "
    ,"Código Procurado Del Desbloquear: "
    ,"Code Essayé De Version: "
    ,"Versuchter FreigabeCode: "};
  public final static String REPROCESS__ATTEMPT_HANDLING [] = {""
    ,"Attempted Handling Code: "
    ,"Procurado Manejando Código: "
    ,"Essayé Manipulant Le Code: "
    ,"Versucht, Code Anfassend: "};
  public final static String REPROCESS__ATTEMPT_REMARK [] = {""
    ,"Attempted Remark Code: "
    ,"Código Procurado De la Observación: "
    ,"Code Essayé De Remarque: "
    ,"Versuchter AnmerkungCode: "};
  public final static String REPROCESS__ATTEMPT_STAGEAREA [] = {""
    ,"Attempted Stage Area Code: "
    ,"Código De Área Procurado De la Etapa: "
    ,"Indicatif régional Essayé D'Étape: "
    ,"Versuchte Stadium Ortsnetzkennzahl: "};
  public final static String REPROCESS__NEW_AWB [] = {""
    ,"Enter new Tracking Number: "
    ,"Incorpore Número El Seguir: "
    ,"Écrivez Nombre De Cheminement: "
    ,"Tragen Sie neues GleichlaufZahl ein: "};
   public final static String REPROCESS__ENTER_MASTER [] = {""
    ,"Enter Master: "
    ,"Entre en El Amo: "
    ,"Entrez dans Le Maître: "
    ,"Betreten Sie Meister: "};
  public final static String REPROCESS__MASTER_UNKNOWN[] = {""
    ,"Check here if Master is unknown: "
    ,"Controle aquí si el amo es desconocido: "
    ,"Contrôlez ici si le maître est inconnu: "
    ,"Überprüfen Sie hier, ob Meister unbekannt ist: "};
   public final static String REPROCESS__ENTER_FORM_CODE [] = {""
    ,"Enter Form Code: "
    ,"Introduzca El Código De la Forma: "
    ,"Écrivez Le Code De Forme: "
    ,"Geben Sie FormularCode Ein: "};
   public final static String REPROCESS__DETAINMENT_LOC [] = {""
    ,"Enter Detainment Location: "
    ,"Entre en La Localización De la Detención: "
    ,"Entrez L'Emplacement De Détention: "
    ,"Geben Sie ZurückbehaltungStandort Ein: "};
   public final static String REPROCESS__UNKNOWN_ERROR [] = {""
    ,"Unknown error Type"
    ,"Desconocido tipo de error"
    ,"Inconnu type d'erreur"
    ,"Unbekannte Fehlerart"};
  public final static String REPROCESS__OVERRIDE_ERROR [] = {""
    ,"Override Error"
    ,"Error De la Invalidación"
    ,"Erreur De Priorité"
    ,"Übersteuerung Fehler"};

  //ReprocessComplete
  public final static String REPROCESS_COMPLETE_TITLE [] = {""
    ,"Reprocess Complete"
    ,"Trate de nuevo Completo"
    ,"Retraitez Complet"
    ,"Bereiten Sie Komplettes Wieder auf"};
  public final static String REPROCESS_COMPLETE_TEXT[] = {""
    ,"Reprocess is complete, choose another function to perform"
    ,"Trate de nuevo es completo, elige otra función para realizarse "
    ,"Retraitez est complet, choisit une autre fonction pour exécuter "
    ,"Bereiten Sie ist komplett, beschließt eine andere Funktion, um durchzuführen wieder auf"};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART1[] = {""
    ,"Return to "
    ,"Vuelva a la "
    ,"Revenez à "
    ,"Gehen Sie zum ursprünglichen "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART2[] = {""
    ," original "
    ," pantalla  "
    ," l'écran  "
    ," Bildschirm   "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART3[] = {""
    ," screen"
    ," original"
    ," initial"
    ," zurück"};

/*  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART1[] = {""
    ,"Automatically "
    ,"Automáticamente "
    ,"Automatiquement "
    ,"Automatisch "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART2[] = {""
    ," forwarding "
    ," expedición "
    ," expédition "
    ," Versenden "};
  public final static String REPROCESS_COMPLETE_AUTO_FORWARD_PART3[] = {""
    ," to original input page"
    ," a la paginación original de la entrada de información"
    ," à la page initiale d'entrée"
    ," zur ursprünglichen Inputseite"};
    */
  //ReprocesDup
  public final static String REPROCESS_DUP_TITLE [] = {""
    ,"Reprocess: Resolve Duplicate"
    ,"Trate de nuevo: Resuelva El Artículo con llave de validación"
    ,"Retraitez:  Résolvez Le Double"
    ,"Bereiten Sie wieder auf:  Beheben Sie Duplikat"};
  public final static String REPROCESS_DUP_TRACKING_NBR [] = {""
    ,"Tracking Number: "
    ,"Seguir Número: "
    ,"Cheminement Du Nombre: "
    ,"Gleichlauf Von Zahl: "};
  public final static String REPROCESS_DUP_ATTEMPT_SCAN [] = {""
    ,"Attempting Scan: "
    ,"Procurar La Exploración: "
    ,"Essayer Le Balayage: "
    ,"Versuchen Des Scans: "};
  public final static String REPROCESS_DUP_CHOOSE [] = {""
    ,"Choose"
    ,"Elija"
    ,"Choisissez"
    ,"Wählen Sie"};
  public final static String REPROCESS_DUP_SHIP_DATE [] = {""
    ,"Shipment Date"
    ,"Fecha Del Envío"
    ,"Date D'Expédition"
    ,"VersandDatum"};
  public final static String REPROCESS_DUP_SHIP_DESC [] = {""
    ,"Shipment Desc"
    ,"Envío Desc"
    ,"Expédition Desc"
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
    ,"Expedidor, país, postal"
    ,"Expéditeur, pays, postal"
    ,"Verlader, Land, Post"};
   public final static String REPROCESS_DUP_CONSIGNEE_INFO [] = {""
    ,"Consignee, country, postal"
    ,"Consignatario, país, postal"
    ,"Destinataire, pays, postal"
    ,"Empfänger, Land, Post"};
   public final static String REPROCESS_DUP_NO_DUPS_FOUND [] = {""
    ,"No duplicates found to resolve"
    ,"Ningunos artículos con llave de validación encontraron para resolver. "
    ,"Double n'a pas trouvé pour résoudre"
    ,"Keine Duplikate gefunden, um zu beheben"};
   public final static String REPROCESS_DUP_UNABLE_FETCH [] = {""
    ,"Unable to fetch info on duplicate"
    ,"Incapaz traer el Info en el artículo con llave de validación"
    ,"Incapable de chercher l'information sur le double"
    ,"Nicht imstande, INFO auf Duplikat zu holen"};
  //ReprocessProcess
  public final static String REPROCESS_PROCESS_REPROCESS[] = {""
    ,"Reprocessed"
    ,"Tratado de nuevo"
    ,"Retraité"
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
    ,"Cancelación"
    ,"Effacement"
    ,"Löschung"};
  //result window
  public final static String RESULT_WINDOW_TITLE [] = {""
    ,"Result Window"
    ,"Window Del Resultado"
    ,"Window De Résultat"
    ,"Resultat Window"};
  public final static String RESULT_WINDOW_SUCCESS [] = {""
    ,"Success: "
    ,"Éxito: "
    ,"Succès: "
    ,"Erfolg: "};
  public final static String RESULT_WINDOW_FAIL [] = {""
    ,"Fail: "
    ,"Fall: "
    ,"Échouer: "
    ,"Ausfallen: "};
  public final static String RESULT_WINDOW_AWB [] = {""
    ,"AWB"
    ,"AWB"
    ,"AWB"
    ,"AWB"};
  public final static String RESULT_WINDOW_SCAN_NAME [] = {""
    ,"Scan Type"
    ,"Tipo De la Exploración"
    ,"Type De Balayage"
    ,"Scan-Art"};
  public final static String RESULT_WINDOW_CODE_OR_DESC [] = {""
    ,"Code or Description"
    ,"Código o descripción"
    ,"Code ou description"
    ,"Code oder Beschreibung"};
  public final static String RESULT_WINDOW_SCAN_RESULT[] = {""
    ,"Scan Result"
    ,"Resultado De Exploración"
    ,"Résultat De Balayage"
    ,"Scan-Resultat"};
  public final static String RESULT_WINDOW_NONE [] = {""
    ,"None"
    ,"Ningunos"
    ,"Aucun"
    ,"Keine"};
  public final static String RESULT_WINDOW_NONE_YET [] = {""
    ,"None Processed yet"
    ,"Ninguno procesada todavía"
    ,"Aucun traité encore"
    ,"Keine verarbeiteten schon"};
  public final static String RESULT_WINDOW_REMOVE_ALL[] = {""
    ,"Remove All"
    ,"Quite Todos"
    ,"Retirez Tous"
    ,"Löschen Sie Alle"};
  public final static String RESULT_WINDOW_REMOVE_SUCCESSFUL[] = {""
    ,"Remove Successful"
    ,"Quitan Acertado"
    ,"Retirez Réussi"
    ,"Löschen Sie Erfolgreiches"};
  public final static String RESULT_WINDOW_REPROCESS_ALL[] = { ""
    ,"Reprocess All"
    ,"Trate de nuevo Todos"
    ,"Retraitez Tous"
    ,"Bereiten Sie Alles Wieder auf"};
  //return package to shipper
  public final static String RETURN_PKG_SHIPPER_TITLE[] = { ""
    ,"Return Package to Shipper"
    ,"Conjunto de vuelta al expedidor"
    ,"Module de retour à l'expéditeur"
    ,"Rückholpaket zum Verlader"};
  public final static String RETURN_PKG_SHIPPER_PAGE_INSTRUCTIONS[] = { ""
    ,"Enter the original AWB and the new AWB to return a package to shipper"
    ,"Incorpore el AWB original y el AWB nuevo para volver un conjunto al expedidor"
    ,"Entrez dans l'cAwb initial et le nouvel AWB pour renvoyer un module à l'expéditeur"
    ,"Tragen Sie das ursprüngliche AWB und das neue AWB ein, um ein Paket zum Verlader zurückzubringen"};
  public final static String RETURN_PKG_SHIPPER_AWB_INSTRUCTIONS[] = { ""
    ,"Original AWB"
    ,"Awb Original"
    ,"Awb Initial"
    ,"Ursprüngliches Awb"};
  public final static String RETURN_PKG_SHIPPER_SINGLELINE_INSTRUCTIONS[] = { ""
    ,"Return AWB"
    ,"Awb De vuelta"
    ,"Awb De retour"
    ,"Rückhol-Awb"};
     // Corporate RIP scan
  public final static String RIP_INPUT_PAGE_TITLE[] = {""
      ,"Ramp In (RIP) Input Page"
      ,"Rampa en página de la entrada del (RIP)"
      ,"Rampe en page d'entrée de (RIP)"
      ,"Rampe in der x(RIP)x Eingang Seite"};
  public final static String RIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for RIP Scan"
      ,"Incorpore AWB para la exploración del RIP."
      ,"Écrivez AWB pour le balayage de RIP"
      ,"Tragen Sie AWB für RIP Scan ein"};
  public final static String RIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate ROP Scan
   public final static String ROP_INPUT_PAGE_TITLE[] = {""
      ,"Ramp Out (ROP) Input Page"
      ,"Rampa fuera de la página de la entrada del (ROP)"
      ,"Rampe hors de page d'entrée de (ROP)"
      ,"Rampe aus (ROP) Eingang Seite"};
  public final static String ROP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for ROP Scan"
      ,"Incorpore AWB para la exploración del ROP."
      ,"Écrivez AWB pour le balayage de ROP"
      ,"Tragen Sie AWB für ROP Scan ein"};
  public final static String ROP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //route edit
  public final static String ROUTE_EDIT_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginación"
      ,"L'Itinéraire Éditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y después someta"
      ,"Modifiez l'itinéraire choisi et puis soumettez"
      ,"Ändern Sie den ausgewählten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itinéraire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itinéraire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itinéraire"
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
     ,"Gewohnheiten Führen Durch"};
  public final static String ROUTE_EDIT_ROUTE_CLOSED[] = {""
     ,"Route Leg Closed"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itinéraire S'est fermée"
     ,"WegBein Schloß"};
  public final static String ROUTE_EDIT_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itinéraire Non trouvé"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separación"
    ,"Histoire D'Activité De Dégagement"
    ,"Abstand Aktivität Geschichte  "};
   public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripción"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separación encontró"
    ,"Aucune activité de dégagement trouvée"
    ,"Keine Abstand Aktivität gefunden"};
   //route edit APAC
  public final static String ROUTE_EDIT_APAC_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginación"
      ,"L'Itinéraire Éditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_APAC_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y después someta"
      ,"Modifiez l'itinéraire choisi et puis soumettez"
      ,"Ändern Sie den ausgewählten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_APAC_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itinéraire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_APAC_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itinéraire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_APAC_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itinéraire"
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
     ,"Gewohnheiten Führen Durch"};
  public final static String ROUTE_EDIT_APAC_ROUTE_CLOSED[] = {""
     ,"Route Leg Closed"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itinéraire S'est fermée"
     ,"WegBein Schloß"};
  public final static String ROUTE_EDIT_APAC_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itinéraire Non trouvé"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separación"
    ,"Histoire D'Activité De Dégagement"
    ,"Abstand Aktivität Geschichte  "};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripción"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_APAC_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separación encontró"
    ,"Aucune activité de dégagement trouvée"
    ,"Keine Abstand Aktivität gefunden"};
  public final static String ROUTE_EDIT_APAC_YES[] = { ""
    ,"Yes"
    ,"Sí"
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
    ,"Fermé"
    ,"Geschlossen"};
  public final static String ROUTE_EDIT_APAC_DELETE[] = {""
    ,"Delete"
    ,"Cancelación"
    ,"Effacement"
    ,"Löschung"};
   //route edit US
  public final static String ROUTE_EDIT_US_INPUT_PAGE_TITLE[] = {""
      ,"Route Edit Page"
      ,"La Ruta Corrige La Paginación"
      ,"L'Itinéraire Éditent La Page"
      ,"Weg Bearbeiten Seite"};
  public final static String ROUTE_EDIT_US_INSTRUCTIONS[] ={ ""
      ,"Modify the selected route and then submit"
      ,"Modifique la ruta seleccionada y después someta"
      ,"Modifiez l'itinéraire choisi et puis soumettez"
      ,"Ändern Sie den ausgewählten Weg und dann legen Sie ein"};
  public final static String ROUTE_EDIT_US_ROUTE_NBR[] = {""
     ,"Route Nbr"
     ,"Ruta Nbr"
     ,"Itinéraire Nbr"
     ,"Weg Nbr"};
  public final static String ROUTE_EDIT_US_ROUTE_LEG[] = {""
     ,"Route Leg"
     ,"Pierna De la Ruta"
     ,"Jambe D'Itinéraire"
     ,"WegBein"};
  public final static String ROUTE_EDIT_US_ROUTE_DATE[] = {""
     ,"Route Date"
     ,"Fecha De la Ruta"
     ,"Date D'Itinéraire"
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
     ,"Gewohnheiten Führen Durch"};
  public final static String ROUTE_EDIT_US_ROUTE_CLOSED[] = {""
     ,"Route Leg Status"
     ,"Pierna De la Ruta Cerrada"
     ,"La Jambe D'Itinéraire S'est fermée"
     ,"WegBein Schloß"};
  public final static String ROUTE_EDIT_US_ROUTE_NOT_FOUND[] = {""
    ,"Route Not Found"
    ,"Ruta No encontrada"
    ,"Itinéraire Non trouvé"
    ,"Weg Nicht Gefunden"};
  public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_HISTORY[] = {""
    ,"Clearance Activity History"
    ,"Historia De la Actividad De la Separación"
    ,"Histoire D'Activité De Dégagement"
    ,"Abstand Aktivität Geschichte  "};
   public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_DATE[] = {""
    ,"Date"
    ,"Fecha"
    ,"Date"
    ,"Datum"};
   public final static String ROUTE_EDIT_US_CLEARANCE_DESCRIPTION[] = {""
    ,"Description"
    ,"Descripción"
    ,"Description"
    ,"Beschreibung"};
   public final static String ROUTE_EDIT_US_CLEARANCE_ACTIVITY_NOT_FOUND[] = {""
    ,"No Clearance Activity found"
    ,"Ninguna actividad de la separación encontró"
    ,"Aucune activité de dégagement trouvée"
    ,"Keine Abstand Aktivität gefunden"};
  public final static String ROUTE_EDIT_US_YES[] = { ""
    ,"Scanning"
    ,"Sí"
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
      ,"Paginación Del Mantenimiento De la Ruta"
      ,"Page D'Entretien D'Itinéraire"
      ,"WegWartung Seite"};
  public final static String ROUTE_MAINT_INSTRUCTIONS[] ={ ""
      ,"Select a route to modify"
      ,"Seleccione encamínelo para modificarse"
      ,"Choisissez le conduisez pour modifier"
      ,"Wählen Sie verlegen Sie, um zu ändern"};
  public final static String ROUTE_MAINT_SORT_DATE_SUBMIT[] = {""
     ,"Choose Sort Date"
     ,"Elija La Fecha De la Clase"
     ,"Choisissez La Date De Tri"
     ,"Wählen Sie SortierungDatum"};
  public final static String ROUTE_MAINT_EDIT_ROUTE[] = { ""
     ,"Edit Route"
     ,"Corrija La Ruta"
     ,"Éditez L'Itinéraire"
     ,"Bearbeiten Sie Weg"};
  public final static String ROUTE_MAINT_TABLE_CHOOSE_ROUTE [] = { ""
     ,"Choose Route"
     ,"Elija La Ruta"
     ,"Choisissez L'Itinéraire"
     ,"Wählen Sie Weg"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_NUMBER[] = { ""
     ,"Route Number"
     ,"Encamine El Número"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_LEG_NBR[] = {""
     ,"Route Leg Number"
     ,"Encamine El Número"
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
     ,"Gewohnheiten Führen Durch"};
  public final static String ROUTE_MAINT_TABLE_ROUTE_CLOSED[] = { ""
     ,"Route Status"
     ,"Los Costumbres Terminan"
     ,"Itinéraire Fermé"
     ,"Weg Geschlossen"};
  public final static String ROUTE_MAINT_NO_ROUTES [] = { ""
     ,"No Routes for this date"
     ,"Ningunas rutas para esta fecha"
     ,"Aucun itinéraire pour cette date"
     ,"Keine Wege für dieses Datum"};
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
     ,"Fecha De la Clase De la Visión"
     ,"Date De Tri De Visionnement"
     ,"Betrachtung SortierungDatum"};
  public final static String ROUTE_MAINT_ROUTE_DATE[] = {""
    ,"Route Date"
    ,"Fecha De la Ruta"
    ,"Date D'Itinéraire"
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
      ,"Paginación Del Mantenimiento De la Ruta"
      ,"Page D'Entretien D'Itinéraire"
      ,"WegWartung Seite"};
  public final static String ROUTE_MAINT_APAC_INSTRUCTIONS[] ={ ""
      ,"Select a route to modify"
      ,"Seleccione encamínelo para modificarse"
      ,"Choisissez le conduisez pour modifier"
      ,"Wählen Sie verlegen Sie, um zu ändern"};
  public final static String ROUTE_MAINT_APAC_SORT_DATE_SUBMIT[] = {""
     ,"Choose Sort Date"
     ,"Elija La Fecha De la Clase"
     ,"Choisissez La Date De Tri"
     ,"Wählen Sie SortierungDatum"};
  public final static String ROUTE_MAINT_APAC_EDIT_ROUTE[] = { ""
     ,"Edit Route"
     ,"Corrija La Ruta"
     ,"Éditez L'Itinéraire"
     ,"Bearbeiten Sie Weg"};
  public final static String ROUTE_MAINT_APAC_TABLE_CHOOSE_ROUTE [] = { ""
     ,"Choose Route"
     ,"Elija La Ruta"
     ,"Choisissez L'Itinéraire"
     ,"Wählen Sie Weg"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_NUMBER[] = { ""
     ,"Route Number"
     ,"Encamine El Número"
     ,"Conduisez Le Nombre"
     ,"Verlegen Sie Zahl"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_LEG_NBR[] = {""
     ,"Route Leg Number"
     ,"Encamine El Número"
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
     ,"Gewohnheiten Führen Durch"};
  public final static String ROUTE_MAINT_APAC_TABLE_ROUTE_CLOSED[] = { ""
     ,"Route Flag"
     ,"Bandera De la Ruta"
     ,"Drapeau D'Itinéraire"
     ,"Weg-Markierungsfahne "};
  public final static String ROUTE_MAINT_APAC_NO_ROUTES [] = { ""
     ,"No Routes for this date"
     ,"Ningunas rutas para esta fecha"
     ,"Aucun itinéraire pour cette date"
     ,"Keine Wege für dieses Datum"};
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
     ,"Fecha De la Clase De la Visión"
     ,"Date De Tri De Visionnement"
     ,"Betrachtung SortierungDatum"};
  public final static String ROUTE_MAINT_APAC_ROUTE_DATE[] = {""
    ,"Route Date"
    ,"Fecha De la Ruta"
    ,"Date D'Itinéraire"
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
    ,"Kontaktlan-Support oder -operationen zum Unterstützen Sie"};
  //shipment remarks
  public final static String SHIP_REMARK_INPUT_PAGE_TITLE[] =
     {"","Shipment Remark Input Page"
      ,"Paginación De la Entrada de información De la Observación Del Envío"
      ,"Page D'Entrée De Remarque D'Expédition"
      ,"VersandAnmerkung-InputSeite"};
  public final static String SHIP_REMARK_CODE_INSTRUCTIONS[] =
     {"","Select a Shipment Remark to apply"
      ,"Seleccione una observación del envío para aplicarse"
      ,"Choisissez une remarque d'expédition pour s'appliquer"
      ,"Wählen Sie eine Versandanmerkung aus, um zuzutreffen"};
  public final static String SHIP_REMARK_TEXT_INSTRUCTIONS[] =
     {"","or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"
      ,"or enter freeform text to apply"};
  public final static String SHIP_REMARK_AWB_INSTURCTIONS[] =
     {"","Enter the Tracking Number to apply Shipment Remark"
      ,"Incorpore el número de Número El Seguir para aplicar la observación del envío"
      ,"Écrivez le Nombre De Cheminement pour appliquer la remarque d'expédition"
      ,"Tragen Sie die GleichlaufZahl-Zahl ein, um Versandanmerkung anzuwenden"};
  //STAGE AREA ID label
  public final static String STAGEAREAID_TITLE[] = { ""
    ,"Stage Area ID Label"
    ,"Etiqueta de la Identificación Del Área De la Etapa"
    ,"Étiquette d'Identification De Région D'Étape"
    ,"Stadium Bereich Identifikation Aufkleber"};
  public final static String STAGEAREAID_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String STAGEAREAID_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEAREAID_CODE2_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String STAGEAREAID_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String STAGEAREAID_EXCPETION_ALL_STAGE_AREAS [] = {""
    ,"All stage areas"
    ,"Todas las áreas de la etapa"
    ,"Tous les secteurs d'étape"
    ,"Alle Stadium Bereiche"};
  //corporate SIP Scan
    public final static String SIP_INPUT_PAGE_TITLE[] = {""
      ,"Station In (SIP) Input Page"
      ,"Estación en página de la entrada del (SIP)"
      ,"Station en page d'entrée de (SIP)"
      ,"Station in der (SIP) Eingang Seite"};
  public final static String SIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for SIP Scan"
      ,"Incorpore AWB para la exploración del SIP."
      ,"Écrivez AWB pour le balayage de SIP"
      ,"Tragen Sie AWB für SIP Scan ein"};
  public final static String SIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  // Corporate SOP Scan
   public final static String SOP_INPUT_PAGE_TITLE[] = {""
      ,"Station Out (SOP) Input Page"
      ,"Estación fuera de la página de la entrada del (SOP)"
      ,"Station hors de page d'entrée de (SOP)"
      ,"Station aus (SOP) Eingang Seite"};
  public final static String SOP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB for SOP Scan"
      ,"Incorpore AWB para la exploración del SOP."
      ,"Écrivez AWB pour le balayage de SOP"
      ,"Tragen Sie AWB für SOP Scan ein"};
  public final static String SOP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  //stage area pick list
  public final static String STAGE_AREA_PICK_INPUT_PAGE_TITLE[] = { ""
      ,"Stage Area Pick List"
      ,"Lista De la Selección Del Área De la Etapa"
      ,"Liste De Sélection De Région D'Étape"
      ,"Stadium Bereich AuswahlListe"};
  public final static String STAGE_AREA_PICK_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"List of tracking numbers that have satisfied intercepts but are still in staging area.  Select checkbox next to tracking number to print pick list labels."
      ,"La lista de los números que siguen que han satisfecho interceptaciones pero todavía está en área del estacionamiento. Checkbox selecto al lado del número que sigue para imprimir escrituras de la etiqueta de la lista de la selección. "
      ,"La liste de nombres de cheminement qui ont satisfait des interceptions mais sont toujours dans la zone d'échafaudage. Checkbox choisi à côté du nombre de cheminement pour imprimer des étiquettes de liste de sélection. "
      ,"Liste der aufspürenzahlen, die Abschnitte aber erfüllt, noch im Inszenierungbereich sind haben. Auserwähltes checkbox nahe bei der aufspürenzahl zum Drucken der Auswahlliste Kennsätze."};
  public final static String STAGE_AREA_PICK_SUBMIT[] = { ""
      ,"Submit selected"
      ,"Sométase escogido"
      ,"Soumettre choisi"
      ,"Reichen Sie ausgewählt ein"};
  public final static String STAGE_AREA_PICK_SUBMIT_ALL[] = { ""
      ,"Submit All"
      ,"Sométase Todo"
      ,"Soumettre Tout"
      ,"Reichen Sie Alle ein"};
  public final static String STAGE_AREA_PICK_SUBMIT_EMPTY[] = { ""
      ,"Choose a different Staging Area"
      ,"Escoja una Area diferente que Prepara"
      ,"Choisir un Domaine différent qui monte"
      ,"Wählen Sie Ein Verschiedenes Inszenierendes Gebiet"};
  public final static String STAGE_AREA_PICK_NO_DATA[] = {""
      ,"No Data to Display"
      ,"Ningunos datos a visualizar"
      ,"Aucunes données à afficher"
      ,"Keine anzuzeigenden Daten"};
  public final static String STAGE_AREA_PICK_STAGE_AREA[]=STAGING_AREA;
  public final static String STAGE_AREA_PICK_CHOOSE [] = {""
      ,"Choose"
      ,"Elija"
      ,"Choisissez"
      ,"Wählen Sie"};
  public final static String STAGE_AREA_PICK_TRACKING_NBR [] = {""
      ,"Tracking Number"
      ,"Seguir Número"
      ,"Cheminement Du Nombre"
      ,"Gleichlauf Von Zahl"};
  public final static String STAGE_AREA_PICK_DETAINMENT_LOC [] = {""
      ,"Detainment Loc"
      ,"Localización De la Detención"
      ,"Emplacement De Détention"
      ,"ZurückbehaltungStandort"};
  public final static String STAGE_AREA_PICK_NO_PACKAGE [] = {""
      ,"No Packages to display"
      ,"Ningunos conjuntos a visualizar"
      ,"Aucuns modules à afficher"
      ,"Keine anzuzeigenden Pakete"};
  public final static String STAGE_AREA_PICK_STATUS [] = GENERIC_STATUS_STATUS_OR_LOCATION;
  //stage in
  public final static String STAGEIN_INPUT_PAGE_TITLE[] = { ""
      ,"Stage In Input Page"
      ,"Etapa En La Paginación De la Entrada de información"
      ,"Étape En Page D'Entrée"
      ,"Stadium In der InputSeite"};
  public final static String STAGEIN_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage In"
      ,"Seleccione el área correcta de la etapa y después incorpore unos o más Número El Seguir para la etapa adentro"
      ,"Choisissez la région correcte d'étape et puis écrivez un ou plusieurs Nombre De Cheminement pour l'étape dedans"
      ,"Wählen Sie den korrekten Stadium Bereich aus und geben Sie dann ein oder mehr GleichlaufZahl für Stadium innen ein"};
  public final static String STAGEIN_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEIN_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEIN_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Detainment location"
      ,"Localización de la detención"
      ,"Emplacement de détention"
      ,"Zurückbehaltungstandort"};
  //stage out
  public final static String STAGEOUT_INPUT_PAGE_TITLE[] = {""
      ,"Stage Out Input Page"
      ,"Etapa Fuera De la Paginación De la Entrada de información"
      ,"Étape Hors De Page D'Entrée"
      ,"Stadium Aus InputSeite"};
  public final static String STAGEOUT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage Out"
       + "<p>" + "Printer: "
      ,"Seleccione el área correcta de la etapa y después incorpore unos o más Número El Seguir para la etapa hacia fuera"
       + "<p>" + "Impresora: "
      ,"Choisissez la région correcte d'étape et puis écrivez un ou plusieurs Nombre De Cheminement pour l'étape dehors"
       + "<p>" + "Imprimante: "
      ,"Wählen Sie den korrekten Stadium Bereich aus und geben Sie dann ein oder mehr GleichlaufZahl für Stadium heraus ein"
       + "<p>" + "Drucker: "};
  public final static String STAGEOUT_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEOUT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEOUT_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  //stage out STRIP
  public final static String STAGEOUTSTRIP_INPUT_PAGE_TITLE[] = {""
      ,"Stage Out Strip Input Page"
      ,"Etapa Fuera De la Paginación De la Entrada de información De la Tira"
      ,"Étape Hors De Page D'Entrée De Bande"
      ,"Stadium Aus StreifenInputSeite"};
  public final static String STAGEOUTSTRIP_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Select the correct Stage Area and then enter one or more Tracking Number for Stage Out Strip"
       + "<p>" + "Printer: "
      ,"Seleccione el área correcta de la etapa y después entre en uno o más que sigue el número para la etapa fuera de la tira"
       + "<p>" + "Impresora: "
      ,"Choisissez la région correcte d'étape et puis entrez dans un ou plusieurs qui dépiste le nombre pour l'étape hors de la bande"
       + "<p>" + "Imprimante: "
      ,"Wählen Sie den korrekten Stadium Bereich aus und betreten Sie dann eins oder mehr, die aufspüren Zahl für Stadium aus Streifen"
       + "<p>" + "Drucker: "};
  public final static String STAGEOUTSTRIP_CODE_INSTRUCTIONS[] = STAGING_AREA;
  public final static String STAGEOUTSTRIP_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAGEOUTSTRIP_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
    // corporate STAT Scan
  public final static String STAT_INPUT_PAGE_TITLE[] = {""
      ,"Status (STAT) Input Page"
      ,"Página de la entrada del (STAT) del estado"
      ,"Page d'entrée de (STAT) de statut"
      ,"Status (STAT) Eingang Seite"};
  public final static String STAT_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT"
      ,"Incorpore AWB para agregar el STAT"
      ,"Écrivez AWB pour ajouter le STAT"
      ,"Tragen Sie AWB ein, um STAT zu addieren"};
  public final static String STAT_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT_SINGLE_LINE_INSTURCTIONS[] = { ""
      ,"Comments or Reason"
      ,"Comentarios o razón"
      ,"Commentaires ou raison"
      ,"Anmerkungen oder Grund"};
    /*public final static String STAT_SUBMIT2_PROMPT[] = { ""
    ,"Choose different printer"
    ,"Elija diversa impresora"
    ,"Choisissez différente l'imprimante"
    ,"Wählen Sie unterschiedlichen Drucker "};*/
  /*public final static String STAT_ADDITIONAL_INFO[] = { ""
      ,"Additional Information *"
      ,"Información Adicional *"
      ,"L'Information Additionnelle *"
      ,"Zusätzliche Informationen *"};
  public final static String STAT_ADDITIONAL_INFO_EXPLAIN[] = { ""
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "
      ,"*  STAT 68 = Routing, STAT 69 = ASTRAY, STAT 77 = MDE Routing, STAT 85 & 90 = Flt Number, Flt Date "};
      */
      // corporate STAT37 Scan
  public final static String STAT37_INPUT_PAGE_TITLE[] = {""
      ,"Status 37 (STAT 37) Input Page"
      ,"Página de la entrada del (STAT 37) del estado"
      ,"Page d'entrée de (STAT 37) de statut"
      ,"Status (STAT 37) Eingang Seite"};
  public final static String STAT37_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 37"
      ,"Incorpore AWB para agregar el STAT 37"
      ,"Écrivez AWB pour ajouter le STAT 37"
      ,"Tragen Sie AWB ein, um STAT 37 zu addieren"};
  public final static String STAT37_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT37_CODE_INSTRUCTIONS[] = { ""
      ,"Package Condition"
      ,"Condición Del Paquete"
      ,"État De Paquet"
      ,"Paket-Zustand"};
  public final static String STAT37_CODE_A[] = { ""
      ,"Crushed"
      ,"Machacado"
      ,"Écrasé"
      ,"Zerquetscht"};
  public final static String STAT37_CODE_B[] = { ""
      ,"Wet"
      ,"Mojado"
      ,"Humide"
      ,"Naß"};
  public final static String STAT37_CODE_C[] = { ""
      ,"Torn"
      ,"Rasgado"
      ,"Déchiré"
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
      ,"Página de la entrada del (STAT 68 or 77) del estado"
      ,"Page d'entrée de (STAT 68 or 77) de statut"
      ,"Status (STAT 68 or 77) Eingang Seite"};
  public final static String STAT6877_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 68 or 77"
      ,"Incorpore AWB para agregar el STAT 68 or 77"
      ,"Écrivez AWB pour ajouter le STAT 68 or 77"
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
      ,"Página de la entrada del (STAT 69) del estado"
      ,"Page d'entrée de (STAT 69) de statut"
      ,"Status (STAT 69) Eingang Seite"};
  public final static String STAT69_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 69"
      ,"Incorpore AWB para agregar el STAT 69"
      ,"Écrivez AWB pour ajouter le STAT 69"
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
      ,"Página de la entrada del (STAT 85 & 90) del estado"
      ,"Page d'entrée de (STAT 85 & 90) de statut"
      ,"Status (STAT 85 & 90) Eingang Seite"};
  public final static String STAT8590_INPUT_PAGE_INSTRUCTIONS[] = { ""
      ,"Enter AWB to add STAT 85 or 90"
      ,"Incorpore AWB para agregar el STAT 85 or 90"
      ,"Écrivez AWB pour ajouter le STAT 85 or 90"
      ,"Tragen Sie AWB ein, um STAT 85 or 90 zu addieren"};
  public final static String STAT8590_AWB_INSTURCTIONS[] = TRACKING_NUMBER;
  public final static String STAT8590_SINGLE_LINE_INSTURCTIONS1[] = { ""
      ,"Flight Number"
      ,"Número De Vuelo"
      ,"Numéro De Vol"
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
    ,"Ccii Menú"
    ,"Ccii Menu"
    ,"Ccii Menü"};
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
    ,"Intercepción"
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
    ,"États"
    ,"Reports"};
  public final static String TOP_MENU_SECURITY_ADMIN[] = {""
    ,"Security Admin"
    ,"Seguridad Admin"
    ,"Sécurité Admin"
    ,"Sicherheit Admin"};
  public final static String TOP_MENU_LOGOFF[] = {""
    ,"Logoff"
    ,"Término de sesión"
    ,"Fermeture de session"
    ,"Logoff"};
//Warehouse ID label
  public final static String WAREHOUSEID_TITLE[] = { ""
    ,"Warehouse ID Label"
    ,"Etiqueta de la Identificación Del Almacén "
    ,"Étiquette d'Identification D'Entrepôt"
    ,"Aufkleber Des Lager-Identifikation"};
  public final static String WAREHOUSEID_PAGE_INSTRUCTIONS[] = PRINTER_PROMPT;
  public final static String WAREHOUSEID_CODE_INSTRUCTIONS[] = WAREHOUSE_CODE;
  public final static String WAREHOUSEID_SUBMIT2_PROMPT[] = CHOOSE_DIFFERENT_PRINTER;
  public final static String WAREHOUSEID_EXCEPTION_ALL_WAREHOUSES[] = {""
    ,"All warehouses"
    ,"Todos los almacenes"
    ,"Tous les entrepôts"
    ,"Alle Lager"};

  public CCIILanguages()
  {
  }
}
