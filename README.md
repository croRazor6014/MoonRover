
<p align="left">
<img src="presentation/Title.PNG" width="800" height="400" border="10"/>
</p>

## an ICE coding challenge
The purpose of this application is to guide a rover 
over a small area defined in the configuration application.properties



<p align="left">
<img src="presentation/KerbalRover.png" width="300" height="300" border="10"/>
</p>

## REST API
 To facilitate this there are 4 main API calls:

<p align="left">
<img src="presentation/methods.PNG" width="800" height="400" border="10"/>
</p>

## CONCEPT

    The tabletop is defined as an 2D array of tabletop objects of 
    wich the rover is the extended class and the tabletop has
    x and y dimensions begining from 0,0 coordinates

<p align="left">
<img src="presentation/coordinateSystem.PNG" width="400" height="400" border="10"/>
</p>

    To handle the rover going outside the bounds of the tabletop
    there exist two possible  concepts to handle that case.
    In the first instance we could determine that the new coordinates are outside
    the dimensions of the tabletop and throw an error.

<p align="left">
<img src="presentation/ballFallOff.PNG" width="200" height="200" border="10"/>
</p>

    In the second instance we might bound the movement so that the rover simply 
    stays in place as if the rover where pushing into a wall where it is not able to 
    move forward. We might describe that concept as if the rover and the tabletop where 
    in a box.

<p align="left">
<img src="presentation/ballCaptured.PNG" width="200" height="200" border="10"/>
</p>

