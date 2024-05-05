import java.util.Random;

public class Neuron {

    private double[] weights; // Only the weights of the neuron objects will be stored, and there will be 4 weights

    public Neuron(){
        // When a Neuron object is first created, all weights are randomly assigned
        weights = new double[4];
        Random random = new Random(); // [0, 1)
        for(int i = 0; i < weights.length; i++){
            weights[i] = random.nextDouble();
        }
    }

    public double findOutput(double[] inputs) { // This method calculates the output of the neuron. It multiplies
        // the corresponding weights with the inputs to produce a result and returns it.

        double total = 0;
        for(int i = 0; i < 4; i++){
            total += inputs[i] * weights[i];
        }
        return total;
    }

    public double[] getWeights() {
        return weights;
    }

    // Function to increase the weight of the neuron by a given lambda value
    public void increaseWeight(double[] weights, double[] inputs, double lambda) {
        for(int i = 0; i < weights.length; i++){
            weights[i] = weights[i] + (lambda * inputs[i]);
        }
    }

    // Function to decrease the weight of the neuron by a given lambda value
    public void decreaseWeight(double[] weights, double[] inputs, double lambda) {
        for(int i = 0; i < weights.length; i++){
            weights[i] = weights[i] - (lambda * inputs[i]);
        }
    }
}
