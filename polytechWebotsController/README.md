# polytechWebotsController

This is a repo used for teaching (meta)language semantics. It provides a java based API to control a cyberbotics robots (webots: https://cyberbotics.com/) based on the "create" robot (https://cyberbotics.com/doc/guide/create) augmented with:
  * a pen
  * a gripper
  * a front camera
  * a back camera

This is the basics API to define a language, its operational semantics and the associated debugger must be defined, based on the GEMOC studio (gemoc.org/studio.html).

In order to put the webots library in the classpath, one should do
`export LD_LIBRARY_PATH=/snap/webots/current/usr/share/webots/lib/controller/` in the launching terminal with the appropriate path before to launch gemoc.
