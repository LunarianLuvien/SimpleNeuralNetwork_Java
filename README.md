# Iris Flower Classification Neural Network

This Java program implements a neural network for classifying Iris flowers into three species: Iris-setosa, Iris-versicolor, and Iris-virginica. The neural network utilizes a training algorithm to adjust the weights of neurons for improved accuracy.

## Overview
The neural network consists of three neurons, each corresponding to one Iris flower species. During training, the program adjusts neuron weights based on the input data representing sepal and petal measurements.

## Features
- **Dynamic Weight Adjustment:** Adjusts neuron weights during training to minimize classification errors.
- **Multiple Neuron Management:** Manages three separate neurons for distinct classification tasks.
- **Accuracy Measurement:** Calculates the classification accuracy after training epochs.

## Core Components
- **Neuron Class:** Defines neuron behavior, including weight initialization and output calculation.
- **ArtificialNeuralNetwork Class:** Manages neurons and conducts training using the provided input dataset.

## Workflow
1. **Initialization:** Each neuron's weights are initialized randomly.
2. **Training:** The network trains by adjusting weights based on the correct classification and the actual output.
3. **Accuracy Evaluation:** After training, the network's accuracy in classifying new data is calculated.

## Code Details
- **Neuron's Weight Adjustment:** Utilizes increase and decrease weight methods based on the discrepancy between expected and actual outputs.
- **Training Algorithm:** Employs a method to train neurons using an array of input values, which includes sepal length, sepal width, petal length, petal width, and the corresponding flower name.
- **Accuracy Calculation:** Computes how often the network correctly classifies the data across epochs to measure effectiveness.

## Usage
This simulation is useful for educational purposes in demonstrating how neural networks can be applied to real-world classification problems using Java. It provides hands-on experience with the foundational concepts of machine learning, including data preprocessing, learning rate adjustment, and performance evaluation.

## Example Execution
```java
public static void main(String[] args) {
    // Initialize and train the network, then print the accuracy
    String[][] inputs = loadIrisData(); // Assume this method loads the Iris dataset
    ArtificialNeuralNetwork ann = new ArtificialNeuralNetwork();
    ann.train(inputs, 50, 0.01); // 50 epochs with learning rate of 0.01
    double accuracy = ann.calculateAccuracy(inputs);
    System.out.println("Classification Accuracy: " + accuracy + "%");
}
