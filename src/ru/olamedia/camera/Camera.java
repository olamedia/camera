package ru.olamedia.camera;

import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLContext;
import javax.media.opengl.GLUniformData;
import javax.media.opengl.fixedfunc.GLMatrixFunc;
import javax.vecmath.Vector3f;

import com.jogamp.opengl.util.PMVMatrix;

public class Camera {
	private final PMVMatrix pmv = new PMVMatrix(true);
	private final GLUniformData pmvUniform = new GLUniformData("mgl_PMVMatrix", 4, 4, pmv.glGetPMvMatrixf());
	private final FloatBuffer mv = pmv.glGetMvMatrixf();
	private final int mvOffset = mv.position();

	private final Orientation orientation = new Orientation();

	private final Frustum4f frustum = new Frustum4f();

	private final Vector3f forward = new Vector3f();
	private final Vector3f back = new Vector3f();
	private final Vector3f left = new Vector3f();
	private final Vector3f right = new Vector3f();
	private final Vector3f up = new Vector3f();
	private final Vector3f down = new Vector3f();

	private void packVectors() {
		right.set(mv.get(mvOffset + 0), mv.get(mvOffset + 4), mv.get(mvOffset + 8));
		left.set(right);
		left.negate();
		back.set(mv.get(mvOffset + 2), mv.get(mvOffset + 6), mv.get(mvOffset + 10));
		forward.set(back);
		forward.negate();
		// look.negate();
		up.cross(back, right);
		down.set(up);
		down.negate();
	}

	// rebuild matrices if something changed
	public void pack() {
		if (frustum.setUpProjection(pmv) || orientation.setUpModelView(pmv)) {
			pmv.glGetFrustum();
			pmv.update();
			packVectors();
		}
	}

	// For use with Fixed Function Pipeline
	public void setUpMatrices() {
		final GL gl = GLContext.getCurrentGL();
		if (gl.isGL2()) {
			// FFP
			final GL2 gl2 = gl.getGL2();
			gl2.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
			gl2.glLoadMatrixf(pmv.glGetPMatrixf());
			gl2.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
			gl2.glLoadMatrixf(pmv.glGetMvMatrixf());
		} else if (gl.isGLES2()) {
			// shader
		}
	}

	// For use with shaders
	public GLUniformData getUniform() {
		return pmvUniform;
	}

	// Modify orientation
	// Attach to objects via getOrientation().getPosition.setOffset()
	public Orientation getOrientation() {
		return orientation;
	}

	// Modify frustum parameters
	public Frustum4f getFrustum() {
		return frustum;
	}

	public Vector3f getForward() {
		return forward;
	}

	public Vector3f getBack() {
		return back;
	}

	public Vector3f getRight() {
		return right;
	}

	public Vector3f getUp() {
		return up;
	}

	public Vector3f getLeft() {
		return left;
	}

	public Vector3f getDown() {
		return down;
	}

}
