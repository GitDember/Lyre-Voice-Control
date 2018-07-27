package fr.dember.lvc.voice;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import edu.cmu.sphinx.util.props.PropertyException;
import fr.dember.lvc.Communication;
import fr.dember.lvc.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Detection {

    public static void DetectVocal(String[] args){

        boolean loop = true;
        
        boolean light = false;
        boolean tilt = false;
        boolean pan = false;
        
        try {
            URL url;
            if (args.length > 0) {
                url = new File(args[0]).toURI().toURL();
            } else {
                url = Detection.class.getResource("/fr/dember/lvc/voice/Configuration.config.xml");
            }

            System.out.println("Chargement ...");

            ConfigurationManager cm = new ConfigurationManager(url);

            Recognizer recognizer = (Recognizer) cm.lookup("recognizer");
            Microphone microphone = (Microphone) cm.lookup("microphone");

            recognizer.allocate();

            if (microphone.startRecording()) {

                while (loop) {
                    System.out.println("\nDétection en cours, en attente d'une instruction ...\n");

                    Result result = recognizer.recognize();

                    if (result != null) {
                        String resultText = result.getBestFinalResultNoFiller();
                        System.out.println("Retranscription: " + resultText + "\n");

                        if(resultText.equalsIgnoreCase("back")){
                            loop = false;
                        }else if(resultText.equalsIgnoreCase("light")){
                            if(light == false){
                                light = true;
                                Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("8") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("120") + "FSOC337255");
                            }else if(light == true){
                                light = false;
                                Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("8") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("0") + "FSOC337255");
                            }
                        }else if(resultText.equalsIgnoreCase("red")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("5") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("15") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("green")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("5") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("25") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("blue")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("5") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("35") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("white")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("5") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("0") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("up")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("3") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("125") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("down")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("3") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("0") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("left")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("1") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("125") + "FSOC337255");
                        }else if(resultText.equalsIgnoreCase("right")){
                            Communication.onSendData("FSOC335255" + Communication.getControlsFromNumber("1") + "FSOC332255FSOC333255" + Communication.getControlsFromNumber("0") + "FSOC337255");
                        }
                        
                        

                    } else {
                        System.out.println("Retranscription impossible !\n");
                    }
                }
            } else {
                System.out.println("Aucun microphone !");
                recognizer.deallocate();
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Problème lors du chargement de la détection: " + e);
            e.printStackTrace();
        } catch (PropertyException e) {
            System.err.println("Problème de configuration de la détection: " + e);
            e.printStackTrace();
        }

    }

}
