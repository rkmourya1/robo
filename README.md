
# Robot Movement
## Description:

This application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5
units.There are no other obstructions on the table surface.
<br>
The robot is free to roam around the surface of the table, but it is prevented from falling to
destruction. Any movement that would result in the robot falling from the table will be ignored,
however further valid movement commands are still allowed.
<br><br>
Create an application that can read in commands of the following form - <br>
<pre>
 PLACE X,Y,F
 MOVE
 LEFT
 RIGHT
 REPORT
 EXIT
</pre>
Where PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or
WEST. The origin (0,0) is considered to be the SOUTH WEST most corner.
<br>
It is required that the first command to the robot is a PLACE command, after that, any sequence of
commands may be issued, in any order, including another PLACE command. The application will
discard all commands in the sequence until a valid PLACE command has been executed.
<br>
Where MOVE will move the toy robot one unit forward in the direction it is currently facing.
<br>
Where LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing
the position of the robot.
<br>
Where REPORT will announce the X,Y and F of the robot. This can be in any form, but standard
output is sufficient.
<br>
EXIT command will end the program and will not accept any other subsequent command.
A robot that is not on the table will choose to ignore the MOVE, LEFT, RIGHT and REPORT
commands.
<br><br>
Input should from standard input.
<br>
Example test data is provided in a section below.
<br>
### Constraints:
The toy robot will not fall off the table during movement. This also includes the initial placement
of the toy robot. Any move that would cause the robot to fall will be ignored.

## Build Application

Clone this repo or download a zip and extract to your system, where Java JDK 1.8 is installed.
Goto to cloned/extracted project folder "robo", will refer it as <ROBO_PROJECT_HOME>
<br>
Run following gradle command to build from project home folder:
<pre>
# for windows:
gradlew clean build installDist
# for Linux
./gradlew clean build installDist
</pre>

## View Test, Coda Analisis, Code Coverage reports
Above will build the project and create a distrbutable and install it. Also it will run unit test and code analysis tools (findbug, pmd), code coverage tool (Jacoco).
The detail test, code analysis and code coverage report will be generated in <ROBO_PROJECT_HOME>/build/reports folder.

## Run Robo Applicatiom

Option 1: The above build step have created the application distributable at <ROBO_PROJECT_HOME>/build/distributions. Take the tar or zip and extract in a folder on a system with Java 1.8 installed
<br><
Option 2: Above build has installed it at <ROBO_PROJECT_HOME>/build/install folder.
<br><br>
By either of the option, you will have "robo" folder installed and have bin and lib folder inside it
<br>
Goto installed loaction e.g: <ROBO_PROJECT_HOME>/build/install/robo and cd inside bin folder and run and play with Robo as example below:
<pre>
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
</pre
