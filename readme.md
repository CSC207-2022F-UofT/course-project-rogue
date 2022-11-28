# Adventure Guy
Game created by David, Ian, John, Thomas, Jaemi, Henry, Jillian
![Adventure Guy Image](https://github.com/CSC207-2022F-UofT/course-project-rogue/blob/main/pictures/Menu%20Sample.PNG?raw=true)
# Lore
You are a novice adventurer who has accidentally fell into a maze, your knowledge tells you that this maze is rumored to be ferocious and unforgiving to even the most reputated adventurer. It has been said that only by finding artifacts, the maze will reveal the exit to the surface. Otherwise, the poor souls who has entered the maze will be trapped eternally....
# Running
1. Run Game which is located in the Game Drive

# Basic Flow of the Game
Player has to explore the maze, obtain at least 5 artifacts and find the exit to win. 
In the maze, the player will encounter monsters and they'll have to fight their way out and find better weapons and armors.
The will be able to Heal and Upgrade, after encountering an Event or winning a fight.

So try to stay alive, collect the artifact and escape the maze!

# Features
* A pre-generated Map
* Monsters Player can encounter to fight with
* Equipments player can use to increase survivability
* Saving Player progress after Player wins

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

# Design Patterns used
* Facade Design Pattern is used in Player 
  * Where CollectibleInventory takes care of the Inventory
  * EquipmentSlot takes care of the equipment for the Player.
  * The State records what actions the player can take.
  * Method delegation is also used. (We choose to make player a relatively big class compared to having everyone needing to make a train of method calls)
* Event is using Strategy Design Pattern (Where map is holding an Array of Events, the player will trigger Events differently depending on which Event type it is)


# Clean Architecture used 
* Player is Entity
* 

# Test Coverage
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
  * **Random Event** cannot be tested because it is depending on random number generator.
  * **Essence Event** is tested all methods (there's only 1 possible outcome per method).
  * **Artifact Event** Event is tested all methods (there's only 1 possible outcome per method).
  * **WinEvent**  Tested only enter(), because trigger will only have a visual display and no other changes made.
  * **WallEvent** Only test enter(), because triggering the event will not result in anything (and the player isn't supposed to trigger them in the first place).
  * **No Event** Cannot be tested because it requires player control to choose between upgrade and heal.
