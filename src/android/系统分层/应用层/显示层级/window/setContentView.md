可以看出，Window作为Activity和DecorView的联结者。
```
View  decorView = ((Activity) context).getWindow().getDecorView();
View content=((ViewGroup)decorView).findViewById(android.R.id.content);
```
