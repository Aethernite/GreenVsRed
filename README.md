# GreenVsRed


![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

# Assignment
GreenVsRed is a game played on a 2D grid that in theory can be infinite.
Each cell on this grid can be either green (**represented by 1**) or red (**represented by 0**).
The game always receives an initial state of the grid which we call '**Generation ZERO**'.
After that a set of 4 rules are applied across the grid and those rules form the next generation.
- Each red cell that is surrounded by exactly 3 or exactly 6 green cells will also become green in next generation
- A red cell will stay red in the next generation if it has either 0,1,2,4,5,7 or 8 green neighbours.
- Each green cell surrounded by 0,1,4,5,7 or 8 green neighbours will become red in the next generation.
- A green cell will stay green in the next generation if it has either 2,3 or 6 green neighbours.

# Facts
 - Each cell is surrounded by 8 neighbour cells. Four on the sides and four on the corners. Exceptions are the corners and the sides of the grid.
 - All of the four rules apply at the same time for the whole grid in order for the next generations to be formed.

# Your Task
Create a program that accepts the size of our grid - **x**, **y** (**x** - width, **y** - height)
The next **y** lines should contain strings (long **x** characters) created by 0s and 1s which will represent the '**Generation Zero**' state and help us build the grid.
The last arguments to the program should be coordinates (x1 and y1) and the number N.

The coordinates will be of a cell in the grid. We would like you to calculate in how many generations from '**Generation Zero**' to '**Generation N**' this cell was green.
# Constraints
**x <= y < 1000**
# Output
Print the result in the console




# Inputs

```sh
3, 3
000
111
000
1, 0, 10
Expected Result: 5
```
```sh
4, 4
1001
1111
0100
1010
2, 2, 15
Expected Result: 14
```
