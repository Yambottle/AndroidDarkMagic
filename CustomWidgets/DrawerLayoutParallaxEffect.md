# DrawerLayoutParallaxEffect
//Using ViewHelper
```
 DrawerLayout.DrawerListener listen = new DrawerLayout.DrawerListener() {

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            View mContent = mDrawerLayout.getChildAt(0);
            View mMenu = drawerView;
            float scale = 1 - slideOffset;
            ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
            ViewHelper.setTranslationX(mContent,
                    mMenu.getMeasuredWidth() * (1 - scale));
            ViewHelper.setPivotX(mContent, 0);
            ViewHelper.setPivotY(mContent, mContent.getMeasuredHeight() / 2);
            mContent.invalidate();
        }

        @Override
        public void onDrawerOpened(View drawerView) {
           
        }

        @Override
        public void onDrawerClosed(View drawerView) {
           
        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
```
