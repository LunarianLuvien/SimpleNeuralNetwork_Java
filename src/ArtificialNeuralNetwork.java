public class ArtificialNeuralNetwork {

    // There will be 3 different neurons for 3 different types of flowers in our neural network class
    private Neuron setosa;
    private Neuron versicolor;
    private Neuron virginica;

    public ArtificialNeuralNetwork() { // Neurons are created in the constructor
        setosa = new Neuron();
        versicolor = new Neuron();
        virginica = new Neuron();
    }

    public void trainNeuron(String[][] inputs, double lambda) { // Method to train the neuron,
        // loops for the length of the input set and completes one epoch

        for (int i = 0; i < inputs.length; i++) { // inputs.length = 150;

            // Temporarily holds the current input values
            double sepalLength = Double.valueOf(inputs[i][0]);
            double sepalWidth = Double.valueOf(inputs[i][1]);
            double petalLength = Double.valueOf(inputs[i][2]);
            double petalWidth = Double.valueOf(inputs[i][3]);
            String name = inputs[i][4];

            // Inputs are set as numerical values to the function that finds the neuron output
            double[] dataSet = {sepalLength, sepalWidth, petalLength, petalWidth};

            // Expected values are initialized to 0 at the beginning of each loop
            int expectedSetosa = 0;
            int expectedVersicolor = 0;
            int expectedVirginica = 0;

            // Outputs for the three flower neurons are found separately
            double outputSetosa = setosa.findOutput(dataSet);
            double outputVersicolor = versicolor.findOutput(dataSet);
            double outputVirginica = virginica.findOutput(dataSet);

            double maxValue = -1; // Impossible starting condition for finding the max value

            // Update expected values based on the input name
            if (name.equals("Iris-setosa")) {
                expectedSetosa = 1;
            } else if (name.equals("Iris-versicolor")) {
                expectedVersicolor = 1;
            } else if (name.equals("Iris-virginica")) {
                expectedVirginica = 1;
            }

            // Determine which neuron produced the highest output
            if (outputSetosa >= outputVersicolor && outputSetosa >= outputVirginica) {
                maxValue = outputSetosa;
            } else if (outputVersicolor >= outputSetosa && outputVersicolor >= outputVirginica) {
                maxValue = outputVersicolor;
            } else if (outputVirginica >= outputSetosa && outputVirginica >= outputVersicolor) {
                maxValue = outputVirginica;
            }

            // If the highest output is from setosa but the input is not setosa
            if (maxValue == outputSetosa && expectedSetosa != 1) {
                if (expectedVersicolor == 1) {
                    versicolor.increaseWeight(versicolor.getWeights(), dataSet, lambda);
                } else if (expectedVirginica == 1) {
                    virginica.increaseWeight(virginica.getWeights(), dataSet, lambda);
                }
                setosa.decreaseWeight(setosa.getWeights(), dataSet, lambda);
            } else if (maxValue == outputVirginica && expectedVirginica != 1) {
                if (expectedVersicolor == 1) {
                    versicolor.increaseWeight(versicolor.getWeights(), dataSet, lambda);
                } else if (expectedSetosa == 1) {
                    setosa.increaseWeight(setosa.getWeights(), dataSet, lambda);
                }
                virginica.decreaseWeight(virginica.getWeights(), dataSet, lambda);
            } else if (maxValue == outputVersicolor && expectedVersicolor != 1) {
                if (expectedSetosa == 1) {
                    setosa.increaseWeight(setosa.getWeights(), dataSet, lambda);
                } else if (expectedVirginica == 1) {
                    virginica.increaseWeight(virginica.getWeights(), dataSet, lambda);
                }
                versicolor.decreaseWeight(versicolor.getWeights(), dataSet, lambda);
            }
        }
    }

    public double calculateAccuracy(String[][] inputs) { // Returns the accuracy rate obtained after 1 epoch

        int correctCount = 0; // Holds the number of correct answers after 1 epoch (150 iterations)

        for (int i = 0; i < inputs.length; i++) { // Processes for the length of the input set

            // Holds values for each row and generates output values using the function
            double sepalLength = Double.valueOf(inputs[i][0]);
            double sepalWidth = Double.valueOf(inputs[i][1]);
            double petalLength = Double.valueOf(inputs[i][2]);
            double petalWidth = Double.valueOf(inputs[i][3]);
            String name = inputs[i][4];

            double[] dataSet = {sepalLength, sepalWidth, petalLength, petalWidth};

            // Expected values are reset to 0 at the start of each loop
            int expectedSetosa = 0;
            int expectedVersicolor = 0;
            int expectedVirginica = 0;

            // Generate output values for the three flower neurons
            double outputSetosa = setosa.findOutput(dataSet);
            double outputVersicolor = versicolor.findOutput(dataSet);
            double outputVirginica = virginica.findOutput(dataSet);

            double maxValue = -1; // Impossible starting condition for finding the max value, updated each loop

            // Update expected value based on input name
            if (name.equals("Iris-setosa")) {
                expectedSetosa = 1;
            } else if (name.equals("Iris-versicolor")) {
                expectedVersicolor = 1;
            } else if (name.equals("Iris-virginica")) {
                expectedVirginica = 1;
            }

            // Determine the neuron with the highest output
            if (outputSetosa >= outputVersicolor && outputSetosa >= outputVirginica) {
                maxValue = outputSetosa;
            } else if (outputVersicolor >= outputSetosa && outputVersicolor >= outputVirginica) {
                maxValue = outputVersicolor;
            } else if (outputVirginica >= outputSetosa && outputVirginica >= outputVersicolor) {
                maxValue = outputVirginica;
            }

            // Accuracy means the plant type from the input (expected value) matches the neuron with the highest output
            if (maxValue == outputSetosa && expectedSetosa == 1) {
                correctCount++;
            } else if (maxValue == outputVirginica && expectedVirginica == 1) {
                correctCount++;
            } else if (maxValue == outputVersicolor && expectedVersicolor == 1) {
                correctCount++;
            }
        }
        return (correctCount * 100.0) / inputs.length;
    }
}
