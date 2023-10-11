[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/ma-cxrlC)


# Homework 3 - Incremental Development

## Authors
1) Han Lin, ezp9xp, HankkLin

## To Run

### Prerequisites

Before running the application, make sure you have the following:

- Java 17 or higher installed on your system.

### Building the Application

To build the file, run the following command in your terminal to build the jar:

```bash
./gradlew build
```
After the build is successful, you'll find the Apportionment.jar file in the build/lib directory.

### Running the Application
To execute the JAR file, use the following command:
```bash
java -jar Apportionment.jar <filename> [number of representatives to allocate]
```
* \<filename\> is the file needed that the user wants to read, and it can be either in CSV, XLSX, or XLS format.
* [number of representatives to allocate] is an optional integer argument. The default number of representatives is 435 if no value is provided.

### Flags
When executing, you can include different flags:

#### Method Flags
* --adams: Use the Adams method for allocating representatives.
* --jefferson: Use the Jefferson method for allocating representatives **(Default)**.
* --huntington: Use the Huntington Hill method for allocating representatives.

#### Format Flags
* --population: Allocate representatives based on population.
* --alphabet: Allocate representatives based on an alphabetical order **(Default)**. 
* --benefit: Allocate representatives based on the relative benefit.

#### Sequence Flags
For "--population" and "--benefit" formats, you can specify the sequence:
* --ascending or --a: Allocate in ascending order (Default for population).
* --descending or --d: Allocate in descending order (Default for benefit).

**Note**: The sequence flag is not applicable when using the --alphabet format.

#### Example:
```bash
# Using the Adams method with ascending population sequence
java -jar Apportionment.jar example.csv 435 --adams --population --ascending

# Using the default Jefferson method with alphabet format
java -jar Apportionment.jar example.xlsx

# Using the Huntington method with descending benefit sequence
java -jar Apportionment.jar example.xls 600 --huntington --benefit
```

## Contributions
All by me! All the code you see are written by me, including this README.md and QUESTIONS.md. 


## Issues
List any known issues (bugs, incorrect behavior, etc.) at the time of submission.
