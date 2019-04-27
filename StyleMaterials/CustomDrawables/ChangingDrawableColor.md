## Changing Drawable Color
Using one set of drawables is enough, then set different colors
```
int checkColor = context.getResources().getColor(R.color.theme_red);
viewHolder.icon.setColorFilter(selectPosition==position? checkColor :Color.TRANSPARENT, PorterDuff.Mode.SRC_ATOP);
```

```
<selector></selector>
```
