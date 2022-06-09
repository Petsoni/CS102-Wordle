# **JavaFX Wordle game**

Project made for the **CS102** course at the **University of Metropolitan**.

---

## <ins>*Description*

The game is made so that the program randomly chooses a word from the database and sets it as an answer. Player is
trying to guess the chosen word by typing in his guess, and it's displayed in the grid as an individual character that
is set on the specific field. If the player guesses the *correct letter in the correct position*, the field turns
**green**. If the player guesses the *correct letter in the wrong position*, the field turns **yellow**. If the player
guesses the wrong letters, the field **won't change**.

## <ins>*Structure*

> The project is divided into parts/folders:

* **Main** - the main class of the project and the run class.
* **Utils** - contains the classes that contain many methods for better coding.
* **Connection** - contains the class that is primarily used for database connection .
* **Building classes** - contains the classes that are used to build the Wordle.
* **Controllers** - contains the classes that have all the methods for work with the database.
* **Entities** - contains all the entity classes.
* **Exceptions** - contains all the exceptions that can be thrown.
* **Alerts** - contains Alert class that can be initialized and personalized.
* **Interfaces** - contains the interfaces that are used in the project.
* **Tests** - contains the tests for all necessary classes in the project.
* **Resources** - contains all the resources that are used in the project.
