# 1. OnTouchEvent: Dragging and clicking
```
//Compare XY between MotionEvent DOWN and UP
slideMenuLayout.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                touchX = event.getX();
                touchY = event.getY();
            }
            if(event.getAction()==MotionEvent.ACTION_UP){
                if(touchX==event.getX()&&touchY==event.getY()&&event.getX() >
                getResources().getDimensionPixelSize(R.dimen._269sdp)){
                    slideMenuLayout.closeLeftSlide();
                }
            }
            return false;
});
```
# 2. ScrollView+RecyclerView: RecyclerView not fully displayed
Especially, item contains any clickable widget
```
<RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:descendantFocusability="blocksDescendants">
            <androidx.recyclerview.widget.RecyclerView
                android:id="@+id/menu_list"
                android:layout_marginTop="@dimen/_39sdp"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@color/toolbar_bg"
                android:nestedScrollingEnabled="false">
            </androidx.recyclerview.widget.RecyclerView>
</RelativeLayout>
```
