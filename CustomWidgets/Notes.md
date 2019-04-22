# Soft Keyboard

* EditText re-request focus:
```
searchEdit.setFocusable(true);
searchEdit.setFocusableInTouchMode(true);
searchEdit.requestFocus();
```

* Hide&Show keyboard
```
    public void hideSoftWinFromEdit() {
        try{
            InputMethodManager imManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if(imManager.isActive()){
                imManager.hideSoftInputFromWindow(searchEdit.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void popSoftWinFromEdit() {
        InputMethodManager imManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imManager.showSoftInput(searchEdit, InputMethodManager.SHOW_IMPLICIT);
    }
```

* Hide keyboard while touching non edit zone
```
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(searchEdit.getVisibility()==View.VISIBLE && event.getRawY()>300){
            searchModeOff();
            return false;
        }
        return super.dispatchTouchEvent(event);
    }
```
