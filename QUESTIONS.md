# Reflection Questions

Answer these questions thoroughly after completing the assignment, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

Compare the difficulty integrating (that is, connecting new code into the existing structure) the new apportionment features (Hamilton and Huntington-Hill) to code in HW3 vs. integrating Excel support to your code in HW1 Part 2. Which change was easier? Justify your answer. Answer this question honestly! If you think Prof. McBurney's design sucks and is hard to work with, we want to know! (If members of your HW3 group was on different teams for HW1, then they should answer this question separately.)

## Answer 1
Well, the answer is quite clear to me. This task is significantly easier than the implementation in HW1 part 2. One key factor is that I wasn't initially prepared for HW1 part 2, so in HW1, I created a function for reading CSV files but not Excel files. Changing this function later turned out to be quite challenging. If I had known that we would need to implement another file reader, I would have designed a function to determine the file type and return the appropriate file reader for each type. (I'm aware we learned about the factory, but I'm trying to envision my approach at that time).

The primary reason this homework is more manageable is due to the well-structured program design. Firstly, we have an interface called "ApportionMethod" with predefined functions. Additionally, we have different methods implemented as separate classes, making the code more readable. Lastly, we have a factory that takes a flag and returns the desired method. These elements simplify the implementation of the Huntington method.

Another contributing factor is that the Jefferson and Adams methods have already been implemented. As a result, I could essentially copy some of the existing code and modify it to meet the requirements of the current homework.
## Question 2

What is the benefit of the Factory classes that handle instantiating the relevant objects? How this could make future changes easier? Be specific about what could you could expect to change.

## Answer 2
Factory classes offer several benefits in software design. One key advantage is improved maintainability. When I need to change the way objects are instantiated or introduce new object types, I can make these adjustments within the factory class, rather than scattering object creation code throughout your application. Using the code in ApportionmentMethodFactory.java as an example. Let's say today I want to implement a new method called "Hank method", after finish writing my HankMethod.java class, I just need to add a new case into the factory:
```java
case ("hank"):
                return new HankMethod();
```
As showed, adding a new method is a straightforward process. I don't need to make changes elsewhere or look for scattered code throughout the application. The factory pattern ensures that object creation remains organized and maintainable.
