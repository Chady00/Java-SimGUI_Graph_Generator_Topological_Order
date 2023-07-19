## **Topological Order SimGUI**

A Java implementation of a topological sorting algorithm. It includes a class called TopologicalSort that implements the ThreeTenAlg interface. Here is a brief description of the project: 

*   The TopologicalSort class represents a simulation of a topological sorting algorithm. It uses the edu.uci.ics.jung.graph.Graph class from the JUNG library to represent the graph on which the algorithm runs. The class has instance variables for the graph, a priority queue of nodes, a sorted list of nodes, and other properties related to the algorithm's execution. The class implements various methods defined by the ThreeTenAlg interface, including reset, isStarted, start, finish, and others. The TopologicalSort class also defines additional methods required by the algorithm, such as selectNext, updateSuccessorCost, highlightNext, simplify, and main. These methods are responsible for selecting the next node with the best priority, updating the costs of successor nodes, highlighting the next node, simplifying the graph, and executing the algorithm step by step. 
*   The main method demonstrates the usage of the TopologicalSort class by creating a graph, adding vertices and edges to it, and running the topological sorting algorithm on the graph. 
*   Here are some of the main features:

1.  _Traverse in topological order:_ 

![1](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/0ea9c6ed-4953-4222-a155-870d6794dfa0)

 2.  _Interactive UI:_
 
![2](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/20d693cb-ccbc-4234-9df7-c410822ae4b4)


3\.  _Ability to edit, add,drag, and delete nodes and arcs:_

![3](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/d1fbf5b4-0bf0-498b-99f8-758190b69e1c)


4\.  _Add sustainable edges:_

![4](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/382d128f-c3b6-458d-a67c-62ba7c096a54)


5\.  _Ability to create any number of nodes:_

![6](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/9b94c737-e563-4204-832b-944dfe3ab253)


6\.  _Go as complex as you want!_

![7](https://github.com/Chady00/Java-SimGUI_Topological_Order_Graph_Generator/assets/84717550/03af89cc-7a78-4039-ba5c-ae3074a2ace8)
