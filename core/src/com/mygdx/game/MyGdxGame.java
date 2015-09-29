package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
    SpriteBatch batch;
    /**
     * We use this to make the background look a bit nicer than a flat colour
     */
    TextureRegion sky;
    /**
     * Use clouds if you want
     */
    TextureRegion cloud;
    /**
     * Images are all stored in a single texture atlas
     */
    private TextureAtlas atlas;
    /**
     * Animations are used to control what frame is shown when. Use getKeyFrame()
     */
    private Animation beeAnimation;
    private Animation waspAnimation;

    /**
     * Text in OpenGL is hard work. Don't worry about trying to make text look pretty
     * with the default font, you wont succeed.
     */
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        atlas = new TextureAtlas(Gdx.files.internal("atlas.txt"));
        sky = atlas.findRegion("sky");
        cloud = atlas.findRegion("cloud");

        beeAnimation = new Animation(0.03f,
                atlas.findRegion("bee-1"),
                atlas.findRegion("bee-2"),
                atlas.findRegion("bee-3"));
        beeAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        waspAnimation = new Animation(0.05f,
                atlas.findRegion("wasp-1"),
                atlas.findRegion("wasp-2"));
        waspAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        font = new BitmapFont();

        // This sets us up to receive touches etc...
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        // This is the number of seconds since the last frame
        float delta = Gdx.graphics.getDeltaTime();

        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Draw some stuff
        batch.draw(sky, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
