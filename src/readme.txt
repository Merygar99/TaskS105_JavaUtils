==========================
📘 Java Console Commands
==========================

This file explains the basic commands to compile and run Java programs using the terminal or command prompt.

🔹 Prerequisites:
- Java Development Kit (JDK) installed
- JAVA_HOME environment variable configured
- Access to a terminal (Command Prompt, PowerShell, Terminal, etc.)

-----------------------------------------
🧵 1. Compile a Java Source File (.java)
-----------------------------------------

Use the following command to compile a Java source file:

    javac FileName.java

🔸 Example:
    javac Main.java

This will generate a `Main.class` file containing the bytecode in the same directory.

-----------------------------------------
▶️ 2. Run a Compiled Java File
-----------------------------------------

Once compiled, run the program using:

    java ClassName

🔸 Example:
    java Main

💡 Note:
- Do not include the `.class` extension when running
- The name must match the class that contains the `main` method

-----------------------------------------
📂 3. Compile Multiple Files at Once
-----------------------------------------

If your program includes multiple classes:

    javac *.java

This will compile all `.java` files in the folder.

-----------------------------------------
📍 Compiler Location
-----------------------------------------

If `javac` or `java` are not recognized, make sure the `bin` folder of the JDK is included in your system’s PATH environment variable.

-----------------------------------------

And that’s it! With these commands, you can compile and run Java programs without needing an IDE.