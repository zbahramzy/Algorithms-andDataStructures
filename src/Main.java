import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

// Binary Tree data structure
public class Main {
    // read data from a csv file and save it in arraylist
    public static List<String> readCSV(String fileName) {
        // store one line at a time from the csv file in this variable
        // then remove redundant characters before saving it in arraylist
        String row;
        //int controlSignal = 0;
        ArrayList<String> dataSet = new ArrayList<>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            while ((row = csvReader.readLine()) != null /*&& controlSignal < 200*/) {
                // remove last semicolon from each line
                row = row.substring(0, row.length()-4);
                // replace quotation marks with empty string
                row = row.replace("\"", "");
                dataSet.add(row);
                //controlSignal++;
            }
            csvReader.close();
            // remove header from dataset
            dataSet.remove(0);
            // sorting dataSet
            Collections.sort(dataSet);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        return dataSet;
    }

    public static void main(String[] args) {
        // csv file path
        String fileName = "/Users/zalandbahramzy/Programming/JavaProjects/DSVCaseProject2/CSV_File/steam-200k.csv";
        // dataset where redundant characters removed from csv file
        List<String> dataSet = readCSV(fileName);

        // some datasets that contains duplicates
        List<String> dataSet1 = divideList(dataSet,"100351493");
        List<String> dataSet2 = divideList(dataSet,"100894366");
        List<String> dataSet3 = divideList(dataSet,"101022115");
        List<String> dataSet4 = divideList(dataSet,"101695880");
        List<String> dataSet5 = divideList(dataSet,"101731521");
        List<String> dataSet6 = divideList(dataSet,"101878879");
        List<String> dataSet7 = divideList(dataSet,"10253354");
        List<String> dataSet8 = divideList(dataSet,"103624897");
        List<String> dataSet9 = divideList(dataSet,"105782521");
        List<String> dataSet10 = divideList(dataSet,"105877396");

        BinarySearchTree bST1 = new BinarySearchTree();
        bST1.add(dataSet1);
        bST1.printInorder();
        System.out.println();
        bST1.printSideways();
        System.out.println();
        System.out.println(bST1.contains("100351493,Portal Stories Mel,play,2.4"));
    }

    public static List<String> divideList(List<String> data, String ID) {

        List<String> newDataSet = new ArrayList<>();
        for (String row : data) {
            if (row.contains(ID)) {
                newDataSet.add(row);
            }
        }
        return newDataSet;
    }
}