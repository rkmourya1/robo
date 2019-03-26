
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
Example test data is provided in a section below.
<br>
### Constraints:
The toy robot will not fall off the table during movement. This also includes the initial placement
of the toy robot. Any move that would cause the robot to fall will be ignored.
