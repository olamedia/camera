package ru.olamedia.camera;

import javax.media.opengl.fixedfunc.GLMatrixFunc;

import com.jogamp.opengl.util.PMVMatrix;

/**
 * FOV/Aspect/zNear/zFar definition of frustum
 * 
 * @author olamedia
 * 
 */
public class Frustum4f {
	private float fov = 90f;
	private float aspect = 1f;
	private float zNear = 0.1f;
	private float zFar = 500f;
	private boolean isDirty = true;

	public boolean setUpProjection(PMVMatrix pmv) {
		if (isDirty()) {
			pmv.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
			pmv.glLoadIdentity();
			pmv.gluPerspective(fov, aspect, zNear, zFar);
			setDirty(false);
			return true;
		}
		return false;
	}

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		if (fov != this.fov) {
			this.fov = fov;
			setDirty(true);
		}
	}

	public float getAspect() {
		return aspect;
	}

	public void setAspect(float aspect) {
		if (aspect != this.aspect) {
			this.aspect = aspect;
			setDirty(true);
		}
	}

	public float getzNear() {
		return zNear;
	}

	public void setzNear(float zNear) {
		if (zNear != this.zNear) {
			this.zNear = zNear;
			setDirty(true);
		}
	}

	public float getzFar() {
		return zFar;
	}

	public void setzFar(float zFar) {
		if (zFar != this.zFar) {
			this.zFar = zFar;
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
