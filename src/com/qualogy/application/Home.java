package com.qualogy.application;


import com.qualogy.scanner.Input;
import java.util.Scanner;

public class Home {

    Scanner scanner = new Scanner(System.in);
    Input input = new Input();
    String entities = """
            1- Translate\s
            2- Add
            3- Dictionary
            0- Exit
            """;

    public void home() {

        do {
            input.addDummyData();
            System.out.println(entities);
            String opt = scanner.nextLine();
            {
                switch (opt) {
                    case "0": {
                        System.exit(0);
                    }
                    case "1": {
                        input.find();
                        break;
                    }
                    case "2": {
                        input.addOperation();
                        break;
                    }

                    case "3": {
                        input.dictionaryOperation();
                        break;
                    }
                    default: {
                        System.out.println("\nInvalid option\n");
                    }
                }
            }
        }
        while (true);
    }
}
