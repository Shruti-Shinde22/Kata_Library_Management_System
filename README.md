# Kata Library Management System

## Overview
The Kata Library Management System is a Java-based application that allows users to manage books in a library. Users can add books, borrow them, and return them, while handling exceptions for book availability and borrowing status.

## Features
- Add new books to the library.
- Borrow and return books.
- View available books.
- Exception handling for book availability and borrowing status.

## Technologies Used
- Java
- JUnit (for testing)

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven (for dependency management and building)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/kata_library_management_system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd kata_library_management_system
   ```

### Running the Application
1. Compile the project:
   ```bash
   mvn compile
   ```
2. Run the main application:
   ```bash
   mvn exec:java -Dexec.mainClass="Main.Main"
   ```

### Running Tests
To run the unit tests, execute:
```bash
mvn test
```

