package ru.olamedia.camera;

public class Position3f {
	protected float x = 0;
	protected float y = 0;
	protected float z = 0;
	private boolean isDirty = true;
	protected Position3f offset = null;

	public float getX() {
		return x + (null != offset ? offset.getX() : 0);
	}

	public void setX(float x) {
		if (x != this.x) {
			this.x = x;
			setDirty(true);
		}
	}

	public float getY() {
		return y + (null != offset ? offset.getY() : 0);
	}

	public void setY(float y) {
		if (y != this.y) {
			this.y = y;
			setDirty(true);
		}
	}

	public float getZ() {
		return z + (null != offset ? offset.getZ() : 0);
	}

	public void setZ(float z) {
		if (z != this.z) {
			this.z = z;
			setDirty(true);
		}
	}

	public boolean isDirty() {
		if (null != offset && offset.isDirty()) {
			return true;
		}
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		if (null != offset) {
			offset.setDirty(true);
		}
		this.isDirty = isDirty;
	}
}
