package de.exterm.android;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MyGLSurfaceActivity extends Activity {
    private GLSurfaceView mGLView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		// super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		super.onCreate(savedInstanceState);
		mGLView = new GLSurfaceView(this);
		mGLView.setEGLConfigChooser(false);
		SpriteRenderer renderer = new SpriteRenderer(this);
		renderer.appendSprite("su", new Sprite(0, 0, 0, 1));
		renderer.appendSprite("run", new Sprite(1, 0, 0, 0.8f));
		mGLView.setRenderer(renderer);
		setContentView(mGLView);
    }
    

    @Override
    protected void onPause() {
        super.onPause();
        mGLView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLView.onResume();
    }
}