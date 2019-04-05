# Battleship
Completed as part of Concordia's Comp249 (advanced Object-Oriented-Programming) course in the fall of 2018.

#### Instructions: 

The purpose of this assignment is to help you practice/review arrays of objects and objet oriented design.

In this assignment, you will write a program to play a game of Battleship against the computer. Our simplified version of the game will be played on a single 8 by 8 grid. Before the actual game, each player secretly places 6 ships and 4 grenades on the grid. Ships and grenades are a single position on the grid. The position of these ships and grenades are of course hidden from the opponent. Once both players have placed their ships and grenades, the actual game starts. Each player, in turn, “shoots a rocket” on the grid (i.e. calls a position).
- If the rocket (the position called) falls on a position where there is nothing, then nothing happens, and the other player can shoot his/her rocket.
- If the rocket falls on a coordinate where the opponent (or the player) has a grenade, then the player loses a turn, and next time, the opponent will play twice in a row.
- If the rocket falls on a coordinate where the opponent (or the player...) has a ship, then that ship sinks.
- If the rocket falls on a coordinate that has been called before, regardless of what was there before, nothing
happens. (So for example, a grenade can only explode once).

The goal of the game is to sink all of your opponent’s ships before your opponent sinks yours.

For the sake of simplicity, you can assume that ships and grenades cannot overlap. So you cannot have 2 grenades on the same position, have 2 ships on the same position, or have a grenade on a ship.

The game goes on until one player has all his/her ships sunk and he/she looses the game.
Your program must simulate a game of battleship between a human user (H) and a computer (C). 

