This repository gives you a simple practice on Design Patterns used by various software developers across the world.

# What is a Design Pattern?
Design patterns usually represent the best practices that are used by experienced object-oriented software developers. They provide solutions to general problems that software developers encounter during software development. Basically, it is a template to solve a problem that can be used in many different situations.

# Why need Design Patterns?
* Design patterns can speed up the development process since they provide tested, proven development paradigms

* Reusing the design patterns helps to prevent subtle issues which can bring major problems and improves the readability of codes for coders and architects to get familiarized with the patterns.

* They also provide general solutions, documented in a format that doesn't require specifics tied to a specified problem.

* Design Patterns also allow developers to communicate using well-known, well understood names for software interactions.
.............................................................................................................................................................................................................................................................................................

There is a long list of design patterns that are used by software developers currently. I have worked out 06 common design patterns in practice for my repository. Hope this may help you understand the design patterns to a certain extent.

# 1.	BUILDER
The Builder pattern separates the construction of a complex object from its representation so that the same construction process can create different representations. This pattern is used in this repository to create users which consist of ID, name, email and nationality. Using the builder design pattern make the process easier to create different users with many parameters. We are allowed to even leave out few parameters and the order of parameters also does not matter.

![BuilderwithoutLombok](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/UserCreatewithoutLombok.PNG?raw=true)
![BuilderwithLombok](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/UserLombok.PNG?raw=true)

# 2.	SINGLETON
The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. The repository contains the singleton class implemented by traditional method as well as using Spring method.

![](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/JUnitTest.PNG?raw=true)

# 3.	FACTORY
This pattern defines an interface that is used to create an object and lets the subclasses decide which class to instantiate. The Factory Method lets a class defer instantiation to subclasses. In the repository, different roles are created from the Role Factory having different access privileges. 

![Factory1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/addRoleMember.PNG?raw=true)
![Factory1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/addRoleAdmin.PNG?raw=true)
![Factory1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/addRoleErrorException.PNG?raw=true)

# 4.	FACADE
A façade provides a unified interface to a set of interfaces in a subsystem. It defines a higher-level interface that makes the subsystem easier to use since it hides the implementation complexity. This repository consists of a façade that hides the overall implementation at the back end and provides a simplified interface to the overall functionality of a complex subsystem.

![Builder1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/ConsoleaddRole.PNG?raw=true)

# 5.	STATE
This design pattern is basically an object-oriented state machine that allows an object to change its behavior when its internal state changes. The object will appear to change its class. This repository has the state changes in player attributes in terms of attack, defense and agility.

![Builder1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/StateOutput.PNG?raw=true)

# 6.	OBSERVER
The observer pattern is widely used when a specific group is interested on a change and they are notified automatically through this. A one-to-many relation is introduced when the observed object changes its internal state and all of its observers are automatically informed about this change of state. Here, the core (or common or engine) components are encapsulated in a Subject abstraction, and the variable (or optional or user interface) components are encapsulated in an Observer hierarchy. This repository uses the list of observers and the topic to illustrate Observer design pattern. This depicts how the registered observers are notified of any updates in a topic. 

![Builder1](https://github.com/FathimaShafana/SAD/blob/main/DesignPatternsLab/HW3_Screenshots/ObserverUpdate.PNG?raw=true)

## REFERENCE:
Sourcemaking.com.2021.Design Patterns and Refactoring. [online]. Available at <https://sourcemaking.com/design_patterns> [Accessed 13th February,2021]
