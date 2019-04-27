## 1. Hide status bar
```
View decorView = getWindow().getDecorView();
int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
decorView.setSystemUiVisibility(option);
ActionBar actionBar = getSupportActionBar();
actionBar.hide();
```
## 2. Transparent status bar and without spending layout space
```
if (Build.VERSION.SDK_INT >= 21) {
    View decorView = getWindow().getDecorView();
    int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    decorView.setSystemUiVisibility(option);
    getWindow().setStatusBarColor(Color.TRANSPARENT);
}
```
## 3. Hide both, pop while clicking(For watching movie)
```
View decorView = getWindow().getDecorView();
int option = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_FULLSCREEN;
decorView.setSystemUiVisibility(option);
ActionBar actionBar = getSupportActionBar();
actionBar.hide();
```
## 4. Both and without spending layout space(Potential touch action conflict at bottom)
```
if (Build.VERSION.SDK_INT >= 21) {
    View decorView = getWindow().getDecorView();
    int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
    decorView.setSystemUiVisibility(option);
    getWindow().setNavigationBarColor(Color.TRANSPARENT);
    getWindow().setStatusBarColor(Color.TRANSPARENT);
}
ActionBar actionBar = getSupportActionBar();
actionBar.hide();
```
## 5. Immersive Mode: Status and navigation bar will show when dragging from bottom or top
```
if (hasFocus && Build.VERSION.SDK_INT >= 19) {
View decorView = getWindow().getDecorView();
decorView.setSystemUiVisibility(
     View.SYSTEM_UI_FLAG_LAYOUT_STABLE
       | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
       | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
       | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
       | View.SYSTEM_UI_FLAG_FULLSCREEN
       | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
}
```
# Reference from: https://blog.csdn.net/guolin_blog/article/details/51763825
