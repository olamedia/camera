package ru.olamedia.camera;

import javax.vecmath.Vector3f;

public class VectorOffset extends Position3f {
	private Vector3f direction;

	@Override
	public float getX() {
		return x * direction.x + (null != offset ? offset.getX() : 0);
	}

	@Override
	public float getY() {
		return y * direction.y + (null != offset ? offset.getY() : 0);
	}

	@Override
	public float getZ() {
		return z * direction.z + (null != offset ? offset.getZ() : 0);
	}

	public Vector3f getDirection() {
		return direction;
	}

	public void setDirection(Vector3f direction) {
		this.direction = direction;
	}
}
