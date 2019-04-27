# Dragging and Clicking
```
//Compare XY between MotionEvent DOWN and UP
slideMenuLayout.setOnTouchListener((v, event) -> {
            if(event.getAction()==MotionEvent.ACTION_DOWN){
                touchX = event.getX();
                touchY = event.getY();
            }
            if(event.getAction()==MotionEvent.ACTION_UP){
                if(touchX==event.getX()&&touchY==event.getY()&&event.getX() > getResources().getDimensionPixelSize(R.dimen._269sdp)){
                    slideMenuLayout.closeLeftSlide();
                }
            }
            return false;
        });
```
