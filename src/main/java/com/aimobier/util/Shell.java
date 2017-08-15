package com.aimobier.util;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Shell {

    public static void shell(SimpMessagingTemplate webSocket, String[] command){

        try {

            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;

            while ((s = reader.readLine()) != null) {

                webSocket.convertAndSend("/topic/greetings",s);
            }
        } catch (IOException e) {

            webSocket.convertAndSend("/topic/greetings",e.getLocalizedMessage());
        }
    }

    public static void shell(SimpMessagingTemplate webSocket, String[] command, String ... args){

        try {

            Process process = Runtime.getRuntime().exec(command);

            if (args.length > 0){

                PrintStream printStream = new PrintStream(process.getOutputStream());

                for (String arg: args){

                    printStream.println(arg);
                }

                printStream.flush();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;

            while ((s = reader.readLine()) != null) {

                webSocket.convertAndSend("/topic/greetings",s);
            }
        } catch (IOException e) {

            webSocket.convertAndSend("/topic/greetings",e.getLocalizedMessage());
        }
    }
}
