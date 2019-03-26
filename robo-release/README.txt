Robot Movement
================

This application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.
There are no other obstructions on the table surface. 
The robot is free to roam around the surface of the table, but it is prevented from falling to destruction. 
Any movement that would result in the robot falling from the table will be ignored, 
however further valid movement commands are still allowed. 

This application can read in commands of the following form - 

 PLACE X,Y,F
 MOVE
 LEFT
 RIGHT
 REPORT
 EXIT


Command details are described at: https://github.com/rkmourya1/robo


Source amd more details:
========================

The source code and more detail is available at: https://github.com/rkmourya1/robo


Install and run:
=================

You get a pre build robo.zip or build it from source using instruction at https://github.com/rkmourya1/robo.

Running from robo.zip:
----------------------

1. Get the robo.zip or robo.tar and exract it in a system folder, where Java 1.8 or above is installed.
2. cd to extracted folder <INSTALL_DIR>/robo/bin
3. run: robo
4. Play with issuing commnads as described at https://github.com/rkmourya1/robo and shown in example below:

Example run:
------------

D:\workspace\robo\build\install\robo\bin>robo
Welcome to play with MyRobo. Please enter commands to play with it.
Enter Command 'PLACE <0-5>,<0-5>,EAST|NORTH|WEST|SOUTH', to place the robo on th
e square table between points (0,0) and (5,5) with face direction.
Then enter command LEFT|RIGHT|REPORT, to play with robo.
Then enter command REPORT, reports location of robo on table and face direction,
 if placed in table
Enter command EXIT, to exit the game.

Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
PLACE 2,2,EAST
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
REPORT
Output: 2,2,EAST
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
MOVE
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
REPORT
Output: 3,2,EAST
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
LEFT
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
REPORT
Output: 3,2,NORTH
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
MOVE
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
REPORT
Output: 3,3,NORTH
Enter command [PLACE X,Y,F|MOVE|LEFT|RIGHT|REPORT|EXIT]:
EXIT
Thank you for playing with Robo. Exiting now, bye!
D:\workspace\robo\build\install\robo\bin>




