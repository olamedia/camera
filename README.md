JOGL Camera
=======

```java
Camera camera = new Camera();

final Orientation orientation = camera.getOrientation();
final Euler3f euler = orientation.getEuler();
final Position3f position = orientation.getPosition();
euler.setYaw(30);
euler.setPitch(10);
euler.setRoll(5);
position.setX(0);
position.setY(1);
position.setZ(4);
// draw, FFP:
camera.pack();
camera.setUpMatrices();

// draw, shader
camera.pack();
final GLUniformData pmv = camera.getUniform(); // pass it to shader

```