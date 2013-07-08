package ru.olamedia.camera;

public class Euler3f {
	private float yaw = 0; // left/right
	private float pitch = 0; // down/up
	private float roll = 0;
	private boolean isDirty = true;

	public float getYaw() {
		return yaw;
	}

	public void setYaw(float yaw) {
		if (yaw != this.yaw) {
			this.yaw = yaw % 360;
			setDirty(true);
		}
	}

	public float getPitch() {
		return pitch;
	}

	public void setPitch(float pitch) {
		if (pitch != this.pitch) {
			this.pitch = pitch % 360;
			setDirty(true);
		}
	}

	public float getRoll() {
		return roll;
	}

	public void setRoll(float roll) {
		if (roll != this.roll) {
			this.roll = roll % 360;
			setDirty(true);
		}
	}

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
}
