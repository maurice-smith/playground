# Pager

This is a working example of how to use the [Android Jetpack Paging Library](https://developer.android.com/topic/libraries/architecture/paging/).

In this example, we use our SQLite database (using [Room](https://developer.android.com/topic/libraries/architecture/room)) as our single source of turth. Once we run out of items to show, the API is called to load more items, providing a smoother scrolling experience for the user. 
