package io.github.mthli.Ninja.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import io.github.mthli.Ninja.Browser.AlbumController;
import io.github.mthli.Ninja.Browser.BrowserController;
import io.github.mthli.Ninja.R;

public class NinjaRelativeLayout extends RelativeLayout implements AlbumController {
    private Context context;
    private Album album;
    private int flag = 0;

    private BrowserController browserController;
    public void setBrowserController(BrowserController browserController) {
        this.browserController = browserController;
        this.album.setBrowserController(browserController);
    }

    public NinjaRelativeLayout(Context context) {
        this(context, null);
    }

    public NinjaRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NinjaRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        this.album = new Album(context, this, this.browserController);
        initUI();
    }

    private void initUI() {
        album.setAlbumCover(null);
        album.setAlbumTitle(context.getString(R.string.album_untitled));
        album.setBrowserController(browserController);
    }

    @Override
    public int getFlag() {
        return flag;
    }

    @Override
    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public View getAlbumView() {
        return album.getAlbumView();
    }

    @Override
    public void setAlbumCover(Bitmap bitmap) {
        album.setAlbumCover(bitmap);
    }

    @Override
    public void setAlbumTitle(String title) {
        album.setAlbumTitle(title);
    }

    @Override
    public void activate() {
        album.activate();
    }

    @Override
    public void deactivate() {
        album.deactivate();
    }
}