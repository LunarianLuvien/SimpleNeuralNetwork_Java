import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class Main {

    // This function conducts the experiments
    public static double conductExperiment(String[][] inputs, int epochCount, double lambda) {
        // Performs the specified number of epochs and updates weights based on lambda

        ArtificialNeuralNetwork neuralNet = new ArtificialNeuralNetwork(); // Each experiment uses a new neural network with different initial random weights
        for (int i = 0; i < epochCount; i++) { // Trains our neuron for the given number of epochs
            neuralNet.trainNeuron(inputs, lambda);
        }
        double accuracyRate = neuralNet.calculateAccuracy(inputs); // After training the neuron, we find the accuracy rate of that experiment.
        return accuracyRate;
    }

    public static void main(String[] args) {

        // We hold the inputs from the file in a 150 x 5 matrix to use repeatedly.
        String[][] inputs = new String[150][5];
        ArtificialNeuralNetwork neuralNet1 = new ArtificialNeuralNetwork();
        Scanner inputText = null;

        try { // used to open the file
            inputText = new Scanner(new FileInputStream("iris.data"));
        } catch (FileNotFoundException e) { // throws an error if the file is not found and exits the system.
            System.out.println("File not found");
            System.exit(0);
        }
        int row = -1; // variable that holds the row to be read

        while (inputText.hasNextLine()) { // continues as long as there is data in our file
            row++;
            String[] arr = inputText.nextLine().split(",");

            for (int column = 0; column < 5; column++) {

                if (column != 4) { // This will be the case for double values, we cannot take the name into this category. The place where we separate it
                    double newValue = Double.valueOf(arr[column]);
                    newValue = newValue / 10;  // The place where we scale the input values to [0, 1]
                    String value = String.valueOf(newValue);
                    arr[column] = value;
                }
                inputs[row][column] = arr[column]; // we update our inputs matrix, (held as String)
            }
        }

        for (int i = 0; i < 50; i++) {
            neuralNet1.trainNeuron(inputs, 0.01);
        }

        double resultFirst50EpochsLambda001 = conductExperiment(inputs, 50, 0.01);
        // We train our neuron 50 times with a lambda value of 0.01 and print it
        System.out.printf("Outcome of the experiment after 50 epochs, lambda 0.01: %.2f", resultFirst50EpochsLambda001);
        System.out.println("");
        System.out.println("");

        // We implement 27 different combinations for our first experiment (changing lambda and epoch count)
        // and save them. We will use these values to create a table
        double resultTwentyEpochsLambda001 = conductExperiment(inputs, 20, 0.01);
        double resultOneHundredEpochsLambda001 = conductExperiment(inputs, 100, 0.01);

        double resultTwentyEpochsLambda0005 = conductExperiment(inputs, 20, 0.005);
        double resultOneHundredEpochsLambda0005 = conductExperiment(inputs, 100, 0.005);
        double resultFiftyEpochsLambda0005 = conductExperiment(inputs, 50, 0.005);

        double resultTwentyEpochsLambda0025 = conductExperiment(inputs, 20, 0.025);
        double resultOneHundredEpochsLambda0025 = conductExperiment(inputs, 100, 0.025);
        double resultFiftyEpochsLambda0025 = conductExperiment(inputs, 50, 0.025);

        // We save the first experiment results to an array created for experiment1 to print in a table
        double[][] firstExperimentResults = {{resultTwentyEpochsLambda0005, resultTwentyEpochsLambda001, resultTwentyEpochsLambda0025},
                {resultFiftyEpochsLambda0005, resultFirst50EpochsLambda001, resultFiftyEpochsLambda0025},
                {resultOneHundredEpochsLambda0005,  resultOneHundredEpochsLambda001, resultOneHundredEpochsLambda0025}};

        System.out.println("First experiment results (in order)");
        // We print the first experiment results in a table format
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%.2f ", firstExperimentResults[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");

        // We implement 27 different combinations for our second experiment (changing lambda and epoch count)
        // and save them. We will use these values to create a table
        double resultSecondFiftyEpochsLambda001 = conductExperiment(inputs, 50, 0.01);
        double resultSecondTwentyEpochsLambda001 = conductExperiment(inputs, 20, 0.01);
        double resultSecondOneHundredEpochsLambda001 = conductExperiment(inputs, 100, 0.01);

        double resultSecondTwentyEpochsLambda0005 = conductExperiment(inputs, 20, 0.005);
        double resultSecondOneHundredEpochsLambda0005 = conductExperiment(inputs, 100, 0.005);
        double resultSecondFiftyEpochsLambda0005 = conductExperiment(inputs, 50, 0.005);

        double resultSecondTwentyEpochsLambda0025 = conductExperiment(inputs, 20, 0.025);
        double resultSecondOneHundredEpochsLambda0025 = conductExperiment(inputs, 100, 0.025);
        double resultSecondFiftyEpochsLambda0025 = conductExperiment(inputs, 50, 0.025);

        // We save the second experiment results to an array created for experiment2 to print in a table
        double[][] secondExperimentResults = {{resultSecondTwentyEpochsLambda0005, resultSecondTwentyEpochsLambda001, resultSecondTwentyEpochsLambda0025},
                {resultSecondFiftyEpochsLambda0005, resultSecondFiftyEpochsLambda001, resultSecondFiftyEpochsLambda0025},
                {resultSecondOneHundredEpochsLambda0005,  resultSecondOneHundredEpochsLambda001, resultSecondOneHundredEpochsLambda0025}};

        System.out.println("Second experiment results (in order)");
        // We print the second experiment results in a table format
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%.2f ", secondExperimentResults[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");

        // We implement 27 different combinations for our third experiment (changing lambda and epoch count)
        // and save them. We will use these values to create a table
        double resultThirdFiftyEpochsLambda001 = conductExperiment(inputs, 50, 0.01);
        double resultThirdTwentyEpochsLambda001 = conductExperiment(inputs, 20, 0.01);
        double resultThirdOneHundredEpochsLambda001 = conductExperiment(inputs, 100, 0.01);

        double resultThirdTwentyEpochsLambda0005 = conductExperiment(inputs, 20, 0.005);
        double resultThirdOneHundredEpochsLambda0005 = conductExperiment(inputs, 100, 0.005);
        double resultThirdFiftyEpochsLambda0005 = conductExperiment(inputs, 50, 0.005);

        double resultThirdTwentyEpochsLambda0025 = conductExperiment(inputs, 20, 0.025);
        double resultThirdOneHundredEpochsLambda0025 = conductExperiment(inputs, 100, 0.025);
        double resultThirdFiftyEpochsLambda0025 = conductExperiment(inputs, 50, 0.025);

        // We save the third experiment results to an array created for experiment3 to print in a table
        double[][] thirdExperimentResults = {{resultThirdTwentyEpochsLambda0005, resultThirdTwentyEpochsLambda001, resultThirdTwentyEpochsLambda0025},
                {resultThirdFiftyEpochsLambda0005, resultThirdFiftyEpochsLambda001, resultThirdFiftyEpochsLambda0025},
                {resultThirdOneHundredEpochsLambda0005,  resultThirdOneHundredEpochsLambda001, resultThirdOneHundredEpochsLambda0025}};

        System.out.println("Third experiment results (in order)");
        // We print the third experiment results
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%.2f ", thirdExperimentResults[i][j]);
            }
            System.out.println("");
        }
    }
}
