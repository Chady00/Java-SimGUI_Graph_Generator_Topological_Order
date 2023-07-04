## **Topological Order SimGUI**

A Java implementation of a topological sorting algorithm. It includes a class called TopologicalSort that implements the ThreeTenAlg interface. Here is a brief description of the project: 

*   The TopologicalSort class represents a simulation of a topological sorting algorithm. It uses the edu.uci.ics.jung.graph.Graph class from the JUNG library to represent the graph on which the algorithm runs. The class has instance variables for the graph, a priority queue of nodes, a sorted list of nodes, and other properties related to the algorithm's execution. The class implements various methods defined by the ThreeTenAlg interface, including reset, isStarted, start, finish, and others. The TopologicalSort class also defines additional methods required by the algorithm, such as selectNext, updateSuccessorCost, highlightNext, simplify, and main. These methods are responsible for selecting the next node with the best priority, updating the costs of successor nodes, highlighting the next node, simplifying the graph, and executing the algorithm step by step. 
*   The main method demonstrates the usage of the TopologicalSort class by creating a graph, adding vertices and edges to it, and running the topological sorting algorithm on the graph. 
*   Here are some of the main features:

1.  _Traverse in topological order:_ 

 ![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/55e87999364ed7708201efe55346b88155eb0dd4c8e5adce.png)

 2.  _Interactive UI:_

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/df36435146a3d2f11d20a761865a5fa4ab77b4733af29a98.png)

3\.  _Ability to edit, add,drag, and delete nodes and arcs:_

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/06f00f7fab2f2329133cc88298fe5efc5feb8b3a095c65dd.png)

4\.  _Add sustainable edges:_

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/4579ed67008d275692110ae72ce2e265fb1c0009416db14a.png)

5\.  _Ability to create any number of nodes:_

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/23c524b3de61203aa376e25cb5d938a9d32e7eab457a6e68.png)

6\.  _Go as complex as you want!_

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/1e3b1dd50fa2db49a10171209de0066659a25e114af13e36.png)
