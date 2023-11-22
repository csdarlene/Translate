package com.qualogy.scanner;

import java.util.*;
import java.util.stream.Collectors;

public class Input {
    String word;
    String nedWoord;
    String engWoord;
    String taal;
    String opt;
    public List<String> nederlands = new ArrayList<>();
    public List<String> engels = new ArrayList<>();
    public List<String> sortedList;

    public Map<String, String> translateEN = new HashMap<>();
    public Map<String, String> translateNE = new HashMap<>();

    String entities = """
            1- English to Dutch\s
            2- Dutch to English
            3- Go back
            0- Exit
            """;
    Scanner scanner = new Scanner(System.in);

    public void addDummyData() {
        if (engels.isEmpty() && nederlands.isEmpty()) {
            addWord("huis", "house");
            addWord("boom", "tree");
            addWord("zon", "sun");
            addWord("hond", "dog");
            addWord("vriend", "friend");
            addWord("auto", "car");
            addWord("tafel", "table");
            addWord("fiets", "bike");
            addWord("stad", "city");
            addWord("strand", "beach");
            addWord("telefoon", "phone");
            addWord("muziek", "music");
            addWord("koffie", "coffee");
            addWord("film", "movie");
            addWord("kleur", "color");
            addWord("kunst", "art");
            addWord("feest", "party");
        }
    }

    public void addOperation() {
        System.out.println("Type Dutch word");
         nedWoord = scanner.nextLine().toLowerCase();

        System.out.println("Type English word");
         engWoord = scanner.nextLine().toLowerCase();

        System.out.println(addWord(nedWoord, engWoord));
    }

    public String addWord(String nedWoord, String engWoord) {
        if (!nederlands.contains(nedWoord) && !engels.contains(engWoord)) {
            nederlands.add(nedWoord);
            engels.add(engWoord);

            translateNE.put(nedWoord, engWoord);
            translateEN.put(engWoord, nedWoord);

            return "\nAdded successfully.\n";
        }
        else {
            return "\nAlready exists in the dictionary.\n";
        }
    }


    public void find() {
            do {
                System.out.println(entities);
              opt= scanner.nextLine();
                switch (opt) {
                    case "0": {
                        System.exit(0);
                    }
                    case "1": {
                        findTranslation(translateEN);
                        break;
                    }
                    case "2": {
                        findTranslation(translateNE);
                        break;
                    }
                    case "3": {
                        return;
                    }
                    default: {
                        System.out.println("\nInvalid option\n");
                    }
                }
            } while (true);
    }

    private void findTranslation(Map<String, String> translationMap) {
        System.out.println("Type word");
        word = scanner.nextLine().toLowerCase();
        if (translationMap.containsKey(word)) {
            System.out.println("\nTranslation\n" +word +" --> "+translationMap.get(word)+"\n");
        }
        else System.out.println( "\nNot in the dictionary.");
    }

    public void dictionaryOperation() {
        System.out.println("\nDutch or English");
        taal = scanner.nextLine().toLowerCase();
        order(taal);
    }
    public void order(String taal) {
              if (taal.equals("dutch") || taal.equals("d") ) {
            sortedList = nederlands.stream().sorted().collect(Collectors.toList());
            System.out.println("\nDutch dictionary");

        } else if (taal.equals("english") || taal.equals("e") ) {
            sortedList = engels.stream().sorted().collect(Collectors.toList());
            System.out.println("\nEnglish dictionary");

        } else {
            System.out.println("\nInvalid language choice.");
            return;
        }
        System.out.println(sortedList);
    }

}

