package de.hsa.games.fastsquirrel.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

class CommandScanner {

    private CommandTypeInfo[] commandTypeInfos;
    private BufferedReader inputStream;
    PrintStream outputStream;

    Command next() throws ScanExceptions{
        String input = null;
        String[] splitedInput = new String[0];

        try {
            input = inputStream.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        splitedInput = input.split(" ");

        for (int i = 0; i <= commandTypeInfos.length - 1; i++) {
            if (commandTypeInfos[i].getName().equals(splitedInput[0])) {
                Class<?>[] param = commandTypeInfos[i].getParamTypes();
                if (param.length != 0) {
                    Object[] paramArr = new Object[splitedInput.length];
                    for (int j = 1; j <= splitedInput.length - 1; j++) {
                        try {
                            switch (param[j - 1].getName()) {
                                case "int":
                                    paramArr[j - 1] = Integer.parseInt(splitedInput[j]);
                                    break;
                                case "float":
                                    paramArr[j - 1] = Float.parseFloat(splitedInput[j]);
                                    break;
                                case "java.lang.String":
                                    paramArr[j - 1] = splitedInput[j];
                                    break;
                                default:
                                    break;

                            }
                        } catch (NumberFormatException e) {
                            throw new ScanExceptions("parameter " + j + " got the wrong data type");
                        }
                    }
                    return new Command(commandTypeInfos[i], paramArr);
                }

            }
        }
        throw new ScanExceptions("no existing command");

    }

    CommandScanner(CommandTypeInfo[] commandTypeInfo, BufferedReader inputStream) {
        this.commandTypeInfos = commandTypeInfo;
        this.inputStream = inputStream;
    }

}