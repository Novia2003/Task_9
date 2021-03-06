package ru.vsu.cs.novichikhin;

import ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Objects;

public class ConsoleMain {

    public static void main(String[] args) {
        CmdArgs.CmdParams params = CmdArgs.parseArgs(args);

        if (params.help) {
            printUsage(params);
        } else {
            if (params.window) {
                GuiMain.winMain();
            } else {
                makeNewList(params);
            }
        }
    }

    private static void printUsage(CmdArgs.CmdParams params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> -i <input-file> -o <output-file>");
        out.println("  <cmd> -i <input-file>");
        out.println("  <cmd> --help");
        out.println(" <cmd> --window");
        System.exit(params.error ? 1 : 0);
    }

    private static void makeNewList(CmdArgs.CmdParams params) {
        try {
            CreatingNewList creating = new CreatingNewList(ArrayUtils.readListFromFile(params.inputFile, 0),
                    ArrayUtils.readListFromFile(params.inputFile, 1));

            List<Integer> list = creating.createNewList();
            Objects.requireNonNull(list);

            printResult(params, list);
        } catch (Exception e) {
            printError();
        }
    }

    private static void printResult(CmdArgs.CmdParams params, List<Integer> list) throws FileNotFoundException {
        PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
        out.println(list);
        out.close();
    }

    private static void printError() {
        System.err.print("Данные в файле некоректны (в файле должно быть 2 строчки, причём во второй строчке" +
                " должен содержаться хотя бы один элемент из первой)");
        System.exit(1);
    }
}
