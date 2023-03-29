The task:
Create a small application and design a REST API with the following prerequisites. We will ask you
also to present your solution to us to emulate a code and design review session. Think about how
you would do it in front of a small group and prepare your presentation accordingly. Think about
how you would convince other people of your approaches. Presentation is an important part of the
assignment because we look at how you articulate your thoughts. Use the tools of your choice to
present your solution.
Problem details:
• The application is a simulation of a moon rover moving on a square tabletop, of dimensions
5x5 units
• There are no other obstructions on the surface
• The rover should be able to be placed on the tabletop, it has coordinates and facing, which
shows where the rover is and in which direction the rover can move. The rover can turn on
the spot and its facing changes accordingly
• The rover is free to roam around the surface of the tabletop but must be prevented from
falling to destruction. Any movement that would result in the rover falling from the tabletop
must be prevented, however further valid movement commands must still be allowed.
Create an application with the following use cases:
• It should be possible to place the rover on the surface to the specific coordinates and facing
(e.g. 1,1,south)
• It should be possible to send a move command to the rover. The rover should move one unit
in the facing direction
• It should be possible to send a turn command to the rover, in this case, the rover should turn
to the left or the right. It’s facing should change accordingly
• It should be possible to request a report from the rover about its position on the tabletop and
its facing
• Commanding the rover should be realised via a REST API

