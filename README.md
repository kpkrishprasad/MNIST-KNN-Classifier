
# MNIST-KNN-CLASSIFIER

This repository contains a simple K-Nearest Neighbors (KNN) classifier for the MNIST dataset. The KNN classifier is implemented in Java and consists of four files: `KNNClassifier.java`, `MNISTReader.java`, `MyPriorityQueue.java`, and `dHeap.java`.

## Files

### KNNClassifier.java

This file contains the implementation of the KNNClassifier class, which is responsible for training the KNN model and making predictions on test data. The KNNClassifier class uses the MNISTReader class to load and preprocess the MNIST dataset. It also utilizes the MyPriorityQueue class, implemented using dHeap, for efficient nearest neighbor search.

### MNISTReader.java

MNISTReader is a utility class that provides methods for loading and preprocessing the MNIST dataset. It reads the MNIST image and label files, performs normalization and flattening of the images, and splits the dataset into training and testing sets.

### MyPriorityQueue.java

MyPriorityQueue is an implementation of a priority queue using a d-ary heap. It provides methods for inserting elements, removing the maximum element, clearing the queue, and checking if the queue is empty. The class is used by the KNNClassifier class for efficient k-nearest neighbor search.

### dHeap.java

dHeap is a generic implementation of a d-ary heap. It represents a heap data structure with a specified branching factor. The class provides methods for adding elements, removing the root element, clearing the heap, and retrieving the size of the heap. It is used by the MyPriorityQueue class as the underlying data structure for the priority queue.

## Usage

To use the MNIST KNN classifier, follow these steps:

1. Download the MNIST dataset files: `train-images.idx3-ubyte`, `train-labels.idx1-ubyte`, `t10k-images.idx3-ubyte`, `t10k-labels.idx1-ubyte`.

2. Make sure the four Java files (`KNNClassifier.java`, `MNISTReader.java`, `MyPriorityQueue.java`, and `dHeap.java`) are in the same directory.

3. Compile the Java files: 
   ```
   javac KNNClassifier.java
   ```

4. Run the KNNClassifier program:
   ```
   java KNNClassifier
   ```

The program will train the KNN model using the MNIST training dataset and make predictions on the MNIST test dataset. The accuracy of the KNN classifier will be displayed in the console.

Feel free to modify the code and experiment with different parameters to improve the classifier's performance.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```
