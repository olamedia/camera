package ru.olamedia.camera;

import javax.media.opengl.fixedfunc.GLMatrixFunc;

import com.jogamp.opengl.util.PMVMatrix;

public class Orientation {
	private final Euler3f euler = new Euler3f();
	private final Position3f position = new Position3f();

	public boolean setUpModelView(PMVMatrix pmv) {
		if (euler.isDirty() || position.isDirty()) {
			pmv.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
			pmv.glLoadIdentity();
			pmv.glRotatef(-euler.getPitch(), 1, 0, 0);
			pmv.glRotatef(-euler.getYaw(), 0, 1, 0);
			pmv.glRotatef(-euler.getRoll(), 0, 0, 1);
			pmv.glTranslatef(-position.getX(), -position.getY(), -position.getZ());
			pmv.update();
			euler.setDirty(false);
			position.setDirty(false);
			return true;
		}
		return false;
	}

	public Euler3f getEuler() {
		return euler;
	}

	public Position3f getPosition() {
		return position;
	}

}
