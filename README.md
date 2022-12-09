# Adventure Guy
Game created by David, Ian, John, Thomas, Jaemi, Henry, Jillian
![Adventure Guy Image](https://github.com/CSC207-2022F-UofT/course-project-rogue/blob/main/pictures/Menu%20Sample.PNG?raw=true)
# Lore
You are a novice adventurer who has accidentally fell into a maze, your knowledge tells you that this maze is rumored to be ferocious and unforgiving to even the most reputed adventurer. It has been said that only by finding artifacts, the maze will reveal the exit to the surface. Otherwise, the poor souls who have entered the maze will be trapped eternally....
# Running
1. Clone Project, run with Java 16 as SDK
2. Run Game in src/main/java/driver

# Basic Flow of the Game
Player has to explore the maze, obtain at least 5 artifacts and find the exit to win. 
In the maze, the player will encounter monsters, so they will have to fight their way out and find better weapons and armors.
They will be able to Heal and Upgrade, after encountering an Event or winning a fight.

So try to stay alive, collect the artifact and escape the maze!

# Features
* A pre-generated Map
* Monsters Player can encounter to fight with
* Equipments player can use to increase survivability
* Player stats are saved upon completing a level, so don't worry about losing your equipment!

# UI
* Artifact: The winning condition for the player, you need at least 5 to Win
* Essence: The currency to heal player and upgrade equipments
* HP: Health Point, you die if it reaches 0
* Attack Point: How much Damage you will deal to the monster
* Map: Where the player will walk around and play in


# Basic Controls
* [W] Move Up
* [A] Move Left
* [S] Move Down
* [D] Move Right
* [H] Heal
* [U] Upgrade
* [F] Fight
* [R] Flee
* [C] Continue

# Design Patterns used
* Observer Patter for use cases requiring user input
  * Use case interactors for moving the player, fighting a monster, healing and upgrading equipment are all observer classes that observe another class receiving user input
  * Facade Design Pattern used in ActionManager and MoveManager to manage these use cases.
  * * Facade Design Pattern used in ActionManager and MoveManager to manage these use cases.
* Facade Design Pattern is used in Player
  * Where CollectibleInventory takes care of the Inventory
  * EquipmentSlot takes care of the equipment for the Player.
  * The State records what actions the player can take.
  * Method delegation is also used. (We choose to make player a relatively big class compared to having everyone needing to make a train of method calls)
* Event is using Strategy Design Pattern (Where map is holding an Array of Events, the player will trigger Events differently depending on which Event type it is)
* Items are using the composite design patter as it branches out to **Collectibles** and **Equipments** and **Equipments** branches out to **Armor** and **Weapons**
* State pattern used for monster fights
  * Different states of a fight: in a fight, running away, after a fight, and game over.
  * The state of a Fight class determines how the fight occurs
* GameFileWriter uses Observer Design Pattern to inform PlayerFactory and GameFileReader(through interfaces to lower coupling)
  * PlayerFactory is informed to destroy the player instance it has been storing when the player wins a game or dies to be able to create a new player instance.
  * GameFileReader is informed to change its reading directory to the directory of the file GameFileWriter writes to. This only happens when a player wins(escaped a level).

# Clean Architecture used
* We follow MVC structure.
* View interacts with Controller, Controller interacts with usecases(move manager and action manager implement the Input Boundary) through Input boundary.
* Use cases control visual(presenter) through view interface and visual controls view through output boundary interface.
* Gateway classes and use case class are the only classes that access entity.
* Input Boundary, GameFileReaderInterface, GameFileWriterInterface, Output Boundary, ViewInterface all follow Interface Segregation Principle.
* Open/Closed Principle with Item: Item allows extension because it allows different types of items to be created without having to modify the Item class. If new types of item want to be created, they can just extend the Item class. This is seen with the Collectible class and the Equipment class.
* Open closed principle for Players, Monsters and Powers
* Liskov Substitution Principle with Item and its subclasses (Collectible, Equipment, Armor, and Weapon): Each subclass can substitute an Item object. The methods in Item are all appropriate for the subclasses and can be used by the subclasses.
* Open/Closed Principle with ActionManager, as it allow easy addition of new Observers, and have a stable definition. Liskov substitution principle with MoveManager since this class is only for containing some setup methods.

# Test Coverage
![img.png](pictures/img.png)
* **Player**
  * All Methods and Possibilities are tested.
* **State**
  * All Methods and Possibilities are tested.
* **Inventory**
  * **Basic Inventory** Cannot be tested because it is abstract
  * **Collectible Inventory** All Methods and Possibility are tested
* **Basic Equipment Slots**
  * All Methods and Possibilities are tested.
* **Events**
  * **Event** cannot be tested because Event is abstract.
  * **Random Event** cannot be tested because it depends on random number generation.
  * **Essence Event**  Tested only enter(), because trigger will only have a visual display
  * **Artifact Event**  Tested only enter(), because trigger will only have a visual display
  * **Fight Event** Tested only enter(), as trigger calls a method in the output boundary
  * **WinEvent**  Tested only enter(), because trigger will only have a visual display and no other changes made.
  * **WallEvent** Only test enter(), because triggering the event will not result in anything (and the player isn't supposed to trigger them in the first place).
  * **No Event** Tested only enter(), because trigger will only have a visual display and no other changes made.
* **Moving**
  * **Map** All Methods and Possibilities are tested.
  * **Mover** All Methods and Possibilities are tested.
  * **MoveManager** All Methods and Possibilities are tested.
* **Items**
  * **Collectible** All Methods and Possibilities are tested.
  * **Armor** All Methods and Possibilities are tested.
  * **Weapon** All Methods and Possibilities are tested.
* **Monsters and Monster Fights**
* All tests passed.
  * **Monster** 100% method and line coverage
  * **Monster Power Class (Steal, Smile, ExtraDrops):** 100% method and line coverage
  * **Calculators (Win and damage)** 100% method and class coverage
  * **FightSummary** 100% method and line coverage
  * **ResultFormatter** 100% method and line coverage
  * **DropRetriever** 50% method and 33% line coverage (cannot test method that determines equipment drops as it is random)
  * **FightState classes (Fighter, Runner, AfterFight)** 100% method and class coverage. Test check that the classes correctly alter Player class, but does not check output boundary methods
  * Note: Fight class cannot be tested on its own as its behavior is determined by one of the FightState classes
  * Note: Restarter class cannot be tested as its only method makes a call to an output boundary method
* **Factory Classes**
  * **Monster Factory** 100% class coverage, all tests pass
  * **Equipment Factory** 100% class coverage, all tests pass
  * **Player Factory** Test file reader to search for data of a specific player with the requested key to value combination and return relevant data to create the requested player.
  
