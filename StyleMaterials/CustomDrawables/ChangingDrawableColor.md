## Changing Drawable Color
```
int checkColor = context.getResources().getColor(R.color.theme_red);
viewHolder.icon.setColorFilter(selectPosition==position? checkColor :Color.TRANSPARENT, PorterDuff.Mode.SRC_ATOP);
```
