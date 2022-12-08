package com.sas.directoryCrawler;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner grab = new Scanner(System.in);
        System.out.println("+--------------------------------+");
        System.out.println("|        DirectoryCrawler        |");
        System.out.println("|           - by SAS -           |");
        System.out.println("|                                |");
        System.out.println("|  Scans Given Paths And Output  |");
        System.out.println("|  Full Paths Of Detected Files  |");
        System.out.println("+--------------------------------+");
        System.out.print("\nEnter Full Path(s) separated by ';' : \n> ");
        String input = grab.next() + grab.nextLine();

        DIRCrawler crawler = new DIRCrawler();
        String output = crawler.crawl(input);
        String[] outputArr = stringToArr(output,';');

        System.out.println("===========================\nDetected Files \n===========================");
        for (String eString : outputArr) {
            System.out.println(eString);
        }

        System.out.println("===========================\nSingle Line Output \n===========================");
        System.out.println(output);

    }

    private static String[] stringToArr(String string , char separatorCharacter) {

        char[] stringCharArr = string.toCharArray();
        int numOfStrings = 1;

        String[] outArr = null;
        int outArrPlaceValue = 0;
        String tempOutString = "";

        // Calculate the number of strings in the multi string
        for (char echar : stringCharArr) {
            if (echar == separatorCharacter) {
                numOfStrings++;
            }
        }
        // Set output array
        outArr = new String[numOfStrings];

        // Assign values to array
        for (char echar : stringCharArr) {
            if (echar == separatorCharacter) {
                outArr[outArrPlaceValue] = tempOutString;
                tempOutString = "";
                outArrPlaceValue++;
            } else {
                tempOutString += echar;
            }
        }
        outArr[outArrPlaceValue] = tempOutString;
        tempOutString = "";

        return outArr;
    }



}